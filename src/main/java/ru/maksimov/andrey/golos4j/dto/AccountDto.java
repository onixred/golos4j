package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.dto.param.BaseKeyDto;
import ru.maksimov.andrey.golos4j.dto.param.Category;
import ru.maksimov.andrey.golos4j.deserializes.AssetDeserializer;
import ru.maksimov.andrey.golos4j.deserializes.MetadataDeserializer;
import ru.maksimov.andrey.golos4j.dto.param.AccountMetadataDto;
import ru.maksimov.andrey.golos4j.dto.param.Asset;

/**
 * Structure from the result map where value
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetAccountsDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AccountDto implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private String name;
	private BaseKeyDto owner;
	private BaseKeyDto active;
	private BaseKeyDto posting;
	private String memoKey;
	private AccountMetadataDto metadata;
	private String proxy;
	private Date lastOwnerUpdate;
	private Date lastAccountUpdate;
	private Date created;
	private boolean isMined;
	private boolean isOwnerChallenged;
	private boolean isActiveChallenged;
	private Date lastOwnerProved;
	private Date lastActiveProved;
	private String RecoveryAccount;
	private Date lastAccountRecovery;
	private String resetAccount;
	private int commentCount;
	private int lifetimeVoteCount;
	private int postcount;
	private boolean hasCanVote;
	private int votingPower;
	private Date lastVoteTime;
	private Asset balance;
	private Asset savingsBalance;
	private Asset sbdBalance;
	private String sbdSeconds;
	private Date sbdSecondsLastUpdate;
	private Date sbdLastInterestPayment;
	private Asset savingsSbdBalance;
	private String savingsSbdSeconds;
	private Date savingsSbdSecondsLastUpdate;
	private Date savingsSbdLastInterestPayment;
	private int savingsWithdrawRequests;
	private Asset vestingShares;
	private Asset delegatedVestingShares;
	private Asset receivedVestingShares;
	private Asset vestingWithdrawRrate;
	private Date nextVestingWithdrawal;
	private int withdrawn;
	private int toWithdraw;
	private int withdrawRoutes;
	private long curationRewards;
	private long postingRewards;
	private List<Integer> proxiedVsfVotes;
	private int witnessesVotedFor;
	private long averageBandwidth;
	private String lifetimeBandwidth;
	private Date lastBandwidthUpdate;
	private long averageMarketBandwidth;
	private Date lastMarketBandwidthUpdate;
	private Date lastPost;
	private Date lastRootPost;
	private long postBandwidth;
	private String newAverageBandwidth;
	private long newAverageMarketBandwidth;
	private Asset vestingBalance;
	private String reputation;
	private List<String> transferHistory;
	private List<String> marketHistory;
	private List<String> postHistory;
	private List<String> voteHistory;
	private List<String> otherHistory;
	private List<String> witnessVotes;
	private List<String> tagsUsage;
	private List<String> guestBloggers;
	private Category blogCategory;

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BaseKeyDto getOwner() {
		return owner;
	}

	public BaseKeyDto getActive() {
		return active;
	}

	public BaseKeyDto getPosting() {
		return posting;
	}

	public String getMemoKey() {
		return memoKey;
	}

	public AccountMetadataDto getMetadata() {
		return metadata;
	}

	public String getProxy() {
		return proxy;
	}

	public Date getLastOwnerUpdate() {
		return lastOwnerUpdate;
	}

	public Date getLastAccountUpdate() {
		return lastAccountUpdate;
	}

	public Date getCreated() {
		return created;
	}

	public boolean isMined() {
		return isMined;
	}

	public boolean isOwnerChallenged() {
		return isOwnerChallenged;
	}

	public boolean isActiveChallenged() {
		return isActiveChallenged;
	}

	public Date getLastOwnerProved() {
		return lastOwnerProved;
	}

	public Date getLastActiveProved() {
		return lastActiveProved;
	}

	public String getRecoveryAccount() {
		return RecoveryAccount;
	}

	public Date getLastAccountRecovery() {
		return lastAccountRecovery;
	}

	public String getResetAccount() {
		return resetAccount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public int getLifetimeVoteCount() {
		return lifetimeVoteCount;
	}

	public int getPostcount() {
		return postcount;
	}

	public boolean isHasCanVote() {
		return hasCanVote;
	}

	public int getVotingPower() {
		return votingPower;
	}

	public Date getLastVoteTime() {
		return lastVoteTime;
	}

	public Asset getBalance() {
		return balance;
	}

	public Asset getSavingsBalance() {
		return savingsBalance;
	}

	public Asset getSbdBalance() {
		return sbdBalance;
	}

	public String getSbdSeconds() {
		return sbdSeconds;
	}

	public Date getSbdSecondsLastUpdate() {
		return sbdSecondsLastUpdate;
	}

	public Date getSbdLastInterestPayment() {
		return sbdLastInterestPayment;
	}

	public Asset getSavingsSbdBalance() {
		return savingsSbdBalance;
	}

	public String getSavingsSbdSeconds() {
		return savingsSbdSeconds;
	}

	public Date getSavingsSbdSecondsLastUpdate() {
		return savingsSbdSecondsLastUpdate;
	}

	public Date getSavingsSbdLastInterestPayment() {
		return savingsSbdLastInterestPayment;
	}

	public int getSavingsWithdrawRequests() {
		return savingsWithdrawRequests;
	}

	public Asset getVestingShares() {
		return vestingShares;
	}

	public Asset getDelegatedVestingShares() {
		return delegatedVestingShares;
	}

	public Asset getReceivedVestingShares() {
		return receivedVestingShares;
	}

	public Asset getVestingWithdrawRrate() {
		return vestingWithdrawRrate;
	}

	public Date getNextVestingWithdrawal() {
		return nextVestingWithdrawal;
	}

	public int getWithdrawn() {
		return withdrawn;
	}

	public int getToWithdraw() {
		return toWithdraw;
	}

	public int getWithdrawRoutes() {
		return withdrawRoutes;
	}

	public long getCurationRewards() {
		return curationRewards;
	}

	public long getPostingRewards() {
		return postingRewards;
	}

	public List<Integer> getProxiedVsfVotes() {
		return proxiedVsfVotes;
	}

	public int getWitnessesVotedFor() {
		return witnessesVotedFor;
	}

	public long getAverageBandwidth() {
		return averageBandwidth;
	}

	public String getLifetimeBandwidth() {
		return lifetimeBandwidth;
	}

	public Date getLastBandwidthUpdate() {
		return lastBandwidthUpdate;
	}

	public long getAverageMarketBandwidth() {
		return averageMarketBandwidth;
	}

	public Date getLastMarketBandwidthUpdate() {
		return lastMarketBandwidthUpdate;
	}

	public Date getLastPost() {
		return lastPost;
	}

	public Date getLastRootPost() {
		return lastRootPost;
	}

	public long getPostBandwidth() {
		return postBandwidth;
	}

	public String getNewAverageBandwidth() {
		return newAverageBandwidth;
	}

	public long getNewAverageMarketBandwidth() {
		return newAverageMarketBandwidth;
	}

	public Asset getVestingBalance() {
		return vestingBalance;
	}

	public String getReputation() {
		return reputation;
	}

	public List<String> getTransferHistory() {
		return transferHistory;
	}

	public List<String> getMarketHistory() {
		return marketHistory;
	}

	public List<String> getPostHistory() {
		return postHistory;
	}

	public List<String> getVoteHistory() {
		return voteHistory;
	}

	public List<String> getOtherHistory() {
		return otherHistory;
	}

	public List<String> getWitnessVotes() {
		return witnessVotes;
	}

	public List<String> getTagsUsage() {
		return tagsUsage;
	}

	public List<String> getGuestBloggers() {
		return guestBloggers;
	}

	public Category getBlogCategory() {
		return blogCategory;
	}

	@JsonProperty("id")
	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("owner")
	public void setOwner(BaseKeyDto owner) {
		this.owner = owner;
	}

	@JsonProperty("active")
	public void setActive(BaseKeyDto active) {
		this.active = active;
	}

	@JsonProperty("posting")
	public void setPosting(BaseKeyDto posting) {
		this.posting = posting;
	}

	@JsonProperty("memo_key")
	public void setMemoKey(String memoKey) {
		this.memoKey = memoKey;
	}

	@JsonProperty("json_metadata")
	@JsonDeserialize(using = MetadataDeserializer.class)
	public void setMetadata(AccountMetadataDto metadata) {
		this.metadata = metadata;
	}

	@JsonProperty("proxy")
	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	@JsonProperty("last_owner_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastOwnerUpdate(Date lastOwnerUpdate) {
		this.lastOwnerUpdate = lastOwnerUpdate;
	}

	@JsonProperty("last_account_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastAccountUpdate(Date lastAccountUpdate) {
		this.lastAccountUpdate = lastAccountUpdate;
	}

	@JsonProperty("created")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setCreated(Date created) {
		this.created = created;
	}

	@JsonProperty("mined")
	public void setMined(boolean isMined) {
		this.isMined = isMined;
	}

	@JsonProperty("owner_challenged")
	public void setOwnerChallenged(boolean isOwnerChallenged) {
		this.isOwnerChallenged = isOwnerChallenged;
	}

	@JsonProperty("active_challenged")
	public void setActiveChallenged(boolean isActiveChallenged) {
		this.isActiveChallenged = isActiveChallenged;
	}

	@JsonProperty("last_owner_proved")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastOwnerProved(Date lastOwnerProved) {
		this.lastOwnerProved = lastOwnerProved;
	}

	@JsonProperty("last_active_proved")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastActiveProved(Date lastActiveProved) {
		this.lastActiveProved = lastActiveProved;
	}

	@JsonProperty("recovery_account")
	public void setRecoveryAccount(String recoveryAccount) {
		RecoveryAccount = recoveryAccount;
	}

	@JsonProperty("last_account_recovery")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastAccountRecovery(Date lastAccountRecovery) {
		this.lastAccountRecovery = lastAccountRecovery;
	}

	@JsonProperty("reset_account")
	public void setResetAccount(String resetAccount) {
		this.resetAccount = resetAccount;
	}

	@JsonProperty("comment_count")
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	@JsonProperty("lifetime_vote_count")
	public void setLifetimeVoteCount(int lifetimeVoteCount) {
		this.lifetimeVoteCount = lifetimeVoteCount;
	}

	@JsonProperty("post_count")
	public void setPostcount(int postcount) {
		this.postcount = postcount;
	}

	@JsonProperty("can_vote")
	public void setHasCanVote(boolean hasCanVote) {
		this.hasCanVote = hasCanVote;
	}

	@JsonProperty("voting_power")
	public void setVotingPower(int votingPower) {
		this.votingPower = votingPower;
	}

	@JsonProperty("last_vote_time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastVoteTime(Date lastVoteTime) {
		this.lastVoteTime = lastVoteTime;
	}

	@JsonProperty("balance")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setBalance(Asset balance) {
		this.balance = balance;
	}

	@JsonProperty("savings_balance")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setSavingsBalance(Asset savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	@JsonProperty("sbd_balance")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setSbdBalance(Asset sbdBalance) {
		this.sbdBalance = sbdBalance;
	}

	@JsonProperty("sbd_seconds")
	public void setSbdSeconds(String sbdSeconds) {
		this.sbdSeconds = sbdSeconds;
	}

	@JsonProperty("sbd_seconds_last_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setSbdSecondsLastUpdate(Date sbdSecondsLastUpdate) {
		this.sbdSecondsLastUpdate = sbdSecondsLastUpdate;
	}

	@JsonProperty("sbd_last_interest_payment")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setSbdLastInterestPayment(Date sbdLastInterestPayment) {
		this.sbdLastInterestPayment = sbdLastInterestPayment;
	}

	@JsonProperty("savings_sbd_balance")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setSavingsSbdBalance(Asset savingsSbdBalance) {
		this.savingsSbdBalance = savingsSbdBalance;
	}

	@JsonProperty("savings_sbd_seconds")
	public void setSavingsSbdSeconds(String savingsSbdSeconds) {
		this.savingsSbdSeconds = savingsSbdSeconds;
	}

	@JsonProperty("savings_sbd_seconds_last_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setSavingsSbdSecondsLastUpdate(Date savingsSbdSecondsLastUpdate) {
		this.savingsSbdSecondsLastUpdate = savingsSbdSecondsLastUpdate;
	}

	@JsonProperty("savings_sbd_last_interest_payment")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setSavingsSbdLastInterestPayment(Date savingsSbdLastInterestPayment) {
		this.savingsSbdLastInterestPayment = savingsSbdLastInterestPayment;
	}

	@JsonProperty("savings_withdraw_requests")
	public void setSavingsWithdrawRequests(int savingsWithdrawRequests) {
		this.savingsWithdrawRequests = savingsWithdrawRequests;
	}

	@JsonProperty("vesting_shares")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setVestingShares(Asset vestingShares) {
		this.vestingShares = vestingShares;
	}

	@JsonProperty("delegated_vesting_shares")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setDelegatedVestingShares(Asset delegatedVestingShares) {
		this.delegatedVestingShares = delegatedVestingShares;
	}

	@JsonProperty("received_vesting_shares")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setReceivedVestingShares(Asset receivedVestingShares) {
		this.receivedVestingShares = receivedVestingShares;
	}

	@JsonProperty("vesting_withdraw_rate")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setVestingWithdrawRrate(Asset vestingWithdrawRrate) {
		this.vestingWithdrawRrate = vestingWithdrawRrate;
	}

	@JsonProperty("next_vesting_withdrawal")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setNextVestingWithdrawal(Date nextVestingWithdrawal) {
		this.nextVestingWithdrawal = nextVestingWithdrawal;
	}

	@JsonProperty("withdrawn")
	public void setWithdrawn(int withdrawn) {
		this.withdrawn = withdrawn;
	}

	@JsonProperty("to_withdraw")
	public void setToWithdraw(int toWithdraw) {
		this.toWithdraw = toWithdraw;
	}

	@JsonProperty("withdraw_routes")
	public void setWithdrawRoutes(int withdrawRoutes) {
		this.withdrawRoutes = withdrawRoutes;
	}

	@JsonProperty("curation_rewards")
	public void setCurationRewards(long curationRewards) {
		this.curationRewards = curationRewards;
	}

	@JsonProperty("posting_rewards")
	public void setPostingRewards(long postingRewards) {
		this.postingRewards = postingRewards;
	}

	@JsonProperty("proxied_vsf_votes")
	public void setProxiedVsfVotes(List<Integer> proxiedVsfVotes) {
		this.proxiedVsfVotes = proxiedVsfVotes;
	}

	@JsonProperty("witnesses_voted_for")
	public void setWitnessesVotedFor(int witnessesVotedFor) {
		this.witnessesVotedFor = witnessesVotedFor;
	}

	@JsonProperty("average_bandwidth")
	public void setAverageBandwidth(long averageBandwidth) {
		this.averageBandwidth = averageBandwidth;
	}

	@JsonProperty("lifetime_bandwidth")
	public void setLifetimeBandwidth(String lifetimeBandwidth) {
		this.lifetimeBandwidth = lifetimeBandwidth;
	}

	@JsonProperty("last_bandwidth_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastBandwidthUpdate(Date lastBandwidthUpdate) {
		this.lastBandwidthUpdate = lastBandwidthUpdate;
	}

	@JsonProperty("average_market_bandwidth")
	public void setAverageMarketBandwidth(long averageMarketBandwidth) {
		this.averageMarketBandwidth = averageMarketBandwidth;
	}

	@JsonProperty("last_market_bandwidth_update")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastMarketBandwidthUpdate(Date lastMarketBandwidthUpdate) {
		this.lastMarketBandwidthUpdate = lastMarketBandwidthUpdate;
	}

	@JsonProperty("last_post")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastPost(Date lastPost) {
		this.lastPost = lastPost;
	}

	@JsonProperty("last_root_post")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public void setLastRootPost(Date lastRootPost) {
		this.lastRootPost = lastRootPost;
	}

	@JsonProperty("post_bandwidth")
	public void setPostBandwidth(long postBandwidth) {
		this.postBandwidth = postBandwidth;
	}

	@JsonProperty("new_average_bandwidth")
	public void setNewAverageBandwidth(String newAverageBandwidth) {
		this.newAverageBandwidth = newAverageBandwidth;
	}

	@JsonProperty("new_average_market_bandwidth")
	public void setNewAverageMarketBandwidth(long newAverageMarketBandwidth) {
		this.newAverageMarketBandwidth = newAverageMarketBandwidth;
	}

	@JsonProperty("vesting_balance")
	@JsonDeserialize(using = AssetDeserializer.class)
	public void setVestingBalance(Asset vestingBalance) {
		this.vestingBalance = vestingBalance;
	}

	@JsonProperty("reputation")
	public void setReputation(String reputation) {
		this.reputation = reputation;
	}

	@JsonProperty("transfer_history")
	public void setTransferHistory(List<String> transferHistory) {
		this.transferHistory = transferHistory;
	}

	@JsonProperty("market_history")
	public void setMarketHistory(List<String> marketHistory) {
		this.marketHistory = marketHistory;
	}

	@JsonProperty("post_history")
	public void setPostHistory(List<String> postHistory) {
		this.postHistory = postHistory;
	}

	@JsonProperty("vote_history")
	public void setVoteHistory(List<String> voteHistory) {
		this.voteHistory = voteHistory;
	}

	@JsonProperty("other_history")
	public void setOtherHistory(List<String> otherHistory) {
		this.otherHistory = otherHistory;
	}

	@JsonProperty("witness_votes")
	public void setWitnessVotes(List<String> witnessVotes) {
		this.witnessVotes = witnessVotes;
	}

	@JsonProperty("tags_usage")
	public void setTagsUsage(List<String> tagsUsage) {
		this.tagsUsage = tagsUsage;
	}

	@JsonProperty("guest_bloggers")
	public void setGuestBloggers(List<String> guestBloggers) {
		this.guestBloggers = guestBloggers;
	}

	@JsonProperty("blog_category")
	public void setBlogCategory(Category blogCategory) {
		this.blogCategory = blogCategory;
	}

}
