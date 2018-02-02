<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-2.1.1.js"></script>
	<script type="text/javascript" src="js/emp.js"></script>
	<link href="css/emp.css" rel="stylesheet" type="text/css">
</head>
<body>
	<a href="test">Hello</a>
	<br><br>
	<a href="jsonTest.jsp">查询</a>
	<br><br>
	<a href="emp-findAll">查询员工</a>
	<br><br>
	<h4>添加一个员工</h4>
	<form action="emp-add" method="post">
		姓名：<input type="text" name="emp.name"/>
		<br><br>
		年龄：<input type="text" name="emp.age"/>
		<br><br>
		<input type="submit" value="AddEmp"/>
	</form>
</body>
</html>