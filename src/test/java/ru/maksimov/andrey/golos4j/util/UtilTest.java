package ru.maksimov.andrey.golos4j.util;

import java.io.IOException;
import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.api.method.BaseMethod;
import ru.maksimov.andrey.golos4j.exception.SystemException;

/**
 * Вспомогаткельный класс для тестов
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class UtilTest {

	private static int connectTimeout = 3000;
	private static int connectionRequestTimeout = 600000;
	private static int socketTimeout = 30000;

	public static <T> T executePost(BaseMethod method, Class<T> classDto) throws SystemException {
		SSLContext sslContext = Util.getSSLContext();
		sslContext = null;
		RequestConfig config = Util.getConfig(connectTimeout, connectionRequestTimeout, socketTimeout);
		CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(sslContext)
				.setDefaultRequestConfig(config).build();
		HttpPost httpPost = new HttpPost("http://prerelease.golos.io");
		httpPost.setEntity(method.getEntity());
		try {
			HttpResponse response = httpClient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			System.out.println(entity.getContent());
			if (entity != null) {
				System.out.println("Response content length: " + entity.getContentLength());
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = EntityUtils.toString(entity);
			System.out.println("Response content: " + jsonString);
			T getDto = mapper.readValue(jsonString, classDto);
			return getDto;
		} catch (ClientProtocolException cpe) {
			throw new SystemException("Unable execute send POST-request: " + cpe.getMessage(), cpe);
		} catch (IOException ioe) {
			throw new SystemException("Unable execute POST-request: " + ioe.getMessage(), ioe);
		}
	}

}
