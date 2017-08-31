<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fy" uri="http://zhiyou100.com/common/" %>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>viewCourse</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js" ></script>
   	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" ></script>
   	<style type="text/css">
   		#sc{
   			margin-top: -70px;
   		}
   		#c{
   			padding-left: 375px;
   		}
   		#r{
   			margin-left: 590px;
   		}
   		.a,.e,.f{
   			width: 45px;
   		}
   		.b,.c{
   			width: 100px;
   		}
   	</style>
  </head>
  <body>
  	<%-- <div id="all">
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
		            <li><a href='<c:url value="/video/viewVideo.action" />'>视频管理</a></li>
		            <li><a href="<c:url value='/speaker/viewSpeaker.action' />">主讲人管理</a></li>
		            <li class="active"><a href="#">课程管理</a></li>
		            <li><a href="<c:url value='/course/analysisCourse.action' />">统计分析</a></li>
		            <li id="r"><a href="#">admin<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
		          </ul>
		        </div><!-- /.navbar-collapse -->
		      </div><!-- /.container-fluid -->
		    </nav>
		  </div>
  	</div>
   	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>课程列表-课程管理</h2>
		</div>
   	</div>
   	</div>
  	<!--导航div--> --%>
  	<jsp:include page="/WEB-INF/view/common/header.jsp">
  		<jsp:param value="course" name="fromJsp"/>
  	</jsp:include>
  	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>课程列表-课程管理</h2>
		</div>
   	</div>
   	<div class="container">
   		<a href='<c:url value="/course/addCourse.action" />'><button type="button" class="btn btn-primary">添加课程</button></a>
    <table class="table table-hover">
      <thead>
        <tr>
          <th class="a">序号</th>
          <th class="b">标题</th>
          <th class="c">学科</th>
          <th class="d">简介</th>
          <th class="e">编辑</th>
          <th class="f">删除</th>
        </tr>
      </thead>
      <tbody>
      <c:forEach items="${page.rows }" var="v" varStatus="vs">
        <tr>
          <th>${vs.count +(page.page-1)*10 }</th>
          <td>${v.courseName }</td>
          <td>${v.subjectName }</td>
          <td>${v.courseDescr }</td>
          <td><a href="<c:url value="/course/editCourse.action?id=${v.id }" />"><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
          <td><a href="<c:url value='/course/deleteCourse.action?id=${v.id }' />"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
      </tr>
       </c:forEach>  
      </tbody>
    </table>
    <fy:page url="${pageContext.request.contextPath }/course/viewCourse.action"></fy:page>
   	</div>
  </body>
</html>