package ru.maksimov.andrey.golos4j.serializable;

/**
 * interface for byte serializable
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public interface ByteSerializable {

	/**
	 * Get array bayts, convert object to bytes
	 */
	byte[] toBytes();
}
