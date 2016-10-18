
<%@ page language="java" import="java.util.*,java.net.*" contentType="text/html; charset=utf-8"%>
<%
   String path = request.getContextPath();
   String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<!-- Page title -->
		<title> Login</title>
		<!-- End of Page title -->
		<!-- Libraries -->
		
		<link type="text/css" href="css/login.css" rel="stylesheet" />	
		<link type="text/css" href="css/smoothness/jquery-ui-1.7.2.custom.html" rel="stylesheet" />	
		<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
		<script type="text/javascript" src="js/easyTooltip.js"></script>
		<script type="text/javascript" src="js/jquery-ui-1.7.2.custom.min.js"></script>
		
		<!-- End of Libraries -->	
		<!-- Bootstrap -->
    	<link href="css/bootstrap.min.css" rel="stylesheet">

    	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    	<!--[if lt IE 9]>
      <script src="//cdn.bootcss.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="//cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    	<![endif]-->
	</head>  
	<body background="image/index.jpg">
	<h1>用户登录</h1>
    <hr>
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
	<div id="container">
		<div class="logo">
			<a href="#"><img src="image/l.jpg" alt="" width="2000" height="100"/></a>
		</div>
		<br><br><br><br><br><br>
		
		<div id="box" align="center">
			<form action="dologin.jsp" method="post">
			<p class="main">
				<!--  
				<div class="input-group input-group-lg">
  				<span class="input-group-addon" id="sizing-addon1">用户名</span>
  				<input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
				</div>
				<div class="input-group input-group-lg">
  				<span class="input-group-addon" id="sizing-addon1">密码</span>
  				<input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
				</div>
				--> 
				<label>用户名: </label>
				<input name="username" value="" /> 
				<br><br>
				<label>密码: </label>
				<input type="password" name="password" value="">
				
			</p>
			<p class="space">
				<!--  <input type="submit" value="登录" class="login" style="cursor: pointer;"/>-->
				 <input type="submit" value="登录" class="login" style="cursor: pointer;"/>
				 <input type="reset" value="取消" class="login" style="cursor: pointer;"/>
			</p>
			 <tr>
           <td colspan="2"><input type="checkbox" name="isUseCookie" checked="checked"/>十天内记住我的登录状态</td>
         	</tr>
         	
         
         	
			</form>
		</div>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
	</body>
</html>