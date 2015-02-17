package net.wonderslife.indexer.pharma;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class PharmaCrawler {
	public static void main(String[] args) {

		String destDir = "D:/temp/pharmacrawler/";
		String catelogUrl = "http://yao.dxy.com/category/";

		for (int i = 166; i <= 200; i++) {
			System.out.println("parsing catelog " + i + " ...");
			pharmaCrawle(String.valueOf(i), catelogUrl, destDir);
		}
	}

	/**
	 * 获取HTML页面并保存
	 * 
	 * @param url
	 * @param dest
	 */
	private static void getHtml(String url, String dest) {
		CloseableHttpResponse response1 = null;
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);
			response1 = httpclient.execute(httpGet);
			HttpEntity entity1 = response1.getEntity();
			// EntityUtils.consume(entity1);
			entity1.writeTo(new FileOutputStream(dest));
			httpclient.close();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				response1.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获取最后一页
	 * 
	 * @param file
	 * @return
	 */
	private static int getLast(String file) {
		int last = 1;
		// 读取文件
		Document doc = null;
		try {
			doc = Jsoup.parse(new File(file), "UTF-8");

			Elements elements = doc.select("a[href].ui-page-item-gray");
			if (elements.size() == 2) {
				last = Integer.parseInt(elements.get(1).attr("href")
						.replace("?&page=", ""));
			} else {
				last = 0;
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return last;
	}

	/**
	 * 获取URL
	 * 
	 * @param file
	 * @return
	 */
	private static List<String> getUrls(String file) {
		List<String> result = new ArrayList<String>();
		Document doc = null;
		try {
			doc = Jsoup.parse(new File(file), "UTF-8");

			Elements elements = doc.select("div.drugs-ser-list")
					.select("h3.tit").select("a");
			for (Element e : elements) {
				result.add(e.attr("href"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 抓药品
	 * 
	 * @param cata
	 *            分类数字
	 * @param catelogUrl
	 *            分类url
	 * @param destDir
	 *            写入目录
	 */
	private static void pharmaCrawle(String cata, String catelogUrl,
			String destDir) {
		String catalog = cata + ".htm";

		// 取分类目录
		getHtml(catelogUrl + catalog, destDir + catalog);
		int last = getLast(destDir + catalog);
		if (last == 0)
			return;
		// 循环取分页
		for (int i = 1; i <= last; i++) {
			getHtml(catelogUrl + catalog + "?&page=" + i, destDir + cata + "-"
					+ i + ".htm");
			// 解析获取url，读取药品
			List<String> urls = getUrls(destDir + cata + "-" + i + ".htm");
			int j = 1;
			for (String url : urls) {
				getHtml(url, destDir + cata + "-" + i + "-" + j + ".htm");
				j = j + 1;
			}
		}
	}

}
