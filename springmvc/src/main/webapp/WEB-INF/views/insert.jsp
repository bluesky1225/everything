<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>입력 폼</title>
</head>
<body>
	<div align="center">
		<h3>데이터 삽입</h3>
		<form method="post" enctype="multipart/form-data" id="myform">
			<table border="1">
				<tr>
					<td rowspan="5" align="center">
						<p></p>
						<img src="img" width="100" height="100" border="1" id="img"/>
						<br/>
						<input type="file" id="pictureurl" name="pictureurl" accept=".jpg, .jpeg, .png, .gif"/>
						<br/>
					</td>
				</tr>
				<tr>
					<td align="center">코드</td>
					<td><input type="text" name="itemid" id="itemid" required="required" />
					<div id="iddiv"></div>
					</td>
				</tr>
				<tr>
					<td align="center">이름</td>
					<td><input type="text" name="itemname" id="itemname" required="required" />
					<div id="namediv"></div>
					</td>
				</tr>
				<tr>
					<td align="center">가격</td>
					<td><input type="text" name="price" id="price" required="required" />
					<div id="pricediv"></div>
					</td>
				</tr>
				<tr>
					<td align="center">설명</td>
					<td><input type="text" name="description" id="description" required="required" />
					<div id="descriptiondiv"></div>
					</td>
				</tr>
				<tr>
					<td colspan="3" align="center"><input type="submit" value="전송하기"/></td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="./resources/js/insert.js"></script>
</body>
</html>