package ru.maksimov.andrey.golos4j.dto;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Structure from the result
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetDynamicGlobalPropertiesDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class DynamicGlobalPropertiesDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private long headBlockNumber;

	private String headBlockId;

	private Date time;

	private String currentWitness;

	private long totalPow;

	private int numPowWitnesses;

	private String virtualSupply;

	private String currentSupply;

	private String confidentialSupply;

	private String currentSbdSupply;

	private String confidentialSbdSupply;

	private String totalVestingFundSteem;

	private String totalVestingShares;

	private String totalRewardFundSteem;

	private String totalRewardShares2;

	private int sbdInterestRate;

	private int sbdPrintRate;

	private int averageBlockSize;

	private int maximumBlockSize;

	private long currentAslot;

	private String recentSlotsFilled;

	private int participationCount;

	private long lastIrreversibleBlockNum;

	private String maxVirtualBandwidth;

	private int currentReserveRatio;

	private int voteRegenerationPerDay;

	@JsonProperty("head_block_number")
	public long getHeadBlockNumber() {
		return headBlockNumber;
	}

	public void setHeadBlockNumber(long headBlockNumber) {
		this.headBlockNumber = headBlockNumber;
	}

	@JsonProperty("head_block_id")
	public String getHeadBlockId() {
		return headBlockId;
	}

	public void setHeadBlockId(String headBlockId) {
		this.headBlockId = headBlockId;
	}

	@JsonProperty("time") // 2017-06-26T12:36:12
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@JsonProperty("current_witness")
	public String getCurrentWitness() {
		return currentWitness;
	}

	public void setCurrentWitness(String currentWitness) {
		this.currentWitness = currentWitness;
	}

	@JsonProperty("total_pow")
	public long getTotalPow() {
		return totalPow;
	}

	public void setTotalPow(long totalPow) {
		this.totalPow = totalPow;
	}

	@JsonProperty("num_pow_witnesses")
	public int getNumPowWitnesses() {
		return numPowWitnesses;
	}

	public void setNumPowWitnesses(int numPowWitnesses) {
		this.numPowWitnesses = numPowWitnesses;
	}

	@JsonProperty("virtual_supply")
	public String getVirtualSupply() {
		return virtualSupply;
	}

	public void setVirtualSupply(String virtualSupply) {
		this.virtualSupply = virtualSupply;
	}

	@JsonProperty("current_supply")
	public String getCurrentSupply() {
		return currentSupply;
	}

	public void setCurrentSupply(String currentSupply) {
		this.currentSupply = currentSupply;
	}

	@JsonProperty("confidential_supply")
	public String getConfidentialSupply() {
		return confidentialSupply;
	}

	public void setConfidentialSupply(String confidentialSupply) {
		this.confidentialSupply = confidentialSupply;
	}

	@JsonProperty("current_sbd_supply")
	public String getCurrentSbdSupply() {
		return currentSbdSupply;
	}

	public void setCurrentSbdSupply(String currentSbdSupply) {
		this.currentSbdSupply = currentSbdSupply;
	}

	@JsonProperty("confidential_sbd_supply")
	public String getConfidentialSbdSupply() {
		return confidentialSbdSupply;
	}

	public void setConfidentialSbdSupply(String confidentialSbdSupply) {
		this.confidentialSbdSupply = confidentialSbdSupply;
	}

	@JsonProperty("total_vesting_fund_steem")
	public String getTotalVestingFundSteem() {
		return totalVestingFundSteem;
	}

	public void setTotalVestingFundSteem(String totalVestingFundSteem) {
		this.totalVestingFundSteem = totalVestingFundSteem;
	}

	@JsonProperty("total_vesting_shares")
	public String getTotalVestingShares() {
		return totalVestingShares;
	}

	public void setTotalVestingShares(String totalVestingShares) {
		this.totalVestingShares = totalVestingShares;
	}

	@JsonProperty("total_reward_fund_steem")
	public String getTotalRewardFundSteem() {
		return totalRewardFundSteem;
	}

	public void setTotalRewardFundSteem(String totalRewardFundSteem) {
		this.totalRewardFundSteem = totalRewardFundSteem;
	}

	@JsonProperty("total_reward_shares2")
	public String getTotalRewardShares2() {
		return totalRewardShares2;
	}

	public void setTotalRewardShares2(String totalRewardShares2) {
		this.totalRewardShares2 = totalRewardShares2;
	}

	@JsonProperty("sbd_interest_rate")
	public int getSbdInterestRate() {
		return sbdInterestRate;
	}

	public void setSbdInterestRate(int sbdInterestRate) {
		this.sbdInterestRate = sbdInterestRate;
	}

	@JsonProperty("sbd_print_rate")
	public int getSbdPrintRate() {
		return sbdPrintRate;
	}

	public void setSbdPrintRate(int sbdPrintRate) {
		this.sbdPrintRate = sbdPrintRate;
	}

	@JsonProperty("average_block_size")
	public int getAverageBlockSize() {
		return averageBlockSize;
	}

	public void setAverageBlockSize(int averageBlockSize) {
		this.averageBlockSize = averageBlockSize;
	}

	@JsonProperty("maximum_block_size")
	public int getMaximumBlockSize() {
		return maximumBlockSize;
	}

	public void setMaximumBlockSize(int maximumBlockSize) {
		this.maximumBlockSize = maximumBlockSize;
	}

	@JsonProperty("current_aslot")
	public long getCurrentAslot() {
		return currentAslot;
	}

	public void setCurrentAslot(long currentAslot) {
		this.currentAslot = currentAslot;
	}

	@JsonProperty("recent_slots_filled")
	public String getRecentSlotsFilled() {
		return recentSlotsFilled;
	}

	public void setRecentSlotsFilled(String recentSlotsFilled) {
		this.recentSlotsFilled = recentSlotsFilled;
	}

	@JsonProperty("participation_count")
	public int getParticipationCount() {
		return participationCount;
	}

	public void setParticipationCount(int participationCount) {
		this.participationCount = participationCount;
	}

	@JsonProperty("last_irreversible_block_num")
	public long getLastIrreversibleBlockNum() {
		return lastIrreversibleBlockNum;
	}

	public void setLastIrreversibleBlockNum(long lastIrreversibleBlockNum) {
		this.lastIrreversibleBlockNum = lastIrreversibleBlockNum;
	}

	@JsonProperty("max_virtual_bandwidth")
	public String getMaxVirtualBandwidth() {
		return maxVirtualBandwidth;
	}

	public void setMaxVirtualBandwidth(String maxVirtualBandwidth) {
		this.maxVirtualBandwidth = maxVirtualBandwidth;
	}

	@JsonProperty("current_reserve_ratio")
	public int getCurrentReserveRatio() {
		return currentReserveRatio;
	}

	public void setCurrentReserveRatio(int currentReserveRatio) {
		this.currentReserveRatio = currentReserveRatio;
	}

	@JsonProperty("vote_regeneration_per_day")
	public int getVoteRegenerationPerDay() {
		return voteRegenerationPerDay;
	}

	public void setVoteRegenerationPerDay(int voteRegenerationPerDay) {
		this.voteRegenerationPerDay = voteRegenerationPerDay;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
