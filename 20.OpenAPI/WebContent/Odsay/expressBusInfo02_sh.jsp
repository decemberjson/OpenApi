<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

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
	var busNo = document.getElementById('busNo').value;
	var xhr = new XMLHttpRequest();
	var url = "https://api.odsay.com/api/searchBusLane?apiKey=2j66n0rdhZW8VITP11Bwhw&busNo=" + busNo;
	xhr.open("GET", url, true);
	xhr.send();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var resultObj = JSON.parse(xhr.responseText);
			console.log(resultObj.result);
			var resultArr = resultObj["result"]["lane"];
			console.log(resultArr);

			var str = "";
			for (var i = 0; i < resultArr.length; i++) {
				str += "<div class='box'>";
				str += "<p>지역이름 : " + resultArr[i].busCityName + "</p>";
				str += "<p>버스회사 : " + resultArr[i].busCompanyNameKor + "</p>";
				str += "<p>버스번호 : " + resultArr[i].busNo + "</p>";
				str += "<p>출발점 / 도착점 : " + resultArr[i].busStartPoint + " - "
					+ resultArr[i].busEndPoint + "</p>";
				str += "</div>";
			}
			document.getElementById("resultDiv").innerHTML = str;
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