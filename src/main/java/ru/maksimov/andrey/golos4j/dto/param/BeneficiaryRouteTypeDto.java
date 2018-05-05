package ru.maksimov.andrey.golos4j.dto.param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;
import ru.maksimov.andrey.golos4j.util.Util;

public class BeneficiaryRouteTypeDto implements Serializable, ByteSerializable {

	private static final long serialVersionUID = -1977173382377258164L;

	@JsonProperty("account")
	private String account;
	// Original type is uint16_t.
	@JsonProperty("weight")
	private short weight;

	public BeneficiaryRouteTypeDto() {
	}

	public BeneficiaryRouteTypeDto(String account, short weight) {
		this.account = account;
		this.weight = weight;
	}

	/**
	 * Get account name.
	 * 
	 * @return account name.
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * Get weight beneficiary.
	 * 
	 * @return weight beneficiary.
	 */
	public short getWeight() {
		return weight;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setWeight(short weight) {
		this.weight = weight;
	}

	@Override
	public List<Byte> toBytes() {
		List<Byte> authorBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> weightBytes = Collections.<Byte> singletonList((byte) 0);
		try {
			authorBytes = Util.stringUtf82ByteList(account);
			weightBytes = Util.short2ByteArray(weight);
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		List<Byte> list = new ArrayList<Byte>();
		list.addAll(authorBytes);
		list.addAll(weightBytes);
		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
