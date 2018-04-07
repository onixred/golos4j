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

	public BroadcastTransactionSynchronous(Integer id, BaseTransactionDto transactionDto) {
		super(id, SteemApis.NETWORK_BROADCAST_API, RequestMethods.BROADCAST_TRANSACTION_SYNCHRONOUS);
		setParams(transactionDto);
	}

	public void setParams(BaseTransactionDto transactionDto) {
		List<Object> params = new ArrayList<Object>();
		params.add(transactionDto);
		super.setParams(params);
		
	}
}
