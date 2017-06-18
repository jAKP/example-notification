package example.notification.exception;

import java.io.Serializable;

/**
 * The Class ValueTooLargeException.
 * 
 * @author AlokPandey
 */
public class ValueTooLargeException extends ApplicationException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new value too large exception.
	 */
	public ValueTooLargeException() {
		super();
	}

	/**
	 * Instantiates a new value too large exception.
	 * 
	 * @param message the message
	 */
	public ValueTooLargeException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new value too large exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public ValueTooLargeException(String message, Exception e) {
		super(message, e);
	}

}
