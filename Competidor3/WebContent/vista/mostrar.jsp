<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Administrar Competidores</title>
</head>
<body>
	<wrapper class="container">
		
		
		
		<ul class="nav justify-content-center">
			<li class="nav-item">
			
				<button class=" btn btn-primary" href="adminCompetidor?action=index"><a class="text-light" href="adminCompetidor?action=index" >menu</a> </button>
			</li>
		</ul>
		
		<div class="row">
		<div class="col-md-2">
		</div>
		<div class="col-md-8">
		<h1 class="text-center">Lista  Competidores</h1>

		
		<table id="Tabla1" class="table table-striped text-center container-fluid">
			<tr>
				<td>ID</td>
				<td>NOMBRE</td>
				<td>APELLIDOS</td>
				<td>PAIS</td>
				<td>CATEGORIA</td>
				<td>RANKING</td>
				<td colspan=2>ACCIONES</td>
			</tr>
			<c:forEach var="competidor" items="${lista}">
			<tr>
				<td><c:out value="${competidor.id}"/></td>
				<td><c:out value="${competidor.nombre}"/></td>
				<td><c:out value="${competidor.apellidos}"/></td>
				<td><c:out value="${competidor.pais}"/></td>
				<td><c:out value="${competidor.categoria}"/></td>
				<td><c:out value="${competidor.ranking}"/></td>
				<td><button type="button" class="btn btn-primary"  ><a class="text-light"  href="adminCompetidor?action=showedit&id=<c:out value="${competidor.id}" />">Editar</a>   </button>    </td>
				<td><button type="button" class="btn btn-danger"><a class="text-light"  href="adminCompetidor?action=eliminar&id=<c:out value="${competidor.id}" />">Eliminar</a>   </button>    </td>				
			</tr>
		</c:forEach>
	</table>
	</div>
		
		
		
		
</wrapper>

</body>
</html>