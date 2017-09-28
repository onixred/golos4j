package ru.maksimov.andrey.golos4j.dto.api;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.MapInteger2AccountHistoryDeserializer;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.BaseDto;

/**
 * DTO for method
 * {@link ru.maksimov.andrey.golos4j.api.method.GetWithdrawRoutes}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetWithdrawRoutesDto extends BaseDto {

	private static final long serialVersionUID = -4647573142541692885L;

	private Map<Integer, AccountHistoryDto> result;

	public Map<Integer, AccountHistoryDto> getResults() {
		return result;
	}

	@JsonProperty("result")
	@JsonDeserialize(using = MapInteger2AccountHistoryDeserializer.class)
	public void setResult(Map<Integer, AccountHistoryDto> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
