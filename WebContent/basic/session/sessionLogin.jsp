<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션연습</title>
</head>
<body>
		
		<%
			  session = request.getSession();
			  String userid = (String)session.getAttribute("USERID");
			  if("admin".equals(userid)){
		%>		  
			 <h3> <%=userid %> 님 반갑습니다</h3>
			  <a href = "<%=request.getContextPath()%>/sessionLogout.do">로그아웃하기</a>	  
				  
		<% 	  
			  }
			  else{
		%>
				  <form action = "<%=request.getContextPath() %>/sessionLogin.do" method = "post">
					<table>
							<tr>
								 <td>ID : </td>
								 <td><input type ="text" name = "userid"></td>
							</tr>
							<tr>
								 <td>PASS : </td>
								 <td><input type ="password" name = "pass"></td>
							</tr>
							<tr>
								<td><input type = "submit" value = "Login"></td>
							</tr>
					</table>
				</form>		  
		<% } %>

		
		
		
</body>
</html>