package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.Object2StringDeserializer;

/**
 * Base error class for DTO
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ErrorDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int code;

	private String message;

	private String data;

	@JsonProperty("code")
	public int getCode() {
		return code;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("data")
	@JsonDeserialize(using = Object2StringDeserializer.class)
	public String getData() {
		return data;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
