package ru.maksimov.andrey.golos4j.dto.operation;

import com.google.common.primitives.Bytes;

/**
 * DTO for operation comment
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class CommentDto extends BaseOperation {

	private static final long serialVersionUID = -4822924304260583578L;

	private static final OperationType type = OperationType.COMMENT_OPERATION;

	private String parentAuthor; // если этот параметр пустой то это считается
									// созданием новой публикации
	private String parentPermlink;
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
	public String getParentAuthor() {
		return parentAuthor;
	}

	public void setParentAuthor(String parentAuthor) {
		this.parentAuthor = parentAuthor;
	}

	/**
	 * Get of the parent comment or article. If this article is first category.
	 * If this comment is url of the article or comment.
	 */
	public String getParentPermlink() {
		return parentPermlink;
	}

	public void setParent_permlink(String parentPermlink) {
		this.parentPermlink = parentPermlink;
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
	 * Get the url of the article or comment. If this first comment is add
	 * "re-PARENT-AUTHOR-NAME-ARTICLE". If this last comment is add
	 * "re-AUTHOR-re-PATENT-AUTHOR-PATENT-PERMLINK-DATE"
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

	@Override
	public byte[] toBytes() {
		byte[] parentAuthorBytes = parentAuthor.getBytes();
		byte[] parentPermlinkBytes = parentPermlink.getBytes();
		byte[] authorBytes = author.getBytes();
		byte[] permlinkBytes = permlink.getBytes();
		byte[] titleBytes = title.getBytes();
		byte[] bodyBytes = body.getBytes();
		byte[] jsonMetadataBytes = jsonMetadata.getBytes();
		return Bytes.concat(parentAuthorBytes, parentPermlinkBytes, authorBytes, permlinkBytes, titleBytes, bodyBytes,
				jsonMetadataBytes);
	}
}
