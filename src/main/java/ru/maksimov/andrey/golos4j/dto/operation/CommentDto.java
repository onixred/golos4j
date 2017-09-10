package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.exception.BusinessException;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for operation comment
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class CommentDto extends BaseOperation {

	private static final long serialVersionUID = -4822924304260583578L;

	private static final OperationType type = OperationType.COMMENT_OPERATION;

	public static String TAGS_KEY = "tags";
	public static String IMAGE_KEY = "image";
	public static String LINKS_KEY = "links";

	// если этот параметр пустой то это считается
	// созданием новой публикации
	private String parentAuthor;
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

	public void setParentPermlink(String parentPermlink) {
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

	/*
	 * public void setJsonMetadata(String jsonMetadata) { this.jsonMetadata =
	 * jsonMetadata; }
	 */

	/**
	 * Set map where key {@link #TAGS_KEY}, {@link #IMAGE_KEY},
	 * {@link #LINKS_KEY} and value is tags, images and гкд links
	 * 
	 * @throws JsonProcessingException
	 */
	public void setJsonMetadata(Map<String, List<String>> jsonMetadata) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString;
		try {
			jsonInString = mapper.writeValueAsString(jsonMetadata);
		} catch (JsonProcessingException e) {
			jsonInString = " ";
		}
		this.jsonMetadata = jsonInString;
	}

	@Override
	public List<Byte> toBytes() {

		byte typeByte = (byte) getType().ordinal();
		List<Byte> typeBytes = Collections.singletonList(typeByte);
		List<Byte> parentAuthorBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> parentPermlinkBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> authorBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> permlinkBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> titleBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> bodyBytes = Collections.<Byte> singletonList((byte) 0);
		List<Byte> jsonMetadataBytes = Collections.<Byte> singletonList((byte) 0);

		try {
			parentAuthorBytes = Util.stringUtf82ByteList(parentAuthor);
			parentPermlinkBytes = Util.stringUtf82ByteList(parentPermlink);
			authorBytes = Util.stringUtf82ByteList(author);
			permlinkBytes = Util.stringUtf82ByteList(permlink);
			titleBytes = Util.stringUtf82ByteList(title);
			bodyBytes = Util.stringUtf82ByteList(body);
			jsonMetadataBytes = Util.stringUtf82ByteList(jsonMetadata);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<Byte> list = new ArrayList<Byte>();
		list.addAll(typeBytes);
		list.addAll(parentAuthorBytes);
		list.addAll(parentPermlinkBytes);
		list.addAll(authorBytes);
		list.addAll(permlinkBytes);
		list.addAll(titleBytes);
		list.addAll(bodyBytes);
		list.addAll(jsonMetadataBytes);
		return list;

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
