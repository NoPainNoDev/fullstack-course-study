<%@ page contentType="text/html; charset=UTF-8"%>
<%
	// 이전 페이지(Send09.jsp)로 부터 데이터 수신 → userName
	
	// 한글 인코딩 처리(깨짐 방지)
	request.setCharacterEncoding("UTF-8");

	String userName = request.getParameter("userName");
	
	request.setAttribute("message", "반갑습니다.");
	//-- request 객체의 key(message)의 값 안에
	//   "반갑습니다."를 value 로 넣는 작업 수행
	//   (map 자료구조와 동일함..)
	
	// ※ 리다이렉트
	//response.sendRedirect("Receive09.jsp");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send09_re.jsp</title>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>

<div>
	<h1>데이터 송수신 실습</h1>
	<hr>
</div>

<div>
	<h2>리다이렉트</h2>
</div>

<div>
	<p>이름 : <%=userName %></p>
</div>

</body>
</html>