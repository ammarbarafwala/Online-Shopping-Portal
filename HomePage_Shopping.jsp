<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test='<%=request.getSession().getAttribute("remember")!=null%>'>
<c:if test='<%=request.getSession().getAttribute("useradmin")==null%>'>
<c:redirect url="Welcome_Shopping.jsp"/>
</c:if>
<c:if test='<%=request.getSession().getAttribute("useradmin")!=null%>'>
<c:redirect url="Admin_Shopping.jsp"/>
</c:if>
</c:if>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<h1>Online Shopping Portal</h1>
	<h3>Shopping Portal Home Page</h3>
	<form action='Signup_Shopping.jsp'>
	<input type='submit' value='SignUp'><br/>
	</form>
	<form action='Signin_Shopping.jsp'>
	<input type='submit' value='SignIn'><br/>
	</form>
</center>
</body>
</html>