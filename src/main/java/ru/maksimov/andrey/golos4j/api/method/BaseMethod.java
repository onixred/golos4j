package ru.maksimov.andrey.golos4j.api.method;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.exception.SystemException;

/**
 * Base method
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseMethod {

	private static final Logger LOG = LogManager.getLogger(BaseMethod.class);

	private static final String PARAM_ID_ID = "id";

	private static final String PARAM_ID_METHOD = "method";

	private static final String PARAM_ID_PARAMS = "params";

	private static final String PARAM_VALUE_METHOD = "call";

	private Integer id;

	private RequestMethods method;

	private SteemApis steemApi;

	private List<Object> params;

	public BaseMethod(Integer id, RequestMethods method) {
		this.id = id;
		this.method = method;
		params = new ArrayList<Object>();
	}

	public BaseMethod(Integer id, SteemApis steemApi, RequestMethods method) {
		this.id = id;
		this.steemApi = steemApi;
		this.method = method;
		params = new ArrayList<Object>();
	}

	public BaseMethod(Integer id, SteemApis steemApi, RequestMethods method, List<Object> params) {
		this.id = id;
		this.steemApi = steemApi;
		this.method = method;
		this.params = params;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RequestMethods getMethod() {
		return method;
	}

	public void setMethod(RequestMethods method) {
		this.method = method;
	}

	public List<Object> getParams() {
		return params;
	}

	protected void setParams(List<Object> params) {
		this.params = params;
	}
	

	public SteemApis getSteemApi() {
		return steemApi;
	}

	public void setSteemApi(SteemApis steemApi) {
		this.steemApi = steemApi;
	}

	/**
	 * Get map for key param name, value is param
	 * 
	 * @return param map
	 * @throws SystemException
	 *             системное исключение
	 */
	public StringEntity getEntity() throws SystemException {
		StringEntity myEntity = new StringEntity(getJson(), "UTF-8");
		return myEntity;
	}

	/**
	 * Get map for key param name, value is param
	 * 
	 * @return param map
	 * @throws SystemException
	 *             системное исключение
	 */
	public String getJson() throws SystemException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put(BaseMethod.PARAM_ID_ID, getId());
		map.put("jsonrpc", "2.0");
		map.put(BaseMethod.PARAM_ID_METHOD, PARAM_VALUE_METHOD);
		List<Object> params = new ArrayList<Object>();
		params.add(steemApi.toString().toLowerCase());
		
		params.add(method.toString().toLowerCase());
		params.add(getParams());
		map.put(BaseMethod.PARAM_ID_PARAMS, params);
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(map);
			LOG.debug("json-string: " + jsonInString);
			return jsonInString;
		} catch (JsonProcessingException e) {
			throw new SystemException("Unable convert map to string: " + e.getMessage(), e);
		}
	}
}
