package ru.maksimov.andrey.golos4j.dto.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import ru.maksimov.andrey.golos4j.dto.BaseDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.GetAccountCount}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCountDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private long result;

	/**
	 * Get account count
	 * 
	 * @return get account count
	 */
	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
