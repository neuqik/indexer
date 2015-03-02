package net.wonderslife.indexer.fullexpense;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.wonderslife.indexer.base.CodeList;
import net.wonderslife.indexer.base.HospitalOrgList;
import net.wonderslife.util.JDBCUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.core.CoreContainer;

public class FullExpenseIndexer {
	
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
	 * 										|____ indexer1.log 索引进程 
	 * 										|____ indexer..n.log 
	 * 										|____ indexer.log 调度进程 
	 * 										|____ merge1.log 合并进程 
	 * 										|____ merge..n.log 
	 * 										|____ index_success.log 索引成功的进程 
	 * 										|____ index_fail.log 索引失败的进程
	 * 								|___ data 合并后的索引文件目录
	 * 								|___ solr solr配置文件
	 * 
	 */
	public static void indexFullExpense() {
		// 设置多个进程，使用拷贝方式
		Logger log = null;
		String workspace = "";
		int rowCount = 0;
		int pageSize = 0;
		final String INDEX_DIR = "/indexers";
		final String MERGE_DIR = "/merge";
		final String LOG_DIR = "/logs";
		final String DATA_DIR = "/data";
		final String SOLR_DIR = "/solr";

		File ws = null;
		try {
			workspace = PropertyUtil.get("solr.distribute.index.workspace");
			System.setProperty("WORKDIR", workspace);
			log = Logger.getLogger(FullExpenseIndexer.class);
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.rowcount"));
			pageSize = Integer.parseInt(PropertyUtil
					.get("solr.distribute.index.pagesize"));
			ws = new File(workspace);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 1.读取workspace目录，如果没有，则创建，如果有则强制删除，异常提示出来

		// 如果目录存在，强制删除
		if (ws.exists()) {
			FileUtils.deleteQuietly(ws);
		}
		ws.mkdirs();

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
		log.debug(">>>>>>>>indexer begin>>>>>>>");
		log.debug(">>>>>>>>>>directory initial>>>>>>>>>>");
		// 获取要生成的文件数量
		int totalPages = rowCount / pageSize + 1;
		for (int i = 1; i <= totalPages; i++) {
			dirs = new File(workspace + INDEX_DIR + "/indexer" + i);
			dirs.mkdir();
		}
		log.debug(">>>>>>>>>>indexer split : " + totalPages + ">>>>>>>>>>");
		// 3.拷贝文件，从参数中获取源文件目录地址
		// 4.执行每个索引进程
		// 5.主进程检查已经分配运行的进程，查看其日志结果，如果没有成功，则记录下来，然后启动另外的进程

	}

	public static void main(String[] args) {
		FullExpenseIndexer.indexFullExpense();
	}
}
