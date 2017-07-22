package ru.maksimov.andrey.golos4j.dto.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.BaseDto;
import ru.maksimov.andrey.golos4j.dto.ConfigDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.GetConfig}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetConfigDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private ConfigDto result;

	public ConfigDto getResults() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(ConfigDto result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
