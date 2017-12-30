<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>��Ŀ �����ϱ�</title>

</head>
<body>
	<div id="map" style="width: 100%; height: 350px;"></div>

	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=68171e6db798333d82b92ae249926a4e"></script>
	<script>
		var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
		mapOption = {
			center : new daum.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
			level : 3
		// ������ Ȯ�� ����
		};

		var map = new daum.maps.Map(mapContainer, mapOption); // ������ �����մϴ�

		// ��Ŀ�� ǥ�õ� ��ġ�Դϴ� 
		
		var markerPosition = new daum.maps.LatLng(33.450701, 126.570667);

		// ��Ŀ�� �����մϴ�
		var marker = new daum.maps.Marker({
			position : markerPosition
		});

		// ��Ŀ�� ���� ���� ǥ�õǵ��� �����մϴ�
		marker.setMap(map);

		// �Ʒ� �ڵ�� ���� ���� ��Ŀ�� �����ϴ� �ڵ��Դϴ�
		// marker.setMap(null);
	</script>
</body>
</html>