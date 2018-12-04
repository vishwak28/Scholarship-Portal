<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"   isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>State Message</title>
</head>
<body>
          <h1>${str}</h1>
          
          <%
response.setHeader("Refresh", "5; http://localhost:8585/scholarship/state_redirect");
%>

</body>
</html>