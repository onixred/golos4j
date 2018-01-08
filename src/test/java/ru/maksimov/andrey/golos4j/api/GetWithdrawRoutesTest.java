package ru.maksimov.andrey.golos4j.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import ru.maksimov.andrey.golos4j.api.method.GetWithdrawRoutes;
import ru.maksimov.andrey.golos4j.dto.api.GetWithdrawRoutesDto;
import ru.maksimov.andrey.golos4j.dto.param.WithdrawRouteType;
import ru.maksimov.andrey.golos4j.exception.SystemException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Класс для тестов метода
 * {@link ru.maksimov.andrey.golos4j.api.method.GetWithdrawRoutes} и dto
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetWithdrawRoutesDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetWithdrawRoutesTest {

	@Before
	public void initialize() throws InterruptedException {
		Thread.sleep(2000);
	}

	@Test
	public void testId() throws SystemException, InterruptedException {
		int id = 2;
		GetWithdrawRoutes getWithdrawRoutes = new GetWithdrawRoutes(id, "onixred", WithdrawRouteType.all);
		GetWithdrawRoutesDto getWithdrawRoutesDto = Util.executePost(getWithdrawRoutes, GetWithdrawRoutesDto.class,
				"https://ws.golos.io");
		assertEquals(getWithdrawRoutesDto.getId(), id);
	}

	@Test
	public void testNotNull() throws SystemException, InterruptedException {
		int id = 2;
		GetWithdrawRoutes getWithdrawRoutes = new GetWithdrawRoutes(id, "onixred", WithdrawRouteType.incoming);
		GetWithdrawRoutesDto getWithdrawRoutesDto = Util.executePost(getWithdrawRoutes, GetWithdrawRoutesDto.class,
				"https://ws.golos.io");
		assertNotNull(getWithdrawRoutesDto);
	}

	@Test
	public void testNotNullResults() throws SystemException, InterruptedException {
		int id = 2;
			GetWithdrawRoutes getWithdrawRoutes = new GetWithdrawRoutes(id, "onixred", WithdrawRouteType.outgoing);
		GetWithdrawRoutesDto getWithdrawRoutesDto = Util.executePost(getWithdrawRoutes, GetWithdrawRoutesDto.class,
				"https://ws.golos.io");
		assertNotNull(getWithdrawRoutesDto.getResults());
	}
}
