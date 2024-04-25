var socket = new WebSocket("ws://localhost:8080/chat");
var chatLog = document.getElementById("chat-log");

socket.onopen = function(event) {
    console.log("Conexão WebSocket estabelecida.");
};

socket.onmessage = function(event) {
    var message = JSON.parse(event.data);
    var chatMessage = document.createElement("div");
    chatMessage.textContent = message.sender + ": " + message.text;
    chatLog.appendChild(chatMessage);
};

socket.onclose = function(event) {
    console.log("Conexão WebSocket fechada.");
};

function sendMessage() {
    var username = document.getElementById("username").value;
    var messageText = document.getElementById("message").value;
    var message = {
        sender: username,
        text: messageText
    };
    socket.send(JSON.stringify(message));
}
