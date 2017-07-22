package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetConfig;
import ru.maksimov.andrey.golos4j.dto.api.GetConfigDto;
import ru.maksimov.andrey.golos4j.util.UtilTest;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetConfig} и
 * dto {@link ru.maksimov.andrey.golos4j.dto.api.GetConfigDto}
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetConfigTest {

	@Test
	public void testId() throws ClientProtocolException, IOException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = UtilTest.executePost(getConfig,
				GetConfigDto.class);
		assertEquals(getConfigDto.getId(), id);
	}

	@Test
	public void testNotNull() throws ClientProtocolException, IOException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = UtilTest.executePost(getConfig,
				GetConfigDto.class);
		assertNotNull(getConfigDto);
	}

	@Test
	public void testNotNullResults() throws ClientProtocolException, IOException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = UtilTest.executePost(getConfig,
				GetConfigDto.class);
		assertNotNull(getConfigDto.getResults());
	}
}
