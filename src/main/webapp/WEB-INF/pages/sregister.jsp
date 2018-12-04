<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<title>Student Registration Form</title>
</head>
<body>
<div class="login-page">
	<center><h1>Student Registration Form</h1></center>
  <div class="form">
    <form class="login-form" method="post" action="student_register">
      <h3>Basic Details</h3>

				 Candidate Name: <input type="text" name="gs_name"
					pattern="[A-Za-z]{}" placeholder="Candidate Full Name" maxlength="30" title="Characters Only, Max 30" required>
				Candidate Mobile No: <input type="tel" name="gs_mobile" value=""
					pattern="[6789][0-9]{9}" placeholder="Mobile No." minlength="10" maxlength="10"
					required> Candidate Email: <input type="text"
					name="gs_email" value=""
					pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$"
					placeholder="Email Id" title="example@gmail.com" required> Date of Birth: <input
					type="text" name="gs_dob" value=""
					placeholder="Candidate Date of Birth" required> Candidate
				Aadhar no: <input type="tel" name="gs_aadhar" minlength="12" maxlength="12"
					placeholder="Candidate Addhar number" required> Candidate
				Institute Name: <input type="text" name="gs_insname" pattern="[A-Za-z]{}"
					placeholder="Institute Name" required> <br> Candidate
				State : <select name="gs_state" id="State" title="State"
					class="required" required>
					<option selected="selected" value="-1" title="-Select-">-Select-</option>
					<option title="Andaman &amp; Nicobar Islands">Andaman
						&amp; Nicobar Islands</option>
					<option title="Andhra Pradesh">Andhra Pradesh</option>
					<option title="Arunachal Pradesh">Arunachal Pradesh</option>
					<option title="Assam">Assam</option>
					<option title="Bihar">Bihar</option>
					<option title="Chandigarh">Chandigarh</option>
					<option title="Chhattisgarh">Chhattisgarh</option>
					<option title="Dadra &amp; Nagar Haveli">Dadra &amp; Nagar
						Haveli</option>
					<option title="Daman &amp; Diu">Daman &amp; Diu</option>
					<option title="Delhi">Delhi</option>
					<option title="Goa">Goa</option>
					<option title="Gujarat">Gujarat</option>
					<option title="Haryana">Haryana</option>
					<option title="Himachal Pradesh">Himachal Pradesh</option>
					<option title="Jammu and Kashmir">Jammu and Kashmir</option>
					<option title="Jharkhand">Jharkhand</option>
					<option title="Karnataka">Karnataka</option>
					<option title="Kerala">Kerala</option>
					<option title="Lakshadweep">Lakshadweep</option>
					<option title="Madhya Pradesh">Madhya Pradesh</option>
					<option title="Maharashtra">Maharashtra</option>
					<option title="Manipur">Manipur</option>
					<option title="Meghalaya">Meghalaya</option>
					<option title="Mizoram">Mizoram</option>
					<option title="Nagaland">Nagaland</option>
					<option title="Odisha">Odisha</option>
					<option title="Puducherry">Puducherry</option>
					<option title="Punjab">Punjab</option>
					<option title="Rajasthan">Rajasthan</option>
					<option title="Sikkim">Sikkim</option>
					<option title="Tamil Nadu">Tamil Nadu</option>
					<option title="Telangana">Telangana</option>
					<option title="Tripura">Tripura</option>
					<option title="Uttar Pradesh">Uttar Pradesh</option>
					<option title="Uttarakhand">Uttarakhand</option>
					<option title="West Bengal">West Bengal</option>
				</select>

				<h3>Bank Details</h3>
				Bank Name: <input type="text" name="gs_bank_name" value="" placeholder="Bank Name"
					required> 
				Bank IFSC Code: <input type="text" name="gs_ifsc"
					value="" placeholder="IFSC Code" pattern="/^[A-Za-z]{4}\d{7}$/" required> Bank Account Number: <input type="text"
					name="gs_account_no" value="" placeholder="Account Number" required>

		
				<h3>Your Password</h3>
				Password<input type="password" name="gs_password" id="gs_password"
					pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
					placeholder="Your Password"
					title="Must contain at least one uppercase letter, one digit, one special character and lowercase letter and must be of 8 or more characters"
					required> 
				Confirm Password<input type="password" name="gs_confirm_password"
					id="gs_confirm_password" placeholder="Confirm Password" required>
					
					<h3>Just In Case You Forget Your Password</h3>
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
			        
      
      <button onclick="return Validate()">Register</button>
      <!-- <p class="message">Not registered? <a href="#">Create an account</a></p> -->
    </form>
  </div>
</div>
</body>
</html>