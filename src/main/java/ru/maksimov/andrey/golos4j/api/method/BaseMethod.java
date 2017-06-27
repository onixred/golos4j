package ru.maksimov.andrey.golos4j.api.method;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.StringEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Base method
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseMethod {

	private static final String PARAM_ID_ID = "id";

	private static final String PARAM_ID_METHOD = "method";

	private static final String PARAM_ID_PARAMS = "params";

	private Integer id;

	private String method;

	private List<String> params = new ArrayList<String>();

	public BaseMethod(Integer id, String method) {
		this.id = id;
		this.method = method;
	}

	public BaseMethod(Integer id, String method, List<String> params) {
		this.id = id;
		this.method = method;
		this.params = params;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public List<String> getParams() {
		return params;
	}

	protected void setParams(List<String> params) {
		this.params = params;
	}

	/**
	 * Get map for key param name, value is param
	 * 
	 * @return param map
	 * @throws UnsupportedEncodingException
	 * @throws JsonProcessingException
	 */
	public StringEntity getEntity() throws UnsupportedEncodingException, JsonProcessingException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put(BaseMethod.PARAM_ID_ID, getId().toString());
		map.put(BaseMethod.PARAM_ID_METHOD, getMethod());

		if (!getParams().isEmpty()) {
			map.put(BaseMethod.PARAM_ID_PARAMS, getParams());
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(map);
		StringEntity myEntity = new StringEntity(jsonInString, "UTF-8");
		return myEntity;
	}

}
