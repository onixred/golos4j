package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map&lt;String, String&gt;
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapString2StringDeserializer extends JsonDeserializer<Map<String, String>> {

	@Override
	public Map<String, String> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, String> ret = Util.gsonMap2Map(parser);
		return ret;
	}

}