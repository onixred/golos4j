package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.List;

import ru.maksimov.andrey.golos4j.dto.transaction.BaseTransactionDto;

/**
 * Method broadcast transaction synchronous
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BroadcastTransactionSynchronous extends BaseMethod {

	private final static String METHOD_NAME = "call";
	private final static String PARAM_NAME = "broadcast_transaction_synchronous";
	private final static int PARAM_ID = 3;

	public BroadcastTransactionSynchronous(Integer id, BaseTransactionDto transactionDto) {
		super(id, METHOD_NAME);
		setParams(transactionDto);
	}

	public void setParams(BaseTransactionDto transactionDto) {
		List<Object> params = new ArrayList<Object>();
		params.add(BroadcastTransactionSynchronous.PARAM_ID);
		params.add(BroadcastTransactionSynchronous.PARAM_NAME);
		BaseTransactionDto[] transactionsDto  = {transactionDto};
		params.add(transactionsDto);
		super.setParams(params);
		
	}
}
