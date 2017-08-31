<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<%-- <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js" ></script>
<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" ></script> --%>

<style type="text/css">
  		#sc{
   			margin-top: -70px;
   		}
   		#c{
   			padding-left: 375px;
   		}
   		#r{
   			margin-left: 570px;
   		}
  		#ll,#lr{
  			display: inline-block;
  			margin-right: -20px;
  		}
  		
  		
  	</style>
</head>
<body>
<div id="all">
  	<div class="container-fluid">
		  		<div class="bs-example" data-example-id="inverted-navbar">
		    	<nav class="navbar navbar-inverse">
		      <div class="container-fluid" id="c">
		        <!-- Brand and toggle get grouped for better mobile display -->
		        <div class="navbar-header">
		          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false">
		            <span class="sr-only">Toggle navigation</span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		            <span class="icon-bar"></span>
		          </button>
		          <a class="navbar-brand" href="#">视频管理系统</a>
		        </div>
		
		        <!-- Collect the nav links, forms, and other content for toggling -->
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
		          <ul class="nav navbar-nav">
		            <li ${param.fromJsp=="video" ? "class='active'" : "" }><a href="<c:url value='/video/viewVideo.action' />">视频管理</a></li>
		            <li ${param.fromJsp=="speaker" ? "class='active'" : "" }><a href="<c:url value='/speaker/viewSpeaker.action' />">主讲人管理</a></li>
		            <li ${param.fromJsp=="course" ? "class='active'" : "" }><a href="<c:url value='/course/viewCourse.action' />">课程管理</a></li>
		            <li ${param.fromJsp=="analysisCourse" ? "class='active'" : "" }><a href="<c:url value='/course/analysisCourse.action' />">统计分析</a></li>
		            <li id="r"><a href="#" id="ll">${admin.loginName }</a><a id="lr" href="${pageContext.request.contextPath }/admin/exitAdmin.action"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
		          </ul>
		        </div><!-- /.navbar-collapse -->
		      </div><!-- /.container-fluid -->
		    </nav>
		  </div>
  	</div>
   
   	</div>
  	<!--导航div-->
</body>
</html>