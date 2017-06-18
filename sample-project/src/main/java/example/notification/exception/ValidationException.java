package example.notification.exception;

import java.io.Serializable;

/**
 * Exception thrown when a validation check doesn't match its requirements
 * 
 * @author AlokPandey
 */
public class ValidationException extends ApplicationException implements Serializable {
	private static final long	serialVersionUID	= 1L;
	
	/**
	 * Instantiates a new passed id does not exist exception
	 */
	public ValidationException(long id) {
		super();
	}

	/**
	 * Instantiates a new passed id does not exist exception
	 * 
	 * @param message the message
	 */
	public ValidationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new passed id does not exist exception
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public ValidationException(String message, Exception e) {
		super(message, e);
	}
	

}
