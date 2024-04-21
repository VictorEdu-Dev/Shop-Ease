var socket = new WebSocket("ws://localhost:8080/shop-ease/content/chat");

        socket.onmessage = function(event) {
            var message = event.data;
            document.getElementById("chatArea").innerHTML += "<p>" + message + "</p>";
        };

        function sendMessage() {
            var message = document.getElementById("message").value;
            socket.send(message);
            document.getElementById("message").value = "";
        }