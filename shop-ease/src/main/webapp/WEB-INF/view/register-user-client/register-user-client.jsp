<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value='/content/assets/css/register-user-client/register-user-client-styles.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/content/assets/css/register-user-client/view-list-client-styles.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/content/assets/css/register-user-client/modal/message.css' />" type="text/css">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<main class="main-user-client">
    <section class="container-user-client">
        <div class="inner-container-user-client">
            <h2 class="title-user-client">Cadastrar cliente</h2>
			<!-- Servlet de destino -->
            <form action="<c:url value='/reqSubmitClient' />" method="POST" class="form">
                <input type="hidden" id="siteId" name="param" value="client.RegisterClient">
                <div class="form-group">
                    <label for="name">Nome</label>
                    <input type="text" id="name" name="name" required>
                </div>
                <div class="form-group">
                    <label for="address">Endereço</label>
                    <input type="text" id="address" name="address" required>
                </div>
                <div class="form-group">
                    <label for="homeNumber">Nº</label>
                    <input type="text" id="homeNumber" name="homeNumber" required>
                </div>
                <div class="form-group">
                    <label for="neighborhood">Bairro</label>
                    <input type="text" id="neighborhood" name="neighborhood" required>
                </div>
                <div class="form-group">
                    <label for="city">Cidade</label>
                    <input type="text" id="city" name="city" required>
                </div>
                <div class="form-group">
                    <label for="state">Estado</label>
                    <input type="text" id="state" name="state" required>
                </div>
                <div class="form-group">
                    <label for="country">País</label>
                    <input type="text" id="country" name="country" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>
                <div class="form-group">
                    <label for="phoneNumber">Telefone</label>
                    <input type="text" id="phoneNumber" name="phoneNumber" required>
                </div>
                <div class="form-group">
                    <input type="submit" id="submitButton" value="Enviar">
                </div>
                <div id="myMessage" class="message">
                    <div class="message-content" id="message-content">
                        <span class="close" onclick="closeMessage()">&times;</span>
                        <h2>Mensagem</h2>
                        <p>Cadastro realizado!</p>
                        <script type="text/javascript" src="<c:url value='/content/assets/js/register-user-client/modal/message.js' />"></script>
                    </div>
                </div>
            </form>
        </div>
    </section>
    <section class="view-client-list">
    	<div class="view-container-list">
    		<button id="loadList" onclick="loadListView('${pageContext.request.contextPath}/reqLoadListClient')">Carregar lista</button>
    		<button id="loadList" onclick="loadListView('${pageContext.request.contextPath}/reqEditLine')">Editar linha</button>
    		<button id="loadList" onclick="loadListView('${pageContext.request.contextPath}/reqDeleteLine')">Deletar linha</button>
    		<iframe class="table-view-container" id="table-view-container">
	    		
			</iframe>
    	</div>
    </section>
</main>
</body>
</html>
