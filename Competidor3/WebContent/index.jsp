<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD COMPETIDORES</title>
</head>
<body>
<wrapper class="container-fluid text-center">
	<h1 class="text-center" >INICIAR SESIÓN</h1>
	<div class="text-center">
		<form action="adminCompetidor?action=hacerlogin" method="post" >
		<table class="table table-striped text-center">
			<tr>
				<td><label>Usuario</label></td>
				<td><input class="text-center" type="text" name="user" required ></td>
			</tr>
			<tr>
				<td><label>Contraseña</label></td>
				<td><input class="text-center"  type="password" name="password" required></td>
			</tr>
			
		</table>
	
		<input class="btn btn-success text-center" type="submit" name="registrar" value="Guardar"> 
	</form>
	</div>

	
</wrapper>	
</body>
</html>