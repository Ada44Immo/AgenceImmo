monApp

.controller("findAllClasseStandardCtrl", function($scope, classeStandardService, $rootScope,$location) {

	// appel de la methode du service pour recup la liste du WS
	classeStandardService.findListe(function(callback) {
		// stocker la liste recup dans la variable listeCS du scope pour
		// quelle soit accessible de la vue
		$scope.listeCS = callback;
	});
	

	// fonction pour supprimer avec un lien dans la liste
	$scope.supprimLien = function(classeStandard) {
		classeStandardService.deleteClasseStandard(classeStandard.idCode, function(deletecallback) {
			if (deletecallback == 'OK') {
				// appel de la methode du service pour recup la liste du WS
				classeStandardService.findListe(function(callbackList) {
					// stocker la liste recup dans la variable listePays du
					// scope pour quelle soit accessible de la vue
					$scope.listeCS = callbackList;
				});
			}
		})
	}
	// initialiser l'object classe standard dans le rootScope
	
	$rootScope.classeStandardUpdate={
			idCode:undefined,
			modeOffre : '',
			prixMax:'',
			surfaceMin : '',
			type: ''				
	}
	
	// fonction modifier avec un lien dans la liste
	$scope.modifierLien=function(classeStandard){
		// stocker les données du pays recupéré dans le rootscope
		$rootScope.classeStandardUpdate=classeStandard;
		// rediriger vers la vue modif
		$location.path("modifClasseStandard")
	}
	
	
})

.controller("addClasseStandardCtrl", function($scope, classeStandardService, $location) {
	// initialiser le pays du formulaire
	$scope.types = ["a vendre", "a louer"]
	$scope.classeStandardAjout = {
			modeOffre : false,
			prixMax:'',
			surfaceMin : '',
			type: ''	
		
	}
	$scope.test
	
	if( $scope.test=="a louer"){
		$scope.classeStandardAjout.modeOffre = false;
	} else {
		$scope.classeStandardAjout.modeOffre = true;
	}
	
	
	// fonction pour soumettre le classeStandard a ajouter
	$scope.ajouterClasseStandard = function() {
		// appel de la methode addClasseStandard du service
		classeStandardService.addClasseStandard($scope.classeStandardAjout, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClasseStandard")
			}
		});
	}

})

.controller("updateClasseStandardCtrl", function($scope, classeStandardService, $location,$rootScope) {
	
	$scope.types = ["a vendre", "a louer"]
	if($rootScope.classeStandardUpdate.idCode==undefined){
		$scope.classeStandardModif = {			
				idCode:'',
				modeOffre : '',
				prixMax:'',
				surfaceMin : '',
				type: ''	
				
			};
	}else{
		// sinon passage par le lien
		$scope.classeStandardModif=$rootScope.classeStandardUpdate
	}
	$scope.test

	
	$scope.modifierClasseStandard = function() {
		if( $scope.test=="a louer"){
			$scope.classeStandardModif.modeOffre = false;
		} else {
			$scope.classeStandardModif.modeOffre = true;
		}
		classeStandardService.updateClasseStandard($scope.classeStandardModif, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClasseStandard")
			}
		})
	}

})

.controller("deleteClasseStandardCtrl", function($scope, classeStandardService, $location) {

	$scope.id = '';

	$scope.supprimerClasseStandard = function() {
		classeStandardService.deleteClasseStandard($scope.id, function(callback) {
			if (callback == 'OK') {
				// redirection vers la methode afficher la liste
				$location.path("afficheClasseStandard")
			}
		})
	}

})

.controller("findByNomClasseStandardCtrl", function($scope, classeStandardService,$location,$rootScope) {
			
		$scope.nom = '';
		$scope.indice = false;
	
	// fonction pour soumettre le pays a ajouter
	$scope.rechercherClasseStandard = function() {
		// appel de la methode addPays du service
		classeStandardService.findByNomClasseStandard($scope.nom, function(callback) {
			if (typeof callback == "object") {
				$scope.classeStandardRecherche = callback;
				$scope.indice = true;
			} else {
				$scope.indice = false;
			}
		});
	}
})