<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
		<div class="logo">
			<a href="#"><img src="assets/logo.png" alt="" /></a>
		</div>
		<div id="box">
		<%
			String loginuser="";
			if(session.getAttribute("loginuser")!=null)
			{
				loginuser=session.getAttribute("loginuser").toString();
			}
		%>
			欢迎您，<font color="red"><%=loginuser %></font>登陆成功！
			
		</div>
	</div>
	</body>
</html>