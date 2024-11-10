app.controller('homeController', function($scope, $http,$rootScope) {
    console.log("in home controller");  // It will be printed, once GSuite id accessed
    console.log($rootScope.emailTo);
    console.log($rootScope.emailSelected);
    console.log($rootScope.name);

//    $scope.myVar="core";

$scope.changeWidth = function() {

        console.log("Hello from ProgressED bar");
        const progress = document.getElementById("progress-done")

        var data = {
                 creator:$rootScope.name
                }

          $http.post("getPercentage", JSON.stringify(data))
          			.then(function(response) {  // till the time rest controller does not send data pointer will not move forward

          				console.log(response.data);

                        $scope.finalvalue = response.data;

                        progress.style.width = $scope.finalvalue+"%";
                        progress.innerText = $scope.finalvalue+"%";

          			})

     };



	/*$scope.postdata = function(urlCore, usernameCore, passwordCore, datasetCore, mailrecCore) {

		//Get input field values
		var data = {
			urlCore: urlCore,
			usernameCore: usernameCore,
			passwordCore: passwordCore,
			datasetCore: datasetCore,
			mailrecCore: mailrecCore
		}

		//Get AJAX - list of data


		//AJAX call after receiving the values
		$http.post("mailids", JSON.stringify(data))
			.then(function(response) {  // till the time rest controller does not send data pointer will not move forward

				//Response from API
				$scope.urlCore = response.data.url;
				$scope.usernameCore = response.data.name;
				$scope.passwordCore = response.data.password;
				$scope.datasetCore = response.data.dataset;
				$scope.mailrecCore = response.data.mailto;

				console.log(response);	// Angular js Data binding , AJAX
			})


	}*/


	/*$scope.getdata = function() {

		$http.get("course")
			.then(function(response) {

				$scope.urlCore = response.data.url;
				$scope.usernameCore = response.data.name;
				$scope.passwordCore = response.data.password;
				$scope.datasetCore = response.data.dataset;
				$scope.mailrecCore = response.data.mailto;

				console.log(response.data);
			})
	}*/

	function clearField() {
		document.getElementById("entryForm").reset();
	}

	function clearFieldInstaller(){
	    document.getElementById("installerform").reset();
	}

    $scope.ajaxStart = function(){
        alert("Automation about to begin, please don't refresh the browser !")
    }

	//----------------------------------------------------LVA-------------------

	/*$scope.postdatalva = function(urlLva, usernameLva, passwordLva, datasetLva, mailrecLva) {

		//Get input field values
		var data = {
			urlLva: urlLva,
			usernameLva: usernameLva,
			passwordLva: passwordLva,
			datasetLva: datasetLva,
			mailrecLva: mailrecLva
		}

		//Get AJAX - list of data


		//AJAX call after receiving the values
		$http.post("mailids", JSON.stringify(data))
			.then(function(response) {  // till the time rest controller does not send data pointer will not move forward

				//Response from API
				$scope.urlLva = response.data.url;
				$scope.usernameLva = response.data.name;
				$scope.passwordLva = response.data.password;
				$scope.datasetLva = response.data.dataset;
				$scope.mailrecLva = response.data.mailto;

				console.log(response);	// Angular js Data binding , AJAX
			})


	}*/


	$scope.getdatalva = function() {

		$scope.getVersion('LVA'); // Hardcoded
	}

	$scope.getdatamcube = function() {

    		$scope.getVersion('MCUBE'); // Hardcoded
    }

    $scope.getdatainstaller = function(){
            $scope.getVersion('INSTALLER');
    }

//$scope.getdatamcube();

$scope.repositories=[];
 $scope.showDetails = function(){
                console.log("hello");
                var data = {
                			creatorMail: $rootScope.emailTo
                }
                $http.post("repIds", JSON.stringify(data)).then(function(response){
                console.log("service called");

               $scope.repositories=response.data.reportDetails;
                console.log("repo--",$scope.repositories);
                $scope.repId = $scope.repositories.repId ;
                 $scope.username = $scope.repositories.username;
                  $scope.creatorMail = $scope.repositories.creatorMail;
                   $scope.creatorTime = $scope.repositories.creatorTime;
                    $scope.report = $scope.repositories.report;

})
                }

//                window.onload = showDetails;

$scope.downloadPDF = function() {
console.log("function called");

}



	//--------------------------------------------------------- Client---------
    $scope.showalert = function() {
        console.log("ALERT")
        $scope.ajaxStart();
        //$window.alert("Automation about to begin, please don't refresh !!!");
        //alertify.alert("Automation about to begin, please don't refresh !!!");
        //$scope.postdataclient(url,username,password,dataset,mailrec,model,myVar);
    }

	$scope.postdataclient = function(url, username, password, dataset, mailrec,model,myVar) {
        console.log(model);  // Client and Version Dropdown as model contains both model.client as well as model.version
        console.log(myVar); // Radio Button Client will be displayed but not in JSON format
		//Get input field values

		if(model.client){ // this line is added because for radio btn mcube and lva -> model.client is not present only model.version is present
		    myVar=model.client; //If client dropdown is present then save client in myVar else radio btn will be client
		}
		var data = {
			url: url,
			username: username,
			password: password,
			dataset: dataset,
			mailrec: mailrec,
			version:JSON.parse(model.version).version, // will save o/p of only response.version and convert the returned type string(array/json etc)
			//to JavaScript Object as WebServer returns String value which needs to be typecasted to JS Object
			client:myVar, // For Mcube and LVA myVar which is radio btn becomes client
			sanityDetailsId:JSON.parse(model.version).id, // Doubt, how model.version.id is saved without actual response o/p
			createdBy:$rootScope.emailTo,  // Doubt
			createdByName:$rootScope.name // Doubt

		}
		//Get AJAX - list of data


		//AJAX call after receiving the values
		/*$http.post("mailids", JSON.stringify(data))
			.then(function(response) {*/  // till the time rest controller does not send data pointer will not move forward

        $http.post("setVersionDetails", JSON.stringify(data)).then(function(response) {


				//Response from API, to not allow the text fields to become blannk after submit click
				$scope.url = response.data.url;
				$scope.username = response.data.username;
				$scope.password = response.data.password;
				$scope.dataset = response.data.dataset;
				$scope.mailrec = response.data.mailto;

				console.log("Send Button response"+response.data);	// Angular js Data binding , AJAX
			})
        $scope.button={};
        $scope.button.disabled=true;

//        $scope.disabledFlag = false;
//        $scope.disabledIt = function(){
//            $scope.disabledFlag= true;
//        }
	}



	$scope.getdataclient = function() {

		$http.get("clients")
			.then(function(response) {

//				$scope.url = response.data.url;
//				$scope.username = response.data.name;
//				$scope.password = response.data.password;
//				$scope.dataset = response.data.dataset;
//				$scope.mailrec = response.data.mailto;

				console.log(response.data); // List of clients will be displayed will be in JSON format only for Client Radio btn
				$scope.clients = response.data;
				$scope.model.client=$scope.clients[0]; // By default 0th client will be shown on screen
				$scope.getVersion($scope.model.client); // Version details will be shown for 0th client
			})
	}

	//--------------------------------------Client Versions------------------



	/*$scope.getclientversion = function() {

		$http.get("clientoption")
			.then(function(response) {

				$scope.clients = ['TAGIC', 'CIGNA', 'LVA', 'NOVOLIN'];
				$scope.versions = {
					TAGIC: ['3.2', '4.3'],
					CIGNA: ['3.3', '4.2'],
					LVA: ['BASF', '4.5'],
					NOVOLIN: ['2.2', '2.5'],
				}

				$scope.getVersion = function(client) {
					return $scope.versions[client];
				}

				console.log(response.data);
			})
	}
	*/


			$scope.model = {};
			$scope.clients = [];
			$scope.versions=[];
			$scope.loginView={};
			$scope.loginView.showLoginDiv="true";
			$scope.emailTo="";
            $scope.emailSelected="";
            $scope.name="";


			$scope.getVersion = function(client) {
				 console.log(client); // Only one word either MCUBE, LVA, OR TAGIC printed on console for Radio MCUBE/LVA but for Client Radio all the clients in dropdown will be printed
				 $http.get("versions?client="+client).then(function(response) {

					// const obj = JSON.parse(response.data);
					// document.getElementById("demo").innerHTML = obj.1;

					// $scope.versions=[response.data];
					// $scope.version =  $scope.versions[1];
					 $scope.versions =  response.data; // List of versions as per the model.client entry from index.html
					 $scope.model.version= JSON.stringify($scope.versions[0]); // 0th version will be displayed inside Index.html by default
				     console.log(response.data); // all ids and versions will be printed just below mcube,lva, tagic printed statement
				     $scope.getDataClientVersion($scope.model.version); // Continuous AJAX call first by using default version present on screen
				})

			}

			$scope.getDataClientVersion=function(versionId){  // this function is called twice, one via default version on screen, 2nd by changing the versions manually
			    console.log(versionId); // id and version by default selected will be printed on console (it will be 0th row because of $scope.versions[0])
			     //and will be printed just below the the list of ids and versions
			    console.log(JSON.parse(versionId)); // id and version will be printed in JSON Object format or JS Object format
			     $http.get("versionDetails?versionId="+JSON.parse(versionId).id).then(function(response) {

                    // const obj = JSON.parse(response.data);
                    // document.getElementById("demo").innerHTML = obj.1;

                    // $scope.versions=[response.data];
                    // $scope.version =  $scope.versions[1];
                     console.log("Get response data : "+response.data);
                     $scope.url = response.data.url;
                    $scope.username = response.data.username;
                    $scope.password = response.data.password;
                    $scope.dataset = response.data.dataset;
                    //$scope.mailrec = response.data.mailto;
                     $scope.mailrec = $rootScope.emailTo;
                })
			}


            $scope.setDataClientVersion=function(url, username,password, dataset, mailrec,model){
                console.log(model);
                        			    //Get input field values
                                        		var data = {
                                        			url: url,
                                        			username: username,
                                        			password: password,
                                        			dataset: dataset,
                                        			mailrec: mailrec
                                        		}
                        			     $http.post("setVersionDetails", JSON.stringify(data)).then(function(response) {
                                             console.log(response.data);

                                        })
                        			}

			window.onload = initNewGsuiteClient;

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
                    $scope.emailTo=profile.email;
                    $scope.emailSelected=angular.copy($scope.emailTo);
                    $scope.name=profile.name;

                    $scope.loginView.showLoginDiv="false";
                    console.log($scope.loginView.showLoginDiv);

                }



});



