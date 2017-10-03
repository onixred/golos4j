package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import ru.maksimov.andrey.golos4j.util.TransactionUtil;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for operation vote
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class VoteDto extends BaseOperation {

	private static final long serialVersionUID = -1377035920994354306L;

	private static final OperationType type = OperationType.VOTE_OPERATION;

	private String author;

	private String permlink;

	private String voter;

	private int weight;

	public VoteDto() {
		super(type);
	}

	/**
	 * Get author of the article or comment
	 * 
	 * @return get author
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the url of the article or comment
	 * 
	 * @return get permlink
	 */
	public String getPermlink() {
		return permlink;
	}

	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

	/**
	 * Get voter
	 * 
	 * @return get voter
	 */
	public String getVoter() {
		return voter;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

	/**
	 * Get weight of voice
	 * 
	 * @return get weight
	 */
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public List<Byte> toBytes() {
		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> voteBytes = Util.string2ByteList(voter);
		List<Byte> authorBytes = Util.string2ByteList(author);
		List<Byte> permlinkBytes = Util.string2ByteList(permlink);
		List<Byte> weightBytes = TransactionUtil.int2ByteList(weight, 2);
		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(voteBytes);
		list.addAll(authorBytes);
		list.addAll(permlinkBytes);
		list.addAll(weightBytes);
		return list;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	public static OperationType getOperationType() {
		return type;
	}
}
