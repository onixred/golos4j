package ru.maksimov.andrey.golos4j.dto.operation.extension;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import ru.maksimov.andrey.golos4j.deserializes.CommentOptionsExtensionDeserializer;
import ru.maksimov.andrey.golos4j.serializable.ByteSerializable;
import ru.maksimov.andrey.golos4j.serializer.CommentOptionsExtensionSerializer;

/**
 * Extension for {@link ru.maksimov.andrey.golos4j.dto.operation.CommentOptionsDto}
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
@JsonDeserialize(using = CommentOptionsExtensionDeserializer.class)
@JsonSerialize(using = CommentOptionsExtensionSerializer.class)
public abstract class CommentOptionsExtension implements ByteSerializable {

	@JsonIgnore
	private CommentOptionsExtensionsType type;

	public CommentOptionsExtension(CommentOptionsExtensionsType type) {
		this.type = type; 
	}

	public CommentOptionsExtensionsType getType() {
		return type;
	}

	protected void setType(CommentOptionsExtensionsType type) {
		this.type = type;
	}
}
