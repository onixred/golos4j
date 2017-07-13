package ru.maksimov.andrey.golos4j.util;

/**
 * Вспомогаткельный класс для транзакций
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class TransactionUtil {

	/**
	 * Получить число из двух последних байт long'a.
	 * 
	 * @param value
	 *            число типа long
	 * @return число типа char
	 */
	public static int getLast2Byte(long value) {
		int last2Byte = ((int) value) & 0xFFFF;
		return last2Byte;
	}

	/**
	 * Получить число из hex строки с unsigned преобразованием
	 * 
	 * @param hexString
	 *            hex строка
	 * @param value
	 *            отступ в байтах
	 * @param value
	 *            количество байт числа
	 * @return положительное число
	 */
	public static long getLastByte2Char(String hexString, int offset, int length) {
		int beginIndex = Character.BYTES * offset;
		int endIndex = beginIndex + Character.BYTES * length;
		String hashData = hexString.substring(beginIndex, endIndex);
		StringBuilder builder = new StringBuilder();
		int lengthInBytes = Character.BYTES * length;
		for (int i = 0; i < lengthInBytes; i = i + Character.BYTES) {
			builder.append(hashData.substring(lengthInBytes - Character.BYTES - i, lengthInBytes - i));
		}
		long hex2long = Long.parseLong(builder.toString(), 16);
		return hex2long;
	}
}
