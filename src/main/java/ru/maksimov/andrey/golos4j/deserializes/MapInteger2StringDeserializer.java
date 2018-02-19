package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map&lt;Integer, String&gt;
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapInteger2StringDeserializer extends JsonDeserializer<Map<Integer, String>> {

	@Override
	public Map<Integer, String> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<Integer, String> ret = Util.gsonArrArr2Map(parser, Integer.class, String.class, false);
		return ret;
	}

}
