package test;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadDic {
	public static void main(String[] args) {
		// ��ȡĿ¼
		List<String> files = getListFiles("E:\\HIS_X\\oracle\\product\\10.2.0\\db_1\\orcl", "",
				false);
		Iterator<String> it = files.iterator();
		while (it.hasNext()) {
			String file = (String) it.next();
			System.out.print("0 0 0 ");
			System.out.println(file + " 8192");
		}
	}

	public static List<String> getListFiles(String path, String suffix,
			boolean isdepth) {
		List<String> lstFileNames = new ArrayList<String>();
		File file = new File(path);
		return listFile(lstFileNames, file, suffix, isdepth);
	}

	private static List<String> listFile(List<String> lstFileNames, File f,
			String suffix, boolean isdepth) {
		// ����Ŀ¼, ���õݹ�ķ���������Ŀ¼
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
				int begIndex = filePath.lastIndexOf("."); // ���һ��.(����׺��ǰ���.)������
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
}
