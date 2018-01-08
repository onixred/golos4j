package ru.maksimov.andrey.golos4j.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is info about vote content for
 * {@link ru.maksimov.andrey.golos4j.dto.ContentDto#getActiveVotes()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class ActiveVoteDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String voter;
	private long weight;
	private long rshares;
	private int percent;
	private long reputation;
	private Date time;

	@JsonProperty("voter")
	public String getVoter() {
		return voter;
	}

	@JsonProperty("weight")
	public long getWeight() {
		return weight;
	}

	@JsonProperty("rshares")
	public long getRshares() {
		return rshares;
	}

	@JsonProperty("percent")
	public int getPercent() {
		return percent;
	}

	@JsonProperty("reputation")
	public long getReputation() {
		return reputation;
	}

	@JsonProperty("time")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT")
	public Date getTime() {
		return time;
	}

	public void setVoter(String voter) {
		this.voter = voter;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

	public void setRshares(long rshares) {
		this.rshares = rshares;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	public void setReputation(long reputation) {
		this.reputation = reputation;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
