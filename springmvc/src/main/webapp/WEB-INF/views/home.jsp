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
<body align="center">
	<h2 align='center'>상품 목록</h2>
	<div id="scrollview" align="center">
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
				<td align='center'><img src="./resources/images/${item.pictureurl}" width="100"></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div>
	<c:if test="${member == null}">
	<a href="login">로그인</a><br/>
	</c:if>
	<c:if test="${member != null}">
	${member.userid}님 <a href="logout">로그아웃</a><br/>
	</c:if>
	
	<a href="insert">데이터 삽입</a><br/>
	
	<a href="chat">WebSocket을 이용한 채팅</a><br/>
	
	<a href="item.xls">엑셀로 내려받기</a><br/>
	
	<a href="item.pdf">pdf로 내려받기</a><br/>
	
	<a href="item1.json">json으로 내려받기</a><br/>
	
	<a href="item.csv">csv로 내려받기</a><br/>
	
	<a href="item2.json">json으로 내려받기2</a><br/>
	
	<a href="#" id="ajax">ajax로 json 데이터 사용하기</a><br/>	
	
	<a href="item.xml">XML로 내려받기</a><br/>
		
	<div align="center" id="disp"></div>
	</div>
	<script type="text/javascript" src="./resources/js/home.js"></script>
</body>
</html>




