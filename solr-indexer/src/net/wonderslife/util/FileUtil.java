package net.wonderslife.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * 读取目录及子目录下指定文件名的路径, 返回一个List
 */

public class FileUtil {
	private static Logger logger = Logger.getLogger(FileUtil.class);

	/**
	 * @param path
	 *            文件路径
	 * @param suffix
	 *            后缀名, 为空则表示所有文件
	 * @param isdepth
	 *            是否遍历子目录
	 * @return list
	 */
	public static List<String> getListFiles(String path, String suffix,
			boolean isdepth) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return FileUtil.listFile(lstFileNames, file, suffix, isdepth);
	}

	private static List<String> listFile(List<String> lstFileNames, File f,
			String suffix, boolean isdepth) {
		// 若是目录, 采用递归的方法遍历子目录
		if (f.isDirectory()) {
			File[] t = f.listFiles();

			for (int i = 0; i < t.length; i++) {
				if (isdepth || t[i].isFile()) {
					listFile(lstFileNames, t[i], suffix, isdepth);
				}
			}
		} else {
			String filePath = f.getAbsolutePath();
			if (!suffix.equals("")) {
				int begIndex = filePath.lastIndexOf("."); // 最后一个.(即后缀名前面的.)的索引
				String tempsuffix = "";

				if (begIndex != -1) {
					tempsuffix = filePath.substring(begIndex + 1,
							filePath.length());
					if (tempsuffix.equals(suffix)) {
						lstFileNames.add(filePath);
					}
				}
			} else {
				lstFileNames.add(filePath);
			}
		}
		return lstFileNames;
	}
	/**
	 * 判断是否是四位数字
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str.matches("\\d*")) {
			return true;
		} else {
			return false;
		}
	}
}