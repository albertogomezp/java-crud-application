<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SGJDB</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
	<style>	    <%@include file="vista/src/index.css" %>	</style>
	<script>    <%@include file="vista/src/script.js" %>	</script>
</head>
<body>
<div class="login-form">
    <form action="adminCompetidor?action=securelogin" method="post">
        <h2 class="text-center">Iniciar Sesión</h2>       
        <div class="form-group">
            <input name="user" type="text" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Enviar</button>
        </div>
        <div class="clearfix">
            <label class="pull-left checkbox-inline"><input type="checkbox"> Recuerdame</label>
            <a href="#" class="pull-right">¿olvidaste tu contraseña?</a>
        </div>        
    </form>
    <p class="text-center"><a href="adminCompetidor?action=signupmenu">Crear cuenta</a></p>
</div>
</body>
</html>         