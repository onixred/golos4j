package ru.maksimov.andrey.golos4j.dto.param;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.MapInteger2StringInversionDeserializer;

/**
 * Базовое dto для ключя
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseKeyDto {

	private int weightThreshold;
	private List<String> accountAuths;
	private Map<Integer, String> keyAuths;

	public int getWeightThreshold() {
		return weightThreshold;
	}

	public List<String> getAccountAuths() {
		return accountAuths;
	}

	public Map<Integer, String> getKeyAuths() {
		return keyAuths;
	}

	@JsonProperty("weight_threshold")
	public void setWeightThreshold(int weightThreshold) {
		this.weightThreshold = weightThreshold;
	}

	@JsonProperty("account_auths")
	public void setAccountAuths(List<String> accountAuths) {
		this.accountAuths = accountAuths;
	}

	@JsonProperty("key_auths")
	@JsonDeserialize(using = MapInteger2StringInversionDeserializer.class)
	public void setKeyAuths(Map<Integer, String> keyAuths) {
		this.keyAuths = keyAuths;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
