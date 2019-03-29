app.controller('updateTabController', ['$scope', '$routeParams', 'serviceFetch', function ($scope, $routeParams, serviceFetch) {

    var id = $routeParams.id;

	$(".hiden_menu_items").removeClass("hiden_menu_items");
    $scope.candidate = {};
    $scope.showTableEntry = true;
    $scope.showTableInterview = true;
    $scope.university = [];
    $scope.site = []; 
    $scope.channel = [];
    $scope.faculty = []
    $(".close-btn").click(function(){
		window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/listCandidate");
	});
    $scope.listGender = [
    	{
    		id:1,
    		name: "Male"
    	},
    	{
    		id:2,
    		name: "Female"
    	}
    ]
    $scope.listResult = [
    	{resultName: "Pass"},
    	{resultName: "Fail"}
    ]
    $scope.gender = "";
    
    
	$scope.candidate = {};
	(function(){
        serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findCandidateById", id).then(
         function (res) {
             console.log("Success user -> " );
             $scope.candidate = res.data;
             console.log($scope.candidate);      
         },
         function (err) {
             console.log("listAll Failure -> " + err);
//             console.log(err)
         })
         
         
         serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllUniversity", {}).then(
         function (res) {
             console.log("Success user -> " );
             $scope.university = res.data;
//             console.log($scope.university);      
         },
         function (err) {
             console.log("listAll Failure -> " + err);
//             console.log(err)
         })
         
         serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllLocation", {}).then(
         function (res) {
             console.log("Success user -> " );
             $scope.site = res.data;
             console.log($scope.site);      
         },
         function (err) {
             console.log("listAll Failure -> " + err);
//             console.log(err)
         })
         
         
         serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllChannel", {}).then(
         function (res) {
             console.log("Success user -> " );
             $scope.channel = res.data;
//             console.log($scope.channel);      
         },
         function (err) {
             console.log("listAll Failure -> " + err);
//             console.log(err)
         })
         
         serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllFaculty", {}).then(
         function (res) {
             console.log("Success user -> " );
             $scope.faculty = res.data;
//             console.log($scope.faculty);      
         },
         function (err) {
             console.log("listAll Failure -> " + err);
//             console.log(err)
         })
    })();
	
	 var forms;
     var files = [];
     $("#file-upload").change(function(event) {
         files = event.target.files;
         forms = new FormData();
         forms.append("file", files[0]);
     })
	
	$scope.update = function(){
    	 if (forms !== undefined) {
             $
                 .ajax({
                     url: "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/UploadFile",
                     type: "POST",
                     data: forms,
                     contentType: false,
                     processData: false,
                     enctype: "multipart/form-data",
                     success: function(value) {
                         $scope.candidateDemo = {
                             candidateId: $scope.profileId
                         }
                         console
                             .log($scope.candidate.candidateProfile.account)
                         serviceFetch
                             .doPost(
                                 "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/updateCandidate",
                                 $scope.candidate)
                             .then(
                                 function(
                                     res) {
                                     console
                                         .log("Success faculty -> ");
                                     alert("Update candidate Success!")
//                                     $scope.candidate = {}
                                 },
                                 function(
                                     err) {
                                     console
                                         .log("listAll Failure -> " +
                                             err);
                                 })
                     }
                 })
         } else {

             serviceFetch
                 .doPost(
                     "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/updateCandidate",
                     $scope.candidate)
                 .then(
                     function(res) {
                         console
                             .log("Success faculty -> ");
                         alert("Create candidate Success!")
//                         $scope.candidate = {}
                     },
                     function(err) {
                         console
                             .log("listAll Failure -> " +
                                 err);
                     })

	}
     }
	
	
	$scope.deleteInterview = function (index, id) {
	
       $scope.candidate.interviews.splice(index, 1);
       serviceFetch
       .doPost(
           "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/deleteInterview",
           id)
       .then(
           function(res) {
               console
                   .log("Success faculty -> ");
               alert("delete interview Success!")
//               $scope.candidate = {}
           },
           function(err) {
               console
                   .log("delete interview Failure -> " +
                       err);
           })

    }
	$scope.deleteEmtryTestById = function (id) {
         $scope.candidate.entryTests.splice(id, 1);
         serviceFetch
         .doPost(
             "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/deleteEntryTest",
             id)
         .then(
             function(res) {
                 console
                     .log("Success faculty -> ");
                 alert("delete EntryTest Success!")
//                 $scope.candidate = {}
             },
             function(err) {
                 console
                     .log("delete EntryTest Failure -> " +
                         err);
             })
    }
	
	
	$scope.show = function(){
		console.log($scope.candidate);
	}



}]);