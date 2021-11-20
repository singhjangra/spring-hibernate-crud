<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add A new Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	<style type="text/css">
	.error{
	color:red;
	}
	</style>
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<c:if test="${customer.id eq '0'}">
				<h1>Add a new Customer</h1>
			</c:if>
			<c:if test="${customer.id gt '0'}">
				<h1>Update the Customer</h1>
			</c:if>
		</div>
	</div>

	<div id="container">
		<form:form action="addCustomer" method="POST"
			modelAttribute="customer">
			<table>
					<form:hidden path="id" />
				<tr>
					<td><form:label path="firstName">FirstName:</form:label></td>
					<td><form:input path="firstName" /></td>
					<td><form:errors path="firstName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="lastName">LastName:</form:label></td>
					<td><form:input path="lastName" /></td>
					<td><form:errors path="lastName" cssClass="error" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email:</form:label></td>
					<td><form:input path="email" /></td>
					<td><form:errors path="email" cssClass="error" /></td>
				</tr>
				<tr>
						<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
			</table>
		</form:form>
	</div>
			<div>
				<a type="button"  class="add-button" href="${pageContext.request.contextPath}/customers/list">
					<- Go To List</a>
			
			</div>
</body>
</html>