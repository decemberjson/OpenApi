<%@ page contentType="text/html; charset=euc-kr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
<meta charset="EUC-KR">
<title>고속버스 터미널 조회결과</title>

	<!-- 참조 : http://getbootstrap.com/css/   참조 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	
	<!--  ///////////////////////// Bootstrap, jQuery CDN ////////////////////////// -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" >
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>

	<!-- //////////////////// CSS //////////////////// -->
	<style>
 		body {
            padding-top : 50px;
        }
    </style>

<!-- //////////////////// JavaScript //////////////////// -->
	<script type="text/javascript">	


	</script>
</head>

<body>

	<!--  화면구성 div Start /////////////////////////////////////-->
	<div class="container">
	
		<div class="page-header">
	       <h3 class=" text-info">고속버스 터미널 조회 결과</h3>
	    </div>
	
		<div class="row">
	  		<div class="col-xs-4 col-md-2"><strong>result : 필수값(Y)</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.purchaseProd.prodNo }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>구매자아이디</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.buyer.userId}</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>구매방법</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.paymentOption == '1' ? "현금구매" : "신용구매" }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>받으실분 이름</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.receiverName }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>받으실분 연락처</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.receiverPhone }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>받으실분 주소</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.dlvyAddr }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>구매시 요청사항</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.dlvyRequest }</div>
		</div><hr/>
		
		<div class="row">
	  		<div class="col-xs-4 col-md-2 "><strong>배송희망일자</strong></div>
			<div class="col-xs-8 col-md-4">${ purchase.dlvyDate }</div>
		</div><hr/>
		
		<div class="row">
		    <div class="col-md-12 text-center">
		      <button type="button" class="btn btn-primary">계속쇼핑하기</button>
		    </div>
		  </div>
	  <!--  table End /////////////////////////////////////-->
	  
 	</div>
 	<!--  화면구성 div End /////////////////////////////////////-->
 	
</body>

</html>