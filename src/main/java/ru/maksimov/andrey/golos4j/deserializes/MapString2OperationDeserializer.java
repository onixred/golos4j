package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.TransferDto;
import ru.maksimov.andrey.golos4j.dto.operation.UnknownDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for Map&lt;String, OperationDto&gt;
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MapString2OperationDeserializer extends JsonDeserializer<Map<String, BaseOperation>> {

	private static final Logger LOG = LogManager.getLogger(MapString2OperationDeserializer.class);

	@Override
	public Map<String, BaseOperation> deserialize(JsonParser parser, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		Map<String, TreeNode> ret = Util.gsonArr2Map(parser, String.class, TreeNode.class);
		Map<String, BaseOperation> map = new HashMap<String, BaseOperation>();
		String voteType = VoteDto.getOperationType().getCaption();
		String commentType = CommentDto.getOperationType().getCaption();
		String transferDto = TransferDto.getOperationType().getCaption();
		ObjectMapper mapper = new ObjectMapper();
		try {
			for (String key : ret.keySet()) {
				if (voteType.contains(key)) {
					VoteDto vote = mapper.readValue(ret.get(key).toString(), VoteDto.class);
					map.put(key, vote);
				} else if (commentType.contains(key)) {
					CommentDto comment = mapper.readValue(ret.get(key).toString(), CommentDto.class);
					map.put(key, comment);
				} else if (transferDto.contains(key)) {
					TransferDto comment = mapper.readValue(ret.get(key).toString(), TransferDto.class);
					map.put(key, comment);
				} else {
					UnknownDto unknown = mapper.treeToValue(ret.get(key), UnknownDto.class);
					map.put(key, unknown);
				}
			}
		} catch (Exception e) {
			LOG.error("Unable deserialize operation: " + e.getMessage(), e);
		}

		return map;
	}

}