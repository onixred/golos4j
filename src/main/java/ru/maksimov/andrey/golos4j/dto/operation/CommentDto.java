package ru.maksimov.andrey.golos4j.dto.operation;

/**
 * DTO for operation comment
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class CommentDto extends BaseOperationDto {

	private static final long serialVersionUID = -4822924304260583578L;

	private static final String type = "comment";

	private String parent_author; // если этот параметр пустой то это считается созданием новой публикации
	private String parent_permlink;
	private String author;
	private String permlink;
	private String title;
	private String body;
	private String jsonMetadata;

	public CommentDto() {
		super(type);
	}

	/**
	 * Get author name of the parent article or comment. Null if new article.
	 */
	public String getParent_author() {
		return parent_author;
	}

	public void setParent_author(String parent_author) {
		this.parent_author = parent_author;
	}

	/**
	 * Get of the parent comment or article. If this article is first category. If this comment is url of the article or comment.
	 */
	public String getParent_permlink() {
		return parent_permlink;
	}

	public void setParent_permlink(String parent_permlink) {
		this.parent_permlink = parent_permlink;
	}

	/**
	 * Get author comment or article.
	 */
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * Get the url of the article or comment.
	 */
	public String getPermlink() {
		return permlink;
	}

	public void setPermlink(String permlink) {
		this.permlink = permlink;
	}

	/**
	 * Get the title of the article. Null if comment.
	 */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Get the body of the article. Null if comment. (html/markdown)
	 */
	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getJsonMetadata() {
		return jsonMetadata;
	}

	public void setJsonMetadata(String jsonMetadata) {
		this.jsonMetadata = jsonMetadata;
	}

	
}
