package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.param.Asset;
import ru.maksimov.andrey.golos4j.dto.param.Asset.AssetSymbolType;
import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for operation transfer
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class TransferDto extends BaseOperation {

	private static final long serialVersionUID = -1377035920994354306L;

	private static final OperationType type = OperationType.TRANSFER_OPERATION;

	@JsonProperty("amount")
	private Asset amount;
	@JsonProperty("memo")
	private String memo;
	@JsonProperty("from")
	private String from;
	@JsonProperty("to")
	private String to;

	public TransferDto() {
		super(type);
	}

	public String getAmount() {
		return amount.toString();
	}

	public float getAmountValue() {
		return amount.toReal();
	}

	public AssetSymbolType getAmountСurrency() {
		return amount.getSymbol();
	}

	public String getMemo() {
		return memo;
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

	public void setAmount(String amount) throws BusinessException {
		this.amount = new Asset(amount);
	}

	public void setAmount(long amount, AssetSymbolType symbol) {
		this.amount = new Asset(amount, symbol);
	}

	public void setAmount(double amount, AssetSymbolType symbol) {
		this.amount = new Asset(amount, symbol);
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public static OperationType getOperationType() {
		return type;
	}

	@Override
	public List<Byte> toBytes() {
		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> fromBytes = Util.string2ByteList(from);
		List<Byte> toBytes = Util.string2ByteList(to);
		List<Byte> amountBytes = amount.toByteList();
		List<Byte> memoBytes = Util.string2ByteList(memo);
		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(fromBytes);
		list.addAll(toBytes);
		list.addAll(amountBytes);
		list.addAll(memoBytes);
		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
