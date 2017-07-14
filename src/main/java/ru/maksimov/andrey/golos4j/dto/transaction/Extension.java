package ru.maksimov.andrey.golos4j.dto.transaction;

import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;

public class Extension implements ByteSerializable {

	@Override
	public byte[] toBytes() {
		return new byte[1];
	}
}
