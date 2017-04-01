package com.boot.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot.dao.impl.ServiceImp;
import com.boot.entity.BaseEntity;
import com.boot.entity.User;
import com.google.gson.Gson;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		System.out.println("user" + username + ",pass" + password);

		BaseEntity entity = BaseEntity.getInstence();
		User bean = User.getInstence();
		//
		ServiceImp serviceImp = ServiceImp.getInstance();
		boolean flag = serviceImp.logService(username, password);
		if (flag) {
			// 登录成功
			entity.setData(bean);
			// System.out.println("登录成功");
		} else {
			// 登录失败
			entity.setData(bean);
			// System.out.println("登录失败");
		}

		// 返回信息到客户端
		// response.setCharacterEncoding("UTF-8");
		// response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String json = gson.toJson(entity);
		out.print(json);
		System.out.println(json);
		// out.print("用户名：" + username);
		// out.print("密码：" + password);
		out.flush();
		out.close();
	}

}
