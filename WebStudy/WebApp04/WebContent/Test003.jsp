<%@ page contentType="text/html; charset=UTF-8"%>
<%!
	// 선언부 영역 → 함수 정의 가능
	
	// 서블릿(Servlet) 코드 내에서 봤을때...
	// a는 클래스 안에 전역변수처럼 선언되어 있음
	
	// 선언부에서 선언한 변수
	int a=0;

	// 선언부에서 정의한 함수
	int sum(int x)
	{
		int s = 0;
		for(int i = 0; i <= 100; ++i)
			s += i;
		
		return s;
	}
%>
<%
	// 스크립릿 영역
	
	// 서블릿(Servlet) 코드 내에서 봤을때...
	// b는 메서드 안에 지역변수처럼 선언되어 있음
	
	// 스크립릿 영역에서 선언한 변수
	int b=0;

	a++;
	b++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test003.jsp</title>
</head>
<body>

<div>
	<h1>JSP 관찰하기</h1>
	<hr>
</div>

<div>
	<h2>변수 확인</h2>
	<h3><%=a %></h3>
	<h3><%=b %></h3>
</div>


<div>
	<h2>함수의 기능 확인</h2>
	<h3><%=sum(100) %></h3>
</div>

<!-- 
	※ 요청한 페이지의 결과를 브라우저에서 확인한 후 새로고침(F5)를 반복해 보면...
	   a 변수(선언부에서 선언된 변수) 값만 계속 증가하는 것을 확인할 수 있다.
	   a 변수의 값만 계속 증가하는 이류를 확인하기 위해서는
	   서블릿(Servlet) 코드를 분석해 보아야 한다.
	   
	   즉. Test003.jsp의 서블릿 코드를 분석해야 한다.
	   
	   - 경로
	     C:\WebStudy\.metadata\.plugins\org.eclipse.wst.server.core
	     -----------
	     workspace
	                \tmp0\work\Catalina\localhost\WebApp04\org\apache\jsp
	                                              --------
	                                              project
	                                              
	                                              
	   - 파일
	     『Test003_jsp.java』
	      --------     ----
	        jsp 파일명    서블릿(Servlet)의 확장자 → 컴파일 이전
	        
	   ==> 변수 a 는 클래스(Test003_jsp)의 전역 변수로 선언된 것을 확인할 수 있다.
	       이는 객체가 소멸되기 전까지는 계속 값이 유지된다는 것을 의미한다.
	       변수 b 는 메소드(Test003_jsp 클래스의 _jspService() 메소드) 내의 
	       지역 변수로 선언된 것을 확인할 수 있다.
	       
	       『_jspInit()』 메소드와 『_jspDestroy()』 메소드는
	       서비스가 시작될 때와 끝날 때 *한 번씩만 호출*되는 메소드이다.
	       
	       반면...
	       『_jspService()』 메소드는
	       브라우저에 의해 *페이지가 요청될 때 마다 매번 호출되는(실행되는) 메소드*이다.
	       
	       이로 인해 변수 b는 페이지에 대한 요청이 발생할 때 마다
	       새롭게 선언되고 초기화되는 과정을 거치게 되는 것이다.
	       
	       JSP 페이지의 스크립릿 영역에서 선언된 모든 변수는
	       이 『_jspService()』 메소드의 지역 변수가 된다.
	       
	       또한, JSP 페이지의 선언부 영역에서 선언된 모든 변수는
	       클래스의 전역 변수(인스턴스 변수)가 된다.
	       
	       JSP 페이지에서 메소드 정의 시
	       스크립릿 영역 내부에서는 정의할 수 없다.
	       서블릿으로 변환되는 과정에서 메소드 내부에 또 다른 메소드가
	       다시 정의되는 상황이 되어버리기 때문에 문법적으로 잘못된 표현이 된다.
	       
	       선언부는...
	       비록 사용 빈도는 낮지만...
	       메소드는 선언부 내부에서만 정의할 수 있는 것이다.
 -->


</body>
</html>