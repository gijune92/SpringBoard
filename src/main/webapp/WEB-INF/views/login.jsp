<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function cancle(){
		
	}
</script>
</head>
<body>
<form method="post" action="/loginAccept">
	<h1>LOG IN</h1>
	<label>ID : </label>
	<input type="text" name="id">
	<label>Password : </label>
	<input type="password" name="pw">
	<button type="button"> Login </button>
	<button type="button" onclick="cancel()"> Cancel </button>
	<button type="button" onclick="location.href='/newAccount'"> 회원가입 </button>
</form>
</body>
</html>