var app = angular.module('mySanity', ['ngRoute']);

app.controller('sanityController', function($scope, $http, $window,$rootScope) {


			window.onload = initNewGsuiteClient;
            $scope.showLoginDiv=true;
			function initNewGsuiteClient(){
                    console.log("in new gsuite client.")
                    google.accounts.id.initialize({
                        client_id: "117751164677-hcr2ufg3cbungvgkjtl48q66rah9sm2j.apps.googleusercontent.com",
            //            ux_mode:'redirect',
                        callback: handleGsuiteResponse,
                        login_uri: "authLogin"
                      });
                      google.accounts.id.renderButton(
                        document.getElementById("buttonDiv"),
                        { theme: "outline", size: "medium" }  // customization attributes
                      );
                      google.accounts.id.prompt(); // also display the One Tap dialog
                }

                function handleGsuiteResponse(cr){
                    console.log(cr);
                    console.log(cr.credential);
                    console.log(cr.credential[0]);
                    var credSplit=cr.credential.split(".");
                    console.log(atob(credSplit[0]));
                    console.log(atob(credSplit[1]));
                    var profile=JSON.parse(atob(credSplit[1]));
                    $rootScope.emailTo=profile.email;
                    $rootScope.emailSelected=angular.copy($scope.emailTo);
                    $rootScope.name=profile.name;

                    $scope.showLoginDiv=false;
                    console.log($scope.showLoginDiv);
                    $window.location.href="#!home"
                }

}).config(function($routeProvider) {
        $routeProvider
        .when("/home", {
          templateUrl : "views/home.html",
          controller : "homeController"
        });
      });
