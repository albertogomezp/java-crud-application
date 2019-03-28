<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="icon" href="vista/src/icon.png" type="image/gif">
	<style>	    <%@include file="vista/src/index2.css" %>	</style>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
	<script>    <%@include file="vista/src/script.js" %>	</script>
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
<!-- 		<form class="form-inline my-2 my-lg-0" > -->
<!-- 			<input name="id" class="form-control mr-sm-2" type="search" placeholder="ID Competidor"> -->
<!-- 			<button class="btn btn-outline-success my-2 my-sm-0"  onclick="AbrirModalbusqueda()" >Buscar</button> -->
<!-- 		</form> -->
	</div>
</nav> 	
<div id="wrapper" class="container-fluid text-center bg-none">
	<h1 class="text-center" >SGJDB</h1>
	<h3>Sistema gestor Judo database</h3>
	<div id="bod" class="text-center">
		<button type="button" class="btn btn-primary text-center" onclick="callJqueryAjax('mostrar')" >	Listado de competidores</button>
	</div>
</div>	
</body>
</html>