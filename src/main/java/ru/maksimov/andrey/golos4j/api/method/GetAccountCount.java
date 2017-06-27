package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get account count
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCount extends BaseMethod {

	private static String METHOD_NAME = "get_account_count";

	public GetAccountCount(Integer id) {
		super(id, METHOD_NAME);
	}
}
