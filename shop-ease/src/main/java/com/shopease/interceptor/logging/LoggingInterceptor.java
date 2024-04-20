package com.shopease.interceptor.logging;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Passou por logginginterceptor");
		
		String uri = request.getRequestURI();
        boolean isResourceRequest = uri.contains("content");
        boolean isLoginRequest = uri.endsWith("authLogin") || uri.endsWith("takeLogin");
        boolean isLoggedIn = request.getSession().getAttribute("loggedInUser") != null;

        // Permitir acesso aos recursos estáticos
        if (isResourceRequest) {
            return true;
        }

        // Permitir acesso às páginas de login e às páginas de login já autenticadas
        if (isLoginRequest || isLoggedIn) {
            return true;
        }

        // Redirecionar para a página de login para todas as outras solicitações
        response.sendRedirect("authLogin");
        return false;
	}
}
