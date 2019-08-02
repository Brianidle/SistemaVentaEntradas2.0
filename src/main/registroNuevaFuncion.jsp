<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registro Nueva Función</title>
</head>
<body>
	<form:form action="registarFuncion" >
	<spring:bind path="peliculaPorDefecto.nombre">
		<table>
			<tr>
				<td><b>Pelicula</b></td>
				<td><form:select path="nombre" items="${opcionesPeliculas}" />
				</td>
			</tr>
		</table>
	</spring:bind>
		<label>Fecha</label><br>
		<input type="text" name="fecha"><br>
		<label>Hora</label><br>
		<input type="text" name="hora"><br>
		<input type="submit" value="Registrar Función">
	</form:form>

</body>
</html>