package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get current status of the GOLOS network
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetDynamicGlobalProperties extends BaseMethod {

	public GetDynamicGlobalProperties(Integer id) {
		super(id, SteemApis.DATABASE_API, RequestMethods.GET_DYNAMIC_GLOBAL_PROPERTIES);
	}
}
