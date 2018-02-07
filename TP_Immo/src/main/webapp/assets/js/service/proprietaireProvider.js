monApp.factory("proprietaireService", function($http){
	
	var urlWS='http://localhost:8080/TP_Immo/proprietaire/';
	
	function recupListe(callback){
		$http({
			method : "GET",
			url : urlWS + 'liste'
		}).then(function success(reponse){
			callback(reponse.data)
		}, function erreur(reponse){
			console.log("--------- Erreur du serveur pour liste : "+reponse.status+" "+reponse.statusText)
		})
	}

	function ajoutProprietaire(proprietaireAjout,callback){
		$http({
			method : "POST",
			url : urlWS + 'add',
			data:angular.toJson(proprietaireAjout),
			header:{'content-type':"application/json"}
		}).then(function success(reponse){
			callback(reponse.statusText)
		},
		function erreur(reponse){
			console.log("--------- Erreur du serveur pour ajout : "+reponse.status+" "+reponse.statusText)

		})
	}
	
	
	return {
		findListe : recupListe,
		addProprietaire : ajoutProprietaire
	}
	
})
