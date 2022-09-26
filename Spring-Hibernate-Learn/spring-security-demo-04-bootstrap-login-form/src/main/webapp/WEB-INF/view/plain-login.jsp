<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
.failed {
	color: red;
}
</style>
</head>
<body>

	<h3>Login Page</h3>

	<form:form method="POST"
		action="${pageContext.request.contextPath}/authenticateTheUser">

		<!-- Checking for error -->
		<c:if test="${param.error != null}">
			<i class="failed">Sorry! Wrong username or password!</i>
		</c:if>

		<p>
			UserName : <input type="text" name="username" />
		</p>

		<p>
			Password : <input type="text" name="password" />
		</p>

		<input type="submit" value="Login" />

	</form:form>


</body>
</html>