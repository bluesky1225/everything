<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹스토리지를 이용한 아이디 저장</title>
</head>
<body>
	<form action="./loginProcess.jsp" method="post" id="loginform">
		<label for="id">아이디</label>
		<input type="text" name="id" required="required" id="id"/><br/>
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" required="required" /><br/>
		<input type="checkbox" name="idsave" value="idsave" id="idsave"/>아이디 저장<br/>
		
		<input type="submit" value="전송"/>
	</form>

<script>
	var loginform = document.getElementById("loginform");
	var ids = document.getElementById("id");
	var idsave = document.getElementById("idsave");
	
	// 폼의 데이터를 서브밋할때
	loginform.addEventListener("submit", function(e) {
		alert(ids.value);
		alert(idsave.checked);
		// 아이디 저장란에 체크가 되어 있으면 아이디 입력값을 로컬 스토리지에 저장
		// 아이디 저장란에 체크가 되어있지않으면 아이디 입력값을 로컬 스토리지에서 제거
		if(idsave.checked) {
			localStorage["id"] = ids.value;
		} else {
			delete localStorage["id"];
		}
	});
	
	// 윈도우가 로드될때 아이디 저장 여부를 확인해서 존재하면 표시하기
	window.addEventListener("load", function(e) {
		if(localStorage["id"]) {
			ids.value = localStorage["id"];
			idsave.checked = true;
		} else {
			ids.value = "";
			idsave.checked = false;
		}
	});
</script>

</body>
</html>