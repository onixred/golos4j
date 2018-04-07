package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get account count
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetAccountCount extends BaseMethod {

	public GetAccountCount(Integer id) {
		super(id, SteemApis.DATABASE_API, RequestMethods.GET_ACCOUNT_COUNT);
	}
}
