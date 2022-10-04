package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//저장된 Session 정보 읽기
		
		// 1. Session 객체 생성 or 현재 Session 정보 가져오기 
		HttpSession session = request.getSession();
		
		// 2. Session 값 읽어오기 
		// 형식> session객체변수.getAttribute("key값");
		// 형변환 해줘야함 ..
		String testSession = (String)session.getAttribute("testSession");
		String userName = (String)session.getAttribute("userName");
		int age = 0;  // 새로 생성된 session이면 null이므로 int형은 조심해야한다.. 
		
		if(session.getAttribute("age") != null) {
			 age  = (int)session.getAttribute("age");			
		}
		
		Testmember mem = (Testmember)session.getAttribute("testObj");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><meta charset = 'utf-8'><title>세션 연습</title></head>");
		out.println("<body>");
			out.println("<h3> 읽어온 Session데이터  출력.</h3>");
			
			if(testSession == null) {
				out.println("testSession의 세션값은 없음 <br> ");
			}else {
				out.println("testSession : " + testSession + "<br>");	
			}
			out.println("age : " + age + "<br>");
			
			if(mem == null) {
				out.println("testObj의 세션값은 없습니다<br>");
			}else {
				out.println("testId : " + mem.getTestId() + "<br>");
				out.println("name : " + mem.getName()+ "<br>");				
			}
			
			out.println("<a href = " + request.getContextPath()+ "/basic/session/sessionTest.jsp>시작문서로가기</a>");
			out.println("</body>");
			
			
			out.println("<hr>");
			out.println("<h3>Session과 관련된 정보들 </h3>");
			
			// 세션ID ==> 세션을 구분하기 위한 고유의 값 
			out.println("세션 ID : " + session.getId() + "<br>");
			
			// 생성시간 -->> 1970 1월 1일 부터 경과한 시간으로 표시(밀리세컨드)
			out.println("세션 생성 시간 : " + session.getCreationTime() + "<br>");
			
			// 가장 최근에 세션에 접근한 시간 == 1970 1월 1일 부터 경과한 시간으로 표시(밀리세컨드)
			out.println("세션 최근 접근 시간 : " + session.getLastAccessedTime() + "<br>");
			
			// 세션 유효시간 ==> (초 단위)
			out.println("세션 유효 시간 : " + session.getMaxInactiveInterval() + "<br>");
			
			
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
