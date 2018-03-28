package ru.maksimov.andrey.golos4j.util;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.exception.SystemException;

/**
 * Вспомогаткельный класс для тестов
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class UtilTest {
	
	@Test
	public void testPermlink() throws SystemException, BusinessException {
		String value = "0123456//6|||57\\|7890qwertyuiop[]asdfgh   jkl;zxcvbnm,.-    <>?m,./";
		String res = Util.title2Permlink(value);
	boolean isContain = res.contains("01234566577890qwertyuiopasdfgh---jklzxcvbnm------m-");
		assertTrue(isContain);
	}

	@Test
	public void testTag() throws SystemException, BusinessException {
		String value = "0123456//6|||57\\|7890qwertyuiop[]asdfgh   jkl;zxcvbnm,.-    <>?m,./";
		String res = Util.text2Tag(value);
		assertEquals(res, "01234566577890qwertyuiopasdfghjklzxcvbnmm");
	}
}
