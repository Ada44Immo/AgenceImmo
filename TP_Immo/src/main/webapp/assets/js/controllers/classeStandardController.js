monApp

.controller("findAllClasseStandardCtrl", function($scope, classeStandardService) {

	// appel de la methode du service pour recup la liste du WS
	classeStandardService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeClient du scope pour
		// quelle soit accessible de la vue
		$scope.listeCS = callback;
	});
	
})