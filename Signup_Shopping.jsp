<%@ page session="false" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
p{color: red;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action='Signup_Shopping' method="post">
<center>
<h1>Online Shopping Portal</h1>
<h3>Registration</h3>
<p>${s0}</p>
First Name<br>
<input type='text' id='firstName' name='firstName'><br/>
<p>${s1}</p>
Last Name<br>
<input type='text' id='firstName' name='lastName'><br/>
<p>${s2}</p>
Email <br>
<input type='text' id='firstName' name='email'><br/>
<p>${s3}</p>
Username<br>
<input type='text' id='firstName' name='userName'><br/>
<p>${s4}</p>
Password<br>
<input type='password' id='firstName' name='password'><br/>
<p>${s5}</p>
Phone<br>
<input type='text' id='firstName' name='phone'><br/>
<p>${s6}</p>
Credit Card<br>
<input type='text' id='firstName' name='creditCard'><br/>
<input type='submit' value='SignUp'><br/>
<a href='HomePage_Shopping.jsp'>Home</a>
<% 
ServletContext context=getServletContext();
for(int i=0;i<7;i++)
{
	context.setAttribute("s"+i, "");	
}
	
%>

</center>
</form>
</body>
</html>