<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Policies</title>
	</head>
	<body>
		<h1>User Policies</h1>
		<c:url var="backUrl" value="/sample/insurance/common" />
		<h3><a href="${backUrl}">Back</a></h3>
		<table style="border: 1px solid; width: 750px; text-align:center">
			<tr style="background:#fcf">
				<td width="100">Policy Id</td>
				<td width="150">Policy Name</td>
				<td width="200">Date of Premium</td>
				<td width="200">Premium Amount</td>
				<td width="100">User Name</td>
				<td width="100"></td>
			</tr>
			<c:forEach items="${userPolicyList}" var="UserPolicyVO">
				<c:url var="editUrl" value="/sample/insurance/edit/${UserPolicyVO.policyID}" />
				<tr>
					<td><c:out value="${UserPolicyVO.policyID}" /></td>
					<td><c:out value="${UserPolicyVO.policyName}" /></td>
					<td><c:out value="${UserPolicyVO.dateOfpremium}" /></td>
					<td><c:out value="${UserPolicyVO.premiumAmount}" /></td>
					<td><c:out value="${UserPolicyVO.user.strFirstName} ${UserPolicyVO.user.strLastName}" /></td>
					<td><a href="${editUrl}">Edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>