<%@page import="Model.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
   <%
	
	Salesman s=new Salesman("1","1","1","1","1","1","1");

	s=(Salesman)request.getSession().getAttribute("salesman");
	

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Update</title>
<!--  
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript">
$(function() {
    //集体调用
    $(".form input").each(function(){
        $(this).setDefauleValue();
    });
    //单个调用
    $("#key").setDefauleValue();
})
 
//设置input,textarea默认值
$.fn.setDefauleValue = function() {
    var defauleValue = $(this).val();
    $(this).val(defauleValue).css("color","#999");
 
    return this.each(function() {      
        $(this).focus(function() {
            if ($(this).val() == defauleValue) {
                $(this).val("").css("color","#000");//输入值的颜色
            }
        }).blur(function() {
            if ($(this).val() == "") {
                $(this).val(defauleValue).css("color","#999");//默认值的颜色
            }
        });
    });
}
</script>
-->
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
<h1>Update</h1>
<hr>
<div align="center" >
<form action="Servlet/SalesmanServlet" name="updateSalesman" method="post">
<!-- 
<input type="hidden" name="action" value="add">
可以再servlet里获取action值为value
 -->
		<table> 
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" value=<%=s.getId() %>/></td>
			</tr>
			
			<td>编号</td>
			<td><input type="text" name="number" value=<%=s.getNumber() %>/></td>
			</tr>
			
			<tr>
			<td>姓名</td>
			<td><input type="text" name="name" value=<%=s.getName() %>/></td>
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
			<td><input type="date" name="birthDate" value=<%=s.getBirthDate()%> /></td>
			</tr>
			<tr>
			
			<tr>
			<td>电话</td>
			<td><input type="text" name="phone" value=<%=s.getPhone() %> /></td>
			</tr>
			<tr>
			
			<tr>
			<td>地址</td>
			<td><input type="text" name="address" value=<%=s.getAddress() %>/> </td>
			</tr>
			<tr>
			
			<tr>
			<td>雇用日期</td>
			<td><input type="date" name="employedDate" value=<%=s.getEmployedDate() %>/></td>
			</tr>
			<tr>
			
			<tr><input type="hidden" name="action" value="update"></tr>
			
			<td colspan="2"><input type="submit" value="提交"></td>
			</tr>
			
		</table>
	</form>
</div>	

</body>
</html>