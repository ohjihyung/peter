package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//방법1  하나하나씩 받아오기 (한글같은거 받아올때)
		request.setCharacterEncoding("utf-8");

		// form 안에 있는 해당 id가 "파라미터명"에들어감 
		double result = 0; // 계산 결과
		int num1 = Integer.parseInt(request.getParameter("number1"));
		int num2 = Integer.parseInt(request.getParameter("number2"));
		
		String operator = request.getParameter("operation");
		
		boolean calcOk = true; // 계산 성공 여부가 저장될 변수 
		
		switch(operator) {
		case "+": result = num1 + num2; break;
		case "-": result = num1 - num2; break;
		case "*": result = num1 * num2; break;
		case "/": 
				if(num2!=0) {
					result = num1*1.0 / num2;					
				}else {
					calcOk = false;
				}
				 break;
		case "%": 
				if(num2 != 0) {
					result = num1 % num2;
				}else {
					calcOk  = false;
				}
				 break;
		default : result = 0;
		}
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset = 'utf-8'><title>Request객체 연습</title></head>");
		out.println("<body>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
		//out.println(num1 +"" + operator  + num2 +"="+ result);
		out.printf("%d %s %d =",num1, operator, num2);
		if(calcOk == true) {
			out.println(result);
		}else {
			out.println("계산 불가!");
		}
		out.println("</body></html>");
		
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response); 
	}

}
