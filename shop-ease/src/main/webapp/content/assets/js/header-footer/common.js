/**
 * 
 */
function toggleSidebar() {
    var sidebar = document.getElementById('sidebar');
    if (sidebar.classList.contains('open')) {
        sidebar.classList.remove('open');
    } else {
        sidebar.classList.add('open');
    }
}

// Fecha a barra lateral se o usuário clicar fora dela
window.addEventListener('click', function(event) {
    var sidebar = document.getElementById('sidebar');
    var button = document.getElementById('open-sidebar-button');
    if (event.target !== sidebar && event.target !== button && !sidebar.contains(event.target)) {
        sidebar.classList.remove('open');
    }
});
