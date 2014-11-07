package net.wonderslife.indexer.base;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.util.JDBCUtil;

public class CodeList {
	private static Map<String, String> codeList = new HashMap<String, String>();

	/**
	 * 初始化，必须执行一次
	 * 
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void init() throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, FileNotFoundException, SQLException {
		// 获取数据库连接，获得关键字段
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT AAA100||'|'||AAA102 CODE,AAA103 VALUE FROM AA10_TABLE WHERE AAE100 = '1'";
		List<Map<String, Object>> result = JDBCUtil.executeQuery(sql, conn,
				null);
		Iterator<Map<String, Object>> itor = result.iterator();
		while (itor.hasNext()) {
			Map<String, Object> row = (Map<String, Object>) itor.next();
			codeList.put(String.valueOf(row.get("CODE")),
					String.valueOf(row.get("VALUE")));
		}
	}

	/**
	 * 获取代码中文
	 * 
	 * @param codeName
	 *            字段名
	 * @param value
	 *            字段值
	 * @return
	 * @throws Exception
	 */
	public String getCodeDesc(String codeName, String value)
			throws Exception {
		String codeDesc = "";
		if (codeList.size() <= 0) {
			throw new Exception("codeList is not been initial.");
		}
		codeDesc = codeList.get(codeName + "|" + value);
		if (codeDesc == null) {
			codeDesc = "";
		}
		if (!"".equals(codeDesc)) {
			return codeDesc;
		} else {
			return value;
		}
	}
}
