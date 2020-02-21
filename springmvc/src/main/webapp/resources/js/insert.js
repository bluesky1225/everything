// 이미지 미리보기
var pictureurl = document.getElementById("pictureurl");
var img = document.getElementById("img");

// 이미지 선택이 변경되면
pictureurl.addEventListener("change", function() {
	// 업로드 한 이미지 파일의 내용을 img에 출력
	
	// 파일 객체 생성
	var reader = new FileReader();
	
	if(pictureurl.files && pictureurl.files[0]) {
		// 파일 읽기
		reader.readAsDataURL(pictureurl.files[0]);
		
		// 파일의 내용을 전부 읽으면 출력. 읽는 도중 출력하면 안됨
		reader.addEventListener("load", function(e) {
			img.src = e.target.result;
		})
		
	}
});

// itemid 중복 체크를 위한 변수
var itemid = document.getElementById("itemid");
var iddiv = document.getElementById("iddiv");

// 중복체크를 통과했는지 여부를 저장할 변수
var idcheck = false;

// itemid 입력란에서 포커스가 떠나면 중복 체크
itemid.addEventListener("focusout", function(e) {
	//ajax 객체 만들기
	request = new XMLHttpRequest();

	// 요청 생성
	request.open('GET', 'itemidcheck?itemid='+itemid.value);

	// 요청 전송
	request.send('');

	// 요청에 대한 처리를 위한 콜백 메소드 등록
	request.onreadystatechange = function() {
		// 정상 응답이 오면
		if(request.readyState == 4 && request.status >= 200 && request.status < 300) {
			// 넘어온 데이터 파싱
			var data = JSON.parse(request.responseText);
			
			if(data.result == 'true') {
				iddiv.innerHTML = '멋진 코드네요';
				iddiv.style.color = 'green';
				idcheck.value = true;
			} else {
				iddiv.innerHTML = '중복된 코드네요';
				iddiv.style.color = 'red';
				idcheck.value = false;
			}
		}
		
		
	}
	
})

