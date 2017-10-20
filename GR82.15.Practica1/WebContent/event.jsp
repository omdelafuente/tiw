<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<title>Instaticket</title>

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>

<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<% if (session.getAttribute("loggedUser") != null) { %>
    <jsp:include page="sidebarLogged.jsp"/>
<% } else {%>
  	<jsp:include page="sidebarNotLogged.jsp"/>
<% } %>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">
  
  <!-- Top header -->
  <header class="w3-xlarge w3-container">
    <p class="w3-left">Información del evento</p>
    <form method="post">
    <p class="w3-right">
    	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left"" placeholder="Buscar eventos...">
    	<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
    </p></form>
 
  </header>

  <!-- Image header -->
  <div class="w3-container">
    <img src="resources/kaseo.jpg" alt="Jeans" style="width:100%">
  </div>
  <br>
  <div class="w3-main">
	<div class="w3-row">
		<div class="w3-col s9 w3-center" style="padding-top:0.25em">
			<h1>Kase-O en concierto</h1>
		</div>
		<div class="w3-col s3 w3-center">
			<span class="w3-tag w3-large w3-padding-large w3-light-grey w3-center w3-hover-orange" style="cursor:pointer">
			<strong>COMPRAR<br>ENTRADAS</strong></span>
		</div>
	</div>
	<hr style="border:1px solid grey; width: 90%; margin-left: 5%">
	
	<div class="w3-row w3-padding-16" style="width: 90%; margin-left: 5%">
    	<div class="w3-twothird w3-container">
      		<h5>Descripción</h5>
     		<p style="text-align:justify">Gira EL CÍRCULO 2016-2017<br>
			   KASE.O llega a conquistar el mítico Palacio de los Deportes de Madrid. 
			   Después de batir todos los records en la gira más importante de la historia de HIP-HOP en España, 
			   KASE.O quiere reunir a todos sus seguidores en un concierto mítico con colabos y sorpresas que se irán anunciando, 
			   y que será el colofón de su TOUR EL CÍRCULO 2017.
			   <br>
			   La apertura de puertas será a las 19:30 horas, EL MOMO 20:30 horas y el inicio del concierto de KASE.O a las 21:30 horas.</p>
    	</div>
    	<div class="w3-third w3-container">
    		<h5>Información del evento</h5>
    		<label>Categoría</label>
    		<p class="w3-border w3-padding-large w3-padding-16 w3-center">Conciertos</p>
    		<label>Precio</label>
      		<p class="w3-border w3-padding-large w3-padding-16 w3-center">16,00 €</p>
      		<label>Fecha y hora</label>
      		<p class="w3-border w3-padding-large w3-padding-16 w3-center">02 DIC 2017<br>19:30h</p>
      		<label>Lugar</label>
      		<p class="w3-border w3-padding-large w3-padding-16 w3-center">WiZink Center, Madrid</p>
    	</div>
  </div>
	
	
  </div>
  <!-- End page content -->
</div>

</body>
</html>

