app.service('serviceFetch', ['$http', function($http){

    return {
        doPost : function(url, input){
            return $http({
                method: 'POST',
                url: url,
                data: angular.toJson(input),
                header: {
                    'Content-Type': 'application/json'
                }
            });
        },
        
        doGet : function(url){
        	return $http({
        		method: 'GET',
        		url: url
        	})
        }
    }
}])