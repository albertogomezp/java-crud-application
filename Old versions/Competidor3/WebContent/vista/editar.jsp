<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Competidor</title>
</head>
<body>
<wrapper class="container-fluid">
<h1 class="text-center">Actualizar Competidor</h1>
<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4 text-center">
		<form action="adminCompetidor?action=editar" method="post" >
		<table class="table table-striped text-center">
			<tr>
				<td><label>Id</label></td>
				<td><input class="text-center" type="text" name="id" value="<c:out value="${competidor.id}"></c:out>" ></td>
			</tr>
			<tr>
				<td><label>Nombre</label></td>
				<td><input class="text-center"  type="text" name="Nombre" value='<c:out value="${competidor.nombre}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Apellidos</label></td>
				<td><input class="text-center"  type="text" name="Apellidos" value='<c:out value="${competidor.apellidos}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Pais</label></td>
				<td><input class="text-center"  type="text" name="Pais" value='<c:out value="${competidor.pais}"></c:out>' ></td>
			</tr>
			<tr>
				<td><label>Categoria (Varchar - 4)</label></td>
				<td><input class="text-center"  type="text" name="Categoria" value='<c:out value="${competidor.categoria}"></c:out>' ></td>
			</tr>
			
			<tr>
				<td><label>Ranking</label></td>
				<td><input class="text-center"  type="text" name="Ranking" value='<c:out value="${competidor.ranking}"></c:out>' ></td>
			</tr>
		</table>
	
		<input class="btn btn-success text-center" type="submit" name="registrar" value="Guardar"> 
	</form>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
</wrapper>
</body>
</html>