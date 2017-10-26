<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.time.LocalDateTime, java.util.List, es.uc3m.tiw.model.Event, org.apache.commons.codec.binary.StringUtils, org.apache.commons.codec.binary.Base64;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css"/>
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<title>Created events</title>
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
    	<p class="w3-left">Eventos creados</p>
    	<p class="w3-right">
    		<button class="w3-bar-item w3-button w3-hover-grey"><i class="fa fa-search"></i></button>
      		<input class="w3-border" type="text" name="search" style="padding: 8px; font-size:15px; float:left" placeholder="Buscar eventos...">
   		</p>
 	</header>
 	
 	<div class="w3-container">
 		
 		<% List<Event> events = (List<Event>)request.getAttribute("events");
 		for(int i = 0; i < events.size(); i++) {
 		LocalDateTime dateTime =  events.get(i).getEventDate();%>
 		
		 <div class="w3-row">
		 	<hr class="w3-border">
		 	<div class="w3-col w3-display-container" style="width:40%">
		 		<img src="<% StringBuilder sb = new StringBuilder();
						sb.append("data:image/png;base64,");
						sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(events.get(i).getImage(), false)));
						out.print(sb.toString()); %>" style="max-width:100%; max-height:100%">
						<div class="w3-display-middle w3-display-hover w3-animate-opacity w3-large w3-hover-opacity-off">
      						<button class="w3-btn w3-light-grey">Ver evento</button>
    					</div>
		 	</div>
		 	<div class="w3-col w3-padding-small" style="width:60%">
		 		<p><b><%=events.get(i).getTitle()%></b></p>
		 		<p><%=events.get(i).getCategory()%></p>
		 		<p><%=events.get(i).getAvailableTickets()%> entradas disponibles a <%=events.get(i).getPrice()%> €</p>
		 		<p><%=dateTime.toLocalDate()%> a las <%=dateTime.toLocalTime() %>h</p>
		 		<p><%=events.get(i).getPlace()%></p>
		 	</div>
		 	
		 </div>
		 <hr class="w3-border">
		 <%} %>
 	
 	</div>
 	
</div>

</body>
</html>