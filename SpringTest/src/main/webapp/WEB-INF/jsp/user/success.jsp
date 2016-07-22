<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>User Policy Success</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  	</head>
  	<body>
  		<h1>User Policies</h1>
  		<c:url var="backUrl" value="/sample/insurance/common" />
  		<div style="position :absolute;left:30px;top:145px;">
			<p>You have added\edited a policy at <%= new java.util.Date() %></p>
			<p>Return to <a href="${backUrl}">Main page</a></p>
		</div>  
  	</body>
</html>