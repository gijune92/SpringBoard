<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 
< 게시글 등록 페이지 >
1. 게시글 등록
2. 게시글 파일 업로드 기능 추가


 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css">
<script src="//cdn.ckeditor.com/4.12.1/standard/ckeditor.js"></script>
<title> 등록 </title>
<script>

</script>
<style>
	.col3 { width: 30%; background-color: gainsboro;}
	.col7 { width: 70%; }
	.w10 { width: 100%; }
	.w { width: 100%; }    
  table { border-collapse: collapse; border: 1px solid black; text-align: center;}
 	tr, td {border: 1px solid black; height:50px;}
</style>
</head>
<body>
	<form action="/Articleinsert" method="POST" enctype="multipart/form-data">
		<table>
			<tbody>
				<tr>
					<td class="col3">
						제목
					</td>
					<td class="col7">
						<input type="text" class="w" name="title">
					</td>
				</tr>
				<tr>
					<td class="col3">내용</td>
					<td class="col7">
						<textarea class="form-control" id="p_content" name="content"></textarea>
						<script type="text/javascript">
							CKEDITOR.replace('p_content', {
								height : 300
							});
						</script>
					</td>
				</tr>
				<tr>
					<td class="col3">
						첨부파일
					</td>
					<td class="cols7">
						<input type="file" name="files" multiple="multiple">
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="전송" >
					</td> 
				</tr>
			</tbody>
		</table>
		<input type=hidden name="name" value="${sessionScope.nickname}"/>
	</form>
</body>
</html>