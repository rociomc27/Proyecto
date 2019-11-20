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
      <h1><a id= "enlace_form" href="index.jsp" >∞ Infinity Space ∞</a></h1>

    </header>
<body id="body_form">
  <fieldset id="fieldset_form">
  <legend> <h1>Formulario de registro</h1> </legend>
   <form id="form_form" action="" oninput="range_control_value.value= range_control.valueAdNumber">
    <p>
      <label class="label_form" for="nombre_de_usuario"  >Usuario:</label>
      <input type="text" name="name_control" autofocus required />
   </p>
   <p>
      <label class="label_form"for="Nombre"  >Nombre:</label>
      <input type="text" name="nombre" autofocus required />
   </p>
   <p>
      <label class="label_form" for="Apellidos"  >Apellidos:</label>
      <input type="text" name="apellidos" autofocus required />
   </p>
   <p>
      <label class="label_form" for="email"  >Correo electrónico:</label>
      <input type="email" name="email_control" required>
   </p>
   <p>
      <label class="label_form" for="contraseña"  >Contraseña:</label>
     <input type="password" name="contraseña">
   </p>
   <p>
      <label class="label_form" for="contraseña"  >Repetir Contraseña:</label>
     <input type="password" name="contraseña">
   </p>
   <p><br>
  <input id="crear_usuario" type="submit" value="∞ Crear Usuario ∞">
  </p>
  </form>
  </fieldset>
  </body>
  </html>