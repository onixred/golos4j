package ru.maksimov.andrey.golos4j.serializable;

import java.io.Serializable;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * interface for JSON serializable
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public interface JsonSerializable extends Serializable {

	/**
	 * Get JSON string
	 * 
	 * @return json string
	 * @throws JsonProcessingException
	 *             исключение преобразования
	 */
	String toJsonString() throws JsonProcessingException;
}
