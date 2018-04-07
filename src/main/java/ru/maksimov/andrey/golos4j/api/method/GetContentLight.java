package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.List;

/**
 * Method get info about post light
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetContentLight extends BaseMethod {

	public GetContentLight(Integer id, String account, String permlink, HardForkVersion version) {
		super(id, RequestMethods.GET_CONTENT);
		if (version == HardForkVersion.HF_16) {
			setSteemApi(SteemApis.DATABASE_API);
		} else {
			setSteemApi(SteemApis.SOCIAL_NETWORK);
		}

		setParams(account, permlink);
	}

	public void setParams(String account, String permlink) {
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(permlink);
		super.setParams(params);
	}
}
