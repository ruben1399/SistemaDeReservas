<%@page import="controladores.ConexionDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- charset="ISO-8859-1"> -->
<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
	<form action="FormController" method="POST">
		<div>
			<label>DNI:</label> <input type="text" name="sDNI"
				placeholder="20932847J" id="DNI" required> <label>Nombre:</label>
			<input type="text" name="sNombre" placeholder="Pon tu nombre"
				id="Nombre" required> <label>Apellidos:</label> <input
				type="text" name="sApellidos" placeholder="Pon tus Apellidos"
				id="Apellidos" required> <label>Numero de telefono:</label>
			<input type="number" name="iTelefono" placeholder="Pon tu telefono"
				id="nTelefono" required> <label>E-mail:</label> <input
				type="text" name="sEmail" placeholder="Pon tu Email" id="email"
				required>
		</div>
		<br> <label>Seleciona que Sala quieres Jugar:</label> <select
			name="select">
			<option value="Selecione" selected>Selecione</option>
			<option value="Tutankamon">Los Secretos del Faraón
				Tutankamón</option>
			<option value="Colon">sEl descubrimiento de Cristobal Colón</option>
			<option value="Castillo">El Castillo de Ricardo Corazón de
				León</option>
			<option value="Steampunk">Steampunk, El futuro</option>
		</select> <label>Seleciona que hora quieres jugar:</label> <select
			name="select">
			<option value="Selecione" selected>Selecione</option>
			<option value="10:00">10:00</option>
			<option value="11:45">11:45</option>
			<option value="13:00">13:00</option>
			<option value="15:15">15:15</option>
			<option value="17:00">17:00</option>
			<option value="18:45">18:45</option>
			<option value="20:30">20:30</option>
			<option value="22:15">22:15</option>
		</select> 
		<div>
		<br>
			<label>¿Cuantos participantes sois?: </label>
			<div>
				<input type="radio" name="checkTrabajo" value="50"> <label>De
					2 a 5 Personas (50€)</label>
			</div>
			<div>
				<input type="radio" name="checkTrabajo" value="60"> <label>6
					Personas (60€)</label>
			</div>
		</div>



		<input type="submit" name="Enviar" value="Enviar">
	</form>
	
	<%
	ConexionDB BBDD= new ConexionDB("escaperoom");
	if(BBDD.checkConnectionDatabase()){
		out.write("Conectado correctamente a la base de datos");
	} else {
		out.write("Pa tu casa");
	}
	
	%>

</body>
</html>