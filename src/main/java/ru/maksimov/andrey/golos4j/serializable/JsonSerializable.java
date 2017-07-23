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
	 * @throws JsonProcessingException
	 */
	String toJsonString() throws JsonProcessingException;
}
