<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ODsay LAB</title>

<meta charset="EUC-KR">
	
	<!-- ���� : http://getbootstrap.com/css/   ���� -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
	<style>
       body > div.container{
        	border: 3px solid #D6CDB7;
            margin-top: 10px;
        }
    </style>
    
     <!--  ///////////////////////// JavaScript ////////////////////////// -->
<script type="text/javascript">

function searchExpressBus () {
	
	var xhr = new XMLHttpRequest();
	var url = "https://api.odsay.com/api/searchBusLane?busNo=10&CID=1000&apiKey=2j66n0rdhZW8VITP11Bwhw";
	xhr.open("GET", url, true);
	xhr.send();
	xhr.onreadystatechange = function() {

		if (xhr.readyState == 4 && xhr.status == 200) {
			console.log( xhr.responseText ); // <- xhr.responseText �� ����� ������ �� ����
		}
	}
}




	$( function(){
		
		$( "button.btn.btn-primary" ).bind("click", function(){
//			$('form').attr("method", "POST").attr("action", "/product/updateProduct").attr("enctype", "multipart/form-data").submit();
			searchExpressBus();
			
			$.ajax ({
				
			})


			});
		});


</script>


</head>
<body>
<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">

		<h1 class="bg-primary text-center">��ӹ��� �������� �˻�</h1>


		<form class="form-horizontal">

			<div class="form-group">
				<label for="language"
					class="col-sm-offset-1 col-sm-3 control-label">���� (���� : 0 , ���� : 1)</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="language" name="language" placeholder="����">
				</div>
			</div>

			<div class="form-group">
				<label for="startStation"
					class="col-sm-offset-1 col-sm-3 control-label">��߿�ID</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="beginStation"
						name="beginStation" placeholder="��߿�ID">
				</div>
			</div>

			<div class="form-group">
				<label for="finalStation"
					class="col-sm-offset-1 col-sm-3 control-label">������ID</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="finalStation"
						name="endStation" placeholder="������ID">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4  col-sm-4 text-center">
					<button type="button" class="btn btn-primary">�� &nbsp;��</button>
				</div>
			</div>

		</form>

	</div>

</body>
</html>


