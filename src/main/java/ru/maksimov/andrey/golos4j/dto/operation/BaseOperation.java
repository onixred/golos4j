package ru.maksimov.andrey.golos4j.dto.operation;

import java.io.Serializable;
import java.util.List;

import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;

/**
 * Base abstract operation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public abstract class BaseOperation implements Serializable, ByteSerializable {

	private static final long serialVersionUID = 6905594032725789509L;

	private OperationType type;

	public BaseOperation(OperationType type) {
		this.type = type;
	}

	public OperationType getType() {
		return type;
	}

	public void setType(OperationType type) {
		this.type = type;
	}

	@Override
	public abstract List<Byte> toBytes();

}
