package ru.maksimov.andrey.golos4j.dto.operation;


/**
 * List of basic types operations
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public enum OperationType {
    VOTE_OPERATION("vote"),
    COMMENT_OPERATION("comment"),
    TRANSFER_OPERATION("transfer"),
    TRANSFER_TO_VESTING_OPERATION("comment"),
    WITHDRAW_VESTING_OPERATION("comment"),
    LIMIT_ORDER_CREATE_OPERATION("comment"),
    LIMIT_ORDER_CANCEL_OPERATION("comment"),
    FEED_PUBLISH_OPERATION("comment"),
    CONVERT_OPERATION("comment"),
    ACCOUNT_CREATE_OPERATION("comment"),
    ACCOUNT_UPDATE_OPERATION("comment"),
    WITNESS_UPDATE_OPERATION("comment"),
    ACCOUNT_WITNESS_VOTE_OPERATION("comment"),
    ACCOUNT_WITNESS_PROXY_OPERATION("comment"),
    POW_OPERATION("comment"),
    CUSTOM_OPERATION("comment"),
    REPORT_OVER_PRODUCTION_OPERATION("comment"),
    DELETE_COMMENT_OPERATION("comment"),
    CUSTOM_JSON_OPERATION("comment"),
    COMMENT_OPTIONS_OPERATION("comment"),
    SET_WITHDRAW_VESTING_ROUTE_OPERATION("comment"),
    LIMIT_ORDER_CREATE2_OPERATION("comment"),
    CHALLENGE_AUTHORITY_OPERATION("comment"),
    PROVE_AUTHORITY_OPERATION("comment"),
    REQUEST_ACCOUNT_RECOVERY_OPERATION("comment"),
    RECOVER_ACCOUNT_OPERATION("comment"),
    CHANGE_RECOVERY_ACCOUNT_OPERATION("comment"),
    ESCROW_TRANSFER_OPERATION("comment"),
    ESCROW_DISPUTE_OPERATION("comment"),
    ESCROW_RELEASE_OPERATION("comment"),
    POW2_OPERATION("comment"),
    ESCROW_APPROVE_OPERATION("comment"),
    TRANSFER_TO_SAVINGS_OPERATION("comment"),
    TRANSFER_FROM_SAVINGS_OPERATION("comment"),
    CANCEL_TRANSFER_FROM_SAVINGS_OPERATION("comment"),
    CUSTOM_BINARY_OPERATION("comment"),
    DECLINE_VOTING_RIGHTS_OPERATION("comment"),
    RESET_ACCOUNT_OPERATION("comment"),
    SET_RESET_ACCOUNT_OPERATION("comment"),

    /// VIRTUAL OPERATIONS BELOW THIS POINT
    FILL_CONVERT_REQUEST_OPERATION("comment"),
    AUTHOR_REWARD_OPERATION("comment"),
    CURATION_REWARD_OPERATION("comment"),
    COMMENT_REWARD_OPERATION("comment"),
    LIQUIDITY_REWARD_OPERATION("comment"),
    INTEREST_OPERATION("comment"),
    FILL_VESTING_WITHDRAW_OPERATION("comment"),
    FILL_ORDER_OPERATION("comment"),
    SHUTDOWN_WITNESS_OPERATION("comment"),
    FILL_TRANSFER_FROM_SAVINGS_OPERATION("comment"),
    HARDFORK_OPERATION("comment"),
    COMMENT_PAYOUT_UPDATE_OPERATION("comment"),
	
    UNKNOWN("unknown");

	private String caption;

	OperationType(String caption) {
		this.caption = caption;
	}

	public String getCaption() {
		return caption;
	}
}
