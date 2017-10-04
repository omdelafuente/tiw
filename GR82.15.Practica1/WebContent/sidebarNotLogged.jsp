<%@ page language="java" contentType="text/html"
    import="es.uc3m.tiw.*" %>
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
body,h1,h2,h3,h4,h5,h6,.w3-wide {font-family: "Montserrat", sans-serif;}
</style>
<body>

<!-- Sidebar/menu -->
<nav class="w3-sidebar w3-bar-block w3-white w3-collapse w3-top" style="z-index:3;width:250px" id="sidebar">
  <div class="w3-container w3-display-container w3-padding-16">
    <i onclick="w3_close()" class="fa fa-remove w3-hide-large w3-button w3-display-topright"></i>
    <h3 class="w3-wide"><b>INSTATICKET</b></h3>
  </div>
  <div class="w3-padding-32 w3-large w3-text-grey" style="font-weight:bold">
  	<a href="login.jsp" class="w3-bar-item w3-button"><i class="fa fa-sign-in w3-margin-right"></i>Accede</a>
    <a onclick="document.getElementById('searchModal').style.display='block'"class="w3-button w3-block w3-left-align" id="searchMenuBtn"><i class="fa fa-search w3-margin-right"></i>
      Búsqueda avanzada &nbsp;&nbsp;<i class="fa fa-caret-right"></i>
    </a>
  </div>
</nav>

<jsp:include page="advancedSearch.jsp"/>

</body>
</html>