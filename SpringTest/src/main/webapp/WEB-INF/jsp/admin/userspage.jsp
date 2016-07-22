<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insurance</title>
	</head>
	<body>
		<h1>User Details</h1>
		<table style="border: 1px solid; width: 800px; text-align:center">
			<tr style="background:#fcf">
				<td width="50">User Id</td>
				<td width="150">Login Name</td>
				<td width="100">First Name</td>
				<td width="100">Last Name</td>
				<td width="200">Policies</td>
				<td width="100">Create Date</td>
				<td width="100">Update Date</td>
			</tr>
			<c:forEach items="${userList}" var="UserVO">
				<tr>
					<td><c:out value="${UserVO.userID}" /></td>
					<td><c:out value="${UserVO.strLoginName}" /></td>
					<td><c:out value="${UserVO.strFirstName}" /></td>
					<td><c:out value="${UserVO.strLastName}" /></td>
					<td>
						<c:forEach items="${UserVO.userPolicies}" var="UserPolicyVO">
							<c:out value="${UserPolicyVO.policyName}" />,
						</c:forEach>
					</td>
					<td><c:out value="${UserVO.createDate}" /></td>
					<td><c:out value="${UserVO.updateDate}" /></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>