<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
	<body>
		<main>
			<table border="1" class="table-view-list" id="clientTable">
				<thead>
					<tr>
				    	<th>Nome</th>
				        <th>Email</th>
				        <th>Telefone</th>
				    </tr>
				 </thead>
				 <tbody>
				 	<c:forEach var="client" items="${clients}">
				    	<tr>
				        	<td>${client.name}</td>
				            <td>${client.email}</td>
				            <td>${client.phoneNumber}</td>
				        </tr>
					</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>