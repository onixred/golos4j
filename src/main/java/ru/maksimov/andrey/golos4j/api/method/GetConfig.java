package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get config node client for GOLOS
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetConfig extends BaseMethod {

	public GetConfig(Integer id) {
		super(id, SteemApis.DATABASE_API, RequestMethods.GET_CONFIG);
	}
}
