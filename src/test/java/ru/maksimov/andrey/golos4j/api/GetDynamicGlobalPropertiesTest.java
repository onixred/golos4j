package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.socket.ServiceWebSocket;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties} и
 * dto {@link ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetDynamicGlobalPropertiesTest {

	private static String WSS_URL_NODE = "wss://ws.golos.io";

	@Before
	public void initialize() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void testId() throws SystemException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = ServiceWebSocket
				.executePost(getDynamicGlobalProperties, GetDynamicGlobalPropertiesDto.class, WSS_URL_NODE);
		assertEquals(getDynamicGlobalPropertiesDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = ServiceWebSocket
				.executePost(getDynamicGlobalProperties, GetDynamicGlobalPropertiesDto.class, WSS_URL_NODE);
		assertNotNull(getDynamicGlobalPropertiesDto);
	}

	@Test
	public void testNotNullResults() throws SystemException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = ServiceWebSocket
				.executePost(getDynamicGlobalProperties, GetDynamicGlobalPropertiesDto.class, WSS_URL_NODE);
		assertNotNull(getDynamicGlobalPropertiesDto.getResults());
	}
}
