package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.MapString2OperationDeserializer;
import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;

/**
 * Structure from the result map where value
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountHistoryDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AccountHistoryDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String trxId;
	private int block;
	private int trxInBlock;
	private int opInTrx;
	private int virtualOp;
	private Date timestamp;
	private Map<String, BaseOperation> operations;

	@JsonProperty("trx_id")
	public String getTrxId() {
		return trxId;
	}

	public void setTrxId(String trxId) {
		this.trxId = trxId;
	}

	@JsonProperty("block")
	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	@JsonProperty("trx_in_block")
	public int getTrxInBlock() {
		return trxInBlock;
	}

	public void setTrxInBlock(int trxInBlock) {
		this.trxInBlock = trxInBlock;
	}

	@JsonProperty("op_in_trx")
	public int getOpInTrx() {
		return opInTrx;
	}

	public void setOpInTrx(int opInTrx) {
		this.opInTrx = opInTrx;
	}

	@JsonProperty("virtual_op")
	public int getVirtualOp() {
		return virtualOp;
	}

	public void setVirtualOp(int virtualOp) {
		this.virtualOp = virtualOp;
	}

	@JsonProperty("timestamp") 
	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public  Map<String, BaseOperation> getOperations() {
		return operations;
	}

	@JsonProperty("op")
	@JsonDeserialize(using = MapString2OperationDeserializer.class)
	public void setOperations(Map<String, BaseOperation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
