package net.wonderslife.indexer.recipe;

import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.util.DateUtil;
import net.wonderslife.util.JDBCUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class RecipeIndexer {

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
					.get("solr.receipt.pagesize"));
			rowCount = Integer.parseInt(PropertyUtil
					.get("solr.receipt.rowcount"));
			startPage = Integer.parseInt(PropertyUtil.get(
					"solr.receipt.startpage").equals("") ? "0" : PropertyUtil
					.get("solr.receipt.startpage"));

			if (startPage <= 0) {
				startPage = 1;
			}
			endPage = Integer.parseInt(PropertyUtil.get("solr.receipt.endpage")
					.equals("") ? "0" : PropertyUtil
					.get("solr.receipt.endpage"));
			if (endPage <= 0) {
				totalPages = rowCount / pageSize;
			} else {
				totalPages = endPage;
			}
			parall = Integer
					.parseInt(PropertyUtil.get("solr.receipt.parall")
							.equals("") ? "0" : PropertyUtil
							.get("solr.receipt.parall"));
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

			// setup SolrJ enviroment

			SolrServer solr = new HttpSolrServer(
					PropertyUtil.get("solr.receipt.url"));
			if (Boolean.parseBoolean(PropertyUtil.get("solr.receipt.delete"))) {
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
						+ parallStr
						+ " AKB020,AKC190,AAE072,AKC220,AKE005,fun_getdesc('BKA135',BKA135) BKA135,BKC301,AKE002,AKE006,TO_CHAR(AKC221,'YYYY-MM-DD') AKC221,TO_CHAR(AKE010,'YYYY-MM-DD') AKE010,fun_getdesc('AKA065',AKA065) AKA065,fun_getdesc('AKE003',AKE003) AKE003, fun_getdesc('AKA063',AKA063) AKA063,AKC225,AKC226,AAE019,AKC228,AKE051,AKA068,AKC268,BKC228,BKA635,AKA069,BKA107,BKA108,fun_getdesc('BKC127',BKC127) BKC127,fun_getdesc('AKA064',AKA064) AKA064,fun_getdesc('AAE100',AAE100) AAE100,fun_getdesc('BKC126',BKC126) BKC126, fun_getdesc('BKC125',BKC125) BKC125,fun_getdesc('BKA231',BKA231) BKA231,fun_getdesc('BAE073',BAE073) BAE073,BKA636,BKA637,BKA104,AKA070,AKA067,AKA074,BKC378,BKC379,BKC380,BKC381,AAE011,TO_CHAR(AAE036,'YYYY-MM-DD') AAE036,BKC319,BKF050,AKC273,AKA071,AKA072,AKA107,BKA076,AKF002,BKC241,BKC242,fun_getdesc('BKC243',BKC243) BKC243,fun_getdesc('BKA205',BKA205) BKA205,BKB401,BKA650,BKA651,fun_getdesc('AKA130',AKA130) AKA130,AKA120,BAE075,AAE017,TO_CHAR(AAE032,'YYYY-MM-DD') AAE032,BKC060,BKC061,BKC062,BKC063,BKC064,BKC065,BKC066,fun_getdesc('BKC067',BKC067) BKC067,fun_getdesc('BKC068',BKC068) BKC068,fun_getdesc('BKC069',BKC069) BKC069,BAZ001,BZE011,TO_CHAR(BZE036,'YYYY-MM-DD') BZE036,AAA027,AAB034,AAC001,BKB070,BKB071,BKC077,BKC078,BKC079,BKC081,BKA610,BKA971,BKA972,BKA973,BKA974 from kc22) A WHERE ROWNUM<="

						+ "?" + ") WHERE RN >=" + "?";
				List<Object> param = new ArrayList<Object>();
				param.add(maxRow);
				param.add(minRow);
				List<Map<String, Object>> result = JDBCUtil.executeQuery(sql,
						conn, param);

				long mid = System.currentTimeMillis();

				indexByResult(result, solr);

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
	 * 
	 * @throws ParseException
	 * 
	 * @throws SolrServerException
	 * 
	 * @throws IOException
	 */

	private static void indexByResult(List<Map<String, Object>> result,

	SolrServer solr) throws ParseException, SolrServerException,

	IOException {

		List<Recipe> docs = new ArrayList<Recipe>();

		Iterator<Map<String, Object>> it = result.iterator();

		while (it.hasNext()) {

			Map<java.lang.String, java.lang.Object> row = (Map<java.lang.String, java.lang.Object>) it

			.next();

			// System.out.println("Indexer is parsing BAZ001:" +

			// row.get("BAZ001")

			// + "... ...");

			Recipe recipe = new Recipe();

			recipe.setAKB020(String.valueOf(row.get("AKB020")));

			recipe.setAKC190(String.valueOf(row.get("AKC190")));

			recipe.setAAE072(String.valueOf(row.get("AAE072")));

			recipe.setAKC220(String.valueOf(row.get("AKC220")));

			recipe.setAKE005(String.valueOf(row.get("AKE005")));

			recipe.setBKA135(String.valueOf(row.get("BKA135")));

			recipe.setBKC301(String.valueOf(row.get("BKC301")));

			recipe.setAKE001(String.valueOf(row.get("AKE001")));

			recipe.setAKE002(String.valueOf(row.get("AKE002")));

			recipe.setAKE006(String.valueOf(row.get("AKE006")));

			recipe.setAKC221(DateUtil.extractDateForSolr(String.valueOf(row

			.get("AKC221"))));

			recipe.setAKE010(DateUtil.extractDateForSolr(String.valueOf(row

			.get("AKE010"))));

			recipe.setAKA065(String.valueOf(row.get("AKA065")));

			recipe.setAKE003(String.valueOf(row.get("AKE003")));

			recipe.setAKA063(String.valueOf(row.get("AKA063")));

			recipe.setAKC225(String.valueOf(row.get("AKC225")));

			recipe.setAKC226(String.valueOf(row.get("AKC226")));

			recipe.setAAE019(String.valueOf(row.get("AAE019")));

			recipe.setAKC228(String.valueOf(row.get("AKC228")));

			recipe.setAKE051(String.valueOf(row.get("AKE051")));

			recipe.setAKA068(String.valueOf(row.get("AKA068")));

			recipe.setAKC268(String.valueOf(row.get("AKC268")));

			recipe.setAKA069(String.valueOf(row.get("AKA069")));

			recipe.setBKC127(String.valueOf(row.get("BKC127")));

			recipe.setAKA064(String.valueOf(row.get("AKA064")));

			recipe.setAAE100(String.valueOf(row.get("AAE100")));

			recipe.setBKC126(String.valueOf(row.get("BKC126")));

			recipe.setBKC125(String.valueOf(row.get("BKC125")));

			recipe.setBKA231(String.valueOf(row.get("BKA231")));

			recipe.setBAE073(String.valueOf(row.get("BAE073")));

			recipe.setBKA636(String.valueOf(row.get("BKA636")));

			recipe.setBKA637(String.valueOf(row.get("BKA637")));

			recipe.setBKA104(String.valueOf(row.get("BKA104")));

			recipe.setAKA070(String.valueOf(row.get("AKA070")));

			recipe.setAKA067(String.valueOf(row.get("AKA067")));

			recipe.setAKA074(String.valueOf(row.get("AKA074")));

			recipe.setAAE011(String.valueOf(row.get("AAE011")));

			recipe.setAAE036(DateUtil.extractDateForSolr(String.valueOf(row

			.get("AAE036"))));

			recipe.setBKF050(String.valueOf(row.get("BKF050")));

			recipe.setAKC273(String.valueOf(row.get("AKC273")));

			recipe.setAKA071(String.valueOf(row.get("AKA071")));

			recipe.setAKA072(String.valueOf(row.get("AKA072")));

			recipe.setAKA107(String.valueOf(row.get("AKA107")));

			recipe.setBKA076(String.valueOf(row.get("BKA076")));

			recipe.setAKF002(String.valueOf(row.get("AKF002")));

			recipe.setBKC241(String.valueOf(row.get("BKC241")));

			recipe.setBKC243(String.valueOf(row.get("BKC243")));

			recipe.setBKA205(String.valueOf(row.get("BKA205")));

			recipe.setAKA130(String.valueOf(row.get("AKA130")));

			recipe.setAKA120(String.valueOf(row.get("AKA120")));

			recipe.setBAE075(String.valueOf(row.get("BAE075")));

			recipe.setAAE017(String.valueOf(row.get("AAE017")));

			recipe.setAAE032(DateUtil.extractDateForSolr(String.valueOf(row

			.get("AAE032"))));

			recipe.setBKC060(String.valueOf(row.get("BKC060")));

			recipe.setBKC061(String.valueOf(row.get("BKC061")));

			recipe.setBKC062(String.valueOf(row.get("BKC062")));

			recipe.setBKC063(String.valueOf(row.get("BKC063")));

			recipe.setBKC066(String.valueOf(row.get("BKC066")));

			recipe.setBKC067(String.valueOf(row.get("BKC067")));

			recipe.setBKC068(String.valueOf(row.get("BKC068")));

			recipe.setBKC069(String.valueOf(row.get("BKC069")));

			recipe.setBAZ001(String.valueOf(row.get("BAZ001")));

			recipe.setBZE011(String.valueOf(row.get("BZE011")));

			recipe.setBZE036(DateUtil.extractDateForSolr(String.valueOf(row

			.get("BZE036"))));

			recipe.setAAA027(String.valueOf(row.get("AAA027")));

			recipe.setAAB034(String.valueOf(row.get("AAB034")));

			recipe.setAAC001(String.valueOf(row.get("AAC001")));

			recipe.setBKB070(String.valueOf(row.get("BKB070")));

			recipe.setBKC078(String.valueOf(row.get("BKC078")));

			recipe.setBKC079(String.valueOf(row.get("BKC079")));

			recipe.setBKC081(String.valueOf(row.get("BKC081")));

			recipe.setBKA971(String.valueOf(row.get("BKA971")));

			recipe.setBKA973(String.valueOf(row.get("BKA973")));

			recipe.setBKA974(String.valueOf(row.get("BKA974")));

			recipe.setOwner("user1");

			recipe.setContent_level("free");

			docs.add(recipe);

		}

		solr.addBeans(docs);

		solr.commit();

	}

}
