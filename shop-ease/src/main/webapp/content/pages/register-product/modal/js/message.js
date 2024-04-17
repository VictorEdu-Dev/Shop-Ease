var message = document.getElementById("myMessage");

    // Função para abrir o message
    function openMessage() {
        message.style.display = "block";
    }

    // Função para fechar o message
    function closeMessage() {
        message.style.display = "none";
    }

    // Fechar o message se o usuário clicar fora dele
    window.onclick = function(event) {
        if (event.target == message) {
            message.style.display = "none";
        }
    }
    
 document.getElementById('submitButton').addEventListener('click', function() {
    openMessage();
});