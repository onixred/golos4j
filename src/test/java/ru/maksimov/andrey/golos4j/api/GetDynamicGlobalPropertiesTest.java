package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties;
import ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto;
import ru.maksimov.andrey.golos4j.util.UtilTest;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetDynamicGlobalProperties} и
 * dto {@link ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto}
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetDynamicGlobalPropertiesTest {

	@Test
	public void testId() throws ClientProtocolException, IOException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		assertEquals(getDynamicGlobalPropertiesDto.getId(), id);
	}

	@Test
	public void testNotNull() throws ClientProtocolException, IOException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		assertNotNull(getDynamicGlobalPropertiesDto);
	}

	@Test
	public void testNotNullResults() throws ClientProtocolException, IOException {
		int id = 2;
		GetDynamicGlobalProperties getDynamicGlobalProperties = new GetDynamicGlobalProperties(id);
		GetDynamicGlobalPropertiesDto getDynamicGlobalPropertiesDto = UtilTest.executePost(getDynamicGlobalProperties,
				GetDynamicGlobalPropertiesDto.class);
		assertNotNull(getDynamicGlobalPropertiesDto.getResults());
	}
}
