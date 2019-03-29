app.controller('dashbroadController', ['$scope', 'serviceFetch', function($scope, serviceFetch) {
    $scope.classList = [];
    $scope.classListCopy = [];
    $scope.classListByLocation = [];
    $scope.classListPlanning = [];
    $scope.classListPlanned = [];
    $scope.classListInprocess = [];
    $scope.LocationName = "";
    $scope.selectedLocation = {
        check: "All"
    };
    $(".hiden_menu_items").removeClass("hiden_menu_items");
    var role = $("#role").val();

    var options1 = {
        'title': 'Planning',
        'width': 400,
        'height': 400
    };
    var options2 = {
        'title': 'Planned',
        'width': 400,
        'height': 400
    };
    var options3 = {
        'title': 'In Process',
        'width': 400,
        'height': 400
    };
    if (role == "" || role == null) {

        window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/errlogin");


    } else {
        if (role == "[ROLE_ADMIN]") $("#role").val("ADMIN")
        if (role == "[ROLE_MANAGER]") $("#role").val("MANAGER")
        if (role == "[ROLE_USER]") $("#role").val("GUEST")
        role = $("#role").val();
        if (role == "ADMIN" || role == "MANAGER") {
            (function() {
                serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/listAllLocation", {}).then(
                    function(res) {
                        console.log("Success class -> ");
                        $scope.Location = res.data;
                        $scope.Location.push({
                            locationId: Location.length,
                            locationName: "All",
                            remark: ""
                        });
                        console.log($scope.Location);
                    },
                    function(err) {
                        console.log(err)
                    });
                serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/getClassByLocation", {}).then(
                    function(res) {
                        console.log("Location Location -> ");
                        $scope.classListByLocation = res.data;
                    },
                    function(err) {
                        console.log(err)
                    });
                serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/getClass", {}).then(
                    function(res) {

                        console.log("Success class -> ");
                        $scope.classList = res.data;
                        $scope.classListCopy = res.data;
                        google.charts.load('current', {
                            'packages': ['corechart']
                        });
                        google.charts.setOnLoadCallback(drawChart);
                        getTable();
                    },
                    function(err) {
                        console.log(err)
                    });
                $("#location-select").change(function() {
                    var selected = $("#location-select").val();
                    $scope.classList = [];
                    serviceFetch.doPost("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/getClass", {}).then(
                        function(res) {
                            if (selected == 0) {
                                $scope.classList = $scope.classListCopy;
                            } else {
                                for (var i = 0; i < $scope.classListByLocation.length; i++) {
                                    if ($scope.classListByLocation[i][3] == selected) {
                                        $scope.classList.push($scope.classListByLocation[i]);
                                    }
                                }

                            }
                            google.charts.load('current', {
                                'packages': ['corechart']
                            });
                            google.charts.setOnLoadCallback(drawChart);
                            getTable();
                        },
                        function(err) {
                            console.log(err)
                        });
                });
            })();
        } else {
            window.location.replace("http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/#!/role_err");
        }
    }


    function addData() {
        $("#chart-items1").addClass("off");
        $("#chart-items2").addClass("off");
        $("#chart-items3").addClass("off");
        $("#table-item-1").addClass("off");
        $("#table-item-2").addClass("off");
        $("#table-item-3").addClass("off");

    };

    function removeAllData() {
        $("#chart-items1").removeClass("off chart-items width-400");
        $("#chart-items2").removeClass("off chart-items width-400");
        $("#chart-items3").removeClass("off chart-items width-400");
        $("#table-item-1").removeClass("off chart-items width-400");
        $("#table-item-2").removeClass("off chart-items width-400");
        $("#table-item-3").removeClass("off chart-items width-400");
    };
    $("#type-select").change(function() {
        var selected = $("#type-select").val();
        if (selected == "chart") {
            $("#charts").removeClass("off");
            $("#tables").addClass("off");

        } else {
            $("#charts").addClass("off");
            $("#tables").removeClass("off");

        }
    });
    $("#status-select").change(function() {
        var selected = $("#status-select").val();
        if (selected == "planning") {
            addData();
            console.log(options1)
            $("#chart-items1").addClass("chart-items width-400");
            $("#chart-items1").removeClass("off");
            $("#table-item-1").addClass("chart-items width-400");
            $("#table-item-1").removeClass("off");

            options1.width = 500;
            drawChart();
        } else if (selected == "planned") {
            addData();
            $("#chart-items2").addClass("chart-items width-400");
            $("#table-item-2").addClass("chart-items width-400");
            $("#chart-items2").removeClass("off");
            $("#table-item-2").removeClass("off");
            options2.width = 500;
            drawChart();
        } else if (selected == "in-process") {
            addData();
            $("#chart-items3").addClass("chart-items width-400 ");
            $("#table-item-3").addClass("chart-items width-400");
            $("#chart-items3").removeClass("off");
            $("#table-item-3").removeClass("off");
            options3.width = 500;
            drawChart();
        } else {
            options1.width = 400;
            options2.width = 400;
            options3.width = 400;
            removeAllData();
            drawChart();
        }
    });
    /*    $scope.Change=function() {
    		  var selected=$( "#location-select" ).val();
    		  console.log(selected);
    			$scope.classList=[];
    		if(selected==0){
    			$scope.classList=$scope.classListCopy;
    		}else{
    			for(var i=0;i<$scope.classListByLocation.length;i++){
    				if($scope.classListByLocation[i][3]==selected){
    					$scope.classList.push($scope.classListByLocation[i]);
    				}
    			}

    		}
    		console.log($scope.classList)
    		getTable();
            google.charts.load('current', { 'packages': ['corechart'] });
            google.charts.setOnLoadCallback(drawChart);
            $scope.refresh();
    		};*/
    $(document).ready(function() {

    });
    /*
     */
    function getTable() {
        $scope.classListPlanning = [];
        $scope.classListPlanned = [];
        $scope.classListInprocess = [];
        for (i = 0; i < $scope.classList.length; i++) {
            if ($scope.classList[i][1] == "Planning") {
                $scope.classListPlanning.push($scope.classList[i]);

            } else if ($scope.classList[i][1] == "Planned") {
                $scope.classListPlanned.push($scope.classList[i]);

            } else {
                $scope.classListInprocess.push($scope.classList[i]);
            }
        }
    }

    function drawChart() {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        var data1 = new google.visualization.DataTable();
        data1.addColumn('string', 'Topping');
        data1.addColumn('number', 'Slices');
        var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'Topping');
        data2.addColumn('number', 'Slices');
        var i = 0;
        for (i = 0; i < $scope.classList.length; i++) {
            if ($scope.classList[i][1] == "Planning") {
                $scope.classListPlanning.push($scope.classList[i]);
                data.addRows([
                    [$scope.classList[i][0], $scope.classList[i][2]],
                ]);
            } else if ($scope.classList[i][1] == "Planned") {
                $scope.classListPlanned.push($scope.classList[i]);
                data1.addRows([
                    [$scope.classList[i][0], $scope.classList[i][2]],
                ]);
            } else {
                $scope.classListInprocess.push($scope.classList[i]);
                data2.addRows([
                    [$scope.classList[i][0], $scope.classList[i][2]],
                ]);
            }
        }
        var chart1 = new google.visualization.PieChart(document.getElementById('chart_div1'));
        chart1.draw(data, options1);
        var chart2 = new google.visualization.PieChart(document.getElementById('chart_div2'));
        chart2.draw(data1, options2);
        var chart3 = new google.visualization.PieChart(document.getElementById('chart_div3'));
        chart3.draw(data2, options3);
    };
}]);