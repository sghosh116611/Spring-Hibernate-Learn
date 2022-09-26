<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Luv2Code Company</title>
</head>
<body>
	Hey welcome to the luv2code company - Yohoooo!

	<hr>

	<!-- Display userName and Role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>


	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

	<hr>

	<security:authorize access="hasRole('MANAGER')">
		<!-- Add link to point to /leaders ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Only for
				Managers</a>
		</p>
	</security:authorize>

	<security:authorize access="hasRole('ADMIN')">
		<!-- Add link to point to /systems ... this is for the managers -->
		<p>
			<a href="${pageContext.request.contextPath}/systems">Only for
				Admin</a>
		</p>
	</security:authorize>


</body>
</html>