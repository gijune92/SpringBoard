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
		<div>
			<label>ID : </label>
			<input type="text" name="id">
		</div>
		<div>
			<label>Password : </label>
			<input type="password" name="pw">
		</div>
		<div>
			<label> Name : </label>
			<input type="text" name="name">
		</div>
		<div>
			<label>Addr : </label>
			<input type="text" name="addr">
		</div>
		<div>
			<label> 구분 :  </label>
			<input type="radio" name="accountDiv" value="1">학생
			<input type="radio" name="accountDiv" value="3">강사
			<input type="radio" name="accountDiv" value="5">관리자
		</div>
		<div>
			<button type="submit"> 가입 </button>
			<button type="button" onclick="location.href='/login'"> 취소 </button>
		</div>
	</form>
</body>
</html>