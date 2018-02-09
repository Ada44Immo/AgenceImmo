monApp

.controller("findAllClientCtrl", function($scope, clientService,$location,$rootScope) {

	// appel de la methode du service pour recup la liste du WS
	clientService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeClient du scope pour
		// quelle soit accessible de la vue
		$scope.listeClient = callback;
	});
	
	// fonction pour supprimer avec un lien dans la liste
	$scope.supprimLien = function(client) {
		clientService.deleteClient(client.id, function(deletecallback) {
			if (deletecallback == 'OK') {
				// appel de la methode du service pour recup la liste du WS
				clientService.findListe(function(callbackList) {
					// stocker la liste recup dans la variable listePays du
					// scope pour quelle soit accessible de la vue
					$scope.listeClient = callbackList;
				});
			}
		})
	}
	//initialiser l'object pays dans le rootScope
	
	$rootScope.clientUpdate={
			id:undefined,
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
	
	//fonction modifier avec un lien dans la liste
	$scope.modifierLien=function(client){
		//stocker les données du pays recupéré dans le rootscope
		$rootScope.clientUpdate=client;
		//rediriger vers la vue modif	
		$location.path("modifClient")
	}
	
	
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
				$location.path("afficheClient")
			}
		});
	}

})

.controller("addCSClientCtrl", function($scope, clientService, $location) {
	// initialiser le pays du formulaire
	$scope.nom = '';
	$scope.nomCS = '';

	
	// fonction pour soumettre le client a ajouter
	$scope.ajouterCSClient = function() {
		
		console.log("---------------------------------------------coucou")
		// appel de la methode addClient du service
		clientService.addCSClient($scope.nomCS,$scope.nom, function(callback) {
			if (callback == 'object') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClient")
			}
		});
	}

})


.controller("updateClientCtrl", function($scope, clientService, $location,$rootScope) {
	
	
	if($rootScope.clientUpdate.id==undefined){
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
	}else{
		//sinon passage par le lien 
		$scope.clientModif=$rootScope.clientUpdate
	}
	
	$scope.modifierClient = function() {
		clientService.updateClient($scope.clientModif, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClient")
			}
		})
	}

})



.controller("deleteClientCtrl", function($scope, clientService, $location) {

	$scope.id = '';

	$scope.supprimerClient = function() {
		clientService.deleteClient($scope.id, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClient")
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
	
