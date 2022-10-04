package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountDelServlet.do")
public class CookieCountDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		Cookie[] cookies = request.getCookies(); //전체 쿠키 가지고옴 
	
		
		if(cookies != null) {
			
			for(Cookie c : cookies) {
				String name = c.getName();
				if("count".equals(name)) {
					 c.setMaxAge(0); // 유지시간 0 셋팅 
					 response.addCookie(c);
					 break;
				}
			}
		}//end of if 
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'><title>쿠키카운트</title></head>");
		out.println("<body>");
			out.println("<h3>카운트가 초기화 되었음  </h3>");
			out.println("<a href = " + request.getContextPath()+ "/basic/cookie/cookieTest02.jsp>시작문서로가기</a>");
		out.println("</body>");
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
