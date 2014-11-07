package net.wonderslife.indexer.base;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.wonderslife.util.JDBCUtil;

public class HospitalOrgList {
	private static Map<String, String> hosList = new HashMap<String, String>();
	private static CodeList codeList;

	/**
	 * 初始化医院信息
	 * 
	 * @throws SQLException
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public void init(CodeList theCodeList) throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, FileNotFoundException {
		codeList = theCodeList;
		// 获取数据库连接，获得关键字段
		Connection conn = JDBCUtil.getConnection();
		String sql = "SELECT AKB020 CODE ,AKB021||'|'||AKB022||'|'||AKA101||'|'||BKB010 VALUE FROM KB01 WHERE AAE100 = '1'";
		List<Map<String, Object>> result = JDBCUtil.executeQuery(sql, conn,
				null);
		Iterator<Map<String, Object>> itor = result.iterator();
		while (itor.hasNext()) {
			Map<String, Object> row = (Map<String, Object>) itor.next();
			hosList.put(String.valueOf(row.get("CODE")),
					String.valueOf(row.get("VALUE")));
		}
	}

	/**
	 * 获取医院名称AKB021
	 * 
	 * @param code 医院编码
	 * @return
	 * @throws Exception
	 */
	public String getHosName(String code) throws Exception {
		String hosName = "";
		String value = hosList.get(code);
		if (value != null) {
			String[] values = value.split("[|]");
			if (values != null & values.length == 4) {
				hosName = codeList.getCodeDesc("AKB021", values[0]);
			}
		}
		return hosName;
	}

	/**
	 * 获取医院机构类型AKB022
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getHosType(String code) throws Exception {
		String hosName = "";
		String value = hosList.get(code);
		if (value != null) {
			String[] values = value.split("[|]");
			if (values != null & values.length == 4) {
				hosName = codeList.getCodeDesc("AKB022", values[1]);
			}
		}
		return hosName;
	}

	/**
	 * 获取医院等级AKA101
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getHosLevel(String code) throws Exception {
		String hosName = "";
		String value = hosList.get(code);
		if (value != null) {
			String[] values = value.split("[|]");
			if (values != null & values.length == 4) {
				hosName = codeList.getCodeDesc("AKA101", values[2]);
			}
		}
		return hosName;
	}

	/**
	 * 获取医院服务类型BKB010
	 * 
	 * @param code
	 * @return
	 * @throws Exception
	 */
	public String getHosServiceType(String code) throws Exception {
		String hosName = "";
		String value = hosList.get(code);
		if (value != null) {
			String[] values = value.split("[|]");
			if (values != null & values.length == 4) {
				hosName = codeList.getCodeDesc("BKB010", values[3]);
			}
		}
		return hosName;
	}
}
