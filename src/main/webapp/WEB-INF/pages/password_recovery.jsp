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
	<center><h1>Password Recovery</h1></center>
  <div class="form">
    <form class="login-form" method="post" action="forget_password">
     
                 <h3>${result}</h3>
                 <h3>Enter Following Details To Reset Your Password</h3>
                Aadhar no: <input type="text" name="gs_aadhar" maxlength="12"
					placeholder="Candidate Addhar number" required>
			    Security Question : <select name="gs_question" id="State" title="State"
					class="required" required>
					<option selected="selected" value="-1" title="-Select-">-Select-</option>
					<option title="What is your nick name">What is your nick name</option>
					<option title="What is Your Birth Place">What is Your Birth Place</option>
					<option title="What is Favourite Book name">What is Favourite Book name</option>
					<option title="Your Deepest Secret">Your Deepest Secret</option>
                    </select> <br>
                  <input type="text" name="gs_answer" value="" placeholder="Enter Your answer"
					required>    
			        
      
      <button >Confirm</button>
    </form>
  </div>
</div>
</body>
</html>