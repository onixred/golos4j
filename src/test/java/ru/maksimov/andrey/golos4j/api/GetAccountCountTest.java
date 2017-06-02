package ru.maksimov.andrey.golos4j.api;

import java.io.IOException;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.HeaderGroup;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.api.method.GetAccountCount;
import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.util.Util;

public class GetAccountCountTest {

	private static int connectTimeout = 3000;
	private static int connectionRequestTimeout = 60000;
	private static int socketTimeout = 30000;

	public static void main(final String args[]) throws Throwable {
		//getAccountCount();
		getAccountHistory();
	}

	public static void getAccountCount() throws ClientProtocolException, IOException {
		GetAccountCount getAccountCount = new GetAccountCount(2);
		RequestConfig config = Util.getConfig(connectTimeout, connectionRequestTimeout, socketTimeout);
		CloseableHttpClient httpclient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost httpClient = new HttpPost("http://node.golos.ws:80");
		httpClient.setEntity(getAccountCount.getEntity());
		HttpResponse response = httpclient.execute(httpClient);
		HttpEntity entity = response.getEntity();
		System.out.println(entity.getContent());
		if (entity != null) {
			System.out.println("Response content length: " + entity.getContentLength());
		}
		ObjectMapper mapper = new ObjectMapper();
		GetAccountCountDto getAccountCountDto = mapper.readValue(EntityUtils.toString(entity), GetAccountCountDto.class);
		System.out.println(getAccountCountDto);
	}

	public static void getAccountHistory() throws ClientProtocolException, IOException {
		GetAccountHistory getAccountHistory = new GetAccountHistory(3, "onixred", 1590, 3);
		RequestConfig config = Util.getConfig(connectTimeout, connectionRequestTimeout, socketTimeout);
		CloseableHttpClient httpСlient = HttpClientBuilder.create().setDefaultRequestConfig(config).build();
		HttpPost httpPost = new HttpPost("http://node.golos.ws:80");

		httpPost.setEntity(getAccountHistory.getEntity());
		HttpResponse response = httpСlient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		System.out.println(entity.getContent());
		if (entity != null) {
			System.out.println("Response content length: " + entity.getContentLength());
		}
		ObjectMapper mapper = new ObjectMapper();
		String stringJson = EntityUtils.toString(entity, "UTF-8");
		System.out.println(stringJson);

		GetAccountHistoryDto getAccountHistoryDto = mapper.readValue(stringJson, GetAccountHistoryDto.class);
		System.out.println("getAccountHistoryDto: " );
		for(Entry<Integer,AccountHistoryDto> entry: getAccountHistoryDto.getResults().entrySet()) {
			System.out.print("key " + entry.getKey());
			System.out.println(" value " + entry.getValue());
		}

	}
}
