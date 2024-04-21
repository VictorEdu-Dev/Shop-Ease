<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page import="com.shopease.controller.servlets.GeneralServlet"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/content/assets/css/register-product/register-product-style.css" type="text/css">
	<link rel="stylesheet" href="<%= request.getContextPath()%>/content/assets/css/register-product/modal/css/message.css" type="text/css">
	<title>Cadastro de produtos</title>
</head>
<body>
    <main class="main-product-register">
    	<section class="body-product-register">
	        <div class="inner-container-product-register">
	            <h2 class="title-register-product">Cadastrar produto</h2>
	            <form action="/shop-ease/handler-no-dispatcher" method="POST" class="form">
	                <input type="hidden" id="siteId" name="param" value="product.RegisterProduct">
	                <div class="form-group">
	                    <label for="name">Nome</label>
	                    <input type="text" id="name" name="name" required>
	                </div>
	                <div class="form-group">
	                    <label for="category">Categoria</label>
	                    <input type="text" id="category" name="category" required>
	                </div>
	                <div class="form-group">
	                    <label for="brand">Marca</label>
	                    <input type="text" id="brand" name="brand" required>
	                </div>
	                <div class="form-group">
	                    <label for="date-manufacturing">Data de fabricação</label>
	                    <input type="text" placeholder="dd/mm/yyyy" id="date-manufacturing" name="date-manufacturing" pattern="^\d{2}/\d{2}/\d{4}$" required>
	                </div>
	                <div class="form-group">
	                    <label for="date-expiration">Data de validade</label>
	                    <input type="text" placeholder="dd/mm/yyyy" id="date-expiration" name="date-expiration" pattern="^\d{2}/\d{2}/\d{4}$" required>
	                </div>
	                <div class="form-group">
	                    <label for="price">Preço</label>
	                    <input type="number" id="price" name="price">
	                </div>
	                <div class="form-group">
	                    <label for="description">Descrição do produto:</label>
	                    <textarea id="description" name="description" rows="4" cols="50"></textarea>
	                </div>
	                <div class="form-group">
	                    <input type="submit" id="submitButton" value="Enviar">
	                </div>
	                <div id="myMessage" class="message">
	                    <div class="message-content">
	                        <span class="close" onclick="closeMessage()">&times;</span>
	                        <h2>Mensagem</h2>
	                        <p>Cadastro realizado!</p>
	                        <script src="modal/js/message.js"></script>
	                    </div>
	                </div>
	            </form>
	        </div>
        </section>
    </main>
</body>
</html>
