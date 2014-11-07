package net.wonderslife.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	/**
	 * 获取参数内容
	 * @param param
	 * @return
	 * @throws IOException
	 */
	public static String get(String param) throws IOException {
		InputStream input = null;
		Properties prop = new Properties();
		input = new FileInputStream(PropertyUtil.class.getResource("/")
				.getPath() + "indexer.properties");
		prop.load(input);
		return prop.getProperty(param);
	}
}
