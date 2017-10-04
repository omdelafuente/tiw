<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<div id="searchModal" class="w3-modal">
  <div class="w3-modal-content w3-animate-zoom" style="padding:32px">
    <div class="w3-container w3-white w3-center">
      <i onclick="document.getElementById('searchModal').style.display='none'" class="fa fa-remove w3-right w3-button w3-transparent w3-xxlarge"></i>
      <h2 class="w3-wide">Búsqueda avanzada</h2>
      <form method="post">
      	<select class="w3-select w3-border" style="width:30%; display:inline-block">
      	<option value="" disabled selected>Escoge una categoría</option>
    	<option value="cine">Cine</option>
   	 	<option value="teather">Teatro</option>
    	<option value="concerts">Conciertos</option>
    	<option value="festivals">Festivales</option>
    	<option value="art">Arte</option>
    	<option value="sports">Deportes</option>
    	<option value="others">Otros</option>
      	</select>
      	<p><label>Localización</label></p>
 		<input class="w3-input w3-border w3-light-grey" type="text" style="width:30%; display:inline-block">
 		<p><label>Nombre</label></p>
 		<input class="w3-input w3-border w3-light-grey" type="text" style="width:30%; display:inline-block">
 		<p><label>Fecha del evento</label></p>
 		<input class="w3-input w3-border w3-light-grey" type="date" min="2017-01-01" style="width:30%; display:inline-block">
      	<p><label>Precio mínimo</label></p>
     	<input class="w3-input w3-border w3-light-grey" type="number" value="0" name="minPrice" min="0" max="500" style="width:30%; display:inline-block">
     	<p><label>Precio máximo</label></p>
     	<input class="w3-input w3-border w3-light-grey" type="number" value="0" name="maxPrice" min="0" max="500" style="width:30%; display:inline-block">
     	<br><br>
     	<p><button class="w3-button w3-grey w3-left-align" type="submit"><i class="fa fa-search w3-margin-right"></i>Buscar evento</button><p>
      
      </form>
    </div>
  </div>
</div>

</body>
</html>