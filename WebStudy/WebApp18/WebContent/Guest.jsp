<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script type="text/javascript">
	function sendIt()
	{
		var f = document.myForm;
		
		f.submit();
	}
</script>
</head>
<body>

<div>
	<h1>JSP 액션태그 실습</h1>
	<hr>
</div>

<div>
	<p>간단한 기본 방명록 작성 실습</p>
	<form action="Guest_ok.jsp" method="post" name="myForm">
		<table class="table">
			<tr>
				<th>이름</th>
				<td>
					<input type="text" class="txt" name="userName">
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<input type="text" class="txt" name="subject">
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea rows="5" cols="30" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button type="button" class="btn" style="width: 100%;"
					 onclick="sendIt()">방명록 작성</button>
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>