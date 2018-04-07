package ru.maksimov.andrey.golos4j.socket;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import ru.maksimov.andrey.golos4j.api.method.BaseMethod;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Сервис для работы с веб сокетитом
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ServiceWebSocket {

	public static <T> T executePost(BaseMethod method, Class<T> classDto, String url) throws SystemException {
		SSLContext sslContext = Util.getSSLContext();
		try {
			URI uri = new URI(url);
			WebSocketClass<T> server = new WebSocketClass<T>(uri);
			server.setClassDto(classDto);
			server.setMesasge(method.getJson());
			SSLSocketFactory factory = sslContext.getSocketFactory();// (SSLSocketFactory)
																		// SSLSocketFactory.getDefault();
			server.setSocket(factory.createSocket());
			server.run();

			if (server.getSystemException() != null) {
				throw server.getSystemException();
			}
			return server.getResponse();
		} catch (URISyntaxException urise) {
			throw new SystemException("Unable execute POST-request: " + urise.getMessage(), urise);
		} catch (IOException ioe) {
			throw new SystemException("Unable execute POST-request: " + ioe.getMessage(), ioe);
		}

	}
}
