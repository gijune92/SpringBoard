<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>대기자 명단</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script type="text/javascript" src="/resources/Angular/acceptList.js"></script>
	</head>
	<body>
	<h1>대기자 명단</h1>
		<div>
			<table>
				<thead>
					<tr>
						<th> 선택 </th>
						<th> 순번 </th>
						<th> ID </th>
						<th> 이름 </th>
						<th> 주소 </th>
						<th> 권한 </th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		<div>
			<button type="button" id="selectBtn">승인</button>
			<button type="button" onclick="location.href='/'">취소</button>
		</div>
		</div>
	</body>
</html>