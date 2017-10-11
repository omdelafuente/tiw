<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
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
    <form method="post">
    	<p class="w3-right">
    		<a class="w3-bar-item w3-button w3-hover-grey" style="float:left" href="index.jsp"><i class="fa fa-home"></i></a>
      		<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
      		<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   		</p>
    </form>
  </header>
  
	<div class="w3-container w3-center">
	
	
	<% if((Boolean)request.getAttribute("failedLogin") != null) {%>
	
		<div class="w3-panel w3-red w3-card-4">
 			 <p>La contrase�a o el usuario son incorrectos.</p>
		</div>
	<%} %>
	<!--	
	 		<div class="w3-panel w3-red w3-card-4">
 			 	<p></p>
			</div>
		-->
		
		
		<p>Por favor, ingresa tus datos de acceso:</p>
		<form method="post" action="login">
     		<p>Correo electr�nico:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="email" name="email"><br>
     		<p>Contrase�a:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="psw" value=""/><br>
   			<p><button class="w3-button w3-theme w3-grey" type="submit">Acceder</button><p>
		</form>
   			
   			<a href="register.jsp">�A�n no est�s registrado? Clic aqu� para darte de alta</a>
	</div>

</body>
</html>