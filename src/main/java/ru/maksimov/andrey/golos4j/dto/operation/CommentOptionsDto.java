package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.operation.extension.CommentOptionsExtension;
import ru.maksimov.andrey.golos4j.dto.param.Asset;
import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for operation comment_options
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class CommentOptionsDto extends BaseOperation {

	private static final long serialVersionUID = -6978830383962556422L;

	private static final OperationType TYPE = OperationType.COMMENT_OPTIONS_OPERATION;

	@JsonProperty("author")
	private String author;
	@JsonProperty("permlink")
	private String permlink;
	@JsonProperty("max_accepted_payout")
	private Asset maxAcceptedPayout;
	@JsonProperty("percent_steem_dollars")
	private short percentSteemDollars;
	@JsonProperty("allow_votes")
	private boolean allowVotes;
	@JsonProperty("allow_curation_rewards")
	private boolean allowCurationRewards;
	@JsonProperty("extensions")
	private List<CommentOptionsExtension> extensions = Collections.<CommentOptionsExtension> emptyList();

	public CommentOptionsDto() {
		super(TYPE);
	}

	/**
	 * Get author comment or article.
	 * 
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * Get the url of the article or comment.
	 * 
	 * @return permlink
	 */
	public String getPermlink() {
		return permlink;
	}

	/**
	 * Get max accepted payout.
	 * 
	 * @return max accepted payout
	 */
	public Asset getMaxAcceptedPayout() {
		return maxAcceptedPayout;
	}

	/**
	 * Get percent steem dollars.
	 * 
	 * @return percent steem dollars
	 */
	public short getPercentSteemDollars() {
		return percentSteemDollars;
	}

	/**
	 * Get allow votes.
	 * 
	 * @return allow votes
	 */
	public boolean isAllowVotes() {
		return allowVotes;
	}

	/**
	 * Get allow curation rewards.
	 * 
	 * @return allow curation rewards
	 */
	public boolean isAllowCurationRewards() {
		return allowCurationRewards;
	}

	/**
	 * Get list extension.
	 * 
	 * @return list extension
	 */
	public List<CommentOptionsExtension> getExtensions() {
		return extensions;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

	public void setMaxAcceptedPayout(Asset maxAcceptedPayout) {
		this.maxAcceptedPayout = maxAcceptedPayout;
	}

	public void setPercentSteemDollars(short percentSteemDollars) {
		this.percentSteemDollars = percentSteemDollars;
	}

	public void setAllowVotes(boolean allowVotes) {
		this.allowVotes = allowVotes;
	}

	public void setAllowCurationRewards(boolean allowCurationRewards) {
		this.allowCurationRewards = allowCurationRewards;
	}

	public void setExtensions(List<CommentOptionsExtension> extensions) {
		this.extensions = extensions;
	}

	@Override
	public List<Byte> toBytes() {
		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> authorBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> permlinkBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> maxAcceptedPayoutBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> percentSteemDollarsBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> allowVotesBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> allowCurationRewardsBytes = Collections
				.<Byte> singletonList((byte) 0);
		List<Byte> extensionsBytes = new ArrayList<Byte>();
		try {
			authorBytes = Util.stringUtf82ByteList(author);
			permlinkBytes = Util.stringUtf82ByteList(permlink);
			maxAcceptedPayoutBytes = maxAcceptedPayout.toBytes();
			percentSteemDollarsBytes = Util.short2ByteArray(percentSteemDollars);
			allowVotesBytes = Util.boolean2ByteArray(allowVotes);
			allowCurationRewardsBytes = Util.boolean2ByteArray(allowCurationRewards);
			extensionsBytes.add((byte) extensions.size());
			for (CommentOptionsExtension extension : extensions) {
				extensionsBytes.addAll(extension.toBytes());
			}
		} catch (BusinessException e) {
			e.printStackTrace();
		}

		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(authorBytes);
		list.addAll(permlinkBytes);
		list.addAll(maxAcceptedPayoutBytes);
		list.addAll(percentSteemDollarsBytes);
		list.addAll(allowVotesBytes);
		list.addAll(allowCurationRewardsBytes);
		list.addAll(extensionsBytes);
		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static OperationType getOperationType() {
		return TYPE;
	}

}
