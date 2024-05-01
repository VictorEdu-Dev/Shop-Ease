<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="pt-br">
<head>
    <title>Chat</title>
    <link href="css/chat-web-shop.css" rel="stylesheet" type="text/css" />
    <script src="js/chat.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header-footer/header.jsp"/>
<div class="main-chat-page">
    <div class="main-chat">
        <div class="main-chat-open">
            <h2 class="title-chat">Chat</h2>
            <div class="chat-element">
				<textarea id="chatArea" cols="50" rows="10" readonly></textarea><br>
	    		<input type="text" id="message" class="message-content"/>
	    		<button onclick="sendMessage()" type="submit" class="message-submit">Enviar</button>
            </div>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/view/header-footer/footer.jsp"></jsp:include>
</body>
</html>
