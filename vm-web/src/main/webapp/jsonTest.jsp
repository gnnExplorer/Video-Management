<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

window.onload=function(){
	var jsonObj={"name":"兰博基尼","price":500000};
	
	alert(JSON.stringify(jsonObj));
	
	var car=[{"name":"兰博基尼","price":500000},{"name":"宝马","price":600000}];
	
	alert(car[1].name);
	
	var people={"name":"张三","cars":[{"name":"兰博基尼","price":500000},{"name":"宝马","price":600000}],"friend":{"name":"张三","age":35}};
	alert(people.name+"--"+people.cars[0].name);
	
}

</script>
</head>
<body>

</body>
</html>