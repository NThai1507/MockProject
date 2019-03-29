app
    .controller(
        "loginController",
        [
            '$scope',
            '$routeParams',
            'serviceFetch',
            function($scope,$routeParams ,serviceFetch) {
                $scope.user = {
                    usersName: "",
                    passwords: ""
                }
                $(".show-items").addClass("hiden_menu_items");
                $("#wellcome").addClass("hiden_menu_items");
            	$scope.Param=$routeParams.error;
            	(function(){
            		serviceFetch
                    .doPost(
                        "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/loginError",$scope.Param )
                    .then(
                        function(res) {
                            console
                                .log("Location Location -> ");
                            $scope.result1 = res.data;
                        },
                        function(err) {
                            console.log(err)
                        });
            	})
            
                $( "#login-btn" ).click(function() {

                	serviceFetch
                    .doPost(
                        "http://localhost:8080/HN_FR_JAVA_18_09_AdminBoard_G2/login",$scope.user )
                    .then(
                        function(res) {
                            console
                                .log("Location Location -> ");
                            $scope.result = res.data;
                        },
                        function(err) {
                            console.log(err)
                        });
                	
                	
                	});
            }
        ]);

$(document).ready(function() {
	
    $("#sub #login-btn").click(function() {
        console.log("load");
        window.location.reload();
    });
});

function loginsubmit() {
    var userName = $("#username").val();
    var password = $("#password").val()
    if (userName == "" || userName == null) {
        $("#usernameMessage").addClass("inputMessage");
        $("#usernameMessage").removeClass("hiden_items");
        $("#loginMessage").addClass("hiden_items");
        $("#loginMessage").removeClass("errMessage");
        $("#passMessage").addClass("hiden_items");
        $("#passMessage").removeClass("inputMessage");
        if (password == "" || password == null) {
            $("#passMessage").addClass("inputMessage");
            $("#passMessage").removeClass("hiden_items");

        }
        return false;
    } else {
        $("#usernameMessage").addClass("hiden_items");
        if (password == "" || password == null) {
            $("#passMessage").addClass("inputMessage");
            $("#passMessage").removeClass("hiden_items");
            return false;

        } else {
            $("#passMessage").addClass("hiden_items");
            $("#usernameMessage").addClass("hiden_items");
            return true;

        }

    }

}
/**/