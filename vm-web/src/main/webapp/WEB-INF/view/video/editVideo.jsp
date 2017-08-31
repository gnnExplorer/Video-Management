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
    <title>videoEdit</title>
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
   		td,select,input,textarea{
   			width: 960px;
   			margin-top: 15px;
   		}
   		button{
   			margin-top: 15px;
   		}
   		select{
   			padding: 8px;
   		}
   		th{
   			text-align: right;
   			padding-right: 30px;
   			width: 250px;
   		}
   	</style>
  </head>
  <body>
  	<!-- <div id="all">
  	<div class="container-fluid">
		  		<div class="bs-example" data-example-id="inverted-navbar">
		    	<nav class="navbar navbar-inverse">
		      <div class="container-fluid" id="c">
		        Brand and toggle get grouped for better mobile display
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
		
		        Collect the nav links, forms, and other content for toggling
		        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
		          <ul class="nav navbar-nav">
		            <li class="active"><a href="#">视频管理</a></li>
		            <li><a href="#">主讲人管理</a></li>
		            <li><a href="#">课程管理</a></li>
		            <li><a href="#">统计分析</a></li>
		            <li id="r"><a href="#">admin<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
		          </ul>
		        </div>/.navbar-collapse
		      </div>/.container-fluid
		    </nav>
		  </div>
  	</div>
   	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>编辑视频信息-视频管理</h2>
		</div>
   	</div>
   	</div> -->
  	<!--导航div-->
  	<jsp:include page="/WEB-INF/view/common/header.jsp">
  		<jsp:param value="video" name="fromJsp"/>
  	</jsp:include>
  	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>视频列表-视频管理</h2>
		</div>
   	</div>
   	<div class="container">
   		<form action="<c:url value='/video/editVideo.action' />" method="post">
   			<table>
   				<tr>
   					<th>视频标题</th>
   					<td><input type="text" class="form-control" name="videoTitle" value="${video.videoTitle}"></td>
   				</tr>
   				<tr>
   					<th>主讲人</th>
   					<td>
   						<select name="speakerId">
   							<option value="0">请选择主讲人</option>
   							<c:forEach items="${speakers }" var="vs">
   								<option value="${vs.id }" ${video.speakerId eq vs.id ? "selected" : "" }>${vs.speakerName }</option>
   							</c:forEach>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<th>所属课程</th>
   					<td>
   						<select name="courseId">
   							<option value="0">请选择课程</option>
   							<c:forEach items="${courses }" var="vc">
   								<option value="${vc.id }" ${video.courseId eq vc.id ? "selected" : "" }>${vc.courseName }</option>
   							</c:forEach>
   						</select>
   					</td>
   				</tr>
   				<tr>
   					<th>视频时长</th>
   					<td><input type="text" class="form-control" name="videoLength" value="${video.videoLength}"></td>
   				</tr>
   				<tr>
   					<th>封面图片</th>
   					<td><input type="text" class="form-control" name="videoImageUrl" value="${video.videoImageUrl}"></td>
   				</tr>
   				<tr>
   					<th>视频播放地址</th>
   					<td><input type="text" class="form-control" name="videoUrl" value="${video.videoUrl}"></td>
   				</tr>
   				<tr>
   					<th>视频简介</th>
   					<td><textarea class="form-control" rows="3" name="videoDescr">${video.videoDescr}</textarea></td>
   				</tr>
   				<tr>
   					<th>&nbsp;</th>
   						
   					<td><input type="hidden" name="id" value="${video.id }"  >
   						<button type="submit" class="btn btn-primary">保存</button>
   					  	<a href="javascript:history.go(-1)"><button type="button" class="btn btn-default">返回列表</button></a>
   					</td>
   				</tr>
   			</table>
			
   		</form>
   	</div>
  </body>
</html>