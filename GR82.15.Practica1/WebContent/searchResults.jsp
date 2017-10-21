<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="es.uc3m.tiw.model.*, java.util.ArrayList, java.util.Date, java.awt.image.*, javax.imageio.ImageIO, java.io.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<title>Resultados de la búsqueda</title>
</head>

<style>
.w3-sidebar a {font-family: "Roboto", sans-serif}
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>


<body class="w3-content" style="max-width:1200px">

<!-- Sidebar/menu -->
<% if (session.getAttribute("loggedUser") != null) { %>
    <jsp:include page="sidebarLogged.jsp"/>
<% } else {%>
  	<jsp:include page="sidebarNotLogged.jsp"/>
<% } %>

<div class="w3-main" style="margin-left:250px">

    <!-- Top header -->
  <header class="w3-container w3-xlarge">
    <p class="w3-left">Resultados de la búsqueda</p>
    <p class="w3-right">
      	<button class="w3-bar-item w3-button w3-hover-grey"><i class="fa fa-search"></i></button>
      	<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   	</p>
  </header>
<br><br>
<div class="w3-row">

	<% ArrayList<EventBean> events = (ArrayList<EventBean>)request.getAttribute("retrievedEvents");
	
	%>
	<div class="w3-col s4 w3-center">      <p></p>    
	</div>
	<div class="w3-col s4 w3-center">      
      
      	<%for(int i = 0; i < events.size(); i++){ %>
      	<div class="w3-container">
      		<div class="w3-display-container">
      			<img class="event-img" src="<%= events.get(i).getImagePath() %>" style="width:100%">
      			<div class="w3-display-middle w3-display-hover">
      				<button class="w3-button w3-black">Información del evento</button>
      			</div>
      		</div>
      		<p><%=events.get(i).getTitle() %><br><b><%=events.get(i).getPrice() %>€</b></p>
      	</div>
      	<%} %>
      
   </div>

	<div class="w3-col s4 w3-center">  <p></p>    
	</div>

  </div> 
  
</div>


</body>
</html>