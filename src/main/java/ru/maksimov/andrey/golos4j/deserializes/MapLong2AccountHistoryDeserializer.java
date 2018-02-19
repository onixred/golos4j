package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;

import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import ru.maksimov.andrey.golos4j.dto.AccountHistoryDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map&lt;Long, AccountHistoryDto&gt; 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapLong2AccountHistoryDeserializer extends JsonDeserializer<Map<Long, AccountHistoryDto>> {

	@Override
	public Map<Long, AccountHistoryDto> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<Long, AccountHistoryDto> ret = Util.gsonArrArr2Map(parser, Long.class, AccountHistoryDto.class, false);
		return ret;
	}

}
