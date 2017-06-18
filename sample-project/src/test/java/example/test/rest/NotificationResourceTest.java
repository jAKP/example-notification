package example.test.rest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import example.notification.dto.Notification;
import example.notification.exception.ApplicationException;
import example.notification.service.NotificationService;
import example.notification.service.NotificationServiceImpl;

public class NotificationResourceTest {
	@Test
	public void testInsertNotification() throws ApplicationException {
		NotificationService service = new NotificationServiceImpl();
		Notification notification = new Notification.NotificationBuilder(1)
				.notificationType("test_type")
				.notificationSubject("test_subject")
				.notificationMessage("test_message")
				.build();

		service.insertNotification(notification);
		assertEquals(true, true);
	}
}
