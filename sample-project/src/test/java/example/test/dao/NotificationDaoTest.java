package example.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import example.test.dto.Notification;
import junit.framework.TestCase;

public class NotificationDaoTest extends TestCase {

	@Autowired
	private NotificationDaoImpl notificationDao;

	@Test
	public void testGetNotification() {
		Notification notification = notificationDao.getNotification(1);
		assertEquals(notification.getNotficationId(), 1);
		assertEquals(notification.getNotificationMessage(), "test_message");
		assertEquals(notification.getNotificationType(), "test_type");
		assertEquals(notification.getNotificationSubject(), "test_subject");
	}

	@Test
	public void testInsertNotification() {
		Notification notif = new Notification.NotificationBuilder(1)
				.notificationType("test_type")
				.notificationSubject("test_subject")
				.notificationMessage("test_message")
				.build();

		notificationDao.insertNotification(notif);

		Notification notif1 = notificationDao.getNotification(notif.getNotficationId());

		assertEquals(notif1.getNotificationMessage(), notif.getNotificationMessage());
		assertEquals(notif1.getNotificationSubject(), notif.getNotificationSubject());
		assertEquals(notif1.getNotificationType(), notif.getNotificationType());
	}
}