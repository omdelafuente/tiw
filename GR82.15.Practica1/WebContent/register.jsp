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
<body>

<form class="center" method="post" action="register">
    Por favor, ingrese sus datos: <br>
    Nombre:<br>
    <input type="text" name="name" value="" /><br>
    Apellidos:<br>
    <input type="text" name="surname" value="" /><br>
    Contraseña:<br>
   	<input type="password" name="psw" value=""/><br>
   	Correo electrónico:<br>
   	<input type="email" name="email"><br>
   	<input type="submit" value="Registrarse">
</form>

</body>
</html>