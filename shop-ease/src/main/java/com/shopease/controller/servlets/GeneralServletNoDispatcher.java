package com.shopease.controller.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.shopease.controller.servlets.services.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/handler-no-dispatcher")
public class GeneralServletNoDispatcher extends HttpServlet {
	public static final String prefixClass = "com.controller.servlets.services.";
	public static final String param = "param";

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String className = prefixClass + request.getParameter(param);
		
		try {
			Class<?> c = Class.forName(className); // Obtém uma representação da classe no caminho especificado

			Service svc = (Service) c.getDeclaredConstructor().newInstance(); // Obtém uma instância da classe anterior numa interface
			svc.execute(request, response); // Executa e processa a requisião e retorna uma String
			
			response.setStatus(HttpServletResponse.SC_NO_CONTENT); // Dispacha a requisição para nenhuma página
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException | NoSuchMethodException |
				SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
