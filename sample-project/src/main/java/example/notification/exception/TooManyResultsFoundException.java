package example.notification.exception;

import java.io.Serializable;

/**
 * Exception thrown when too many results are found.
 * 
 * @author AlokPandey
 */
public class TooManyResultsFoundException extends ApplicationException implements Serializable {
	private static final long	serialVersionUID	= 1L;

	private int					maximumNumberOfResults;

	/**
	 * Instantiates a new too many results found exception.
	 * 
	 * @param maximumNumberOfResults
	 */
	public TooManyResultsFoundException(int maximumNumberOfResults) {
		super();
		this.maximumNumberOfResults = maximumNumberOfResults;
	}

	/**
	 * Instantiates a new too many results found exception.
	 * 
	 * @param message the message
	 * @param maximumNumberOfResults
	 */
	public TooManyResultsFoundException(String message, int maximumNumberOfResults) {
		super(message);
		this.maximumNumberOfResults = maximumNumberOfResults;
	}

	public int getMaximumNumberOfResults() {
		return maximumNumberOfResults;
	}
}
