<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/indexStyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<title>Sign in</title>
</head>
<body class="w3-content" style="max-width:1200px">

<jsp:include page="sidebarNotLogged.jsp"/>

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
  <header class="w3-container w3-xlarge">
    <p class="w3-left">Registrarse</p>
    <form method="post">
    	<p class="w3-right">
    		<a class="w3-bar-item w3-button w3-hover-grey" style="float:left" href="index.jsp"><i class="fa fa-home"></i></a>
      		<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>
      		<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   		</p>
    </form>
  </header>
	<div class="w3-container w3-center">
		<p>Por favor, ingresa tus datos para crear una cuenta:</p>
		<form method="post" action="register">
    		<p>Nombre:</p>
    		<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="text" name="name" value="" /><br>
    		<p>Apellidos:</p>
    		<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="text" name="surname" value="" /><br>
    		<p>Contraseña:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="psw" value=""/><br>
   			<p>Confirmación de la contraseña:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="checkpsw" value=""/><br>
   			<p>Correo electrónico:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="email" name="email"><br>
   			<p><button class="w3-button w3-theme w3-grey" type="submit">Registrarse</button><p>
		</form>
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