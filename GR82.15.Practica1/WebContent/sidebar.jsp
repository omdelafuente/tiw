<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;overflow:hidden;}
</style>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="sidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>INSTATICKET</b></h3>
  </div>
  <div class="w3-padding-32 w3-large w3-text-grey" style="font-weight:bold">
  	<a href="login.jsp" class="w3-bar-item w3-button">Accede</a>
    <a href="#" class="w3-bar-item w3-button">Cartera de entradas</a>
    <a onclick="searchAccordion()" href="javascript:void(0)" class="w3-button w3-block w3-white w3-left-align" id="searchMenuBtn">
      Búsqueda avanzada &nbsp;&nbsp;&nbsp;&nbsp;<i class="fa fa-caret-down"></i>
    </a>
    <div id="searchMenu" class="w3-bar-block w3-hide w3-padding-large w3-medium">
      <form method="post">
      	<select class="w3-select w3-border">
      	<option value="" disabled selected>Escoge una categoría</option>
    	<option value="cine">Cine</option>
   	 	<option value="teather">Teatro</option>
    	<option value="concerts">Conciertos</option>
    	<option value="festivals">Festivales</option>
    	<option value="art">Arte</option>
    	<option value="sports">Deportes</option>
    	<option value="others">Otros</option>
      	</select>
      	<p><label>Localización</label>
 		<input class="w3-input w3-border w3-light-grey" type="text"></p>
 		<p><label>Nombre</label>
 		<input class="w3-input w3-border w3-light-grey" type="text"></p>
 		<p><label>Fecha del evento</label>
 		<input class="w3-input w3-border w3-light-grey" type="date" min="2017-01-01"></p>
      	<p><label>Precio mínimo</label>
     	<input class="w3-input w3-border w3-light-grey" type="number" value="0" name="minPrice" min="0" max="500"></p>
     	<p><label>Precio máximo</label>
     	<input class="w3-input w3-border w3-light-grey" type="number" value="0" name="maxPrice" min="0" max="500"></p>
     	<p><button class="w3-button w3-block w3-grey w3-left-align" type="submit"><i class="fa fa-search w3-margin-right"></i>Buscar evento</button><p>
      
      </form>
    </div>
  </div>
</nav>

</body>
</html>