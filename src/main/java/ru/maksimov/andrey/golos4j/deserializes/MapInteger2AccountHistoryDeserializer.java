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
 * Deserializer for Map<Integer, AccountHistoryDto> 
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapInteger2AccountHistoryDeserializer extends JsonDeserializer<Map<Integer, AccountHistoryDto>> {

	@Override
	public Map<Integer, AccountHistoryDto> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<Integer, AccountHistoryDto> ret = Util.gsonArrArr2Map(parser, Integer.class, AccountHistoryDto.class);
		return ret;
	}

}
