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

	private static String METHOD_NAME = "broadcast_transaction_synchronous";

	public BroadcastTransactionSynchronous(Integer id, BaseTransactionDto transactionDto) {
		super(id, METHOD_NAME);
		setParams(transactionDto);
	}

	public void setParams(BaseTransactionDto transactionDto) {
		List<String> params = new ArrayList<String>();
		params.add(transactionDto.toSerialization());
		super.setParams(params);
	}
}
