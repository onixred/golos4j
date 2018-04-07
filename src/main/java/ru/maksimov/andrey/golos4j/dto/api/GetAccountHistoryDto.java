package ru.maksimov.andrey.golos4j.dto.api;

import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.MapLong2AccountHistoryDeserializer;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.dto.BaseDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.GetAccountHistory}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private Map<Long,AccountHistoryDto> result;

	private String jsonrpc;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	@JsonProperty("jsonrpc")
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}


	public Map<Long,AccountHistoryDto> getResults() {
		return result;
	}

	@JsonProperty("result")
	@JsonDeserialize(using = MapLong2AccountHistoryDeserializer.class)
	public void setResult(Map<Long,AccountHistoryDto> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
