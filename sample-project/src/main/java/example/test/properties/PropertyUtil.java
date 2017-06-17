package example.test.properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PropertyUtil {
	private static Log logger = LogFactory.getLog(PropertyUtil.class);
	private static PropertyUtil instance = null;
	private static PropertiesConfiguration environment;
	private static PropertiesConfiguration application;

	private PropertyUtil() {
		// Exists only to defeat instantiation.
	}

	public static PropertyUtil getInstance() {
		if (instance == null) {
			instance = new PropertyUtil();
			try {
				environment = new PropertiesConfiguration("environment.properties");
				application = new PropertiesConfiguration("application.properties");
			} catch (ConfigurationException e) {
				logger.error("ConfigurationException", e);
			}
		}
		return instance;
	}

	public PropertiesConfiguration getEnvironment() {
		return environment;
	}

	public PropertiesConfiguration getApplication() {
		return application;
	}

	public static class Environment {
		public final static String ENVIRONMENT_ID = "environment.version";
		public final static String ENVIRONMENT_URL = "environment.url";
		public final static String ENVIRONMENT_URL_WEBAPI = "environment.url.webapi";
	}

	public static class Application {
		public final static String APPLICATION_VERSION = "application.version";
		public final static String APPLICATION_DATASOURCE = "application.datasource.a";
		public final static String APPLICATION_MESSAGE_LOCK = "application.message.lock.minutes";
	}

}
