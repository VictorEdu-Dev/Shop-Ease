<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <link href="<c:url value='/content/assets/css/web-chat-team/web-chat-team.css' />" rel="stylesheet" type="text/css" />
    <script src="<c:url value='/content/assets/js/web-chat-team/web-chat-team.js' />"></script>
</head>
<body>
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
</body>
</html>
