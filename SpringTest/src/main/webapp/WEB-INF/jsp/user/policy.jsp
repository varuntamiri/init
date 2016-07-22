<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>Insurance</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<link href="<%=request.getContextPath() %>/css/calendar.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript">	
		function fnCheckAction(val)
		{
			if(val == 'add')
			{
				document.addForm.action="<%=request.getContextPath()%>/sample/insurance/add";
				document.addForm.submit();
			} else
			{
				document.viewForm.action="<%=request.getContextPath()%>/sample/insurance/viewpolicy";
				document.viewForm.submit();
			}
		}
		</script> 
  	</head>
  	<body>
  		<div style="position :absolute;left:30px;top:40px;">
		<h1>Insurance Details</h1>
		</div>
  		<div style="position :absolute;left:450px;top:250px;">
	      	<form:form  name="addForm" modelAttribute="userPolicy" action="" method="GET">
	          	<input type="submit" value="Enroll Policy" onclick="fnCheckAction('add')"/>
	      	</form:form >
	      	<form:form  name="viewForm" modelAttribute="userPolicy" action="" method="GET">
	          	<input type="submit" value="View Enrolled Policy" onclick="fnCheckAction('view')"/>
	      	</form:form >
      	</div>
  	</body>
</html>