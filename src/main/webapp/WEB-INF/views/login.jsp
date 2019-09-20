<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<c:if test='${sessionScope.msg == "등록된 사용자가 없습니다." }'>
	<script>console.log(${sessionScope.msg})</script>
</c:if>


<form method="post" action="/loginAccept">
	<h1>LOGIN</h1>
	<label>ID : </label>
	<input type="text" name="id">
	<label>Password : </label>
	<input type="password" name="pw">
	<button type="submit"> Login </button>
	<button type="button" onclick="location.href='/'"> Cancel </button>
	<button type="button" onclick="location.href='/newAccount'"> 회원가입 </button>
</form>
</body>
</html>