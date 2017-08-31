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
    <title>speakerAdd</title>
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
   		td,input,textarea{
   			width: 1300px;
   			margin-top: 15px;
   		}
   		button{
   			margin-top: 15px;
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
		            <li><a href="#">视频管理</a></li>
		            <li class="active"><a href="#">主讲人管理</a></li>
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
			<h2>编辑主讲人-主讲人管理</h2>
		</div>
   	</div>
   	</div> -->
  	<!--导航div-->
  	<jsp:include page="/WEB-INF/view/common/header.jsp">
  		<jsp:param value="speaker" name="fromJsp"/>
  	</jsp:include>
  	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>主讲人列表-主讲人管理</h2>
		</div>
   	</div>
   	<div class="container">
   		<form action="" method="post">
   			<table>
   				<tr>
   					<th>名字</th>
   					<td><input type="text" class="form-control" placeholder="主讲人姓名" name="speakerName"></td>
   				</tr>
   				<tr>
   					<th>职业</th>
   					<td><input type="text" class="form-control" placeholder="主讲人职业" name="speakerJob"></td>
   				</tr>
   				<tr>
   					<th>头像图片</th>
   					<td><input type="text" class="form-control" placeholder="主讲人头像地址,网络图片" name="speakerHeadUrl"></td>
   				</tr>
   				<tr>
   					<th>简介</th>
   					<td><textarea class="form-control" rows="3" name="speakerDescr"></textarea></td>
   				</tr>
   				<tr>
   					<th>&nbsp;</th>
   					<td><button type="submit" class="btn btn-primary">保存</button>
   					  	<button type="button" class="btn btn-default">返回列表</button>
   					</td>
   				</tr>
   			</table>
			
   		</form>
   	</div>
  </body>
</html>