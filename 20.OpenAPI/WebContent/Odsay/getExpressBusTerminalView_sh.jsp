<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
<meta charset="EUC-KR">

<title>��ӹ��� �͹̳� ��ȸ</title>
	
	<!-- ���� : http://getbootstrap.com/css/   ���� -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
	
	<!--  ///////////////////////// CSS ////////////////////////// -->
<style>
body>div.container {
	border: 3px solid #D6CDB7;
	margin-top: 10px;
}
</style>

<!--  ///////////////////////// JavaScript ////////////////////////// -->
<script type="text/javascript">

	function fncGetExpressBusInfo() {

//		var danielKey = "NGWqA2%2BBr3ddBK6GFTsvMdNW3uJ%2BtGTyJZxuXA4AD5g";
		var yuriKey = "0ObaGjz7q8kLrzbsVutNT0qpRKpduNy7cnS9HDogmsk";

		var language = $("input[name='language']").val();
		var terminalName = $("input[name='terminalName']").val();
		
		if (terminalName == null || terminalName.length < 1) {
			alert("�͹̳θ��� �ݵ�� �Է��Ͽ��� �մϴ�.");
			return;
		}
		
		$("form").attr("method", "POST").attr("action", "/ExpressBus/getTerminalInfo").submit();
//		$("form").attr("method", "POST")
				
	};
	
	//=================== "��ȸ" Event ���� =================== 
	$(function() {
		$("button.btn.btn-primary").bind("click", function() {
			fncGetExpressBusInfo();
		});
	});
	
	
</script>


</head>
<body>

	<!--  ȭ�鱸�� div Start /////////////////////////////////////-->
	<div class="container">

	<div class="page-header">
		<h3 class="text-info">��ӹ��� �͹̳� ��ȸ</h3>
	</div>

		<!-- form Start /////////////////////////////////////-->
		<form class="form-horizontal">

			<div class="form-group">
				<label for="language" class="col-sm-offset-1 col-sm-3 control-label">����</label>
				<div class="col-sm-4">
					<input type="radio" id="language" name="language" value="0" checked> �ѱ���&nbsp;&nbsp;&nbsp;
 					<input type="radio" id="language" name="language" value="1"> English
				</div>
			</div>

			<div class="form-group">
				<label for="terminalName" class="col-sm-offset-1 col-sm-3 control-label">�͹̳θ�</label>
				<div class="col-sm-4">
					<input type="text" class="form-control" id="terminalName" name="terminalName" placeholder="�ʼ��Է�">
				</div>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-4  col-sm-4 text-center">
					<button type="button" class="btn btn-primary">��&nbsp;ȸ</button>
				</div>
			</div>

		</form>
		<!-- form Start /////////////////////////////////////-->

	</div>
	<!--  ȭ�鱸�� div end /////////////////////////////////////-->

</body>
</html>