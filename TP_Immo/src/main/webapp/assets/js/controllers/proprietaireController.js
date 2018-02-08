monApp
.controller("findAllProprietaireCtrl", function($scope, proprietaireService, $rootScope, $location) {
	
	proprietaireService.findListe(function(callback) {
		$scope.listeProprietaire = callback;
	});
	
	$scope.supprimerLien = function(proprietaire) {
		proprietaireService.deleteProprietaire(proprietaire.id, function(callback) {
			if (callback == 'OK') {
				proprietaireService.findListe(function(callbackList) {
					$scope.listeProprietaire = callbackList;
				});
			}
		})
	};
	
	$rootScope.proprietaireUpdate = {
		id : undefined,
		nom : '',
		tel : '',
		adresse : {
			cp : '',
			localite : '',
			num : '',
			pays : '',
			rue : ''
		}
	}
	
	$scope.modifierLien = function(proprietaire){
		$rootScope.proprietaireUpdate = proprietaire;
		$location.path("modifProprietaire");
	}
	
})

.controller("addProprietaireCtrl", function($scope, proprietaireService, $location) {
		
	$scope.proprietaireAjout = {
		nom : '',
		tel : '',
		adresse : {
			cp : '',
			localite : '',
			num : '',
			pays : '',
			rue : ''
		}
	}
		
	$scope.ajouterProprietaire = function() {
		proprietaireService.addProprietaire($scope.proprietaireAjout, function (callback) {
			if (callback == 'OK') {
				$location.path("afficheProprietaire")
			}
		});
	}
})

.controller("updateProprietaireCtrl", function($scope, proprietaireService, $location, $rootScope) {
	
	if($rootScope.proprietaireUpdate == undefined || $rootScope.proprietaireUpdate.id == undefined) {
		$scope.proprietaireModif = {
			id : '',
			nom : '',
			tel : '',
			adresse : {
				cp : '',
				localite : '',
				num : '',
				pays : '',
				rue : ''
			}
		};
	}else {
		$scope.proprietaireModif = $rootScope.proprietaireUpdate;
	};
	
	$scope.modifierProprietaire = function() {
		proprietaireService.updateProprietaire($scope.proprietaireModif, function(callback){
			if (callback == 'OK'){
				$location.path("afficheProprietaire");
			}
		});
	}
})

.controller("deleteProprietaireCtrl", function($scope, proprietaireService, $location) {
	
	$scope.id = '';
	
	$scope.supprimerProprietaire = function(){
		proprietaireService.deleteProprietaire($scope.id, function(callback) {
			if (callback == 'OK'){
				$location.path("afficheProprietaire");
			}
		});
	}
})

.controller("findByNomProprietaireCtrl", function($scope, proprietaireService, $rootScope, $location) {
	$scope.nom = '';
	$scope.indice = false;
	
	$scope.rechercherProprietaire = function() {
		proprietaireService.findByNomProprietaire($scope.nom, function(callback) {
			if (typeof callback == "object") {
				$scope.proprioRecherche = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
				$scope.msg = "Le propriétaire n'existe pas !";
			}
		})
	}
	
	$scope.supprimerLien = function(proprietaire) {
		proprietaireService.deleteProprietaire(proprietaire.id, function(callback) {
			if (callback == 'OK') {
				$location.path("afficheProprietaire");
			}
		})
	}

	$scope.modifierLien = function(proprietaire){
		$rootScope.proprietaireUpdate=proprietaire;
		
		$location.path("modifProprietaire");
	}
	
})
