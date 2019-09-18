<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>대기자 명단</title>
		<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/Angular/acceptList.js"></script>
	</head>
	<body data-ng-app="accountList">
	<h1>대기자 명단</h1>
		<div data-ng-controller="ListControl">
			<table>
				<thead>
					<tr>
						<th>선택</th>
						<th> 순번 </th>
						<th> ID </th>
						<th> 이름 </th>
						<th> 주소 </th>
						<th> 권한 </th>
					</tr>
				</thead>
				<tbody data-ng-repeat="row in list">
					<tr>
						<td><input type="checkbox" name=choose data-ng-model="row.check"></td>
						<td>{{ $index+1 }} </td>
						<td>{{ row.id }}</td>
						<td>{{ row.name }}</td>
						<td>{{ row.addr }}</td>
						<td data-ng-if="1 == row.accountDivision"> 학생 </td>
						<td data-ng-if="3 == row.accountDivision"> 강사 </td>
						<td data-ng-if="5 == row.accountDivision"> 관리자 </td>
					</tr>
				</tbody>
			</table>
		<div>
			<button type="button" id="selectBtn" data-ng-click="accept(row)">승인</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</div>
		</div>
	</body>
</html>