package net.wonderslife.indexer.fullexpense;

/**
 * solr-distribute.jar
 */
import java.io.File;
import java.io.IOException;
import java.util.Collection;

import net.wonderslife.util.PropertyUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class FullExpenseIndexer {
	public static final String INDEX_DIR = "/indexers";

	/**
	 * 并行最大程度调度执行索引 
	 * 1.这是一个统一的调度进程，负责调度所有的数据索引进程 
	 * 2.调度算法如下：
	 * 配置文件中设置总记录数，设置分块行数大小，以及启动进程数，
	 * 及workspace目录 此程序负责启动进程，使用命令行的方式而不采用多线程机制
	 * 通过观察每个日志文件和操作系统进程名，判断执行结果，
	 * 每一分钟判断一次 当所有记录都执行完成此进程退出，或 当调度进程连续3次失败时，退出，记录日志
	 * 目录结构: ----workspace dir 
	 * 								|___ indexers 开始的进程 
	 * 										|____ indexer1 
	 * 										|____ indexer..n 
	 * 								|___ merge 合并进程 
	 * 								|___ logs 所有日志 
	 * 										|____ 1.log 索引进程 
	 * 										|____ n.log 
	 * 										|____ indexer.log 调度进程 
	 * 										|____ merge1.log 合并进程 
	 * 										|____ merge..n.log 
	 * 										|____ index_success.log 索引成功的进程 
	 * 										|____ index_fail.log 索引失败的进程
	 * 								|___ data 合并后的索引文件目录
	 * 								|___ solr solr配置文件
	 * @throws IOException 
	 * @throws InterruptedException 
	 * 
	 */
	public static void indexFullExpense(String srcPath) throws IOException,
			InterruptedException {
		// 设置多个进程，使用拷贝方式
		Logger log = null;
		String workspace = "";
		String core = "";
		String cacheDir = "";

		int rowCount = 0;
		int pageSize = 0;
		int sleep = 0;
		final String MERGE_DIR = "/merge";
		final String LOG_DIR = "/logs";
		final String DATA_DIR = "/data";
		final String SOLR_DIR = "/solr";

		File ws = null;
		try {
			workspace = PropertyUtil.get("solr.distribute.index.workspace");
			core = PropertyUtil.get("solr.distribute.index.core");
			cacheDir = PropertyUtil.get("solr.distribute.cache.dir");
			System.setProperty("WORKDIR", workspace);
			log = Logger.getLogger(FullExpenseIndexer.class);
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.rowcount"));
			pageSize = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.pagesize"));
			sleep = Integer.parseInt(PropertyUtil.get("solr.distribute.sleep"));
			ws = new File(workspace);
		} catch (IOException e1) {
			e1.printStackTrace();
			System.exit(-1);
		}
		// 1.读取workspace目录，如果没有，则创建，如果有则强制删除，异常提示出来
		// 如果目录存在，强制删除
		if (ws.exists()) {
			FileUtils.deleteQuietly(ws);
		}
		ws.mkdirs();
		// 判断是否启动cache，如果启动cache，则删除cache的内容
		if (!"".equals(cacheDir)) {
			FileUtils.deleteQuietly(new File(cacheDir));
		}
		File view = new File(workspace + "/process.sh");
		FileUtils.write(view, "ps -ef|grep solr-indexer.jar|grep -v grep");
		view.setExecutable(true);
		// 2.建立目录结构
		// 2.1.建立索引进程目录

		File dirs = new File(workspace + INDEX_DIR);
		dirs.mkdir();
		dirs = new File(workspace + DATA_DIR);
		dirs.mkdir();
		dirs = new File(workspace + LOG_DIR);
		dirs.mkdir();
		dirs = new File(workspace + MERGE_DIR);
		dirs.mkdir();
		dirs = new File(workspace + SOLR_DIR);
		dirs.mkdir();
		System.out.println(">>>>>>>>indexer begin>>>>>>>");
		System.out.println(">>>>>>>>>>directory initial>>>>>>>>>>");
		// 获取要生成的文件数量
		int totalPages = rowCount / pageSize;
		for (int i = 1; i <= totalPages; i++) {
			String fileName = workspace + INDEX_DIR + "/indexer" + i;
			dirs = new File(fileName);
			dirs.mkdir();
			// 3.拷贝文件，从参数中获取源文件目录地址
			// FileUtils.copyDirectory(new File(srcPath), dirs);
			// // 读取这个目录中的index.properties，修改处理开始页和终止页
			// PropertyUtil.writeProperties(fileName + "/indexer.properties",
			// "solr.fullexpense.startpage", String.valueOf(i));
			// PropertyUtil.writeProperties(fileName + "/indexer.properties",
			// "solr.fullexpense.endpage", String.valueOf(i));
			// PropertyUtil.writeProperties(fileName + "/indexer.properties",
			// "solr.fullexpense.pagesize", String.valueOf(pageSize));
		}
		System.out.println(">>>>>>>>>>indexer split : " + totalPages
				+ ">>>>>>>>>>");

		// 4.执行每个索引进程
		// 5.主进程检查已经分配运行的进程，查看其日志结果，如果没有成功，则记录下来，然后启动另外的进程
		int thread = Integer.parseInt(PropertyUtil
				.get("solr.distribute.index.thread"));
		System.out.println(">>>>>>>>>> indexer executing : " + thread
				+ ">>>>>>>>>>");
		boolean con = true;
		while (con) {
			System.out
					.println(">>>>>>>>>> thread is checking background process count...");
			// 判断当前系统中执行的进程名字
			Process p = Runtime.getRuntime().exec(workspace + "/process.sh");
			String output = FullExpenseUtil.inputStream2String(p
					.getInputStream());
			int n = StringUtils.countMatches(output.toLowerCase(),
					"solr-indexer.jar");
			// 如果当前线程数小于指定线程，创建thread-n个
			if (n < thread) {
				// 如果不足，则判断是否有执行完成的，并删掉对应的jar文件
				for (int i = 1; i <= thread - n; i++) {
					int next = getCurrentThread(workspace + LOG_DIR) + 1;
					String destFile = workspace + INDEX_DIR + "/indexer" + next;
					FileUtils.copyDirectory(new File(srcPath), new File(
							destFile));
					// 读取这个目录中的index.properties，修改处理开始页和终止页
					PropertyUtil.writeProperties(destFile
							+ "/indexer.properties",
							"solr.fullexpense.startpage", String.valueOf(next));
					PropertyUtil.writeProperties(destFile
							+ "/indexer.properties",
							"solr.fullexpense.endpage", String.valueOf(next));
					PropertyUtil.writeProperties(destFile
							+ "/indexer.properties",
							"solr.fullexpense.pagesize",
							String.valueOf(pageSize));
					PropertyUtil.writeProperties(destFile
							+ "/indexer.properties",
							"solr.fullexpense.embedded.solrhome", destFile
									+ "/solr");
					// 后台运行
					// 判断是否启动cache，如果启动，则执行拷贝，再切换目录
					String cmd = "";
					// 没设置cache
					if ("".equals(cacheDir)) {
						cmd = "nohup java -jar " + destFile
								+ "/solr-indexer.jar > " + workspace + LOG_DIR
								+ "/" + next + ".log 2>&1 &";
						File script = new File(destFile + "/run.sh");
						FileUtils.write(script, cmd);
						script.setExecutable(true);
						Thread.sleep(500); // 不同时打开，每隔0.5秒打开一个
						Runtime.getRuntime().exec(
								new String[] { "cd " + destFile,
										destFile + "/run.sh" });
						System.out
								.println(">>>>>>>>>> created process " + next);
					} else {
						// 拷贝到cache
						String cacheFile = cacheDir + "/indexer" + next;
						FileUtils.copyDirectory(new File(destFile), new File(
								cacheFile));
						FileUtils.deleteQuietly(new File(destFile));
						PropertyUtil.writeProperties(cacheFile
								+ "/indexer.properties",
								"solr.fullexpense.embedded.solrhome", cacheFile
										+ "/solr");
						cmd = " cd " + cacheFile + " | nohup java -Duser.dir="
								+ cacheFile + " -jar " + cacheFile
								+ "/solr-indexer.jar > " + workspace + LOG_DIR
								+ "/" + next + ".log 2>&1 &";
						File script = new File(cacheFile + "/run.sh");
						FileUtils.write(script, cmd);
						script.setExecutable(true);
						Runtime.getRuntime().exec(cacheFile + "/run.sh");
						System.out.println(">>>>>>>>>> created cached process "
								+ next);
					}
					setCurrentThread(workspace + LOG_DIR, next);
					// 如果下一个线程已经超过了总页数，则进程结束
					if (next > totalPages) {
						System.out.println(">>>>>>>> indexer end >>>>>>>");
						con = false;
						break;
					}
				}
			} else {
				log.debug(">>>>>>>>>> thread will sleep " + sleep / 1000 + "s.");
				Thread.sleep(sleep);// 睡1分钟然后继续
			}
			// 执行shell命令判断有几个进程存活
			// 根据与thread的差距启动进程，启动的顺序按照目录顺序启动，写入调度文件
			// 执行shell脚本启动命令，记录日志
			// 每隔30秒挨个检查一下正在运行的进程的执行日志，看是否执行成功，执行成功的写入调度文件
		}
	}

	/**
	* 设置当前线程号文件名
	* 
	* @param next
	* @throws IOException
	*/
	private static void setCurrentThread(String dir, int next)
			throws IOException {
		// 判断是否存在.lock文件，文件名是当前分配的最后进程
		Collection<File> files = FileUtils.listFiles(new File(dir),
				new String[] { "lock" }, false);
		if (files.size() <= 0) {
			File f = new File(dir + "/0.lock");
			FileUtils.write(f, "0", true);
		} else if (files.size() != 1) {
			throw new IOException("Exists " + files.size() + " of .lock files!");
		} else {
			// 改名此文件
			File f = (File) files.toArray()[0];
			FileUtils.moveFile(f, new File(dir + "/" + next + ".lock"));
		}

	}

	/**
	* 获取当前Thread数
	* 
	* @dir 记录文件的位置
	* @return
	* @throws IOException
	*/
	private static int getCurrentThread(String dir) throws IOException {
		// 判断是否存在.lock文件，文件名是当前分配的最后进程
		Collection<File> files = FileUtils.listFiles(new File(dir),
				new String[] { "lock" }, false);
		if (files.size() <= 0) {
			File f = new File(dir + "/0.lock");
			FileUtils.write(f, "0", true);
			return 0;
		} else if (files.size() != 1) {
			throw new IOException("Exists " + files.size() + " of .lock files!");
		} else {
			// 取当前文件名返回
			File f = (File) files.toArray()[0];
			String fname = f.getName();
			int no = Integer.parseInt(fname.replace(".lock", ""));
			return no;
		}

	}

	public static void main(String[] args) {
		try {
			String src = PropertyUtil.get("solr.distribute.index.srcdir");
			FullExpenseIndexer.indexFullExpense(src);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
}
