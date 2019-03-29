app
    .controller(
        'createTabController',
        [
            '$scope',
            '$routeParams',
            'serviceFetch',
            function($scope, $routeParams, serviceFetch) {

		var username = $("#userTitle").text();
                // $scope.titleTab = $routeParams.tabName;
                $scope.candidate = {
                    entryTests: [],
                    interviews: [],
                    histories:[]
                };
                
      			$scope.history ={
     	
     			}
      			$scope.history.historyLog = "Created by " + username;
     			$scope.candidate.histories.push($scope.history);
     			
                $scope.showTableEntry = true;
                $scope.showTableInterview = true;
                $scope.university = [];
                $scope.site = [];
                
//                
//               	var histories = [];
//            	var historyElement = $scope.candidate.histories;
////            	if($scope.candidate.candidateId != 0 && historyElement.length != 0) {
////            		for(var i = 0 ; i < historyElement.length; i++){
////            			var currentHistoty = {
////            					"historyId" : historyElement[i].getAttribute("historyId"),
////            					"historyLog" : historyElement[i].getAttribute("historyLog"),
////            					"candidateId" : historyElement[i].getAttribute("candidateId")
////            			}
////            		}
////            		histories.push(currentHistoty);
////            	};
//            	var history = "";
//            	if(candidateId != 0){
//            		history = {
//                			"historyLog": "<<" + getFormattedDate(new Date()) + ">>" + "Updated by" + "<<" + username + ">>"
//                	};
//            	}else {
//            		history = {
//                			"historyLog": "<<" + getFormattedDate(new Date()) + ">>" + "Created by" + "<<" + username + ">>"
//                	};
//            	}
//            	histories.push(history);
//            	
//            	
            	
                $scope.channel = [];
                $scope.faculty = []
                $(".close-btn").click(function() {
                    window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/listCandidate");
                });
                $scope.listGender = [{
                    id: 1,
                    name: "Male"
                }, {
                    id: 2,
                    name: "Female"
                }]
                $scope.listResult = [
                	{resultName: "Pass"},
                	{resultName: "Fail"}
                ]
                $scope.gender = "";
                
                $(".hiden_menu_items").removeClass(
                    "hiden_menu_items");
                (function() {

                    serviceFetch
                        .doPost(
                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/findCurrentBiggestId", {})
                        .then(
                            function(res) {
                                console
                                    .log("Success Id -> ");

                                $scope.profileId = res.data;
                                console.log("get id")
                                console
                                    .log($scope.candidate)
                            },
                            function(err) {
                                console
                                    .log("Id Failure -> " +
                                        err);
                            });
                    /*
                     * serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/createHistory",username
                     * ).then( function (res) { console.log("Success
                     * username -> " ); $scope.history = res.data;
                     * console.log("history")
                     * console.log($scope.history); }, function
                     * (err) { console.log("history Failure -> " +
                     * err); })
                     */

                    serviceFetch
                        .doPost(
                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllLocation", {})
                        .then(
                            function(res) {
                                console
                                    .log("Success location -> ");
                                $scope.site = res.data;

                            },
                            function(err) {
                                console
                                    .log("listAll Failure -> " +
                                        err);
                            })

                    serviceFetch
                        .doPost(
                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllUniversity", {})
                        .then(
                            function(res) {
                                console
                                    .log("Success university -> ");
                                $scope.university = res.data;

                            },
                            function(err) {
                                console
                                    .log("listAll Failure -> " +
                                        err);
                            })

                    serviceFetch
                        .doPost(
                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllChannel", {})
                        .then(
                            function(res) {
                                console
                                    .log("Success channel -> ");
                                $scope.channel = res.data;

                            },
                            function(err) {
                                console
                                    .log("listAll Failure -> " +
                                        err);
                            })

                    serviceFetch
                        .doPost(
                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllFaculty", {})
                        .then(
                            function(res) {
                                console
                                    .log("Success faculty -> ");
                                $scope.faculty = res.data;

                            },
                            function(err) {
                                console
                                    .log("listAll Failure -> " +
                                        err);
                            })

                })();

                function generateAccount(fullname) {
                    var arrayName = fullname.split(" ");
                    var numberOfSyllables = arrayName.length;
                    var account = arrayName[numberOfSyllables - 1]
                        .toUpperCase();
                    for (var i = 0; i < numberOfSyllables - 1; i++) {
                        account += arrayName[i].charAt(0)
                            .toUpperCase();
                    }
                    console.log(account);
                    return account;
                }

                var forms;
                var files = [];
                $("#file-upload").change(function(event) {
                    files = event.target.files;
                    forms = new FormData();
                    forms.append("file", files[0]);
                })

                $scope.dateChanged = function(date) {
                    console
                        .log($scope.applicationDate +
                            "========");
                };

                $scope.submit = function() {
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
                                    $scope.candidate.candidateProfile.account = generateAccount($scope.candidate.candidateProfile.fullName);
                                    $scope.candidateDemo = {
                                        candidateId: $scope.profileId
                                    }
//                                    $scope.history = {
//                                        historyLog: "Create By :" +
//                                            username,
//                                        candidate: $scope.candidateDemo
//                                    };
                                    console
                                        .log($scope.candidate.candidateProfile.account)
                                    serviceFetch
                                        .doPost(
                                            "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/save",
                                            $scope.candidate)
                                        .then(
                                            function(
                                                res) {
                                                console
                                                    .log("Success save -> ");
                                                alert("Create candidate Success!")
                                                console.log($scope.candidate);
                                                $scope.candidate = {}
//                                                console.log($scope.history)
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
                        $scope.candidate.candidateProfile.account = generateAccount($scope.candidate.candidateProfile.fullName);
                        $scope.candidateDemo = {
                            candidateId: $scope.profileId
                        }
                        $scope.history = {
                            historyLog: "Create By :" + username,
                            candidate: $scope.candidateDemo
                        };
                        console
                            .log($scope.candidate.candidateProfile.account)
                        serviceFetch
                            .doPost(
                                "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/save",
                                $scope.candidate)
                            .then(
                                function(res) {
                                    console
                                        .log("Success faculty -> ");
                                    alert("Create candidate Success!")
                                    $scope.candidate = {}
                                },
                                function(err) {
                                    console
                                        .log("listAll Failure -> " +
                                            err);
                                })

                        //									serviceFetch
                        //											.doPost(
                        //													"http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/createHistory",
                        //													$scope.history)
                        //											.then(
                        //													function(res) {
                        //														console
                        //																.log("Success username -> ");
                        //														$scope.historyResult = res.data;
                        //														console
                        //																.log($scope.historyResult);
                        //													},
                        //													function(err) {
                        //														console
                        //																.log("history Failure -> "
                        //																		+ err);
                        //													})
                    }
                }


                $scope.deleteInterview = function (index, id) {
                    $scope.candidate.interviews.splice(index, 1);
             
             
                 }
                 $scope.deleteEmtryTestById = function (id) {
                      $scope.candidate.entryTests.splice(id, 1);
                     
                 }
            }
        ]);