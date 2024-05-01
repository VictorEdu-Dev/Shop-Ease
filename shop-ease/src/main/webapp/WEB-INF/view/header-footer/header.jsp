<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ShopEase</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/content/assets/css/header-footer/header.css' />">
    <script src="<c:url value='/content/assets/js/header-footer/common.js' />"></script>
</head>
<body>
	<header id="header-main" class="header-main">
		<nav id="nav-header" class="nav-header">
	    	<div id="header-container" class="header-container">
	            <h1 class="title">ShopEase</h1>
	            <ul class="navbar-burger">
	            	<li><a href="<c:url value='forward:/content/index.jsp' />">Home</a></li>
	                <li><a href="sobre.jsp">Sobre</a></li>
	                <li><a href="contato.jsp">Contato</a></li>
	                <li><button onclick="window.location.href='<%= request.getContextPath()%>/systemAdmin';" id="open-profile-admin-button" class="open-profile-admin-button">
	    				<img src="<c:url value='/content/assets/images/profile/icons8-male-user-24.png' />" alt="profile-icon">
					</button></li>
	                <li><button onclick="toggleSidebar()" id="open-sidebar-button" class="open-sidebar-button">
	    				<img src="<c:url value='/content/assets/images/icons8-menu-alt.svg' />" alt="menu-icon">
					</button></li>
	        	</ul>
	    	</div>
	 	</nav>	
	 </header>
<div class="sidebar-container">
	    <div class="sidebar-content">
	        <div class="sidebar" id="sidebar">
	            <span class="sidebar-close" onclick="toggleSidebar()">x</span>
	            <h2>Menu</h2>
	            <ul>
	            	<li><a href="<c:url value='/systemAdmin' />">ShopAdmin</a></li>
	                <li><a href="<c:url value='/authLogin' />">Login Admin</a></li>
	                <li><a href="<c:url value='/content/pages/web-chat-shop/web-chat-shop.jsp' />">Chat</a></li>
	            </ul>
	        </div>
	    </div>
    </div>
</body>
</html>
