package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get current status of the GOLOS network
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetDynamicGlobalProperties extends BaseMethod {

	private static String METHOD_NAME = "get_dynamic_global_properties";

	public GetDynamicGlobalProperties(Integer id) {
		super(id, METHOD_NAME);
	}
}
