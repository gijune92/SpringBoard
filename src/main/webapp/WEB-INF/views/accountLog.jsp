<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 접속 로그 확인 페이지  -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<script>
			if (${sessionScope.accountDivision} != 9){
				alert("잘못된 접근입니다.");
				location.href="/";
			}
		</script>
	</head>
	<body>
		<div class="Container">
			<h1> 접속 정보</h1>
			<table style="text-align:center;">
				<thead>
					<tr>
						<th> 순번 </th>
						<th> ID </th>
						<th> 시간 </th>
						<th>로그인 & 로그아웃</th>
					</tr>
				</thead>
				<tbody>
			<c:forEach var="row" items="${List }" varStatus="status">
				<tr>
					<td>${row.no}</td>
					<td>${row.id}</td>
					<td>${row.ctime}</td>
					<td>${row.IOflag}</td>
				</tr>
			</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="Container">
			<button type="button" onclick="location.href='/'"> 메인으로 </button>
		</div>
	</body>
</html>