package ru.maksimov.andrey.golos4j.dto.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.BaseDto;
import ru.maksimov.andrey.golos4j.dto.DynamicGlobalPropertiesDto;

/**
 * DTO for GetDynamicGlobalPropertiesDto
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetDynamicGlobalPropertiesDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private DynamicGlobalPropertiesDto result;

	public DynamicGlobalPropertiesDto getResults() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(DynamicGlobalPropertiesDto result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}