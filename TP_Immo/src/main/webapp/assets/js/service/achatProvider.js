
monApp.factory("achatService",function($http){
	
	//declartion de l'url source du projet webservice
	var urlWS='http://localhost:8080/TP_Immo/achat/';
	
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
	
	function ajoutAchat(achatAjout,callback){
		achatAjout.photo = achatAjout.photo.base64;
		$http({
	
			method : "POST",// methode http
			url : urlWS+'add?pIdP='+achatAjout.proprietaire.id+'&pNomCS='+achatAjout.cStd.nom,// url de la methode dans le WS
			data:angular.toJson(achatAjout),//les données encapsulé dans le corps de la requete http
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
	
	function modifAchat(achatModif,callback){
		achatModif.photo = achatModif.photo.base64;
		$http({
	
			method : "PUT",// methode http
			url : urlWS+'update',// url de la methode dans le WS
			data:angular.toJson(achatModif),//les données encapsulé dans le corps de la requete http
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
	
	function supprAchat(id,callback){
		$http({
	
			method : "DELETE",// methode http
			url : urlWS+'delete?pId='+id,// url de la methode dans le WS		
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour delete : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************GET BY NOM**************************************************************
	
	function rechercheAchat(id,callback){
		$http({
	
			method : "GET",// methode http
			url : urlWS+'ById?pId='+id,// url de la methode dans le WS
		
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.data)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour findByNom : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//********************************GET BY ID******************************************************
	function rechercheAchatByMC(motCle,callback){
		$http({
	
			method : "GET",// methode http
			url : urlWS+'ByMC?mKey='+motCle,// url de la methode dans le WS
		
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter ua controller
			callback(reponse.data)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour MC : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	
	
	
	return {
		//recuperation de des fonction et utilisation en dehors via un nom de methode
		findListe:recupListe,
		addAchat:ajoutAchat,
		updateAchat:modifAchat,
		deleteAchat:supprAchat,
		findByMCAchat:rechercheAchatByMC,
		findByIdAchat:rechercheAchat
		
	}
})