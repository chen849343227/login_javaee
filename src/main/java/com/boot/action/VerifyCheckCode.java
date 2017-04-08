package com.boot.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.boot.entity.BaseEntity;
import com.boot.entity.User;
import com.boot.entity.UserSms;
import com.google.gson.Gson;

/**
 * Servlet implementation class VerifyCheckCode
 */
public class VerifyCheckCode extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Gson gson = new Gson();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyCheckCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		BaseEntity<User> entity = BaseEntity.getInstence();
		User bean = User.getInstence();
		UserSms sms = UserSms.getInstance();
		System.out.println(sms.getCode());
		String code = request.getParameter("code");
		System.out.println(code.toString());
		
		if(code.equals(sms.getCode())){
			bean.setId(0);
			bean.setUser("");
			bean.setPass("");
			entity.setCode(0);
			entity.setMsg("验证码正确");
			entity.setData(bean);
		}else {
			bean.setId(0);
			bean.setUser("");
			bean.setPass("");
			entity.setCode(-1);
			entity.setMsg("验证码错误");
			entity.setData(bean);
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
