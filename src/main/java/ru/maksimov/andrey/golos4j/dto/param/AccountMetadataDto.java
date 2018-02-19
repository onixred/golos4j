package ru.maksimov.andrey.golos4j.dto.param;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * This is info about Metadata for
 * {@link ru.maksimov.andrey.golos4j.dto.AccountDto#getMetadata()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AccountMetadataDto implements BaseMetadataDto {

	private static final long serialVersionUID = 1L;

	private ProfileDto profile;

	public ProfileDto getProfile() {
		return profile;
	}

	public void setProfile(ProfileDto profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
