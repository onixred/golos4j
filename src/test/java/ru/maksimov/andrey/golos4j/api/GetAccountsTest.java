package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccounts;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountsDto;
import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.socket.ServiceWebSocket;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetAccounts} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountsDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountsTest {

	private static String WSS_URL_NODE = "wss://ws.golos.io";

	private final static String ACCOUNT = "onixred";

	@Before
	public void initialize() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void testId() throws SystemException, BusinessException {
		int id = 2;
		GetAccounts getAccounts = new GetAccounts(id, Collections.singletonList(ACCOUNT));
		GetAccountsDto getAccountsDto = ServiceWebSocket.executePost(getAccounts, GetAccountsDto.class, WSS_URL_NODE);
		assertEquals(getAccountsDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException, BusinessException {
		int id = 2;
		GetAccounts getAccounts = new GetAccounts(id, Collections.singletonList(ACCOUNT));
		GetAccountsDto getAccountsDto = ServiceWebSocket.executePost(getAccounts, GetAccountsDto.class, WSS_URL_NODE);
		assertNotNull(getAccountsDto);
	}

	@Test
	public void testPositiveNnumber() throws SystemException, BusinessException {
		int id = 2;
		GetAccounts getAccounts = new GetAccounts(id, Collections.singletonList(ACCOUNT));
		GetAccountsDto getAccountsDto = ServiceWebSocket.executePost(getAccounts, GetAccountsDto.class, WSS_URL_NODE);
		assertTrue(getAccountsDto.getResults().size() == 1);
	}
}
