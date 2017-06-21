package example.notification.dao;

import java.util.List;

import example.notification.dto.Notification;

public interface NotificationDao {

	public Notification getNotification(long id);

	public void updateNotification(Notification notification);

	public void insertNotification(Notification notification);

	public void deleteNotification(Notification notification);

	List<Notification> listNotifications(long id) throws Exception;

	Notification getNotificationMessageLockInfo(long notificationId);

	int lockNotificationMessage(Notification notification);

	int unlockNotificationMessage(long notificationId);

}
