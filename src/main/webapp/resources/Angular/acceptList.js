/**
 * 회원 대기자 명단 리스트 스크립트.
 * 
 */
var app = angular.module('accountList', []);

// 앵귤러 알수없는 오류로 인한 예외코드 추가.
app.config(['$qProvider', function ($qProvider) {
	$qProvider.errorOnUnhandledRejections(false);
}]);

app.controller("ListControl", function($scope, $http){
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
	
	/* 대기자 명단 Select Function */
	$scope.getList = function(){
		$http.get("/acceptList/List").then(function(res){
			console.log(res);
			$scope.list = res.data;
		});
	}
	$scope.getList();
	
	$scope.accept = function(){
		// 상단 선택버튼 클릭시 체크된 Row의 값을 가져온다.
		var tdList = [];
		var checkbox = $("input[name=choose]:checked");
		// 체크된 체크박스 값을 가져온다
		checkbox.each(function(i) {
			var tr = checkbox.parent().parent().eq(i);
			var td = tr.children();
			
			// td.eq(0)은 체크박스 이므로  td.eq(1)의 값부터 가져온다.
			var userid = td.eq(2).text();
			var name = td.eq(3).text();
			var addr = td.eq(4).text();
			var accountDivision = td.eq(5).text();
			
			// 가져온 값을 맵형식으로 담는다.
			tdList.push({
						"id" : userid, 
						"name" : name, 
						"addr" : addr, 
						"accountDivision" : accountDivision
			});
		});

		$.ajax({
            url: "/acceptList/add",
            type: "POST",
            data: JSON.stringify(tdList), //Array를 JSON string형태로 변환
            dataType: "json",
            contentType: "application/json",
            success: function(data) {
            },
            error:function(data){
            }
        });
	}
});