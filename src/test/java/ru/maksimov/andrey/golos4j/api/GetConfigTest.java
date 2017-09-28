package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetConfig;
import ru.maksimov.andrey.golos4j.dto.api.GetConfigDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetConfig} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetConfigDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetConfigTest {

	@Test
	public void testId() throws SystemException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = Util.executePost(getConfig, GetConfigDto.class, "https://ws.golos.io");
		assertEquals(getConfigDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = Util.executePost(getConfig, GetConfigDto.class, "https://ws.golos.io");
		assertNotNull(getConfigDto);
	}

	@Test
	public void testNotNullResults() throws SystemException {
		int id = 2;
		GetConfig getConfig = new GetConfig(id);
		GetConfigDto getConfigDto = Util.executePost(getConfig, GetConfigDto.class, "https://ws.golos.io");
		assertNotNull(getConfigDto.getResults());
	}
}
