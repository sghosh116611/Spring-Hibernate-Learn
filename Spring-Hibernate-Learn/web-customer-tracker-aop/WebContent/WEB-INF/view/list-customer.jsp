<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.luv2code.springdemo.util.SortUtils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">

		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>

		<div id="container">

			<div id="content">

				<input type="button" value="Add Customer"
					onClick="window.location.href='showFormForAdd';return false;"
					class="add-button" />

				<form:form action="searchCustomer" method="GET">
					Search Customer: <input type="text" name="theSearchName" />
					<input type="submit" value="search" class='add-button' />
				</form:form>

				<!-- Sort Utils -->
				<c:url var="sortLinkFirstName" value="/customer-tracker/list">
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.FIRST_NAME)%>" />
				</c:url>

				<c:url var="sortLinkLastName" value="/customer-tracker/list">
					<c:param name="sort"
						value="<%=Integer.toString(SortUtils.LAST_NAME)%>" />
				</c:url>

				<c:url var="sortLinkEmail" value="/customer-tracker/list">
					<c:param name="sort" value="<%=Integer.toString(SortUtils.EMAIL)%>" />
				</c:url>

				<table>
					<tr>
						<th><a href="${sortLinkFirstName }">First Name </a></th>
						<th><a href="${sortLinkLastName }">Last Name </a></th>
						<th><a href="${sortLinkEmail }">Email </a></th>
						<th>Action</th>
					</tr>


					<c:forEach var="tempCustomer" items="${customers}">

						<c:url var="updateLink"
							value="/customer-tracker/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>

						<c:url var="deleteLink" value="/customer-tracker/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id }" />
						</c:url>

						<tr>
							<td>${tempCustomer.firstName }</td>
							<td>${tempCustomer.lastName }</td>
							<td>${tempCustomer.email }</td>
							<td><a href="${updateLink }">Update</a> | <a
								href="${deleteLink }"
								onClick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>

		</div>

	</div>

</body>
</html>