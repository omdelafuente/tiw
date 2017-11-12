<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="es.uc3m.tiw.model.Usr, java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="resources/css/w3.css" rel="stylesheet" type="text/css" />
<script src="lib/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="resources/css/fonts.css">
<link rel="stylesheet" href="resources/css/font-awesome-4.7.0/css/font-awesome.min.css">
<title>Comunicación con usuarios</title>
</head>

<style>
body, h1, h2, h3, h4, h5, h6, .w3-wide {
	font-family: "Montserrat", sans-serif;
}
</style>

<body class="w3-content" style="max-width: 1200px">

	<!-- Sidebar/menu -->
	<jsp:include page="sidebarLogged.jsp" />

	<!-- !PAGE CONTENT! -->
	<div class="w3-main" style="margin-left: 250px">

		<!-- Top header -->
		<header class="w3-xlarge w3-container">
		<p class="w3-left">Comunicación con usuarios</p>
		<form action="search" method="post">
			<p class="w3-right">
				<input type="hidden" name="type" value="simple">
				<input class="w3-border" type="text" name="search" style="padding: 8px; font-size: 15px; float: left"
					placeholder="Buscar eventos..." required>
				<button class="w3-bar-item w3-button w3-hover-grey" type="submit">
					<i class="fa fa-search"></i>
				</button>
			</p>
		</form>
		</header>

		<p class="w3-center">
			Conversación con <b><%=request.getAttribute("userEmail")%></b>
		</p>

		<div class="w3-container w3-center">

			<div class="w3-container w3-border">
				<p>Escribe a continuación tu mensaje:</p>
				<form method="post" action="chat" autocomplete="off">
					<input type="hidden" name="userEmail" value="<%=request.getAttribute("userEmail")%>">
					<input type="hidden" name="type" value="write">
					<input class="w3-input w3-border w3-light-grey" name="msg" type="text" required>
					<p>
						<button class="w3-btn w3-border" type="submit">Enviar</button>
					<p>
				</form>
			</div>

			<form method="post" action="chat">
				<input type="hidden" name="userEmail" value="<%=request.getAttribute("userEmail")%>">
				<input type="hidden" name="type" value="read">
				<p>
					<button class="w3-btn w3-border" type="submit">
						<i class="fa fa-refresh">&nbsp;</i>Actualizar conversación
					</button>
				<p>
			</form>

		</div>

		<%
			if (request.getAttribute("sendSuccess") != null) {
		%>
		<div class="w3-container w3-center">
			<p>¡Mensaje enviado!</p>
		</div>
		<%
			}
		%>

		<%
			if (request.getAttribute("messages") != null) {
		%>
		<div class="w3-container w3-left" style="width: 100%">
			<p>Mensajes</p>
			<hr>
			<%=request.getAttribute("messages")%>
			<hr>
		</div>
		<%
			}
		%>
		<!-- End page content -->
	</div>

</body>
</html>