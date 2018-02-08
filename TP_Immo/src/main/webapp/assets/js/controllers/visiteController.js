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


.controller("findVisiteAchatCtrl", function($scope, visiteService) {
	$scope.idAchat=''
	// Appel de la methode du service pour recuperer la liste du ws
	visiteService.findListAchat($scope.idAchat,function(callback){
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
	$scope.date=''
	$scope.idC=''
	$scope.idBien=''
	$scope.idAg=''
		
	$scope.choix=0

	//Fonction pour soumettre le pays à ajouter
	$scope.ajouterVisite=function(){
		//Appel de la methode du paysService
		visiteService.addVisite($scope.idC,$scope.date,$scope.idAg,$scope.choix,$scope.idBien,function (callback){
			if(callback=='OK'){
				$location.path("listeVisite")
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
				$location.path("listeVisite")
			}
		})
		
	}

});
