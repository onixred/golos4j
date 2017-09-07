package ru.maksimov.andrey.golos4j.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;

/**
 * Serializer for BaseOperation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseOperationSerializer extends StdSerializer<VoteDto> {

	private static final String authorField = "author";
	private static final String permlinkField = "permlink";
	private static final String voterField = "voter";
	private static final String weightField = "weight";

	private static final long serialVersionUID = 1L;

	public BaseOperationSerializer() {
		this(null);
	}

	public BaseOperationSerializer(Class<VoteDto> t) {
		super(t);
	}

	@Override
	public void serialize(VoteDto operation, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		jgen.writeStartArray();
		jgen.writeString(operation.getType().getCaption().toLowerCase());
		jgen.writeStartObject();
		jgen.writeObjectField(authorField, operation.getAuthor());
		jgen.writeObjectField(permlinkField, operation.getPermlink());
		jgen.writeObjectField(voterField, operation.getVoter());
		jgen.writeObjectField(weightField, operation.getWeight());
		jgen.writeEndObject();
		jgen.writeEndArray();
	}

}
