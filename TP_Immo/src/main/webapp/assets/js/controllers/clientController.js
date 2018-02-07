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
	// fonction pour soumettre le client a ajouter
	$scope.ajouterClient = function() {
		// appel de la methode addClient du service
		clientService.addClient($scope.clientAjout, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("liste")
			}
		});
	}

})

.controller("updateClientCtrl", function($scope, clientService, $location,$rootScope) {
	$scope.clientModif = {			
			id:'',
			nom : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			}
			
		};
	$scope.modifierClient = function() {
		clientService.updateClient($scope.clientModif, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("liste")
			}
		})
	}

})



.controller("deleteClientCtrl", function($scope, clientService, $location) {

	$scope.clientSupp = {
			
			id:'',
			nom : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			}
			
		};

	$scope.supprimerClient = function() {
		clientService.deleteClient($scope.clientSupp, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("liste")
			}
		})
	}

})

.controller("findByNomClientCtrl", function($scope, clientService,$location,$rootScope) {
	

		$scope.nom = '';
		$scope.indice = false;
	
	// fonction pour soumettre le pays a ajouter
	$scope.rechercherClient = function() {
		// appel de la methode addPays du service
		clientService.findByNomClient($scope.nom, function(callback) {
			if (typeof callback == "object") {
				$scope.clientRecherche = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
})