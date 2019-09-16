var app = angular.module('myWeb', []);
app.config(['$qProvider', function ($qProvider) {
	$qProvider.errorOnUnhandledRejections(false);
}]);

app.controller('myCtl1',function($scope, $http){
	console.log("ASDASD")
	/* 전체 글 Select Function */
	$scope.getData = function(){
		$http.get("/s").then(function(res){
			$scope.articles = res.data;
		});
	}
	
	/* Page Load시, 게시글 가져오기 */
	$scope.getData();
	
	/* http function */
	$scope.httpMethod = function(method, url, data){
		$http({
			method : method,
			url : url,
			params : data
		}).then(function(res){
			$scope.getData();
		})
	}
});
