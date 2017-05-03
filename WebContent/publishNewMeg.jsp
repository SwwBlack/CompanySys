<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>PublishNewMeg</title>
<style type="text/css">
   .input{FONT-SIZE: 9pt;
BORDER-BOTTOM: 0px
color: #996600;
background-color: #6690BD;
border: 1px solid #54697B;
color: #FFFFFF;
height: 100px;
width: 500px;}
</style>
</head>
<body>
<table width="100%" height="10%">
        <tr><img src="http://localhost:8080/company/images/1.jpg" width="100%" height="150"></tr>
        <tr><h2 align="right"><a href="mainpage.jsp">首页</a>|<a href="MessageList.jsp">消息列表</a>|<a href="publishNewMeg.jsp">发布新消息</a>|<a href="PrivatePerson.jsp">个人中心</a></h2></tr>
</table>
  <div id="messageBox">
     <p><font color="red">${requestScope.error }</font></p>
     <form action="MsgPublish" method="post">
        <p>消息标题：<input type="text" size="50" name="title"/></p>
        <p>消息内容：</p>
         <p><input name="content" type="text" class="input"></p>
         <p><input type="submit" value="发表"/>&nbsp&nbsp<input type="reset" value="重置"/></p>
     </form>
  </div>  
</body>
</html>