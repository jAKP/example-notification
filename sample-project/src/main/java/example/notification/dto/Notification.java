package example.notification.dto;

public class Notification {

	private long notficationId;
	private String notificationMessage;
	private String notificationType;
	private String notificationSubject;

	private Notification(NotificationBuilder builder) {
		this.notficationId = builder.notficationId;
		this.notificationMessage = builder.notificationMessage;
		this.notificationType = builder.notificationType;
		this.notificationSubject = builder.notificationSubject;
	}

	public static class NotificationBuilder {
		private long notficationId;
		private String notificationMessage;
		private String notificationType;
		private String notificationSubject;

		public NotificationBuilder(long notficationId) {
			this.notficationId = notficationId;
		}

		public NotificationBuilder notificationMessage(String notificationMessage) {
			this.notificationMessage = notificationMessage;
			return this;
		}

		public NotificationBuilder notificationType(String notificationType) {
			this.notificationType = notificationType;
			return this;
		}

		public NotificationBuilder notificationSubject(String notificationSubject) {
			this.notificationSubject = notificationSubject;
			return this;
		}

		public Notification build() {
			return new Notification(this);
		}

	}

	public long getNotficationId() {
		return notficationId;
	}

	public void setNotficationId(long notficationId) {
		this.notficationId = notficationId;
	}

	public String getNotificationMessage() {
		return notificationMessage;
	}

	public void setNotificationMessage(String notificationMessage) {
		this.notificationMessage = notificationMessage;
	}

	public String getNotificationType() {
		return notificationType;
	}

	public void setNotificationType(String notificationType) {
		this.notificationType = notificationType;
	}

	public String getNotificationSubject() {
		return notificationSubject;
	}

	public void setNotificationSubject(String notificationSubject) {
		this.notificationSubject = notificationSubject;
	}

}
