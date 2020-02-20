<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- if나 forEach를 사용하기위한 태그 라이브러리를 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 검색 결과</title>
<link rel="stylesheet" href="./resources/css/item.css"/>
</head>
<body>
	<h2 align='center'>상품 목록</h2>
	<table border='1' align='center'>
		<tr class='header'>
			<th width='80'>ItemID</th>
			<th width='160'>ItemName</th>
			<th width='80'>Price</th>	
			<th width='160'>Description</th>
			<th width='140'>PictureURL</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr class="record">
				<td align='center'>${item.itemid}</td>
				<!--  <td align='center'><a href="detail?itemid=${item.itemid}">${item.itemname}</a></td> -->
				<td align='center'><a href="detail/${item.itemid}">${item.itemname}</a></td>
				<td align='center'>${item.price}원</td>
				<td align='center'>${item.description}</td>
				<td align='center'><img src="./resources/images/${item.pictureurl}" width="50%"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>