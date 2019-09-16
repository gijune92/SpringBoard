<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="/account">
		<h1>회원 가입</h1>
		<label>ID : </label>
		<input type="text">
		<label>Password : </label>
		<input type="password">
		<button type="button"> 가입 </button>
		<button type="button" onclick="location.href='/'"> 취소 </button>
	</form>
</body>
</html>