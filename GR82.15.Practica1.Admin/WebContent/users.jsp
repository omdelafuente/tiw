<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="es.uc3m.tiw.model.Usr, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<title>Gestión de usuarios</title>
</head>

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>

<body class="w3-content" style="max-width:1200px">

<jsp:include page="sidebarLogged.jsp"/>

<!-- PAGE CONTENT -->
<div class="w3-main" style="margin-left:250px">

 <!-- Top header -->
	<header class="w3-container w3-xlarge">
    	<p class="w3-left">Gestión de usuarios</p>
    	<form action="search" method="post">
    	<p class="w3-right">		
    		<input type="hidden" name="type" value="simple">
    		<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar..." required>
    		<button class="w3-bar-item w3-button w3-hover-grey" type="submit"><i class="fa fa-search"></i></button>  	
   		</p>
    </form>
 	</header>
 	
 	<%if(request.getAttribute("noUsers") != null){ %>	
			<div class="w3-container w3-center">
				<p>No se han encontrado usuarios activos.</p>
			</div>
	<%}
		
	else {%>
	
	<div class="w3-container w3-center">
	
		<%List<Usr> users = (List<Usr>) request.getAttribute("users"); %>
		
		<%for(int i = 0; i < users.size();i++) {%>
			<div class="w3-row w3-border">			
				<div class="w3-container w3-half">
					&nbsp;
					<p>Nombre y apellidos: <%=users.get(i).getName()%> <%=users.get(i).getSurname()%></p>
					<p>Correo electrónico: <%=users.get(i).getEmail()%></p>
				</div>
				<div class="w3-container w3-half">
					<p><a class="w3-button w3-border">Modificar datos</a></p>
					<p><a class="w3-button w3-border">Dar de baja</a></p>
				</div>
			</div>
		<%}%>
 	
 	</div>
 	
 	<%} %>
 <!-- End page content -->
 </div>

</body>
</html>