<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>클릭 이벤트 등록하기</title>

</head>
<body>
	<div id="map" style="width: 100%; height: 800px;"></div>
	<p><em>지도를 클릭해주세요!</em></p> 
<p id="result"></p>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68171e6db798333d82b92ae249926a4e"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };

var map = new daum.maps.Map(mapContainer, mapOption); // 지도를 생성합니다

// 지도에 클릭 이벤트를 등록합니다
// 지도를 클릭하면 마지막 파라미터로 넘어온 함수를 호출합니다
daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // 클릭한 위도, 경도 정보를 가져옵니다 
    var latlng = mouseEvent.latLng;
    
    var message = '클릭한 위치의 위도는 ' + latlng.getLat() + ' 이고, ';
    message += '경도는 ' + latlng.getLng() + ' 입니다';
    
    var resultDiv = document.getElementById('result'); 
    resultDiv.innerHTML = message;
    
 	// 마커가 표시될 위치입니다 
    var markerPosition  = new daum.maps.LatLng(latlng.getLat(), latlng.getLng()); 

    // 마커를 생성합니다
    var marker = new daum.maps.Marker({
        position: markerPosition
    });
    
 	// 마커가 지도 위에 표시되도록 설정합니다
    marker.setMap(map);
    
 	// 아래 코드는 지도 위의 마커를 제거하는 코드입니다
 	//marker.setMap(null); 
 	
});


</script>
</body>
</html>