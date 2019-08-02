<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro de Pelicula</title>
</head>
<body>
	<h2>Se registro la pelicula ${pelicula.nombre} exitosamente con los siguientes generos:</h2>
	<c:if test="${not empty lists}">
		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue.nombre}</li>
			</c:forEach>
		</ul>
	</c:if>
	<a href="http://localhost:8080/registroPelicula">Registrar Nueva Pelicula</a>  <a href="http://localhost:8080/home">Volver a Home</a>  
</body>
</html>