package net.wonderslife.indexer.fileindexer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with Okey User: Okey Date: 13-3-14 Time: 下午3:19 NIO逐行读数据回调方法
 */
public abstract class ReaderListener {

	// 一次读取行数，默认为500
	private int readRowNum = 500;

	private List<String> list = new ArrayList<String>();

	/**
	 * 设置一次读取行数
	 * 
	 * @param readRowNum
	 */
	protected void setReadRowNum(int readRowNum) {
		this.readRowNum = readRowNum;
	}

	/**
	 * 每读取到一行数据，添加到缓存中
	 * 
	 * @param lineStr
	 *            读取到的数据
	 * @param lineNum
	 *            行号
	 * @param over
	 *            是否读取完成
	 * @throws Exception
	 */
	public void outLine(String lineStr, long lineNum, boolean over)
			throws Exception {
		if (null != lineStr)
			list.add(lineStr);
		if (!over && (lineNum % readRowNum == 0)) {
			output(list, lineNum);
			list.clear();
		} else if (over) {
			output(list, lineNum);
			list.clear();
		}
	}

	/**
	 * 批量输出
	 * 
	 * @param stringList
	 * @param lineNum 行号
	 * @throws Exception
	 */
	public abstract void output(List<String> stringList, long lineNum)
			throws Exception;

}
