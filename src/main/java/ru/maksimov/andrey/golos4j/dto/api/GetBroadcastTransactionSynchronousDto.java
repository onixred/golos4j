package ru.maksimov.andrey.golos4j.dto.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.BaseDto;
import ru.maksimov.andrey.golos4j.dto.BroadcastTransactionSynchronousDto;

/**
 * DTO for method
 * {@link ru.maksimov.andrey.golos4j.api.method.BroadcastTransactionSynchronous}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetBroadcastTransactionSynchronousDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private BroadcastTransactionSynchronousDto result;

	private String jsonrpc;

	public String getJsonrpc() {
		return jsonrpc;
	}

	@JsonProperty("jsonrpc")
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public BroadcastTransactionSynchronousDto getResults() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(BroadcastTransactionSynchronousDto result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
