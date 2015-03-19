package net.wonderslife.indexer.fullexpense;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import net.wonderslife.util.PropertyUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.LogByteSizeMergePolicy;
import org.apache.lucene.index.LogMergePolicy;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

public class FullExpenseIndexMerge {
	// 连接两个或多个索引
	public final static String INDEX_DIR = "/indexers";
	public final static String MERGE_DIR = "/merge";
	public final static String LOG_DIR = "/logs";
	public final static String DATA_DIR = "/data";
	public final static String SOLR_DIR = "/solr";

	private static void mergeIndex(File from, File to, StandardAnalyzer sa)
			throws IOException {
		long begin = System.currentTimeMillis();
		IndexWriter iw = null;

		System.out.println("Index merging, from " + from + " to " + to);

		Directory toD = FSDirectory.open(to);
		IndexWriterConfig iwc = new IndexWriterConfig(Version.LUCENE_47, sa);
		iwc.setOpenMode(OpenMode.CREATE_OR_APPEND); // 创建和添加索引

		LogMergePolicy mp = new LogByteSizeMergePolicy();
		mp.setMergeFactor(Integer.MAX_VALUE); // 提高批量速度
		mp.setMaxMergeDocs(Integer.MAX_VALUE);
		iwc.setMergePolicy(mp);

		iw = new IndexWriter(toD, iwc);
		Directory fromD = FSDirectory.open(from);
		iw.addIndexes(fromD);
		iw.commit();
		iw.close();
		System.out.println("Index merged.");
		long end = System.currentTimeMillis();
		System.out.println("merge spent:" + (end - begin) / 1000 + "s");

	}

	public static void main(String[] args) {
		// 获取workspace
		String workspace = "";
		String core = "";
		boolean condition = true;
		int rowCount = 0;
		int pageSize = 0;
		Logger log = Logger.getLogger(FullExpenseIndexMerge.class);
		int sleep = 0;
		String logdir = "";
		int totalPages = 0;
		try {
			sleep = Integer.parseInt(PropertyUtil.get("solr.distribute.sleep"));
			workspace = PropertyUtil.get("solr.distribute.index.workspace");
			logdir = workspace + LOG_DIR;
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.rowcount"));
			pageSize = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.pagesize"));
			totalPages = rowCount / pageSize;
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 循环条件
		while (condition) {
			log.info(">>>>>>>>>> begin merge >>>>>>>>>workspace:"+workspace);

			try {
				// 睡眠等待
				Thread.sleep(sleep);

				// 判断最大的log文件名是多少
				File lastLog = new File(logdir + "/" + totalPages + ".log");
				if (lastLog.exists()) {
					// 如果当前文件中有最大的日志文件，则处理完后结束此进程
					// 索引进程已经正常执行完毕
					Collection<File> files = FileUtils.listFiles(new File(
							logdir), new String[] { "log" }, false);
					// 判断每个file，如果file执行完成则合并并且删除
					decideMerge(files, workspace);
					condition = false;
					break;
				}
				Process p = Runtime.getRuntime()
						.exec(workspace + "/process.sh");
				String output = FullExpenseUtil.inputStream2String(p
						.getInputStream());
				int n = StringUtils.countMatches(output.toLowerCase(),
						"solr-indexer.jar");
				if (n <= 0) {
					// 如果没有solr-indexer进程，则在处理完当前的索引数据后
					// 查找当前未处理的索引数据
					// 退出进程
					Collection<File> files = FileUtils.listFiles(new File(
							logdir), new String[] { "log" }, false);
					// 判断每个file，如果file执行完成则合并并且删除
					decideMerge(files, workspace);
					condition = false;
					break;
				}
				if (n > 0) {
					// 则还有索引进程没有完成
					// 查找当前未处理的索引数据
					Collection<File> files = FileUtils.listFiles(new File(
							logdir), new String[] { "log" }, false);
					// 判断每个file，如果file执行完成则合并并且删除
					decideMerge(files, workspace);
				}

				// 读取当前剩余的logs目录下的*.log文件
				// 如果最大的log文件已经产生，并且执行结束，就可以退出
				// 根据log文件读取，如果产生了log文件，并其中最后一行是成功结束，则合并
				// 合并后删除log文件和indexer中的对应jar
				// 
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//			String fromdir = PropertyUtil
		//					.get("solr.fullexpense.embedded.merge.fromdir");
		//			String todir = PropertyUtil
		//					.get("solr.fullexpense.embedded.merge.todir");
		//			int count = Integer.parseInt(PropertyUtil
		//					.get("solr.fullexpense.embedded.merge.threadcount"));
		//			File to = new File(todir);
		//			for (int i = 1; i <= count; i++) {
		//				File from = new File(fromdir + "/index" + i + "/data/index");
		//				FullExpenseIndexMerge.mergeIndex(from, to,
		//						new StandardAnalyzer(Version.LUCENE_47));

	}

	// 判断并决定是否合并
	private static void decideMerge(Collection<File> files, String workspace) {
		// 循环判断每个日志
		Iterator<File> it = files.iterator();
		while (it.hasNext()) {
			File file = it.next();
			try {
				// 获取索引编号
				int fileno = Integer.parseInt(file.getName()
						.replace(".log", ""));
				List<String> content = FileUtils.readLines(file);
				String last = content.get(content.size() - 1);
				if (last.contains(">>>>>>>>>>>>>Total:")) {
					// 已经执行完，合并目录到目标目录，合并完成删除源目录的jar文件和改名log文件为.done
					String from = workspace + INDEX_DIR + "/indexer" + fileno
							+ "/solr/collection1/data/index";
					String to = workspace + MERGE_DIR;
					mergeIndex(new File(from), new File(to),
							new StandardAnalyzer(Version.LUCENE_47));
					// 节省空间，删除jar
					FileUtils.deleteQuietly(new File(workspace + INDEX_DIR
							+ "/indexer" + fileno + "/solr-indexer.jar"));
					// 
					FileUtils.moveFile(new File(workspace + LOG_DIR + "/"
							+ fileno + ".log"), new File(workspace + LOG_DIR
							+ "/" + fileno + ".done"));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
