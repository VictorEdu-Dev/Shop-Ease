<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfil do Administrador</title>
</head>
<body>
<jsp:include page="../../../header-footer/header.jsp"></jsp:include>
<div id="profile-container" class="profile-container">
    <!-- Perfil do administrador -->
    <section id="profile" class="profile-section">
        <div id="element-profile" class="element-profile">
	        <h1>Conta</h1>
	        <img src="caminho/para/foto-de-perfil.jpg" alt="Foto de Perfil" width="150" height="150">
	        <label>ID</label>
	        <p>123456789</p>
	        <label>Nome:</label>
	        <p>Administrador</p>
	        <label>Email:</label>
	        <p>admin@example.com</p>
	        <label>Último login:</label>
	        <p>2024-04-16 10:00:00</p>
	        <button>Editar Perfil</button>
        </div>
    </section>
</div>
<jsp:include page="../../../header-footer/footer.jsp"></jsp:include>
</body>
</html>
