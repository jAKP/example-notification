package example.notification.rest;

import org.springframework.beans.factory.annotation.Autowired;

import example.notification.properties.PropertyUtil;
import example.notification.service.NotificationService;
import example.notification.service.RelationService;

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