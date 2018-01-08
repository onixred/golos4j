package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetContent;
import ru.maksimov.andrey.golos4j.dto.api.GetContentDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetContent} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetContentDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetContentTest {

	private String ACCOUNT ="onixred";
	private String PERMLINK = "ne-mogu-perevesti-v-silu-golosa-v-chem-problema";
	@Test
	public void testId() throws SystemException {
		int id = 2;
		GetContent getContent = new GetContent(id, ACCOUNT, PERMLINK);
		GetContentDto getContentDto = Util.executePost(getContent, GetContentDto.class, "https://ws.golos.io");
		assertEquals(getContentDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetContent getContent = new GetContent(id, ACCOUNT, PERMLINK);
		GetContentDto getContentDto = Util.executePost(getContent, GetContentDto.class, "https://ws.golos.io");
		assertNotNull(getContentDto);
	}

	@Test
	public void testNotNullResults() throws SystemException {
		int id = 2;
		GetContent getContent = new GetContent(id, ACCOUNT, PERMLINK);
		GetContentDto getContentDto = Util.executePost(getContent, GetContentDto.class, "https://ws.golos.io");
		assertNotNull(getContentDto.getResults());
	}
}
