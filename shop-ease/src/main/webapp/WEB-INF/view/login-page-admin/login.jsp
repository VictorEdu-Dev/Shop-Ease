<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/content/assets/css/login-page-admin/style.css" type="text/css">
</head>
<body>
	<jsp:include page="/WEB-INF/view/header-footer/header.jsp"></jsp:include>
	<main class="body-form-main">
		<section class="body-form-section">
			<div class="form-wrapper">
				<h2>Entrar</h2>
				<form action="<%= request.getContextPath()%>/takeLogin" method="POST">
					<div class="form-control">
						<label>Nome de usuário</label> 
						<input type="text" name="username" id="username" required>
					</div>
					<div class="form-control">
						<label>Senha</label> 
						<input type="password" name="password" id="password" required>
					</div>
					<button type="submit">Entrar</button>
					<div class="form-help">
						<input type="checkbox" name="remember-me" id="remember-me"> <label for="remember-me">Lembrar-se de mim</label>
						<a href="#">Precisa de ajuda?</a>
					</div>
				</form>
				<p>
					É novo aqui? <a href="#">Cadastre-se agora</a>
				</p>
				<small> Esta página está protegida por Google reCAPTCHA para assegurar
					que você não é um robô. <a href="#">Saiba mais.</a>
				</small>
			</div>
		</section>
	</main>
	<jsp:include page="/WEB-INF/view/header-footer/footer.jsp"></jsp:include>
</body>
</html>
