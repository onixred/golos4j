package ru.maksimov.andrey.golos4j.dto.api;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.maksimov.andrey.golos4j.dto.BaseDto;
import ru.maksimov.andrey.golos4j.dto.ContentDto;

/**
 * DTO for method {@link ru.maksimov.andrey.golos4j.api.method.GetContent}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetContentDto extends BaseDto {

		private static final long serialVersionUID = 1L;

		private String jsonrpc;
		private ContentDto result;

		public String getJsonrpc() {
			return jsonrpc;
		}

		@JsonProperty("jsonrpc")
		public void setJsonrpc(String jsonrpc) {
			this.jsonrpc = jsonrpc;
		}

		public ContentDto getResults() {
			return result;
		}

		@JsonProperty("result")
		public void setResult(ContentDto result) {
			this.result = result;
		}

		@Override
		public String toString() {
			return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
		}
	}
