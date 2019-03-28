app.directive("cdSelected", function($timeout){
	// Runs during compile
	return {
		scope: {
			value:"=",
			afterSelect:"=",
			attributeName: "@"
		}, 
		controller: function($scope, $element, $attrs, $transclude) {
			
		},
		 restrict: 'E', // E = Element, A = Attribute, C = Class, M = Comment
		templateUrl: 'http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/directiveApp/selectDirective/select.html',
		replace: true,
		link: function($scope, iElm, iAttrs, controller) {
			
		 	$scope.$watch("value", function(newValue, oldValue){
		 		$scope.value.forEach(function(item){
		 			var option = document.createElement("option");
		 			option.setAttribute("value", item[`${ $scope.attributeName}`]);
		 			option.innerHTML = item[$scope.attributeName];

		 			iElm[0].appendChild(option);

		 		})

		 	})

		 	$timeout(function(){ 
		 		iElm[0].value = $scope.afterSelect ;
		 		iElm.bind('change', function(event) {
		 			$scope.$apply(function(){
		 				$scope.afterSelect =iElm[0].value; 
		 				console.log(iElm[0].value)              
		 			})

		 		});
		 	},10);

		 }
	};
});