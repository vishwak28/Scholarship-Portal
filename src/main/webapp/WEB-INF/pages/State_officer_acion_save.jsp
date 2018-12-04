<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save State</title>
</head>
<body>

<h1> Your Actions have been saved successfully </h1>

<%
response.setHeader("Refresh", "5; http://localhost:8585/scholarship/state_redirect");
%>

</body>
</html>