app.directive("cdSelectedDynamic", function($timeout){
	// Runs during compile
	return {
		scope: {
			value:"=",
			afterSelect:"=",
			attributeName: "@",
			pageNow : "@"
		}, 
		controller: function($scope, $element, $attrs, $transclude) {
			
		},
		 restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
		templateUrl: 'http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/directiveApp/selectDynamicDirective/selectDinamic.html',
		replace: true,
		link: function($scope, iElm, iAttrs, controller) {
			$scope.$watch("pageNow", function(newValue, oldValue){
				 if(newValue != oldValue){
				 	console.log($scope.pageNow)
				 	for(let item of $scope.value){
				 		if(item[$scope.attributeName].split("/")[0] == newValue){
				 			iElm[0].value = item[$scope.attributeName];
				 			break;
				 		}
				 	}
				 	// iElm[0].value = 
					console.log(iElm[0].value);
				 }
			})
			
			$timeout(function(){ 
				iElm.bind('change', function(event) {
					$scope.$apply(function(){
						$scope.afterSelect =iElm[0].value; 
					})
					
				});
			},10);
			
		}
	};
});