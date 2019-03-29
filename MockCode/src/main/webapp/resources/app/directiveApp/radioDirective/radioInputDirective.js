app.directive("cdRadio", function($timeout){
	return {
		scope: {
			value:"=",
			afterCheck:"=",
			attributeName: "@",
		
		},
		controller: function($scope, $element, $attrs, $transclude) {
			
		},
		 restrict: 'E',
		templateUrl: 'http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/directiveApp/radioDirective/radioInput.html',
		replace: true,
		link: function($scope, iElm, iAttrs, controller) {
			var resultGender = "";
//			console.log(console.log($scope.afterCheck[`${$scope.attributeName}`]))
			$timeout(function(){
				$scope.value.forEach(function(item){
					var input = document.createElement("input");
					input.setAttribute("type", "radio");
					input.setAttribute("value", item[`${ $scope.attributeName}`] == "Male"? 1:0);
					input.setAttribute("name", "radioGender")
					$scope.afterCheck == "1" 
					console.log($scope.afterCheck);
					if(item[`${ $scope.attributeName}`] == "Male" && $scope.afterCheck == "1"  ){
						console.log("male")
						input.setAttribute("checked", "true")
					}else if(item[`${ $scope.attributeName}`] == "Female" && $scope.afterCheck == "0"  ){
						console.log("female")
						input.setAttribute("checked", "false")
					}
					
					var b = document.createElement("b");
					b.innerHTML = item[$scope.attributeName];
				
					iElm[0].appendChild(input);
					iElm[0].appendChild(b);
		
				})
				
				iElm.find("input").bind('click', function(event) {
					
					resultGender = this.value;
					$scope.$apply(function(){
						$scope.afterCheck = resultGender; 
						console.log($scope.afterCheck)
					})
					
				});
			},10)

		}
	};
});