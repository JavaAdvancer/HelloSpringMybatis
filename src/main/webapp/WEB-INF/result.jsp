<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>员工信息</title>
</head>
<body>
	
	<s:if test="#session.emps == null || #session.emps.size() == 0">
		没有员工信息。。。
	</s:if>
	<s:else>
		<table border="1" cellspacing="0px" cellpadding="10px">
			<tr class="head">
				<td>ID</td>
				<td>NAME</td>
				<td>AGE</td>
				<td>DELETE</td>
				<td>EDIT</td>
			</tr>
			<s:iterator value="#session.emps">
				<tr>
					<td>${id }</td>
					<td>${name }</td>
					<td>${age }</td>
					<td><a href="emp-delete?id=${id }">Delete</a></td>
					<td><a href="emp-edit?id=${id }">Edit</a></td>
				</tr>
			</s:iterator>
		</table>
	</s:else>
	
</body>
</html>