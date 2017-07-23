package ru.maksimov.andrey.golos4j.exception;

/**
 * Wrap for system exceptions
 * 
 * @author <a href="mailto:onixbed@gmail.com">amaksimov</a>
 */
public class SystemException extends Exception {

	private static final long serialVersionUID = 3823152858515751080L;

	public SystemException(String message) {
		super(message);
	}

	public SystemException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
