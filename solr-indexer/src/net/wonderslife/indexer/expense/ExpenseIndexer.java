package net.wonderslife.indexer.expense;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.indexer.base.CodeList;
import net.wonderslife.indexer.record.Record;
import net.wonderslife.util.DateUtil;
import net.wonderslife.util.JDBCUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class ExpenseIndexer {
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
					.get("solr.expense.pagesize"));
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.expense.rowcount"));
			startPage = Integer.parseInt(PropertyUtil.get(
					"solr.expense.startpage").equals("") ? "0" : PropertyUtil
					.get("solr.expense.startpage"));

			if (startPage <= 0) {
				startPage = 1;
			}
			endPage = Integer.parseInt(PropertyUtil.get("solr.expense.endpage")
					.equals("") ? "0" : PropertyUtil
					.get("solr.expense.endpage"));
			if (endPage <= 0) {
				totalPages = rowCount / pageSize;
			} else {
				totalPages = endPage;
			}
			parall = Integer
					.parseInt(PropertyUtil.get("solr.expense.parall")
							.equals("") ? "0" : PropertyUtil
							.get("solr.expense.parall"));
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
			// setup SolrJ enviroment

			SolrServer solr = new HttpSolrServer(
					PropertyUtil.get("solr.expense.url"));
			if (Boolean.parseBoolean(PropertyUtil.get("solr.expense.delete"))) {
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

				indexByResult(result, codeList, solr);

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

	/**
	 * 
	 * 根据SQL结果索引数据
	 * 
	 * 
	 * 
	 * @param result
	 * 
	 * @param solr
	 * @throws Exception
	 */

	private static void indexByResult(List<Map<String, Object>> result,
			CodeList codeList, SolrServer solr) throws Exception {
		List<Expense> docs = new ArrayList<Expense>();
		Iterator<Map<String, Object>> it = result.iterator();
		while (it.hasNext()) {
			Map<java.lang.String, java.lang.Object> row = (Map<java.lang.String, java.lang.Object>) it
					.next();

			// System.out.println("Indexer is parsing BAZ001:" +

			// row.get("BAZ001")

			// + "... ...");

			Expense expense = new Expense();
			expense.setAAA027(codeList.getCodeDesc("AAA027",
					String.valueOf(row.get("AAA027"))));
			expense.setAAB001(codeList.getCodeDesc("AAB001",
					String.valueOf(row.get("AAB001"))));
			expense.setAAB004(codeList.getCodeDesc("AAB004",
					String.valueOf(row.get("AAB004"))));
			expense.setAAB019(codeList.getCodeDesc("AAB019",
					String.valueOf(row.get("AAB019"))));
			expense.setAAB020(codeList.getCodeDesc("AAB020",
					String.valueOf(row.get("AAB020"))));
			expense.setAAB034(codeList.getCodeDesc("AAB034",
					String.valueOf(row.get("AAB034"))));
			expense.setAAB999(codeList.getCodeDesc("AAB999",
					String.valueOf(row.get("AAB999"))));
			expense.setAAC001(codeList.getCodeDesc("AAC001",
					String.valueOf(row.get("AAC001"))));
			expense.setAAC003(codeList.getCodeDesc("AAC003",
					String.valueOf(row.get("AAC003"))));
			expense.setAAC999(codeList.getCodeDesc("AAC999",
					String.valueOf(row.get("AAC999"))));
			expense.setAAE001(codeList.getCodeDesc("AAE001",
					String.valueOf(row.get("AAE001"))));
			expense.setAAE011(codeList.getCodeDesc("AAE011",
					String.valueOf(row.get("AAE011"))));
			expense.setAAE017(codeList.getCodeDesc("AAE017",
					String.valueOf(row.get("AAE017"))));
			expense.setAAE072(codeList.getCodeDesc("AAE072",
					String.valueOf(row.get("AAE072"))));
			expense.setAAE076(codeList.getCodeDesc("AAE076",
					String.valueOf(row.get("AAE076"))));
			expense.setAAE100(codeList.getCodeDesc("AAE100",
					String.valueOf(row.get("AAE100"))));
			expense.setAAE117(codeList.getCodeDesc("AAE117",
					String.valueOf(row.get("AAE117"))));
			expense.setAAE135(codeList.getCodeDesc("AAE135",
					String.valueOf(row.get("AAE135"))));
			expense.setAAE140(codeList.getCodeDesc("AAE140",
					String.valueOf(row.get("AAE140"))));
			expense.setAAZ500(codeList.getCodeDesc("AAZ500",
					String.valueOf(row.get("AAZ500"))));
			expense.setAKA101(codeList.getCodeDesc("AKA101",
					String.valueOf(row.get("AKA101"))));
			expense.setAKA130(codeList.getCodeDesc("AKA130",
					String.valueOf(row.get("AKA130"))));
			expense.setAKB020(codeList.getCodeDesc("AKB020",
					String.valueOf(row.get("AKB020"))));
			expense.setAKC021(codeList.getCodeDesc("AKC021",
					String.valueOf(row.get("AKC021"))));
			expense.setAKC087(codeList.getCodeDesc("AKC087",
					String.valueOf(row.get("AKC087"))));
			expense.setAKC190(codeList.getCodeDesc("AKC190",
					String.valueOf(row.get("AKC190"))));
			expense.setAKC267(codeList.getCodeDesc("AKC267",
					String.valueOf(row.get("AKC267"))));
			expense.setBAA084(codeList.getCodeDesc("BAA084",
					String.valueOf(row.get("BAA084"))));
			expense.setBAC202(codeList.getCodeDesc("BAC202",
					String.valueOf(row.get("BAC202"))));
			expense.setBAD533(codeList.getCodeDesc("BAD533",
					String.valueOf(row.get("BAD533"))));
			expense.setBAD536(codeList.getCodeDesc("BAD536",
					String.valueOf(row.get("BAD536"))));
			expense.setBAE074(codeList.getCodeDesc("BAE074",
					String.valueOf(row.get("BAE074"))));
			expense.setBAZ001(codeList.getCodeDesc("BAZ001",
					String.valueOf(row.get("BAZ001"))));
			expense.setBAZ002(codeList.getCodeDesc("BAZ002",
					String.valueOf(row.get("BAZ002"))));
			expense.setBKA135(codeList.getCodeDesc("BKA135",
					String.valueOf(row.get("BKA135"))));
			expense.setBKA203(codeList.getCodeDesc("BKA203",
					String.valueOf(row.get("BKA203"))));
			expense.setBKA627(codeList.getCodeDesc("BKA627",
					String.valueOf(row.get("BKA627"))));
			expense.setBKA628(codeList.getCodeDesc("BKA628",
					String.valueOf(row.get("BKA628"))));
			expense.setBKA630(codeList.getCodeDesc("BKA630",
					String.valueOf(row.get("BKA630"))));
			expense.setBKB030(codeList.getCodeDesc("BKB030",
					String.valueOf(row.get("BKB030"))));
			expense.setBKC012(codeList.getCodeDesc("BKC012",
					String.valueOf(row.get("BKC012"))));
			expense.setBKC014(codeList.getCodeDesc("BKC014",
					String.valueOf(row.get("BKC014"))));
			expense.setBKC015(codeList.getCodeDesc("BKC015",
					String.valueOf(row.get("BKC015"))));
			expense.setBKC018(codeList.getCodeDesc("BKC018",
					String.valueOf(row.get("BKC018"))));
			expense.setBKC021(codeList.getCodeDesc("BKC021",
					String.valueOf(row.get("BKC021"))));
			expense.setBKC070(codeList.getCodeDesc("BKC070",
					String.valueOf(row.get("BKC070"))));
			expense.setBKC071(codeList.getCodeDesc("BKC071",
					String.valueOf(row.get("BKC071"))));
			expense.setBKC072(codeList.getCodeDesc("BKC072",
					String.valueOf(row.get("BKC072"))));
			expense.setBKC073(codeList.getCodeDesc("BKC073",
					String.valueOf(row.get("BKC073"))));
			expense.setBKC074(codeList.getCodeDesc("BKC074",
					String.valueOf(row.get("BKC074"))));
			expense.setBKC075(codeList.getCodeDesc("BKC075",
					String.valueOf(row.get("BKC075"))));
			expense.setBKC076(codeList.getCodeDesc("BKC611",
					String.valueOf(row.get("BKC076"))));
			expense.setBKC077(codeList.getCodeDesc("BKC077",
					String.valueOf(row.get("BKC077"))));
			expense.setBKC091(codeList.getCodeDesc("BKC091",
					String.valueOf(row.get("BKC091"))));
			expense.setBKC092(codeList.getCodeDesc("BKC092",
					String.valueOf(row.get("BKC092"))));
			expense.setBKC093(codeList.getCodeDesc("BKC093",
					String.valueOf(row.get("BKC093"))));
			expense.setBKC120(codeList.getCodeDesc("BKC120",
					String.valueOf(row.get("BKC120"))));
			expense.setBKC190(codeList.getCodeDesc("BKC190",
					String.valueOf(row.get("BKC190"))));
			expense.setBKC197(codeList.getCodeDesc("BKC197",
					String.valueOf(row.get("BKC197"))));
			expense.setBKC198(codeList.getCodeDesc("BKC198",
					String.valueOf(row.get("BKC198"))));
			expense.setBKC199(codeList.getCodeDesc("BKC199",
					String.valueOf(row.get("BKC199"))));
			expense.setBKC200(codeList.getCodeDesc("BKC200",
					String.valueOf(row.get("BKC200"))));
			expense.setBKC201(codeList.getCodeDesc("BKC201",
					String.valueOf(row.get("BKC201"))));
			expense.setBKC203(codeList.getCodeDesc("BKC203",
					String.valueOf(row.get("BKC203"))));
			expense.setBKC204(codeList.getCodeDesc("BKC204",
					String.valueOf(row.get("BKC204"))));
			expense.setBKC205(codeList.getCodeDesc("BKC205",
					String.valueOf(row.get("BKC205"))));
			expense.setBKC319(codeList.getCodeDesc("BKC319",
					String.valueOf(row.get("BKC319"))));
			expense.setBKC328(codeList.getCodeDesc("BKC328",
					String.valueOf(row.get("BKC328"))));
			expense.setBKC329(codeList.getCodeDesc("BKC329",
					String.valueOf(row.get("BKC329"))));
			expense.setBKC335(codeList.getCodeDesc("BKC335",
					String.valueOf(row.get("BKC335"))));
			expense.setBKC376(codeList.getCodeDesc("BKC376",
					String.valueOf(row.get("BKC376"))));
			expense.setBKC377(codeList.getCodeDesc("BKC377",
					String.valueOf(row.get("BKC377"))));
			expense.setBKC378(codeList.getCodeDesc("BKC378",
					String.valueOf(row.get("BKC378"))));
			expense.setBKC379(codeList.getCodeDesc("BKC379",
					String.valueOf(row.get("BKC379"))));
			expense.setBKC380(codeList.getCodeDesc("BKC380",
					String.valueOf(row.get("BKC380"))));
			expense.setBKC381(codeList.getCodeDesc("BKC381",
					String.valueOf(row.get("BKC381"))));
			expense.setBKC401(codeList.getCodeDesc("BKC401",
					String.valueOf(row.get("BKC401"))));
			expense.setBKC403(codeList.getCodeDesc("BKC403",
					String.valueOf(row.get("BKC403"))));
			expense.setBKE001(codeList.getCodeDesc("BKE001",
					String.valueOf(row.get("BKE001"))));
			expense.setBKE022(codeList.getCodeDesc("BKE022",
					String.valueOf(row.get("BKE022"))));
			expense.setBKE160(codeList.getCodeDesc("BKE160",
					String.valueOf(row.get("BKE160"))));
			expense.setBKE161(codeList.getCodeDesc("BKE161",
					String.valueOf(row.get("BKE161"))));
			expense.setBKF100(codeList.getCodeDesc("BKF100",
					String.valueOf(row.get("BKF100"))));
			expense.setBZE011(codeList.getCodeDesc("BZE011",
					String.valueOf(row.get("BZE011"))));
			expense.setBZE036(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BZE036"))));
			expense.setAAE032(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AAE032"))));
			expense.setAAE036(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AAE036"))));
			expense.setBKE162(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKE162"))));
			expense.setAKE010(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AKE010"))));
			expense.setAKC266(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AKC266"))));
			expense.setBAD534(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BAD534"))));
			expense.setBAD537(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BAD537"))));
			expense.setBKC013(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKC013"))));
			expense.setBKC016(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKC016"))));
			expense.setBKC019(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKC019"))));
			expense.setOwner("user1");

			expense.setContent_level("free");

			docs.add(expense);

		}

		solr.addBeans(docs);

		solr.commit();

	}

}
