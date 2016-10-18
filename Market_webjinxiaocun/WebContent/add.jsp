<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    %>
    
    <%@ page import="Model.*"%>
    <%@page import="java.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8"); 
%>

<!--  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
-->
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Market</title>
</head>
<body background="image/index.jpg">

	欢迎您：  
        <%  
            Users user = (Users)session.getAttribute("Users");  
            if(user != null)  
                out.write(user.getUsername()); 
            else
            	response.sendRedirect(request.getContextPath()+"/login.jsp");
         %>  
         <a href="/Market/login.jsp">登陆</a> 

<% request.setCharacterEncoding("utf-8"); %>
<h1>ADD</h1>
<hr>
<div align="center" >
<form action="Servlet/SalesmanServlet" name="addSalesman" method="post">
<!-- 
<input type="hidden" name="action" value="add">
可以再servlet里获取action值为value
 -->
		<table> 
		<tr>
			<td>编号</td>
			<td><input type="text" name="number"></td>
			</tr>
			
			<tr>
			<td>姓名</td>
			<td><input type="text" name="name"></td>
			</tr>
			
			<tr>
			<td>性别</td>
			<td>
			<input type="Radio" name="sex" value="female">男
			<input type="Radio" name="sex" value="female">女
			</td>
			</tr>
			
			<tr>
			<td>出生日期</td>
			<td><input type="date" name="birthDate"></td>
			</tr>
			<tr>
			
			<tr>
			<td>电话</td>
			<td><input type="text" name="phone"></td>
			</tr>
			<tr>
			
			<tr>
			<td>地址</td>
			<td><input type="text" name="address"></td>
			</tr>
			<tr>
			
			<tr>
			<td>雇用日期</td>
			<td><input type="date" name="employedDate"></td>
			</tr>
			
			<tr><input type="hidden" name="action" value="add"></tr>
			
			<tr>
			<td colspan="2"><input type="submit" name="add" value="提交"></td>
			</tr>
			
		</table>
	</form>
</div>	

</body>
</html>