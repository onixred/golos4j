package ru.maksimov.andrey.golos4j.util;

import java.io.ByteArrayOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bitcoinj.core.VarInt;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import ru.maksimov.andrey.golos4j.api.method.BaseMethod;
import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.exception.SystemException;

/**
 * Вспомогаткельный класс
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Util {

	private static final Logger LOG = LogManager.getLogger(Util.class);

	private static int connectTimeout = 3000;
	private static int connectionRequestTimeout = 600000;
	private static int socketTimeout = 30000;

	private static final char[] hexArray = "0123456789abcdef".toCharArray();

	public final static String APPLICATION_JSON_VALUE = "application/json";
	public final static String APPLICATION_JSON_UTF8_VALUE = APPLICATION_JSON_VALUE + ";charset=UTF-8";

	public final static Charset ENCODING_CHARSET = StandardCharsets.UTF_8;

	/**
	 * Получить конфигурацию запроса
	 * 
	 * @param connectTimeout
	 *            определяет тайм-аут в миллисекундах до тех пор, пока
	 *            соединение не будет установлено
	 * @param connectionRequestTimeout
	 *            определяет таймаут в миллисекундах, используемых при запросе
	 *            соединения из диспетчера подключений
	 * @param socketTimeout
	 *            определяет тайм-аут сокета в миллисекундах.
	 * @return конфигурация запроса
	 */
	public static RequestConfig getConfig(int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
		return RequestConfig.custom().setConnectTimeout(connectTimeout)
				.setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build();
	}

	/**
	 * Получить экземпляр протокол безопасного сокета
	 * 
	 * @return экземпляр протокола безопасного сокета
	 * @throws SystemException
	 *             системное исключение -
	 */
	public static SSLContext getSSLContext() throws SystemException {
		try {
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(new KeyManager[0], new TrustManager[] { new AllowingAllTrustManager() },
					new SecureRandom());
			SSLContext.setDefault(sslContext);
			return sslContext;
		} catch (NoSuchAlgorithmException nsae) {
			throw new SystemException(" Unable get instance TLS: " + nsae.getMessage() + nsae);
		} catch (KeyManagementException kme) {
			throw new SystemException(" Unable init SSL context: " + kme.getMessage() + kme);
		}
	}

	/**
	 * Десериализатор из Gson двумеррного массива в Map где четный элемент ключ
	 * а не четный значение
	 * 
	 * @param <T>
	 *            тип ключя карты
	 * @param <V>
	 *            тип значения карты
	 * @param parser
	 *            Gson строка
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @param isInversion
	 *            признак инверсии типов key и value 
	 * @throws IOException
	 *             исключение парсера
	 * @return карта
	 */
	public static <T, V> Map<T, V> gsonArrArr2Map(JsonParser parser, Class<T> keyClass, Class<V> valueClass, boolean isInversion)
			throws IOException {
		Map<T, V> ret = new HashMap<T, V>();
		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		if (node.isArray()) {
			for (JsonNode n : (ArrayNode) node) {
				Map<T, V> map;
				if(isInversion) {
					Map<V, T> inversionMap =  string2Map(n, valueClass, keyClass);
					map = new HashMap<T, V>();
					for( V value: inversionMap.keySet()) {
						T key = inversionMap.get(value);
						map.put(key, value);
					}
				} else {
					map =  string2Map(n, keyClass, valueClass);
				}
				
				if (map != null && !map.isEmpty()) {
					ret.putAll(map);
				}
			}
		}
		return ret;
	}

	/**
	 * Десериализатор из Gson массива в Map где четный элемент ключ а не четный
	 * значение
	 * 
	 * @param <T>
	 *            тип ключя карты
	 * @param <V>
	 *            тип значения карты
	 * @param parser
	 *            Gson строка
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @throws IOException
	 *             исключение не парса
	 * @return карта
	 */
	public static <T, V> Map<T, V> gsonArr2Map(JsonParser parser, Class<T> keyClass, Class<V> valueClass)
			throws IOException {
		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		Map<T, V> ret = string2Map(node, keyClass, valueClass);
		return ret;
	}

	/**
	 * Десериализатор Gson Map в Map&lt;String, String&gt; значение
	 * 
	 * @param parser
	 *            Gson строка
	 * @throws IOException
	 *             исключение парсера
	 * @return карта
	 */
	public static Map<String, String> gsonMap2Map(JsonParser parser) throws IOException {
		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		Map<String, String> ret = new HashMap<String, String>();
		if (node.isObject()) {
			for (Iterator<String> iter = node.fieldNames(); iter.hasNext();) {
				String fieldName = iter.next();
				TreeNode field = node.get(fieldName);
				if (field != null) {
					ret.put(fieldName, field.toString());
				} else {
					ret.put(fieldName, "null");
				}
			}
		}
		return ret;
	}

	/**
	 * Десериализатор TreeNode массива в Map где четный элемент ключ а не четный
	 * значение
	 * 
	 * @param <T>
	 *            тип ключя карты
	 * @param <V>
	 *            тип значения карты
	 * @param node
	 *            узел
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @throws IOException
	 *             исключение парсера
	 * @return карта
	 */
	private static <T, V> Map<T, V> string2Map(TreeNode node, Class<T> keyClass, Class<V> valueClass)
			throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Map<T, V> ret = new HashMap<T, V>();
		if (node.isArray()) {
			T key = null;
			ArrayNode key2value = (ArrayNode) node;
			for (int i = 0; i < key2value.size(); i++) {
				if (i % 2 == 0) {
					key = mapper.treeToValue(key2value.get(i), keyClass);
				} else {
					V value = mapper.treeToValue(key2value.get(i), valueClass);
					ret.put(key, value);
				}
			}
		}
		return ret;
	}

	/**
	 * Конвертировать TreeNode в строку
	 * 
	 * @param node
	 *            узел
	 * @throws IOException
	 *             исключение парсера
	 * @return строка
	 */
	public static String node2String(TreeNode node) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.treeToValue(node, String.class);
	}

	/**
	 * Десериализатор TreeNode массива в объект
	 * 
	 * @param <T>
	 *            тип объекта
	 * @param node
	 *            узел
	 * @param aClass
	 *            класс объекта
	 * @throws IOException
	 *             исключение парсера
	 * @return объект
	 */
	public static <T> T node2String2Object(TreeNode node, Class<T> aClass) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		String str = node2String(node);
		T obj = mapper.readValue(str, aClass);
		return obj;
	}

	/**
	 * Добавить/отнять от даты время
	 * 
	 * @param time
	 *            дата
	 * @param offsetSecond
	 *            смещение в секундах
	 * @return время со смещением
	 */
	public static Date addTime(Date time, int offsetSecond) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(time);
		calendar.add(Calendar.SECOND, offsetSecond);
		return calendar.getTime();
	}

	/**
	 * Конвертировать строку в список байт
	 * 
	 * @param value
	 *            строка
	 * @return список байт в формате: первый элемент длина строки, далее байты
	 *         строки. Если строка пуста то резултатом будет список с одним
	 *         элеметом размер строки равный 0
	 */
	public static List<Byte> string2ByteList(String value) {
		List<Byte> list;
		if (StringUtils.isBlank(value)) {
			list = Collections.singletonList((byte) 0);
		} else {
			list = new ArrayList<Byte>();
			list.add((byte) value.length());
			List<Byte> listBytes = arrayByte2List(value.getBytes());
			list.addAll(listBytes);
		}
		return list;
	}

	/**
	 * Transform a long value into its byte representation.
	 * 
	 * @param longValue
	 *            value The long value to transform.
	 * @return The byte representation of the given value.
	 */
	public static byte[] long2VarIntByteArray(long longValue) {
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
			LOG.error("Could not transform the given long value into its VarInt representation - "
					+ "Using BitcoinJ as Fallback. This could cause problems for values > 127.", e);
			return (new VarInt(longValue)).encode();
		}
	}

	/**
	 * Transform a long variable into a byte array.
	 * 
	 * @param longValue
	 *            The long value to transform.
	 * @return The byte representation of the long value.
	 */
	public static List<Byte> long2ByteArray(long longValue) {
		ByteBuffer array = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(longValue);
		List<Byte> list = arrayByte2List(array.array());
		return list;
	}

	/**
	 * Change the order of a byte to little endian.
	 * 
	 * @param byteValue
	 *            The byte to transform.
	 * @return The byte in its little endian representation.
	 */
	public static byte byte2LittleEndian(byte byteValue) {
		return ByteBuffer.allocate(1).order(ByteOrder.LITTLE_ENDIAN).put(byteValue).get(0);
	}

	/**
	 * Конвертировать utf-8 строку в список байт
	 * 
	 * @param value
	 *            строка
	 * @return список байт в формате: первый элемент длина строки, далее байты
	 *         строки. Если строка пуста то резултатом будет список с одним
	 *         элеметом размер строки равный 0
	 * @throws BusinessException
	 *             бизнес исключение
	 */
	public static List<Byte> stringUtf82ByteList(String value) throws BusinessException {
		byte[] bytes;
		try {
			ByteArrayOutputStream resultingByteRepresentation = new ByteArrayOutputStream();
			byte[] stringAsByteArray = value.getBytes(ENCODING_CHARSET);
			resultingByteRepresentation
					.write(TransactionUtil.long2VarIntByteArray(Integer.toUnsignedLong(stringAsByteArray.length)));
			resultingByteRepresentation.write(stringAsByteArray);

			bytes = resultingByteRepresentation.toByteArray();
		} catch (IOException e) {
			throw new BusinessException("A problem occured while transforming the string into a byte array.", e);
		}
		List<Byte> listBytes = arrayByte2List(bytes);
		return listBytes;
	}

	/**
	 * Конвертировать массива байт в список байт
	 * 
	 * @param bytes
	 *            массив байт
	 * @return список байт
	 */
	public static List<Byte> arrayByte2List(byte[] bytes) {
		List<Byte> listBytes = new ArrayList<Byte>();
		for (byte aByte : bytes) {
			listBytes.add(aByte);
		}
		return listBytes;
	}

	/**
	 * Конвертировать списка байт в массива байт
	 * 
	 * @param list
	 *            список байт
	 * @return массив байт
	 */
	public static byte[] listBytes2array(List<Byte> list) {
		byte[] bytes = new byte[list.size()];
		for (int index = 0; index < list.size(); index++) {
			bytes[index] = list.get(index);
		}
		return bytes;
	}

	/**
	 * Конвертировать списка байтов в hex-строку
	 * 
	 * @param bytes:
	 *            Список байт
	 * @return: строка с содержанием списка байт.
	 */
	public static String bytes2Hex(List<Byte> bytes) {
		char[] hexChars = new char[bytes.size() * Character.BYTES];
		for (int index = 0; index < bytes.size(); index++) {
			int v = bytes.get(index) & 0xFF;
			hexChars[index * 2] = hexArray[v >>> 4];
			hexChars[index * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	/**
	 * Конвертировать hex-строку string в массив байт.
	 * 
	 * @param hexString:
	 *            hex-строка.
	 * @return: массив байт.
	 */
	public static List<Byte> hexToBytes(String hexString) {
		List<Byte> list = new ArrayList<Byte>(hexString.length() / 2);
		for (int index = 0; index < hexString.length(); index += 2) {
			Byte aByte = (byte) ((Character.digit(hexString.charAt(index), 16) << 4)
					+ Character.digit(hexString.charAt(index + 1), 16));
			list.add(aByte);
		}
		return list;
	}

	/**
	 * Конвертировать заголовка в url строку
	 * 
	 * @param title:
	 *            заголовок
	 * @return: ссылка.
	 * @throws BusinessException
	 *             бизнес исключение
	 */
	private static String replace(String text) throws BusinessException {
		if (StringUtils.isBlank(text)) {
			throw new BusinessException("Unable conver title tp permlink");
		}
		String[] abcCyr = { "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р",
				"с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я", " ", ".", "!" };
		String[] abcLat = { "a", "b", "v", "g", "d", "e", "jo", "zh", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r",
				"s", "t", "u", "f", "h", "ts", "ch", "sh", "sch", "b", "", "", "e", "ju", "ja", "-", "-", "-" };
		return StringUtils.replaceEach(text.toLowerCase(), abcCyr, abcLat);
	}

	/**
	 * Конвертировать заголовка в url строку
	 * 
	 * @param title:
	 *            заголовок
	 * @return: ссылка.
	 * @throws BusinessException
	 *             бизнес исключение
	 */
	public static String title2Permlink(String title) throws BusinessException {
		String permlink = replace(title);
		permlink += formatDate(new Date(), "yyyy-MM-dd-HH-mm-ss-SS");
		permlink = permlink.replaceAll("[^a-z0-9\\-]", "");
		return permlink;
	}

	/**
	 * Конвертировать заголовка в url строку
	 * 
	 * @param text:
	 *            заголовок
	 * @return: ссылка.
	 * @throws BusinessException
	 *             бизнес исключение
	 */
	public static String text2Tag(String text) throws BusinessException {
		String tag = replace(text);
		tag = tag.replaceAll("[^a-z0-9]", "");
		return tag;
	}

	/**
	 * Преобразовать дату в строку
	 * 
	 * @param date
	 *            дата
	 * @param format
	 *            формат
	 * @return дата в заданном формате
	 */
	public static String formatDate(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * Выполнить Post запрос
	 * 
	 * @param <T>
	 *            класс ответа {@link ru.maksimov.andrey.golos4j.dto.api}
	 * 
	 * @param method
	 *            объект который нужно отпрапвить в запросе
	 * @param classDto
	 *            класс возврата
	 * @param url
	 *            url адрес
	 * @return дата в заданном формате
	 * @throws SystemException
	 *             система ошибка выполения запроса
	 */
	public static <T> T executePost(BaseMethod method, Class<T> classDto, String url) throws SystemException {
		SSLContext sslContext = Util.getSSLContext();
		RequestConfig config = Util.getConfig(connectTimeout, connectionRequestTimeout, socketTimeout);
		CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLContext(sslContext)
				.setDefaultRequestConfig(config).build();
		HttpPost httpPost = new HttpPost(url);
		//443 httpClient
		httpPost.setEntity(method.getEntity());
		httpPost.addHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE);
		try {
			HttpResponse response = httpClient.execute(httpPost);
			response.addHeader("Content-Type", APPLICATION_JSON_UTF8_VALUE);
			HttpEntity entity = response.getEntity();

			LOG.debug("Content: " + entity.getContent());
			if (entity != null) {
				LOG.debug("Response content length: " + entity.getContentLength());
			}
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = EntityUtils.toString(entity, ENCODING_CHARSET);
			LOG.debug("Response content: " + jsonString);
			T getDto = mapper.readValue(jsonString, classDto);
			return getDto;
		} catch (ClientProtocolException cpe) {
			throw new SystemException("Unable execute send POST-request: " + cpe.getMessage(), cpe);
		} catch (IOException ioe) {
			throw new SystemException("Unable execute POST-request: " + ioe.getMessage(), ioe);
		}
	}

}
