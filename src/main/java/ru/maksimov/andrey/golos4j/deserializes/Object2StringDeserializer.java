package ru.maksimov.andrey.golos4j.deserializes;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

/**
 * Deserializer for Object
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class Object2StringDeserializer extends JsonDeserializer<String> {

	@Override
	public String deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		ObjectCodec codec = p.getCodec();
		TreeNode node = codec.readTree(p);
		return node.toString();
	}

}
