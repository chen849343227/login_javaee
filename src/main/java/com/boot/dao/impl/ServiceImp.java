package com.boot.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.boot.dao.Service;
import com.boot.entity.BaseEntity;
import com.boot.entity.User;
import com.boot.utils.DBUtils;
import com.boot.utils.DaYuService;

public class ServiceImp implements Service {

	private static ServiceImp service;

	// 获取实体类的单例对象，方便传数据
	BaseEntity<User> baseEntity = BaseEntity.getInstence();
	User bean = User.getInstence();

	// 获取DB的实例
	DBUtils db = DBUtils.createInstance();

	public ServiceImp() {

	}

	public static ServiceImp getInstance() {
		if (service == null) {
			service = new ServiceImp();
		}
		return service;
	}

	/**
	 * 注册用户,注册的时候先查找用户，如果用户存在数据库，则说明用户已注册
	 */
	@Override
	public boolean regService(String user, String pass) {
		// TODO Auto-generated method stub
		String sql = "select  *  from Login.user where user_name   = '" + user + "'";
		String regSql = "insert into user (user_name,user_pwd) values('" + user + "','" + pass + "') ";
		// 打开数据库
		db.openDB();
		// 操作DB对象
		try {
			ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				// 说明用户已注册
				System.out.println(rs.getString("user_name"));
				baseEntity.setCode(-1);
				baseEntity.setMsg("注册失败，账号已注册");
				bean.setId(rs.getInt("user_id"));
				return false;
			}
			db.executeUpdate(regSql);
			baseEntity.setCode(0);
			baseEntity.setMsg("注册成功");
			bean.setId(0);
			bean.setUser(user);
			bean.setPass(pass);
			baseEntity.setData(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDB();
		return true;
	}

	/**
	 * 登录对账号和密码进行判断(首先判断账号是否存在，再判断密码是否正确)
	 */
	@Override
	public boolean logService(String user, String pass) {
		// 获取Sql查询语句
		String sql = "select * from user where user_name   = '" + user + "'";
		db.openDB();
		try {
			ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				// 说明用户存在
				if (rs.getString("user_pwd").equals(pass)) {
					baseEntity.setCode(0);
					baseEntity.setMsg("登录成功");
					bean.setUser(user);
					bean.setPass(pass);
					bean.setId(rs.getInt("user_id"));
					baseEntity.setData(bean);
					return true;
				} else {
					baseEntity.setCode(-1);
					baseEntity.setMsg("登录失败，密码错误");
					bean.setUser("");
					bean.setPass("");
					bean.setId(rs.getInt("user_id"));
					baseEntity.setData(bean);
					return false;
				}
			}
			// 用户不存在
			baseEntity.setCode(-1);
			baseEntity.setMsg("登录失败，账号不存在。");
			bean.setId(0);
			bean.setUser("");
			bean.setPass("");
			baseEntity.setData(bean);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.closeDB();
		}
		return false;
	}

	/**
	 * 请求验证码，先查找用户，如果用户存在数据库，则说明用户已注册
	 */
	@Override
	public boolean requestCodeService(String phone) {
		String sql = "select  *  from Login.user where user_name   = '" + phone + "'";
		// 打开数据库
		db.openDB();
		// 操作DB对象
		try {
			ResultSet rs = db.executeQuery(sql);
			if (rs.next()) {
				// 说明用户已注册
				System.out.println(rs.getString("user_name"));
				baseEntity.setCode(-1);
				baseEntity.setMsg("账号已注册");
				bean.setId(rs.getInt("user_id"));
				return false;
			}
			baseEntity.setCode(0);
			baseEntity.setMsg("发送成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.closeDB();
		return DaYuService.requestSmsCode(phone);
	}
}
