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
    <title>analysisCourse</title>
    <link href="${pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet"/>
   	<script src="${pageContext.request.contextPath }/js/jquery-1.12.4.min.js" ></script>
   	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js" ></script>
   	<script src="${pageContext.request.contextPath }/js/echarts.js" ></script>
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
   	</style>
   	<script type="text/javascript">
   	window.onload=function(){
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));
        var n = new Array();
        var v = new Array();
        $("input").each(function(i,e){
        	n.push(e.getAttribute("name"));
        	v.push(e.getAttribute("value"));
        });
        /*   var ele=document.getElementsByTagName("input");
         var n = new Array();
        var v = new Array();
     	for(var i=0;i<ele.length;i++){
     		n.push(ele[i].getAttribute("name"));
     		v.push(ele[i].getAttribute("value"));
     	} */
        // 指定图表的配置项和数据
        var option = {
            color:['#7cb5ed'],
        	title: {
                text: '课程平均播放次数',
                subtext: '数据来源:zhiyou100.com',
                sublink:'http://www.zhiyou100.com',
                left: 'center',
                textStyle: {
                    color: '#323232',
                    fontWeight: 'normal',
                    fontSize: 20
                },
                subtextStyle:{
                    color: '#323232'
                }
            },
            legend: {
                y: 'bottom',
                data: ['平均播放次数'],
                textStyle: {
                	color:'#323232',
                    fontSize: 14,
                    fontWeight:'600'
                },
                icon:'circle'
            },
            tooltip: {},
            xAxis: {
                data: n,
                axisLabel: {
                    textStyle: {
                        color: '#888'
                    }
                },
                axisLine: {
                    show: true,
                    lineStyle: {       // 属性lineStyle控制线条样式
                        color: '#cdd7eb',
                        // width: 2,
                        // type: 'solid'
                    }
                }
            },
            yAxis: {
            	 name: '平均播放次数(times)',
                 nameLocation: 'middle',
                 nameGap: 40,
                 nameTextStyle: {
                     color: '#888',
                     //fontSize: 16
                 },
                 axisLine: {
                     show: false
                 },
                 axisTick: {
                     show: false
                 }
            },
            series: [{
                name: '平均播放次数',
                type: 'bar',
                barWidth: '33%',
                data: v
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);}
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
		            <li><a href="#">视频管理</a></li>
		            <li><a href="#">主讲人管理</a></li>
		            <li><a href="<c:url value='/course/viewCourse.action' />">课程管理</a></li>
		            <li class="active"><a href="#">统计分析</a></li>
		            <li id="r"><a href="#">admin<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span></a></li>
		          </ul>
		        </div><!-- /.navbar-collapse -->
		      </div><!-- /.container-fluid -->
		    </nav>
		  </div>
  	</div>
   	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>统计-统计分析</h2>
		</div>
   	</div>
   	</div>
  	<!--导航div--> --%>
  	<jsp:include page="/WEB-INF/view/common/header.jsp">
  		<jsp:param value="analysisCourse" name="fromJsp"/>
  	</jsp:include>
  	<div class="container" id="sc">
		 <div class="jumbotron">
			<h2>统计-统计分析</h2>
		</div>
   	</div>
   	<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 1400px;height:460px; margin:0 auto;padding-left:40px;"></div>
    <c:forEach items="${analysisCourseInfo }" var ="acv">
    	<input type="hidden" name="${acv.courseName }" value="${acv.avgVideoPlayTimes }">
    </c:forEach>
    
  </body>
</html>