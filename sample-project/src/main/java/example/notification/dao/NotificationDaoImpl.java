package example.notification.dao;

import java.util.List;

import example.notification.dto.Notification;

/**
 * Class NotificationDaoImpl
 * 
 * @author AlokPandey
 */
public class NotificationDaoImpl extends AbstractDao implements NotificationDao {

	@Override
	public Notification getNotification(long id) {
		return (Notification) selectOne("getNotification", id);
	}

	@Override
	public void insertNotification(Notification notification) {
		insert("insertNotification", notification);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Notification> listNotifications(long id) throws Exception {
		return selectList("listNotifications", id);
	}

	@Override
	public void updateNotification(Notification notification) {
		update("updateNotification", notification);
	}

	@Override
	public void deleteNotification(Notification notification) {
		delete("deleteNotification", notification);
	}

}
