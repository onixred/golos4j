package ru.maksimov.andrey.golos4j.api.method;

import java.io.UnsupportedEncodingException;
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

	private Integer id;

	private String method;

	private List<Object> params = new ArrayList<Object>();

	public BaseMethod(Integer id, String method) {
		this.id = id;
		this.method = method;
	}

	public BaseMethod(Integer id, String method, List<Object> params) {
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

	public List<Object> getParams() {
		return params;
	}

	protected void setParams(List<Object> params) {
		this.params = params;
	}

	/**
	 * Get map for key param name, value is param
	 * 
	 * @return param map
	 * @throws UnsupportedEncodingException
	 * @throws JsonProcessingException
	 */
	public StringEntity getEntity() throws SystemException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put(BaseMethod.PARAM_ID_METHOD, getMethod());
		if (!getParams().isEmpty()) {
			map.put(BaseMethod.PARAM_ID_PARAMS, getParams());
		}
		map.put("jsonrpc", "2.0");
		map.put(BaseMethod.PARAM_ID_ID, getId());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(map);
			LOG.debug("json-string: " + jsonInString);
			StringEntity myEntity = new StringEntity(jsonInString, "UTF-8");
			return myEntity;
		} catch (JsonProcessingException e) {
			throw new SystemException("Unable convert map to string: " + e.getMessage(), e);
		}
	}

}
