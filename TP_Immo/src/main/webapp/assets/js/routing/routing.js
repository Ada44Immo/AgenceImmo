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
		
		.when("/ajoutCSClient",{
			templateUrl: "views/ajoutCSClient.html",
			controller: "addCSClientCtrl"
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
		
		.when("/listeVisiteByLoc",{
			templateUrl: "views/listeVisiteLoc.html",
			controller: "findVisiteLocCtrl"
		})
		
		.when("/listeVisiteByAgent",{
			templateUrl: "views/listeVisiteAgent.html",
			controller: "findVisiteAgentCtrl"
		})
		
		.when("/ajoutVisite",{
			templateUrl: "views/ajoutVisite.html",
			controller: "addVisiteCtrl"
		})
		
		.when("/modifVisite",{
			templateUrl: "views/modifVisite.html",
			controller: "updateVisiteCtrl"
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
		
		
		//***********************Routing Proprietaire***********************************************
		
		.when("/afficheProprietaire",{
			templateUrl: "views/afficheProprietaire.html",
			controller: "findAllProprietaireCtrl"
		})
		
		.when("/ajoutProprietaire",{
			templateUrl: "views/ajoutProprietaire.html",
			controller: "addProprietaireCtrl"
		})
		
		.when("/supprProprietaire",{
			templateUrl: "views/supprProprietaire.html",
			controller: "deleteProprietaireCtrl"
		})
		
		.when("/modifProprietaire",{
			templateUrl: "views/modifProprietaire.html",
			controller: "updateProprietaireCtrl"
		})
		
		.when("/rechercheProprietaire",{
			templateUrl: "views/rechercheProprietaire.html",
			controller: "findByNomProprietaireCtrl"
		})
		
		
		//****************Routing map***********************************************
		
		.when("/map",{
			templateUrl:"views/map.html"
		})
		
		//************google agenda**************************************************
		.when("/planning",{
			templateUrl:"views/planning.html",
			
		})
		
		//************google agenda**************************************************
		.when("/affichePhoto",{
			templateUrl:"views/affichePhoto.html",
			
		})
		
		//*****************Achat Routing ********************************************
		
		.when("/afficheAchat",{
			templateUrl: "views/afficheAchat.html",
			controller: "findAllAchatCtrl"
		})
		
		.when("/rechercheAchat",{
			templateUrl: "views/rechercheAchat.html",
			controller: "findByIdAchatCtrl"
		})
		
		.when("/modifAchat",{
			templateUrl: "views/modifAchat.html",
			controller: "updateAchatCtrl"
		})
		
		.when("/supprAchat",{
			templateUrl: "views/supprAchat.html",
			controller: "deleteAchatCtrl"
		})
		
		.when("/rechercheMCAchat",{
			templateUrl: "views/rechercheMCAchat.html",
			controller: "findByMCAchatCtrl"
		})
		.when("/ajoutAchat",{
			templateUrl: "views/ajoutAchat.html",
			controller: "addAchatCtrl"
		})
		
		
		.when("/afficheAchatParCS",{
			templateUrl: "views/listeAchatParCS.html",
			controller: "findParCSAchatCtrl"
		})
		
		.when("/afficheAchatParCSParClient",{
			templateUrl: "views/listeAchatParCSParClient.html",
			controller: "findParCSParClientAchatCtrl"
		})
		
		.when("/attribuerBien",{
			templateUrl: "views/attribuerBien.html",
			controller: "attribuerAcquereurCtrl"
		})
		
		.when("/attribuerBienLoc",{
			templateUrl:"views/attribuerBienLoc.html",
			controller:"attribuerAcquereurLocCtrl"
		})
		
})