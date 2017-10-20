<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<title>Edit Profile</title>
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
    <p class="w3-left">Editar perfil</p>
    <form method="post">
    	<p class="w3-right">
    		<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
      		<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   		</p>
    </form>
  </header>
	<div class="w3-container w3-center">
		
		<% if((Boolean)request.getAttribute("editSuccess") != null) {
			if((Boolean)request.getAttribute("editSuccess") == false) { 
			
			ArrayList<String> errList = (ArrayList<String>)request.getAttribute("errorEdit");%>		
			
		<div class="w3-panel w3-red w3-card-4">
			<%for(int i = 0; i < errList.size(); i++) {%>
	 			<p><%= errList.get(i)%></p>
	 		<%} %>
		</div>
		<%} }%>
		
		
		<p>Edita los campos que desees modificar:</p>
		<form method="post" action="edit" id="editForm">
			<p>Nombre:</p>
	    	<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="text" name="name" placeholder="Solo letras del alfabeto"/><br>
	    	<p>Apellidos:</p>
	    	<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="text" name="surname" placeholder="Solo letras del alfabeto"  /><br>
	    	<p>Contraseña antigua:</p>
	   		<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="psw"/><br>
	    	<p>Nueva contraseña:</p>
	   		<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="npsw" placeholder="Mín. 6 num/letras"/><br>
	   		<p>Confirmación de la nueva contraseña:</p>
	   		<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="checknpsw"/><br>
		</form>
		<p><button class="w3-button w3-theme w3-grey" onclick="document.getElementById('confirmBox').style.display='block'">Confirmar cambios</button><p>
	</div>
	<hr style="border:1px solid grey; width: 90%; margin-left: 5%">
	<div class="w3-container w3-center">
		<p>Si quieres dejar de ser miembro de Instaticket...</p>
		<p><button class="w3-button w3-theme w3-red">Darse de baja</button><p>
		
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

<script>




</script>

</body>
</html>