package example.notification.exception;

import java.io.Serializable;

/**
 * The Class SearchTimeoutException.
 * 
 * @author AlokPandey
 */
public class SearchTimeoutException extends ApplicationException implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/**
	 * Instantiates a new search timeout exception.
	 */
	public SearchTimeoutException() {
		super();
	}

	/**
	 * Instantiates a new search timeout exception.
	 * 
	 * @param message the message
	 */
	public SearchTimeoutException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new search timeout exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public SearchTimeoutException(String message, Exception e) {
		super(message, e);
	}

}
