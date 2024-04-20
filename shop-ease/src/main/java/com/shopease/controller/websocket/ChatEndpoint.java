package com.controller.websocket;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.OnMessage;
import javax.websocket.RemoteEndpoint.Basic;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/chat")
public class ChatEndpoint extends Endpoint {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @Override
	public void onOpen(Session session, EndpointConfig endpointConfig) {
		Basic remoteEndpointBasic = session.getBasicRemote();
		session.addMessageHandler(new EchoMessageHandler(remoteEndpointBasic));
		
	}
    
    private static class EchoMessageHandler implements MessageHandler.Whole<String> {
    	private final Basic remoteEndpointBasic;
    	
    	private EchoMessageHandler(Basic remoteEndpointBasic) {
    		this.remoteEndpointBasic = remoteEndpointBasic;
    	}

		@Override
		public void onMessage(String arg0) {
			try {
				if(remoteEndpointBasic != null) {
					remoteEndpointBasic.sendText(arg0);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (Session s : sessions) {
            if (s.isOpen()) {
                try {
                    s.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
