package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sessionLogin.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//객체 생성 
		HttpSession session = request.getSession();
		
		// 입력한값 본다..
		
		String userId = request.getParameter("userid");
		String password = request.getParameter("pass");
		
		// id가 admin이고 비번이 1234면 session에 저장 
		if(userId.equals("admin") && password.equals("1234")) {
			session.setAttribute("USERID", userId);
			session.setAttribute("PASSWORD", password);
			
			response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");
		}else {
			
			// redirect로 보낼 경우 전체 경로를 넣어준다.
			response.sendRedirect(request.getContextPath() + "/basic/session/sessionLogin.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
