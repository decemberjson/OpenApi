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

<!-- Odsay ���� ���ÿ��� -->

function searchBusLaneAJAX() {
	var busNo = document.getElementById('busNo').value;
	var xhr = new XMLHttpRequest();
	var url = "https://api.odsay.com/api/searchBusLane?apiKey=0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk&busNo=" + busNo;
//	var url = "https://api.odsay.com/api/searchBusLane?apiKey=NGWqA2%2BBr3ddBK6GFTsvMdNW3uJ%2BtGTyJZxuXA4AD5g&busNo=" + busNo;
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
				str += "<p>�����̸� : " + resultArr[i].busCityName + "</p>";
				str += "<p>����ȸ�� : " + resultArr[i].busCompanyNameKor + "</p>";
				str += "<p>������ȣ : " + resultArr[i].busNo + "</p>";
				str += "<p>����� / ������ : " + resultArr[i].busStartPoint + " - "
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
<!-- ���â -->
</div>
</body>
</html>