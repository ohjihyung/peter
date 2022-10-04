package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionDelete.do")
public class SessionDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// Session 정보 삭제 
		
		// 1. session 객체 생성 
		HttpSession session = request.getSession();
		
		// 2. session 삭제하기 ( 방법 2가지)
		
		// 2-1) Session 값 삭제하기 --> Session자체는 삭제되지 않고 개별적인 Session값만 삭제된다.
		//      형식 Session객체변수.removeAttribute("키값"); 
		
		session.removeAttribute("testSession");
		session.removeAttribute("age");
		
	
		// 2-2) Session 자체를 삭제하기 --> Session의 모든 정보가 삭제된다.
		//     형식> session객체변수.invalidate();
		
		//session.invalidate(); // 전체 세션 삭제
		
		

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<html><head><meta charset = 'utf-8'><title>세션 연습</title></head>");
		out.println("<body>");
		out.println("<h3> Session 삭제하기.</h3>");	
		out.println("<a href = " + request.getContextPath()+ "/basic/session/sessionTest.jsp>시작문서로가기</a>");
		out.println("</body>");
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
