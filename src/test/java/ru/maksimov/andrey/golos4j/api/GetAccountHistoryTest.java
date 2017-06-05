package ru.maksimov.andrey.golos4j.api;

/**
 * Класс для тестов метода {@link ru.maksimov.andrey.golos4j.api.method.GetAccountHistory}  и dto {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto}
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccountHistory;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto;
import ru.maksimov.andrey.golos4j.util.UtilTest;

public class GetAccountHistoryTest {
	@Test
	public void testId() throws ClientProtocolException, IOException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = UtilTest.executePost(getAccountHistory, GetAccountHistoryDto.class);
		assertEquals(getAccountHistoryDto.getId(), id);
	}

	@Test
	public void testNotNull() throws ClientProtocolException, IOException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = UtilTest.executePost(getAccountHistory, GetAccountHistoryDto.class);
		assertNotNull(getAccountHistoryDto);
	}

	@Test
	public void testNotNullResults() throws ClientProtocolException, IOException {
		int id = 2;
		int limit = 2;
		GetAccountHistory getAccountHistory = new GetAccountHistory(id, "onixred", 1590, limit);
		GetAccountHistoryDto getAccountHistoryDto = UtilTest.executePost(getAccountHistory, GetAccountHistoryDto.class);
		assertNotNull(getAccountHistoryDto.getResults());
	}
}
