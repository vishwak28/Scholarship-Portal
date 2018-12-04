<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style1.css">

<title>Student Registration Form</title>
</head>
<body>
<div class="login-page">
	<center><h1>Password Changed</h1></center>
  <div class="form">
    <form class="login-form" method="post" action="forget_password">
     
                   
			       <h3>${message}</h3>       			       
   
    </form>
  </div>
</div>

  
           <%
response.setHeader("Refresh", "5; http://localhost:8585/scholarship/index.jsp");
%>
    
</body>
</html>