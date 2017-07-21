package ru.maksimov.andrey.golos4j.api.method;

/**
 * Method get config node client for GOLOS
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetConfig extends BaseMethod {

	private static String METHOD_NAME = "get_config";

	public GetConfig(Integer id) {
		super(id, METHOD_NAME);
	}
}
