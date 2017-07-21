package ru.maksimov.andrey.golos4j.util;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

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
	public static int long2Last2Byte(long value) {
		int last2Byte = ((int) value) & 0xFFFF;
		return last2Byte;
	}

	/**
	 * Конвертировать hex строку в число с перестановкой(реверс) байт
	 * 
	 * @param hexString
	 *            hex строка
	 * @param offset
	 *            отступ в байтах
	 * @return положительное число
	 */
	public static long hexString2Long(String hexString, int offset) {
		int beginIndex = Character.BYTES * offset;
		int endIndex = beginIndex + Long.BYTES;
		String subString = hexString.substring(beginIndex, endIndex);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < Long.BYTES; i = i + Character.BYTES) {
			builder.append(subString.substring(Long.BYTES - Character.BYTES - i, Long.BYTES - i));
		}
		long hexLong = Long.parseLong(builder.toString(), 16);
		return hexLong;
	}

	/**
	 * Конвертировать числа в список байт с перестановкой(реверс байт) 
	 * 
	 * @param number
	 *            число
	 * @param length
	 *            количество байт в списке
	 * @return положительное число
	 */
	public static List<Byte> int2ByteList(int number, int length) {
		List<Byte> byteList = new ArrayList<Byte>();
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		byteBuffer.putInt(number);
		byte[] byteArray = byteBuffer.array();
		length = length > byteArray.length?byteArray.length:length;
		for (int index = 0; index < length; index++) {
			byteList.add(byteArray[byteArray.length - index -1]);
		}
		return byteList;
	}
}
