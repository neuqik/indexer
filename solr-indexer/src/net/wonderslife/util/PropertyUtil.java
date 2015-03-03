package net.wonderslife.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
		input.close();
		return prop.getProperty(param);
	}

	/*
	 * 写Properties文件的内容
	 */
	public static void writeProperties(String fileName, String key, String value)
			throws IOException {
		//读properties文件内容
		Properties prop = new Properties();
		InputStream input = new FileInputStream(fileName);
		prop.load(input);
		prop.setProperty(key, value);
		input.close();
		OutputStream output = new FileOutputStream(fileName);
		prop.store(output, "");
		output.close();
	}
}
