package ru.maksimov.andrey.golos4j.serializer;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import ru.maksimov.andrey.golos4j.dto.operation.BaseOperation;
import ru.maksimov.andrey.golos4j.dto.operation.CommentDto;
import ru.maksimov.andrey.golos4j.dto.operation.TransferDto;
import ru.maksimov.andrey.golos4j.dto.operation.VoteDto;

/**
 * Serializer for BaseOperation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseOperationSerializer extends StdSerializer<BaseOperation> {

	private static final String authorField = "author";
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
	private static final String parentMemoField = "memo";

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
		jgen.writeStartArray();
		jgen.writeString(operation.getType().getCaption().toLowerCase());
		jgen.writeStartObject();
		if (operation instanceof VoteDto) {
			VoteDto vote = (VoteDto) operation;
			jgen.writeObjectField(authorField, vote.getAuthor());
			jgen.writeObjectField(permlinkField, vote.getPermlink());
			jgen.writeObjectField(voterField, vote.getVoter());
			jgen.writeObjectField(weightField, vote.getWeight());
		} else if (operation instanceof CommentDto) {
			CommentDto comment = (CommentDto) operation;
			jgen.writeObjectField(parentAuthorField, comment.getParentAuthor());
			jgen.writeObjectField(parentPermlinkField, comment.getParentPermlink());
			jgen.writeObjectField(authorField, comment.getAuthor());
			jgen.writeObjectField(permlinkField, comment.getPermlink());
			jgen.writeObjectField(titleField, comment.getTitle());
			jgen.writeObjectField(bodyField, comment.getBody());
			jgen.writeObjectField(jsonMetadataField, comment.getJsonMetadata());
		} else if (operation instanceof TransferDto) {
			TransferDto transfer = (TransferDto) operation;
			jgen.writeObjectField(parentFromField, transfer.getFrom());
			jgen.writeObjectField(parentToField, transfer.getTo());
			jgen.writeObjectField(parentAmountField, transfer.getAmount());
			jgen.writeObjectField(parentMemoField, transfer.getMemo());
		}
		jgen.writeEndObject();
		jgen.writeEndArray();
	}

}
