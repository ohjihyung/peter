package kr.or.ddit.basic.reqNresp;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responseTest01.do")
public class ResponseTest01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 	-forward 방식 
		 	      ==> 특정 서블릿이나 JSP에 대한 요청을 다른 서블릿이나 JSP로 넘겨준다.
		 			  (이때 Request객체와 Response객체를 공유하기 때문에 파라미터를 넘길 수 있다.)
		 		  
		 		  ==> 웹브라우저의 주소 영역의 주소가 처음 요청할 때의 값으로 변화가 없다.
		 		      (서버 내부에서만 접근이 가능하다.)
		 		  
		 		  ==> 이동되는 페이지로 값을 넘기려면  Request객체의 setAttribute()메서드로 데이터를 셋팅해서 보낸다.
		 		      형식) request객체.setAttribute("키값",데이터); // 데이터 : 모든 데이터 (Object)
		 */
		  //attribute 로 기존 request에 추가한다.
		 request.setAttribute("tel", "010-1234-5678"); //키값은 문자열이다..
		 
		 	//forward 처리 
		 	// 형식 RequestDispatcher rd = request.getRequestDispatcher("이동할 주소");
		 	//  이동할 주소 ==> 이동할 전체 주소 중에서 ContextPath 이후의 경로를 기술한다..
		    // 예) http://localhost/webTest/forwardTest.do ==>  /forwardTest.do
		 	// ContextPath = http://localhost/webTest
		 RequestDispatcher rd = request.getRequestDispatcher("/forwardTest.do");
		 rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
