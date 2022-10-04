<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>forward, sendRediect 연습</title>
</head>
<body>
	
	<h3>forward, sendRediect 연습</h3><hr>
	
	<form action="<%= request.getContextPath() %>/responseTest01.do">
	 forward 연습용 : <input type ="text" name ="username">
	 	<input type ="submit" value ="확인">
		
	</form>
	<hr>
	
	
	<form action="/webTest/responseTest02.do">
	 sendRedirect 연습용 : <input type ="text" name ="username">
	 	<input type ="submit" value ="확인">
	
	</form>

	
</body>
</html>