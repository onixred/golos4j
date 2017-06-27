package ru.maksimov.andrey.golos4j.dto.operation;

import java.io.Serializable;

/**
 * DTO for base operation
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BaseOperationDto implements Serializable {

	private static final long serialVersionUID = 6905594032725789509L;

	private String type;

	public BaseOperationDto(String type) {
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
