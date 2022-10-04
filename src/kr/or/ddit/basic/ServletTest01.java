package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 	요청 주소 :  http://localhost:8081/webTest/servletTest01.do ==> 요청할 때의 URL 주소 
 	           - http = 프로토콜 이름 
 	           - localhost = 컴퓨터이름(도메인명) 또는 IP 주소가 들어가는 자리 
 	           - 8081 : 포트번호 (포트번호 80번이면 생략가능)
 	           - /webTest : 컨텍스트 패스( 보통 프로젝트 이름으로 지정)
 	           - /servletTest01.do : 서블릿 요청의 URL 패턴   
 */

//Servlet클래스는 HttpServlet을 상속해서 작성한다..

// 이 예제는 배포 서술자(DD - Deployment Descriptor => web.xml 문서)를 이용해서
// 실행할 Servlet을 설정하여 처리하는 예제 
public class ServletTest01 extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	/*
	 	이 영역에서는 대부분 service() 메서드 or doGet() 메서드나 doPost() 메서드를 재정의해서 작성한다.
	 	
	 	doGet() 메서드나 doPost()메서드는 service() 메서드를 통해서 호출된다. 
	 	
	 	- HttpServletRequest() 객체 ==> 서비스 요청에 관련된 정보 및 메서드를 관리하는 객체
	 	- HttpServletResponse() 객체 ==> 서비스 응답에 관련된 정보 및 메서드를 관리하는 객체	 
	 */
	
	
	// doGet()메서드 -> GET	방식의 요청을 처리하는 메서드 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = "홍길동";
		
		// 응답을 보낼때 
		response.setCharacterEncoding("utf-8"); // 응답 문서의 인코딩 방식 지정 
		response.setContentType("text/html; charset=UTF-8"); // 응답 문서의 ContentType을 지정
		
		// 처리한 내용을 응답으로 보내기 위해서 PrintWriter객체를 생성한다.
		PrintWriter out = response.getWriter(); // 출력용 스트림 객체 
		
		// 처리한 내용을 출력한다.==> 응답 결과를 웹브라우저로 보낸다..
		// 방법1: append() 메서드 이용
		out.append("<html>")
			  .append("<head>")
			  	.append("<meta charset='utf-8'>")
			  	.append("<title>첫번째 Servlet 연습</title>")
			  	.append("</head>")
				  	.append("<body>")
				  		.append("<h2 style ='text-align:center;'>")
				  		.append(name + "씨 안녕하세요. 첫번 째 Servlet 프로그램입니다<br>")
				  		.append("Server at : " + request.getContextPath())
				  		.append("</h2>")
				  	.append("</body>")
			.append("</html>");
		
	}
	
	
	// doPost()메서드 -> POST 방식의 요청을 처리하는 메서드
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}
}
