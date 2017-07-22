package ru.maksimov.andrey.golos4j.dto.transaction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.Sha256Hash;
import org.bitcoinj.core.Utils;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * DTO for base transaction
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseTransactionDto implements ByteSerializable {

	private final int REF_BLOCK_NUM_BYTES = 2;
	private final int REF_BLOCK_PREFIX_BYTES = 4;
	private final int REF_BLOCK_EXPIRATION_BYTES = 4;

	public static final int DEFAULT_EXPIRATION_TIME = 30;

	private int refBlockNum;
	private long refBlockPrefix;
	private Date expiration;
	private List<BaseOperation> operations = new ArrayList<BaseOperation>();
	private List<Extension> extensions = Collections.<Extension> emptyList();
	private List<String> signatures;

	/**
	 * Get Reference to the previous block number.
	 *
	 * @return: ref_block_num.
	 */
	public int getRefBlockNum() {
		return refBlockNum;
	}

	/**
	 * Setter fot the 'ref_block_num' field.
	 * 
	 * @param refBlockNum:
	 *            The ref block number.
	 */
	public void setRefBlockNum(int refBlockNum) {
		this.refBlockNum = refBlockNum;
	}

	/**
	 * Get last 4 bytes from the block identifier.
	 * 
	 * @return: ref_block_prefix.
	 */
	public long getRefBlockPrefix() {
		return refBlockPrefix;
	}

	/**
	 * Setter fot the 'ref_block_prefix' field, assumint its value is exactly
	 * the one passed in the argument.
	 * 
	 * @param refBlockPrefix
	 */
	public void setRefBlockPrefix(long refBlockPrefix) {
		this.refBlockPrefix = refBlockPrefix;
	}

	/**
	 * Get transaction relative expiration time. Usually the date is not more
	 * than 30 seconds
	 * 
	 * @return: expiration time.
	 */
	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * Get list operations.
	 * 
	 * @return: list operations.
	 */
	public List<BaseOperation> getOperations() {
		return operations;
	}

	public void setOperations(List<BaseOperation> operations) {
		this.operations = operations;
	}

	/**
	 * Get list extensions.
	 * 
	 * @return: list extensions.
	 */
	public List<Extension> getExtensions() {
		return extensions;
	}

	public void setExtensions(List<Extension> extensions) {
		this.extensions = extensions;
	}

	/**
	 * Get list signatures.
	 * 
	 * @return: list signatures.
	 */
	public List<String> getSignatures() {
		return signatures;
	}

	public void setSignatures(List<String> signatures) {
		this.signatures = signatures;
	}

	/**
	 * Get list baytes serialized transaction with compact information about
	 * this transaction that is needed for the creation of a signature.
	 * 
	 * @return: byte array with serialized information about this transaction.
	 */
	@Override
	public List<Byte> toBytes() {
		List<Byte> byteArray = new ArrayList<Byte>();
		int length = REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES + REF_BLOCK_EXPIRATION_BYTES;
		for (int i = 0; i < length; i++) {
			if (i < REF_BLOCK_NUM_BYTES) {
				byteArray.add((byte) (this.refBlockNum >> 8 * i));
			} else if (i >= REF_BLOCK_NUM_BYTES && i < REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES) {
				byteArray.add((byte) (this.refBlockPrefix >> 8 * (i - REF_BLOCK_NUM_BYTES)));
			} else {
				byteArray.add((byte) ((this.expiration.getTime() / 1000) >> 8
						* (i - REF_BLOCK_NUM_BYTES + REF_BLOCK_PREFIX_BYTES)));
			}
		}
		byteArray.add((byte) operations.size());
		for (BaseOperation operation : operations) {
			byteArray.addAll(operation.toBytes());
		}

		byteArray.add((byte) extensions.size());
		for (Extension extension : extensions) {
			byteArray.addAll(extension.toBytes());
		}

		return byteArray;
	}

	/**
	 * Get array bayts signature
	 */
	public byte[] getSignatureBytes(String chainId, ECKey postingKey) {
		boolean isGrapheneCanonical = false;
		byte[] signatureData = null;

		while (!isGrapheneCanonical) {
			List<Byte> serializedTransaction = this.toBytes();
			List<Byte> listBytes = new ArrayList<Byte>();
			listBytes.addAll(Util.hexToBytes(chainId));
			listBytes.addAll(serializedTransaction);
			byte[] arrayBytes = Util.listBytes2array(listBytes);

			Sha256Hash hashTransaction = Sha256Hash.wrap(Sha256Hash.hash(arrayBytes));
			int recId = -1;
			ECKey.ECDSASignature sig = postingKey.sign(hashTransaction);

			for (int i = 0; i < 4; i++) {
				ECKey k = ECKey.recoverFromSignature(i, sig, hashTransaction, postingKey.isCompressed());
				if (k != null && k.getPubKeyPoint().equals(postingKey.getPubKeyPoint())) {
					recId = i;
					break;
				}
			}
			// 1 header + 32 bytes for R + 32 bytes for S
			signatureData = new byte[65];
			int headerByte = recId + 27 + (postingKey.isCompressed() ? 4 : 0);
			signatureData[0] = (byte) headerByte;
			System.arraycopy(Utils.bigIntegerToBytes(sig.r, 32), 0, signatureData, 1, 32);
			System.arraycopy(Utils.bigIntegerToBytes(sig.s, 32), 0, signatureData, 33, 32);

			// Further "canonicality" tests
			if (((signatureData[0] & 0x80) != 0) || (signatureData[0] == 0) || ((signatureData[1] & 0x80) != 0)
					|| ((signatureData[32] & 0x80) != 0) || (signatureData[32] == 0)
					|| ((signatureData[33] & 0x80) != 0)) {
				this.setExpiration(Util.addTime(this.getExpiration(), 1));
			} else {
				isGrapheneCanonical = true;
			}
		}
		return signatureData;

	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
