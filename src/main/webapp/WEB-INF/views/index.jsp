<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
  
<!DOCTYPE html>
<html>
<head>




<title>Item Admin</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.1.3/sketchy/bootstrap.min.css" />

</head>
<body background = "https://techcrunch.com/wp-content/uploads/2017/06/facebook-group-admin-tools.png?w=730&crop=1">


<div class="container">
<h1 style="color:red;">This is the admin page</h1> 


<table border ="1">

	<c:forEach var="p" items="${item}">
	<tr> 
		<!--  left out title on purpose --> 
			<td> ${p.id}</td>
			<td> ${p.name}</td>
			<td> ${p.description}</td>
			<td> ${p.quantity}</td>
			<td> ${p.price}</td>
		
			<!--  this is url encoding and allows us to pass some data into the link for 
			our controller method -->
			<td><a href = "/item/${p.id}/update">Edit</a></td>
			<td><a href = "/item/${p.id}/delete">Delete</a></td>
	</tr>
	
	
	</c:forEach>
</table>

<br>

<h1><a class= "btn btn-secondary" href= "item/add">Add</a></h1>
</div>
</body>
</html>