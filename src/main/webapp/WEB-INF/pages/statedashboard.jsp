
<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>State Dashboard</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
<link href="resources/css/custom.css" rel="stylesheet">


</head>

<body>

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<!-- Logo and responsive toggle -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span
					class="glyphicon glyphicon-globe"></span> National Scholarship
					Portal</a>
			</div>
			<!-- Navbar links -->
			<div class="collapse navbar-collapse" id="navbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#">About Us</a></li>
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">FAQ</a></li>
				</ul>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container -->
	</nav>

	<div class="jumbotron feature"></div>


	<div class="container-fluid">

		<!-- Left Column -->
		<div class="col-sm-3">

			<!-- List-Group Panel -->
			<div class="panel panel-default">
				<div class="panel-heading">
					<h1 class="panel-title">Welcome!</h1>
				</div>
				<div class="list-group">
					<a href="#" class="list-group-item">My Account</a> <a
						href="ViewUpload_state" class="list-group-item">Student
						Application Forms</a> <a href="viewinstitute_data"
						class="list-group-item">Institute Application Forms</a> <a
						href="logout" class="list-group-item">Logout</a>

				</div>
			</div>



		</div>
		<!--/Left Column-->


		<!-- Center Column -->
		<div class="col-sm-6">


			<!-- Articles -->
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-body">
							<h2 class="media-heading">Guidelines For State Nodal Officer</h2>
							<p>
								State Nodal Officer are allowed to verify the scholarship of the
								applying students and also verify the registered forms received
								from the Institute .Officers needs to verify the documents and
								forward them to Ministry for further Verification.<br>
							</p>
						</div>
					</div>
				</article>
			</div>
			<hr>
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-left">


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

							<!-- For Students -->

							<c:if test="${lst !=null and not empty lst}">
								<table border="2px" cellpadding="8px" cellspacing="4px">
									<tr>
										<td>Name</td>
										<td>DOB</td>
										<td>Institute</td>
										<td>Aadhar</td>
										<td>10th Marks</td>
										<td>12th Marks</td>
										<td>Degree</td>
										<td>Income</td>
										<td>Caste</td>
										<td>View</td>

									</tr>


									<c:forEach var="e" items="${lst}">
										<tr>
											<td>${e.gs_name}</td>
											<td>${e.gs_dob}</td>
											<td>${e.gs_insname}</td>
											<td>${e.gs_aadhar}</td>
											<td>${e.gs_metric}</td>
											<td>${e.gs_hsc}</td>
											<td>${e.gs_degree}</td>
											<td>${e.gs_income}</td>
											<td>${e.gs_caste}</td>
											<td><a href="view_state/${e.gs_aadhar}">View</a></td>


										</tr>
									</c:forEach>

								</table>
							</c:if>
						</div>
						<div class="media-body">
							<h2 class="media-heading">
								<a href="#"></a>
							</h2>
							<p>
								<a href="#"></a><br>
							</p>

						</div>
					</div>
				</article>
			</div>
			<hr>
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-left"></div>
						<div class="media-body">
							<h2 class="media-heading">
								<a href="#"></a>
							</h2>
							<p>
								<a href="#"></a><br>
							</p>

						</div>
					</div>
				</article>
			</div>
			<hr>
		</div>
		<!--/Center Column-->




	</div>
	<!--/container-fluid-->

	<footer>
		<div class="small-print">
			<div class="container">
				<p>
					<a href="#">Terms &amp; Conditions</a> | <a href="#">Privacy
						Policy</a> | <a href="#">Contact</a>
				</p>
				<p>Copyright &copy; Example.com 2015</p>
			</div>
		</div>
	</footer>


	<!-- jQuery -->
	<script src="js/jquery-1.11.3.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/bootstrap.min.js"></script>

	<!-- IE10 viewport bug workaround -->
	<script src="js/ie10-viewport-bug-workaround.js"></script>

	<!-- Placeholder Images -->
	<script src="js/holder.min.js"></script>

</body>

</html>
