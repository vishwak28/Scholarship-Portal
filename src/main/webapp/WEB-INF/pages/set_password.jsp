<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="resources/css/style1.css">

<script type="text/javascript">
	function Validate() {
		var password = document.getElementById("gs_password").value;
		var confirmPassword = document.getElementById("gs_confirm_password").value;
		if (password != confirmPassword) {
			alert("Passwords do not match.");
			return false;
		}
		return true;
	}
</script>

<title>Password Recovery</title>
</head>
<body>
<div class="login-page">
	<center><h1>Password Recovery</h1></center>
  <div class="form">
    <form class="login-form" method="post" action="new_password/${gs_aadhar}">
     
     <h3>Set Your New Password</h3>
				Password<input type="password" name="gs_password" id="gs_password"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					placeholder="Your Password"
					title="Must contain at least one uppercase letter, one digit, one special character and lowercase letter and must be of 8 or more characters"
					required> 
				Confirm Password<input type="password" name="gs_confirm_password"
					id="gs_confirm_password" placeholder="Confirm Password" required>
					
               <button onclick="return Validate()">Register</button>
    </form>
  </div>
</div>
</body>
</html>