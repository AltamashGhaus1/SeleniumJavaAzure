var app = angular.module('mySanity', ['ngRoute']);

app.controller('sanityController', function($scope, $window, $rootScope) {

   window.onload = initAzureClient;
    $scope.showLoginDiv = true;

    function initAzureClient() {
        console.log("Initializing Azure AD client.");

        const msalConfig = {
            auth: {
//              clientId: "your-client-id", // Replace with your Azure AD client ID
                clientId: "202ad5f3-cbcd-4ead-913b-52ca39abcc29", // Replace with your Azure AD client ID
//                authority: "https://login.microsoftonline.com/common", // Replace with your Azure AD authority
                authority: "https://login.microsoftonline.com/a30a7b14-8864-46e3-bcb6-eef3d4287413", // Replace with your Azure AD authority
//                redirectUri: "http://localhost" // Replace with your redirect URI
                redirectUri: "https://sanity.tcgdigital.com/sanityAutomation/" // Replace with your redirect URI
            }
        };

        const msalInstance = new msal.PublicClientApplication(msalConfig);

        const loginRequest = {
            scopes: ["user.read"]
        };

        document.getElementById("signIn").innerHTML = '<button id="azureSignInButton">Sign INN</button>';


        document.getElementById("signIn").addEventListener("click", function() {
            msalInstance.loginPopup(loginRequest).then(handleAzureResponse).catch(function(error) {
                console.log('handleAzureResponse Error from initAzureClient : ',error);
            });
        });

        // Optionally, prompt the user with a login dialog
        msalInstance.handleRedirectPromise().then(handleAzureResponse).catch(function(error) {
            console.log(error);
        });
    }

    function handleAzureResponse(response) {
        console.log('Function -> handleAzureResponse : ',response);
        var profile = response.account;
        $rootScope.emailTo = profile.username;
        $rootScope.emailSelected = angular.copy($scope.emailTo);
        $rootScope.name = profile.name;

        $scope.$apply(function() {
            $scope.showLoginDiv = false;
        });

        console.log($scope.showLoginDiv);
        $window.location.href = "#!home";
    }

    function signIn() {

        /**
         * You can pass a custom request object below. This will override the initial configuration. For more information, visit:
         * https://github.com/AzureAD/microsoft-authentication-library-for-js/blob/dev/lib/msal-browser/docs/request-response-object.md#request
         */

        myMSALObj.loginRedirect(loginRequest);
    }

}).config(function($routeProvider) {
    $routeProvider
    .when("/home", {
        templateUrl: "views/home.html",
        controller: "homeController"
    });
});
