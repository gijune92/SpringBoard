<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--
 < 게시글 보기 페이지 > 
	1. 1개의 컬럼 데이터 UI 출력
	2. 업로드된 파일 다운로드 기능

-->
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 보기</title>
	<script src="//cdn.ckeditor.com/4.12.1/standard/ckeditor.js"></script>
	<script>
		function getPost(filename){
			console.log(filename)
			var f = document.download;
			console.log(f)
			f.method = "post";
			f.action = "/web/download";
			f.filename.value = filename;
			console.log(filename);
			f.submit();
	}
	</script>
</head>
<body>

</body>
</html>