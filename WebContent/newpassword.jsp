<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Formulario</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<style>
* {
	margin: 5px;
}
</style>
</head>
<header id="header_index">
	<h1>
		<a id="enlace_form" href="index.jsp">∞ Infinity Space ∞</a>
	</h1>

</header>
<body id="body_password">
	<fieldset id="fieldset_password">
		<legend>
			<h1>Cambiar contraseña</h1>
		</legend>
		<form id="form_form" action="Login" method="POST"
			oninput="range_control_value.value= range_control.valueAdNumber">
			<p>
				<label class="label_form" for="contraseña">Contraseña actual:</label> <input
					type="password" name="contraseña">
			</p>
			<p>
				<label class="label_form" for="contraseña">Nueva Contraseña:</label> <input
					type="password" name="contraseña">
			</p>
			<p>
				<label class="label_form" for="contraseña">Repetir
					Contraseña:</label> <input type="password" name="contraseña">
			</p>
			<p>
				<br> <input id="crear_usuario" type="submit"
					value="Cambiar contraseña">
			</p>
		</form>
	</fieldset>
</body>
</html>