<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<form action="InvalidateSession_Shopping" method="post">
	<input style="float:right;" type='submit' value='Logout'>
	</form>
	<h1>Online Shopping Portal</h1>
	<h3>Welcome <c:out value='<%=request.getSession().getAttribute("firstname")%>'/> <c:out value='<%=request.getSession().getAttribute("lastname")%>'/> to Online Shopping Portal</h3>
	You have logged in successfully.<br/>
	<a href="HomePage_Shopping.jsp">Home</a>
</center>
</body>
</html>