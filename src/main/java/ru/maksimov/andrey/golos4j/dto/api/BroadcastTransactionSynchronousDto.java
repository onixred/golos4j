package ru.maksimov.andrey.golos4j.dto.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.BaseDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.BroadcastTransactionSynchronous}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BroadcastTransactionSynchronousDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private long blockNum;
	private long trxNum;
	private boolean expired;

	@JsonProperty("block_num")
	public long getBlockNum() {
		return blockNum;
	}

	public void setBlockNum(long blockNum) {
		this.blockNum = blockNum;
	}

	@JsonProperty("block_num")
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

}
