package com.controller.servlets;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import com.controller.servlets.services.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/handler")
public class GeneralServlet extends HttpServlet {
	public static final String prefixClass = "com.controller.servlets.services.";
	public static final String param = "param";

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String className = prefixClass + request.getParameter(param);
		
		try {
			Class<?> c = Class.forName(className); // Obtém uma representação da classe no caminho especificado

			Service svc = (Service) c.getDeclaredConstructor().newInstance(); // Obtém uma instância da classe anterior numa interface

			String page = svc.execute(request, response); // Executa e processa a requisião e retorna uma String
			request.getRequestDispatcher(page).forward(request, response); // Dispacha a requisição para página descrita pela String retornada
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
				IllegalArgumentException | InvocationTargetException | NoSuchMethodException |
				SecurityException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
