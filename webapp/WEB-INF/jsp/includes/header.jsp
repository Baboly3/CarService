<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<!DOCTYPE html>
<html lang="sv">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- <link rel="stylesheet" href="http://code.jquery.com/ui/1.11.3/themes/smoothness/jquery-ui.css"> -->
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<script src="/public/lib/jasny-bootstrap/js/jasny-bootstrap.js"></script>
<script src="http://code.jquery.com/ui/1.11.3/jquery-ui.js"></script>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/data.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<link href="/public/lib/bootstrap-3.1.1/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/public/lib/bootstrap-3.1.1/js/bootstrap.min.js"></script>
<script type="text/javascript" src="excanvas.js"></script>
<script type="text/javascript" src="../jquery.easy-pie-chart.js"></script>

<link href="/public/lib/jasny-bootstrap/css/jasny-bootstrap.css"
	rel="stylesheet">
<!-- Font-awesome -->
<link href="/public/lib/font-awesome/css/font-awesome.css"
	rel="stylesheet">
<link href="/public/lib/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="/public/lib/datepicker/css/datepicker.css" rel="stylesheet">

<!-- My Javascript&CSS -->


<link href="/public/css/styles.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/public/js/cssrefresh.js"></script>
<script src="/public/lib/datepicker/js/bootstrap-datepicker.js"></script>
<script src="/public/js/jscript.js"></script>
<title>Carservice</title>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
</head>
<body>
	<div class="container">

		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="/">Home</a>
				</div>


				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">Service <b class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="/addService">Add Service</a></li>
								<li><a href="/service">Service Manager</a></li>
							</ul></li>
					</ul>
					<form class="navbar-form navbar-left" role="search">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-success but">Search</button>
					</form>
					<div class="navbar-form navbar-left" ><strong>${title}</strong></div>
					<ul class="nav navbar-nav navbar-right">						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><i class="fa fa-car"></i>Car<b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value='/addCar' />">Add Car</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value='/carManager' />">Car Manager</a></li>
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span class="glyphicon glyphicon-user">Customer</span><b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value='/newCustomer' />">Add Customer</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value='/customerManager' />">Customer Manager</a></li>
								
							</ul></li>
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown"><span class="glyphicon glyphicon-stats">Statistics</span><b
								class="caret"></b></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value='/statistic/totalStat' />">Total Chart</a></li>
								<li><a href="<c:url value='/statistic/brandStat' />">Services By Brand</a></li>
								<li class="divider"></li>
								<li><a href="<c:url value='/statistic/dateStat' />">Services Between Dates</a></li>
								<li><a href="<c:url value='/statistic/genderStat' />">Services By Gender</a></li>
								<li><a href="<c:url value='/statistic/yearStat' />">Year Report</a></li>
							</ul></li>
					</ul>
				</div>
				<!-- /.navbar-collapse -->
			</div>
			<!-- /.container-fluid -->
		</nav>
	</div>



	<div class="container">
		<div class="col-md-6" id="UImessage">
			<c:if test="${not empty message}">
				<div class="alert alert-success">${message}</div>
			</c:if>

			<c:if test="${not empty errormessage}">
				<div class="alert alert-danger">${errormessage}</div>
			</c:if>
		</div>
	</div>