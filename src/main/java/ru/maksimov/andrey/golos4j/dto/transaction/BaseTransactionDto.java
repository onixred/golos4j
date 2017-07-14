package ru.maksimov.andrey.golos4j.dto.transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.primitives.Bytes;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;

/**
 * DTO for base transaction
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseTransactionDto implements ByteSerializable{

	private final int REF_BLOCK_NUM_BYTES = 2;
	private final int REF_BLOCK_PREFIX_BYTES = 4;
	private final int REF_BLOCK_EXPIRATION_BYTES = 4;

	public static final int DEFAULT_EXPIRATION_TIME = 30;

	private int refBlockNum;
	private long refBlockPrefix;
	private long expiration;
	private List<BaseOperation> operations;
	private List<Extension> extensions = Collections.<Extension>emptyList();
	private List signatures;

	/**
	 * Get Reference to the previous block number.
	 */
	public int getRefBlockNum() {
		return refBlockNum;
	}

	public void setRefBlockNum(int refBlockNum) {
		this.refBlockNum = refBlockNum;
	}

	/**
	 * Get last 4 bytes from the block identifier.
	 */
	public long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	public void setRefBlockPrefix(long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

	/**
	 * Get transaction relative expiration time. Usually the date is not more
	 * than 30 seconds
	 */
	public long getExpiration() {
		return expiration;
	}

	public void setExpiration(long expiration) {
		this.expiration = expiration;
	}

	/**
	 * Get list operations.
	 */
	public List<BaseOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<BaseOperation> operations) {
		this.operations = operations;
	}

	/**
	 * Get list extensions.
	 */
	public List<Extension> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
	}

	/**
	 * Get list signatures.
	 */
	public List getSignatures() {
		return signatures;
	}

	public void setSignatures(List signatures) {
		this.signatures = signatures;
	}

	/**
	 * Get serialization transaction.
	 */
	public String toSerialization() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get array bayts a fixed length, since we will always need 2 bytes for the
	 * ref_block_num value 4 bytes for the ref_block_prefix value 4 bytes for
	 * the relative_expiration
	 */
	@Override
	public byte[] toBytes() {
		List<Byte> byteArray = new ArrayList<Byte>();
		int length = REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES + REF_BLOCK_EXPIRATION_BYTES;
		for (int i = 0; i < length; i++) {
			if (i < REF_BLOCK_NUM_BYTES) {
				byteArray.add((byte) (this.refBlockNum >> 8 * i));
			} else if (i >= REF_BLOCK_NUM_BYTES && i < REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES) {
				byteArray.add((byte) (this.refBlockPrefix >> 8 * (i - REF_BLOCK_NUM_BYTES)));
			} else {
				byteArray.add((byte) (this.expiration >> 8 * (i - REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES)));
			}
		}
		byteArray.add((byte) operations.size());
		for (BaseOperation operation : operations) {
			byteArray.add((byte) operation.getType().ordinal());
			byteArray.addAll(Bytes.asList(operation.toBytes()));
		}

		byteArray.add((byte) extensions.size());
		for (Extension extension : extensions) {
			byteArray.addAll(Bytes.asList(extension.toBytes()));
		}

		return Bytes.toArray(byteArray);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
