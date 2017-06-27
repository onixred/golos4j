package ru.maksimov.andrey.golos4j.dto.operation;

/**
 * DTO for operation vote
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class VoteDto extends BaseOperationDto {

	private static final long serialVersionUID = -1377035920994354306L;

	private static final String type = "vote";

	private String author;
	private String permlink;
	private long weight;

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
	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

}
