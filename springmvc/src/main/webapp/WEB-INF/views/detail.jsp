<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이템 상세 보기</title>
<link rel="stylesheet" href="./resources/css/item.css"/>
</head>
<body>
<h2 align='center'>상품 상세 정보</h2>
	<table border='1' align='center'>
		<tr class="record">
		<td rowspan="6"><img src="../resources/images/${item.pictureurl}" width="100%"></td>
		</tr>
		<tr class="record">
			<td width="70" align='center'>아이디</td>
			<td width="100" align='center'>${item.itemid}</td>
		</tr>
		<tr class="record">
			<td align='center'>상품명</td>
			<td align='center'>${item.itemname}</td>
		</tr>
		<tr class="record">
			<td align='center'>가격</td>
			<td align='center'>${item.price}원</td>
		</tr>
		<tr class="record">
			<td align='center'>설명</td>
			<td align='center'>${item.description}</td>
		</tr>
		<tr class="record">
			<td colspan="2" align='center'>
				<a href="../">돌아가기</a>
			</td>
		</tr>
	</table>
</body>
</html>