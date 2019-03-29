app.directive('cdCheckBox', function() {

	// Runs during compile
	return {
		scope : {
			value : "=",
			result : "=",
			checkAll : "="
		}, // {} = isolate, true = child, false/undefined = no change
		controller : function($scope, $element, $attrs, $transclude) {

		},
		restrict : 'E', 
		 templateUrl: 'http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/directiveApp/checkBoxDirective/checkBox.html',
		replace : true,
		link : function($scope, iElm, iAttrs, controller) {

			if ($scope.checkAll === true) {
				iElm.find("input")[0].checked = true;
				handleCheckbox();
			} else {
				iElm.find("input")[0].checked = false;
				handleCheckbox();
			}

			iElm.find("input").bind('click', function(event) {
				handleCheckbox();
			});

			function handleCheckbox() {
				var obj = $scope.result;
				if (iElm.find("input")[0].checked) {
					
					$scope.$apply(function() {
						$scope.result.push($scope.value);
						console.log($scope.result);
					});
					
				} else {
					for (let i = 0; i < $scope.result.length; i++) {
						if ($scope.value == $scope.result[i]) {
							$scope.$apply(function() {
								$scope.result.splice(i, 1);
								console.log($scope.result);
							});
							
						}
					}
				}
			}

		}
	};
});