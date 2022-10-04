package kr.or.ddit.basic.cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieLoginServlet.do")
public class CookieLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		// id, password, checkbox값 구하기  (jsp의 name)

		String userid = request.getParameter("userid");	
		String password = request.getParameter("pass");	
		String checkid = request.getParameter("checkid");	
		
		// 우선 Cookie 객체 생성 
		Cookie loginCookie = new Cookie("USERID", userid);
		
		// Checkbox는 check된 것만 전송된다..
		if(checkid !=null) { // 쿠키 생성 
			response.addCookie(loginCookie);
		}else {
			// 체크가 해제되었을 때 
			// 쿠키 삭제하기 
			loginCookie.setMaxAge(0);
			response.addCookie(loginCookie);
		}
		
		if("test".equals(userid) && "1234".equals(password)) {
			//cookiemain.jsp로 이동 
			response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieMain.jsp");
			
		}else { // 로그인 실패 
			
			response.sendRedirect(request.getContextPath() + "/basic/cookie/cookieLogin.jsp");			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
