<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Save</title>
</head>
<body>

<h1> Your Actions have been saved successfully </h1>

<%
response.setHeader("Refresh", "5; http://localhost:8585/scholarship/view_ministry");
%>


</body>
</html>