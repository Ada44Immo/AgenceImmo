
monApp.factory("clientService",function($http){
	
	//declartion de l'url source du projet webservice
	var urlWS='http://localhost:8080/TP_Immo/';
	
	//************************************GET ALL PAYS**************************************************************	
	//definition de la fonction pour recuperer la liste
	function recupListe(callback){
		// appel du webservice via le service $http(il est basé sur ajax(le bus
		// transporte la requete et recupere le resultat
		// du WS : XMLHttpRequest (XHR))

		$http({
			method : "GET",// methode http
			url : urlWS+'client/liste'// url de la methode dans le WS
		}).then(function success(reponse) {
			//stocker la reponse dans callback afin de le transporter au controller
			callback(reponse.data)
	
		}, function erreur(reponse) {
			console.log("--------- Erreur du serveur pour liste : "+reponse.status+" "+reponse.statusText)
		})
		
	}
	
	
	
	
	
	
	
	
	return {
		//recuperation de des fonction et utilisation en dehors via un nom de methode
		findListe:recupListe
		
	}
})