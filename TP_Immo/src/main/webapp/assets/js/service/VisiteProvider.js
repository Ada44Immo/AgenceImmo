/**
 * 
 */
monApp.factory("visiteService",function($http){
	var urlWS='http://localhost:8080/TP_Immo/visite/';
	
	//Dev de la fonction pour recuperer la liste complete
	function recupListeVisite(callback) {
		$http({
			method: 'GET',
			url:urlWS+'liste' //URL de la methode du WS
		}).then(function success(reponse){
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.data);
		},function error(reponse){
			console.log("-----Erreur du serveur pour liste :" +reponse.status + " " +reponse.statusText );
		});
	};
	
	//Dev de la fonction pour ajouter
	function recupListeVisiteAchat(achat,callback){
		$http({
			method:'POST',
			url:urlWS+'ByAchat',
			data:angular.toJson(achat), //Les données encapsulées dans le corps de la requete http
			header:{
				'content-type':"application/json"
			}
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.data);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};
	
	//Le retour des fonctions du service
	return {
		findListe:recupListeVisite,
		findListAchat:recupListeVisiteAchat
	}
	
})
