package example.notification.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import example.notification.properties.PropertyUtil;

public class LockNotificationUtil {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static int lockInterval = PropertyUtil.getInstance().getApplication().getInt(PropertyUtil.Application.APPLICATION_MESSAGE_LOCK, 60);

	public static final String LOCK_STATUS_UNLOCKED = "unlocked";
	public static final String LOCK_STATUS_LOCKED = "locked";
	public static final String LOCK_STATUS_UNLOCKABLE = "unlockable";

	public static boolean isLocked(String lockUsername) {
		return StringUtils.isNotEmpty(lockUsername);
	}

	public static boolean isLockOwned(String lockUsername, String loggedOnUser) {
		return isLocked(lockUsername) && StringUtils.equals(loggedOnUser, lockUsername);
	}

	public static boolean isUnlockable(Date lockTimestamp, String lockUsername, String loggedOnUser) {
		if (isLocked(lockUsername)) {
			if (isLockOwned(lockUsername, loggedOnUser)) {
				return true;
			} else {
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MINUTE, lockInterval * -1);
				return lockTimestamp.before(cal.getTime());
			}
		}
		return false;
	}

	public static String getLockStatus(Date lockTimestamp, String lockUsername, String loggedOnUser) {
		if (LockNotificationUtil.isLocked(lockUsername)) {
			if (LockNotificationUtil.isUnlockable(lockTimestamp, lockUsername, loggedOnUser)) {
				return LOCK_STATUS_UNLOCKABLE;
			} else {
				return LOCK_STATUS_LOCKED;
			}
		}
		return LOCK_STATUS_UNLOCKED;
	}

	public static String getLockInfo(Date lockTimestamp, String lockUsername) {
		if (LockNotificationUtil.isLocked(lockUsername)) {
			return "Locked by " + lockUsername + " on " + dateFormat.format(lockTimestamp);
		}
		return "";
	}
}
