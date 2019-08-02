<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro de Pelicula</title>
</head>
<body>
	<form:form method="POST" action="registrarPelicula" modelAttribute="generoPorDefecto">
	<label>Nombre de la Pelicula</label><br>
	<input type="text" name="nombrePelicula"><br>
	<table>
        <tr>
            <td>Generos</td>
            <td><form:checkboxes path="nombre" items="${opcionesGeneros}"/><br></td>
        </tr>
    </table>
  	<input type="submit" value="Registrar Pelicula">
	</form:form>
</body>
</html>