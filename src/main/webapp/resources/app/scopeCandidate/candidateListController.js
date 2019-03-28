app.controller('listCandidateController', ['$scope', 'serviceFetch', '$timeout', function ($scope, serviceFetch, $timeout) {
	$scope.listCandidate = [];
	$scope.candidateInformationVo = {};
	$scope.page = 1;
	$scope.result = [];
	$scope.checkAll = false;
	$scope.countTotal = 0;
	$scope.itemPage = [];
	$scope.result = [];
	$scope.resultSelectPage = "";
	var role = $("#role").val();
	$(".hiden_menu_items").removeClass("hiden_menu_items");
	$scope.sizePage = [
		{
			id:1,
			pageSizeAtt: 5
		},
		{
			id:2,
			pageSizeAtt: 10
		},
		{
			id:3,
			pageSizeAtt: 15
		}
	]
	$scope.candidateInformationVo.pageSizeResult = 5;
	
	$scope.$watch("candidateInformationVo.pageSizeResult", function(newValue, oldValue){
		if(newValue != oldValue){
				getCountTotal(newValue);
				$scope.padding(0);
	    		
	    }
	});
	$scope.$watch("resultSelectPage", function(newValue, oldValue){
	    if(newValue != oldValue){
	//    	var ap = newValue['pageSizeAtt'].split("/")[0];
	    	$scope.padding(newValue);
	    }
	});

	 if(role==""||role==null){
	    	
	    	window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/errlogin");
	    	
	    }
	 else{
	    	if(role=="[ROLE_ADMIN]") $("#role").val("ADMIN")
	    	if(role=="[ROLE_MANAGER]") $("#role").val("MANAGER")
	    	if(role=="[ROLE_USER]") $("#role").val("GUEST")
	    	role = $("#role").val();
	    	if(role=="ADMIN"||role=="MANAGER"){
	    		function getCountTotal(item){
	    			serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/countTotal", {}).then(
	    					function (res) {
	    						console.log("Success user -> " );
	    						$scope.countTotal = res.data;
	    						$scope.itemPage = [];
	    						for(var i = 1; i<=Math.ceil($scope.countTotal/item);i++){
	    							var a = i+"/"+Math.ceil($scope.countTotal/item);
	    							$scope.itemPage.push({pageSizeAtt : a});
	    						}
	    						console.log($scope.itemPage)
	    					},
	    					function (err) {
	    						console.log("listAll Failure -> " + err);
	    						console.log(err)
	    					})
	    		}
	    		
	    		
	    		
	    		(function(){
	    			$scope.candidateInformationVo.page = 1;
	    			serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findByPage", $scope.candidateInformationVo).then(
	    				function (res) {
	    					console.log("Success user -> " );
	    					$scope.listCandidate = res.data;
	    					console.log($scope.listCandidate);     
//	    					console.log($scope.sizePage[0].pageSizeAtt) 
	    					getCountTotal($scope.sizePage[0].pageSizeAtt);
	    				},
	    				function (err) {
	    					console.log("listAll Failure -> " + err);
	    					console.log(err)
	    				})
	    				
	    		})();
	    		
	    		
	    		
	    		$scope.search = function(){
	    			$scope.candidateInformationVo.page = 1;
	    			
	    			serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findByPage", $scope.candidateInformationVo).then(
	    				function (res) {
	    					console.log("Success user -> " );
	    					$scope.listCandidate = res.data;
	    					console.log($scope.listCandidate);   
	    					 getCountTotal(res.data.length);
	    				},
	    				function (err) {
	    					console.log("listAll Failure -> " + err);
	    					console.log(err)
	    				})
	    				
	    				
	    		}
	    		
	    		$scope.padding = function(indexPage){
	    			if(typeof indexPage == 'number'){
	    				
	    				$scope.page+=indexPage;
	    				console.log("number "+$scope.page)
	    			}else if(typeof indexPage == 'string'){
	    				
	    				$scope.page = parseInt(indexPage.split("/")[0],10)
	    				console.log("string"+$scope.page)
	    			}
	    			
	    			if($scope.page > 0){
	    				$scope.candidateInformationVo.page = $scope.page;
	    				serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findByPage", $scope.candidateInformationVo).then(
	    					function (res) {
	    						console.log("Success user -> " );
	    						$scope.listCandidate = res.data;
	    						console.log($scope.listCandidate);      
//	    						 getCountTotal$();
	    					},
	    					function (err) {
	    						console.log("listAll Failure -> " + err);
	    						console.log(err)
	    					})
	    			}
	    			
	    			
	    			
	    		}
	    		
	    		
	    		$scope.show = function(){
	    			console.log($scope.candidateInformationVo.pageSizeResult)
	    		}

	    	}
	    	else{
	    		window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/role_err");
	    	}
	 }
	
}]);