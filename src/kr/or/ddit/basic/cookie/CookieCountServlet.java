package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		
		//Cookie의 key 값은 count 로 하기로한다..
		
		// count 라는 쿠키있는 지검사
		
		Cookie[] cookies = request.getCookies();
		
		int count = 0;
		
		if(cookies != null) {
			for(Cookie c : cookies) {
				String name =  c.getName(); // 쿠키의 키값 구하기 
				if("count".equals(name)) {
					String value = c.getValue(); //쿠키의 value값 (현재의 count 값) 구하기 
					count = Integer.parseInt(value);
					break;
				}
			}
		} // end of if 
		
		count++; // count 값 증가 
		
		// 증가된 count 가 저장될 Cookie 객체 생성 
		Cookie countCookie = new Cookie("count", String.valueOf(count));
		
		response.addCookie(countCookie); // 쿠키 추가 
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'><title>쿠키카운트</title></head>");
		out.println("<body>");
			out.println("<h3>어서오세요 당신은 " + count + "번째 방문입니다</h3><br><br>");
			
			out.println("<a href = " + request.getContextPath()+ "/cookieCountServlet.do>카운트 증가하기</a>");
			out.println("<a href = " + request.getContextPath()+ "/basic/cookie/cookieTest02.jsp>시작문서로가기</a>");
		out.println("</body>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
