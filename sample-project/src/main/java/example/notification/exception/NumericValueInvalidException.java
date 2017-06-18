package example.notification.exception;

import java.io.Serializable;

/**
 * The Class NumericValueInvalidException.
 * 
 * @author AlokPandey
 */
public class NumericValueInvalidException extends ApplicationException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new numeric value invalid exception.
	 */
	public NumericValueInvalidException() {
		super();
	}

	/**
	 * Instantiates a new numeric value invalid exception.
	 * 
	 * @param message the message
	 */
	public NumericValueInvalidException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new numeric value invalid exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public NumericValueInvalidException(String message, Exception e) {
		super(message, e);
	}

}
