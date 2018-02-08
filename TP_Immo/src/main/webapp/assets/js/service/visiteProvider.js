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
	
	//Dev de la fonction pour recuperer la liste par Achat
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
	
	//Dev de la fonction pour recuperer la liste par Location
	function recupListeVisiteLoc(location,callback){
		$http({
			method:'POST',
			url:urlWS+'ByLoc',
			data:angular.toJson(location), //Les données encapsulées dans le corps de la requete http
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
	
	//Dev de la fonction pour recuperer la liste par Agent
	function recupListeVisiteAgent(agent,callback){
		$http({
			method:'POST',
			url:urlWS+'ByAgent',
			data:angular.toJson(location), //Les données encapsulées dans le corps de la requete http
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
	
	//Dev de la fonction pour ajouter
	function ajoutVisite(visiteAjout,callback){
		$http({
			method:'POST',
			url:urlWS+'add',
			data:angular.toJson(visiteAjout), //Les données encapsulées dans le corps de la requete http
			header:{
				'content-type':"application/json"
			}
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.statusText);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};	
	
	//Dev de la fonction pour supprimer
	function supprimVisite(id,callback){
		$http({
			method:'DELETE',
			url:urlWS+''+id
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.statusText);
		},function error(reponse){
			console.log("-----Erreur du serveur pour delete :" +reponse.status + " " +reponse.statusText );

		});
	};
	
	//Dev de la fonction pour modifier
	function modifVisite(visiteModifier,callback){
		$http({
			method:'PUT',
			url:urlWS+'updatePays',
			data:angular.toJson(visiteModifier), //Les données encapsulées dans le corps de la requete http
			header:{
				'content-type':"application/json"
			}
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.statusText);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};
	//Le retour des fonctions du service
	return {
		findListeVisite:recupListeVisite,
		findListAchat:recupListeVisiteAchat,
		findListLoc:recupListeVisiteLoc,
		findListAgent:recupListeVisiteAgent,
		addVisite:ajoutVisite,
		deleteVisite:supprimVisite,
		updateVisite:modifVisite
	}
	
})
