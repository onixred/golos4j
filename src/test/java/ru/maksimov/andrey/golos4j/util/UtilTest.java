package ru.maksimov.andrey.golos4j.util;

import java.io.IOException;

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

/**
 * Вспомогаткельный класс для тестов
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class UtilTest {

	private static int connectTimeout = 3000;
	private static int connectionRequestTimeout = 60000;
	private static int socketTimeout = 30000;

	public static <T> T executePost(BaseMethod method, Class<T> classDto) throws ClientProtocolException, IOException {
		RequestConfig config = Util.getConfig(connectTimeout, connectionRequestTimeout, socketTimeout);
		CloseableHttpClient httpСlient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost httpClient = new HttpPost("http://node.golos.ws:80");
		httpClient.setEntity(method.getEntity());
		HttpResponse response = httpСlient.execute(httpClient);
		HttpEntity entity = response.getEntity();
		System.out.println(entity.getContent());
		if (entity != null) {
			System.out.println("Response content length: " + entity.getContentLength());
		}
		ObjectMapper mapper = new ObjectMapper();
		T getDto = mapper.readValue(EntityUtils.toString(entity), classDto);
		return getDto;
	}
}
