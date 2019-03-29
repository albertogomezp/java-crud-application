<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="icon" href="vista/icon.png" type="image/gif">
	<style>
		body{
			background-image: url("vista/back2.jpg");
			background-size: 100%;
			background-repeat: no-repeat;
			color: white;
			shadow: 2px 2px black
		}
	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
	<script src="vista/src/script.js"></script>

	<script>
		function callJqueryAjax(action){
			//var action = $('#name').val();
			$.ajax({
				url     : '/Competidor/adminCompetidor',
				method     : 'POST',
				data     : {action: action},
				success    : function(resultText){
					$('#wrapper').html(resultText);
				},
				error : function(jqXHR, exception){
					console.log('Error occured!!');
				}
			});
		};
		function quitarCompetidor(param){
			var id = param;
			var action ="eliminar";
			$.ajax({
				url     : '/Competidor/adminCompetidor',
				method     : 'POST',
				data: {"action": action, "id": id}
				success    : function(resultText){
					$('#wrapper').html(resultText);
				},
				error : function(jqXHR, exception){
					console.log('Error occured!!');

				}
			});
			action ="mostrar";
			callJqueryAjax(action);
		};
		</script>
		<script>
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
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>SGJDB</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a
		class="navbar-brand" href="#">Bienvenido, <%out.print(request.getAttribute("displayname"));%></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-5">
			<li class="nav-item active"><a class="nav-link"  href="adminCompetidor?action=index">Menu
				<span class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item"><a class="nav-link" onclick="callJqueryAjax('mostrar')">Listado</a></li>				
			<li class="nav-item"><a class="nav-link" onclick="callJqueryAjax('nuevo')">Nuevo</a></li>
			<li class="nav-item">
				<a class="nav-link" href="adminCompetidor?action=logout" tabindex="-1">Cerrar Sesión</a>
			</li>
		</ul>
		<h2 class="text-light mr-auto mL-3">Listado Competidores</h2>
		
		<form class="form-inline my-2 my-lg-0" >
			<input name="id" class="form-control mr-sm-2" type="search" placeholder="ID Competidor">
			<button class="btn btn-outline-success my-2 my-sm-0"  onclick="AbrirModalbusqueda()" >Buscar</button>
		</form>
	</div>
</nav> 	
<wrapper id="wrapper" class="container-fluid text-center bg-none">
	<h1 class="text-center" >SGJDB</h1>
	<h3>Sistema gestor Judo database</h3>
	<div id="bod" class="text-center">
		<button type="button" class="btn btn-primary text-center" onclick="callJqueryAjax('mostrar')" >	Listado de competidores</button>
	</div>
</wrapper>	
</body>
</html>