// creation table de navigation 

monApp.config(function($routeProvider){
	$routeProvider
	
		.when("/client/liste",{
			templateUrl: "views/listeClient.html",
			controller: "findAllClientCtrl"
		})
		
		.when("/listeVisite",{
			templateUrl: "views/listeVisite.html",
			controller: "findAllVisiteCtrl"
		})
	
	
})