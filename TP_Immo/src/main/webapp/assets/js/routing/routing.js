// creation table de navigation 

monApp.config(function($routeProvider){
	$routeProvider
		//***********************Routing Client***********************************************
		.when("/afficheClient",{
			templateUrl: "views/afficheClient.html",
			controller: "findAllClientCtrl"
		})
		
		.when("/ajoutClient",{
			templateUrl: "views/ajoutClient.html",
			controller: "addClientCtrl"
		})
		
		.when("/supprClient",{
			templateUrl: "views/supprClient.html",
			controller: "deleteClientCtrl"
		})
		
		.when("/modifClient",{
			templateUrl: "views/modifClient.html",
			controller: "updateClientCtrl"
		})
		
		.when("/rechercheClient",{
			templateUrl: "views/rechercheClient.html",
			controller: "findByNomClientCtrl"
		})
		//***********************Routing Visite*************************************************
		.when("/listeVisite",{
			templateUrl: "views/listeVisite.html",
			controller: "findAllVisiteCtrl"
		})
		
		.when("/listeVisiteByAchat",{
			templateUrl: "views/listeVisiteAchat.html",
			controller: "findVisiteAchatCtrl"
		})
		
//		.when("/listeVisite",{
//			templateUrl: "views/listeVisiteLoc.html",
//			controller: "findVisiteLocCtrl"
//		})
		
		.when("/ajoutVisite",{
			templateUrl: "views/ajoutVisite.html",
			controller: "addVisiteCtrl"
		})
		
		.when("/supprimVisite",{
			templateUrl: "views/supprVisite.html",
			controller: "deleteVisiteCtrl"
		})
	
		//******************************ROUTING CLASSE STANDARD**********************************
		.when("/afficheClasseStandard",{
			templateUrl: "views/afficheClasseStandard.html",
			controller: "findAllClasseStandardCtrl"
		})
		
				.when("/ajoutClasseStandard",{
			templateUrl: "views/ajoutClasseStandard.html",
			controller: "addClasseStandardCtrl"
		})
		
		.when("/supprClasseStandard",{
			templateUrl: "views/supprClasseStandard.html",
			controller: "deleteClasseStandardCtrl"
		})
		
		.when("/modifClasseStandard",{
			templateUrl: "views/modifClasseStandard.html",
			controller: "updateClasseStandardCtrl"
		})
		
		.when("/rechercheClasseStandard",{
			templateUrl: "views/rechercheClasseStandard.html",
			controller: "findByNomClasseStandardCtrl"
		})
})