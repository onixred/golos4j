package ru.maksimov.andrey.golos4j.dto.transaction;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperationDto;

/**
 * DTO for base transaction
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseTransactionDto {

	private int refBlockNum;
	private long refBlockPrefix;
	private Date expiration;
	private List<BaseOperationDto> operations;
	private List extensions;
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
	 * Get transaction expiration time. Usually the date is not more than 30 seconds
	 */
	public Date getExpiration() {
		return expiration;
	}

	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}

	/**
	 * Get list operations.
	 */
	public List<BaseOperationDto> getOperations() {
		return operations;
	}

	public void setOperations(List<BaseOperationDto> operations) {
		this.operations = operations;
	}

	/**
	 * Get list extensions.
	 */
	public List getExtensions() {
		return extensions;
	}

	public void setExtensions(List extensions) {
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

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
