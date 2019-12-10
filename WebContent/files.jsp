<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="database.LogicBD"%>
<%@ page import="entity.Archive"%>
<%@ page import="java.util.List"%>
<%@ page import="servlets.Logout"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Mis archivos</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body id="body_archivos">
	<%
		String n = request.getParameter("user");
		if (n == null) {
			HttpSession sesion = request.getSession(true);
			n = (String) sesion.getAttribute("user");
		}

		ServletContext contextoAplicacion = this.getServletContext();
		LogicBD logicBD = (LogicBD) contextoAplicacion.getAttribute("logicBD");
	%>
	<header id="archivos">∞ Infinity Space ∞</header>
	<div class="toolbar">
		<nav class="menu">
			<ul>
				<li><input id="newfolder" type="button" value="Crear Carpeta"></li>
				<li><label  id="newfolder1"  for="file-upload" class="subir"> <i
						class="fas fa-cloud-upload-alt"></i> Examinar Archivo
				</label> <input id="file-upload" onchange='cambiar()' type="file"
					style='display: none;' />
					<div id="info"></div>
				<li><input id="uploadfile" type="submit" value="Subir archivo" /></li>
				<li><a id="fulanito" href="#"><%= n %></a>
					<ul id="userlogout">
						<li id="changePass"><a href="newpassword.jsp"> Cambiar contraseña </a>
						<li id="userout"><a href="Logout"> Cerrar sesión </a></li>
					</ul></li>
			</ul>
		</nav>
	</div>
	<div>
		<div id="sidebar" class="sidebar">
			<div class="folder_label">
			<button class="folder_button">Cumpleaños Maria</button>
		</div>
		</div>
		<div class="rute">
			<ul class="breadcrumb">
				<li><a href="#">Mis Archivos</a></li>
				<li><a href="#">Fotografías</a></li>
				<li><a href="#">2016</a></li>
				<li>Cumpleaños de María</li>
			</ul>
		</div>
	</div>
	<div id="contenido_archivos">

		<div class="file_label">
			<button class="file_button">img_001</button>
		</div>
		<div class="file_label">
			<button class="file_button">img_002</button>
		</div>
		<div class="file_label">
			<button class="file_button">img_003</button>
		</div>
	</div>
</body>
</html>
