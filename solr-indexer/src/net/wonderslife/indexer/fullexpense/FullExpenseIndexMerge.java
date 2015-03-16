package net.wonderslife.indexer.fullexpense;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

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
		Logger log = null;
		String workspace = "";
		String core = "";

		int rowCount = 0;
		int pageSize = 0;
		try {
			workspace = PropertyUtil.get("solr.distribute.index.workspace");
			String logdir = workspace + "/logs";
			log = Logger.getLogger(FullExpenseIndexMerge.class);
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.rowcount"));
			pageSize = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.pagesize"));
			int totalPages = rowCount / pageSize;
			// 判断最大的log文件名是多少
			File lastLog = new File(logdir + "/" + totalPages + ".log");
			if (lastLog.exists()) {
				// 如果当前文件中有最大的日志文件，则处理完后结束此进程
				// 索引进程已经正常执行完毕
			}
			Process p = Runtime.getRuntime().exec(workspace + "/process.sh");
			String output = FullExpenseUtil.inputStream2String(p
					.getInputStream());
			int n = StringUtils.countMatches(output.toLowerCase(),
					"solr-indexer.jar");
			if (n <= 0) {
				// 如果没有solr-indexer进程，则在处理完当前的索引数据后
				// 查找当前未处理的索引数据
				// 退出进程
				Collection<File> files = FileUtils.listFiles(new File(logdir),
						new String[] { "log" }, false);
				// 判断每个file，如果file执行完成则合并并且删除
			}
			if (n > 0) {
				// 则还有索引进程没有完成
				// 查找当前未处理的索引数据
			}

			// 读取当前剩余的logs目录下的*.log文件
			// 如果最大的log文件已经产生，并且执行结束，就可以退出
			// 根据log文件读取，如果产生了log文件，并其中最后一行是成功结束，则合并
			// 合并后删除log文件和indexer中的对应jar
			// 
		} catch (IOException e) {
			e.printStackTrace();
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
}
