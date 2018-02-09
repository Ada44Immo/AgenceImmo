monApp

.controller("findAllAchatCtrl", function($scope, achatService,$location,$rootScope) {

	// appel de la methode du service pour recup la liste du WS
	achatService.findListe(function(callback) {
		// stocker la liste recup dans la variable liste du scope pour
		// quelle soit accessible de la vue
		$scope.listeAchat = callback;
	});
	
	// fonction pour supprimer avec un lien dans la liste
	$scope.supprimLien = function(achat) {
		achatService.deleteAchat(achat.id, function(deletecallback) {
			if (deletecallback == 'OK') {
				// appel de la methode du service pour recup la liste du WS
				achatService.findListe(function(callbackList) {
					// stocker la liste recup dans la variable listePays du
					// scope pour quelle soit accessible de la vue
					$scope.listeAchat = callbackList;
				});
			}
		})
	}
	//initialiser l'object pays dans le rootScope
	
	$rootScope.achatUpdate={
			id:undefined,
			etat:'',
			prix : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			},
			dateDispo:'',
			dateMiseEnGerance:'',
			description:'',
			revenuCadastral:'',
			statut:'disponible',
			surface:'',
			photo:null
			
	
	}
	
	//fonction modifier avec un lien dans la liste
	$scope.modifierLien=function(achat){
		//stocker les données du pays recupéré dans le rootscope
		$rootScope.achatUpdate=achat;
		//rediriger vers la vue modif	
		$location.path("modifAchat")
	}
	
	
})

.controller("findParCSAchatCtrl", function($scope, achatService,$location,$rootScope) {

		$scope.nom = '';
		$scope.indice = false;
	
	$scope.findListeParCS = function() {
		achatService.findListeParCS($scope.nom, function(callback) {
			if (typeof callback !=undefined){
				$scope.listeAchatParCS = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
	
	$scope.supprimLien = function(achat) {
		achatService.deleteAchat(achat.id, function(deletecallback) {
			if (deletecallback == 'OK') {
				achatService.findListeParCS(function(callbackList) {
					$scope.listeAchatParCS = callbackList;
				});
			}
		})
	}
	$rootScope.achatUpdate={
			id:undefined,
			etat:'',
			prix : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			},
			dateDispo:'',
			dateMiseEnGerance:'',
			description:'',
			revenuCadastral:'',
			statut:'disponible',
			surface:''
	}
	
	$scope.modifierLien=function(achat){
		$rootScope.achatUpdate=achat;
		$location.path("modifAchat")
	}
})

.controller("findParCSParClientAchatCtrl", function($scope, achatService,$location,$rootScope) {

		$scope.nom = '';
		$scope.indice = false;
	
	$scope.findListeParCSParClient = function() {
		achatService.findListeParCSParClient($scope.nom, function(callback) {
			if (typeof callback !=undefined){
				$scope.listeAchatParCSParClient = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
	
	$scope.supprimLien = function(achat) {
		achatService.deleteAchat(achat.id, function(deletecallback) {
			if (deletecallback == 'OK') {
				achatService.findListeParCSParClient(function(callbackList) {
					$scope.listeAchatParCSParClient = callbackList;
				});
			}
		})
	}
	$rootScope.achatUpdate={
			id:undefined,
			etat:'',
			prix : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			},
			dateDispo:'',
			dateMiseEnGerance:'',
			description:'',
			revenuCadastral:'',
			statut:'disponible',
			surface:''
	}
	
	$scope.modifierLien=function(achat){
		$rootScope.achatUpdate=achat;
		$location.path("modifAchat")
	}
})

.controller("addAchatCtrl", function($scope, achatService, $location) {
	// initialiser le pays du formulaire
	$scope.achatAjout = {
			etat:'',
			prix : '',
			tel:'',
			adresse : {
				cp: '', 
				localite:'', 
				num:'', 
				pays:'', 
				rue:''
			},
			dateDispo:'',
			dateMiseEnGerance:'',
			description:'',
			revenuCadastral:'',
			statut:'disponible',
			surface:'',
			proprietaire:{
				id: '' 
					},
			cStd:{
				nom: '' 
			},
			photo:null
	}
	// fonction pour soumettre le  a ajouter
	$scope.ajouterAchat = function() {
		// appel de la methode add du service
		achatService.addAchat($scope.achatAjout, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheAchat")
			}
		});
	}

})

.controller("updateAchatCtrl", function($scope, achatService, $location,$rootScope) {
	
	
	if($rootScope.achatUpdate.id==undefined){
		$scope.achatModif = {			
				id:'',
				etat:'',
				prix : '',
				tel:'',
				adresse : {
					cp: '', 
					localite:'', 
					num:'', 
					pays:'', 
					rue:''
				},
				dateDispo:'',
				dateMiseEnGerance:'',
				description:'',
				revenuCadastral:'',
				statut:'disponible',
				surface:'',
				photo:null
			};
	}else{
		//sinon passage par le lien 
		$scope.achatModif=$rootScope.achatUpdate
	}
	
	$scope.modifierAchat = function() {
		achatService.updateAchat($scope.achatModif, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheAchat")
			}
		})
	}

})



.controller("deleteAchatCtrl", function($scope, achatService, $location) {

	$scope.id = '';

	$scope.supprimerAchat = function() {
		achatService.deleteAchat($scope.id, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheAchat")
			}
		})
	}

})

.controller("findByIdAchatCtrl", function($scope, achatService,$location,$rootScope) {
	
		
		$scope.id = '';
		$scope.indice = false;
	
	// fonction pour soumettre le pays a ajouter
	$scope.rechercherAchat = function() {
		// appel de la methode addPays du service
		achatService.findByIdAchat($scope.id, function(callback) {
			if (typeof callback == "object") {
				$scope.achatRecherche = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
	})
	
	.controller("findByMCAchatCtrl", function($scope, achatService,$location,$rootScope) {
	
		
		$scope.motCle = '';
		$scope.indice = false;
		$scope.achatRechercheMC ={};
	// fonction pour soumettre le pays a ajouter
	$scope.rechercherMCAchat = function() {
		// appel de la methode addPays du service
		achatService.findByMCAchat($scope.motCle, function(callback) {
			if (typeof callback == "object") {
				 console.log("------------------------- ");
				 console.log(callback);
				$scope.achatRechercheMC = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
	})
