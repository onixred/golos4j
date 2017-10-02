package ru.maksimov.andrey.golos4j.dto.operation;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.OperationType;
import ru.maksimov.andrey.golos4j.deserializes.UnknownDtoDeserializer;

/**
 * Structure from the result map where value
 * {@link ru.maksimov.andrey.golos4j.dto.AccountHistoryDto#getOperations()}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
@JsonDeserialize(using = UnknownDtoDeserializer.class)
public class UnknownDto extends BaseOperation {

	private static final OperationType type = OperationType.UNKNOWN;

	public UnknownDto() {
		super(type);
	}

	private static final long serialVersionUID = 1L;

	private Map<String, String> key2value;

	public Map<String, String> getKey2value() {
		return key2value;
	}

	public void setKey2value(Map<String, String> key2value) {
		this.key2value = key2value;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

	@Override
	public List<Byte> toBytes() {
		return Collections.emptyList();
	}

	public static OperationType getOperationType() {
		return type;
	}
}
