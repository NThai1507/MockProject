<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
</head>
<body>
	<div ng-controller="loginController">
		<div class="container-fluid titleLogin">
			<h3>Login</h3>
		</div>
		<div class="container-fluid login_container">

			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6">
					<form class="form-horizontal form-login" 
					name='loginForm' onsubmit="return loginsubmit()" action="<c:url value='j_spring_security_login' />" method='POST'>
						<!-- id="loginMessage" class="hiden_items" -->
						<div id="loginMessage" class="errMessage">${err}</div>
						<div class="form-group">
							<label for="user-name" class="col-sm-2 control-label">Username
							</label>
							<div class="col-sm-10">
								<!-- <cd-input value="user.usersName"></cd-input> -->
								<input class="form-control" type="text"
									ng-model="user.usersName" id="username" name="username"></input>
								<div id="usernameMessage" class="hiden_items">Username
									must be not empty!</div>
							</div>

						</div>
						<div class="form-group">
							<label for="password" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<!-- <cd-input value="user.passwords"></cd-input> -->
								<input class="form-control" type="password"
									ng-model="user.passwords" id="password" name="password"></input>
								<div id="passMessage" class="hiden_items">Password must be
									not empty!</div>
							</div>
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-5">
								<button type="submit" class="login-items btn btn-primary"
									name="submit" value="login" id="login-btn">Login</button>
								<!-- <button type="submit" class="login-items btn btn-primary"
								id="login-btn" ng-click="login()">Login</button> -->
							</div>
							<div class="col-sm-5 ">
								<button type="reset" class="  btn btn-default login-items">Reset</button>
							</div>
						</div>
					</form>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 mesage-system">

					<div class="my_panel">
						<div class="my-panel-title">Welcome to Fsoft HR Utility</div>
						<div class="my-panel-body">
							This tool is developed to help Employees, Project Managers, BU

							Managers, FSU Leads, HR (SSC, BP, Manager), CTC, FWA, QA in

							submitting HR related informations, approving the submitted info,

							monitoring status of your submissions and further more <br>
							<a class="left"
								href="/fhu/resources/tutorials/HR_UTILITY_User_Guide_v3.pdf"
								target="_blank" class="more">More...</a>
						</div>
						<div class="my-panel-bottom">
							<i id="blinking" style="display: inline;">The recommended web
								browser is <b style="color: rgb(0, 112, 192)">G</b><b
								style="color: rgb(255, 0, 0)">o</b><b
								style="color: rgb(204, 155, 0)">o</b><b
								style="color: rgb(0, 112, 192)">g</b><b
								style="color: rgb(0, 176, 80)">l</b><b
								style="color: rgb(255, 0, 0)">e</b> <b style="color: black">Chrome</b>.
								Sorry for any inconvenience!!!
							</i>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
</body>
</html>