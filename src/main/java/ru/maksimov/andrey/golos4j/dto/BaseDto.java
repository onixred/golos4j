package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Base class for DTO
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public abstract class BaseDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private ErrorDto error;

	/**
	 * Get id
	 * 
	 * @return id
	 */
	@JsonProperty("id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@JsonProperty("error")
	public ErrorDto getError() {
		return error;
	}

	public void setError(ErrorDto error) {
		this.error = error;
	}

}
