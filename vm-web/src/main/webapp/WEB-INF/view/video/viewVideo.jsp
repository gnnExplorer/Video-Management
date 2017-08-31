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
    <title>videoList</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js" ></script>
   	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" ></script>
  	<style type="text/css">
  		/* #sc{
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
  		} */
  		
  		form#searchId{
  			display: inline-block;
  		}
  		.a,.g,.h,.i{
  			width: 45px;
  		}
  		.b,.d,.e,.f{
  			width: 100px;
  		}
  		form#searchId{
  			position: absolute;
  			margin-left: 410px;
  			
  		}
  		input,select{
  			height: 30px;
  		}
  		
  		
  		
  	</style>
  	<script type="text/javascript">
  	   
	  	/* function selectAll(theCheck) {
	  	
	  		var arr = document.getElementsByName("rowCheck");
	  		var element= document.getElementById("dv");
	  		for(var i = 0; i < arr.length; i++){
	  			arr[i].checked = theCheck.checked;
	  		}
	  		if(theCheck.checked){
		  		element.innerHTML = arr.length-1;
	  		}else{
		  		element.innerHTML = 0 ;
	  		}
	  		
	  		for(var i = 0; i < arr.length; i++){
	  			if(arr[i].checked){
	  				++num;
	  			}
	  		}
	  		element.innerHTML = num-1;
	  	}
	  	
	  	function getSelectedNum() {
	  		var num=0;
	  		var arr = document.getElementsByName("rowCheck");
	  		var element= document.getElementById("dv");
	  		for(var i = 0; i < arr.length; i++){
	  			if(arr[i].checked){
	  				++num;
	  			}
	  		}
	  		if(document.getElementById("sl").checked){
	  			element.innerHTML = num-1;
	  		}else{
	  			element.innerHTML = num;
	  		}
	  	}*/
	  	
	  	function multiDelete() {
	  		var url='multiDeleteVideo.action?';
	  		var arr = document.getElementsByName("rowCheck");
		  		for(var i = 0; i < arr.length; i++){
		  			if(arr[i].checked){
		  				//alert(arr[i].id);
		  				var url = url + 'id'+i+'='+arr[i].id+'&'; 
		  				location.href =url; 
		  			}
		  		}
		} 
		
		//jquery
		var num=0;
		$(function(){
  			
	  		$("#sl").click(function() {
	  			
	  		});
	  		
	  		
	  		$("input[name='rowCheck']").click(function(){
	  			if((this).prop("checked")){
	  				++num;
	  			}else{
	  				--num;
	  			}
	  			$(".badge").text(num);
	  			
	  		});
	  		
  			
  			
  		});
		
		
	  	
  	</script>
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
		            <li class="active"><a href="#">视频管理</a></li>
		            <li><a href="<c:url value='/speaker/viewSpeaker.action' />">主讲人管理</a></li>
		            <li><a href="<c:url value='/course/viewCourse.action' />">课程管理</a></li>
		            <li><a href="#">统计分析</a></li>
		            <li id="r"><a href="#" id="ll">${admin.loginName }</a><a id="lr" href="${pageContext.request.contextPath }/admin/exitAdmin.action"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
		          </ul>
		        </div><!-- /.navbar-collapse -->
		      </div><!-- /.container-fluid -->
		    </nav>
		  </div>
  	</div>
   	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>视频列表-视频管理</h2>
		</div>
   	</div>
   	</div>
  	<!--导航div--> --%>
  	<jsp:include page="/WEB-INF/view/common/header.jsp">
  		<jsp:param value="video" name="fromJsp"/>
  	</jsp:include>
  	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>视频列表-视频管理</h2>
		</div>
   	</div>
   	<div class="container">
   		<a href='<c:url value="/video/addVideo.action"  />'><button type="button" class="btn btn-primary">添加视频</button></a>
   		<button class="btn btn-primary" type="button" onclick="multiDelete()" >批量删除 <span class="badge" id="dv">0</span></button>
   		<form action="${pageContext.request.contextPath }/video/viewVideo.action" method="post" id="searchId">
   			<input type="text" placeholder="视频标题" name="keyword" value="${keyword }" />
   			<select name="sn">
   				<option value="s">请选择主持人</option>
   				<c:forEach items="${csv.sl }" var="sv">
   					<option ${sn eq sv.speakerName ? "selected" : "" }>${sv.speakerName }</option>
   				</c:forEach>
   			</select>
   			<select name="cn">
   				<option value="s">请选择课程</option>
   				<c:forEach items="${csv.cl }" var="cv">
   					<option ${cn eq cv.courseName ? "selected" : "" }>${cv.courseName }</option>
   				</c:forEach>
   			</select>
   			<button type="submit" class="btn btn-primary">查询</button>
   		</form>
    <table class="table table-hover">
      <thead>
        <tr>
       	<th class="i"><input type="checkbox" id="sl"></th>
          <th class="a">序号</th>
          <th class="b">名称</th>
          <th class="c">介绍</th>
          <th class="d">讲师</th>
          <th class="b">课程</th>
          <th class="e">时长(秒)</th>
          <th class="f">播放次数</th>
          <th class="g">编辑</th>
          <th class="h">删除</th>
        </tr>
        
      </thead>
      <tbody>
      <c:forEach items="${csv.vl }" var="vv" varStatus="vs">
        <tr>
        	<td><input type="checkbox" name="rowCheck" id="${vv.id }"></td>
          <td>${vs.count + (page.page-1)*10}</td>
          <td>${vv.videoTitle }</td>
          <td>${vv.videoDescr }</td>
          <td>${vv.speakerName }</td>
          <td>${vv.courseName }</td>
          <td>${vv.videoLength }</td>
          <td>${vv.videoPlayTimes }</td>
          <td><a href='<c:url value="/video/editVideo.action?id=${vv.id }" />'><span class="glyphicon glyphicon-edit" aria-hidden="true"></span></a></td>
          <td><a href='<c:url value="/video/deleteVideo.action?id=${vv.id }" />'><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
        </tr>
        </c:forEach>  
      </tbody>
    </table>
    <fy:page url="${pageContext.request.contextPath }/video/viewVideo.action"></fy:page>
   	</div>
  </body>
</html>