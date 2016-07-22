<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insurance Project</title>
	</head>
	<body>
		<h1>Login</h1>		
		<div id="login-error">${error}</div>
		<form action="../../j_spring_security_check" method="post" >
			<p>
				<label for="j_username">User Name</label>
				<input type="text" name="j_username"
							value='<c:if test="${not empty param.authfailed}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}" escapeXml="false"/></c:if>' />
			</p>
			<p>
				<label for="j_password">Password</label>
				<input id="j_password" name="j_password" type="password" />
			</p>
			<input  type="submit" value="Login"/>
		</form>
	</body>
</html>