monApp.factory("acquereurService", function($http) {

	var urlWS='http://localhost:8080/TP_Immo/acquereur/';
	
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
	
	function ajoutAcquereur(acquereurAjout,callback) {
		$http( {
			method : "POST",
			url : urlWS + 'add',
			data:angular.toJson(acquereurAjout),
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
		addAcquereur : ajoutAcquereur,
		//findByNomProprietaire : rechercherProprietaire
	}
	
})
