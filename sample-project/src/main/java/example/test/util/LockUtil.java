package example.test.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import example.test.properties.PropertyUtil;

public class LockUtil {
	private static final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm");
	private static int lockIntervalInMinutes = PropertyUtil.getInstance().getApplication()
			.getInt(PropertyUtil.Application.APPLICATION_MESSAGE_LOCK, 60);

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
				cal.add(Calendar.MINUTE, lockIntervalInMinutes * -1);
				return lockTimestamp.before(cal.getTime());
			}
		}
		return false;
	}

	public static String getLockStatus(Date lockTimestamp, String lockUsername, String loggedOnUser) {
		if (LockUtil.isLocked(lockUsername)) {
			if (LockUtil.isUnlockable(lockTimestamp, lockUsername, loggedOnUser)) {
				return LOCK_STATUS_UNLOCKABLE;
			} else {
				return LOCK_STATUS_LOCKED;
			}
		}
		return LOCK_STATUS_UNLOCKED;
	}

	public static String getLockInfo(Date lockTimestamp, String lockUsername) {
		if (LockUtil.isLocked(lockUsername)) {
			return "Locked by " + lockUsername + " on " + dateFormat.format(lockTimestamp);
		}
		return "";
	}
}
