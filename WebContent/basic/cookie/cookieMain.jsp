<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 로그인 </title>
</head>
<body>
   <h2>cookie 연습용 main 페이지 입니다.</h2>
	
	<!--  getContentPath() 하면  WebContent 위치라 생각  -->
   <a href = "<%=request.getContextPath()%>/basic/cookie/cookieLogin.jsp"> Login 창으로 이동</a>
</body>
</html>