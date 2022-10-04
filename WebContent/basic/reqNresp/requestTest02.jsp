<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 
	 <!-- GET	방식  -->
	 <hr>
	 <h1>Request 연습 Form(숫자 입력은 정수형으로 입력하세요.) GET 방식</h1>
	 <hr>
	 <form action = "/webTest/requestTest02.do" method = "GET">
	 	<input type ="text" name ="number1" value=""> 
		<select name ="operation">
			<option value ="+">+</option>
			<option value ="-">-</option>
			<option value ="*">*</option>
			<option value ="/">/</option>
		</select>
	 	<input type ="text" name ="number2" value=""> 
		<input type ="submit" value ="확인">	 	
	 </form>	 
	 
	 
	 
	 <hr>
	 <h1>Request 연습 Form(숫자 입력은 정수형으로 입력하세요.) POST 방식</h1>
	 <hr>
	 <form action = "/webTest/requestTest02.do" method ="POST">
	 	<table>
	 	<tr>	 	
	 		<td><input type ="text" size = "10" name ="number1" value=""></td> 
		<td>
		<select name ="operation">
			<option value ="+">+</option>
			<option value ="-">-</option>
			<option value ="*">*</option>
			<option value ="/">/</option>
			<option value ="%">%</option>
		</select>
	 	</td>
	 	<td><input type ="text" name ="number2" value=""></td> 
		<td><input type ="submit" value ="확인"></td>
		</tr> 	
	 	</table>
	 </form>	 
	 
</body>
</html>