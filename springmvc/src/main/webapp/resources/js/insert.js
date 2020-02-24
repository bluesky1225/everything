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
				idcheck = true;
				iddiv.innerHTML = '멋진 코드네요';
				iddiv.style.color = 'green';
				
			} else {
				iddiv.innerHTML = '중복된 코드네요';
				iddiv.style.color = 'red';
				idcheck = false;
			}
		}
		
		
	}
	
});

// 폼의 데이터를 전송할때 발생하는 이벤트 처리
document.getElementById("myform").addEventListener("submit", function(e) {

	if(idcheck == false) {		
		iddiv.innerHTML = "아이디 중복 검사를 하세요";
		iddiv.style.color = "orange";
		itemid.focus();
		
		// 폼의 데이터를 전송하지 않도록 하기
		e.preventDefault();
		return ;
	}
	// price 입력란이 숫자만 입력되었는지 체크
	// +나 - 기호를 앞에 붙일 수 있는지
	// ,의 경우는 어떻게 할것인지
	var price = document.getElementById("price");
	var pricediv = document.getElementById("pricediv");
	var pricecheck = false;
	
	for(var i=0; i < price.value.length; i++) {
		var ch = price.value.charAt(i);
		
		if(i==0) {
			if(!(ch=='+'||ch=='-')&&!(ch >= '0' && ch <= '9')) {
				alert("가격의 첫번째 자리는 숫자나 +, -여야합니다.");
				price.focus();
				
				e.preventDefault();
				return ;
			}
		}
		
		if(ch >= '0' && ch <= '9') {			
			pricecheck = true;
		} else {
			pricecheck = false;
		}
	}
	
	if(pricecheck == true) {
		pricediv.innerHTML = "올바른 금액입니다";
	} else {
		pricediv.innerHTML = "금액의 형식이 잘못되었네요";
		pricediv.style.color = "red";
		price.focus();
		e.preventDefault();
		return ;
	}
});

