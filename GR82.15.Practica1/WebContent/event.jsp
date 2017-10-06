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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
    	<a class="w3-bar-item w3-button w3-hover-grey" style="float:left" href="index.jsp"><i class="fa fa-home"></i></a>
    	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left"" placeholder="Buscar eventos...">
    	<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
    </p></form>
 
  </header>

  <!-- Image header -->
  <div class="w3-container">
    <img src="resources/kaseo.jpg" alt="Jeans" style="width:100%">
  </div>
  <br>
	<div class="w3-row">
		<div class="w3-col s9 w3-center w3-purple">
			<h4 class="w3-jumbo">Kase-O en concierto</h4>
		</div>
		<div class="w3-col s3 w3-center w3-green">
			<a class="w3-tag w3-large w3-padding-large w3-orange w3-center">
			<strong>COMPRAR<br>ENTRADAS</strong></a>
		</div>
	</div>
  <!-- End page content -->
</div>

</body>
</html>

