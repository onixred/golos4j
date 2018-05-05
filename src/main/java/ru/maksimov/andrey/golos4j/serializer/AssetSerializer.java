package ru.maksimov.andrey.golos4j.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import ru.maksimov.andrey.golos4j.dto.param.Asset;

/**
 * This Custom serializer for class
 * {@link ru.maksimov.andrey.golos4j.dto.param.Asset}
 * .
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class AssetSerializer extends JsonSerializer<Asset>{

	@Override
	public void serialize(Asset asset, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		gen.writeString(asset.toString());
	}

}
