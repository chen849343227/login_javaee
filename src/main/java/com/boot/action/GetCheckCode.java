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
import com.boot.entity.UserSms;
import com.google.gson.Gson;

/**
 * Servlet implementation class GetCheckCode
 */
public class GetCheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Gson gson = new Gson();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCheckCode() {
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
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		String phone = request.getParameter("phone");
		BaseEntity<User> entity = BaseEntity.getInstence();
		User bean = User.getInstence();

		UserSms sms = new UserSms();
		sms.setPhone(phone);
		ServiceImp serviceImp = ServiceImp.getInstance();
		boolean flag = serviceImp.requestCodeService(phone);
		if (flag) {
			// 发送成功
			bean.setId(0);
			bean.setUser("");
			bean.setPass("");
			entity.setData(bean);
			System.out.println("发送成功");
		} else {
			// 发送失败
			entity.setData(bean);
			System.out.println("发送失败");
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
