package ru.maksimov.andrey.golos4j.util;

import java.nio.ByteBuffer;

/**
 * Вспомогаткельный класс для транзакций 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class TransactionUtil {

	/**
	 * Получить число типа char из двух последних байт long'a.
	 * 
	 * @param value
	 *            число типа long
	 * @return число типа char
	 */
	public static char getLastByte2Char(long value) {
		ByteBuffer bufferLong = ByteBuffer.allocate(Long.BYTES);
		bufferLong.putLong(value);
		ByteBuffer bufferChar = ByteBuffer.allocate(Character.BYTES);
		bufferChar.put(bufferLong.array(), Long.BYTES - Character.BYTES, Character.BYTES);
		bufferChar.flip();//need flip 
		return bufferChar.getChar();
	}

	public static long bytesToLong(byte[] bytes) {
		ByteBuffer buffer = ByteBuffer.allocate(Long.BYTES);
		buffer.put(bytes);
		buffer.flip();// need flip
		return buffer.getLong();
	}
}
