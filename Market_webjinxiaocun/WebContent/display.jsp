<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ page import="Model.*"%>
    <%@page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>信息显示</title>
 <script language="javascript">
	    function delcfm() {
	        if (!confirm("确认要删除？")) {
	            window.event.returnValue = false;
	        }
	    }
   </script>
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

<div align="center">
<form action="Servlet/SalesmanServlet" method="get">
	<table border="1" cellpadding="10" bgcolor="white">
	<caption>Salesman</caption>
	<br><br>
	
	<a href="Servlet/SalesmanServlet?action=query">查询</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<a href="add.jsp?action=add">添加</a>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	<a href="index.jsp">返回</a>
	

	

		<tr>
			<th>chose</th> <th>Id</th> <th>Number</th> <th>Name</th> <th>Sex</th> <th>BirthDate</th> <th>Phone</th> <th>Address</th> <th>EmployedDate</th> 
		</tr>
<%
	List<Salesman> list = (List<Salesman>)request.getSession().getAttribute("list");
	//List<Salesman> Slist = (List<Salesman>)request.getSession().getAttribute("Slist");
 	if(!list.isEmpty())
	{
		for(Salesman s : list)
		{
%>
			
		<tr>
			<td><input type="radio" name="salesman" /></td>
			<td><%=s.getId() %></td> 
			<td><%=s.getNumber() %></td>
			<td><%=s.getName() %></td>
			<td><%=s.getGender() %></td>
			<td><%=s.getBirthDate() %></td>
			<td><%=s.getPhone() %></td>
			<td><%=s.getAddress() %></td>
			<td><%=s.getEmployedDate() %></td>
			<td><a href="Servlet/SalesmanServlet?action=delete&id=<%=s.getId()%>" onclick="delcfm();">删除</a></td>
			<td><a href="Servlet/SalesmanServlet?action=update&id=<%=s.getId()%>" >更改</a></td>
		</tr>
			
<%
		}
	}
%>
	
	</table>
	
	<!-- 
	<input type="hidden" name="action" value="search">
	<input type="submit" name="QUERY" value="查询" />
	<input type="submit" name="REMOVE" value="删除" />
	 -->
</form>
</div>


</body>
</html>