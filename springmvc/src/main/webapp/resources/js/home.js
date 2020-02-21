/**
 * 
 */

document.getElementById("ajax").addEventListener("click", function() {
	
	// ajax 객체 만들기
	request = new XMLHttpRequest();
	
	// 요청 생성
	request.open('GET', 'item2.json');
	
	// 요청 전송
	request.send('');
	
	// 요청에 대한 처리를 위한 콜백 메소드 등록
	request.onreadystatechange = function() {
		// 정상 응답이 오면
		if(request.readyState == 4 && request.status >= 200 && request.status < 300) {
			// 데이터 확인
			//alert(request.responseText);
			
			// 받아온 데이터를 JSON 파싱을 해서 배열로 만들기
			list = JSON.parse(request.responseText);
			
			// 배열을 순회
			msg = ''
			msg += "<table border='1'>";
			msg += "<tr class='header'>";
			msg += "<th width='80'>코드</th>";
			msg += "<th width='160'>상품명</th>";
			msg += "<th width='80'>가격</th>";
			msg += "<th width='160'>설명</th>";
			msg += "</tr>";
			
			for(i in list) {				
				msg += "<tr class='record'>";
				msg += "<td width='80'>" + list[i].itemid + "</th>";
				msg += "<td width='160'>" + list[i].itemname + "</th>";
				msg += "<td width='80'>" + list[i].price + "</th>";
				msg += "<td width='160'>" + list[i].description + "</th>";
				msg += "</tr>";
			}
			
			msg += "</table>";
			
			var disp = document.getElementById("disp");
			disp.innerHTML = msg;
		}
	}
});