package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.common.primitives.Bytes;

import ru.maksimov.andrey.golos4j.util.TransactionUtil;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for operation vote
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
/**
 * @author mas
 *
 */
public class VoteDto extends BaseOperation {

	private static final long serialVersionUID = -1377035920994354306L;

	private static final OperationType type = OperationType.VOTE_OPERATION;

	private String author;
	private String permlink;
	private String vote;
	private int weight;

	public VoteDto() {
		super(type);
	}

	/**
	 * Get author of the article or comment
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the url of the article or comment
	 */
	public String getPermlink() {
		return permlink;
	}

	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

	/**
	 * Get author vote
	 */
	public String getVote() {
		return vote;
	}

	public void setVote(String vote) {
		this.vote = vote;
	}

	/**
	 * Get weight of voice
	 */
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public byte[] toBytes() {
		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> authorBytes = Util.string2ByteList(author);
		List<Byte> permlinkBytes = Util.string2ByteList(permlink);
		List<Byte> voteBytes = Util.string2ByteList(vote);
		List<Byte> weightBytes = TransactionUtil.int2ByteList(weight, 2);
		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(voteBytes);
		list.addAll(authorBytes);
		list.addAll(permlinkBytes);
		list.addAll(weightBytes);
		return Bytes.toArray(list);
	}
}
