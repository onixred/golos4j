package ru.maksimov.andrey.golos4j.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.http.client.config.RequestConfig;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * Вспомогаткельный класс
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Util {

	/**
	 * Получить конфигурацию запроса
	 * 
	 * @param timeout
	 *            таймаут в мсек
	 * @return конфигурация запроса
	 */
	public static RequestConfig getConfig(int connectTimeout, int connectionRequestTimeout, int socketTimeout) {
		return RequestConfig.custom().setConnectTimeout(connectTimeout)
				.setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build();
	}

	/**
	 * Десериализатор из Gson двумеррного массива в Map где четный элемент ключ
	 * а не четный значение
	 * 
	 * @param parser
	 *            Gson строка
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @throws IOException
	 * @return карта
	 */
	public static <T, V> Map<T, V> gsonArrArr2Map(JsonParser parser, Class<T> keyClass, Class<V> valueClass)
			throws IOException {
		Map<T, V> ret = new HashMap<T, V>();
		ObjectCodec codec = parser.getCodec();
		TreeNode node = codec.readTree(parser);
		if (node.isArray()) {
			for (JsonNode n : (ArrayNode) node) {
				Map<T, V> map = string2Map(n, keyClass, valueClass);
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
	 * @param parser
	 *            Gson строка
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @throws IOException
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
	 * Десериализатор Gson Map в Map<String, String>
	 * значение
	 * 
	 * @param parser
	 *            Gson строка
	 * @throws IOException
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
	 * @param parser
	 *            Gson строка
	 * @param keyClass
	 *            класс для ключа карты
	 * @param valueClass
	 *            класс для значения карты
	 * @throws IOException
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

}
