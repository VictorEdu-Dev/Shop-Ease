<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Perfil do Administrador</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/content/assets/css/login-page-admin/system-admin-profile/admin-profile.css' />">
    <script type="text/javascript" src="<c:url value='/content/assets/js/login-page-admin/system-admin/system-admin-contents.js' />"></script>
</head>
<body>
<jsp:include page="/WEB-INF/view/header-footer/header.jsp"></jsp:include>
<main id="profile-container" class="profile-container">
	<section class="sidebar-list-option">
    	<div class="list-option-container">
	    	<nav class="nav-list-option">
	    		<ul class="list-option">
		    		<li><a href="#">Perfil</a></li>
		    		<li><a href="#" onclick="loadPage('${pageContext.request.contextPath}/reqClientRegisterArea')">Clientes</a></li>
		    		<li><a href="#" onclick="loadPage('${pageContext.request.contextPath}/reqProductRegisterArea')">Estoque</a></li>
		    		<li><a href="#">Vendas</a></li>
		    		<li><a href="#">Chat online</a></li>
		    		<li><a href="#">Configurações</a></li>
	    		</ul>
	    	</nav>
    	</div>
    </section>
    <section id="system-content" class="system-content">
        <div id="generic-content" class="generic-content">
	        
        </div>
    </section>
</main>
<jsp:include page="/WEB-INF/view/header-footer/footer.jsp"></jsp:include>
</body>
</html>
