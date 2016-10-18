<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="Model.*"%>
  
     <% 
      request.setCharacterEncoding("utf-8");
      String username="";
      String password = "";
      Cookie[] cookies = request.getCookies();
      if(cookies!=null&&cookies.length>0)
      {
           for(Cookie c:cookies)
           {
              if(c.getName().equals("username"))
              {
                   username =  URLDecoder.decode(c.getValue(),"utf-8");
              }
              if(c.getName().equals("password"))
              {
                   password =  URLDecoder.decode(c.getValue(),"utf-8");
              }
           }
      }
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>主页</title>
</head>
<body background="image/index.jpg">
<h1 align="center">进销存系统</h1>
<hr>
	欢迎您：  
        <%  
            Users user = (Users)session.getAttribute("Users");  
            if(user != null)  
                out.write(user.getUsername()); 
            else
            	response.sendRedirect(request.getContextPath()+"/login.jsp");
         %>  
         <a href="/Market/login.jsp">登陆</a>  
	
	<form action="Servlet/SalesmanServlet" method="get">
	<a href="Servlet/SalesmanServlet?action=query" align="center">查询</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<a href="add.jsp?action=add" align="center">添加</a>
	<div align="right">
	<input type="text" name="search" value="search">
	<input type="submit" name="action" value="search">
	</div>
	</table>
	</form>
	
</body>
</html>