package ru.maksimov.andrey.golos4j.dto.transaction;

import java.util.Collections;
import java.util.List;

import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;

/**
 * Extension for transaction
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Extension implements ByteSerializable {

	@Override
	public List<Byte> toBytes() {
		return Collections.singletonList((byte) 1);
	}
}
