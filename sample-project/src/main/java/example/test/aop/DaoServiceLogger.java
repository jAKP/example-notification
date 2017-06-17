package example.test.aop;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/**
 * The Class DaoServiceLogger
 * 
 * @author AlokPandey
 */
public class DaoServiceLogger {
	protected final Log log = LogFactory.getLog(getClass());

	public Object doLog(ProceedingJoinPoint pjp) throws Throwable {
		log.info("Start: " + pjp.toShortString());
		StopWatch watch = new StopWatch();
		try {
			watch.start();
			Object result = pjp.proceed();
			if (result instanceof List) {
				@SuppressWarnings("rawtypes")
				List list = (List) result;
				log.info("Number of results from query : " + list.size());
			}
			watch.stop();
			log.info("End: " + pjp.toShortString());
			log.info("time taken: " + watch.getTotalTimeSeconds() + " seconds for successful call : " + pjp.toShortString());
			return result;
		} catch (Throwable t) {
			watch.stop();
			log.error("time taken: " + watch.getTotalTimeSeconds() + " seconds for unsuccessful call : " + pjp.toShortString());
			log.error("Exception: " + pjp.toLongString() + ": " + t);
			throw t;
		}
	}
}
