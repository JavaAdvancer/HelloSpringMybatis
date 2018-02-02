<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>修改信息</h4>
	<form action="emp-update" method="post">
		ID：<input readonly type="text" value="${emps.id }" name="emp.id"/>
		<br><br>
		姓名：<input type="text" value="${emps.name }" name="emp.name"/>
		<br><br>
		年龄：<input type="text" value="${emps.age }" name="emp.age"/>
		<br><br>
		<input type="submit" value="updateEmp"/>
	</form>
</body>
</html>