package example.test.exception;

import java.io.Serializable;

/**
 * Exception thrown when no results are found.
 * 
 * @author AlokPandey
 */
public class NoResultsFoundException extends ApplicationException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new no results found exception.
	 */
	public NoResultsFoundException() {
		super();
	}

	/**
	 * Instantiates a new no results found exception.
	 * 
	 * @param message the message
	 */
	public NoResultsFoundException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new no results found exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public NoResultsFoundException(String message, Exception e) {
		super(message, e);
	}
}
