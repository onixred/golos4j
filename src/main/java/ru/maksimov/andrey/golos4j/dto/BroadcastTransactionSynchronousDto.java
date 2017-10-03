package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Structure from the result BroadcastTransactionSynchronous
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetBroadcastTransactionSynchronousDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BroadcastTransactionSynchronousDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private long blockNum;
	private long trxNum;
	private boolean expired;

	/**
	 * Get id
	 * 
	 * @return id 
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("block_num")
	public long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(long blockNum) {
		this.blockNum = blockNum;
	}

	@JsonProperty("trx_num")
	public long getTrxNum() {
		return trxNum;
	}

	public void setTrxNum(long trxNum) {
		this.trxNum = trxNum;
	}

	@JsonProperty("expired")
	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
