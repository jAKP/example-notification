package example.notification.exception;

/**
 * Class ApplicationException
 * 
 * @author AlokPandey
 */
public class ApplicationException extends Exception {
	private static final long	serialVersionUID	= -3546589451880499159L;

	/**
	 * Instantiates a new ae runtime exception.
	 */
	public ApplicationException() {
		super();
	}

	/**
	 * Instantiates a new ae runtime exception.
	 * 
	 * @param t the t
	 */
	public ApplicationException(Throwable t) {
		super(t);
	}

	/**
	 * Instantiates a new ae runtime exception.
	 * 
	 * @param message the message
	 */
	public ApplicationException(String message) {
		super(message);
	}

	/**
	 * Instantiates a new ae runtime exception.
	 * 
	 * @param message the message
	 * @param t the t
	 */
	public ApplicationException(String message, Throwable t) {
		super(message, t);
	}

}
