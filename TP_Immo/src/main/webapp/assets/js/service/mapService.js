monApp.factory("mapService", function($http) {
	
	function recupCoordGPS(achat,callback){

		$http({
			method : "GET",
			url : 'https://maps.googleapis.com/maps/api/geocode/json?address='
				+'+'+achat.adresse.num
				+'+'+achat.adresse.rue
				+',+'+achat.adresse.localite
				+',+'+achat.adresse.pays
				+'&key=AIzaSyBNbERhjSliTotEcKSzVFsXjtfWD-WmSFw'
		}).then(function success(reponse) {
			console.log(reponse.data)
			callback(reponse.data)
			
		}, function erreur(reponse) {
			console.log("--------- Erreur du serveur pour liste : "+reponse.status+" "+reponse.statusText)
		})
		
	}
	return{
	getCoordineesGPS:recupCoordGPS
	}

})