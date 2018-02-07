
monApp.factory("clientService",function($http){
	
	//declartion de l'url source du projet webservice
	var urlWS='http://localhost:8080/TP_Immo/client/';
	
	//************************************GET ALL Client**************************************************************	
	//definition de la fonction pour recuperer la liste
	function recupListe(callback){
		// appel du webservice via le service $http(il est basé sur ajax(le bus
		// transporte la requete et recupere le resultat
		// du WS : XMLHttpRequest (XHR))

		$http({
			method : "GET",// methode http
			url : urlWS+'liste'// url de la methode dans le WS
		}).then(function success(reponse) {
			//stocker la reponse dans callback afin de le transporter au controller
			callback(reponse.data)
	
		}, function erreur(reponse) {
			console.log("--------- Erreur du serveur pour liste : "+reponse.status+" "+reponse.statusText)
		})
		
	}
	
//************************************ADD Client**************************************************************
	
	function ajoutClient(paysAjout,callback){
		$http({
	
			method : "POST",// methode http
			url : urlWS+'add',// url de la methode dans le WS
			data:angular.toJson(clientAjout),//les données encapsulé dans le corps de la requete http
			header:{'content-type':"application/json"}
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour ajout : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************UPDATE PAYS**************************************************************
	
	function modifClient(clientModif,callback){
		$http({
	
			method : "PUT",// methode http
			url : urlWS+'update',// url de la methode dans le WS
			data:angular.toJson(clientModif),//les données encapsulé dans le corps de la requete http
			header:{'content-type':"application/json"}
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour modif : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************DELETE PAYS**************************************************************
	
	function supprClient(clientSupp,callback){
		$http({
	
			method : "DELETE",// methode http
			url : urlWS+'delete',// url de la methode dans le WS
			data:angular.toJson(clientSupp),//les données encapsulé dans le corps de la requete http
			header:{'content-type':"application/json"}
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour delete : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************GET BY ID PAYS**************************************************************
	
	function rechercheClient(nom,callback){
		$http({
	
			method : "GET",// methode http
			url : urlWS+'ByNom?pNom='+nom,// url de la methode dans le WS
		
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.data)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour findByNom : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	
	
	
	
	
	
	return {
		//recuperation de des fonction et utilisation en dehors via un nom de methode
		findListe:recupListe,
		ajoutClient:addClient,
		modifClient:updateClient,
		supprClient:deleteClient,
		rechercheClient:findByNomClient
		
	}
})