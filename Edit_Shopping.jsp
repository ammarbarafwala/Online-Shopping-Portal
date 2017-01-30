<%@page import="cs1220.lab4.Items"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<c:set var="t" value='<%=request.getSession().getAttribute("id")%>'/>
<body>
<form action="InvalidateSession_Shopping" method="post">
	<input style="float:right;" type='submit' value='Logout'>
</form>
<form action="Save_Shopping" method="post">
Movie Name<br>
<input type='text' name='movieName' value='${t.name}'/><br/>
Image url<br>
<input type='text' id='image' name='imageUrl' value='${t.image}'><br/>
Price<br>
<input type='text' id='price' name='price' value='${t.price}'><br/>
Quantity<br>
<input type='text' id='quantity' name='quantity' value='${t.quantity}'><br/>
<input type='submit' value='submit'><br/>
</form>
</body>
</html>