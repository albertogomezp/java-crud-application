<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="icon" href="vista/icon.png" type="image/gif">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Competidor</title>
</head>
<body>
<wrapper class="container-fluid" >
	
<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4 text-center bg-light">
	<h1 class="text-center">Registrar Competidor</h1>
	<form class="form-group" action="adminCompetidor?action=register" method="post">
		<table class="table table-stripped text-center">
		<tr>
			<td><a>Nombre:</a></td>		
			<td><input type="text" name="Nombre" required/></td>	
		</tr>
		<tr>
			<td><a>Apellidos:</a></td>		
			<td><input type="text" name="Apellidos" required/></td>	
		</tr>
		<tr>
			<td><a>Pais:</a></td>		
			<td><input type="text" name="Pais" required/></td>	
		</tr>
		<tr>
			<td><a>Categoria: (varchar 4)</a></td>		
			<td><input type="text" name="Categoria"required /></td>	
		</tr>
		<tr>
			<td><a>Ranking:</a></td>		
			<td><input type="text" name="Ranking" required /></td>	
		</tr>		
		
	</table>
	<br>
	<button class=" btn btn-primary" href="adminCompetidor?action=index"><a class="text-light" href="adminCompetidor?action=index" >menu</a> </button>			

	<input class="btn btn-success" type="submit" value="Agregar" name="agregar"></td>	
	</form>
		
		
		</div>
		<div class="col-md-4">
		</div>
	</div>





</wrapper>	
</body>
</html>