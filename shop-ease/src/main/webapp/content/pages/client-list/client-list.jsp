<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.shopease.database.daos.*,com.shopease.controller.system.users.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Listagem de clientes</title>
		<link rel="stylesheet" type="text/css" href="css/styleConfirmation.css">
	</head>
	<body>
		<c:import url="../header-footer/header.jsp"/>
		<input type="hidden" id="siteId" name="param" value="client.RegisterClient">
		<table class="table-client" border="1">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Email</th>
					<th>CPF</th>
				</tr>
			</thead>
			<tbody>
				<!-- POJO - Plain Old Java Object -->
				<c:forEach var="client" items="${clients}" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
						<td>${id.count}</td>
						<td>${client.name}</td>
						<td>
							<c:choose>
								<c:when test="${not empty client.email}">
									<a href="victorcampos:${client.email}">${client.email}</a>
								</c:when>
								<c:otherwise>
									E-mail não informado
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:import url="../header-footer/footer.jsp"/>
	</body>
</html>
