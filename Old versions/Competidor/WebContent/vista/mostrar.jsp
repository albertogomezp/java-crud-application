<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Administrar Competidores</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="icon" href="vista/icon.png" type="image/gif">
	<style>
		body{
			background-image: url("vista/back2.jpg");
			background-size: 100%;
			background-repeat: no-repeat;
			background-attachment: fixed;
			color: black;
			shadow: 2px 2px black
		}	
	</style>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		$("#form1").submit(function(e) {
			var txt;
			var r = confirm("Press a button!");
			if (r == true) {
				txt = "You pressed OK!";
			} else {
				txt = "You pressed Cancel!";
			}
			e.preventDefault(); // avoid to execute the actual submit of the form.
			
			var form = $(this);
			var url = form.attr('adminCompetidor?action=editar');
			
			$.ajax({
				type: "POST",
				url: url,
				data: form.serialize(), // serializes the form's elements.
				success: function(data)
				{
					alert(data); // show response from the php script.
				}
			});
		});
		var idb;
		function getidb(){
			idb = document.getElementById('buscarid').value;
			console.log(idb);
			return idb;
		};
		function AbrirModalbusqueda() {
			idb = getidb();
			var element = document.getElementById("tr"+idb);
			element.classList.add("bg-dark");
			element.classList.add("text-light");
		};
		function AbrirModal(x) {
			$('#exampleModal').modal('show'); // abrir
			document.getElementById("idr").value = document.getElementById("id"+x).innerHTML;
			document.getElementById("nombrer").value = document.getElementById("nombre"+x).innerHTML;
			document.getElementById("apellidosr").value = document.getElementById("apellidos"+x).innerHTML;
			document.getElementById("paisr").value = document.getElementById("pais"+x).innerHTML;
			document.getElementById("categoriar").value = document.getElementById("categoria"+x).innerHTML;
			document.getElementById("rankingr").value = document.getElementById("ranking"+x).innerHTML;
			idb =  getidb();
			var element = document.getElementById("tr"+idb);
			element.classList.remove("bg-dark");
			element.classList.remove("text-light");
		};
		
	</script>	
	
	
</head>
<body class="container-fluid">
	<div id="show" align="center"></div>
	
	<nav class=" container-fluid navbar navbar-expand-lg navbar-dark bg-dark sticky-top mt-0">
		<a	class="navbar-brand" href="#">Bienvenido, <%out.print(request.getAttribute("displayname"));%></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"		data-target="#navbarSupportedContent">
			<span class="navbar-toggler-icon"></span>
		</button>
		
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-5">
				<li class="nav-item"><a class="nav-link" href="adminCompetidor?action=index">Menu</a></li>
				<li class="nav-item active"><a class="nav-link" href="adminCompetidor?action=mostrar">Listado</a></li>
				
				<li class="nav-item "><a class="nav-link"  href="adminCompetidor?action=nuevo">Nuevo</a></li>
				<li class="nav-item">
					<a class="nav-link" href="adminCompetidor?action=logout" tabindex="-1">Cerrar Sesi�n</a>
				</li>
			</ul>
			<h3 class="text-light mr-auto mL-3">SGJDB</h3>
			
			<div class="form-inline my-2 my-lg-0" action="AbrirModal()">
				<input id="buscarid" class="form-control mr-sm-2" type="search" placeholder="ID Competidor">
				<button  type="button" class="btn btn-primary text-light" onclick="AbrirModalbusqueda()">	
					Buscar
				</button>
			</form>
		</div>
		
	</nav> 
	<wrapper id="wrapper" class="container container-fluid pt-0"> 
		
		<div class="row">
			<div class="col-sm-2 ml-auto mr-auto">
				<img src="vista/IJF.png" class="img-fluid">
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
							<tr id="tr<c:out value="${competidor.id}" />">
							<td id="id<c:out value="${fila}"/>" ><c:out value="${competidor.id}" /></td>
							<td id="nombre<c:out value="${fila}"/>"><c:out value="${competidor.nombre}" /></td>
							<td id="apellidos<c:out value="${fila}"/>"><c:out value="${competidor.apellidos}" /></td>
							<td id="pais<c:out value="${fila}"/>"><c:out value="${competidor.pais}" /></td>
							<td id="categoria<c:out value="${fila}"/>"><c:out value="${competidor.categoria}" /></td>
							<td id="ranking<c:out value="${fila}"/>"><c:out value="${competidor.ranking}" /></td>
							<td>
								<button id="<c:out value="${fila}"/>" type="button" class="btn btn-primary text-light" onclick="AbrirModal(this.id)">	
								Editar
							</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger">
								<a  class="text-light" href="adminCompetidor?action=eliminar&id=<c:out value="${competidor.id}" />">Eliminar</a>
							</button>
						</td>
						
					</tr>
				</c:forEach>
			</table>
			<pre id="output" class="text-light"></pre>
			
		</div>
	</div>
	<div class="col-md-2 ml-auto mr-auto">
		<img src="vista/IJF.png" class="img-fluid">
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
				<!-- 					<div class="modal-footer"> -->
					<!-- 						<button  id="sendbutton1" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> -->
					<!-- 						<button id="sendbutton"  type="submit" class="btn btn-secondary" data-dismiss="modal" >Enviar(?)</button> -->
					<!-- 					</div> -->
				</div>
			</div>
		</div>	
	</wrapper>
</body>
</html>