package example.notification.exception;

import java.io.Serializable;

/**
 * Exception thrown when the media webservice encounters an UnknownHostException
 * 
 * @author AlokPandey
 */
public class WebServiceUnknowHostException extends ApplicationException implements Serializable {
	private static final long	serialVersionUID	= 1L;
	private String				host;

	/**
	 * Instantiates a new media preview webservice exception.
	 */
	public WebServiceUnknowHostException(String host) {
		super();
		this.host = host;
	}

	/**
	 * Instantiates a new media preview webservice exception.
	 * 
	 * @param message the message
	 */
	public WebServiceUnknowHostException(String message, String host) {
		super(message);
		this.host = host;
	}

	/**
	 * Instantiates a new media preview webservice exception.
	 * 
	 * @param message the message
	 * @param e the e
	 */
	public WebServiceUnknowHostException(String message, Exception e, String host) {
		super(message, e);
		this.host = host;
	}

	public String getHost() {
		return host;
	}
}
