app.controller("logoutController", ['$scope', 'serviceFetch', function($scope, serviceFetch) {
    $scope.logout = function(){
    		 serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/logout",{}).then(
                    function(res) {
                        console.log("Success user -> ");
                        $scope.result = res.data;
                        console.log($scope.result);
                       
                    },
                    function(err) {
                        console.log(err)

                    })
    		
    }
    
}]);