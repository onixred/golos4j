package ru.maksimov.andrey.golos4j.dto.operation;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;
import ru.maksimov.andrey.golos4j.serializer.BaseOperationSerializer;

/**
 * Base abstract operation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
@JsonSerialize(using = BaseOperationSerializer.class)
public abstract class BaseOperation implements Serializable, ByteSerializable {

	private static final long serialVersionUID = 6905594032725789509L;

	private OperationType type;

	public BaseOperation(OperationType type) {
		this.type = type; 
	}

	public OperationType getType() {
		return type;
	}

	protected void setType(OperationType type) {
		this.type = type;
	}


	@Override
	public abstract List<Byte> toBytes();

}
