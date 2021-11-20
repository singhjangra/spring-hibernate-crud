<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>List of Customers</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<input type="button" value="Add Customer" class="add-button" onclick="window.location.href='showFormForAdd'; return false">
		<table>
				<tr>
					<th>Id</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach items="${customers}" var="cust">
					<c:url var="updateURL" value="/customers/showFormForUpdate">
							<c:param name="customerId" value="${cust.id}"></c:param>
					</c:url>
					<c:url var="deleteURL" value="/customers/delete">
							<c:param name="customerId" value="${cust.id}"></c:param>
					</c:url>
					<tr>
						<td>${cust.id }</td>
						<td>${cust.firstName }</td>
						<td>${cust.lastName }</td>
						<td>${cust.email }</td>
						<td><a href="${updateURL }" class="add-button">Update</a> 
						<a href="${deleteURL }" class="add-button" onclick="if(!(confirm('Are you sure u want to delete this customer?'))) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>