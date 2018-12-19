package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import ru.maksimov.andrey.golos4j.deserializes.MetadataDeserializer;
import ru.maksimov.andrey.golos4j.dto.param.Asset;
import ru.maksimov.andrey.golos4j.dto.param.ContentMetadataDto;

/**
 * Structure from the result
 * {@link ru.maksimov.andrey.golos4j.dto.api.GetContentDto#getResults()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
/**
 * @author mas
 *
 */
public class ContentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String author;
    private String permlink;
    private String category;
    private String parentAuthor;
    private String parentPermlink;
    private String title;
    private String body;
    private ContentMetadataDto metadata;
    private Date lastUpdate;
    private Date created;
    private Date active;
    private Date lastPayout;
    private int depth;
    private int children;
    private String childrenRshares2;
    private Long netRshares;
    private Long absRshares;
    private Long voteRshares;
    private Long childrenAbsRshares;
    private Date cashoutTime;
    private Date maxCashoutTime;
    private String totalVoteWeight;
    private int rewardWeight;
    private Asset totalPayoutValue;
    private Asset beneficiaryPayoutValue;
    private Asset beneficiaryGestsPayoutValue;
    private Asset curatorPayoutValue;
    private Asset curatorGestsPayoutValue;
    private int authorRewards;
    private Asset authorGbgPayoutValue;
    private Asset authorGolosPayoutValue;
    private Asset authorGestsPayoutValue;
    private int netVotes;
    private String curationRewardCurve;
    private String auctionWindowRewardDestination;
    private int auctionWindowSize;
    private String auctionWindowWeight;
    private String votesInAuctionWindowWeight;
    private long rootComment;
    private String mode;
    private Asset maxAcceptedPayout;
    private int percentSteemDollars;
    private boolean allowReplies;
    private boolean allowVotes;
    private boolean allowCurationRewards;
    private int curationRewardsPercent;
    private List<Object> beneficiaries;
    private String url;
    private String rootTitle;
    private Asset pendingAuthorPayoutValue;
    private Asset pendingAuthorPayoutGbgValue;
    private Asset pendingAuthorPayoutGestsValue;
    private Asset pendingAuthorPayoutGolosValue;
    private Asset pendingBenefactorPayoutValue;
    private Asset pendingBenefactorPayoutGestsValue;
    private Asset pendingCuratorPayoutValue;
    private Asset pendingCuratorPayoutGestsValue;
    private Asset pendingPayoutValue;
    private Asset totalPendingPayoutValue;
    private List<ActiveVoteDto> activeVotes;
    private int activeVotesCount;
    private List<String> replies;
    private String authorReputation;
    private Asset promoted;
    private int bodyLength;
    private List<String> rebloggedBy;
    private List<String> reblogEntries;

    @JsonProperty("id")
    public long getId() {
        return id;
    }

    @JsonProperty("author")
    public String getAuthor() {
        return author;
    }

    @JsonProperty("permlink")
    public String getPermlink() {
        return permlink;
    }

    @JsonProperty("category")
    public String getCategory() {
        return category;
    }

    @JsonProperty("parent_author")
    public String getParentAuthor() {
        return parentAuthor;
    }

    @JsonProperty("parent_permlink")
    public String getParentPermlink() {
        return parentPermlink;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("json_metadata")
    @JsonDeserialize(using = MetadataDeserializer.class)
    public ContentMetadataDto getMetadata() {
        return metadata;
    }

    @JsonProperty("last_update")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getCreated() {
        return created;
    }

    @JsonProperty("active")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getActive() {
        return active;
    }

    @JsonProperty("last_payout")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getLastPayout() {
        return lastPayout;
    }

    @JsonProperty("depth")
    public int getDepth() {
        return depth;
    }

    @JsonProperty("children")
    public int getChildren() {
        return children;
    }

    @JsonProperty("children_rshares2")
    public String getChildrenRshares2() {
        return childrenRshares2;
    }

    @JsonProperty("net_rshares")
    public Long getNetRshares() {
        return netRshares;
    }

    @JsonProperty("abs_rshares")
    public Long getAbsRshares() {
        return absRshares;
    }

    @JsonProperty("vote_rshares")
    public Long getVoteRshares() {
        return voteRshares;
    }

    @JsonProperty("children_abs_rshares")
    public Long getChildrenAbsRshares() {
        return childrenAbsRshares;
    }

    @JsonProperty("cashout_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getCashoutTime() {
        return cashoutTime;
    }

    @JsonProperty("max_cashout_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
    public Date getMaxCashoutTime() {
        return maxCashoutTime;
    }

    @JsonProperty("total_vote_weight")
    public String getTotalVoteWeight() {
        return totalVoteWeight;
    }

    @JsonProperty("reward_weight")
    public int getRewardWeight() {
        return rewardWeight;
    }

    @JsonProperty("pending_author_payout_value")
    public Asset getPendingAuthorPayoutValue() {
        return pendingAuthorPayoutValue;
    }

    @JsonProperty("pending_author_payout_gbg_value")
    public Asset getPendingAuthorPayoutGbgValue() {
        return pendingAuthorPayoutGbgValue;
    }

    @JsonProperty("pending_author_payout_gests_value")
    public Asset getPendingAuthorPayoutGestsValue() {
        return pendingAuthorPayoutGestsValue;
    }

    @JsonProperty("pending_author_payout_golos_value")
    public Asset getPendingAuthorPayoutGolosValue() {
        return pendingAuthorPayoutGolosValue;
    }

    @JsonProperty("pending_benefactor_payout_value")
    public Asset getPendingBenefactorPayoutValue() {
        return pendingBenefactorPayoutValue;
    }

    @JsonProperty("pending_benefactor_payout_gests_value")
    public Asset getPendingBenefactorPayoutGestsValue() {
        return pendingBenefactorPayoutGestsValue;
    }

    @JsonProperty("pending_curator_payout_value")
    public Asset getPendingCuratorPayoutValue() {
        return pendingCuratorPayoutValue;
    }

    @JsonProperty("pending_curator_payout_gests_value")
    public Asset getPendingCuratorPayoutGestsValue() {
        return pendingCuratorPayoutGestsValue;
    }

    @JsonProperty("total_payout_value")
    public Asset getTotalPayoutValue() {
        return totalPayoutValue;
    }

    @JsonProperty("author_gbg_payout_value")
    public Asset getAuthorGbgPayoutValue() {
        return authorGbgPayoutValue;
    }

    @JsonProperty("author_golos_payout_value")
    public Asset getAuthorGolosPayoutValue() {
        return authorGolosPayoutValue;
    }

    @JsonProperty("author_gests_payout_value")
    public Asset getAuthorGestsPayoutValue() {
        return authorGestsPayoutValue;
    }

    @JsonProperty("beneficiary_payout_value")
    public Asset getBeneficiaryPayoutValue() {
        return beneficiaryPayoutValue;
    }

    @JsonProperty("beneficiary_gests_payout_value")
    public Asset getBeneficiaryGestsPayoutValue() {
        return beneficiaryGestsPayoutValue;
    }

    @JsonProperty("curator_payout_value")
    public Asset getCuratorPayoutValue() {
        return curatorPayoutValue;
    }

    @JsonProperty("curator_gests_payout_value")
    public Asset getCuratorGestsPayoutValue() {
        return curatorGestsPayoutValue;
    }

    @JsonProperty("author_rewards")
    public int getAuthorRewards() {
        return authorRewards;
    }

    @JsonProperty("net_votes")
    public int getNetVotes() {
        return netVotes;
    }

    @JsonProperty("curation_reward_curve")
    public String getCurationRewardCurve() {
        return curationRewardCurve;
    }

    @JsonProperty("auction_window_reward_destination")
    public String getAuctionWindowRewardDestination() {
        return auctionWindowRewardDestination;
    }

    @JsonProperty("auction_window_size")
    public int getAuctionWindowSize() {
        return auctionWindowSize;
    }

    @JsonProperty("auction_window_weight")
    public String getAuctionWindowWeight() {
        return auctionWindowWeight;
    }

    @JsonProperty("votes_in_auction_window_weight")
    public String getVotesInAuctionWindowWeight() {
        return votesInAuctionWindowWeight;
    }

    @JsonProperty("root_comment")
    public long getRootComment() {
        return rootComment;
    }

    @JsonProperty("mode")
    public String getMode() {
        return mode;
    }

    @JsonProperty("max_accepted_payout")
    public Asset getMaxAcceptedPayout() {
        return maxAcceptedPayout;
    }

    @JsonProperty("percent_steem_dollars")
    public int getPercentSteemDollars() {
        return percentSteemDollars;
    }

    @JsonProperty("allow_replies")
    public boolean isAllowReplies() {
        return allowReplies;
    }

    @JsonProperty("allow_votes")
    public boolean isAllowVotes() {
        return allowVotes;
    }

    @JsonProperty("allow_curation_rewards")
    public boolean isAllowCurationRewards() {
        return allowCurationRewards;
    }

    @JsonProperty("curation_rewards_percent")
    public int getCurationRewardsPercent() {
        return curationRewardsPercent;
    }

    @JsonProperty("beneficiaries")
    public List<Object> getBeneficiaries() {
        return beneficiaries;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("root_title")
    public String getRootTitle() {
        return rootTitle;
    }

    @JsonProperty("pending_payout_value")
    public Asset getPendingPayoutValue() {
        return pendingPayoutValue;
    }

    @JsonProperty("total_pending_payout_value")
    public Asset getTotalPendingPayoutValue() {
        return totalPendingPayoutValue;
    }

    @JsonProperty("active_votes")
    public List<ActiveVoteDto> getActiveVotes() {
        return activeVotes;
    }

    @JsonProperty("active_votes_count")
    public int getActiveVotesCount() {
        return activeVotesCount;
    }

    @JsonProperty("replies")
    public List<String> getReplies() {
        return replies;
    }

    @JsonProperty("author_reputation")
    public String getAuthorReputation() {
        return authorReputation;
    }

    @JsonProperty("promoted")
    public Asset getPromoted() {
        return promoted;
    }

    @JsonProperty("body_length")
    public int getBodyLength() {
        return bodyLength;
    }

    @JsonProperty("reblogged_by")
    public List<String> getRebloggedBy() {
        return rebloggedBy;
    }

    @JsonProperty("reblog_entries")
    public List<String> getReblogEntries() {
        return reblogEntries;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPermlink(String permlink) {
        this.permlink = permlink;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setParentAuthor(String parentAuthor) {
        this.parentAuthor = parentAuthor;
    }

    public void setParentPermlink(String parentPermlink) {
        this.parentPermlink = parentPermlink;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setMetadata(ContentMetadataDto metadata) {
        this.metadata = metadata;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setActive(Date active) {
        this.active = active;
    }

    public void setLastPayout(Date lastPayout) {
        this.lastPayout = lastPayout;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public void setChildrenRshares2(String childrenRshares2) {
        this.childrenRshares2 = childrenRshares2;
    }

    public void setNetRshares(Long netRshares) {
        this.netRshares = netRshares;
    }

    public void setAbsRshares(Long absRshares) {
        this.absRshares = absRshares;
    }

    public void setVoteRshares(Long voteRshares) {
        this.voteRshares = voteRshares;
    }

    public void setChildrenAbsRshares(Long childrenAbsRshares) {
        this.childrenAbsRshares = childrenAbsRshares;
    }

    public void setCashoutTime(Date cashoutTime) {
        this.cashoutTime = cashoutTime;
    }

    public void setMaxCashoutTime(Date maxCashoutTime) {
        this.maxCashoutTime = maxCashoutTime;
    }

    public void setTotalVoteWeight(String totalVoteWeight) {
        this.totalVoteWeight = totalVoteWeight;
    }

    public void setRewardWeight(int rewardWeight) {
        this.rewardWeight = rewardWeight;
    }

    public void setCurationRewardsPercent(int curationRewardsPercent) {
        this.curationRewardsPercent = curationRewardsPercent;
    }

    public void setPendingAuthorPayoutValue(Asset pendingAuthorPayoutValue) {
        this.pendingAuthorPayoutValue = pendingAuthorPayoutValue;
    }

    public void setPendingAuthorPayoutGbgValue(Asset pendingAuthorPayoutGbgValue) {
        this.pendingAuthorPayoutGbgValue = pendingAuthorPayoutGbgValue;
    }

    public void setPendingAuthorPayoutGestsValue(Asset pendingAuthorPayoutGestsValue) {
        this.pendingAuthorPayoutGestsValue = pendingAuthorPayoutGestsValue;
    }

    public void setPendingAuthorPayoutGolosValue(Asset pendingAuthorPayoutGolosValue) {
        this.pendingAuthorPayoutGolosValue = pendingAuthorPayoutGolosValue;
    }

    public void setPendingBenefactorPayoutValue(Asset pendingBenefactorPayoutValue) {
        this.pendingBenefactorPayoutValue = pendingBenefactorPayoutValue;
    }

    public void setPendingBenefactorPayoutGestsValue(Asset pendingBenefactorPayoutGestsValue) {
        this.pendingBenefactorPayoutGestsValue = pendingBenefactorPayoutGestsValue;
    }

    public void setPendingCuratorPayoutValue(Asset pendingCuratorPayoutValue) {
        this.pendingCuratorPayoutValue = pendingCuratorPayoutValue;
    }

    public void setPendingCuratorPayoutGestsValue(Asset pendingCuratorPayoutGestsValue) {
        this.pendingCuratorPayoutGestsValue = pendingCuratorPayoutGestsValue;
    }

    public void setTotalPayoutValue(Asset totalPayoutValue) {
        this.totalPayoutValue = totalPayoutValue;
    }

    public void setReblogEntries(List<String> reblogEntries) {
        this.reblogEntries = reblogEntries;
    }

    public void setCurationRewardCurve(String curationRewardCurve) {
        this.curationRewardCurve = curationRewardCurve;
    }

    public void setAuctionWindowRewardDestination(String auctionWindowRewardDestination) {
        this.auctionWindowRewardDestination = auctionWindowRewardDestination;
    }

    public void setAuctionWindowSize(int auctionWindowSize) {
        this.auctionWindowSize = auctionWindowSize;
    }

    public void setAuctionWindowWeight(String auctionWindowWeight) {
        this.auctionWindowWeight = auctionWindowWeight;
    }

    public void setVotesInAuctionWindowWeight(String votesInAuctionWindowWeight) {
        this.votesInAuctionWindowWeight = votesInAuctionWindowWeight;
    }

    public void setAuthorGbgPayoutValue(Asset authorGbgPayoutValue) {
        this.authorGbgPayoutValue = authorGbgPayoutValue;
    }

    public void setAuthorGolosPayoutValue(Asset authorGolosPayoutValue) {
        this.authorGolosPayoutValue = authorGolosPayoutValue;
    }

    public void setAuthorGestsPayoutValue(Asset authorGestsPayoutValue) {
        this.authorGestsPayoutValue = authorGestsPayoutValue;
    }

    public void setBeneficiaryPayoutValue(Asset beneficiaryPayoutValue) {
        this.beneficiaryPayoutValue = beneficiaryPayoutValue;
    }

    public void setBeneficiaryGestsPayoutValue(Asset beneficiaryGestsPayoutValue) {
        this.beneficiaryGestsPayoutValue = beneficiaryGestsPayoutValue;
    }

    public void setCuratorPayoutValue(Asset curatorPayoutValue) {
        this.curatorPayoutValue = curatorPayoutValue;
    }

    public void setCuratorGestsPayoutValue(Asset curatorGestsPayoutValue) {
        this.curatorGestsPayoutValue = curatorGestsPayoutValue;
    }

    public void setAuthorRewards(int authorRewards) {
        this.authorRewards = authorRewards;
    }

    public void setNetVotes(int netVotes) {
        this.netVotes = netVotes;
    }

    public void setRootComment(long rootComment) {
        this.rootComment = rootComment;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void setMaxAcceptedPayout(Asset maxAcceptedPayout) {
        this.maxAcceptedPayout = maxAcceptedPayout;
    }

    public void setPercentSteemDollars(int percentSteemDollars) {
        this.percentSteemDollars = percentSteemDollars;
    }

    public void setAllowReplies(boolean allowReplies) {
        this.allowReplies = allowReplies;
    }

    public void setAllowVotes(boolean allowVotes) {
        this.allowVotes = allowVotes;
    }

    public void setAllowCurationRewards(boolean allowCurationRewards) {
        this.allowCurationRewards = allowCurationRewards;
    }

    public void setBeneficiaries(List<Object> beneficiaries) {
        this.beneficiaries = beneficiaries;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRootTitle(String rootTitle) {
        this.rootTitle = rootTitle;
    }

    public void setPendingPayoutValue(Asset pendingPayoutValue) {
        this.pendingPayoutValue = pendingPayoutValue;
    }

    public void setTotalPendingPayoutValue(Asset totalPendingPayoutValue) {
        this.totalPendingPayoutValue = totalPendingPayoutValue;
    }

    public void setActiveVotes(List<ActiveVoteDto> activeVotes) {
        this.activeVotes = activeVotes;
    }

    public void setActiveVotesCount(int activeVotesCount) {
        this.activeVotesCount = activeVotesCount;
    }

    public void setReplies(List<String> replies) {
        this.replies = replies;
    }

    public void setAuthorReputation(String authorReputation) {
        this.authorReputation = authorReputation;
    }

    public void setPromoted(Asset promoted) {
        this.promoted = promoted;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public void setRebloggedBy(List<String> rebloggedBy) {
        this.rebloggedBy = rebloggedBy;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

}
