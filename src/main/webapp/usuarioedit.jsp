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
<c:set var="usuario" scope="request" value="${requestScope.usuario}"/>
<form action="UsuarioController" method="post">
<ul>
<li><label>Id</label> <input type="text" name="id"
value="<c:out value="${usuario.id}"/>" /> </li>
<li><label>Nombre</label> <input type="text" name="nombre"
value="<c:out value="${usuario.nombre}"/>" /> </li>
<li><label>Email</label> <input type="text" name="email"
value="<c:out value="${usuario.email}"/>" /> </li>
<li><label>Pais</label> <input type="text" name="pais"
value="<c:out value="${usuario.pais}"/>" /> </li>
<li> <input type="submit"
value="<c:out value="${usuario != null ? 'Editar' : 'Registrar' }" />" />
</ul>
</form>
</body>
</html>