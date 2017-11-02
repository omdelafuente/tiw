<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<script src="lib/jquery-3.2.1.min.js"></script>
<title>Comprar entrada</title>

<style>
.w3-sidebar a {
	font-family: "Roboto", sans-serif
}

body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>

<body class="w3-content" style="max-width: 1200px">

	<!-- Sidebar/menu -->
	<jsp:include page="sidebarLogged.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Top header -->
		<header class="w3-xlarge w3-container">
		<p class="w3-left">Comprar entrada</p>
		<form action="search" method="post">
			<p class="w3-right">
				<input type="hidden" name="type" value="simple"> <input
					class="w3-border" type="text" name="search"
					style="padding: 8px; font-size: 15px; float: left"
					placeholder="Buscar eventos..." required>
				<button class="w3-bar-item w3-button w3-hover-grey" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</p>
		</form>

		</header>
		
		<div class="w3-container w3-center">
		
			<div class="w3-row w3-light-grey w3-border-top w3-border-bottom" style="width:100%">
				<div class="w3-container w3-half">
					<p class="w3-text-grey"><b>ENTRADA</b></p>
				</div>
				<div class="w3-container w3-quarter">
					<p class="w3-text-grey"><b>PRECIO</b></p>
				</div>
				<div class="w3-container w3-quarter">
					<p class="w3-text-grey"><b>UNIDADES</b></p>
				</div>
			</div>
			
			<div class="w3-row" style="width:100%">
				<div class="w3-container w3-half">
					<p>Kase-O en concierto</p>
				</div>
				<div class="w3-container w3-quarter">
					<p>19.99€</p>
				</div>
				<div class="w3-container w3-quarter">
					<p><input type="number" min="1" value="1" style="text-align:center; max-width:50%"></p>
				</div>
			</div>
			
			<div class="w3-row w3-padding-16" style="width:100%">
				<a href="javascript:history.back()" class="w3-btn w3-white w3-border w3-left">Cancelar compra</a>
				<a id="checkout" class="w3-btn w3-white w3-border w3-right w3-border-green">Continuar</a>
			</div>
			
		
		</div>
		
		<div class="w3-container w3-center" id="payment" style="display:none">
		
			<div class="payment-selector">
				<input id="visa" type="radio" name="credit-card" value="visa" />
        		<label class="drinkcard-cc visa" for="visa"></label>
      		    <input id="paypal" type="radio"  name="credit-card" value="paypal" />
        		<label class="drinkcard-cc paypal" for="paypal"></label>
			</div>
			
			<div class="w3-container w3-border" id="payment-cc" style="display:none">
				<form method="post">
					<div class="w3-row-padding w3-padding-16">
		    			<label><b>Número de la tarjeta de crédito</b></label><br>
		    			<input class="w3-input w3-border w3-light-grey" type="text" style="width:50%;display:inline-block;">	  				
					</div>
					<div class="w3-row-padding w3-padding-16">
						<div class="w3-quarter">&nbsp;</div>			
		  				<div class="w3-quarter">
		   					<label><b>Código CV</b></label>
		    				<input class="w3-input w3-border w3-light-grey" type="text">
		  				</div>		  				
		  				<div class="w3-quarter">
		    				<label><b>Fecha de expiración</b></label>
		    				<input class="w3-input w3-border w3-light-grey" type="text">
		  				</div>		  				
					</div>
					<div class="w3-row w3-padding-16">
						<button class="w3-btn w3-green w3-border">Finalizar compra</button>
					</div>
				</form>			
			</div>
		
		</div>
		<!-- End page content -->
	</div>
	
<script>

$( document ).ready(function() {
    
	$("#checkout").click(function() {
		$("#payment").show();
	});
	
	$("[name='credit-card']").change(function () {
		if($(this).val() == "visa"){		
			$("#payment-cc").show();
		}
	});
	
});

</script>
	
</body>
</html>

