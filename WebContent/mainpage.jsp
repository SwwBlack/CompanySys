<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MainPage</title>
<style type="text/css">
  #contain{width:100%;}
  #left{float:left;width:40%;}
  #right{float:right;width:60%}
</style>
</head>
<body>
   <table width="100%" height="10%">
        <tr><img src="http://localhost:8080/company/images/1.jpg" width="100%" height="150"></tr>
        <tr><h2 align="right"><a href="mainpage.jsp">首页</a>|<a href="MessageList.jsp">消息列表</a>|<a href="publishNewMeg.jsp">发布新消息</a>|<a href="PrivatePerson.jsp">个人中心</a></h2></tr>
</table>
    <div id="contain">
   <div align="left" id="left">
       <c:choose>
          <c:when test="${empty sessionScope.employee }">
              没有进行身份识别，请先进行身份识别
          </c:when>
          <c:otherwise>
             <ul>
               <li>员工编号：${employee.employeeId }</li>
               <li>员工姓名：${employee.employeeName }</li>
               <li>员工性别：${employee.employeeSex }</li>
               <li>出生日期：${employee.employeeBirth }</li>
               <li>办公室电话：${employee.employeePhone }</li>
               <li>住址：${employee.employeePlace }</li>
               <li>管理层：${employee.isLead }</li>
             </ul>
          </c:otherwise>
       </c:choose>
   </div>
   <div align="right" id="right">
      <p>哈哈
   </div>
   </div>
</body>
</html>