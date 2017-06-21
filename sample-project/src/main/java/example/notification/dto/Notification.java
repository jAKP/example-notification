package example.notification.dto;

import java.util.Date;

public class Notification {

	private long notficationId;
	private String notificationMessage;
	private String notificationType;
	private String notificationSubject;
	private String notificationLockUser;
	private Date notificationLockTimestamp;

	private Notification(NotificationBuilder builder) {
		this.notficationId = builder.notficationId;
		this.notificationMessage = builder.notificationMessage;
		this.notificationType = builder.notificationType;
		this.notificationSubject = builder.notificationSubject;
		this.notificationLockUser = builder.notificationLockUser;
		this.notificationLockTimestamp = builder.notificationLockTimestamp;
	}

	public static class NotificationBuilder {
		private long notficationId;
		private String notificationMessage;
		private String notificationType;
		private String notificationSubject;
		private String notificationLockUser;
		private Date notificationLockTimestamp;

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

		public NotificationBuilder notificationLockUser(String notificationLockUser) {
			this.notificationLockUser = notificationLockUser;
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

	public String getNotificationLockUser() {
		return notificationLockUser;
	}

	public void setNotificationLockUser(String notificationLockUser) {
		this.notificationLockUser = notificationLockUser;
	}

	public Date getNotificationLockTimestamp() {
		return notificationLockTimestamp;
	}

	public void setNotificationLockTimestamp(Date notificationLockTimestamp) {
		this.notificationLockTimestamp = notificationLockTimestamp;
	}
	
	public void updateLockTimestamp() {
		setNotificationLockTimestamp(new Date());
	}


}
