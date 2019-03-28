app.config(function($routeProvider) {
	$routeProvider
	.when("/listCandidate",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/scopeCandidate/candidateList.html",
		controller : 'listCandidateController'
	})
	.when("/inpormationTab/:id",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/scopeCandidate/informationTab.html",
		controller : 'informationController'
	})
	.when("/dashboard",
	{
        templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/scopeDashBoard/dasbroad.html",
		controller : 'dashbroadController'
	})
	.when("/create",
	{
        templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/scopeCandidate/createTab.html",
		controller : 'createTabController'
	})	
	.when("/updateTab/:id",
	{
        templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/scopeCandidate/updateTab.html",
		controller : 'updateTabController'
	})	

	.when("/login",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/loginScope/login.jsp",
		controller : 'loginController'
	})
		.when("/errlogin",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/errorScope/must-be-login.jsp",
		controller : 'errLogin'
	})
	
	.when("/404",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/errorScope/404.jsp",
		controller : '404'
	})
		.when("/role_err",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/errorScope/Role.jsp",
		controller : '404'
	})
	
	.when("/",
	{
		templateUrl : "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/loginScope/login.jsp",
		controller : 'loginController'
	})
	.otherwise({redirectTo:'404'});
})