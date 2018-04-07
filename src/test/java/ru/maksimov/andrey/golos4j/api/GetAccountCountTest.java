package ru.maksimov.andrey.golos4j.api;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetAccountCount;
import ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.socket.ServiceWebSocket;

import static org.junit.Assert.*;

import org.junit.Before;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetAccountCount} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountCountDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCountTest {

	private static String WSS_URL_NODE = "wss://ws.golos.io";

	@Before
	public void initialize() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void testId() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = ServiceWebSocket.executePost(getAccountCount, GetAccountCountDto.class,
				WSS_URL_NODE);
		assertEquals(getAccountCountDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = ServiceWebSocket.executePost(getAccountCount, GetAccountCountDto.class,
				WSS_URL_NODE);
		assertNotNull(getAccountCountDto);
	}

	@Test
	public void testPositiveNnumber() throws SystemException {
		int id = 2;
		GetAccountCount getAccountCount = new GetAccountCount(id);
		GetAccountCountDto getAccountCountDto = ServiceWebSocket.executePost(getAccountCount, GetAccountCountDto.class,
				WSS_URL_NODE);
		assertTrue(getAccountCountDto.getResult() >= 0);
	}
}
