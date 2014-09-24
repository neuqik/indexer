package net.wonderslife.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class JDBCUtil {
	private static String solrURL = "";

	public static Connection getConnection() throws SQLException,
			InstantiationException, IllegalAccessException,
			ClassNotFoundException, FileNotFoundException {
		Properties prop = new Properties();
		Connection conn = null;
		InputStream input = null;
		try {
			input = new FileInputStream(JDBCUtil.class.getResource("/")
					.getPath() + "indexer.properties");
			prop.load(input);
			// 获取数据库连接串
			String driver = prop.getProperty("user.db.driver");
			String url = prop.getProperty("user.db.url");
			String user = prop.getProperty("user.db.user");
			String password = prop.getProperty("user.db.password");

			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url, user, password);
			conn.setAutoCommit(false);
			return conn;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (input != null)
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}

		return conn;
	}

	/**
	 * 查询结果，不使用prepare的方法，如果是null则置为空
	 * 
	 */
	public static List<Map<String, Object>> executeQuery(String sql,
			Connection conn, List<Object> param) throws SQLException {
		List<Map<String, Object>> data = new ArrayList<Map<String, Object>>();
		PreparedStatement stmt = conn.prepareStatement(sql);
		if (param != null) {
			for (int i = 0; i < param.size(); i++) {
				stmt.setObject(i + 1, param.get(i));
			}
		}
		ResultSet rs = stmt.executeQuery();
		try {
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, Object> row = new HashMap<String, Object>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					row.put(rsmd.getColumnName(i), rs.getObject(i) == null ? ""
							: rs.getObject(i));
				}
				data.add(row);
			}
		} finally {
			rs.close();
			stmt.close();
			closeConnection(conn);
		}
		return data;
	}

	/**
	 * 关闭连接，建议在finally中使�?
	 * 
	 */
	public static void closeConnection(Connection conn) throws SQLException {
		if (conn != null) {
			conn.rollback();
			conn.close();
		}
	}

	/**
	 * 获取配置文件中的solr.url
	 * lazy load
	 * @return
	 * @throws IOException
	 */
	public static String getSolrURL() {
		if ("".equals(solrURL)) {
			Properties prop = new Properties();
			InputStream input = null;
			try {
				input = new FileInputStream(JDBCUtil.class.getResource("/")
						.getPath() + "indexer.properties");
				prop.load(input);
				solrURL = prop.getProperty("solr.url");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (input != null)
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
			}
			return solrURL;
		} else {
			return solrURL;
		}
	}
}
