/**
 * 
 */

monApp

.controller("findAllVisiteCtrl",
		function($scope, visiteService, $rootScope, $location) {
			// Appel de la methode du service pour recuperer la liste du ws
			visiteService.findListeVisite(function(callback) {
				// stocker la liste recuperer dans la variable listeVisite du
				// scope pour quelle soit accessible depuis al vue
				$scope.listeVisite = callback;
			});
		})

.controller("findVisiteAchatCtrl", function($scope, visiteService) {
	$scope.idAchat = ''

	$scope.rechercherListAchat = function() {
		// Appel de la methode du service pour recuperer la liste du ws
		visiteService.findListAchat($scope.idAchat, function(callback) {
			// stocker la liste recuperer dans la variable listeVisiteAchat du
			// scope pour quelle soit accessible depuis al vue
			$scope.listeVisiteAchat = callback;
		});
	}
})

// Appel de la methode pour recuperer la liste des visites par la location
.controller("findVisiteLocCtrl", function($scope, visiteService) {
	$scope.idLoc = ''

		$scope.rechercherListLoc = function() {
		// Appel de la methode du service pour recuperer la liste du ws
		visiteService.findListLoc($scope.idLoc, function(callback) {
			// stocker la liste recuperer dans la variable listeVisiteAchat du
			// scope pour quelle soit accessible depuis al vue
			$scope.listeVisiteLoc = callback;
		});
	}
})

.controller("findVisiteAgentCtrl", function($scope, visiteService) {
	$scope.idAgent = ''

		$scope.rechercherListAgent = function() {
		// Appel de la methode du service pour recuperer la liste du ws
		visiteService.findListAgent($scope.idLoc, function(callback) {
			// stocker la liste recuperer dans la variable listeVisiteAchat du
			// scope pour quelle soit accessible depuis al vue
			$scope.listeVisiteAgent = callback;
		});
	}
})

.controller(
		"updateVisiteCtrl",
		function($scope, visiteService, $location, $rootScope) {

			// Initliaiser la visite du formulaire
			$scope.visiteModifier = {
				"id" : '',
				"date" : '',
				"client" : '',
				"location" : '',
				"achat" : '',
				"agent" : ''
			}

			// Fonction pour soumettre le pays à ajouter
			$scope.modifierVisite = function() {
				// Appel de la methode du paysService
				visiteService.updateVisite($scope.visiteModifier, function(
						callback) {
					if (callback == 'OK') {
						$location.path("getAllVisite")
					}
				})

			}

		})

.controller(
		"addVisiteCtrl",
		function($scope, visiteService, $location, $rootScope) {

			// Initliaiser la visite du formulaire
			$scope.date = ''
			$scope.idC = ''
			$scope.idBien = ''
			$scope.idAg = ''

			$scope.choix = 0

			// Fonction pour soumettre le pays à ajouter
			$scope.ajouterVisite = function() {
				// Appel de la methode du paysService
				visiteService.addVisite($scope.idC, $scope.date, $scope.idAg,
						$scope.choix, $scope.idBien, function(callback) {
							if (callback == 'OK') {
								$location.path("listeVisite")
							}
						})

			}

		})

.controller("deleteVisiteCtrl", function($scope, visiteService, $location) {
	// Initliaiser le pays du formulaire
	$scope.id = '';
	// Fonction pour soumettre le pays à ajouter
	$scope.supprimerVisite = function() {
		// Appel de la methode du paysService
		visiteService.deleteVisite($scope.id, function(callback) {
			if (callback == 'OK') {
				$location.path("listeVisite")
			}
		})

	}

});
