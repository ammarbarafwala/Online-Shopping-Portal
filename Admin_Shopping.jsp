
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="InvalidateSession_Shopping" method="post">
	<input style="float:right;" type='submit' value='Logout'>
	</form>
	<h1>Online Shopping Portal</h1>
	<h3>Welcome Admin!</h3>
	User Details<br/>
	<table border="1">
	<tr>
		<th>
			 First Name
		</th>
		<th>
			Last Name
		</th>
		<th>
			Email Id
		</th>
		<th>
			Username
		</th>
		<th>
			Phone No
		</th>
	</tr>
	<c:forEach items='<%=(request.getSession().getAttribute("useradmin"))%>' var='u'>
	<tr>
	<c:set var='useradmin' value=''/>
	
		<td>
			<c:out value='${u.firstName}'/>
		</td>
		<td>
			<c:out value='${u.lastName}'/>
		</td>
		<td>
			<c:out value='${u.email}'/>
		</td>
		<td>
			<c:out value='${u.userName}'/>
		</td>
		<td>
			<c:out value='${u.phone}'/>
		</td>
	</tr>
	</c:forEach>
</table>
Items<br/>

<br/>
<table border="1">
	<tr>
		<th>
			 Image
		</th>
		<th>
			 Name
		</th>
		<th>
			Price
		</th>
		<th>
			Quantity
		</th>
		<th>
			Edit
		</th>
		<th>
			Delete
		</th>
	</tr>
	<%int i=0;%>
	<c:forEach items='<%=(request.getSession().getAttribute("admindata_Shopping"))%>' var='t'>
	<%i=i+1;%>
	<c:set var="i" value='<%=i%>'/>
	<tr>
		<td>
			<img src="${t.image}" width="128" height="128">
			
		</td>
		<td>
			<c:out value="${t.name}"/>
		</td>
		<td>
		<c:out value="${t.price}"/>
		</td>
		<td>
			<c:out value="${t.quantity}"/>
		</td>
		<td>
			<a href="Edit_Shopping?index=${i}">Edit</a>
		</td>
		<td>
			<a href="Delete_Shopping?index=${i}">Delete</a>
		</td>
	</tr>
	</c:forEach>
</table>
	<a href="HomePage_Shopping.jsp">Home</a>
</center>
</body>
</html>