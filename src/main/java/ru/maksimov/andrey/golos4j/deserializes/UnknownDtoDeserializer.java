package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.dto.operation.UnknownDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for  UnknownDto
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class UnknownDtoDeserializer extends JsonDeserializer<UnknownDto> {

	@Override
	public UnknownDto deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, String> ret = Util.gsonMap2Map(parser);
		UnknownDto unknownDto = new UnknownDto();
		unknownDto.setKey2value(ret);
		return unknownDto;
	}

}
