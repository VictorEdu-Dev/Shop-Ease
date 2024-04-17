package com.controller.servlets;

import java.io.IOException;

import javax.websocket.server.ServerContainer;

import com.controller.websocket.ChatEndpoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/chat/*")
public class ChatServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServerContainer container = (ServerContainer) getServletContext().getAttribute(ServerContainer.class.getName());
        try {
            container.addEndpoint(ChatEndpoint.class);
        } catch (Exception e) {
            throw new ServletException("Failed to add endpoint", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Chat Servlet");
    }
}

