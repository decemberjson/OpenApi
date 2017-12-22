<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
<title>��ã�� ��� ������ ǥ���ϱ�</title>
</head>

<div id="map" style="width:100%;height:400px;"></div>
<!-- Naver Developers���� �߱޹��� ���̹����� Application Key �Է�  -->

<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=ByxJShLyghWlQTAQc4ES&submodules=geocoder"></script>

<script>
 
	var mapOptions = {
		center: new naver.maps.LatLng(37.3595704, 127.105399),
		zoom: 10
	};

	var map = new naver.maps.Map('map', mapOptions);
	
	var sx = 126.93737555322481;
	var sy = 37.55525165729346;
	var ex = 126.88265238619182;
	var ey = 37.481440035175375;
	
	function searchPubTransPathAJAX() {
		var xhr = new XMLHttpRequest();
		//ODsay apiKey �Է�
		var url = "https://api.odsay.com/api/searchPubTransPath?SX="+sx+"&SY="+sy+"&EX="+ex+"&EY="+ey+"&apiKey=2j66n0rdhZW8VITP11Bwhw";
		xhr.open("GET", url, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
			console.log( JSON.parse(xhr.responseText) ); // <- xhr.responseText �� ����� ������ �� ����
			//�뼱�׷��� ������ ȣ��
			callMapObjApiAJAX((JSON.parse(xhr.responseText))["result"]["path"][0].info.mapObj);
			}
		}
	}
	
	//��ã�� API ȣ��
	searchPubTransPathAJAX();
	
	function callMapObjApiAJAX(mabObj){
		var xhr = new XMLHttpRequest();
		//ODsay apiKey �Է�
		var url = "https://api.odsay.com/api/loadLane?mapObject=0:0@"+mabObj+"&apiKey=2j66n0rdhZW8VITP11Bwhw";
		xhr.open("GET", url, true);
		xhr.send();
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var resultJsonData = JSON.parse(xhr.responseText);
				drawNaverMarker(sx,sy);					// ����� ��Ŀ ǥ��
				drawNaverMarker(ex,ey);					// ������ ��Ŀ ǥ��
				drawNaverPolyLine(resultJsonData);		// �뼱�׷��ȵ����� ������ ǥ��
				// boundary �����Ͱ� �������, �ش� boundary�� �����̵�
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
	
	// ������ ��Ŀ ǥ�����ִ� �Լ�
	function drawNaverMarker(x,y){
		var marker = new naver.maps.Marker({
		    position: new naver.maps.LatLng(y, x),
		    map: map
		});
	}
	
	// �뼱�׷��� �����͸� �̿��Ͽ� ������ �������� �׷��ִ� �Լ�
	function drawNaverPolyLine(data){
		var lineArray;
		
		for(var i = 0 ; i < data.result.lane.length; i++){
			for(var j=0 ; j <data.result.lane[i].section.length; j++){
				lineArray = null;
				lineArray = new Array();
				for(var k=0 ; k < data.result.lane[i].section[j].graphPos.length; k++){
					lineArray.push(new naver.maps.LatLng(data.result.lane[i].section[j].graphPos[k].y, data.result.lane[i].section[j].graphPos[k].x));
				}
				
			//����ö����� ��� �뼱�� ���� ���λ��� �����ϴ� �κ� (1,2ȣ���� ��츸 ���� ����)
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