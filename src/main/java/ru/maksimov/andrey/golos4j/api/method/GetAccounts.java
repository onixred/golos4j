package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.List;

import ru.maksimov.andrey.golos4j.exception.BusinessException;

/**
 * Method get info about accounts
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccounts extends BaseMethod {

	private static String METHOD_NAME = "get_accounts";

	public GetAccounts(Integer id, List<String> accounts) throws BusinessException {
		super(id, METHOD_NAME);
		setAccounts(accounts);
	}

	public void setAccounts(List<String> accounts) throws BusinessException {
		if(accounts == null || accounts.isEmpty() ) {
			throw new BusinessException("Unable set accounts. accounts is empty");
		}
		List<Object> params = new ArrayList<Object>();
		params.add(accounts);
		super.setParams(params);
	}

}
