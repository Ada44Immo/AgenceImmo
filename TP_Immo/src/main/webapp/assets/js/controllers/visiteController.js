/**
 * 
 */

monApp

.controller("findAllVisiteCtrl", function($scope, visiteService, $rootScope,$location) {
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListeVisite(function(callback){
		// stocker la liste recuperer dans la variable listeVisite du scope pour quelle soit accessible depuis al vue
		$scope.listeVisite=callback;
	});	
})

//Appel de la methode pour recuperer un achat par son id
//Appel de la methode pour recuperer la liste des visites par l'achat
.controller("findVisiteAchatCtrl", function($scope, visiteService, $rootScope,$location) {
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListAchat(function(callback){
		// stocker la liste recuperer dans la variable listeVisiteAchat du scope pour quelle soit accessible depuis al vue
		$scope.listeVisiteAchat=callback;
	});	
})

//Appel de la methode pour recuperer une location par son id
//Appel de la methode pour recuperer la liste des visites par la location
.controller("findVisiteLocCtrl", function($scope, visiteService, $rootScope,$location) {
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListLoc(function(callback){
		// stocker la liste recuperer dans la variable listeVisiteLoc du scope pour quelle soit accessible depuis al vue
		$scope.listeVisiteLoc=callback;
	});	
})

//Appel de la methode pour recuperer un agent par son id
//Appel de la methode pour recuperer la liste des visites par l'agent
.controller("findVisiteAgentCtrl", function($scope, visiteService, $rootScope,$location) {
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListAgent(function(callback){
		// stocker la liste recuperer dans la variable listeVisiteAgent du scope pour quelle soit accessible depuis al vue
		$scope.listeVisiteAgent=callback;
	});	
})

.controller("updateVisiteCtrl", function($scope,visiteService, $location,$rootScope) {
	
	//Initliaiser la visite du formulaire
	$scope.visiteModifier={
		      "id": '',
		      "date": '',
		      "client": '',
		      "location": '',
		      "achat":  '',    
		      "agent":  ''
		   }

	//Fonction pour soumettre le pays à ajouter
	$scope.modifierVisite=function(){
		//Appel de la methode du paysService
		visiteService.updateVisite($scope.visiteModifier,function (callback){
			if(callback=='OK'){
				$location.path("getAllVisite")
			}
		})
		
	}

})

.controller("addVisiteCtrl", function($scope,visiteService, $location,$rootScope) {
	
	//Initliaiser la visite du formulaire
	$scope.visiteAjout={
		      "date": '',
		      "client": '',
		      "location": '',
		      "achat":  '',    
		      "agent":  ''
		   }

	//Fonction pour soumettre le pays à ajouter
	$scope.ajouterVisite=function(){
		//Appel de la methode du paysService
		visiteService.addVisite($scope.visiteAjout,function (callback){
			if(callback=='OK'){
				$location.path("getAllVisite")
			}
		})
		
	}

})

.controller("deleteVisiteCtrl", function($scope, visiteService,$location) {
	//Initliaiser le pays du formulaire
	$scope.id='';
	//Fonction pour soumettre le pays à ajouter
	$scope.supprimerVisite=function(){
		//Appel de la methode du paysService
		visiteService.deleteVisite($scope.id,function (callback){
			if(callback=='OK'){
				$location.path("getAllPays")
			}
		})
		
	}

});
