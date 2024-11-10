app.controller('homeController', function($scope, $http,$rootScope) {
    console.log("in home controller");  // It will be printed, once GSuite id accessed
    console.log($rootScope.emailTo);
    console.log($rootScope.emailSelected);
    console.log($rootScope.name);

    $scope.currentclient='';
    $scope.clientinformation='';
//    $scope.myVar="core";

//-----------------------------------Repository-------------------------------------------------
//$scope.isContainerVisible= false
//$scope.toggleContainer = function() {
////      var container = document.getElementById('myContainer');
//    $scope.isContainerVisible = !$scope.isContainerVisible
//
//    console.log("Inside the container")
//      // Toggle the 'hidden' class
//
//    }
//-----------------------------------Client information------------------------------------------------
$scope.isContainerVisible1= false
$scope.repositoryRepId= null

$scope.toggleContainer1 = function() {
//      var container = document.getElementById('myContainer');
    $scope.isContainerVisible1 = !$scope.isContainerVisible1

    console.log("Inside the toggle container")
      // Toggle the 'hidden' class

    }
//------------------------------------------------------------
$scope.repositories=[];
$scope.isContainerVisible= false
 $scope.showDetails = function(){

        $scope.isContainerVisible = !$scope.isContainerVisible
                console.log("hello showDetaiols toggled");
                var data = {
                			creatorMail: $rootScope.emailTo
                }
                if($rootScope.emailTo.includes("mcube")){
                        $http.get("repIdsAll").then(function(response){
                        console.log("All service called");

                        $scope.repositories=response.data.reportDetails;
                        //console.log("repo--",$scope.repositories);
                        $scope.repId = $scope.repositories.repId ;
                        $scope.username = $scope.repositories.username;
//                        $scope.creatorMail = $scope.repositories.creatorMail;
                        $scope.mailto = $scope.repositories.mailto;
                        $scope.creatorTime = $scope.repositories.creatorTime;

                })
                }
                else{
                $http.post("repIds", JSON.stringify(data)).then(function(response){
                console.log("service called");

                    $scope.repositories=response.data.reportDetails;
                    console.log("repo--",$scope.repositories);
                    $scope.repId = $scope.repositories.repId ;
                    $scope.username = $scope.repositories.username;
//                    $scope.creatorMail = $scope.repositories.creatorMail;
                    $scope.mailto = $scope.repositories.mailto;
                    $scope.creatorTime = $scope.repositories.creatorTime;
                    //$scope.report = $scope.repositories.report;

                                })
                    }
           }

$scope.downloadPDF = function() {
console.log("function called");

}

//$scope.downloadBlob = function(repId, creatorTime) {
$scope.downloadBlob = function(repId, creatorTime) {
         //$scope.versions =  response.data; // List of versions as per the model.client entry from index.html
         //$scope.model.version= JSON.stringify($scope.versions[0]); // 0th version will be displayed inside Index.html by default
         //console.log(response.data); // all ids and versions will be printed just below mcube,lva, tagic printed statement
         //$scope.getDataClientVersion($scope.model.version);
         console.log('rep_id : ',repId);
         console.log('creatorTime : ',creatorTime);
//         		var data = {
////         			repId:"567",
//         			idBlob:repId,
////         			creatorTime:creatorTime
//
////         			creatorMail: $rootScope.emailTo
////         			sanityDetailsId:JSON.parse(model.version).id, // Doubt, how model.version.id is saved without actual response o/p
////         			creatorMail:$rootScope.emailTo,  // Doubt
////         			createdByName:$rootScope.name // Doubt
//         		}

//                 $http.post("downloadBlob", JSON.stringify(data)).then(function(response) {
//
//                         $scope.flag = response.data;
//                         console.log("flag valuee----> ",$scope.flag);
//                         if($scope.flag==false){
//                         alert("No report found !!")
//                         }
//                         else{
//                          alert("Report is downloaded in D drive");
//                         }
//
//         				console.log("Download Button is clicked and Response voided");	// Angular js Data binding , AJAX
//                 })
//---------New---------
//                $http.get("versions?client="+client).then(function(response) {
//                $http.get("versionDetails?versionId="+JSON.parse(versionId).id).then(function(response) {
                //$http.get('URL_TO_YOUR_BLOB_FILE', { responseType: 'blob' }).then(function (response) {
                $http.get("downloadBlob?repId="+repId , { responseType: 'arraybuffer' }).then(function (response) {
//                        console.log('Return from downloadBlob', response)
                        $scope.flag = response.data;
                        console.log("flag valuee----> ",$scope.flag);
                        console.log("flag.byteLength size----> ",$scope.flag.byteLength);
                        if($scope.flag.byteLength==0){
                            alert("No Report Found !!")
                        }
                        else{
                            var blob = new Blob([response.data], { type: 'application/octet-stream' });
                            var url = window.URL.createObjectURL(blob);
                            var a = document.createElement('a');
                            a.href = url;
                            //a.download = 'file_name.extension';
                            a.download = 'sanity_automation_'+creatorTime+'.pdf';
                            document.body.appendChild(a);
                            a.click();
                            window.URL.revokeObjectURL(url);
                        }
                });


//        window.location.href = '/downloadBlob';
    }

//$scope.downloadBlob = function(repId, creatorTime) {
//
//console.log("Download Button clicked inside DownLoad File");
//             var data = {
//                idBlob:repId,
//                creatorTime:creatorTime
//             }
//
//                 $http.post("downloadBlob", JSON.stringify(data)).then(function(response) {
//
//                         $scope.flag = response.data;
//                         console.log("File Path -> flag valuee----> ",$scope.flag);
//                         if($scope.flag=="" || $scope.flag=="null"){
//                         alert("No report found !!")
//                         }
//                         else{
//                          alert("Report is downloaded in C drive");
//                         }
//                   console.log("Download Button is clicked and Response voided"); // Angular js Data binding , AJAX
//
//                    //----------------------------------
////                    String filePath = "C:\\sanity_automation_" + creatorTime + ".pdf";
//                var fileUrl = $scope.flag;\
//                console.log("File Path received : ", fileUrl)
//
//                    // Creating a link element
//                    var link = document.createElement('a');
//                    link.href = fileUrl;
//                    link.target = '_blank'; // Open the link in a new tab/window
//
//                    // Triggering the click event on the link
//                    if (navigator.userAgent.indexOf('Chrome') !== -1) {
//                      // For Chrome, use the download attribute to specify the filename
//                      link.download = 'downloaded_file.pdf';
//                    }
//                    document.body.appendChild(link);
//                    link.click();
//                    document.body.removeChild(link);
//                })
//
//  }

//--------------------------------------------------
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
	    $scope.currentclient='LVA';
		$scope.getVersion('LVA'); // Hardcoded
		$scope.isContainerVisible1= false

	}

	$scope.getdatamcube = function() {
	        $scope.currentclient='MCUBE';
    		$scope.getVersion('MCUBE'); // Hardcoded
    		$scope.isContainerVisible1= false

    }

    $scope.getdatainstaller = function(){
            $scope.currentclient='INSTALLER';
            $scope.getVersion('INSTALLER');
            $scope.isContainerVisible1= false
    }

    $scope.getdatacustom = function(){
                $scope.currentclient='CUSTOM';
                //$scope.getVersion('INSTALLER');
                $scope.isContainerVisible1= false
        }

//$scope.getdatamcube();

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

	$scope.postdatacustom = function(url, username, password, dataset, mailrec,model,myVar) {
            console.log(model);  // Client and Version Dropdown as model contains both model.client as well as model.version
            console.log(myVar); // Radio Button Client will be displayed but not in JSON format
    		//Get input field values

    		if(model.client){ // this line is added because for radio btn mcube and lva -> model.client is not present only model.version is present
    		    myVar=model.client; //If client dropdown is present then save client in myVar else radio btn will be client
    		}
    		else if(!model.client && !model.version)
    		{
    		    model.version = url;
    		}
    		console.log('model_version_: ',model.version)

    		var data = {
    			url: url,
    			username: username,
    			password: password,
    			dataset: dataset,
    			mailrec: mailrec,
//    			version:model.version, // wiltl save o/p of only response.version and convert the returned type string(array/json etc)
    			//to JavaScript Object as WebServer returns String value which needs to be typecasted to JS Object
    			client:myVar, // For Mcube and LVA myVar which is radio btn becomes client
//    			sanityDetailsId:JSON.parse(model.version).id, // Doubt, how model.version.id is saved without actual response o/p
    			sanityDetailsId: "999",
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

        $scope.currentclient='CLIENT';
	    $scope.isContainerVisible1= false;

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

	$scope.getdatafeature = function() {

     $scope.currentclient='FEATURE';
	 $scope.isContainerVisible1= false;

    		$http.get("features")
    			.then(function(response) {

    				console.log(response.data); // List of clients will be displayed will be in JSON format only for Client Radio btn
    				$scope.features = response.data;
    				$scope.model.feature=$scope.features[0]; // By default 0th client will be shown on screen
    				$scope.getVersion($scope.model.feature); // Version details will be shown for 0th client
    			})
    	}

    	$scope.getdataregression = function() {

             console.log('Inside Regression js func');
             $scope.currentclient='REGRESSION';
        	 $scope.isContainerVisible1= false;

            		$http.get("regressions")
            			.then(function(response) {

            				console.log(response.data); // List of clients will be displayed will be in JSON format only for Client Radio btn
            				$scope.regressions = response.data;
            				$scope.model.regression=$scope.regressions[0]; // By default 0th client will be shown on screen
            				$scope.getVersion($scope.model.regression); // Version details will be shown for 0th client
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
				 console.log('versions?client=',client); // Only one word either MCUBE, LVA, OR TAGIC printed on console for Radio MCUBE/LVA but for Client Radio all the clients in dropdown will be printed
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
                $scope.isContainerVisible1= false;
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

    $scope.getclientinformation = function(){
      if(typeof $scope.model.version !== 'undefined' && $scope.model.version !== null){
                var selectVersion = JSON.parse($scope.model.version);
                console.log('AG_selectVersion : ',selectVersion);
                console.log('AG_selectVersion.version : ',selectVersion.version)
                $scope.versionName = selectVersion.version
        if($scope.currentclient === 'MCUBE'){
            console.log("Mcube CLient")
            $scope.clientinformation = ""
            if($scope.versionName === '4.3.0.0'){
                console.log("Client in 4.3.0.0 version")
//                $scope.clientinformation = "Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 v Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0Mcube CLient for 4.3.0.0Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0McubMcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0McubMcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0McubMcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0McubMcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0 Mcube CLient for 4.3.0.0Mcubtrdfthgjgvhgghvhghg"

            }else if($scope.versionName === '4.5.0.0'){
                console.log("Client in 4.5.5.0 version")

            }else if($scope.versionName === '4.5.1.0'){
                console.log("Client in 4.5.1.0 version")

            }else if($scope.versionName === '4.5.2.0'){
                console.log("Client in 4.5.2.0 version")

            }
            else if($scope.versionName === 'AI 20 important templates'){
                            console.log("Client in AI 20 important templates")

                        }
            else if($scope.versionName === 'AI concurrent workflow automation'){
                            console.log("Client in AI concurrent workflow automation")

                        }
            else if($scope.versionName === '4.5.3.0'){
                            console.log("Client in 4.5.3.0 version")

                        }
            else if($scope.versionName === 'MDI_4531'){
                                        console.log("Client in MDI_4531")

                                    }
            else if($scope.versionName === '4.5.4.0'){
                                        console.log("Client in 4.5.4.0 version")

                                    }
            else if($scope.versionName === '4.5.5.0'){
                                        console.log("Client in 4.5.5.0 version")

                                    }

            $scope.clientinformationnew($scope.currentclient,$scope.versionName)

        }else if($scope.currentclient === 'LVA'){
            console.log("LVA client");
            $scope.clientinformation = "LVA CLient is here"
            if($scope.versionName === '4.0.1.0'){
                 console.log("Client in 4.0.1.0 version")
                 $scope.clientinformation = "LVA CLient for 4.0.1.0"
            }else if($scope.versionName === '4.1.0.0'){
                 console.log("Client in 4.1.0.0 version")
                 $scope.clientinformation = "LVA CLient for 4.1.0.0"
            }
             $scope.clientinformationnew($scope.currentclient,$scope.versionName)
        }
        else if($scope.currentclient === 'CLIENT'){
                     $scope.clientname=$scope.model.client
                     console.log($scope.clientname);

            if($scope.clientname==="TAGIC"){
                        if($scope.versionName === '3.2.0.0'){
                                       console.log("Client in 3.2.0.0 version")
//                                       $scope.clientinformation = "TAGIC CLient for 3.2.0.0"
                        }
                        else if($scope.versionName === '4.3.0.0'){
                                        console.log("Client in 4.3.0.0 version")
//                                        $scope.clientinformation = "TAGIC CLient for 4.3.0.0"
                        }
                         $scope.clientinformationnew($scope.clientname,$scope.versionName)
            }
            else if($scope.clientname==="CIGNA"){
                                         console.log("CIGNA Client");
//                                         $scope.clientinformation = "CIGNA Client is here"
                                          $scope.clientinformationnew($scope.clientname,$scope.versionName)
            }
            else if($scope.clientname==="IPDS"){
                                         console.log("IPDS Client");
//                                         $scope.clientinformation = "IPDS Client is here"
                                          $scope.clientinformationnew($scope.clientname,$scope.versionName)
                    }
            else if($scope.clientname==="INSTALLER"){
                                         console.log("INSTALLER Client");
//                                         $scope.clientinformation = "INSTALLER Client is here"
                                         $scope.clientinformationnew($scope.clientname,$scope.versionName)
                    }
            else if($scope.clientname==="LUMMUS"){
                                         console.log("LUMMUS Client");
//                                         $scope.clientinformation = "LUMMUS Client is here"
                                         $scope.clientinformationnew($scope.clientname,$scope.versionName)
                    }
            else if($scope.clientname==="CTEC"){
                                         console.log("CTEC Client");
//                                         $scope.clientinformation = "CTEC Client is here"
                                $scope.clientinformationnew($scope.clientname,$scope.versionName)
                    }
            else if($scope.clientname==="Genmab"){
                                         console.log("Genamb Client");
//                                         $scope.clientinformation = "Genmab Client is here"
                                $scope.clientinformationnew($scope.clientname,$scope.versionName)
                    }

        }
        else if($scope.currentclient === 'INSTALLER'){
                    console.log("INSTALLER");
//                    $scope.clientinformation = "INSTALLER is here"
                    if($scope.versionName === '4.2.0.0'){
                         console.log("Client in 4.2.0.0 version")
//                         $scope.clientinformation = "INSTALLER for 4.2.0.0"
                    }else if($scope.versionName === '4.5.2.0'){
                         console.log("INSTALLER 4.5.2.0 version")
//                         $scope.clientinformation = "INSTALLER for 4.5.2.0"
                    }
                     $scope.clientinformationnew($scope.currentclient,$scope.versionName)
                }

        else if($scope.currentclient === 'FEATURE'){
               $scope.clientname= $scope.model.feature
                     console.log($scope.clientname);
                         if($scope.clientname==="Dashboard Calendar Filter"){
                            if($scope.versionName === '4.5.4.0'){
                                console.log("Dashboard Calendar feature in 4.5.4.0 version")
//                                 $scope.clientinformation = "Dashboard Calendar feature for 4.5.4.0"
                             }
                             else if($scope.versionName === '4.5.5.0'){
                                        console.log("Dashboard Calendar feature in 4.5.5.0 version")
//                                        $scope.clientinformation = "Dashboard Calendar feature for 4.5.5.0"
                             }
//                              $scope.clientinformationnew($scope.clientname,$scope.versionName)
                     }
                     if($scope.clientname==="Calender Filter"){
                                                 if($scope.versionName === '4.5.4.0'){
                                                     console.log("Calendar Filter in 4.5.4.0 version")
                     //                                 $scope.clientinformation = "Dashboard Calendar feature for 4.5.4.0"
                                                  }
                                                  else if($scope.versionName === '4.5.5.0'){
                                                             console.log("Calendar Filter in 4.5.5.0 version")
                     //                                        $scope.clientinformation = "Dashboard Calendar feature for 4.5.5.0"
                                                  }
                     //                              $scope.clientinformationnew($scope.clientname,$scope.versionName)
                                          }
                     $scope.clientinformationnew($scope.clientname,$scope.versionName)
         }

        else{
            console.log("Please select client")
            return $scope.currentClient= ''
            return $scope.clientinformation = "Please select the client"

        }
      }
      else if($scope.currentclient === 'CUSTOM'){
                     console.log("CUSTOM");
//                                 $scope.clientinformation = "CUSTOM is here"
                                 $scope.clientinformation("CUSTOM")
      //                           if($scope.versionName === '4.2.0.0'){
      //                                console.log("Client in 4.2.0.0 version")
      //                                $scope.clientinformation = "INSTALLER for 4.2.0.0"
      //                           }else if($scope.versionName === '4.5.2.0'){
      //                                console.log("INSTALLER 4.5.2.0 version")
      //                                $scope.clientinformation = "INSTALLER for 4.5.2.0"
      //                           }
      }
      else{
        $scope.clientinformation = "Please select the client"
      }

    }


    $scope.clientinformationnew = function(model,myVar) {
    var data = null
//                 console.log("AGJS_ClientInfoo:",clientinfo);  // Client and Version Dropdown as model contains both model.client as well as model.version
                if($scope.currentclient!="CLIENT" && $scope.currentclient!="FEATURE"){
                 data = {
                         		    clientName:$scope.currentclient,
                         		    clientVer: myVar// will save o/p of only response.version and convert the returned type string(array/json etc)
                                    			//to JavaScript Object as WebServer returns String value which needs to be typecasted to JS Object

                         		}
                }
                else{
                 data = {
                               clientName:$scope.clientname,
                               clientVer: myVar// will save o/p of only response.version and convert the returned type string(array/json etc)
                                                    			//to JavaScript Object as WebServer returns String value which needs to be typecasted to JS Object

                         }
                }

                console.log("data---",data)
//         		console.log("json........",JSON.parse($scope.model.version).version);


                 $http.post("clientinfoDetails", JSON.stringify(data)).then(function(response) {

                        console.log("clientinformation response"+response.data.product_info);
         				//Response from API, to not allow the text fields to become blannk after submit click
         				$scope.clientinformation = response.data.product_info;
         				console.log("Send Button response"+response.data);	// Angular js Data binding , AJAX
         			})
                 $scope.button={};
                 $scope.button.disabled=true;

         //        $scope.disabledFlag = false;
         //        $scope.disabledIt = function(){
         //            $scope.disabledFlag= true;
         //        }
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



