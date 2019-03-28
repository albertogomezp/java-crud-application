<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Administrar Competidores</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="vista/src/icon.png" type="image/gif">
	<style>	    <%@include file="/vista/src/listado.css" %>	</style>
	<script>    <%@include file="/vista/src/script.js" %>	</script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body class="container-fluid">
	<div id="wrapper" class="container container-fluid pt-0"> 
		
		<div class="row">
			<div class="col-sm-2 ml-auto mr-auto">
				<img src="vista/src/IJF.png" class="img-fluid">
			</div>
			
			<div class="col-sm-8 " id="lista">
				<h1 class="text-center text-light">Lista Competidores</h1>
				
				<div id="TablaExt" class="container container-fluid">
					<table id="Tabla1"	class="table table-striped text-center  bg-light">
						<tr class="sticky-top position-relative">
							<td>ID</td>
							<td>NOMBRE</td>
							<td>APELLIDOS</td>
							<td>PAIS</td>
							<td>CATEGORIA</td>
							<td>RANKING</td>
							<td colspan=2>ACCIONES</td>
						<c:set var = "fila" value = "${-1}"/> 
						<c:forEach var="competidor" items="${lista}"> 
						<c:set var = "fila" value = "${fila+1}"/>
						<tr id="tr<c:out value="${fila}" />">
							<td id="id<c:out value="${fila}"/>" ><c:out value="${competidor.id}" /></td>
							<td id="nombre<c:out value="${fila}"/>"><c:out value="${competidor.nombre}" /></td>
							<td id="apellidos<c:out value="${fila}"/>"><c:out value="${competidor.apellidos}" /></td>
							<td id="pais<c:out value="${fila}"/>"><c:out value="${competidor.pais}" /></td>
							<td id="categoria<c:out value="${fila}"/>"><c:out value="${competidor.categoria}" /></td>
							<td id="ranking<c:out value="${fila}"/>"><c:out value="${competidor.ranking}" /></td>
							<td>
								<button id="<c:out value="${fila}"/>" type="button" class="btn btn-primary text-light" onclick="AbrirModal(<c:out value="${fila}"/>)">	
								Editar
								</button>
							</td>
							<td>
								<button type="button" class="btn btn-danger" onclick="quitarCompetidor(<c:out value="${competidor.id}" />)">
										
									<a  class="text-light" >Eliminar</a>
								</button>
							</td>
						
						</tr>
					</c:forEach>
				</table>
				<pre id="output" class="text-light"></pre>
				
			</div>
		</div>
		<div class="col-md-2 ml-auto mr-auto">
			<img src="vista/src/IJF.png" class="img-fluid">
		</div>
	
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content bg-dark text-light">
					<div class="modal-header">
						<h5 class="modal-title text-center" id="exampleModalLabel">Editar competidor</h5>
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body text-center">
						<form id="form1" class="enviar modal-body mx-3" action="adminCompetidor?action=editar" method="post" >
							<div class="md-form mb-5">
								<label>numero ID</label><br>
								<input id="idr" class="text-center  " type="text" name="id" value="1" required>
							</div>
							<div class="md-form mb-5">
								<label>Nombre</label><br>
								<input id="nombrer" class="text-center"  type="text" name="Nombre" value='2'required >
							</div>
							<div class="md-form mb-4">
								<label>Apellidos</label><br>
								<input id="apellidosr" class="text-center"  type="text" name="Apellidos" value='3' required>
							</div>
							<div class="md-form mb-4">
								<label>Pais</label><br>
								<input id="paisr" class="text-center"  type="text" name="Pais" value='4'required >
							</div>
							<div class="md-form mb-4">
								<label>Categoria</label><br>
								<input id="categoriar" class="text-center"  type="text" name="Categoria" value='5' required>        
							</div>
							<div class="md-form mb-4">
								<label>Ranking</label><br>
								<input id="rankingr" class="text-center"  type="text" name="Ranking" value='6' required>    
							</div>                      
							<div class="modal-footer d-flex justify-content-center">
								<input id="sendbutton2" class="btn btn-deep-orange" type="submit" name="registrar" value="Guardar" onclick="refreshlist()">
							</div>
						</form>
			</div>
		</div>	
	</div>
</body>
</html>