package net.wonderslife.indexer.chemical;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.util.DateUtil;
import net.wonderslife.util.JDBCUtil;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class ChemicalIndexer {
	public static void main(String[] args) {
		Connection conn = null;
		List<Chemical> docs = new ArrayList<Chemical>();
		long start = System.currentTimeMillis();
		try {
			// setup SolrJ enviroment
			SolrServer solr = new HttpSolrServer(JDBCUtil.getSolrURL()
					+ "chemicalcore");
			solr.deleteByQuery("*:*");
			solr.commit();
			// connect to database
			conn = JDBCUtil.getConnection();
			// 需要判断如果是null则设置中文空
			String sql = "SELECT AAA027,AAB034,AAE011,AAE013,AAE030,AAE031,AAE036,fun_getdesc('AAE100',AAE100) AAE100,AKA020,fun_getdesc('AKA022',AKA022) AKA022,AKA060,AKA061, fun_getdesc('aka063',AKA063) AKA063, fun_getdesc('aka065',AKA065) AKA065,AKA070,AKA074,AKA109,AKB020,fun_getdesc('ALA011',ALA011) ALA011,fun_getdesc('AMA011',AMA011) AMA011,BAZ001,BKA083,fun_getdesc('BKA084',BKA084) BKA084,BKA087,fun_getdesc('BKA204',BKA204) BKA204,fun_getdesc('BKA209',BKA209) BKA209,fun_getdesc('BKA210',BKA210) BKA210,fun_getdesc('BKA217',BKA217) BKA217,BKA219,BKA221,BKA222,BKA225,fun_getdesc('BKA226',BKA226) BKA226,fun_getdesc('BKA228',BKA228) BKA228,BKA231,BKA232,BKA233,BKA234,BKA235,BKA236,BKA237,BKA240,BKA246,BKA247,BKA248,BKA249,BKA605,fun_getdesc('BKA608',BKA608) BKA608,BKA610,BKA620,BKA613,BKA638,fun_getdesc('BKC173',BKC173) BKC173 FROM KA02 ";
			List<Map<String, Object>> result = JDBCUtil.executeQuery(sql, conn,
					null);
			long mid = System.currentTimeMillis();

			Iterator<Map<String, Object>> it = result.iterator();
			while (it.hasNext()) {
				Map<java.lang.String, java.lang.Object> row = (Map<java.lang.String, java.lang.Object>) it
						.next();
//				System.out.println("Indexer is parsing BAZ001:"
//						+ row.get("BAZ001") + "... ...");
				Chemical ch = new Chemical();
				ch.setAAA027(String.valueOf(row.get("AAA027")));
				ch.setAAB034(String.valueOf(row.get("AAB034")));
				ch.setAAE011(String.valueOf(row.get("AAE011")));
				ch.setAAE013(String.valueOf(row.get("AAE013")));
				ch.setAAE030(DateUtil.extractDateForSolr(String.valueOf(row
						.get("AAE030"))));
				ch.setAAE031(DateUtil.extractDateForSolr(String.valueOf(row
						.get("AAE031"))));
				ch.setAAE036(DateUtil.extractDateForSolr(String.valueOf(row
						.get("AAE036"))));
				ch.setAAE100(String.valueOf(row.get("AAE100")));
				ch.setAKA020(String.valueOf(row.get("AKA020")));
				ch.setAKA022(String.valueOf(row.get("AKA022")));
				ch.setAKA060(String.valueOf(row.get("AKA060")));
				ch.setAKA061(String.valueOf(row.get("AKA061")));
				ch.setAKA063(String.valueOf(row.get("AKA063")));
				ch.setAKA065(String.valueOf(row.get("AKA065")));
				ch.setAKA070(String.valueOf(row.get("AKA070")));
				ch.setAKA074(String.valueOf(row.get("AKA074")));
				ch.setAKA109(String.valueOf(row.get("AKA109")));
				ch.setAKB020(String.valueOf(row.get("AKB020")));
				ch.setALA011(String.valueOf(row.get("ALA011")));
				ch.setAMA011(String.valueOf(row.get("AMA011")));
				ch.setBAZ001(String.valueOf(row.get("BAZ001")));
				ch.setBKA083(String.valueOf(row.get("BKA083")));
				ch.setBKA084(String.valueOf(row.get("BKA084")));
				ch.setBKA087(String.valueOf(row.get("BKA087")));
				ch.setBKA204(String.valueOf(row.get("BKA204")));
				ch.setBKA209(String.valueOf(row.get("BKA209")));
				ch.setBKA210(String.valueOf(row.get("BKA210")));
				ch.setBKA217(String.valueOf(row.get("BKA217")));
				ch.setBKA219(String.valueOf(row.get("BKA219")));
				ch.setBKA221(String.valueOf(row.get("BKA221")));
				ch.setBKA222(String.valueOf(row.get("BKA222")));
				ch.setBKA225(String.valueOf(row.get("BKA225")));
				ch.setBKA226(String.valueOf(row.get("BKA226")));
				ch.setBKA228(String.valueOf(row.get("BKA228")));
				ch.setBKA231(String.valueOf(row.get("BKA231")));
				ch.setBKA232(String.valueOf(row.get("BKA232")));
				ch.setBKA233(String.valueOf(row.get("BKA233")));
				ch.setBKA234(String.valueOf(row.get("BKA234")));
				ch.setBKA235(String.valueOf(row.get("BKA235")));
				ch.setBKA236(String.valueOf(row.get("BKA236")));
				ch.setBKA237(String.valueOf(row.get("BKA237")));
				ch.setBKA240(String.valueOf(row.get("BKA240")));
				ch.setBKA246(String.valueOf(row.get("BKA246")));
				ch.setBKA247(String.valueOf(row.get("BKA247")));
				ch.setBKA248(String.valueOf(row.get("BKA248")));
				ch.setBKA249(String.valueOf(row.get("BKA249")));
				ch.setBKA605(String.valueOf(row.get("BKA605")));
				ch.setBKA608(String.valueOf(row.get("BKA608")));
				ch.setBKA610(String.valueOf(row.get("BKA610")));
				ch.setBKA620(String.valueOf(row.get("BKA620")));
				ch.setBKA613(String.valueOf(row.get("BKA613")));
				ch.setBKA638(String.valueOf(row.get("BKA638")));
				ch.setBKC173(String.valueOf(row.get("BKC173")));

				ch.setOwner("user1");
				ch.setContent_level("free");
				docs.add(ch);
			}
			solr.addBeans(docs);
			solr.commit();
			long end = System.currentTimeMillis();
			System.out.println("database retrive spent:" + (mid - start) / 1000
					+ "s");
			System.out
					.println("total time spend:" + (end - start) / 1000 + "s");
			System.out.println("indexed docs:" + result.size());
		} catch (SolrServerException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
