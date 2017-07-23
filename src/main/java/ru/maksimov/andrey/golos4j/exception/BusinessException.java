package ru.maksimov.andrey.golos4j.exception;

/**
 * Wrap for business exceptions
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = 4742369552086416811L;

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
