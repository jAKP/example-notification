package example.notification.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import example.notification.dao.NotificationDaoImpl;
import example.notification.dto.Notification;
import example.notification.exception.AeExceptionUtil;
import example.notification.exception.ApplicationException;
import example.notification.exception.MessageLockedException;
import example.notification.util.LockNotificationUtil;

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

	/**
	 * Get the notification mesasge lock info for a given id
	 * 
	 * @param notification
	 *            the Notification dto
	 * @return notification
	 * @throws MessageLockedException
	 */
	public Notification getNotificationMessageLockInfo(Notification notification) throws MessageLockedException {
		notification = getNotificationDao().getNotificationMessageLockInfo(notification.getNotficationId());
		if (notification == null) {
			throw new MessageLockedException("Notification does not exists");
		}

		return notification;
	}

	/**
	 * Locks the notification for a given id
	 * 
	 * @param notification
	 *            the Notification dto
	 * @return notification
	 * @throws MessageLockedException
	 */
	public Notification lockNotificationMessage(Notification notification) throws MessageLockedException {
		Notification notificationOrig = (Notification) getNotificationMessageLockInfo(notification);
		if (LockNotificationUtil.isLocked(notificationOrig.getNotificationLockUser()) && !LockNotificationUtil
				.isLockOwned(notification.getNotificationLockUser(), notificationOrig.getNotificationLockUser())) {
			throw new MessageLockedException(
					"Notification message is Locked by user: " + notificationOrig.getNotificationLockUser());
		} else {
			notificationOrig.setNotificationLockUser(notification.getNotificationLockUser());
			notificationOrig.updateLockTimestamp();
			getNotificationDao().lockNotificationMessage(notification);
		}

		return notification;
	}

	/**
	 * Unlocks the notification for a given id
	 * 
	 * @param notification
	 *            the Notification dto
	 * @return notification
	 * @throws MessageLockedException
	 */
	public Notification unlockNotificationMessage(Notification notification) throws MessageLockedException {
		Notification notificationOrig = null;
		notificationOrig = (Notification) getNotificationMessageLockInfo(notification);
		if (LockNotificationUtil.isLocked(notification.getNotificationLockUser())) {
			if (!LockNotificationUtil.isUnlockable(notification.getNotificationLockTimestamp(),
					notification.getNotificationLockUser(), notification.getNotificationLockUser())) {
				throw new MessageLockedException(
						"Notification message is Locked by user: " + notificationOrig.getNotificationLockUser());
			}
			getNotificationDao().unlockNotificationMessage(notification.getNotficationId());
		}
		return notification;
	}

	public NotificationDaoImpl getNotificationDao() {
		return notificationDao;
	}

	public void setNotificationDao(NotificationDaoImpl notificationDao) {
		this.notificationDao = notificationDao;
	}

}