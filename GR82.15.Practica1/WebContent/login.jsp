<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<script src="lib/jquery-3.2.1.min.js"></script>
<title>Log in</title>
</head>

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>

<body class="w3-content" style="max-width:1200px">

<jsp:include page="sidebarNotLogged.jsp"/>

<!-- !PAGE CONTENT! -->
<div class="w3-main" style="margin-left:250px">
  
    <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left">Acceder</p>
    <p class="w3-right">
    	<button class="w3-bar-item w3-button w3-hover-grey"><i class="fa fa-search"></i></button>
    	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   	</p>
  </header>
  
	<div class="w3-container w3-center">
	
	
	<% if((Boolean)request.getAttribute("registerSuccess") != null) {
		if((Boolean)request.getAttribute("registerSuccess") == true) { %>

	
			<div id="registerSuccess" class="w3-modal">
			    <div class="w3-modal-content w3-animate-opacity">
    	  			<div class="w3-container">
        				<i onclick="document.getElementById('registerSuccess').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-large"></i>
        				<p>!Enhorabuena� Te has registrado en Instaticket con �xito.</p>
      				</div>
   				</div>
  			</div>
  				
			<script>
			$(document).ready(function() {
			   $("#registerSuccess").css("display","block");
			   $("#registerSuccess").delay(2500).fadeOut();
			});
			</script>
	<%} }%>
	<% if((Boolean)request.getAttribute("loginSuccess") != null) {
		if((Boolean)request.getAttribute("loginSuccess") == false) {
		ArrayList<String> errList = (ArrayList<String>)request.getAttribute("errorLogin");%>		
			
		<div class="w3-panel w3-red w3-card-4">
			<%for(int i = 0; i < errList.size(); i++) {%>
 				<p><%= errList.get(i)%></p>
 			<%} %>
		</div>
		<%} }%>
		
		
		<p>Por favor, ingresa tus datos de acceso:</p>
		<form method="post" action="login">
     		<p>Correo electr�nico:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" maxlength="30" type="email" name="email" required><br>
     		<p>Contrase�a:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" maxlength="30" type="password" name="psw" value="" required/><br>
   			<p><button class="w3-button w3-theme w3-grey" type="submit">Acceder</button><p>
		</form>
   			
   			<a href="register.jsp">�A�n no est�s registrado? Clic aqu� para darte de alta</a>
	</div>

</body>
</html>