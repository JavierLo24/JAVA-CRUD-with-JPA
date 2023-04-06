<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Aplicacion Gestión de Usuarios</title>
</head>
<body>
	<table>
		<jsp:useBean id="uDao" class="services.UsuarioDao" scope="request">
		</jsp:useBean>
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Email</th>
			<th>Pais</th>
		</tr>
		<c:forEach var="usuario" items="${uDao.list()}">
		<tr>
			<td><c:out value="${usuario.id}"></c:out></td>
			<td><c:out value="${usuario.nombre}"></c:out></td>
			<td><c:out value="${usuario.email}"></c:out></td>
			<td><c:out value="${usuario.pais}"></c:out></td>
		</tr>
		</c:forEach>
	</table>
	<a href="UsuarioController?id=<c:out value="${usuario.id}"/>">Editar</a>
</body>
</html>