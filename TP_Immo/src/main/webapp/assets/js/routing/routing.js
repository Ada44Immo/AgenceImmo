// creation table de navigation 

monApp.config(function($routeProvider){
	$routeProvider
	
		.when("/client/liste",{
			templateUrl: "views/listeClient.html",
			controller: "findAllClientCtrl"
		})
	
	
})