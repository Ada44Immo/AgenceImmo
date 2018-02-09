monApp

.controller("mapCtrl", function($scope, mapService,$location) {
	
		$scope.achat={
				id:undefined,
				etat:'',
				prix : '',
				tel:'',
				adresse : {
					cp: '', 
					localite:'', 
					num:'', 
					pays:'', 
					rue:''
				},
				dateDispo:'',
				dateMiseEnGerance:'',
				description:'',
				revenuCadastral:'',
				statut:'',
				surface:'',
				proprietaire:{
					id: '' 
						},
				cStd:{
					nom: '' 
				},
				photo:null
		}
		
		$rootscope.obtenirCoordineesGPS=function(){

			mapService.getCoordineesGPS($scope.achat,function(callback){
				if (typeof callback=='object'){
					$scope.map=callback;

					$scope.lat=$scope.map.results[0].geometry.location.lat;

					$scope.lng=$scope.map.results[0].geometry.location.lng;
				}
			})
		}
})

























