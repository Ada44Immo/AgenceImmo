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
		
		$scope.obtenirCoordineesGPS=function(){

			mapService.getCoordineesGPS($scope.achat,function(callback){
				if (typeof callback=='object'){
					$location.path("map");
				}
			})
		}
})

























