<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>핸드폰 주소록</title>
</head>
<body>
	<table border = "1">
		<tr>
			<th>이름</th>
			<th>번호</th>
		</tr>
		<tr>
			<td>정범석</td>
			<td>01065293557</td>
		</tr>
		<tr>
			<td>한수형</td>
			<td>01096069292</td>
		</tr>
		<tr>
			<td>윤성이형</td>
			<td>01026388378</td>
		</tr>
		<tr>
			<td>정민석</td>
			<td>01033880586</td>
		</tr>	
	</table>
	<br>
	<form action="/hi"method="post">
		<label>
			핸드폰 번호 입력<br>
			<input type="text" name="phoneNumber">
		</label>
	</form>
</body>
</html>