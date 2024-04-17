var message = document.getElementById("message-content");

    function openMessage() {
        message.style.display = "block";
    }

    function closeMessage() {
        message.style.display = "none";
    }

    window.onclick = function(event) {
        if (event.target == message) {
            message.style.display = "none";
        }
    }
    
 document.getElementById('submitButton').addEventListener('click', function() {
    openMessage();
});