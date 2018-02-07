monApp.controller("findAllProprietaireCtrl",
		function($scope, proprietaireService) {
			proprietaireService.findListe(function(callback) {
				$scope.listeProprietaire = callback;
			})
		}).controller("addProprietaireCtrl",
		function($scope, proprietaireService, $location) {
			$scope.proprietaireAjout = {
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

			$scope.ajouterProprietaire=function(){
				proprietaireService.addProprietaire($scope.proprietaireAjout, function (callback){
					if (callback == 'OK') {
						$location.path("afficheProprietaire")
					}
				});
			}
		})