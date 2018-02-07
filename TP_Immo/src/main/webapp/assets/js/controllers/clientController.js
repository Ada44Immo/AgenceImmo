monApp

.controller("findAllClientCtrl", function($scope, clientService) {

	// appel de la methode du service pour recup la liste du WS
	clientService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeClient du scope pour
		// quelle soit accessible de la vue
		$scope.listeClient = callback;
	});
	
})

.controller("addClientCtrl", function($scope, clientService, $location) {
	// initialiser le pays du formulaire
	$scope.clientAjout = {
		nom : '',
		tel:'',
		adresse : {
			cp: '', 
			localite:'', 
			num:'', 
			pays:'', 
			rue:''
		}
		
	}
	// fonction pour soumettre le pays a ajouter
	$scope.ajouterClient = function() {
		// appel de la methode addPays du service
		paysService.addClient($scope.clientAjout, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("liste")
			}
		});
	}

})