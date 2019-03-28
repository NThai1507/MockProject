app.directive('cdCheckBoxSelect', function ($timeout, serviceFetch) {
    // Runs during compile
    return {
        scope: {
            value: "=",
            result: "=",
            attributeName: "@",
            attributeUrl: "@",
            attributeAddFunction: "@",
            attributeAddOther: "@"
        },
        controller: function ($scope, $element, $attrs, $transclude) {
        },
        restrict: 'E', 
        templateUrl: 'http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/resources/app/directiveApp/checkboxSelectDirective/checkBoxSelect.html',
        replace: true,
        link: function ($scope, iElm, iAttrs, controller) {
        	
        	$scope.show = false;
        	iElm.find("input").bind("keyup", function(event){
        		event.preventDefault();
        		
        		if (event.keyCode === 13) {
        			var valueInput ={[`${$scope.attributeName}`] : this.value};
        			$scope.$apply(function(){
        				serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/"+$scope.attributeUrl , valueInput).then(
   	    			         function (res) {
   	    			             console.log("directive save success -> " );  
   	    			             $scope.value.splice($scope.value.length, 0, res.data );
   	    			         },
   	    			         function (err) {
   	    			             console.log("save Failure -> " + err);
   	    			         })
        			})
        		  }
        	})
        	$scope.$watch("value", function(newValue, oldValue){
        	    if(newValue != oldValue){
        	    	$timeout(function(){ 
        	    		iElm.find("div").bind("click", function(event){
        	    			var checkBoxObj = this.children[0].value;
            	    		$scope.$apply(function(){
            	    			if(checkBoxObj != "other"){
            	    				$scope.result = JSON.parse(checkBoxObj);
            	    			}
            	    			if(checkBoxObj == "other"){
            	    				$scope.show = true;
            	    			}else{
            	    				$scope.show = false;
            	    			}
            	    		});
            	    	})
        	    	});
        	    }
        	}, true);
        }
    };
});
