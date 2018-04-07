package ru.maksimov.andrey.golos4j.socket;

import java.io.IOException;
import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.exception.SystemException;

/**
 * Веб сокети клиент
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class WebSocketClass<T> extends WebSocketClient {

	private static final Logger LOG = LogManager.getLogger(WebSocketClass.class);

	private String mesasge;
	private Class<T> classDto;
	private T response = null;
	private SystemException systemException = null;

	public WebSocketClass(URI serverUri) {
		super(serverUri);
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		LOG.debug("close ws uri:" + uri + " with exit code " + code + " additional info: " + reason);
	}

	@Override
	public void onError(Exception ex) {
		LOG.error("Error occured on ws uri:" + uri + ":" + ex);
	}

	@Override
	public void onMessage(String message) {
		String debugMessage = "";
		if(message != null) {
			debugMessage = message.length() > 51?message.substring(0, 50): message; 
		} 
		LOG.debug("message ws uri:" + uri + " message: " + debugMessage);
		ObjectMapper mapper = new ObjectMapper();
		try {
			response = mapper.readValue(message, classDto);
		} catch (IOException ioe) {
			systemException = new SystemException("Unable execute POST-request: " + ioe.getMessage(), ioe);
		} finally {
			close();
		}
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		send(mesasge);
	}

	public String getMesasge() {
		return mesasge;
	}

	public void setMesasge(String mesasge) {
		this.mesasge = mesasge;
	}

	public T getResponse() {
		return response;
	}

	public SystemException getSystemException() {
		return systemException;
	}

	public void setClassDto(Class<T> classDto) {
		this.classDto = classDto;
	}

}
