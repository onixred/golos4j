package ru.maksimov.andrey.golos4j.dto.operation.extension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.param.BeneficiaryRouteTypeDto;

/**
 * This class represents a "comment_payout_beneficiaries" object Extension for
 * {@link ru.maksimov.andrey.golos4j.dto.operation.extension.CommentOptionsExtension}
 * 
 * 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class CommentPayoutBeneficiaries extends CommentOptionsExtension {

	private static final CommentOptionsExtensionsType TYPE = CommentOptionsExtensionsType.COMMENT_PAYOUT_BENEFICIARIES;

	public CommentPayoutBeneficiaries() {
		super(TYPE);
	}

	@JsonProperty("beneficiaries")
	private List<BeneficiaryRouteTypeDto> beneficiaries = Collections.<BeneficiaryRouteTypeDto> emptyList();

	public List<BeneficiaryRouteTypeDto> getBeneficiaries() {
		return beneficiaries;
	}

	public void setBeneficiaries(List<BeneficiaryRouteTypeDto> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}

	@Override
	public List<Byte> toBytes() {
		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> beneficiariesBytes = new ArrayList<Byte>();
		beneficiariesBytes.add((byte) beneficiaries.size());
		for (BeneficiaryRouteTypeDto beneficiary : beneficiaries) {
			beneficiariesBytes.addAll(beneficiary.toBytes());
		}
		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(beneficiariesBytes);

		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
