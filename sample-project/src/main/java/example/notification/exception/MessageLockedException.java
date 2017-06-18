package example.notification.exception;

/**
 * Exception thrown when the message is locked
 * 
 * @author AlokPandey
 */
public class MessageLockedException extends ApplicationException {

	public MessageLockedException(String errorMessageLocked) {
		super(errorMessageLocked);
	}

	private static final long	serialVersionUID	= -6395464355963363248L;

}
