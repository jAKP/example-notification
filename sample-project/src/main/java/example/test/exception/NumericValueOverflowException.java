package example.test.exception;

import java.io.Serializable;

/**
 * The Class NumericValueOverflowException.
 * 
 * @author AlokPandey
 */
public class NumericValueOverflowException extends ApplicationException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new numeric value overflow exception.
	 */
	public NumericValueOverflowException() {
		super();
	}

	/**
	 * Instantiates a new numeric value overflow exception.
	 * 
	 * @param message the message
	 */
	public NumericValueOverflowException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new numeric value overflow exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public NumericValueOverflowException(String message, Exception e) {
		super(message, e);
	}

}
