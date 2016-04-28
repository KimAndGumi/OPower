var opowerApp = angular.module('opower', ['ngResource']);
opowerApp.controller('utilisateurs', function($scope,$log,$http,$rootScope,commun){
	$rootScope.afficheOK = false;
	$scope.getListeUtilisateurs = function(){
		/*$http({
			method : 'GET',
			url : opowerRestURI+'person/all'
		}).then(function successCallback(response) {
			$scope.listeUtilisateurs = response.data;
		}, function errorCallback(response) {
			$log.log("probleme");
		});*/
		$rootScope.listeUtilisateurs = [
			{"id":1,"nom":"Ranaivoson","prenom":"Nirina","mail":"coucou1"},
			{"id":2,"nom":"Giffrain","prenom":"Aurélie","mail":"coucou2"},
			{"id":3,"nom":"Ranaivoson","prenom":"Cléa","mail":"coucou3"}
		]
	}
	$scope.afficherInfos = function(idn){
		/*$http({
			method : 'GET',
			url : opowerRestURI+'person/'+id
		}).then(function successCallback(response) {
			$rootScope.utilisateur = response.data;
		}, function errorCallback(response) {
			$log.log("probleme");
		});*/
			$log.log(idn)
		for(i in $rootScope.listeUtilisateurs)
		{
			if ($rootScope.listeUtilisateurs[i].id == idn)
				$rootScope.utilisateur = $rootScope.listeUtilisateurs[i];
				$rootScope.afficheOK = true;
				
		}
	}
})

opowerApp.controller('ajouterUtilisateur', function($scope,$log,$http){
	
})

opowerApp.controller('infoUtilisateur', function($scope,$log,$http){
	
})

opowerApp.factory('commun', function(){
	var prenom ;
	var nom;
	var id;
	return { prenom : prenom, nom : nom, id : id}
})

opowerApp.config(['$resourceProvider', function($resourceProvider) {
    $resourceProvider.defaults.stripTrailingSlashes = false;
}]);

var opowerRestURI = "http://localhost:8080/rest/";