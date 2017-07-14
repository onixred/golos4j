package ru.maksimov.andrey.golos4j.dto.operation;

import com.google.common.primitives.Bytes;

import ru.maksimov.andrey.golos4j.util.TransactionUtil;

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
	private int weight;

	public VoteDto() {
		super(type);
	}

	/**
	 * Get author vote
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
		byte[] authorBytes = author.getBytes();
		byte[] permlinkBytes = permlink.getBytes();
		int refBlockNum = TransactionUtil.getLast2Byte(weight);
		byte[] weightBytes = new byte[]{(byte) refBlockNum};
		return Bytes.concat(authorBytes, permlinkBytes, weightBytes);
	}
}
