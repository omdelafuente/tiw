<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<title>Editar evento</title>
</head>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>

<body class="w3-content" style="max-width:1200px">

<jsp:include page="sidebarLogged.jsp"/>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">

 <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left">Editar evento</p>
    <p class="w3-right">
    	<button class="w3-bar-item w3-button w3-hover-grey"><i class="fa fa-search"></i></button>
      	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   	</p>
  </header>
	<div class="w3-container w3-center">
		
		<p>Edita los campos que desees modificar:</p>
		<form method="post" action="editEvent" id="editForm">
		
		
		
		
		</form>
		<p><button class="w3-button w3-theme w3-grey" onclick="document.getElementById('confirmBox').style.display='block'">Confirmar cambios</button><p>
	</div>
	
	<div class="w3-container w3-center">
		<p>Si deseas cancelar el evento:</p>
		<form method="post" id="cancelEventForm" action="cancelEvent">
		</form><p><button class="w3-button w3-theme w3-red" onclick="document.getElementById('confirmBox2').style.display='block'">Cancelar evento</button><p>
	</div>

</div>

<div id="confirmBox" class="w3-modal">
	<div class="w3-modal-content w3-animate-opacity w3-center" style="padding:16px">
		<p>¿Estás seguro de que quieres cambiar estos datos?</p>
		<div class="w3-row">
			<button class="w3-button w3-theme w3-green w3-medium" type="submit" form="editForm">Sí</button>
			<button class="w3-button w3-theme w3-grey w3-medium" onclick="document.getElementById('confirmBox').style.display='none'">No</button>
		</div>
	</div>
</div>

<div id="confirmBox2" class="w3-modal">
	<div class="w3-modal-content w3-animate-opacity w3-center" style="padding:16px">
		<p>¿Estás seguro de que quieres cancelar el evento?</p>
		<div class="w3-row">
			<button class="w3-button w3-theme w3-grey w3-medium" type="submit" form="cancelEventForm">Sí</button>
			<button class="w3-button w3-theme w3-grey w3-medium" onclick="document.getElementById('confirmBox2').style.display='none'">No</button>
		</div>
	</div>
</div>


</body>
</html>