<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>길찾기 결과 지도에 표출하기</title>
</head>

<div id="map" style="width: 100%; height: 400px;"></div>

<!-- Daum Developers에서 발급받은 다음지도 Application Key 입력  -->
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68171e6db798333d82b92ae249926a4e"></script>

<script>
 
	var mapOptions = {
		center: new naver.maps.LatLng(37.3595704, 127.105399),
		zoom: 10
	};

	var map = new naver.maps.Map('map', mapOptions);
	
	var sx = 126.93737555322481;		// 출발지 X좌표 (경도좌표)
	var sy = 37.55525165729346;			// 출발지 Y좌표 (위도좌표)
	var ex = 126.88265238619182;		// 도착지 X좌표 (경도좌표)
	var ey = 37.481440035175375;		// 도착지 Y좌표 (위도좌표)
	
	var serviceKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";
	var optValue = 1;
	var searchPathType = 2;
	
	function searchPubTransPathAJAX() {
		var xhr = new XMLHttpRequest();
		//ODsay apiKey 입력
		var url = "https://api.odsay.com/api/searchPubTransPath?SX="+sx+"&SY="+sy+"&EX="+ex+"&EY="+ey+"&OPT="+optValue+"&SearchPathType"+searchPathType+"&apiKey=" + serviceKey;
		xhr.open("GET", url, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
			console.log( JSON.parse(xhr.responseText) ); // <- xhr.responseText 로 결과를 가져올 수 있음
			//노선그래픽 데이터 호출
			callMapObjApiAJAX((JSON.parse(xhr.responseText))["result"]["path"][0].info.mapObj);
			}
		}
	}
	
	//길찾기 API 호출
	searchPubTransPathAJAX();
	
	function callMapObjApiAJAX(mabObj){
		var xhr = new XMLHttpRequest();
		//ODsay apiKey 입력
		var url = "https://api.odsay.com/api/loadLane?mapObject=0:0@"+mabObj+"&apiKey=0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";
		xhr.open("GET", url, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var resultJsonData = JSON.parse(xhr.responseText);
				drawNaverMarker(sx,sy);					// 출발지 마커 표시
				drawNaverMarker(ex,ey);					// 도착지 마커 표시
				drawNaverPolyLine(resultJsonData);		// 노선그래픽데이터 지도위 표시
				// boundary 데이터가 있을경우, 해당 boundary로 지도이동
				if(resultJsonData.result.boundary){
						var boundary = new naver.maps.LatLngBounds(
				                new naver.maps.LatLng(resultJsonData.result.boundary.top, resultJsonData.result.boundary.left),
				                new naver.maps.LatLng(resultJsonData.result.boundary.bottom, resultJsonData.result.boundary.right)
				                );
						map.panToBounds(boundary);
				}
			}
		}
	}
	
	// 지도위 마커 표시해주는 함수
	function drawNaverMarker(x,y){
		var marker = new naver.maps.Marker({
		    position: new naver.maps.LatLng(y, x),
		    map: map
		});
	}
	
	// 노선그래픽 데이터를 이용하여 지도위 폴리라인 그려주는 함수
	function drawNaverPolyLine(data){
		var lineArray;
		
		for(var i = 0 ; i < data.result.lane.length; i++){
			for(var j=0 ; j <data.result.lane[i].section.length; j++){
				lineArray = null;
				lineArray = new Array();
				for(var k=0 ; k < data.result.lane[i].section[j].graphPos.length; k++){
					lineArray.push(new naver.maps.LatLng(data.result.lane[i].section[j].graphPos[k].y, data.result.lane[i].section[j].graphPos[k].x));
				}
				
			//지하철결과의 경우 노선에 따른 라인색상 지정하는 부분 (1,2호선의 경우만 예로 들음)
				if(data.result.lane[i].type == 1){
					var polyline = new naver.maps.Polyline({
					    map: map,
					    path: lineArray,
					    strokeWeight: 3,
					    strokeColor: '#003499'
					});
				}else if(data.result.lane[i].type == 2){
					var polyline = new naver.maps.Polyline({
					    map: map,
					    path: lineArray,
					    strokeWeight: 3,
					    strokeColor: '#37b42d'
					});
				}else{
					var polyline = new naver.maps.Polyline({
					    map: map,
					    path: lineArray,
					    strokeWeight: 3
					});
				}
			}
		}
	}
</script>


<body>




</body>
</html>