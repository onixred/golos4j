package ru.maksimov.andrey.golos4j.api;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccountCount;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;
import static org.junit.Assert.*;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetAccountCount} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCountTest {

	@Test
	public void testId() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = Util.executePost(getAccountCount, GetAccountCountDto.class,
				"https://ws.golos.io");
		assertEquals(getAccountCountDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = Util.executePost(getAccountCount, GetAccountCountDto.class,
				"https://ws.golos.io");
		assertNotNull(getAccountCountDto);
	}

	@Test
	public void testPositiveNnumber() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = Util.executePost(getAccountCount, GetAccountCountDto.class,
				"https://ws.golos.io");
		assertTrue(getAccountCountDto.getResult() >= 0);
	}
}
