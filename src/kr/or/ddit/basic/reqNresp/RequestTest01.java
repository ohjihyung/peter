package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//jsp에서 전송한 데이터 받기 
		request.setCharacterEncoding("utf-8"); // POST방식으로 전달되는 문자 인코딩 방식 지정 
		
		//클라이언트가 보내온 데이터 받기 
		
		// 1) request객체.getParameter("파라미터명"); ==> 해당 '파라미터명'에 설정된 '값'을 가져온다.
		//                      ==> 가져오는 '값'의 자료형은 'String' 이다.
		//                      ==> '파라미터명'은 <form>태그 안에서 지정한 객체의 name 속성값
	
		String userName = request.getParameter("username");
		
		//select option은 하나만 선택이므로 getParameter로 받아와도 된다.
		String job = request.getParameter("job");
		
		
		// 2) request 객체.getParameterValues("파라미터명"); ==> 파라미터명이 같은것이 여러개 일경우 
		// ex> checkbox
		//    ==> 가져오는 '값'의 자료형은 'String[]'이다.
		
		//getParameterValues()메서드를 이용하여 name 속성값이 'hobby'로 설정된 체크박스의 값들을 읽어오기
		String[] hobbies = request.getParameterValues("hobby");
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'><title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Request객체 처리 결과</h2>");
		out.println("<table border='1'>");
		
		out.println("<tr><td>이름</td>");
		out.println("<td>"+ userName + "</td></tr>");
		
		out.println("<tr><td>직업</td>");
		out.println("<td>"+ job + "</td></tr>");
		
		out.println("<tr><td>취미</td>");
		out.println("<td>");
		
		if(hobbies !=null) {
			for(String h : hobbies) {
				out.println(h + "<br>");
			}
		}
		out.println("</td></tr>");
		out.println("</table>");
		
		out.println("<br><hr><br>");
		
		out.println("<h2>Request객체의 메서드 처리 결과</h2>");
		out.println("<ol>");
		out.println("<li> 클라이언트의 IP주소 : " + request.getRemoteAddr() + "</li>");
		out.println("<li> 요청메서드 :" +request.getMethod()+ "</li>");
		out.println("<li> Context Path : " +request.getContextPath()+ "</li>");
		out.println("<li> 프로토콜  :" + request.getProtocol() + "</li>");
		out.println("<li> URL 정보  :" + request.getRequestURL() + "</li>");
		out.println("<li> URI 정보  :" + request.getRequestURI() + "</li>");
		
		
		out.println("</ol>");
		
		//request객체.getParameterMap() ==> 전송된 모든 파라미터를 Map객체에 담아서 반환한다.
		//   이 Map객체의 Key값은 '파라미터명'이고, value값의 자료형은 'String[]'이다.
		
		Map<String, String[]> paramsMap = request.getParameterMap();
		out.println("<h2>request객체의 getParameterMap()메서드</h2>");
		out.println("<table border ='1'>");
		out.println("<tr><td>파라미터 Name</td><td>파라미터 value</td><tr>");
		
		for(String paramName : paramsMap.keySet()) { // 파라미터명의 개수만큼 반복
			String[] paramValues = paramsMap.get(paramName); // 파라미터 value값구하기 
			
			out.println("<tr><td>" + paramName + "</td>");
			out.println("<td>");
			
			if(paramValues == null || paramValues.length == 0) {
				continue;
			}
			else if(paramValues.length == 1) { // 파라미터가 배열이아니면
				out.println(paramValues[0]);
			}else { // 파라미터가 여러개일경우
				for(int i = 0 ; i < paramValues.length; i++) {
					out.println(paramValues[i] + "<br>");
				}
			} //end of else
			out.println("</td></tr>");
			
		}
		
		out.println("</table>");
		out.println("</body></html>");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
