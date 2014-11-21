package net.wonderslife.indexer.record;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.indexer.base.CodeList;
import net.wonderslife.util.DateUtil;
import net.wonderslife.util.JDBCUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class RecordIndexer {
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
					.get("solr.record.pagesize"));
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.record.rowcount"));
			startPage = Integer.parseInt(PropertyUtil.get(
					"solr.record.startpage").equals("") ? "0" : PropertyUtil
					.get("solr.record.startpage"));

			if (startPage <= 0) {
				startPage = 1;
			}
			endPage = Integer
					.parseInt(PropertyUtil.get("solr.record.endpage")
							.equals("") ? "0" : PropertyUtil
							.get("solr.record.endpage"));
			if (endPage <= 0) {
				totalPages = rowCount / pageSize;
			} else {
				totalPages = endPage;
			}
			parall = Integer.parseInt(PropertyUtil.get("solr.record.parall")
					.equals("") ? "0" : PropertyUtil.get("solr.record.parall"));
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
					PropertyUtil.get("solr.record.url"));
			if (Boolean.parseBoolean(PropertyUtil.get("solr.record.delete"))) {
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
						+ parallStr + " * from KC21) A WHERE ROWNUM<="

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
		List<Record> docs = new ArrayList<Record>();
		Iterator<Map<String, Object>> it = result.iterator();
		while (it.hasNext()) {
			Map<java.lang.String, java.lang.Object> row = (Map<java.lang.String, java.lang.Object>) it
					.next();

			// System.out.println("Indexer is parsing BAZ001:" +

			// row.get("BAZ001")

			// + "... ...");

			Record record = new Record();
			record.setAAA027(codeList.getCodeDesc("AAA027",
					String.valueOf(row.get("AAA027"))));
			record.setAAB001(codeList.getCodeDesc("AAB001",
					String.valueOf(row.get("AAB001"))));
			record.setAAB004(codeList.getCodeDesc("AAB004",
					String.valueOf(row.get("AAB004"))));
			record.setAAB019(codeList.getCodeDesc("AAB019",
					String.valueOf(row.get("AAB019"))));
			record.setAAB020(codeList.getCodeDesc("AAB020",
					String.valueOf(row.get("AAB020"))));
			record.setAAB034(codeList.getCodeDesc("AAB034",
					String.valueOf(row.get("AAB034"))));
			record.setAAB301(codeList.getCodeDesc("AAB301",
					String.valueOf(row.get("AAB301"))));
			record.setAAB999(codeList.getCodeDesc("AAB999",
					String.valueOf(row.get("AAB999"))));
			record.setAAC001(codeList.getCodeDesc("AAC001",
					String.valueOf(row.get("AAC001"))));
			record.setAAC003(codeList.getCodeDesc("AAC003",
					String.valueOf(row.get("AAC003"))));
			record.setAAC004(codeList.getCodeDesc("AAC004",
					String.valueOf(row.get("AAC004"))));
			record.setAAC999(codeList.getCodeDesc("AAC999",
					String.valueOf(row.get("AAC999"))));
			record.setAAE009(codeList.getCodeDesc("AAE009",
					String.valueOf(row.get("AAE009"))));
			record.setAAE010(codeList.getCodeDesc("AAE010",
					String.valueOf(row.get("AAE010"))));
			record.setAAE011(codeList.getCodeDesc("AAE011",
					String.valueOf(row.get("AAE011"))));
			record.setAAE013(codeList.getCodeDesc("AAE013",
					String.valueOf(row.get("AAE013"))));
			record.setAAE017(codeList.getCodeDesc("AAE017",
					String.valueOf(row.get("AAE017"))));
			record.setAAE100(codeList.getCodeDesc("AAE100",
					String.valueOf(row.get("AAE100"))));
			record.setAAE135(codeList.getCodeDesc("AAE135",
					String.valueOf(row.get("AAE135"))));
			record.setAAZ500(codeList.getCodeDesc("AAZ500",
					String.valueOf(row.get("AAZ500"))));
			record.setAKA101(codeList.getCodeDesc("AKA101",
					String.valueOf(row.get("AKA101"))));
			record.setAKA130(codeList.getCodeDesc("AKA130",
					String.valueOf(row.get("AKA130"))));
			record.setAKA151(codeList.getCodeDesc("AKA151",
					String.valueOf(row.get("AKA151"))));
			record.setAKB020(codeList.getCodeDesc("AKB020",
					String.valueOf(row.get("AKB020"))));
			record.setAKB021(codeList.getCodeDesc("AKB021",
					String.valueOf(row.get("AKB021"))));
			record.setAKC021(codeList.getCodeDesc("AKC021",
					String.valueOf(row.get("AKC021"))));
			record.setAKC190(codeList.getCodeDesc("AKC190",
					String.valueOf(row.get("AKC190"))));
			record.setAKC193(codeList.getCodeDesc("AKC193",
					String.valueOf(row.get("AKC193"))));
			record.setAKC195(codeList.getCodeDesc("AKC195",
					String.valueOf(row.get("AKC195"))));
			record.setAKC196(codeList.getCodeDesc("AKC196",
					String.valueOf(row.get("AKC196"))));
			record.setAKC273(codeList.getCodeDesc("AKC273",
					String.valueOf(row.get("AKC273"))));
			record.setAKE013(codeList.getCodeDesc("AKE013",
					String.valueOf(row.get("AKE013"))));
			record.setAKE020(codeList.getCodeDesc("AKE020",
					String.valueOf(row.get("AKE020"))));
			record.setAKE021(codeList.getCodeDesc("AKE021",
					String.valueOf(row.get("AKE021"))));
			record.setAKF002(codeList.getCodeDesc("AKF002",
					String.valueOf(row.get("AKF002"))));
			record.setBAB024(codeList.getCodeDesc("BAB024",
					String.valueOf(row.get("BAB024"))));
			record.setBAC888(codeList.getCodeDesc("BAC888",
					String.valueOf(row.get("BAC888"))));
			record.setBAE013(codeList.getCodeDesc("BAE013",
					String.valueOf(row.get("BAE013"))));
			record.setBAE073(codeList.getCodeDesc("BAE073",
					String.valueOf(row.get("BAE073"))));
			record.setBAE450(codeList.getCodeDesc("BAE450",
					String.valueOf(row.get("BAE450"))));
			record.setBAZ001(codeList.getCodeDesc("BAZ001",
					String.valueOf(row.get("BAZ001"))));
			record.setBAZ002(codeList.getCodeDesc("BAZ002",
					String.valueOf(row.get("BAZ002"))));
			record.setBKA130(codeList.getCodeDesc("BKA130",
					String.valueOf(row.get("BKA130"))));
			record.setBKB010(codeList.getCodeDesc("BKB010",
					String.valueOf(row.get("BKB010"))));
			record.setBKC021(codeList.getCodeDesc("BKC021",
					String.valueOf(row.get("BKC021"))));
			record.setBKC023(codeList.getCodeDesc("BKC023",
					String.valueOf(row.get("BKC023"))));
			record.setBKC050(codeList.getCodeDesc("BKC050",
					String.valueOf(row.get("BKC050"))));
			record.setBKC051(codeList.getCodeDesc("BKC051",
					String.valueOf(row.get("BKC051"))));
			record.setBKC052(codeList.getCodeDesc("BKC052",
					String.valueOf(row.get("BKC052"))));
			record.setBKC053(codeList.getCodeDesc("BKC053",
					String.valueOf(row.get("BKC053"))));
			record.setBKC054(codeList.getCodeDesc("BKC054",
					String.valueOf(row.get("BKC054"))));
			record.setBKC055(codeList.getCodeDesc("BKC055",
					String.valueOf(row.get("BKC055"))));
			record.setBKC056(codeList.getCodeDesc("BKC056",
					String.valueOf(row.get("BKC056"))));
			record.setBKC057(codeList.getCodeDesc("BKC057",
					String.valueOf(row.get("BKC057"))));
			record.setBKC058(codeList.getCodeDesc("BKC058",
					String.valueOf(row.get("BKC058"))));
			record.setBKC059(codeList.getCodeDesc("BKC059",
					String.valueOf(row.get("BKC059"))));
			record.setBKC060(codeList.getCodeDesc("BKC060",
					String.valueOf(row.get("BKC060"))));
			record.setBKC120(codeList.getCodeDesc("BKC120",
					String.valueOf(row.get("BKC120"))));
			record.setBKC126(codeList.getCodeDesc("BKC126",
					String.valueOf(row.get("BKC126"))));
			record.setBKC128(codeList.getCodeDesc("BKC128",
					String.valueOf(row.get("BKC128"))));
			record.setBKC190(codeList.getCodeDesc("BKC190",
					String.valueOf(row.get("BKC190"))));
			record.setBKC197(codeList.getCodeDesc("BKC197",
					String.valueOf(row.get("BKC197"))));
			record.setBKC231(codeList.getCodeDesc("BKC231",
					String.valueOf(row.get("BKC231"))));
			record.setBKC232(codeList.getCodeDesc("BKC232",
					String.valueOf(row.get("BKC232"))));
			record.setBKC233(codeList.getCodeDesc("BKC233",
					String.valueOf(row.get("BKC233"))));
			record.setBKC280(codeList.getCodeDesc("BKC280",
					String.valueOf(row.get("BKC280"))));
			record.setBKC281(codeList.getCodeDesc("BKC281",
					String.valueOf(row.get("BKC281"))));
			record.setBKC282(codeList.getCodeDesc("BKC282",
					String.valueOf(row.get("BKC282"))));
			record.setBKC283(codeList.getCodeDesc("BKC283",
					String.valueOf(row.get("BKC283"))));
			record.setBKC284(codeList.getCodeDesc("BKC284",
					String.valueOf(row.get("BKC284"))));
			record.setBKC285(codeList.getCodeDesc("BKC285",
					String.valueOf(row.get("BKC285"))));
			record.setBKC286(codeList.getCodeDesc("BKC286",
					String.valueOf(row.get("BKC286"))));
			record.setBKC287(codeList.getCodeDesc("BKC287",
					String.valueOf(row.get("BKC287"))));
			record.setBKC288(codeList.getCodeDesc("BKC288",
					String.valueOf(row.get("BKC288"))));
			record.setBKC289(codeList.getCodeDesc("BKC289",
					String.valueOf(row.get("BKC289"))));
			record.setBKB342(codeList.getCodeDesc("BKB342",
					String.valueOf(row.get("BKC290")))); // 字段名称不对
			record.setBKC317(codeList.getCodeDesc("BKC317",
					String.valueOf(row.get("BKC317"))));
			record.setBKC319(codeList.getCodeDesc("BKC319",
					String.valueOf(row.get("BKC319"))));
			record.setBKC378(codeList.getCodeDesc("BKC378",
					String.valueOf(row.get("BKC378"))));
			record.setBKC379(codeList.getCodeDesc("BKC379",
					String.valueOf(row.get("BKC379"))));
			record.setBKC380(codeList.getCodeDesc("BKC380",
					String.valueOf(row.get("BKC380"))));
			record.setBKC381(codeList.getCodeDesc("BKC381",
					String.valueOf(row.get("BKC381"))));
			record.setBKC390(codeList.getCodeDesc("BKC390",
					String.valueOf(row.get("BKC390"))));
			record.setBKC401(codeList.getCodeDesc("BKC401",
					String.valueOf(row.get("BKC401"))));
			record.setBKC500(codeList.getCodeDesc("BKC500",
					String.valueOf(row.get("BKC500"))));
			record.setBKE160(codeList.getCodeDesc("BKE160",
					String.valueOf(row.get("BKE160"))));
			record.setBKE161(codeList.getCodeDesc("BKE161",
					String.valueOf(row.get("BKE161"))));
			record.setBKF050(codeList.getCodeDesc("BKF050",
					String.valueOf(row.get("BKF050"))));
			record.setBZE011(codeList.getCodeDesc("BZE011",
					String.valueOf(row.get("BZE011"))));
			record.setBZE036(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BZE036"))));
			record.setBKE162(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKE162"))));
			record.setBKC192(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKC192"))));
			record.setBKC194(DateUtil.extractDateForSolr(String.valueOf(row
					.get("BKC194"))));
			record.setAMC020(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AMC020"))));
			record.setAAE032(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AAE032"))));
			record.setAAE036(DateUtil.extractDateForSolr(String.valueOf(row
					.get("AAE036"))));
			record.setOwner("user1");

			record.setContent_level("free");

			docs.add(record);

		}

		solr.addBeans(docs);

		solr.commit();

	}
}
