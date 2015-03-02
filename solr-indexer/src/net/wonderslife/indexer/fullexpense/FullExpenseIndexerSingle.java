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

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.core.CoreContainer;

public class FullExpenseIndexerSingle {
	/**
	 * 单线程执行索引
	 */
	public static void main(String[] args) {

		int pageSize = 0;
		int rowCount = 0;// 总行数
		int startPage = 0;// 最后页数
		int endPage = 0;
		int totalPages = 0;
		String parallStr = "";
		int parall = 0;
		try {
			pageSize = Integer.parseInt(PropertyUtil
					.get("solr.fullexpense.pagesize"));
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.fullexpense.rowcount"));
			startPage = Integer.parseInt(PropertyUtil.get(
					"solr.fullexpense.startpage").equals("") ? "0"
					: PropertyUtil.get("solr.fullexpense.startpage"));

			if (startPage <= 0) {
				startPage = 1;
			}
			endPage = Integer.parseInt(PropertyUtil.get(
					"solr.fullexpense.endpage").equals("") ? "0" : PropertyUtil
					.get("solr.fullexpense.endpage"));
			if (endPage <= 0) {
				totalPages = rowCount / pageSize;
			} else {
				totalPages = endPage;
			}
			parall = Integer.parseInt(PropertyUtil.get(
					"solr.fullexpense.parall").equals("") ? "0" : PropertyUtil
					.get("solr.fullexpense.parall"));
			if (parall > 0) {
				parallStr = "/*+ parallel(" + parall + ")  */";
			}
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} // 20条一提交solr

		int count = totalPages;// 计数器

		// count = totalPages;

		System.out.println("total pages:" + (count - startPage + 1));

		Connection conn = null;

		long allstart = System.currentTimeMillis();

		try {
			// 1.加载缓存 AA10_TABLE和医院名称
			CodeList codeList = new CodeList();
			// 1.1.初始化代码表
			codeList.init();
			HospitalOrgList hosList = new HospitalOrgList();
			hosList.init(codeList);
			// setup SolrJ enviroment
			// 判断solr服务器
			SolrServer solr = null;
			String solrurl = PropertyUtil.get("solr.fullexpense.url");
			if ("EmbeddedSolrServer".equals(solrurl)) {
				String solrhome = PropertyUtil
						.get("solr.fullexpense.embedded.solrhome");
				if ("".equals(solrhome)) {
					System.out
							.println("please set up solr.fullexpense.embedded.solrhome first.");
					return;
				}
				// 设置嵌入式模式
				System.setProperty("solr.solr.home", solrhome);
				CoreContainer coreContainer = CoreContainer.createAndLoad(
						solrhome, new File(solrhome + "/solr.xml"));
				solr = new EmbeddedSolrServer(coreContainer,
						PropertyUtil.get("solr.fullexpense.embedded.core"));
			} else {
				solr = new HttpSolrServer(solrurl);
			}
			if (Boolean.parseBoolean(PropertyUtil
					.get("solr.fullexpense.delete"))) {
				solr.deleteByQuery("*:*");
				solr.commit();
			}
			// connect to database

			for (int i = startPage - 1; i < count; i++) {

				// 需要判断如果是null则设置中文无

				int maxRow = (i + 1) * pageSize;

				int minRow = i * pageSize + 1;

				System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

				System.out.println("processing page:" + (i + 1)

				+ ", start row:" + minRow + ", end row:" + maxRow);

				long start = System.currentTimeMillis();

				conn = JDBCUtil.getConnection();

				String sql = "SELECT * FROM (SELECT A.*,ROWNUM RN FROM (select "
						+ parallStr + " * from KC24) A WHERE ROWNUM<="

						+ "?" + ") WHERE RN >=" + "?";
				List<Object> param = new ArrayList<Object>();
				param.add(maxRow);
				param.add(minRow);
				List<Map<String, Object>> result = JDBCUtil.executeQuery(sql,
						conn, param);

				long mid = System.currentTimeMillis();

				FullExpenseUtil.indexByResult(result, codeList, solr, hosList);

				long end = System.currentTimeMillis();

				System.out.println("database retrive spent:" + (mid - start)

				/ 1000 + "s");

				System.out.println("total time spent:" + (end - start) / 1000

				+ "s");

				System.out.println("indexed docs:" + result.size());

			}

			long allend = System.currentTimeMillis();

			System.out.println(">>>>>>>>>>>>>Total:"
					+ ((allend - allstart) / 1000) + "s>>>>>>>>>>>");

		} catch (Exception e) {

			e.printStackTrace();

		}

	}

}
