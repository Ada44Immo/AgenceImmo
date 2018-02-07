/**
 * 
 */

monApp

.controller("findAllVisiteCtrl", function($scope, visiteService, $rootScope,$location) {
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListeVisite(function(callback){
		// stocker la liste recuperer dans la variable listePays du scope pour quelle soit accessible depuis al vue
		$scope.listeVisite=callback;
	});
	
})