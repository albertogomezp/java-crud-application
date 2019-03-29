<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="icon" href="vista/icon.png" type="image/gif">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
			
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Competidor</title>
</head>
<body>
<wrapper class="container-fluid">
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
			<li class="nav-item"><a class="nav-link" href="adminCompetidor?action=nuevo">Nuevo</a></li>
			<li class="nav-item">
				<a class="nav-link" href="adminCompetidor?action=logout" tabindex="-1">Cerrar Sesión</a>
			</li>
		</ul>
				<h2 class="text-light mr-auto mL-3">Listado Competidores</h2>
		
		<form class="form-inline my-2 my-lg-0" action="adminCompetidor?action=showedit" method="post">
			<input name="id" class="form-control mr-sm-2" type="search" placeholder="ID Competidor">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
		</form>
	</div>
	</nav> 
<h1 class="text-center">Actualizar Competidor</h1>
<div class="row">
		<div class="col-md-4">
		</div>
		<div class="col-md-4 text-center">
		<form action="adminCompetidor?action=editar" method="post" >
		<!-- MODAL -->
		
		<div class="modal fade" id="modalRegisterForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Sign up</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body mx-3">
        <div class="md-form mb-5">
          <label data-error="wrong" data-success="right" for="orangeForm-name">Id</label><br>
          <input class="text-center" type="text" name="id"  value="<c:out value="${competidor.id}"></c:out>" required>
        </div>
        <div class="md-form mb-5">
            <label data-error="wrong" data-success="right" for="orangeForm-email">Nombre</label><br>
            <input class="text-center"  type="text" name="Nombre" value='<c:out value="${competidor.nombre}"></c:out>'required >
        </div>
        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="orangeForm-pass">Apellidos</label><br>
          <input class="text-center"  type="text" name="Apellidos" value='<c:out value="${competidor.apellidos}" ></c:out>' required>
        </div>
        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="orangeForm-pass">Pais</label><br>
          <input class="text-center"  type="text" name="Pais" value='<c:out value="${competidor.pais}"></c:out>'required >
        </div>
        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="orangeForm-pass">Categoria</label><br>
          <input class="text-center"  type="text" name="Categoria" value='<c:out value="${competidor.categoria}" ></c:out>' required>        
        </div>
        <div class="md-form mb-4">
          <label data-error="wrong" data-success="right" for="orangeForm-pass">Ranking</label><br>
         <input class="text-center"  type="text" name="Ranking" value='<c:out value="${competidor.ranking}" ></c:out>' required>    
        </div>                      
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <input class="btn btn-deep-orange" type="submit" name="registrar" value="Guardar">
      </div>
    </div>
  </div>
</div>

<!-- > -->
		

<div class="text-center">
  <a href="" class="btn btn-primary btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalRegisterForm">MOSTRAR</a>
</div>
		</div>
		<div class="col-md-4">
		</div>
	</div>
	
</wrapper>
</body>
</html>