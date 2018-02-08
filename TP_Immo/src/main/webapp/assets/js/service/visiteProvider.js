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
	function recupListeVisiteAchat(idA,callback){
		$http({
			method:'GET',
			url:urlWS+'ByAchat?idAchat='+idA
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.data);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};
	
	//Dev de la fonction pour recuperer la liste par Location
	function recupListeVisiteLoc(idLoc,callback){
		$http({
			method:'GET',
			url:urlWS+'ByLoc?idLoc='+idLoc
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.data);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};
	
	//Dev de la fonction pour recuperer la liste par Agent
	function recupListeVisiteAgent(idA,callback){
		$http({
			method:'GET',
			url:urlWS+'ByAgent?idAgent='+idA
			
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.data);
		},function error(reponse){
			console.log("-----Erreur du serveur pour ajout :" +reponse.status + " " +reponse.statusText );

		});
	};
	
	
	//Dev de la fonction pour ajouter
	function ajoutVisite(idC,date,idAg,choix,idBien,callback){
		$http({
			method:'POST',
			url:urlWS+'addVisite?idClient='+idC+'&date='+date+'&idAgent='+idAg+'&choix='+choix+'&idBien='+idBien
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
	function modifVisite(id,date,idC,choix,idBien,idAg,callback){
		$http({
			method:'PUT',
			url:urlWS+'update?idClient='+idC+'&date='+date+'&idAgent='+idAg+'&choix='+choix+'&idBien='+idBien+'&idVisite='+id
		}).then(function success(reponse) {
			//Stocker la reponse dans la callback afin de la transporter au controller
			callback(reponse.statusText);
		},function error(reponse){
			console.log("-----Erreur du serveur pour modif :" +reponse.status + " " +reponse.statusText );

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
