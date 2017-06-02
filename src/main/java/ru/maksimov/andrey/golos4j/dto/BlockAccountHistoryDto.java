package ru.maksimov.andrey.golos4j.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * DTO for GetAccountCount
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BlockAccountHistoryDto extends BaseDto {

	private static final long serialVersionUID = 1L;

	private AccountHistoryDto[] accountsHistory;

	public AccountHistoryDto[] getAccountsHistory() {
		return accountsHistory;
	}

	public void setAccountsHistory(AccountHistoryDto[] accountsHistory) {
		this.accountsHistory = accountsHistory;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}
