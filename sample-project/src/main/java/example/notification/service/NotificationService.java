package example.notification.service;

import java.util.List;

import example.notification.dto.Notification;
import example.notification.exception.ApplicationException;

public interface NotificationService {

	public abstract void insertNotification(Notification notifications) throws ApplicationException;

	public abstract void deleteNotification(Notification notification) throws ApplicationException;

	public abstract List<Notification> listNotifications(long id) throws ApplicationException;

	public abstract void updateNotification(Notification notification) throws ApplicationException;

	public abstract Notification getNotification(long notificationId) throws ApplicationException;

}