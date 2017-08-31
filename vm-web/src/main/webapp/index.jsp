<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>index</title>
    <!--<link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>-->
    <link href="<c:url value="/css/bootstrap.min.css"/>" rel="stylesheet"/>
   	<script src="<c:url value="/js/jquery-1.12.4.min.js"/>" ></script>
   	<script src="<c:url value="/js/bootstrap.min.js"/>" ></script>
   	<script src="<c:url value="/js/jquery.validate.min.js"/>" ></script>
   	<script src="<c:url value="/js/messages_zh.min.js"/>" ></script>
  </head>
  <style type="text/css">
  	form{
  		margin-top: 300px;
  		text-align: center;
  	}
  	img, button{
  		width:255px;
  	}
  	input,button{
  		margin-top: 10px;
  	}
  </style>
  <script type="text/javascript">
  $(function(){
	  $("#checkForm").validate({
		  rules:{
			  loginName:{
				 required:true
			  },
			  loginPwd:{
				  required:true
			  }/* ,
			  reLoginPwd:{
				  required:true,
				  equalTo:"input[name='loginPwd']"
			  } */
			  
		  },
		  messages:{
			  loginName:{
					 required:"请输入用户名"
				  },
				  loginPwd:{
					  required:"请输入密码"
				  }/* ,
				  reLoginPwd:{
					  required:"请输入确认密码",
					  equalTo:"密码不一致"
				  } */
		  }
		  
		  
	  });
  });
  
  </script>
  <body>
   	<div class="container">
   		<form class="form-horizontal" action='<c:url value="/admin/login.action"/>'  method="post" id="checkForm" >
   			<div class="row col-md-3 col-md-offset-4">
  				<img src="<c:url value="/img/logo.png"/>"/>
  				<input type="text" class="form-control" name="loginName" placeholder="用户名">
  				<input type="password" class="form-control" name="loginPwd" placeholder="密码">
  			<!-- 	<input type="password" class="form-control" name="reLoginPwd" placeholder="确认密码"> -->
  				<button type="submit" class="btn btn-success">登录</button>
  				<p style="color: red;">${ErrorMessage }</p>
			</div>
		</form>
   	</div>
  </body>
</html>