<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
<table width="100%" height="10%">
        <tr><img src="http://localhost:8080/company/images/1.jpg" width="100%" height="150"></tr>
        <tr><h2 align="right"><a href="mainpage.jsp">首页</a>|<a href="MessageList.jsp">消息列表</a>|<a href="publishNewMeg.jsp">发布新消息</a>|<a href="PrivatePerson.jsp">个人中心</a></h2></tr>
</table>
  <div>
       <p><font color="red">${requestScope.error }</font></p>
       <form action="loginAction" method="get">
         <p>员工编号：<input type="text" name="employeeId"/></p>
         <p>&nbsp;</p>
         <p>系统口令：<input type="text" name="password"/></p>
         <p><input type="submit" value="提交"/><input type="reset" value="重置"/></p>
       </form>
    </div>
</body>
</html>