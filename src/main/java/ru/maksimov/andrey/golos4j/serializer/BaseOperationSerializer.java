package ru.maksimov.andrey.golos4j.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanDescription;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.BeanSerializerFactory;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.CommentOptionsDto;
import ru.maksimov.andrey.golos4j.dto.operation.TransferDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;

/**
 * Serializer for BaseOperation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseOperationSerializer extends StdSerializer<BaseOperation> {

/*	private static final String authorField = "author";
	private static final String permlinkField = "permlink";
	private static final String voterField = "voter";
	private static final String weightField = "weight";

	private static final String parentAuthorField = "parent_author";
	private static final String parentPermlinkField = "parent_permlink";

	private static final String titleField = "title";
	private static final String bodyField = "body";
	private static final String jsonMetadataField = "json_metadata";

	private static final String parentFromField = "from";
	private static final String parentToField = "to";
	private static final String parentAmountField = "amount";
	private static final String parentMemoField = "memo";*/

	private static final long serialVersionUID = 1L;

	public BaseOperationSerializer() {
		this(null);
	}

	public BaseOperationSerializer(Class<BaseOperation> t) {
		super(t);
	}

	@Override
	public void serialize(BaseOperation operation, JsonGenerator jgen, SerializerProvider provider)
			throws IOException, JsonProcessingException {
		//TODO уйти от явного определения
		jgen.writeStartArray();
		jgen.writeString(operation.getType().getCaption().toLowerCase());
		if (operation instanceof VoteDto) {
			serialize(operation, VoteDto.class, provider, jgen);
		} else if (operation instanceof CommentDto) {
			serialize(operation, CommentDto.class, provider, jgen);
		} else if (operation instanceof CommentOptionsDto) {
			serialize(operation, CommentOptionsDto.class, provider, jgen);
		} else if (operation instanceof TransferDto) {
			serialize(operation, TransferDto.class, provider, jgen);
		}
		jgen.writeEndArray();
	}

	private void serialize(BaseOperation operation, Class<? extends BaseOperation > aClass, SerializerProvider provider, JsonGenerator jgen) throws JsonProcessingException, IOException {
		JavaType javaType = provider.constructType(aClass);
		BeanDescription beanDesc = provider.getConfig().introspect(javaType);
		JsonSerializer<Object> serializer = BeanSerializerFactory.instance.findBeanSerializer(provider,
				javaType, beanDesc);
		serializer.serialize(aClass.cast(operation), jgen, provider);
		
	}

}
