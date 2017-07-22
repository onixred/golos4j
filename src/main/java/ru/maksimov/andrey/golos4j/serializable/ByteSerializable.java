package ru.maksimov.andrey.golos4j.serializable;

import java.util.List;

/**
 * interface for byte serializable
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public interface ByteSerializable {

	/**
	 * Get array bayts, convert object to bytes
	 */
	List<Byte> toBytes();
}
