monApp

.controller("findAllClientCtrl", function($scope, clientService,$location,$rootScope) {

	// appel de la methode du service pour recup la liste du WS
	paysService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeClient du scope pour
		// quelle soit accessible de la vue
		$scope.listeClient = callback;
	});
	
})