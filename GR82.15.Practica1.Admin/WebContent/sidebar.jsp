<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="sidebar">
<div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <a href="index.jsp"  style="text-decoration:none"><h3 class="w3-wide"><b>INSTATICKET</b></h3></a>
  </div>
  <div class="w3-padding-32 w3-large w3-text-grey" style="font-weight:bold">
  	<p class="w3-bar-item"> �Hola</p>
  	<a href="editProfile.jsp" class="w3-bar-item w3-button">Editar perfil</a>
    <a href="#" class="w3-bar-item w3-button">Cartera de entradas</a>
    <a href="createEvent.jsp" class="w3-bar-item w3-button">Crear un evento</a>
    <a href="myCreatedEvents" class="w3-bar-item w3-button">Mis eventos</a>
    <a onclick="document.getElementById('searchModal').style.display='block'"class="w3-button w3-block w3-left-align" id="searchMenuBtn">
      B�squeda avanzada &nbsp;&nbsp;<i class="fa fa-caret-right"></i>
    </a>
    <a href="logOut" class="w3-bar-item w3-button">Cerrar sesi�n</a>
  </div>
</nav>
</body>
</html>