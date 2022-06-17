<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>수정폼2</h2>
	<p>수정화면입니다. 아래의 항목을 수정하고 "수정"버튼을 클릭하세요</p>
	
	<form action="/phonebook4/update" method="get">
		이름(name) <input type="text" name="name" value="${pMap.NAME }"><br>
		핸드폰(hp) <input type="text" name="hp" value="${pMap.HP }"><br>
		회사(company) <input type="text" name="company" value="${pMap.COMPANY }"><br>
		pk(personId) <input type="text" name="personId" value="${param.no }"><br>
		
		<br>
		<button type="submit">수정</button>
	</form>
	
</body>
</html>