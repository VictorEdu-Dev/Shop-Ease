function loadPage(page) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("generic-content").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", page, true);
    xhttp.send();
}

function loadListView(page) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("table-view-container").innerHTML = this.responseText;
        }
    };
    xhttp.open("GET", page, true);
    xhttp.send();
}

function loadList() {
    $.ajax({
        type: "GET",
        url: "/shop-ease/reqLoadListClient",
    });
}

var socket = new WebSocket("ws://localhost:8080/shop-ease/chat");
var chatArea = document.getElementById("chatArea");
var usernameInput = document.getElementById("username");
var messageInput = document.getElementById("message");
var chatLog = document.getElementById("chat-log");

socket.onopen = function(event) {
    console.log("Conexão WebSocket estabelecida.");
};

socket.onmessage = function(event) {
    var messageContainer = document.getElementById("messageContainer");
    if (!messageContainer) {
        console.error("Elemento HTML 'messageArea' não encontrado.");
        return;
    }

    try {
        var data = event.data.trim();
        if (data.startsWith("null: ")) {
            data = data.substring(6);
        }
        var message = JSON.parse(data);
        var messageText = message.sender + ": " + message.text + "\n";
        messageContainer.value += messageText;
    } catch (error) {
        console.error("Erro ao analisar a mensagem JSON:", error);
        console.log("Conteúdo da mensagem:", event.data);
    }
};



socket.onclose = function(event) {
    console.log("Conexão WebSocket fechada.");
};

function sendMessage() {
    var usernameInput = document.getElementById("username");
    var messageInput = document.getElementById("message");

    if (!usernameInput || !messageInput) {
        console.error("Elementos HTML não encontrados.");
        return;
    }

    var username = usernameInput.value.trim();
    var messageText = messageInput.value.trim();

    if (!username || !messageText) {
        console.error("O nome de usuário e a mensagem não podem estar vazios.");
        return;
    }

    var message = {
        sender: username,
        text: messageText
    };

    try {
        socket.send(JSON.stringify(message));
        messageInput.value = '';
    } catch (error) {
        console.error("Erro ao enviar a mensagem:", error);
    }
}


