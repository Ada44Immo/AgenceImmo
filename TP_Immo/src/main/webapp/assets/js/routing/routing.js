// creation table de navigation 

monApp.config(function($routeProvider){
	$routeProvider
	
		.when("/afficheClient",{
			templateUrl: "views/afficheClient.html",
			controller: "findAllClientCtrl"
		})
		
		.when("/listeVisite",{
			templateUrl: "views/listeVisite.html",
			controller: "findAllVisiteCtrl"
		})
	
	
})