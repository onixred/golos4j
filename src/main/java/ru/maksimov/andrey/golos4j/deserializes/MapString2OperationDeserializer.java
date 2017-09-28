package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.UnknownDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map<String, OperationDto>
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapString2OperationDeserializer extends JsonDeserializer<Map<String, BaseOperation>> {

	@Override
	public Map<String, BaseOperation> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		System.out.println("asd");
		Map<String, Object> ret = Util.gsonArr2Map(parser, String.class, Object.class);
		Map<String, BaseOperation> map = new HashMap<String, BaseOperation>();
		String voteType = VoteDto.getOperationType().getCaption();
		String commentType = CommentDto.getOperationType().getCaption();
		ObjectMapper mapper = new ObjectMapper();
		for(String key: ret.keySet()) {
			if(voteType.contains(key)) {
				VoteDto vote = mapper.readValue(ret.get(key).toString(), VoteDto.class);
				map.put(key, vote);
			} else if(commentType.contains(key)) {
				CommentDto comment = mapper.readValue(ret.get(key).toString(), CommentDto.class);
				map.put(key, comment);
			} else {
				UnknownDto unknown = mapper.readValue(ret.get(key).toString(), UnknownDto.class);
				map.put(key, unknown);
			}
		}
		System.out.println("asd");
		return map;
	}

}