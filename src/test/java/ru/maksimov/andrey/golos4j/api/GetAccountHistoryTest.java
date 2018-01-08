package ru.maksimov.andrey.golos4j.api;

/**
 * Класс для тестов метода {@link ru.maksimov.andrey.golos4j.api.method.GetAccountHistory}  и dto 
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto}
 *
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;

public class GetAccountHistoryTest {

	@Before
	public void initialize() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void testId() throws SystemException {
		int id = 2;
		int limit = 100;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 43848, limit);
		GetAccountHistoryDto getAccountHistoryDto = Util.executePost(getAccountHistory, GetAccountHistoryDto.class,
				"https://ws.golos.io");
		assertEquals(getAccountHistoryDto.getId(), id);
		System.out.println(getAccountHistoryDto.getResults());
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = Util.executePost(getAccountHistory, GetAccountHistoryDto.class,
				"https://ws.golos.io");
		assertNotNull(getAccountHistoryDto);
	}

	@Test
	public void testNotNullResults() throws SystemException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = Util.executePost(getAccountHistory, GetAccountHistoryDto.class,
				"https://ws.golos.io");
		assertNotNull(getAccountHistoryDto.getResults());
	}

	@Test
	public void testLastElement() throws SystemException {
		int id = 2;
		int limit = 0;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", -1, limit);
		GetAccountHistoryDto getAccountHistoryDto = Util.executePost(getAccountHistory, GetAccountHistoryDto.class,
				"https://ws.golos.io");
		assertNotNull(getAccountHistoryDto.getResults());
	}
}
