package net.wonderslife.indexer.pharma;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.wonderslife.util.FileUtil;
import net.wonderslife.util.PropertyUtil;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PharmaIndexer {

	public static void main(String[] args) {
		PharmaIndexer pi = new PharmaIndexer();
		List<Pharma> docs = new ArrayList<Pharma>();
		try {
			// 4.读取目录下所有文件
			List<String> allfile = FileUtil.getListFiles(
					PropertyUtil.get("solr.pharma.dir"), "htm", true);
			// 4.1.准备solr server
			SolrServer solr = new HttpSolrServer(
					PropertyUtil.get("solr.pharma.url"));
			if (Boolean.parseBoolean(PropertyUtil.get("solr.pharma.delete"))) {
				solr.deleteByQuery("*:*");
				solr.commit();
			}
			for (String file : allfile) {
				System.out.println("processing " + file + "...");
				Pharma p = pi.parseHTML(file);
				if (p != null) {
					System.out.println("added " + file);
					p.setBAZ001(p.getTYM() + "-" + p.getSCQY());
					p.setOwner("user1");
					p.setContent_level("free");
					docs.add(p);
				}
			}
			solr.addBeans(docs);
			solr.commit();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SolrServerException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 测试HTML解析
	 * 
	 * @throws IOException
	 */
	private Pharma parseHTML(String file) throws IOException {
		Pharma p = null;
		File input = new File(file);
		Document doc = Jsoup.parse(input, "UTF-8");
		Elements links = doc.select(".item");// 查找这个class的
		int i = 0;
		Iterator<Element> it = links.iterator();
		while (it.hasNext()) {
			i = i + 1;
			Element e = (Element) it.next();
			if (e.select(".hd").size() <= 0)
				continue;
			String col = e.select(".hd").get(0).toString();

			col = col.replaceAll("【", "").replaceAll("】", "")
					.replaceAll("</div>", "")
					.replaceAll("<div class=\"hd\">", "").replaceAll("\r", "")
					.replaceAll("\n", "").trim();

			if (i == 1 & "药品名称".equals(col)) {
				p = new Pharma();
				String tongyongming = e.select(".info").get(0).toString()
						.replace("通用名：", "")
						.replaceAll("<p class=\"info\">", "")
						.replaceAll("</p>", "").replaceAll("\r", "")
						.replaceAll("\n", "");
				String shangpinming = e.select(".info").get(1).toString()
						.replace("商品名：", "")
						.replaceAll("<p class=\"info\">", "")
						.replaceAll("</p>", "").replaceAll("\r", "")
						.replaceAll("\n", "");
				p.setTYM(tongyongming);
				p.setSPM(shangpinming);
			} else {
				if (e.select(".info").size() <= 0) {
					continue;
				}
				String info = e.select(".info").get(0).toString()
						.replaceAll("<p class=\"info\">", "")
						.replaceAll("</p>", "").replaceAll("\r", "")
						.replaceAll("\n", "");
				if ("".equals(info)) {
					// System.out.println(col);
					if (e.select("ol").size() <= 0) {
						info = e.select("p").toString();
					} else {
						info = e.select("ol").get(0).toString();
					}
				}
				if ("生产企业".equals(col)) {
					p.setSCQY(info);
				}
				if ("成份".equals(col)) {
					p.setCF(info);
				}
				if ("适应症".equals(col)) {
					p.setSYZ(info);
				}
				if ("规格".equals(col)) {
					p.setGG(info);
				}
				if ("用法用量".equals(col)) {
					p.setYFYL(info);
				}
				if ("不良反应".equals(col)) {
					p.setBLFY(info);
				}
				if ("禁忌".equals(col)) {
					p.setJJ(info);
				}
				if ("注意事项".equals(col)) {
					p.setZYSX(info);
				}
				if ("药物相互作用".equals(col)) {
					p.setYWXHZY(info);
				}
				if ("药物分类".equals(col)) {
					p.setYWFL(info);
				}
			}
		}

		return p;
	}
}
