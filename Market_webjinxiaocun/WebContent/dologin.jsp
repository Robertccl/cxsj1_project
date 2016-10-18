<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <jsp:useBean id="loginUser" class="Model.Users" scope="page"/>
    <jsp:useBean id="userDAO" class="Operate.UserDAO" scope="page"/>
    <jsp:setProperty property="*" name="loginUser"/>
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	/* String username="";
	String password="";
	request.setCharacterEncoding("utf-8");
	
	username=request.getParameter("username");
	password=request.getParameter("password");
	if("admin".equals(username)&&"admin".equals(password))
	{
		session.setAttribute("loginuser", username);
		request.getRequestDispatcher("login_success.jsp").forward(request, response);
	}
	else
	{
		response.sendRedirect("login_failure.jsp");
	} */
	if(userDAO.userLogin(loginUser))
	{
		//session.setAttribute("loginUser", loginUser.getUsername());
		request.getSession().setAttribute("Users", loginUser);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	else
	{
		response.sendRedirect("login_failure.jsp");
	}
	
%>