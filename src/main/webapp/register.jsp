<%@page contentType="text/html; charset=gb2312" language="java" import="java.util.*,java.io.*"%>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">  
</head>  
<body>  
<center>  
  <h1>注册新用户</h1>  
  <form action="adduser.jsp" method=post>  
  <table border="1" bgcolor="#0099CC">  
    <tr>  
      <td>        用户名:  
        <input type="text" name="userid">  
      </td>  
    </tr>  
    <tr valign="middle">  
      <td>        密码：  
        <input type="password" name="password" readonly>  
      </td>  
    </tr>  
    <tr>  
      <td>  
        <input type=submit value=提交>  
      </td>  
    </tr>  
  </table>  
  </form>  
</center>  
</body>  
