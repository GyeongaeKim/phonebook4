<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!-- Maven-pom.xml에 jstl라이브러리 추가해주면 됨 -->


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전화번호부</h1>
	<h2>리스트</h2>
	
	<h3>등록한 정보 내용입니다.</h3>
	
	
	<c:forEach items="${requestScope.personList}" var="personVo"> <!-- requestScope생략가능 -->
	<table border="1">
		<tr>
			<td>이름(name)</td>
			<td>${personVo.name }</td>
		</tr>
		<tr>
			<td>핸드폰(hp)</td>
			<td>${personVo.hp }</td>
		</tr>
		<tr>
			<td>회사(company)</td>
			<td>${personVo.company }</td>
		</tr>
		<tr>
			<td><a href="./updateForm?personId=${personVo.personId }">[수정폼]</a></td>
			<td><a href="./delete/${personVo.personId }">[삭제]</a></td>
			<%-- <a href="./delete?no=${personVo.personId }"> --%>
		</tr>
	</table>
	<br>
	</c:forEach>
	<br>
	<br>
	
	<a href="./writeForm">추가번호 등록</a>
	
	
</body>
</html>