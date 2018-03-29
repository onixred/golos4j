package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import ru.maksimov.andrey.golos4j.dto.param.AccountMetadataDto;
import ru.maksimov.andrey.golos4j.dto.param.BaseMetadataDto;
import ru.maksimov.andrey.golos4j.dto.param.ContentMetadataDto;
import ru.maksimov.andrey.golos4j.util.Util;

/**
 * Deserializer for {@link ru.maksimov.andrey.golos4j.dto.param.BaseMetadataDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class MetadataDeserializer extends JsonDeserializer<BaseMetadataDto> {

	private static final Logger LOG = LogManager.getLogger(AssetDeserializer.class);

	@Override
	public BaseMetadataDto deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = p.getCodec();
		TreeNode node = codec.readTree(p);
		List<Class<? extends BaseMetadataDto>> list = new ArrayList<Class<? extends BaseMetadataDto>>();
		list.add(ContentMetadataDto.class);
		list.add(AccountMetadataDto.class);
		StringBuilder errors = new StringBuilder("Unable deserialize asset: ");
		for(Class<? extends BaseMetadataDto> aClass: list) {
			try {
				return Util.node2String2Object(node, aClass);
			} catch (Exception e) {
				errors.append(aClass.getName());
				errors.append(" ");
				errors.append(e.getMessage());
				errors.append(", ");
			}
		}
		LOG.error(errors.toString());
		return new ContentMetadataDto();
	}
}
