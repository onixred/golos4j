package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO for operation transfer
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class TransferDto extends BaseOperation {

	private static final long serialVersionUID = -1377035920994354306L;

	private static final OperationType type = OperationType.TRANSFER_OPERATION;

	private String amount;
	private String memo;
	private String from;
	private String to;

	public TransferDto() {
		super(type);
	}

	public String getAmount() {
		return amount;
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

	public void setAmount(String amount) {
		this.amount = amount;
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
		List<Byte> list = new ArrayList<Byte>();
		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
