<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style type="text/css">
.box {
	width: 400px;
	height: AUTO;
	border: 1px solid green;
	border-radius: 5px;
	padding: 15px;
	margin: 15px;
	overflow-y: scroll;
}
</style>
<script>

function searchBusLaneAJAX() {
	var xhr = new XMLHttpRequest();
	var url = "https://api.odsay.com/api/searchBusLane?busNo=10&CID=1000&apiKey=2j66n0rdhZW8VITP11Bwhw";
	xhr.open("GET", url, true);
	xhr.send();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log( xhr.responseText ); // <- xhr.responseText 로 결과를 가져올 수 있음
		}
	}
}


</script>
</head>
<body>
<div>
<input type="text" id="busNo">
<button onclick="searchBusLaneAJAX();">click</button>
</div>
<div id="resultDiv">
<!-- 결과창 -->
</div>
</body>
</html>