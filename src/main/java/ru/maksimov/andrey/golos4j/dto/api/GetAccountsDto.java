package ru.maksimov.andrey.golos4j.dto.api;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.AccountDto;
import ru.maksimov.andrey.golos4j.dto.BaseDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.GetAccounts}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountsDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private List<AccountDto> result;

	private String jsonrpc;
	
	public String getJsonrpc() {
		return jsonrpc;
	}

	@JsonProperty("jsonrpc")
	public void setJsonrpc(String jsonrpc) {
		this.jsonrpc = jsonrpc;
	}

	public List<AccountDto> getResults() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(List<AccountDto> result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
