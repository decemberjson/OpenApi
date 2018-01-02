<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Ŭ�� �̺�Ʈ ����ϱ�</title>

</head>
<body>
	<div id="map" style="width: 100%; height: 800px;"></div>
	<p><em>������ Ŭ�����ּ���!</em></p> 
<p id="result"></p>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68171e6db798333d82b92ae249926a4e"></script>
<script>
var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
    mapOption = { 
        center: new daum.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
        level: 3 // ������ Ȯ�� ����
    };

var map = new daum.maps.Map(mapContainer, mapOption); // ������ �����մϴ�

// ������ Ŭ�� �̺�Ʈ�� ����մϴ�
// ������ Ŭ���ϸ� ������ �Ķ���ͷ� �Ѿ�� �Լ��� ȣ���մϴ�
daum.maps.event.addListener(map, 'click', function(mouseEvent) {        
    
    // Ŭ���� ����, �浵 ������ �����ɴϴ� 
    var latlng = mouseEvent.latLng;
    
    var message = 'Ŭ���� ��ġ�� ������ ' + latlng.getLat() + ' �̰�, ';
    message += '�浵�� ' + latlng.getLng() + ' �Դϴ�';
    
    var resultDiv = document.getElementById('result'); 
    resultDiv.innerHTML = message;
    
 	// ��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
    var markerPosition  = new daum.maps.LatLng(latlng.getLat(), latlng.getLng()); 

    // ��Ŀ�� �����մϴ�
    var marker = new daum.maps.Marker({
        position: markerPosition
    });
    
 	// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
    marker.setMap(map);
    
 	// �Ʒ� �ڵ�� ���� ���� ��Ŀ�� �����ϴ� �ڵ��Դϴ�
 	//marker.setMap(null); 
 	
});


</script>
</body>
</html>