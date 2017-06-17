package example.test.rest;

import org.springframework.beans.factory.annotation.Autowired;

import example.test.properties.PropertyUtil;
import example.test.service.NotificationService;
import example.test.service.RelationService;

public abstract class AbstractResource {

	@Autowired
	NotificationService notificationService;

	@Autowired
	RelationService relationService;

	public static String getHostUrl() {
		return PropertyUtil.getInstance().getEnvironment().getString(PropertyUtil.Environment.ENVIRONMENT_URL);
	}

	public RelationService getRelationService() {
		return relationService;
	}

	public void setRelationService(RelationService relationService) {
		this.relationService = relationService;
	}

	public NotificationService getNotificationService() {
		return notificationService;
	}

	public void setNotificationService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}

}