package net.wonderslife.indexer.recipe;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.indexer.base.CodeList;
import net.wonderslife.indexer.base.HospitalOrgList;
import net.wonderslife.util.DateUtil;
import net.wonderslife.util.FileUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;

public class RecipeFileIndexer {
	static Logger logger = Logger.getLogger(RecipeFileIndexer.class);

	public static void main(String[] args) {
		try {
			long allstart = System.currentTimeMillis();
			Map<String, Integer> cols = new HashMap<String, Integer>();
			// 1.加载缓存 AA10_TABLE和医院名称
			CodeList codeList = new CodeList();
			// 1.1.初始化代码表
			codeList.init();
			// 2.获取医院信息缓存
			HospitalOrgList hosList = new HospitalOrgList();
			hosList.init(codeList);
			// 3.读取控制文件
			List<String> ctl = FileUtils.readLines(new File(PropertyUtil
					.get("solr.receipt.ctl")));
			// 从第10行开始，到最后一行-1，是字段顺序和列表
			for (int i = 9; i < ctl.size() - 1; i++) {
				String row = ctl.get(i).substring(ctl.get(i).indexOf("\"") + 1);
				String col = row.substring(0, row.indexOf("\""));
				cols.put(col, cols.size() + 1 - 1);
			}
			// 4.读取目录下所有文件
			List<String> allfile = FileUtil.getListFiles(
					PropertyUtil.get("solr.receipt.dir"), "txt", true);
			// 4.1.准备solr server
			SolrServer solr = new HttpSolrServer(
					PropertyUtil.get("solr.receipt.url"));
			if (Boolean.parseBoolean(PropertyUtil.get("solr.receipt.delete"))) {
				solr.deleteByQuery("*:*");
				solr.commit();
			}
			// 5.读取文件中的内容，然后索引

			Iterator<String> itor = allfile.iterator();
			int flag = 0;
			while (itor.hasNext()) {
				String file = (String) itor.next();
				List<Recipe> docs = new ArrayList<Recipe>();
				flag++;
				logger.info(">>>>>>>>>>>start parsing:" + file + ">>>>>>>>>"
						+ flag + "/" + allfile.size());

				long start = System.currentTimeMillis();
				List<String> content = FileUtils.readLines(new File(file));
				for (int i = 0; i < content.size(); i++) {
					String row = content.get(i);
					// 解析每行
					String[] rows = row.split("[|]");
					// 如果第一位不是4位数字则跳过
					if (!FileUtil.isNumeric(rows[0]) || rows[0].length() != 4
							|| ".".equals(rows[0])) {
						logger.info("Line:" + (i + 1)
								+ " format error! First str is not number:"
								+ rows[0]);
						continue;
					}
					if (rows.length <= 77) {
						logger.info("Line:" + (i + 1)
								+ " format error! column size too small:"
								+ rows.length);
						continue;
					}
					if (!FileUtil.isNumeric(rows[76])) {
						logger.info("Line:" + (i + 1)
								+ " format error! BAZ001 is not number:"
								+ rows[76]);
						continue;
					}
					if (rows.length >= 91 || rows.length >= 82) {
						Recipe recipe = indexRecipe(row, rows, cols, codeList,
								hosList);
						docs.add(recipe);
					} else {
						logger.info("Line:" + (i + 1)
								+ " format error! row length:" + rows.length
								+ ", cols size:" + cols.size());
						// System.exit(0);
						continue;
					}

				}
				solr.addBeans(docs);
				solr.commit();
				long end = System.currentTimeMillis();
				logger.info("index parser spent:" + (end - start) / 1000 + "s");
			}
			long allend = System.currentTimeMillis();
			logger.info("Total index parser spent:" + (allend - allstart)
					/ 1000 + "s");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文本解析成对象
	 * 
	 * @param row
	 * @return
	 * @throws Exception
	 */
	private static Recipe indexRecipe(String row, String[] rows,
			Map<String, Integer> colPos, CodeList codelist,
			HospitalOrgList hosList) throws Exception {
		Recipe recipe = new Recipe();
		recipe.setAKB020(getValFromStr(rows, row, "AKB020", codelist, colPos));
		recipe.setAKC190(getValFromStr(rows, row, "AKC190", codelist, colPos));
		recipe.setAAE072(getValFromStr(rows, row, "AAE072", codelist, colPos));
		recipe.setAKC220(getValFromStr(rows, row, "AKC220", codelist, colPos));
		recipe.setAKE005(getValFromStr(rows, row, "AKE005", codelist, colPos));
		recipe.setBKA135(getValFromStr(rows, row, "BKA135", codelist, colPos));
		recipe.setBKC301(getValFromStr(rows, row, "BKC301", codelist, colPos));
		recipe.setAKE001(getValFromStr(rows, row, "AKE001", codelist, colPos));
		recipe.setAKE002(getValFromStr(rows, row, "AKE002", codelist, colPos));
		recipe.setAKE006(getValFromStr(rows, row, "AKE006", codelist, colPos));
		recipe.setAKC221(DateUtil.extractDateForSolr(getValFromStr(rows, row,
				"AKC221", codelist, colPos)));
		recipe.setAKE010(DateUtil.extractDateForSolr(getValFromStr(rows, row,
				"AKE010", codelist, colPos)));
		recipe.setAKA065(getValFromStr(rows, row, "AKA065", codelist, colPos));
		recipe.setAKE003(getValFromStr(rows, row, "AKE003", codelist, colPos));
		recipe.setAKA063(getValFromStr(rows, row, "AKA063", codelist, colPos));
		recipe.setAKC225(getValFromStr(rows, row, "AKC225", codelist, colPos));
		recipe.setAKC226(getValFromStr(rows, row, "AKC226", codelist, colPos));
		recipe.setAAE019(getValFromStr(rows, row, "AAE019", codelist, colPos));
		recipe.setAKC228(getValFromStr(rows, row, "AKC228", codelist, colPos));
		recipe.setAKE051(getValFromStr(rows, row, "AKE051", codelist, colPos));
		recipe.setAKA068(getValFromStr(rows, row, "AKA068", codelist, colPos));
		recipe.setAKC268(getValFromStr(rows, row, "AKC268", codelist, colPos));
		recipe.setAKA069(getValFromStr(rows, row, "AKA069", codelist, colPos));
		recipe.setBKC127(getValFromStr(rows, row, "BKC127", codelist, colPos));
		recipe.setAKA064(getValFromStr(rows, row, "AKA064", codelist, colPos));
		recipe.setAAE100(getValFromStr(rows, row, "AAE100", codelist, colPos));
		recipe.setBKC126(getValFromStr(rows, row, "BKC126", codelist, colPos));
		recipe.setBKC125(getValFromStr(rows, row, "BKC125", codelist, colPos));
		recipe.setBKA231(getValFromStr(rows, row, "BKA231", codelist, colPos));
		recipe.setBAE073(getValFromStr(rows, row, "BAE073", codelist, colPos));
		recipe.setBKA636(getValFromStr(rows, row, "BKA636", codelist, colPos));
		recipe.setBKA637(getValFromStr(rows, row, "BKA637", codelist, colPos));
		recipe.setBKA104(getValFromStr(rows, row, "BKA104", codelist, colPos));
		recipe.setAKA070(getValFromStr(rows, row, "AKA070", codelist, colPos));
		recipe.setAKA067(getValFromStr(rows, row, "AKA067", codelist, colPos));
		recipe.setAKA074(getValFromStr(rows, row, "AKA074", codelist, colPos));
		recipe.setAAE011(getValFromStr(rows, row, "AAE011", codelist, colPos));
		recipe.setAAE036(DateUtil.extractDateForSolr(getValFromStr(rows, row,
				"AAE036", codelist, colPos)));
		recipe.setBKF050(getValFromStr(rows, row, "BKF050", codelist, colPos));
		recipe.setAKC273(getValFromStr(rows, row, "AKC273", codelist, colPos));
		recipe.setAKA071(getValFromStr(rows, row, "AKA071", codelist, colPos));
		recipe.setAKA072(getValFromStr(rows, row, "AKA072", codelist, colPos));
		recipe.setAKA107(getValFromStr(rows, row, "AKA107", codelist, colPos));
		recipe.setBKA076(getValFromStr(rows, row, "BKA076", codelist, colPos));
		recipe.setAKF002(getValFromStr(rows, row, "AKF002", codelist, colPos));
		recipe.setBKC241(getValFromStr(rows, row, "BKC241", codelist, colPos));
		recipe.setBKC243(getValFromStr(rows, row, "BKC243", codelist, colPos));
		recipe.setBKA205(getValFromStr(rows, row, "BKA205", codelist, colPos));
		recipe.setAKA130(getValFromStr(rows, row, "AKA130", codelist, colPos));
		recipe.setAKA120(getValFromStr(rows, row, "AKA120", codelist, colPos));
		recipe.setBAE075(getValFromStr(rows, row, "BAE075", codelist, colPos));
		recipe.setAAE017(getValFromStr(rows, row, "AAE017", codelist, colPos));
		recipe.setAAE032(DateUtil.extractDateForSolr(getValFromStr(rows, row,
				"AAE032", codelist, colPos)));
		recipe.setBKC060(getValFromStr(rows, row, "BKC060", codelist, colPos));
		recipe.setBKC061(getValFromStr(rows, row, "BKC061", codelist, colPos));
		recipe.setBKC062(getValFromStr(rows, row, "BKC062", codelist, colPos));
		recipe.setBKC063(getValFromStr(rows, row, "BKC063", codelist, colPos));
		recipe.setBKC066(getValFromStr(rows, row, "BKC066", codelist, colPos));
		recipe.setBKC067(getValFromStr(rows, row, "BKC067", codelist, colPos));
		recipe.setBKC068(getValFromStr(rows, row, "BKC068", codelist, colPos));
		recipe.setBKC069(getValFromStr(rows, row, "BKC069", codelist, colPos));
		recipe.setBAZ001(getValFromStr(rows, row, "BAZ001", codelist, colPos));
		recipe.setBZE011(getValFromStr(rows, row, "BZE011", codelist, colPos));
		recipe.setBZE036(DateUtil.extractDateForSolr(getValFromStr(rows, row,
				"BZE036", codelist, colPos)));
		recipe.setAAA027(getValFromStr(rows, row, "AAA027", codelist, colPos));
		recipe.setAAB034(getValFromStr(rows, row, "AAB034", codelist, colPos));
		recipe.setAAC001(getValFromStr(rows, row, "AAC001", codelist, colPos));
		recipe.setBKB070(getValFromStr(rows, row, "BKB070", codelist, colPos));
		recipe.setBKC078(getValFromStr(rows, row, "BKC078", codelist, colPos));
		recipe.setBKC079(getValFromStr(rows, row, "BKC079", codelist, colPos));
		recipe.setBKC081(getValFromStr(rows, row, "BKC081", codelist, colPos));
		// recipe.setBKA971(getValFromStr(rows, row,"BKA971", codelist,
		// colPos));
		// recipe.setBKA973(getValFromStr(rows, row,"BKA973", codelist,
		// colPos));
		// recipe.setBKA974(getValFromStr(rows, row,"BKA974", codelist,
		// colPos));
		// //////////////设置医院信息
		recipe.setAKB021(hosList.getHosName(recipe.getAKB020()));
		recipe.setAKB022(hosList.getHosType(recipe.getAKB020()));
		recipe.setAKA101(hosList.getHosLevel(recipe.getAKB020()));
		recipe.setBKB010(hosList.getHosServiceType(recipe.getAKB020()));
		recipe.setOwner("user1");
		recipe.setContent_level("free");
		return recipe;
	}

	/**
	 * 根据字段从字符串中解析数据
	 * 
	 * @param rows
	 * @param colName
	 * @param colPos
	 * @return
	 * @throws Exception
	 */
	private static String getValFromStr(String[] rows, String row,
			String colName, CodeList codelist, Map<String, Integer> colPos)
			throws Exception {
		String desc = "";
		try {
			desc = codelist.getCodeDesc(colName, rows[colPos.get(colName)
					.intValue()]);
		} catch (ArrayIndexOutOfBoundsException e1) {
			// 如果是数据格式不正确，则继续
			return "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return desc;
	}
}
