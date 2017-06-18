package example.notification.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import example.notification.dao.NotificationDaoImpl;
import example.notification.dto.Notification;
import example.notification.exception.AeExceptionUtil;
import example.notification.exception.ApplicationException;

/**
 * Class NotificationServiceImpl
 * 
 * @author AlokPandey
 */
public class NotificationServiceImpl implements NotificationService {
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private NotificationDaoImpl notificationDao;

	@Override
	public void insertNotification(Notification notification) throws ApplicationException {
		try {
			getNotificationDao().insertNotification(notification);
		} catch (Exception e) {
			AeExceptionUtil.throwPersistencyException(e, "service insertNotification", log);
		}
	}

	@Override
	public void deleteNotification(Notification notification) throws ApplicationException {
		try {
			getNotificationDao().deleteNotification(notification);
		} catch (Exception e) {
			AeExceptionUtil.throwPersistencyException(e, "service deleteNotification", log);
		}
	}

	@Override
	public Notification getNotification(long notificationId) throws ApplicationException {
		Notification notification = null;
		try {
			notification = getNotificationDao().getNotification(notificationId);
		} catch (Exception e) {
			AeExceptionUtil.throwPersistencyException(e, "service getNotification", log);
		}
		return notification;
	}
	
	@Override
	public List<Notification> listNotifications(long id) throws ApplicationException {
		List<Notification> notifications = null;
		try {
			notifications = getNotificationDao().listNotifications(id);
		} catch (Exception e) {
			AeExceptionUtil.throwReadException(e, "service listNotifications", log);
		}
		return notifications;
	}

	@Override
	public void updateNotification(Notification notification) throws ApplicationException {
		try {
			getNotificationDao().updateNotification(notification);
		} catch (Exception e) {
			AeExceptionUtil.throwPersistencyException(e, "updateNotification", log);
		}

	}

	public NotificationDaoImpl getNotificationDao() {
		return notificationDao;
	}

	public void setNotificationDao(NotificationDaoImpl notificationDao) {
		this.notificationDao = notificationDao;
	}

}