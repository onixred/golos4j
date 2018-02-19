package ru.maksimov.andrey.golos4j.dto.param;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is info about Profile for
 * {@link ru.maksimov.andrey.golos4j.dto.param.AccountMetadataDto#getProfile()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ProfileDto {

	private String profileImage;
	private String location;

	public String getProfileImage() {
		return profileImage;
	}

	public String getLocation() {
		return location;
	}

	@JsonProperty("profile_image")
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	@JsonProperty("location")
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
