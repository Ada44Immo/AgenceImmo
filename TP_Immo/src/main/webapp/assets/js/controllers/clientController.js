monApp

.controller("findAllClientCtrl", function($scope, clientService) {

	// appel de la methode du service pour recup la liste du WS
	clientService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeClient du scope pour
		// quelle soit accessible de la vue
		$scope.listeClient = callback;
	});
	
})