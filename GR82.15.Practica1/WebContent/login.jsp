<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="resources/css/indexStyle.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Karma">
<title>Log in</title>
</head>
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
		<p>Por favor, ingresa tus datos de acceso:</p>
		<form method="post" action="login">
     		<p>Correo electrónico:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="email" name="email"><br>
     		<p>Contraseña:</p>
   			<input class="w3-input w3-border w3-light-grey" style="width:30%; display:inline-block" type="password" name="psw" value=""/><br>
   			<p><button class="w3-button w3-theme w3-grey" type="submit">Acceder</button><p>
		</form>
   			
   			<a href="register.jsp">¿Aún no estás registrado? Clic aquí para darte de alta</a>
	</div>

</body>
</html>