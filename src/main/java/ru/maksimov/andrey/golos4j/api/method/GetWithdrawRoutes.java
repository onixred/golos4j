package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.List;

import ru.maksimov.andrey.golos4j.dto.param.WithdrawRouteType;

/**
 * Method get withdraw routes
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class GetWithdrawRoutes extends BaseMethod {

	public GetWithdrawRoutes(Integer id, String account, WithdrawRouteType type) {
		super(id, SteemApis.DATABASE_API, RequestMethods.GET_WITHDRAW_ROUTES);
		setParams(account, type);
	}

	public void setParams(String account, WithdrawRouteType type) {
		List<Object> params = new ArrayList<Object>();
		params.add(account);
		params.add(type.name());
		super.setParams(params);
	}
}
