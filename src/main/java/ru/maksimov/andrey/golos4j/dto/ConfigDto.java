package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Structure from the result
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetConfigDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ConfigDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean steemitBuildTestnet;

	private String grapheneCurrentDbVersion;

	private long sbdSymbol;

	private int steemitOneHundredPercent;

	private int steemitOnePercent;

	private String steemitAddressPrefix;

	private long steemitAprPercentMultiplyPerBlock;

	private long steemitAprPercentMultiplyPerHour;

	private long steemitAprPercentMultiplyPerRound;

	private int steemitAprPercentShiftPerBlock;

	private int steemitAprPercentShiftPerHour;

	private int steemitAprPercentShiftPerRound;

	private int steemitBandwidthAverageWindowSeconds;

	private int steemitBandwidthPrecision;

	private int steemitBlockchainPrecision;

	private int steemitBlockchainPrecisionDigits;

	private String steemitBlockchainHardforkVersion;

	private String steemitBlockchainVersion;

	private int steemitBlockInterval;

	private int steemitBlocksPerDay;

	private int steemitBlocksPerHour;

	private long steemitBlocksPerYear;

	private int steemitCashoutWindowSeconds;

	private String steemitChainId;

	private int steemitContentAprPercent;

	private long steemitConversionDelay;

	private int steemitCurateAprPercent;

	private int steemitDefaultSbdInterestRate;

	private int steemitFeedHistoryWindow;

	private int steemitFeedIntervalBlocks;

	private int steemitFreeTransactionsWithNewAccount;

	private Date steemitGenesisTime;

	private int steemitHardforkRequiredWitnesses;

	private String steemitInitMinerName;

	private String steemitInitPublicKeyStr;

	private String steemitInitSupply;

	private Date steemitInitTime;

	private int steemitIrreversibleThreshold;

	private int steemitLiquidityAprPercent;

	private int steemitLiquidityRewardBlocks;

	private int steemitLiquidityRewardPeriodSec;

	private String steemitLiquidityTimeoutSec;

	private int steemitMaxAccountNameLength;

	private int steemitMaxAccountWitnessVotes;

	private int steemitMaxAssetWhitelistAuthorities;

	private int steemitMaxAuthorityMembership;

	private long steemitMaxBlockSize;

	private int steemitMaxCashoutWindowSeconds;

	private int steemitMaxCommentDepth;

	private String steemitMaxFeedAge;

	private String steemitMaxInstanceId;

	private int steemitMaxMemoSize;

	private int steemitMaxWitnesses;

	private int steemitMaxMinerWitnesses;

	private int steemitMaxProxyRecursionDepth;

	private int steemitMaxRationDecayRate;

	private int steemitMaxReserveRatio;

	private int steemitMaxRunnerWitnesses;

	private String steemitMaxShareSupply;

	private int steemitMaxSigCheckDepth;

	private int steemitMaxTimeUntilExpiration;

	private int steemitMaxTransactionSize;

	private int steemitMaxUndoHistory;

	private int steemitMaxUrlLength;

	private int steemitMaxVoteChanges;

	private int steemitMaxVotedWitnesses;

	private int steemitMaxWithdrawRoutes;

	private int steemitMaxWitnessUrlLength;

	private int steemitMinAccountCreationFee;

	private int steemitMinAccountNameLength;

	private int steemitMinBlockSizeLimit;

	private String steemitMinContentReward;

	private String steemitMinCurateReward;

	private String steemitMinerAccount;

	private int steemitMinerPayPercent;

	private int steemitMinFeeds;

	private String steemitMiningReward;

	private Date steemitMiningTime;

	private String steemitMinLiquidityReward;

	private long steemitMinLiquidityRewardPeriodSec;

	private String steemitMinPayoutSbd;

	private String steemitMinPowReward;

	private String steemitMinProducerReward;

	private int steemitMinRation;

	private int steemitMinTransactionExpirationLimit;

	private int steemitMminTransactionSizeLimit;

	private int steemitMinUndoHistory;

	private String steemitNullAccount;

	private int steemitNumInitMiners;

	private int steemitPowAprPercent;

	private int steemitProducerAprPercent;

	private String steemitProxyToSelfAccount;

	private long steemitSbdInterestCompoundIntervalSec;

	private long steemitSecondsPerYear;

	private int steemitReverseAuctionWindowSeconds;

	private int steemitStartMinerVotingBlock;

	private int steemitStartVestingBlock;

	private String steemitSymbol;

	private String steemitTempAccount;

	private long steemitUpvoteLockout;

	private int steemitVestingWithdrawIntervals;

	private int steemitVestingWithdrawIntervalSeconds;

	private int steemitVoteChangeLockoutPeriod;

	private int steemitVoteRegenerationSeconds;

	private String steemSymbol;

	private String vestsSymbol;

	private String blockchainName;

	@JsonProperty("STEEMIT_BUILD_TESTNET")
	public boolean isSteemitBuildTestnet() {
		return steemitBuildTestnet;
	}

	public void setSteemitBuildTestnet(boolean steemitBuildTestnet) {
		this.steemitBuildTestnet = steemitBuildTestnet;
	}

	@JsonProperty("GRAPHENE_CURRENT_DB_VERSION")
	public String getGrapheneCurrentDbVersion() {
		return grapheneCurrentDbVersion;
	}

	public void setGrapheneCurrentDbVersion(String grapheneCurrentDbVersion) {
		this.grapheneCurrentDbVersion = grapheneCurrentDbVersion;
	}

	@JsonProperty("SBD_SYMBOL")
	public long getSbdSymbol() {
		return sbdSymbol;
	}

	public void setSbdSymbol(long sbdSymbol) {
		this.sbdSymbol = sbdSymbol;
	}

	@JsonProperty("STEEMIT_100_PERCENT")
	public int getSteemitOneHundredPercent() {
		return steemitOneHundredPercent;
	}

	public void setSteemitOneHundredPercent(int steemitOneHundredPercent) {
		this.steemitOneHundredPercent = steemitOneHundredPercent;
	}

	@JsonProperty("STEEMIT_1_PERCENT")
	public int getSteemitOnePercent() {
		return steemitOnePercent;
	}

	public void setSteemitOnePercent(int steemitOnePercent) {
		this.steemitOnePercent = steemitOnePercent;
	}

	@JsonProperty("STEEMIT_ADDRESS_PREFIX")
	public String getSteemitAddressPrefix() {
		return steemitAddressPrefix;
	}

	public void setSteemitAddressPrefix(String steemitAddressPrefix) {
		this.steemitAddressPrefix = steemitAddressPrefix;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_MULTIPLY_PER_BLOCK")
	public long getSteemitAprPercentMultiplyPerBlock() {
		return steemitAprPercentMultiplyPerBlock;
	}

	public void setSteemitAprPercentMultiplyPerBlock(long steemitAprPercentMultiplyPerBlock) {
		this.steemitAprPercentMultiplyPerBlock = steemitAprPercentMultiplyPerBlock;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_MULTIPLY_PER_HOUR")
	public long getSteemitAprPercentMultiplyPerHour() {
		return steemitAprPercentMultiplyPerHour;
	}

	public void setSteemitAprPercentMultiplyPerHour(long steemitAprPercentMultiplyPerHour) {
		this.steemitAprPercentMultiplyPerHour = steemitAprPercentMultiplyPerHour;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_MULTIPLY_PER_ROUND")
	public long getSteemitAprPercentMultiplyPerRound() {
		return steemitAprPercentMultiplyPerRound;
	}

	public void setSteemitAprPercentMultiplyPerRound(long steemitAprPercentMultiplyPerRound) {
		this.steemitAprPercentMultiplyPerRound = steemitAprPercentMultiplyPerRound;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_SHIFT_PER_BLOCK")
	public int getSteemitAprPercentShiftPerBlock() {
		return steemitAprPercentShiftPerBlock;
	}

	public void setSteemitAprPercentShiftPerBlock(int steemitAprPercentShiftPerBlock) {
		this.steemitAprPercentShiftPerBlock = steemitAprPercentShiftPerBlock;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_SHIFT_PER_HOUR")
	public int getSteemitAprPercentShiftPerHour() {
		return steemitAprPercentShiftPerHour;
	}

	public void setSteemitAprPercentShiftPerHour(int steemitAprPercentShiftPerHour) {
		this.steemitAprPercentShiftPerHour = steemitAprPercentShiftPerHour;
	}

	@JsonProperty("STEEMIT_APR_PERCENT_SHIFT_PER_ROUND")
	public int getSteemitAprPercentShiftPerRound() {
		return steemitAprPercentShiftPerRound;
	}

	public void setSteemitAprPercentShiftPerRound(int steemitAprPercentShiftPerRound) {
		this.steemitAprPercentShiftPerRound = steemitAprPercentShiftPerRound;
	}

	@JsonProperty("STEEMIT_BANDWIDTH_AVERAGE_WINDOW_SECONDS")
	public int getSteemitBandwidthAverageWindowSeconds() {
		return steemitBandwidthAverageWindowSeconds;
	}

	public void setSteemitBandwidthAverageWindowSeconds(int steemitBandwidthAverageWindowSeconds) {
		this.steemitBandwidthAverageWindowSeconds = steemitBandwidthAverageWindowSeconds;
	}

	@JsonProperty("STEEMIT_BANDWIDTH_PRECISION")
	public int getSteemitBandwidthPrecision() {
		return steemitBandwidthPrecision;
	}

	public void setSteemitBandwidthPrecision(int steemitBandwidthPrecision) {
		this.steemitBandwidthPrecision = steemitBandwidthPrecision;
	}

	@JsonProperty("STEEMIT_BLOCKCHAIN_PRECISION")
	public int getSteemitBlockchainPrecision() {
		return steemitBlockchainPrecision;
	}

	public void setSteemitBlockchainPrecision(int steemitBlockchainPrecision) {
		this.steemitBlockchainPrecision = steemitBlockchainPrecision;
	}

	@JsonProperty("STEEMIT_BLOCKCHAIN_PRECISION_DIGITS")
	public int getSteemitBlockchainPrecisionDigits() {
		return steemitBlockchainPrecisionDigits;
	}

	public void setSteemitBlockchainPrecisionDigits(int steemitBlockchainPrecisionDigits) {
		this.steemitBlockchainPrecisionDigits = steemitBlockchainPrecisionDigits;
	}

	@JsonProperty("STEEMIT_BLOCKCHAIN_HARDFORK_VERSION")
	public String getSteemitBlockchainHardforkVersion() {
		return steemitBlockchainHardforkVersion;
	}

	public void setSteemitBlockchainHardforkVersion(String steemitBlockchainHardforkVersion) {
		this.steemitBlockchainHardforkVersion = steemitBlockchainHardforkVersion;
	}

	@JsonProperty("STEEMIT_BLOCKCHAIN_VERSION")
	public String getSteemitBlockchainVersion() {
		return steemitBlockchainVersion;
	}

	public void setSteemitBlockchainVersion(String steemitBlockchainVersion) {
		this.steemitBlockchainVersion = steemitBlockchainVersion;
	}

	@JsonProperty("STEEMIT_BLOCK_INTERVAL")
	public int getSteemitBlockInterval() {
		return steemitBlockInterval;
	}

	public void setSteemitBlockInterval(int steemitBlockInterval) {
		this.steemitBlockInterval = steemitBlockInterval;
	}

	@JsonProperty("STEEMIT_BLOCKS_PER_DAY")
	public int getSteemitBlocksPerDay() {
		return steemitBlocksPerDay;
	}

	public void setSteemitBlocksPerDay(int steemitBlocksPerDay) {
		this.steemitBlocksPerDay = steemitBlocksPerDay;
	}

	@JsonProperty("STEEMIT_BLOCKS_PER_HOUR")
	public int getSteemitBlocksPerHour() {
		return steemitBlocksPerHour;
	}

	public void setSteemitBlocksPerHour(int steemitBlocksPerHour) {
		this.steemitBlocksPerHour = steemitBlocksPerHour;
	}

	@JsonProperty("STEEMIT_BLOCKS_PER_YEAR")
	public long getSteemitBlocksPerYear() {
		return steemitBlocksPerYear;
	}

	public void setSteemitBlocksPerYear(long steemitBlocksPerYear) {
		this.steemitBlocksPerYear = steemitBlocksPerYear;
	}

	@JsonProperty("STEEMIT_CASHOUT_WINDOW_SECONDS")
	public int getSteemitCashoutWindowSeconds() {
		return steemitCashoutWindowSeconds;
	}

	public void setSteemitCashoutWindowSeconds(int steemitCashoutWindowSeconds) {
		this.steemitCashoutWindowSeconds = steemitCashoutWindowSeconds;
	}

	@JsonProperty("STEEMIT_CHAIN_ID")
	public String getSteemitChainId() {
		return steemitChainId;
	}

	public void setSteemitChainId(String steemitChainId) {
		this.steemitChainId = steemitChainId;
	}

	@JsonProperty("STEEMIT_CONTENT_APR_PERCENT")
	public int getSteemitContentAprPercent() {
		return steemitContentAprPercent;
	}

	public void setSteemitContentAprPercent(int steemitContentAprPercent) {
		this.steemitContentAprPercent = steemitContentAprPercent;
	}

	@JsonProperty("STEEMIT_CONVERSION_DELAY")
	public long getSteemitConversionDelay() {
		return steemitConversionDelay;
	}

	public void setSteemitConversionDelay(long steemitConversionDelay) {
		this.steemitConversionDelay = steemitConversionDelay;
	}

	@JsonProperty("STEEMIT_CURATE_APR_PERCENT")
	public int getSteemitCurateAprPercent() {
		return steemitCurateAprPercent;
	}

	public void setSteemitCurateAprPercent(int steemitCurateAprPercent) {
		this.steemitCurateAprPercent = steemitCurateAprPercent;
	}

	@JsonProperty("STEEMIT_DEFAULT_SBD_INTEREST_RATE")
	public int getSteemitDefaultSbdInterestRate() {
		return steemitDefaultSbdInterestRate;
	}

	public void setSteemitDefaultSbdInterestRate(int steemitDefaultSbdInterestRate) {
		this.steemitDefaultSbdInterestRate = steemitDefaultSbdInterestRate;
	}

	@JsonProperty("STEEMIT_FEED_HISTORY_WINDOW")
	public int getSteemitFeedHistoryWindow() {
		return steemitFeedHistoryWindow;
	}

	public void setSteemitFeedHistoryWindow(int steemitFeedHistoryWindow) {
		this.steemitFeedHistoryWindow = steemitFeedHistoryWindow;
	}

	@JsonProperty("STEEMIT_FEED_INTERVAL_BLOCKS")
	public int getSteemitFeedIntervalBlocks() {
		return steemitFeedIntervalBlocks;
	}

	public void setSteemitFeedIntervalBlocks(int steemitFeedIntervalBlocks) {
		this.steemitFeedIntervalBlocks = steemitFeedIntervalBlocks;
	}

	@JsonProperty("STEEMIT_FREE_TRANSACTIONS_WITH_NEW_ACCOUNT")
	public int getSteemitFreeTransactionsWithNewAccount() {
		return steemitFreeTransactionsWithNewAccount;
	}

	public void setSteemitFreeTransactionsWithNewAccount(int steemitFreeTransactionsWithNewAccount) {
		this.steemitFreeTransactionsWithNewAccount = steemitFreeTransactionsWithNewAccount;
	}

	@JsonProperty("STEEMIT_GENESIS_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public Date getSteemitGenesisTime() {
		return steemitGenesisTime;
	}

	public void setSteemitGenesisTime(Date steemitGenesisTime) {
		this.steemitGenesisTime = steemitGenesisTime;
	}

	@JsonProperty("STEEMIT_HARDFORK_REQUIRED_WITNESSES")
	public int getSteemitHardforkRequiredWitnesses() {
		return steemitHardforkRequiredWitnesses;
	}

	public void setSteemitHardforkRequiredWitnesses(int steemitHardforkRequiredWitnesses) {
		this.steemitHardforkRequiredWitnesses = steemitHardforkRequiredWitnesses;
	}

	@JsonProperty("STEEMIT_INIT_MINER_NAME")
	public String getSteemitInitMinerName() {
		return steemitInitMinerName;
	}

	public void setSteemitInitMinerName(String steemitInitMinerName) {
		this.steemitInitMinerName = steemitInitMinerName;
	}

	@JsonProperty("STEEMIT_INIT_PUBLIC_KEY_STR")
	public String getSteemitInitPublicKeyStr() {
		return steemitInitPublicKeyStr;
	}

	public void setSteemitInitPublicKeyStr(String steemitInitPublicKeyStr) {
		this.steemitInitPublicKeyStr = steemitInitPublicKeyStr;
	}

	@JsonProperty("STEEMIT_INIT_SUPPLY")
	public String getSteemitInitSupply() {
		return steemitInitSupply;
	}

	public void setSteemitInitSupply(String steemitInitSupply) {
		this.steemitInitSupply = steemitInitSupply;
	}

	@JsonProperty("STEEMIT_INIT_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public Date getSteemitInitTime() {
		return steemitInitTime;
	}

	public void setSteemitInitTime(Date steemitInitTime) {
		this.steemitInitTime = steemitInitTime;
	}

	@JsonProperty("STEEMIT_IRREVERSIBLE_THRESHOLD")
	public int getSteemitIrreversibleThreshold() {
		return steemitIrreversibleThreshold;
	}

	public void setSteemitIrreversibleThreshold(int steemitIrreversibleThreshold) {
		this.steemitIrreversibleThreshold = steemitIrreversibleThreshold;
	}

	@JsonProperty("STEEMIT_LIQUIDITY_APR_PERCENT")
	public int getSteemitLiquidityAprPercent() {
		return steemitLiquidityAprPercent;
	}

	public void setSteemitLiquidityAprPercent(int steemitLiquidityAprPercent) {
		this.steemitLiquidityAprPercent = steemitLiquidityAprPercent;
	}

	@JsonProperty("STEEMIT_LIQUIDITY_REWARD_BLOCKS")
	public int getSteemitLiquidityRewardBlocks() {
		return steemitLiquidityRewardBlocks;
	}

	public void setSteemitLiquidityRewardBlocks(int steemitLiquidityRewardBlocks) {
		this.steemitLiquidityRewardBlocks = steemitLiquidityRewardBlocks;
	}

	@JsonProperty("STEEMIT_LIQUIDITY_REWARD_PERIOD_SEC")
	public int getSteemitLiquidityRewardPeriodSec() {
		return steemitLiquidityRewardPeriodSec;
	}

	public void setSteemitLiquidityRewardPeriodSec(int steemitLiquidityRewardPeriodSec) {
		this.steemitLiquidityRewardPeriodSec = steemitLiquidityRewardPeriodSec;
	}

	@JsonProperty("STEEMIT_LIQUIDITY_TIMEOUT_SEC")
	public String getSteemitLiquidityTimeoutSec() {
		return steemitLiquidityTimeoutSec;
	}

	public void setSteemitLiquidityTimeoutSec(String steemitLiquidityTimeoutSec) {
		this.steemitLiquidityTimeoutSec = steemitLiquidityTimeoutSec;
	}

	@JsonProperty("STEEMIT_MAX_ACCOUNT_NAME_LENGTH")
	public int getSteemitMaxAccountNameLength() {
		return steemitMaxAccountNameLength;
	}

	public void setSteemitMaxAccountNameLength(int steemitMaxAccountNameLength) {
		this.steemitMaxAccountNameLength = steemitMaxAccountNameLength;
	}

	@JsonProperty("STEEMIT_MAX_ACCOUNT_WITNESS_VOTES")
	public int getSteemitMaxAccountWitnessVotes() {
		return steemitMaxAccountWitnessVotes;
	}

	public void setSteemitMaxAccountWitnessVotes(int steemitMaxAccountWitnessVotes) {
		this.steemitMaxAccountWitnessVotes = steemitMaxAccountWitnessVotes;
	}

	@JsonProperty("STEEMIT_MAX_ASSET_WHITELIST_AUTHORITIES")
	public int getSteemitMaxAssetWhitelistAuthorities() {
		return steemitMaxAssetWhitelistAuthorities;
	}

	public void setSteemitMaxAssetWhitelistAuthorities(int steemitMaxAssetWhitelistAuthorities) {
		this.steemitMaxAssetWhitelistAuthorities = steemitMaxAssetWhitelistAuthorities;
	}

	@JsonProperty("STEEMIT_MAX_AUTHORITY_MEMBERSHIP")
	public int getSteemitMaxAuthorityMembership() {
		return steemitMaxAuthorityMembership;
	}

	public void setSteemitMaxAuthorityMembership(int steemitMaxAuthorityMembership) {
		this.steemitMaxAuthorityMembership = steemitMaxAuthorityMembership;
	}

	@JsonProperty("STEEMIT_MAX_BLOCK_SIZE")
	public long getSteemitMaxBlockSize() {
		return steemitMaxBlockSize;
	}

	public void setSteemitMaxBlockSize(long steemitMaxBlockSize) {
		this.steemitMaxBlockSize = steemitMaxBlockSize;
	}

	@JsonProperty("STEEMIT_MAX_CASHOUT_WINDOW_SECONDS")
	public int getSteemitMaxCashoutWindowSeconds() {
		return steemitMaxCashoutWindowSeconds;
	}

	public void setSteemitMaxCashoutWindowSeconds(int steemitMaxCashoutWindowSeconds) {
		this.steemitMaxCashoutWindowSeconds = steemitMaxCashoutWindowSeconds;
	}

	@JsonProperty("STEEMIT_MAX_COMMENT_DEPTH")
	public int getSteemitMaxCommentDepth() {
		return steemitMaxCommentDepth;
	}

	public void setSteemitMaxCommentDepth(int steemitMaxCommentDepth) {
		this.steemitMaxCommentDepth = steemitMaxCommentDepth;
	}

	@JsonProperty("STEEMIT_MAX_FEED_AGE")
	public String getSteemitMaxFeedAge() {
		return steemitMaxFeedAge;
	}

	public void setSteemitMaxFeedAge(String steemitMaxFeedAge) {
		this.steemitMaxFeedAge = steemitMaxFeedAge;
	}

	@JsonProperty("STEEMIT_MAX_INSTANCE_ID")
	public String getSteemitMaxInstanceId() {
		return steemitMaxInstanceId;
	}

	public void setSteemitMaxInstanceId(String steemitMaxInstanceId) {
		this.steemitMaxInstanceId = steemitMaxInstanceId;
	}

	@JsonProperty("STEEMIT_MAX_MEMO_SIZE")
	public int getSteemitMaxMemoSize() {
		return steemitMaxMemoSize;
	}

	public void setSteemitMaxMemoSize(int steemitMaxMemoSize) {
		this.steemitMaxMemoSize = steemitMaxMemoSize;
	}

	@JsonProperty("STEEMIT_MAX_WITNESSES")
	public int getSteemitMaxWitnesses() {
		return steemitMaxWitnesses;
	}

	public void setSteemitMaxWitnesses(int steemitMaxWitnesses) {
		this.steemitMaxWitnesses = steemitMaxWitnesses;
	}

	@JsonProperty("STEEMIT_MAX_MINER_WITNESSES")
	public int getSteemitMaxMinerWitnesses() {
		return steemitMaxMinerWitnesses;
	}

	public void setSteemitMaxMinerWitnesses(int steemitMaxMinerWitnesses) {
		this.steemitMaxMinerWitnesses = steemitMaxMinerWitnesses;
	}

	@JsonProperty("STEEMIT_MAX_PROXY_RECURSION_DEPTH")
	public int getSteemitMaxProxyRecursionDepth() {
		return steemitMaxProxyRecursionDepth;
	}

	public void setSteemitMaxProxyRecursionDepth(int steemitMaxProxyRecursionDepth) {
		this.steemitMaxProxyRecursionDepth = steemitMaxProxyRecursionDepth;
	}

	@JsonProperty("STEEMIT_MAX_RATION_DECAY_RATE")
	public int getSteemitMaxRationDecayRate() {
		return steemitMaxRationDecayRate;
	}

	public void setSteemitMaxRationDecayRate(int steemitMaxRationDecayRate) {
		this.steemitMaxRationDecayRate = steemitMaxRationDecayRate;
	}

	@JsonProperty("STEEMIT_MAX_RESERVE_RATIO")
	public int getSteemitMaxReserveRatio() {
		return steemitMaxReserveRatio;
	}

	public void setSteemitMaxReserveRatio(int steemitMaxReserveRatio) {
		this.steemitMaxReserveRatio = steemitMaxReserveRatio;
	}

	@JsonProperty("STEEMIT_MAX_RUNNER_WITNESSES")
	public int getSteemitMaxRunnerWitnesses() {
		return steemitMaxRunnerWitnesses;
	}

	public void setSteemitMaxRunnerWitnesses(int steemitMaxRunnerWitnesses) {
		this.steemitMaxRunnerWitnesses = steemitMaxRunnerWitnesses;
	}

	@JsonProperty("STEEMIT_MAX_SHARE_SUPPLY")
	public String getSteemitMaxShareSupply() {
		return steemitMaxShareSupply;
	}

	public void setSteemitMaxShareSupply(String steemitMaxShareSupply) {
		this.steemitMaxShareSupply = steemitMaxShareSupply;
	}

	@JsonProperty("STEEMIT_MAX_SIG_CHECK_DEPTH")
	public int getSteemitMaxSigCheckDepth() {
		return steemitMaxSigCheckDepth;
	}

	public void setSteemitMaxSigCheckDepth(int steemitMaxSigCheckDepth) {
		this.steemitMaxSigCheckDepth = steemitMaxSigCheckDepth;
	}

	@JsonProperty("STEEMIT_MAX_TIME_UNTIL_EXPIRATION")
	public int getSteemitMaxTimeUntilExpiration() {
		return steemitMaxTimeUntilExpiration;
	}

	public void setSteemitMaxTimeUntilExpiration(int steemitMaxTimeUntilExpiration) {
		this.steemitMaxTimeUntilExpiration = steemitMaxTimeUntilExpiration;
	}

	@JsonProperty("STEEMIT_MAX_TRANSACTION_SIZE")
	public int getSteemitMaxTransactionSize() {
		return steemitMaxTransactionSize;
	}

	public void setSteemitMaxTransactionSize(int steemitMaxTransactionSize) {
		this.steemitMaxTransactionSize = steemitMaxTransactionSize;
	}

	@JsonProperty("STEEMIT_MAX_UNDO_HISTORY")
	public int getSteemitMaxUndoHistory() {
		return steemitMaxUndoHistory;
	}

	public void setSteemitMaxUndoHistory(int steemitMaxUndoHistory) {
		this.steemitMaxUndoHistory = steemitMaxUndoHistory;
	}

	@JsonProperty("STEEMIT_MAX_URL_LENGTH")
	public int getSteemitMaxUrlLength() {
		return steemitMaxUrlLength;
	}

	public void setSteemitMaxUrlLength(int steemitMaxUrlLength) {
		this.steemitMaxUrlLength = steemitMaxUrlLength;
	}

	@JsonProperty("STEEMIT_MAX_VOTE_CHANGES")
	public int getSteemitMaxVoteChanges() {
		return steemitMaxVoteChanges;
	}

	public void setSteemitMaxVoteChanges(int steemitMaxVoteChanges) {
		this.steemitMaxVoteChanges = steemitMaxVoteChanges;
	}

	@JsonProperty("STEEMIT_MAX_VOTED_WITNESSES")
	public int getSteemitMaxVotedWitnesses() {
		return steemitMaxVotedWitnesses;
	}

	public void setSteemitMaxVotedWitnesses(int steemitMaxVotedWitnesses) {
		this.steemitMaxVotedWitnesses = steemitMaxVotedWitnesses;
	}

	@JsonProperty("STEEMIT_MAX_WITHDRAW_ROUTES")
	public int getSteemitMaxWithdrawRoutes() {
		return steemitMaxWithdrawRoutes;
	}

	public void setSteemitMaxWithdrawRoutes(int steemitMaxWithdrawRoutes) {
		this.steemitMaxWithdrawRoutes = steemitMaxWithdrawRoutes;
	}

	@JsonProperty("STEEMIT_MAX_WITNESS_URL_LENGTH")
	public int getSteemitMaxWitnessUrlLength() {
		return steemitMaxWitnessUrlLength;
	}

	public void setSteemitMaxWitnessUrlLength(int steemitMaxWitnessUrlLength) {
		this.steemitMaxWitnessUrlLength = steemitMaxWitnessUrlLength;
	}

	@JsonProperty("STEEMIT_MIN_ACCOUNT_CREATION_FEE")
	public int getSteemitMinAccountCreationFee() {
		return steemitMinAccountCreationFee;
	}

	public void setSteemitMinAccountCreationFee(int steemitMinAccountCreationFee) {
		this.steemitMinAccountCreationFee = steemitMinAccountCreationFee;
	}

	@JsonProperty("STEEMIT_MIN_ACCOUNT_NAME_LENGTH")
	public int getSteemitMinAccountNameLength() {
		return steemitMinAccountNameLength;
	}

	public void setSteemitMinAccountNameLength(int steemitMinAccountNameLength) {
		this.steemitMinAccountNameLength = steemitMinAccountNameLength;
	}

	@JsonProperty("STEEMIT_MIN_BLOCK_SIZE_LIMIT")
	public int getSteemitMinBlockSizeLimit() {
		return steemitMinBlockSizeLimit;
	}

	public void setSteemitMinBlockSizeLimit(int steemitMinBlockSizeLimit) {
		this.steemitMinBlockSizeLimit = steemitMinBlockSizeLimit;
	}

	@JsonProperty("STEEMIT_MIN_CONTENT_REWARD")
	public String getSteemitMinContentReward() {
		return steemitMinContentReward;
	}

	public void setSteemitMinContentReward(String steemitMinContentReward) {
		this.steemitMinContentReward = steemitMinContentReward;
	}

	@JsonProperty("STEEMIT_MIN_CURATE_REWARD")
	public String getSteemitMinCurateReward() {
		return steemitMinCurateReward;
	}

	public void setSteemitMinCurateReward(String steemitMinCurateReward) {
		this.steemitMinCurateReward = steemitMinCurateReward;
	}

	@JsonProperty("STEEMIT_MINER_ACCOUNT")
	public String getSteemitMinerAccount() {
		return steemitMinerAccount;
	}

	public void setSteemitMinerAccount(String steemitMinerAccount) {
		this.steemitMinerAccount = steemitMinerAccount;
	}

	@JsonProperty("STEEMIT_MINER_PAY_PERCENT")
	public int getSteemitMinerPayPercent() {
		return steemitMinerPayPercent;
	}

	public void setSteemitMinerPayPercent(int steemitMinerPayPercent) {
		this.steemitMinerPayPercent = steemitMinerPayPercent;
	}

	@JsonProperty("STEEMIT_MIN_FEEDS")
	public int getSteemitMinFeeds() {
		return steemitMinFeeds;
	}

	public void setSteemitMinFeeds(int steemitMinFeeds) {
		this.steemitMinFeeds = steemitMinFeeds;
	}

	@JsonProperty("STEEMIT_MINING_REWARD")
	public String getSteemitMiningReward() {
		return steemitMiningReward;
	}

	public void setSteemitMiningReward(String steemitMiningReward) {
		this.steemitMiningReward = steemitMiningReward;
	}

	@JsonProperty("STEEMIT_MINING_TIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public Date getSteemitMiningTime() {
		return steemitMiningTime;
	}

	public void setSteemitMiningTime(Date steemitMiningTime) {
		this.steemitMiningTime = steemitMiningTime;
	}

	@JsonProperty("STEEMIT_MIN_LIQUIDITY_REWARD")
	public String getSteemitMinLiquidityReward() {
		return steemitMinLiquidityReward;
	}

	public void setSteemitMinLiquidityReward(String steemitMinLiquidityReward) {
		this.steemitMinLiquidityReward = steemitMinLiquidityReward;
	}

	@JsonProperty("STEEMIT_MIN_LIQUIDITY_REWARD_PERIOD_SEC")
	public long getSteemitMinLiquidityRewardPeriodSec() {
		return steemitMinLiquidityRewardPeriodSec;
	}

	public void setSteemitMinLiquidityRewardPeriodSec(long steemitMinLiquidityRewardPeriodSec) {
		this.steemitMinLiquidityRewardPeriodSec = steemitMinLiquidityRewardPeriodSec;
	}

	@JsonProperty("STEEMIT_MIN_PAYOUT_SBD")
	public String getSteemitMinPayoutSbd() {
		return steemitMinPayoutSbd;
	}

	public void setSteemitMinPayoutSbd(String steemitMinPayoutSbd) {
		this.steemitMinPayoutSbd = steemitMinPayoutSbd;
	}

	@JsonProperty("STEEMIT_MIN_POW_REWARD")
	public String getSteemitMinPowReward() {
		return steemitMinPowReward;
	}

	public void setSteemitMinPowReward(String steemitMinPowReward) {
		this.steemitMinPowReward = steemitMinPowReward;
	}

	@JsonProperty("STEEMIT_MIN_PRODUCER_REWARD")
	public String getSteemitMinProducerReward() {
		return steemitMinProducerReward;
	}

	public void setSteemitMinProducerReward(String steemitMinProducerReward) {
		this.steemitMinProducerReward = steemitMinProducerReward;
	}

	@JsonProperty("STEEMIT_MIN_RATION")
	public int getSteemitMinRation() {
		return steemitMinRation;
	}

	public void setSteemitMinRation(int steemitMinRation) {
		this.steemitMinRation = steemitMinRation;
	}

	@JsonProperty("STEEMIT_MIN_TRANSACTION_EXPIRATION_LIMIT")
	public int getSteemitMinTransactionExpirationLimit() {
		return steemitMinTransactionExpirationLimit;
	}

	public void setSteemitMinTransactionExpirationLimit(int steemitMinTransactionExpirationLimit) {
		this.steemitMinTransactionExpirationLimit = steemitMinTransactionExpirationLimit;
	}

	@JsonProperty("STEEMIT_MIN_TRANSACTION_SIZE_LIMIT")
	public int getSteemitMminTransactionSizeLimit() {
		return steemitMminTransactionSizeLimit;
	}

	public void setSteemitMminTransactionSizeLimit(int steemitMminTransactionSizeLimit) {
		this.steemitMminTransactionSizeLimit = steemitMminTransactionSizeLimit;
	}

	@JsonProperty("STEEMIT_MIN_UNDO_HISTORY")
	public int getSteemitMinUndoHistory() {
		return steemitMinUndoHistory;
	}

	public void setSteemitMinUndoHistory(int steemitMinUndoHistory) {
		this.steemitMinUndoHistory = steemitMinUndoHistory;
	}

	@JsonProperty("STEEMIT_NULL_ACCOUNT")
	public String getSteemitNullAccount() {
		return steemitNullAccount;
	}

	public void setSteemitNullAccount(String steemitNullAccount) {
		this.steemitNullAccount = steemitNullAccount;
	}

	@JsonProperty("STEEMIT_NUM_INIT_MINERS")
	public int getSteemitNumInitMiners() {
		return steemitNumInitMiners;
	}

	public void setSteemitNumInitMiners(int steemitNumInitMiners) {
		this.steemitNumInitMiners = steemitNumInitMiners;
	}

	@JsonProperty("STEEMIT_POW_APR_PERCENT")
	public int getSteemitPowAprPercent() {
		return steemitPowAprPercent;
	}

	public void setSteemitPowAprPercent(int steemitPowAprPercent) {
		this.steemitPowAprPercent = steemitPowAprPercent;
	}

	@JsonProperty("STEEMIT_PRODUCER_APR_PERCENT")
	public int getSteemitProducerAprPercent() {
		return steemitProducerAprPercent;
	}

	public void setSteemitProducerAprPercent(int steemitProducerAprPercent) {
		this.steemitProducerAprPercent = steemitProducerAprPercent;
	}

	@JsonProperty("STEEMIT_PROXY_TO_SELF_ACCOUNT")
	public String getSteemitProxyToSelfAccount() {
		return steemitProxyToSelfAccount;
	}

	public void setSteemitProxyToSelfAccount(String steemitProxyToSelfAccount) {
		this.steemitProxyToSelfAccount = steemitProxyToSelfAccount;
	}

	@JsonProperty("STEEMIT_SBD_INTEREST_COMPOUND_INTERVAL_SEC")
	public long getSteemitSbdInterestCompoundIntervalSec() {
		return steemitSbdInterestCompoundIntervalSec;
	}

	public void setSteemitSbdInterestCompoundIntervalSec(long steemitSbdInterestCompoundIntervalSec) {
		this.steemitSbdInterestCompoundIntervalSec = steemitSbdInterestCompoundIntervalSec;
	}

	@JsonProperty("STEEMIT_SECONDS_PER_YEAR")
	public long getSteemitSecondsPerYear() {
		return steemitSecondsPerYear;
	}

	public void setSteemitSecondsPerYear(long steemitSecondsPerYear) {
		this.steemitSecondsPerYear = steemitSecondsPerYear;
	}

	@JsonProperty("STEEMIT_REVERSE_AUCTION_WINDOW_SECONDS")
	public int getSteemitReverseAuctionWindowSeconds() {
		return steemitReverseAuctionWindowSeconds;
	}

	public void setSteemitReverseAuctionWindowSeconds(int steemitReverseAuctionWindowSeconds) {
		this.steemitReverseAuctionWindowSeconds = steemitReverseAuctionWindowSeconds;
	}

	@JsonProperty("STEEMIT_START_MINER_VOTING_BLOCK")
	public int getSteemitStartMinerVotingBlock() {
		return steemitStartMinerVotingBlock;
	}

	public void setSteemitStartMinerVotingBlock(int steemitStartMinerVotingBlock) {
		this.steemitStartMinerVotingBlock = steemitStartMinerVotingBlock;
	}

	@JsonProperty("STEEMIT_START_VESTING_BLOCK")
	public int getSteemitStartVestingBlock() {
		return steemitStartVestingBlock;
	}

	public void setSteemitStartVestingBlock(int steemitStartVestingBlock) {
		this.steemitStartVestingBlock = steemitStartVestingBlock;
	}

	@JsonProperty("STEEMIT_SYMBOL")
	public String getSteemitSymbol() {
		return steemitSymbol;
	}

	public void setSteemitSymbol(String steemitSymbol) {
		this.steemitSymbol = steemitSymbol;
	}

	@JsonProperty("STEEMIT_TEMP_ACCOUNT")
	public String getSteemitTempAccount() {
		return steemitTempAccount;
	}

	public void setSteemitTempAccount(String steemitTempAccount) {
		this.steemitTempAccount = steemitTempAccount;
	}

	@JsonProperty("STEEMIT_UPVOTE_LOCKOUT")
	public long getSteemitUpvoteLockout() {
		return steemitUpvoteLockout;
	}

	public void setSteemitUpvoteLockout(long steemitUpvoteLockout) {
		this.steemitUpvoteLockout = steemitUpvoteLockout;
	}

	@JsonProperty("STEEMIT_VESTING_WITHDRAW_INTERVALS")
	public int getSteemitVestingWithdrawIntervals() {
		return steemitVestingWithdrawIntervals;
	}

	public void setSteemitVestingWithdrawIntervals(int steemitVestingWithdrawIntervals) {
		this.steemitVestingWithdrawIntervals = steemitVestingWithdrawIntervals;
	}

	@JsonProperty("STEEMIT_VESTING_WITHDRAW_INTERVAL_SECONDS")
	public int getSteemitVestingWithdrawIntervalSeconds() {
		return steemitVestingWithdrawIntervalSeconds;
	}

	public void setSteemitVestingWithdrawIntervalSeconds(int steemitVestingWithdrawIntervalSeconds) {
		this.steemitVestingWithdrawIntervalSeconds = steemitVestingWithdrawIntervalSeconds;
	}

	@JsonProperty("STEEMIT_VOTE_CHANGE_LOCKOUT_PERIOD")
	public int getSteemitVoteChangeLockoutPeriod() {
		return steemitVoteChangeLockoutPeriod;
	}

	public void setSteemitVoteChangeLockoutPeriod(int steemitVoteChangeLockoutPeriod) {
		this.steemitVoteChangeLockoutPeriod = steemitVoteChangeLockoutPeriod;
	}

	@JsonProperty("STEEMIT_VOTE_REGENERATION_SECONDS")
	public int getSteemitVoteRegenerationSeconds() {
		return steemitVoteRegenerationSeconds;
	}

	public void setSteemitVoteRegenerationSeconds(int steemitVoteRegenerationSeconds) {
		this.steemitVoteRegenerationSeconds = steemitVoteRegenerationSeconds;
	}

	@JsonProperty("STEEM_SYMBOL")
	public String getSteemSymbol() {
		return steemSymbol;
	}

	public void setSteemSymbol(String steemSymbol) {
		this.steemSymbol = steemSymbol;
	}

	@JsonProperty("VESTS_SYMBOL")
	public String getVestsSymbol() {
		return vestsSymbol;
	}

	public void setVestsSymbol(String vestsSymbol) {
		this.vestsSymbol = vestsSymbol;
	}

	@JsonProperty("BLOCKCHAIN_NAME")
	public String getBlockchainName() {
		return blockchainName;
	}

	public void setBlockchainName(String blockchainName) {
		this.blockchainName = blockchainName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
