package ru.maksimov.andrey.golos4j.dto.transaction;

import java.util.Collections;
import java.util.List;

import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;

public class Extension implements ByteSerializable {

	@Override
	public List<Byte> toBytes() {
		return Collections.singletonList((byte) 1);
	}
}
