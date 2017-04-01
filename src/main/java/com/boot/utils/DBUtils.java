package com.boot.utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtils {

	private static final String URL = "jdbc:mysql://localhost:3306/Login?useUnicode=true&characterEncoding=UTF-8";

	private static final String USER = "root";

	private static final String PASS = "960930";

	private static final String DRIVER = "com.mysql.jdbc.Driver";

	private static DBUtils utils;

	java.sql.Connection conn = null;

	java.sql.Statement sm = null;

	ResultSet rs;

	private DBUtils() {
	}

	/**
	 * 单例对象
	 * 
	 * @return
	 */
	public static DBUtils createInstance() {
		if (utils == null) {
			utils = new DBUtils();
			utils.initDB();
		}
		return utils;
	}

	/**
	 * 加载数据库驱动
	 */
	public void initDB() {
		try {
			Class.forName(DRIVER);
			System.out.println("加载驱动成功");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 打开数据库
	 */
	public void openDB() {
		try {
			conn = DriverManager.getConnection(URL, USER, PASS);
			sm = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("连接成功");
	}

	/**
	 * 关闭数据库
	 */
	public void closeDB() {
		try {
			if (sm != null) {
				sm.close();
			}
			if (conn != null) {
				conn.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询数据库
	 */
	public ResultSet executeQuery(String sql) {
		rs = null;
		try {
			rs = sm.executeQuery(sql);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return rs;
	}

	/**
	 * 数据库的增删改
	 */
	public int executeUpdate(String sql) {
		int ret = 0;
		try {
			ret = sm.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
