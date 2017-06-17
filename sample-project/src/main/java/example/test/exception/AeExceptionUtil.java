package example.test.exception;

import java.net.UnknownHostException;

import javax.xml.ws.WebServiceException;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.dao.DataAccessException;

/**
 * The Class AeExceptionUtil.
 * 
 * @author AlokPandey
 */
public class AeExceptionUtil {

	public static void throwPersistencyException(Exception e, String service, Log logger) throws ApplicationException {
		throwPersistencyException(e, service, null, "0", logger);
	}

	/**
	 * Throw a specific error when a problem occurred during the insert, update or delete of data.
	 * 
	 * @param e the e
	 * @param service the service
	 * @param id the id
	 * @param idValue the value of the id
	 * @param logger the logger
	 * @throws ApplicationException the ae runtime exception
	 */
	public static void throwPersistencyException(Exception e, String service, String id, String idValue, Log logger) throws ApplicationException {
		String message = "Error while executing " + service;
		if (StringUtils.isNotEmpty(id)) {
			message += " with " + id + " = " + idValue;
		}
		if (logger != null) {
			if (logger.isErrorEnabled()) {
				logger.error(message, e);
			}
		}
		if (e instanceof DataAccessException) {
			if (StringUtils.contains(e.getMessage(), "ORA-01401: inserted value too large for column")) {
				throw new ValueTooLargeException(message, e);
			}
			if (StringUtils.contains(e.getMessage(), "ORA-01461: can bind a LONG value only for insert into a LONG column")) {
				throw new ValueTooLargeException(message, e);
			}
			if (StringUtils.contains(e.getMessage(), "ORA-01426: numeric overflow")) {
				throw new NumericValueOverflowException(message, e);
			}
			if (StringUtils.contains(e.getMessage(), "ORA-01722: invalid number")) {
				throw new NumericValueInvalidException(message, e);
			}
		}
	}

	/**
	 * Throw a specific error when a problem occurred during the list.
	 * 
	 * @param e the e
	 * @param service the service
	 * @param logger the logger
	 * @throws ApplicationException the ae runtime exception
	 */
	public static void throwReadException(Exception e, String service, Log logger) throws ApplicationException {
		//Checking ibatis exception
		if (e instanceof TooManyResultsException || e.getCause() instanceof TooManyResultsException){
			throw new TooManyResultsFoundException(e.getMessage(), 1);
		}

		String message = "Error while executing " + service;
		if (logger != null) {
			if (logger.isInfoEnabled()) {
				logger.info(message, e);
			}
		}

		if (e instanceof DataAccessException) {
			if (StringUtils.contains(e.getMessage(), "ORA-01013: user requested cancel of current operation")) {
				throw new SearchTimeoutException(message, e);
			}
		}
	}

	
	/**
	 * Throw a specific error when a problem occurred during sending/previewing the media (e.g. email, sms)
	 * @param e
	 * @param methodName
	 * @param logger
	 * @throws ApplicationException
	 */
	public static void throwMediaException(Exception e, String methodName, Log logger) throws ApplicationException {
		
		String message = "while executing media service for :" + methodName;
		Throwable unknownHostException = getCauseException(e, UnknownHostException.class);
		if (unknownHostException != null) {
			message = "Unknown host " + unknownHostException.getMessage() + " called " + message;
		} else {
			message = "Error " + message;
		}
		if (logger != null) {
			if (logger.isErrorEnabled()) {
				logger.error(message, e);
			}
		}
		if (e instanceof WebServiceException) {
			if (unknownHostException != null) {
				throw new WebServiceUnknowHostException(message, e, unknownHostException.getMessage());
			}			
		}
	}

	/**
	 * Check whether the passed throwable (or it's cause or that's cause and so on) is assignable from the searched throwable If so, return
	 * that throwable otherwise if not found, return null
	 * 
	 * @param e the passed throwable of which we're check whether it (or it's cause) is assignable from the specified exception
	 * @param exceptionToSearch throwable to search
	 * @return Throwable if the passed throwable is instance of exceptionToSearch
	 */
	@SuppressWarnings("rawtypes")
	public static Throwable getCauseException(Throwable e, Class exceptionToSearch) {
		if (e.getClass().isAssignableFrom(exceptionToSearch)) {
			return e;
		}
		Throwable cause = e.getCause();
		if (cause == null || e.equals(cause)) {
			return null;
		}
		return getCauseException(cause, exceptionToSearch);
	}

	/**
	 * Indicates whether the exception is handled by AE
	 * 
	 * @param e the e
	 * @return boolean
	 */
	public static boolean isHandledException(Throwable e) {
		return e instanceof SearchTimeoutException || e instanceof NoResultsFoundException || e instanceof TooManyResultsFoundException || e instanceof ValueTooLargeException || e instanceof NumericValueOverflowException
				|| e instanceof NumericValueInvalidException;
	}

}