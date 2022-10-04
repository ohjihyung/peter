<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 창</title>
</head>

<body>

<% 
	// 쿠키값 구하기  (쿠키변수가 userId인 쿠키값 구하기)
	String cookieUserId = "";
	String  chk  =""; // 체크박스 체크용 
	
	
	//JSP 문서에는 httpServletRequest객체는 request라는 이름으로 
	// HttpServletResponse객체는 response라는 이름으로 저장되어 있다.
	Cookie[] cookies = request.getCookies();
	
	if(cookies !=null){
		for(Cookie c : cookies){
			if("USERID".equals(c.getName())){ // ID가 저장된 쿠키
				cookieUserId = c.getValue(); //쿠키값(저장된 ID값)구하기
				chk = "checked";
			}
		}
	} //end of if 

%>
	

	<form action ="<%=request.getContextPath()%>/cookieLoginServlet.do" method = "post">
	<table style = "margin:0 auto;">
	<tr>	
	<td>
	 ID:   <input type = "text"  name = "userid" value = "<%=cookieUserId %>" placeholder="ID를 입력하세요"><br>		
	
	</td>
	</tr>
	<tr>
	<td>
	 PASS: <input type = "password" name = "pass" placeholder = "Password 입력하세요"><br>
	
	</td>
	</tr>
	 <!-- 보내고 싶은 데이터를 servlet에서 가지고 갈라면 name ( 데이터의 변수이름) 을 보낸다. -->
 	<tr>
 	<td>
	 <input type ="checkbox" name = "chkid"  value = "check"  <%=chk %>> id 기억하기 <br>
	 <input type ="submit"  value = "로그인">		
 	
 	</td>
 	</tr>	
		
	</table>
	</form>
	
	
</body>
</html>