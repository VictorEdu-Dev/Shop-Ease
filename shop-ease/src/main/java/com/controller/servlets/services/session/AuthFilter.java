package com.controller.servlets.services.session;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(filterName = "AuthFilter", urlPatterns = {
		"/content/pages/register-product/register-products.jsp",
		"/content/pages/register-user-client/register-user-client.jsp",
		"/content/pages/web-chat-shop/web-chat-shop.jsp",
		"/content/handler",
		"/content/handler-no-dispatcher",
		"/content/pages/login-page-admin/system-admin/system-admin-profile/admin-profile.jsp"
		})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
    	HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        
        System.out.println("Testou solic");

        HttpSession session = request.getSession(false);
        
        String loginURI = request.getContextPath() + "/content/pages/login-page-admin/login.jsp";

        boolean loggedIn = session != null && session.getAttribute("username") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        
        allowContent(req, res, chain, request);
        
        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }

	private void allowContent(ServletRequest req, ServletResponse res, FilterChain chain, HttpServletRequest request)
			throws IOException, ServletException {
		String path = request.getRequestURI().substring(request.getContextPath().length());
        if (path.endsWith(".css") || path.endsWith(".svg") || path.endsWith(".jpg")) {
            chain.doFilter(req, res);
            return;
        }
	}

    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void destroy() {

    }
}
