<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.shopease.controller.system.users.client.UserClientParameter"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="<c:url value='/content/assets/css/register-user-client/register-user-client-styles.css' />" type="text/css">
<link rel="stylesheet" href="<c:url value='/content/assets/css/register-user-client/modal/message.css' />" type="text/css">
</head>
<body>
<main class="main-register-user-client">
    <section class="container-user-client">
        <div class="inner-container-user-client">
            <h2 class="title-user-client">Cadastrar cliente</h2>
			<!-- Servlet de destino -->
            <form action="/shop-ease/handler-no-dispatcher" method="POST" class="form">
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
                    <label for="home_number">Nº</label>
                    <input type="text" id="home-number" name="<%= UserClientParameter.HOMENUMBER.getContent()%>" required>
                </div>
                <div class="form-group">
                    <label for="bairro">Bairro</label>
                    <input type="text" id="bairro" name="bairro" required>
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
                    <label for="phone_number">Telefone</label>
                    <input type="text" id="phone-number" name="<%= UserClientParameter.PHONENUMBER.getContent()%>" required>
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
</main>
</body>
</html>
