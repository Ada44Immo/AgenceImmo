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
			
			//Fonction pour supprimer grace au lien du tableau
			$scope.supprimerLien=function(visite){
				visiteService.deleteVisite(visite.id, function (deleteCallback){
					if(deleteCallback=='OK'){
						//Appel de la methode du service pour recuperer la liste du ws
						visiteService.findListeVisite(function(callbackList){
							//Stocker la liste recup dans la varivlae listePays pour quelle soit acessible de la vue
							$scope.listeVisite=callbackList;
						});
					}
				})
			}
			
			//Initialiser les données à envoyer dans le rootScope
			$rootScope.id = ''
			$rootScope.date = ''
			$rootScope.idC = ''
			$rootScope.idBien = ''
			$rootScope.idAg = ''
			$rootScope.choix = 0
			//Fonction pour modifier grace au lien du tableau
			$scope.modifierLien=function(visite){
				//Stocker les données  dans le rootScope
				$rootScope.id = visite.id
				$rootScope.date = visite.date
				$rootScope.idC = visite.client.id
				$rootScope.idAg = visite.agent.id
				if(visite.location==null || visite.location==undefined)
					{
						//dans le cas d'un achat
						$rootScope.choix=0
						$rootScope.idBien=visite.achat.id
					}else
						{
							//dans le cas d'une location
							$rootScope.choix=1
							$rootScope.idBien=visite.location.id
						}
				//Envoyer les données dans la page modifier
				$location.path("modifVisite")
				
			}
			
			
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
		visiteService.findListAgent($scope.idAgent, function(callback) {
			// stocker la liste recuperer dans la variable listeVisiteAchat du
			// scope pour quelle soit accessible depuis al vue
			$scope.listeVisiteAgent = callback;
		});
	}
})

.controller(
		"updateVisiteCtrl",
		function($scope, visiteService, $location, $rootScope) {
//if($rootScope.id==undefined){
//				
//			// Initliaiser la visite du formulaire
//			$scope.id = ''
//			$scope.date = ''
//			$scope.idC = ''
//			$scope.idBien = ''
//			$scope.idAg = ''
//			$scope.choix = 0
//}else{
	$scope.id=$rootScope.id
	$scope.date=$rootScope.date
	$scope.idC=$rootScope.idC
	$scope.idBien=$rootScope.idBien 
	$scope.idAg=$rootScope.idAg
	$scope.choix=$rootScope.choix
	
//}
			// Fonction pour soumettre le pays à ajouter
			$scope.modifierVisite = function() {
				// Appel de la methode du paysService
				visiteService.updateVisite($scope.id,$scope.date,$scope.idC,$scope.choix,$scope.idBien,$scope.idAg, function(
						callback) {
					if (callback == 'OK') {
						$location.path("listeVisite")
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
