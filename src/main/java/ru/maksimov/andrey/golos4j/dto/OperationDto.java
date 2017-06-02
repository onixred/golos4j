package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.maksimov.andrey.golos4j.deserializes.MapString2StringDeserializer;

/**
 * DTO for Operation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
@JsonDeserialize(using = MapString2StringDeserializer.class)
public class OperationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> key2value;

	public Map<String, String> getKey2value() {
		return key2value;
	}

	public void setKey2value(Map<String, String> key2value) {
		this.key2value = key2value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
