<!DOCTYPE html>
<html lang="es">
<head>
<link rel="icon" href="vista/icon.png" type="image/gif">

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>SGJDB</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<style type="text/css">
	.login-form {
		width: 340px;
    	margin: 50px auto;
	}
    .login-form form {
    	margin-bottom: 15px;
        background: #f7f7f7;
        box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
        padding: 30px;
    }
    .login-form h2 {
        margin: 0 0 15px;
    }
    .form-control, .btn {
        min-height: 38px;
        border-radius: 2px;
    }
    .btn {        
        font-size: 15px;
        font-weight: bold;
    }
</style>
</head>
<body>
<div class="login-form">
    <form action="adminCompetidor?action=signup" method="post">
        <h2 class="text-center">Registrarse</h2>       
        <div class="form-group">
            <input name="user" type="text" class="form-control" placeholder="usuario" required="required">
        </div>
        <div class="form-group">
            <input name="password" type="password" class="form-control" placeholder="contraseņa" required="required">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-block">Enviar</button>
        </div>
    </form>
</div>
</body>
</html>         