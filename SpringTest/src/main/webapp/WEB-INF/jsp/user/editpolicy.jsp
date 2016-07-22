<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
    	<title>Edit Enrolled Policy</title>
    	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    	<link href="<%=request.getContextPath()%>/css/calendar.css" rel="stylesheet"
			type="text/css" />
		<script type="text/javascript"
			src="<%=request.getContextPath()%>/js/calendar_us.js"></script>
		<script type="text/javascript">	
		function fnCancel()
		{
			document.editForm.action="<%=request.getContextPath()%>/sample/insurance/viewpolicy";
			document.editForm.submit();
		}
		function fnEditPolicy()
		{
			document.editForm.action="<%=request.getContextPath()%>/sample/insurance/edit";
			document.editForm.submit();
		}
		</script>
  	</head>
  	<body>
  		<div style="position :absolute;left:30px;top:40px;">
		<h1>Policy Details</h1>
		</div>
		<form:form  name="editForm" modelAttribute="userPolicy" action="" method="GET">
	  		<div style="position :absolute;left:30px;top:140px;">
	  			<table class="gDark">
          			<tr class="gDark" >
                    	<th colspan="2" height="20px">
                        	Edit Policy Details
                    	</th>
		            </tr>
	                <tr class="gLight">
	                    <td>Policy ID:</td>
	                    <td>
	                    	<c:out value="${userPolicy.policyID}" />
	                    	<form:hidden path="policyID"/>
						</td>
	                </tr>
	                <tr class="gLight">
	                    <td>Policy Name:</td>
	                    <td>
	                    	<font color="red"><form:errors path="strPolicyName" /></font><br>
	                    	<form:input path="strPolicyName" id="strPolicyName"/>	                    	
	                    </td>
	                </tr>
	                <tr class="gLight">
	                    <td>Date of Premium:</td>
	                    <td>
	                    	<font color="red"><form:errors path="strDateOfpremium" /></font><br>
	                    	<form:input path="strDateOfpremium" id="strDateOfpremium" readonly="true"/>
	                        <script language="JavaScript">
	                            new tcal ({
	                                     // form name
	                                'formname': 'editForm',
	                                // input name
	                                'controlname': 'strDateOfpremium'
	                            });
	                        </script>
	                    </td>
	                </tr>
	                <tr class="gLight">
	                    <td>Premium Amount:</td>
	                    <td>
	                    	<font color="red"><form:errors path="premiumAmount" /></font><br>
	                    	<form:input path="premiumAmount" id="premiumAmount"/>	                    	
	                    </td>
	                </tr>
	                <tr class="gLight">
	                    <td>User Name:</td>
	                    <td>
	                    	<c:out value="${userPolicy.user.strFirstName} ${userPolicy.user.strLastName}" />
	                    </td>
	                </tr>
					<tr class="gLight">
						<td width="25%">&nbsp;</td>
				    	<td width="75%"> 
				        <input type="button" name="Submit" value="Edit" onclick="fnEditPolicy();">
				        <input type="button" name="Submit" value="Cancel" onclick="fnCancel();">
				    	</td>
					</tr>
            	</table>
	      	</div>
		</form:form>
  	</body>
</html>