package ru.maksimov.andrey.golos4j.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitcoinj.core.VarInt;

import ru.maksimov.andrey.golos4j.exception.BusinessException;

/**
 * Вспомогаткельный класс для транзакций
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class TransactionUtil {

	private static final Logger LOG = LogManager
			.getLogger(TransactionUtil.class);

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
			builder.append(subString.substring(Long.BYTES - Character.BYTES - i,
					Long.BYTES - i));
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
	 * @return число в виде списка байт
	 */
	public static List<Byte> int2ByteList(int number, int length) {
		List<Byte> byteList = new ArrayList<Byte>();
		ByteBuffer byteBuffer = ByteBuffer.allocate(4);
		byteBuffer.putInt(number);
		byte[] byteArray = byteBuffer.array();
		length = length > byteArray.length ? byteArray.length : length;
		for (int index = 0; index < length; index++) {
			byteList.add(byteArray[byteArray.length - index - 1]);
		}
		return byteList;
	}

	/**
	 * Конвертировать long value в массив байт.
	 * 
	 * @param longValue
	 *            число.
	 * @return число в виде списка байт.
	 * @throws BusinessException
	 *             бизнес иключение
	 */
	public static byte[] long2VarIntByteArray(long longValue)
			throws BusinessException {
		try {
			long value = longValue;
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			DataOutput out = new DataOutputStream(byteArrayOutputStream);
			while ((value & 0xFFFFFFFFFFFFFF80L) != 0L) {
				out.writeByte(((int) value & 0x7F) | 0x80);
				value >>>= 7;
			}
			out.writeByte((int) value & 0x7F);
			return byteArrayOutputStream.toByteArray();
		} catch (IOException e) {
			LOG.warn(
					"Unable transform long value to VarInt . This could cause problems for values > 127."
							+ e);
			return (new VarInt(longValue)).encode();
		}
	}
}
