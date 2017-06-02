package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.dto.OperationDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map<String, OperationDto>
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapString2OperationDeserializer extends JsonDeserializer<Map<String, OperationDto>> {

	@Override
	public Map<String, OperationDto> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, OperationDto> ret = Util.gsonArr2Map(parser, String.class, OperationDto.class);
		return ret;
	}

}