
<%@ page errorPage="error.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><!DOCTYPE html>
<!-- Template by Quackit.com -->
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Student Dashboard</title>

<!-- Bootstrap Core CSS -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS: You can use this stylesheet to override any Bootstrap styles and/or apply your own styles -->
<link href="resources/css/custom.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<%
		response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1

		response.addHeader("Cache-Control", "no-store, must-revalidate");

		response.addHeader("Cache-Control", "must-revalidate");

		response.addHeader("Pragma", "no-cache"); //HTTP 1.0

		response.setDateHeader("Expires", 0); //Proxies
	%>
	<%
		if (session.getAttribute("str") == null) {
			response.sendRedirect("logout");
		}
	%>


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
						href="applicationStatus" class="list-group-item">Application
						Status</a> <a href="logout" class="list-group-item">Logout</a>

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
						<div class="media-left"></div>
						<div class="media-body"></div>
					</div>
				</article>
			</div>
			<hr>
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-left">Your Status: ${str}</div>

					</div>
				</article>
			</div>
			<hr>
			<div class="row">
				<article class="col-xs-12">
					<div class="media">
						<div class="media-left"></div>

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


	<%
		response.setHeader("Refresh", "5; http://localhost:8585/scholarship/student_redirect");
	%>

</body>

</html>
