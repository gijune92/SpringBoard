/*****************
 * 회원 대기자 명단 리스트 스크립트.
 *****************/

$(document).ready(function(){
	var List = {};
	var appendStr;
	$.ajax({
        url: "/select",
        type: "POST",
        data : "",
        success : function(data){
        	List = JSON.parse(data);
        	console.log(JSON.parse(data));
        	
        	for(var i = 0; i < List.length; i++){
        		appendStr += "<tr>" +
        					"<td><input type='checkbox' name='choose'></td>" + 
        					"<td>" + (i+1) + "</td>" + 
        					"<td>" + List[i].id + "</td>" + 
        					"<td>" + List[i].name + "</td>" +
        					"<td>" + List[i].addr + "</td>";
        		if(List[i].accountDivision == 1){
        			appendStr += "<td>학생</td>";
        		} else if(List[i].accountDivision == 3){
        			appendStr += "<td>강사</td>";
        		} else if(List[i].accountDivision == 5){
        			appendStr += "<td>관리자</td>";
        		}
        		appendStr += "</tr>";
        	}
        	$("tbody").append(appendStr);
        }
    });
	
	$("#selectBtn").click(function(){
		console.log("asdjlfkhalskd");
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
		//console.log(tdList);

		// 승인할 계정 데이터 전송
		$.ajax({
	        url: "/acceptList/add",
	        type: "POST",
	        data : JSON.stringify(tdList), //Array를 JSON string형태로 변환
	        dataType: "json",
	        contentType: "application/json",
        	success: function(data) {
	        	console.log("Success")
	        	if(data == 0){
	        		alert("SUCCESS");
	        		location.href="/"
	        	} else {
	        		alert("ERROR!!");
	        		location.href="/"
	        	}
	        }
		});
	});
});
