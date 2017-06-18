package example.notification.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import example.notification.dao.RelationDao;
import example.notification.dto.Relation;
import example.notification.exception.AeExceptionUtil;
import example.notification.exception.ApplicationException;

/**
 * Class RelationServiceImpl
 * 
 * @author AlokPandey
 */
public class RelationServiceImpl implements RelationService {
	protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	private RelationDao relationDao;

	public Relation getRelation(long relId) throws ApplicationException {
		Relation relation = null;
		try {
			relation = getRelationDao().getRelationById(relId);
		} catch (Exception e) {
			AeExceptionUtil.throwPersistencyException(e, "service getRelation", log);
		}
		return relation;
	}

	public void setRelationDao(RelationDao relationDao) {
		this.relationDao = relationDao;
	}

	public RelationDao getRelationDao() {
		return relationDao;
	}

}
