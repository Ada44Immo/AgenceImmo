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

	function ajoutProprietaire(proprietaireAjout,callback) {
		$http( {
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
	
	function modifierProprietaire(proprietaireModif,callback) {
		$http( {
			method : "PUT",
			url : urlWS + 'update',
			data : angular.toJson(proprietaireModif),
			header : {'content-type':"application/json"}
		}).then(function success(reponse){
			callback(reponse.statusText)
		},
		function erreur(reponse){
			console.log("--------- Erreur du serveur pour modifier : "+reponse.status+" "+reponse.statusText)
		})
	}
	
	function supprimerProprietaire(id, callback) {
		$http( {
			method : "DELETE",
			url : urlWS + 'delete?pId=' + id
		}).then(function success(reponse){
			callback(reponse.statusText)
		},
		function erreur(reponse){
			console.log("--------- Erreur du serveur pour supprimer : "+reponse.status+" "+reponse.statusText)
		})
	}
	
	function rechercherProprietaire(nom, callback) {
		$http( {
			method : "GET",
			url : urlWS + 'ByNom?pNom=' + nom
		}).then(function success(reponse){
			callback(reponse.data)
		}, function erreur(reponse){
			console.log("--------- Erreur du serveur pour recherche : "+reponse.status+" "+reponse.statusText)
		})
	}
	
	return {
		findListe : recupListe,
		addProprietaire : ajoutProprietaire,
		updateProprietaire : modifierProprietaire,
		deleteProprietaire : supprimerProprietaire,
		findByNomProprietaire : rechercherProprietaire
	}
	
})
