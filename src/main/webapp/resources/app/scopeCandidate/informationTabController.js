app.controller('informationController', ['$scope', '$routeParams', 'serviceFetch', function ($scope, $routeParams, serviceFetch) {
	$scope.id = $routeParams.id; 
	$scope.showTableEntry = true;
    $scope.showTableInterview = true;
	$scope.candidate = {};
	$(".hiden_menu_items").removeClass("hiden_menu_items");
	(function(){
        serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findCandidateById", $scope.id).then(
         function (res) {
             console.log("Success user -> " );
             $scope.candidate = res.data;
             console.log($scope.candidate);   
             console.log($scope.candidate.candidateProfile.gender);
         },
         function (err) {
             console.log("listAll Failure -> " + err);
             console.log(err)
         })
    })();
	
    // $scope.showTitleCandidate = "create-tab";
    // $scope.showTableEntry = true;
    // $scope.emtryTestComponent = [
    // {
    // date: '10/01/2019',
    // languageValuator: 'phuoc',
    // languagePoint: 10,
    // technicalValuator: 'phuoc',
    // technicalPoint: 10
    // }
    // ];

    // $scope.deleteEmtryTestById = function (id) {

    // $scope.emtryTestComponent.splice(id, 1);
    // }


    // $scope.interviewComponent = [
    // {
    // date: '10/01/2019',
    // interviewr: 'demo',
    // comment: 'this is comment',
    // result: true
    // }
    // ]
    // $scope.deleteInterview = function (id) {
    // $scope.interviewComponent.splice(id, 1);

    // }

    // $scope.result = [
    // {
    // id: 1,
    // name: "pass"
    // },
    // {
    // id: 2,
    // name: "fail"
    // }
    // ]
    // $scope.defaultResult = {
    // id: 1,
    // name: "pass"
    // }

}]);