package net.wonderslife.indexer.fullexpense;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.indexer.base.CodeList;
import net.wonderslife.indexer.base.HospitalOrgList;
import net.wonderslife.util.DateUtil;
import net.wonderslife.util.JDBCUtil;

import org.apache.solr.client.solrj.SolrServer;

public class FullExpenseUtil {
	/**
	 * 根据结果组织文档
	 * 
	 * @param result
	 * @param codeList
	 * @param solr
	 * @param hosList
	 * @throws Exception
	 */
	public static void indexByResult(List<Map<String, Object>> result,
			CodeList codeList, SolrServer solr, HospitalOrgList hosList)
			throws Exception {
		List<FullExpense> docs = new ArrayList<FullExpense>();
		Iterator<Map<String, Object>> it = result.iterator();
		while (it.hasNext()) {
			Map<java.lang.String, java.lang.Object> row = (Map<java.lang.String, java.lang.Object>) it
					.next();

			// System.out.println("Indexer is parsing BAZ001:" +
			// row.get("BAZ001")
			// + "... ...");

			FullExpense fullexpense = new FullExpense();
			fullexpense.setAAA027(codeList.getCodeDesc("AAA027",
					String.valueOf(row.get("AAA027"))));
			fullexpense.setAAB001(codeList.getCodeDesc("AAB001",
					String.valueOf(row.get("AAB001"))));
			fullexpense.setAAB004(codeList.getCodeDesc("AAB004",
					String.valueOf(row.get("AAB004"))));
			fullexpense.setAAB019(codeList.getCodeDesc("AAB019",
					String.valueOf(row.get("AAB019"))));
			fullexpense.setAAB020(codeList.getCodeDesc("AAB020",
					String.valueOf(row.get("AAB020"))));
			fullexpense.setAAB034(codeList.getCodeDesc("AAB034",
					String.valueOf(row.get("AAB034"))));
			fullexpense.setAAB999(codeList.getCodeDesc("AAB999",
					String.valueOf(row.get("AAB999"))));
			fullexpense.setAAC001(codeList.getCodeDesc("AAC001",
					String.valueOf(row.get("AAC001"))));
			fullexpense.setAAC003(codeList.getCodeDesc("AAC003",
					String.valueOf(row.get("AAC003"))));
			fullexpense.setAAC999(codeList.getCodeDesc("AAC999",
					String.valueOf(row.get("AAC999"))));
			fullexpense.setAAE001(codeList.getCodeDesc("AAE001",
					String.valueOf(row.get("AAE001"))));
			fullexpense.setAAE011(codeList.getCodeDesc("AAE011",
					String.valueOf(row.get("AAE011"))));
			fullexpense.setAAE017(codeList.getCodeDesc("AAE017",
					String.valueOf(row.get("AAE017"))));
			fullexpense.setAAE072(codeList.getCodeDesc("AAE072",
					String.valueOf(row.get("AAE072"))));
			fullexpense.setAAE076(codeList.getCodeDesc("AAE076",
					String.valueOf(row.get("AAE076"))));
			fullexpense.setAAE100(codeList.getCodeDesc("AAE100",
					String.valueOf(row.get("AAE100"))));
			fullexpense.setAAE117(codeList.getCodeDesc("AAE117",
					String.valueOf(row.get("AAE117"))));
			fullexpense.setAAE135(codeList.getCodeDesc("AAE135",
					String.valueOf(row.get("AAE135"))));
			fullexpense.setAAE140(codeList.getCodeDesc("AAE140",
					String.valueOf(row.get("AAE140"))));
			fullexpense.setAAZ500(codeList.getCodeDesc("AAZ500",
					String.valueOf(row.get("AAZ500"))));
			fullexpense.setAKA101(codeList.getCodeDesc("AKA101",
					String.valueOf(row.get("AKA101"))));
			fullexpense.setAKA130(codeList.getCodeDesc("AKA130",
					String.valueOf(row.get("AKA130"))));
			fullexpense.setAKB020(codeList.getCodeDesc("AKB020",
					String.valueOf(row.get("AKB020"))));
			fullexpense.setAKC021(codeList.getCodeDesc("AKC021",
					String.valueOf(row.get("AKC021"))));
			fullexpense.setAKC087(codeList.getCodeDesc("AKC087",
					String.valueOf(row.get("AKC087"))));
			fullexpense.setAKC190(codeList.getCodeDesc("AKC190",
					String.valueOf(row.get("AKC190"))));
			fullexpense.setAKC267(codeList.getCodeDesc("AKC267",
					String.valueOf(row.get("AKC267"))));
			fullexpense.setBAA084(codeList.getCodeDesc("BAA084",
					String.valueOf(row.get("BAA084"))));
			fullexpense.setBAC202(codeList.getCodeDesc("BAC202",
					String.valueOf(row.get("BAC202"))));
			fullexpense.setBAD533(codeList.getCodeDesc("BAD533",
					String.valueOf(row.get("BAD533"))));
			fullexpense.setBAD536(codeList.getCodeDesc("BAD536",
					String.valueOf(row.get("BAD536"))));
			fullexpense.setBAE074(codeList.getCodeDesc("BAE074",
					String.valueOf(row.get("BAE074"))));
			fullexpense.setBAZ001(codeList.getCodeDesc("BAZ001",
					String.valueOf(row.get("BAZ001"))));
			fullexpense.setBAZ002(codeList.getCodeDesc("BAZ002",
					String.valueOf(row.get("BAZ002"))));
			fullexpense.setBKA135(codeList.getCodeDesc("BKA135",
					String.valueOf(row.get("BKA135"))));
			fullexpense.setBKA203(codeList.getCodeDesc("BKA203",
					String.valueOf(row.get("BKA203"))));
			fullexpense.setBKA627(codeList.getCodeDesc("BKA627",
					String.valueOf(row.get("BKA627"))));
			fullexpense.setBKA628(codeList.getCodeDesc("BKA628",
					String.valueOf(row.get("BKA628"))));
			fullexpense.setBKA630(codeList.getCodeDesc("BKA630",
					String.valueOf(row.get("BKA630"))));
			fullexpense.setBKB030(codeList.getCodeDesc("BKB030",
					String.valueOf(row.get("BKB030"))));
			fullexpense.setBKC012(codeList.getCodeDesc("BKC012",
					String.valueOf(row.get("BKC012"))));
			fullexpense.setBKC014(codeList.getCodeDesc("BKC014",
					String.valueOf(row.get("BKC014"))));
			fullexpense.setBKC015(codeList.getCodeDesc("BKC015",
					String.valueOf(row.get("BKC015"))));
			fullexpense.setBKC018(codeList.getCodeDesc("BKC018",
					String.valueOf(row.get("BKC018"))));
			fullexpense.setBKC021(codeList.getCodeDesc("BKC021",
					String.valueOf(row.get("BKC021"))));
			fullexpense.setBKC070(codeList.getCodeDesc("BKC070",
					String.valueOf(row.get("BKC070"))));
			fullexpense.setBKC071(codeList.getCodeDesc("BKC071",
					String.valueOf(row.get("BKC071"))));
			fullexpense.setBKC072(codeList.getCodeDesc("BKC072",
					String.valueOf(row.get("BKC072"))));
			fullexpense.setBKC073(codeList.getCodeDesc("BKC073",
					String.valueOf(row.get("BKC073"))));
			fullexpense.setBKC074(codeList.getCodeDesc("BKC074",
					String.valueOf(row.get("BKC074"))));
			fullexpense.setBKC075(codeList.getCodeDesc("BKC075",
					String.valueOf(row.get("BKC075"))));
			fullexpense.setBKC076(codeList.getCodeDesc("BKC611",
					String.valueOf(row.get("BKC076"))));
			fullexpense.setBKC077(codeList.getCodeDesc("BKC077",
					String.valueOf(row.get("BKC077"))));
			fullexpense.setBKC091(codeList.getCodeDesc("BKC091",
					String.valueOf(row.get("BKC091"))));
			fullexpense.setBKC092(codeList.getCodeDesc("BKC092",
					String.valueOf(row.get("BKC092"))));
			fullexpense.setBKC093(codeList.getCodeDesc("BKC093",
					String.valueOf(row.get("BKC093"))));
			fullexpense.setBKC120(codeList.getCodeDesc("BKC120",
					String.valueOf(row.get("BKC120"))));
			fullexpense.setBKC190(codeList.getCodeDesc("BKC190",
					String.valueOf(row.get("BKC190"))));
			fullexpense.setBKC197(codeList.getCodeDesc("BKC197",
					String.valueOf(row.get("BKC197"))));
			fullexpense.setBKC198(codeList.getCodeDesc("BKC198",
					String.valueOf(row.get("BKC198"))));
			fullexpense.setBKC199(codeList.getCodeDesc("BKC199",
					String.valueOf(row.get("BKC199"))));
			fullexpense.setBKC200(codeList.getCodeDesc("BKC200",
					String.valueOf(row.get("BKC200"))));
			fullexpense.setBKC201(codeList.getCodeDesc("BKC201",
					String.valueOf(row.get("BKC201"))));
			fullexpense.setBKC203(codeList.getCodeDesc("BKC203",
					String.valueOf(row.get("BKC203"))));
			fullexpense.setBKC204(codeList.getCodeDesc("BKC204",
					String.valueOf(row.get("BKC204"))));
			fullexpense.setBKC205(codeList.getCodeDesc("BKC205",
					String.valueOf(row.get("BKC205"))));
			fullexpense.setBKC319(codeList.getCodeDesc("BKC319",
					String.valueOf(row.get("BKC319"))));
			fullexpense.setBKC328(codeList.getCodeDesc("BKC328",
					String.valueOf(row.get("BKC328"))));
			fullexpense.setBKC329(codeList.getCodeDesc("BKC329",
					String.valueOf(row.get("BKC329"))));
			fullexpense.setBKC335(codeList.getCodeDesc("BKC335",
					String.valueOf(row.get("BKC335"))));
			fullexpense.setBKC376(codeList.getCodeDesc("BKC376",
					String.valueOf(row.get("BKC376"))));
			fullexpense.setBKC377(codeList.getCodeDesc("BKC377",
					String.valueOf(row.get("BKC377"))));
			fullexpense.setBKC378(codeList.getCodeDesc("BKC378",
					String.valueOf(row.get("BKC378"))));
			fullexpense.setBKC379(codeList.getCodeDesc("BKC379",
					String.valueOf(row.get("BKC379"))));
			fullexpense.setBKC380(codeList.getCodeDesc("BKC380",
					String.valueOf(row.get("BKC380"))));
			fullexpense.setBKC381(codeList.getCodeDesc("BKC381",
					String.valueOf(row.get("BKC381"))));
			fullexpense.setBKC401(codeList.getCodeDesc("BKC401",
					String.valueOf(row.get("BKC401"))));
			fullexpense.setBKC403(codeList.getCodeDesc("BKC403",
					String.valueOf(row.get("BKC403"))));
			fullexpense.setBKE001(codeList.getCodeDesc("BKE001",
					String.valueOf(row.get("BKE001"))));
			fullexpense.setBKE022(codeList.getCodeDesc("BKE022",
					String.valueOf(row.get("BKE022"))));
			fullexpense.setBKE160(codeList.getCodeDesc("BKE160",
					String.valueOf(row.get("BKE160"))));
			fullexpense.setBKE161(codeList.getCodeDesc("BKE161",
					String.valueOf(row.get("BKE161"))));
			fullexpense.setBKF100(codeList.getCodeDesc("BKF100",
					String.valueOf(row.get("BKF100"))));
			fullexpense.setBZE011(codeList.getCodeDesc("BZE011",
					String.valueOf(row.get("BZE011"))));
			fullexpense.setBZE036(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BZE036"))));
			fullexpense.setAAE032(DateUtil.extractDateForSolr(String
					.valueOf(row.get("AAE032"))));
			fullexpense.setAAE036(DateUtil.extractDateForSolr(String
					.valueOf(row.get("AAE036"))));
			fullexpense.setBKE162(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BKE162"))));
			fullexpense.setAKE010(DateUtil.extractDateForSolr(String
					.valueOf(row.get("AKE010"))));
			fullexpense.setAKC266(DateUtil.extractDateForSolr(String
					.valueOf(row.get("AKC266"))));
			fullexpense.setBAD534(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BAD534"))));
			fullexpense.setBAD537(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BAD537"))));
			fullexpense.setBKC013(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BKC013"))));
			fullexpense.setBKC016(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BKC016"))));
			fullexpense.setBKC019(DateUtil.extractDateForSolr(String
					.valueOf(row.get("BKC019"))));
			fullexpense.setOwner("user1");

			fullexpense.setContent_level("free");

			fullexpense.setAKB021(hosList.getHosName(row.get("AKB020")));
			fullexpense.setAKB022(hosList.getHosType(row.get("AKB020")));
			fullexpense.setContent_valid(codeList.getCodeDesc("BKA135",
					String.valueOf(row.get("BKA135")))); // 默认设置为有效
			fullexpense.setContent_status("0");// 设置内容状态，0是初始，1是问题

			// ////增加KC21部分，处理负交易
			String sql = "SELECT AAC004,BAE450,BKC231,BKC232,AKC193,AKC195,AKC196 FROM KC21 WHERE AKB020=? AND AKC190=? AND AAC001=? AND ROWNUM=1";
			Connection conn = JDBCUtil.getConnection();
			List<Object> param = new ArrayList<Object>();
			param.add(row.get("AKB020"));
			param.add(row.get("AKC190"));
			param.add(row.get("AAC001"));
			try {
				List<Map<String, Object>> kc21Result = JDBCUtil.executeQuery(
						sql, conn, param);
				if (kc21Result != null & kc21Result.size() == 1) {
					fullexpense.setAAC004(String.valueOf(kc21Result.get(0).get(
							"AAC004")));
					fullexpense.setBAE450(String.valueOf(kc21Result.get(0).get(
							"BAE450")));
					fullexpense.setBKC231(String.valueOf(kc21Result.get(0).get(
							"BKC231")));
					fullexpense.setBKC232(String.valueOf(kc21Result.get(0).get(
							"BKC232")));
					fullexpense.setAKC193(String.valueOf(kc21Result.get(0).get(
							"AKC193")));
					fullexpense.setAKC195(String.valueOf(kc21Result.get(0).get(
							"AKC195")));
					fullexpense.setAKC196(String.valueOf(kc21Result.get(0).get(
							"AKC196")));
				}
			} catch (SQLException e) {
				if (e.getSQLState().toLowerCase().contains("no data found")) {

				} else {
					throw e;
				}
			}
			// /////////////////////
			docs.add(fullexpense);

		}

		solr.addBeans(docs);

		solr.commit();

	}
}
