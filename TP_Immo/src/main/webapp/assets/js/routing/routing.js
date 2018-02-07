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
	
	
		//******************************ROUTING CLASSE STANDARD**********************************
		.when("/afficheClasseStandard",{
			templateUrl: "views/afficheClasseStandard",
			controller: "findAllClasseStandardCtrl"
		})
})