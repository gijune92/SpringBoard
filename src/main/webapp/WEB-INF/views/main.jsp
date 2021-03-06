<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<script type="text/javascript" src="/resources/Angular/main.js"></script>
		<style>
		</style>
	</head>
	<body data-ng-app="myWeb">
		<div class="container" data-ng-controller="myCtl1">
			<table>
				<thead>
					<tr>
						<th> No </th>
						<th> 제목 </th>
						<th> 작성자 </th>
						<th> 작성시간 </th>
					</tr>
				</thead>
				<tbody data-ng-repeat="row in articles">
					<tr>
						<td>{{ row.no }}</td>
						<td>{{ row.title }}</td>
						<td>{{ row.usrname }}</td>
						<td>{{ row.ctime }}</td>
					</tr>
				</tbody>
			</table>	
		</div>
		<div class="container">
			<c:set var="user" value="${ sessionScope.user }" />
			<c:set var="accountDivision" value="${ sessionScope.accountDivision }" />
			<c:set var="msg" value="${ sessionScope.msg }" />
			
			<c:if test="${ msg != null }" >
				<script> alert("msg, " +  ${msg})</script>
			</c:if>
			
 			<c:if test="${ user eq null }">
				<button type="button" onclick="location.href='/login'"> 로그인 </button>
			</c:if>
			<c:if test="${ user != null }">
				<button type="button" onclick="location.href='/logout'"> 로그아웃 </button>
				<button type="button" onclick="location.href='/i'">글쓰기</button>
				
				<c:if test="${ accountDivision == 9 }">
					<button type="button" onclick="location.href='/accountLog'">접속로그</button>
					<button type="button" onclick="location.href='/downLog'">다운로드로그</button>
					<button type="button" onclick="location.href='/acceptList'">대기자명단</button>
				</c:if>
				
			</c:if>	
		</div>
	</body>
</html>
