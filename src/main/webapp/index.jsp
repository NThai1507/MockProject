<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="app">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>SB Admin - Bootstrap Admin Template</title>
<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/asset/bootstrap.min.css">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/edit-mode.css">
<link href="<%=request.getContextPath()%>/resources/css/edit-mode.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/index.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/main.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/sb-admin.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/myStyleIndex.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/myStyleDashBroad.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/css_directive_common.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/resources/css/create-candidate.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/resources/asset/jquery-ui.css"
	rel="stylesheet">
<link href="<%=request.getContextPath()%>/resources/css/login.css"
	rel="stylesheet" type="text/css">
<!-- Custom Fonts -->
<link
	href="<%=request.getContextPath()%>/resources/font-awesome/css/all.css"
	rel="stylesheet" type="text/css">


</head>

<body>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-fixed-top custom-nav"
			role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle " data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html"><img class="logo"
					src="<%=request.getContextPath()%>/resources/images/logo.png"
					alt=""></a>
				<ul class="nav navbar-left top-nav">
					<li class="dropdown">
						<h4 class="title-home">FSOFT HR UTILITY</h4>
					</li>
				</ul>
			</div>
			<!-- Top Menu Items -->

			<ul class="nav navbar-right top-nav" ng-controller="logoutController" id="wellcome">
				<p class="userInfor">
					Wellcome, <u id="userTitle">${pageContext.request.userPrincipal.name}</u>
					(-FHO.GO-)<br>
					<c:url value="/j_spring_security_logout" var="logoutUrl" />
					<a id="btn-out" href="${logoutUrl}" ng-click="logout()">Log Out</a>
				</p>
				<form></form>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse nav_custom">
				<ul class="nav navbar-nav side-nav">
					<div class="user-role hiden_menu_items  show-items">
						<div class="form-group">
							<label for="email">Your role now is:</label> <input type="text"
								style="font-size: 12px; font-weight: bold; text-align: center;"
								class="form-control" id="role" value="${Role}" disabled>
						</div>
					</div>

					<li class="active hiden_menu_items  show-items"><a
						href="#!/dashboard"><i class="fas fa-chart-line"></i>
							Dashboard</a></li>
					<li class="hiden_menu_items show-items"><a href="#!/404"
						id="login"><i class="fas fa-users"></i> Class Management</a></li>
					<li class="hiden_menu_items show-items"><a
						href="#!/listCandidate" id="candidate-management"><i
							class="fas fa-user-circle"></i> Candidate Management</a></li>
					<li class="hiden_menu_items show-items"><a href="#!/404"
						id="candidate-create"><i class="fas fa-user-tie"></i> Trainer
							Management</a></li>
					<li class="hiden_menu_items show-items"><a href="#!/404"
						id="view"><i class="fas fa-user-graduate"></i> Trainee
							Management</a></li>
					<li class="hiden_menu_items show-items"><a href="#!/404"><i
							class="fas fa-cogs"></i> Genaral Setting</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>


		<!-- start body page -->

		<div ng-view id="sub"></div>

		<!-- end body page -->

		<!-- /#page-wrapper -->
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom footer"
		role="navigation">
		<div class="container footer-items">
			<ul class="nav navbar-nav">
				<li class=""><a href="#"><i class="fas fa-question-circle"></i>
						Help</a></li>
				<li><a href="#"><i class="fas fa-notes-medical"></i> Create
						ticket On FI2.0</a></li>
			</ul>
		</div>

	</nav>
	<!-- /#wrapper -->
	<!-- jQuery -->
	<script
		src="<%=request.getContextPath()%>/resources/asset/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/asset/angular.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/asset/angular-router.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/asset/jquery-ui.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/asset/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/asset/metisMenu.min.js"></script>

	<script src="<%=request.getContextPath()%>/resources/app/app.js"></script>
	<script src="<%=request.getContextPath()%>/resources/app/app-router.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/inputDirective/inputDirective.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/selectDirective/selectDirective.js"></script>
		<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/selectDynamicDirective/selectDynamicDirective.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/checkBoxDirective/checkboxRepeat.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/checkboxSelectDirective/checkBoxSelectDirective.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/radioDirective/radioInputDirective.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/enterDirective/enterDirective.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/directiveApp/dateDirective/dateDirective.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/app-service.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/scopeDashBoard/dashboardController.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/scopeCandidate/candidateListController.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/scopeCandidate/createTabController.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/scopeCandidate/informationTabController.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/scopeCandidate/updateTabController.js"></script>

	<script
		src="<%=request.getContextPath()%>/resources/app/loginScope/loginController.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/errorScope/errLogin.js"></script>
	<script
		src="<%=request.getContextPath()%>/resources/app/loginScope/logoutController.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/loader.js"></script>
	<script src="<%=request.getContextPath()%>/resources/js/load-items.js"></script>

</body>

</html>