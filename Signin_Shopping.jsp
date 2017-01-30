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
<c:if test='<%=request.getSession().getAttribute("remember")!=null%>'>
<c:if test='<%=request.getSession().getAttribute("useradmin")==null%>'>
<c:redirect url="Welcome_Shopping.jsp"/>
</c:if>
<c:if test='<%=request.getSession().getAttribute("useradmin")!=null%>'>
<c:redirect url="Admin_Shopping.jsp"/>
</c:if>
</c:if>
<form action="Signin_Shopping" method="post">
<center>
<h1>Online Shopping Portal</h1>
<h3>Login</h3>
<p style='color:red;'>
${error}</p>
Username: 
<input type='text' name='userName'value='<%= getServletContext().getAttribute("userName")%>'/><br/>
Password: 
<input type='password' value='<%=getServletContext().getAttribute("password")%>'  name='password'><br/>
<input type="checkbox" name="rememberMe" checked="checked"> Remember me<br/>
<% getServletContext().setAttribute("error", "");%>
<input type='submit' value='Login'><br/>
<a href='Signup_Shopping.jsp'>SignUp</a>
<a href='HomePage_Shopping.jsp'>Home</a>
</center>
</form>
</body>
</html>