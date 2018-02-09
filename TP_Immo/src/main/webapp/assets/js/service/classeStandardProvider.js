
monApp.factory("classeStandardService",function($http){
	
	//declaration de l'url source du projet webservice
	var urlWS='http://localhost:8080/TP_Immo/cstd/';
	
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
	
	//************************************GET ALL CLASSE STANDARD PAR CLIENT**************************************************************	
	//definition de la fonction pour recuperer la liste
	function recupListe(nom,callback){
		// appel du webservice via le service $http(il est basé sur ajax(le bus
		// transporte la requete et recupere le resultat
		// du WS : XMLHttpRequest (XHR))

		$http({
			method : "GET",// methode http
			url : urlWS+'listeParClient?nom='+nom// url de la methode dans le WS
		}).then(function success(reponse) {
			//stocker la reponse dans callback afin de le transporter au controller
			callback(reponse.data)
	
		}, function erreur(reponse) {
			console.log("--------- Erreur du serveur pour liste : "+reponse.status+" "+reponse.statusText)
		})
		
	}
	
//************************************ADD ClasseStandard**************************************************************
	
	function ajoutClasseStandard(classeStandardAjout,callback){
		$http({
	
			method : "POST",// methode http
			url : urlWS+'add',// url de la methode dans le WS
			data:angular.toJson(classeStandardAjout),//les données encapsulées dans le corps de la requete http
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
	
	//************************************UPDATE ClasseStandard**************************************************************
	
	function modifClasseStandard(classeStandardModif,callback){
		$http({
	
			method : "PUT",// methode http
			url : urlWS+'update',// url de la methode dans le WS
			data:angular.toJson(classeStandardModif),//les données encapsulées dans le corps de la requete http
			header:{'content-type':"application/json"}
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter du controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour modif : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************DELETE ClasseStandard**************************************************************
	
	function supprClasseStandard(id,callback){
		$http({
	
			method : "DELETE",// methode http
			url : urlWS+'delete?pId='+id,// url de la methode dans le WS
		
		
		}).then(
			function success(reponse) {
			//stocker la reponse dans callback afin de le transporter du controller
			callback(reponse.statusText)  			
				},
			function erreur(reponse) {
					console.log("--------- Erreur du serveur pour delete : "+reponse.status+" "+reponse.statusText)
				})
		
	}
	
	//************************************GET BY ID ClasseStandard**************************************************************
	
	function rechercheClasseStandard(nom,callback){
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
		findListeParClient:recupListeParClient,
		addClasseStandard:ajoutClasseStandard,
		updateClasseStandard:modifClasseStandard,
		deleteClasseStandard:supprClasseStandard,
		findByNomClasseStandard:rechercheClasseStandard
		
	}
	

})