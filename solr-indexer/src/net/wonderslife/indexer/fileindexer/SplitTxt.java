package net.wonderslife.indexer.fileindexer;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 *
 */
public class SplitTxt {
	public static void main(String[] args) throws Exception {
		String filename = "D:\\temp\\SYSI_KC22.txt";
		ReaderListener readerListener = new ReaderListener() {
			public void output(List<String> stringList,long lineNum) throws Exception {
				// 写文件路径，文件名为SYSI_KC22_1.txt
				FileUtils.writeLines(new File("D:\\temp\\indexfile\\SYSI_KC22"+"_"+lineNum+".txt"), stringList);
				// TODO:传递到远程服务器
//				for (String s : stringList) {
//					System.out.println("s = " + s);
//				}
				
			}
		};
		// 设置一次读取的行数
		readerListener.setReadRowNum(10000);
		NIOFileReader nioFileReader = new NIOFileReader(readerListener, "GB2312");
		nioFileReader.readFileByLine(filename);
	}
}