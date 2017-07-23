package ru.maksimov.andrey.golos4j.api;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccountCount;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.UtilTest;
import static org.junit.Assert.*;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetAccountCount} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto}
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCountTest {

	@Test
	public void testId() throws SystemException   {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = UtilTest.executePost(getAccountCount, GetAccountCountDto.class);
		assertEquals(getAccountCountDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = UtilTest.executePost(getAccountCount, GetAccountCountDto.class);
		assertNotNull(getAccountCountDto);
	}

	@Test
	public void testPositiveNnumber() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = UtilTest.executePost(getAccountCount, GetAccountCountDto.class);
		assertTrue(getAccountCountDto.getResult() >= 0);
	}
}
