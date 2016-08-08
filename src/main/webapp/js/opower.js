var opowerApp = angular.module('opower', ['ngResource']);
/*opowerApp.controller('utilisateurs', function($scope,$log,$http,$rootScope,commun){
	$rootScope.afficheOK = false;
	$scope.getListeUtilisateurs = function(){
		$http({
			method : 'GET',
			url : opowerRestURI+'person/all'
		}).then(function successCallback(response) {
			$rootScope.listeUtilisateurs = response.data;
		}, function errorCallback(response) {
			$log.log("probleme");
		});
		$rootScope.listeUtilisateurs = [
			{"id":1,"nom":"Ranaivoson","prenom":"Nirina","mail":"coucou1"},
			{"id":2,"nom":"Giffrain","prenom":"Aurélie","mail":"coucou2"},
			{"id":3,"nom":"Ranaivoson","prenom":"Cléa","mail":"coucou3"}
		]
	}
	$scope.afficherInfos = function(idn){
		$http({
			method : 'GET',
			url : opowerRestURI+'person/'+id
		}).then(function successCallback(response) {
			$rootScope.utilisateur = response.data;
		}, function errorCallback(response) {
			$log.log("probleme");
		});
			//$log.log(idn)
		for(i in $rootScope.listeUtilisateurs)
		{
			if ($rootScope.listeUtilisateurs[i].id == idn)
				$rootScope.utilisateur = $rootScope.listeUtilisateurs[i];
				$rootScope.afficheOK = true;
				
		}
	}
})*/

/*opowerApp.controller('ajouterUtilisateur', function($scope,$log,$http){
	$scope.stringData = 'mail='+$scope.formMail
		+'&nom='+$scope.formNom
		+'&prenom='+$scope.formPrenom	
	$scope.poster = function(){
		$log.log($scope.stringData)
		$http({
			method : 'POST',
			url : opowerRestURI+'person/',
			headers : {'Content-Type':'application/x-www-form-urlencoded'},
			data : 'mail='+$scope.formMail
			+'&nom='+$scope.formNom
			+'&prenom='+$scope.formPrenom
		}).then(function successCallback(response) {
			$scope.formOK = false;
		}, function errorCallback(response) {
			$log.log("probleme Post");
		});
	}
	
})*/

opowerApp.controller('usersAdmin', function($scope,$http,$rootScope){
	$scope.showMenu = function(){
		$scope.menuVisible = true;
		$rootScope.homeAdminVisible = false;
		$rootScope.heaterAdminVisible = false;
		$rootScope.elecDeviceAdminVisible = false;
	}
	$scope.post = function(){
		$http({
			method : 'POST',
			url : opowerRestURI+'person/',
			headers : {'Content-Type':'application/x-www-form-urlencoded'},
			data : 'mail='$scope.formMail
			+'&nom='+$scope.formNom
			+'$prenom='+$scope.formPrenom
		}).success(
			$scope.addUserVisible = false;
			$scope.showUserVisible = false;
			$rootScope.usersAdminVisible = true;
			$rootScope.homeAdminVisible = true;
			$rootScope.heaterAdminVisible = true;
			$rootScope.elecDeviceAdminVisible = true;
		);
	}
})

opowerApp.controller('homeAdmin', function($scope,$http,$rootScope){
	$scope.showMenu = function(){
		$scope.menuVisible = true;
		$rootScope.homeAdminVisible = false;
		$rootScope.heaterAdminVisible = false;
		$rootScope.elecDeviceAdminVisible = false;
	}
	$scope.post = function(){
		$http({
			method : 'POST',
			url : opowerRestURI+'person/',
			headers : {'Content-Type':'application/x-www-form-urlencoded'},
			data : 'mail='$scope.formMail
			+'&nom='+$scope.formNom
			+'$prenom='+$scope.formPrenom
		}).success(
			$scope.addUserVisible = false;
			$scope.showUserVisible = false;
		);
	}
})

/*opowerApp.factory('commun', function(){
	var prenom ;
	var nom;
	var id;
	return { prenom : prenom, nom : nom, id : id}
})*/

opowerApp.config(['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

var opowerRestURI = "http://localhost:8080/rest/";