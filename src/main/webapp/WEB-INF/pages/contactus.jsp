

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box;}

input[type=text], select, textarea {
    width: 100%;
    padding: 12px;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
    margin-top: 6px;
    margin-bottom: 16px;
    resize: vertical;
}

input[type=submit] {
    background-color: #4CAF50;
    color: white;
    padding: 12px 20px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
    background-color: #45a049;
}

.container {
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 20px;
}
</style>
</head>
<body>

<h3>Contact Form</h3>

<div class="container">
  <form action="/action_page.php">
    <label for="fname">First Name</label>
    <input type="text" id="fname" name="firstname" placeholder="Your name..">

    <label for="lname">Last Name</label>
    <input type="text" id="lname" name="lastname" placeholder="Your last name..">

    <label for="country">State</label>
   <select name="gs_state" id="State" title="State" class="required">
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

    <label for="subject">Subject</label>
    <textarea id="subject" name="subject" placeholder="Write something.." style="height:200px"></textarea>

    <input type="submit" value="Submit">
  </form>
</div>

</body>
</html>
