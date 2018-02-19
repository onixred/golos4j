package ru.maksimov.andrey.golos4j.dto.param;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is info about content for
 * {@link ru.maksimov.andrey.golos4j.dto.ContentDto#getMetadata()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ContentMetadataDto implements BaseMetadataDto {

	private static final long serialVersionUID = 1L;

	private List<String> tags;
	private List<String> images;
	private List<String> links;
	private String app;
	private String format;

	@JsonProperty("tags")
	public List<String> getTags() {
		return tags;
	}

	@JsonProperty("image")
	public List<String> getImages() {
		return images;
	}

	@JsonProperty("links")
	public List<String> getLinks() {
		return links;
	}

	@JsonProperty("app")
	public String getApp() {
		return app;
	}

	@JsonProperty("format")
	public String getFormat() {
		return format;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public void setLinks(List<String> links) {
		this.links = links;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
