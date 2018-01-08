package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.dto.MetadataDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for {@link ru.maksimov.andrey.golos4j.dto.MetadataDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MetadataDeserializer extends JsonDeserializer<MetadataDto> {

	private static final Logger LOG = LogManager.getLogger(AssetDeserializer.class);

	@Override
	public MetadataDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = p.getCodec();
		TreeNode node = codec.readTree(p);
		try {
			return Util.node2String2Object(node, MetadataDto.class);
		} catch (Exception e) {
			LOG.error("Unable deserialize asset: " + e.getMessage(), e);
		}
		return new MetadataDto();
	}
}
