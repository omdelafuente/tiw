<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="es.uc3m.tiw.*"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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

<!-- Top menu on small screens -->
<header class="w3-bar w3-top w3-hide-large w3-black w3-xlarge">
  <div class="w3-bar-item w3-padding-24 w3-wide">INSTATICKET</div>
  <a href="javascript:void(0)" class="w3-bar-item w3-button w3-padding-24 w3-right" onclick="w3_open()"><i class="fa fa-bars"></i></a>
</header>

<!-- Overlay effect when opening sidebar on small screens -->
<div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="overlay"></div>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

  <!-- Push down content on small screens -->
  <div class="w3-hide-large" style="margin-top:83px"></div>
  
  <!-- Top header -->
  <header class="w3-xlarge w3-container">
    <p class="w3-left">Eventos destacados</p>
    <form method="post">
    <p class="w3-right">
    	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left"" placeholder="Buscar eventos...">
    	<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
    </p></form>
 
  </header>

  <!-- Image header -->
  <div class="w3-display-container w3-container">
    <img src="resources/kaseo.jpg" alt="Jeans" style="width:100%">
    <div class="w3-display-topleft w3-text-white" style="padding:24px 48px">
      <h1 class="w3-jumbo w3-hide-small">Kase-O en concierto</h1>
      <h1 class="w3-hide-large w3-hide-medium">Kase-O en concierto</h1>
      <h1 class="w3-hide-small">MADRID - 2017</h1>
      <p><a href="#jeans" class="w3-button w3-black w3-padding-large w3-large">Comprar ahora</a></p>
    </div>
  </div>

  <div class="w3-container w3-text-grey" id="jeans">
    <p>8 items</p>
  </div>

  <!-- Product grid -->
  <div class="w3-row">
    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="resources/kaseo.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">New</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Mega Ripped Jeans<br><b>$19.99</b></p>
      </div>
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Washed Skinny Jeans<br><b>$20.50</b></p>
      </div>
      <div class="w3-container">
        <div class="w3-display-container">
          <img src="resources/kaseo.jpg" style="width:100%">
          <span class="w3-tag w3-display-topleft">Sale</span>
          <div class="w3-display-middle w3-display-hover">
            <button class="w3-button w3-black">Buy now <i class="fa fa-shopping-cart"></i></button>
          </div>
        </div>
        <p>Vintage Skinny Jeans<br><b class="w3-text-red">$14.99</b></p>
      </div>
    </div>

    <div class="w3-col l3 s6">
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Vintage Skinny Jeans<br><b>$14.99</b></p>
      </div>
      <div class="w3-container">
        <img src="resources/kaseo.jpg" style="width:100%">
        <p>Ripped Skinny Jeans<br><b>$24.99</b></p>
      </div>
    </div>
  </div>

  <div class="w3-black w3-center w3-padding-24">Powered by Óscar Martín de la Fuente, Saúl Martín Rodríguez & Luis Miguel Sánchez</div>

  <!-- End page content -->
</div>


<script>

// Script to open and close sidebar
function w3_open() {
    document.getElementById("sidebar").style.display = "block";
    document.getElementById("overlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("sidebar").style.display = "none";
    document.getElementById("overlay").style.display = "none";
}
</script>
</body>
</html>

