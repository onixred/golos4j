package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Method get account history
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountHistory extends BaseMethod {

	private static String METHOD_NAME = "get_account_history";

	public GetAccountHistory(Integer id, String account, long from, int limit) {
		super(id, METHOD_NAME);
		setParams(account, from, limit);
	}

	public void setParams(String account, long from, int limit) {
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(Long.toString(from));
		params.add(Integer.toString(limit));
		super.setParams(params);
	}

}
