
<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

			
		<c:if test="${list !=null and not empty list}">
			<table border="2px" cellpadding="8px" cellspacing="4px">
				<tr>
					<td>Code</td>
					<td>Name</td>
					<td>State</td>
					<td>University</td>
					<td>View Data</td>
					
				</tr>

				<c:forEach var="e" items="${list}">
					<tr>
						<td>${e.gi_code}</td>
						<td>${e.gi_name}</td>
						<td>${e.gi_state}</td>
						<td>${e.gi_uni}</td>
						<td><a href="view_institute/${e.gi_code}">View</a></td>

					</tr>
				</c:forEach>

			</table>
		</c:if>
</body>
</html>