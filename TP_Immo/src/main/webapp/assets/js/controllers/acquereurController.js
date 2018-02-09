monApp
.controller("findAllAcquereurCtrl", function($scope, acquereurService) {
	
	acquereurService.findListe(function(callback) {
		$scope.listeAcquereur = callback;
	});
})

.controller("addAcquereurCtrl", function($scope, acquereurService, $location) {
	
	$scope.acquereurAjout = {
			dateAchat : '',
			prix : '',
			nom : '',
			tel : '',
			adresse : {
				cp : '',
				localite : '',
				num : '',
				pays : '',
				rue : ''
		}
	}
	$scope.ajouterAcquereur = function() {
		acquereurService.addAcquereur($scope.acquereurAjout, function (callback) {
			if (callback == 'OK') {
				$location.path("afficheAcquereur")
			}
		});
	}
})

.controller("attribuerAcquereurCtrl", function($scope, acquereurService, $location) {
	
	$scope.idC=''
	$scope.idBien=''
		
	$scope.attribuerAcquereur = function() {
		acquereurService.attributeAcquereur($scope.idC,$scope.idBien, function (callback) {
			if (typeof callback == "object") {
				$location.path("listeVisite")
			}
		});
	}
})

.controller("attribuerAcquereurLocCtrl", function($scope, acquereurService, $location) {
	
	$scope.idC=''
	$scope.idBien=''
		
	$scope.attribuerAcquereurLoc = function() {
		acquereurService.attributeAcquereurLoc($scope.idC,$scope.idBien, function (callback) {
			if (typeof callback == "object") {
				$location.path("listeVisite")
			}
		});
	}
	
	
})
