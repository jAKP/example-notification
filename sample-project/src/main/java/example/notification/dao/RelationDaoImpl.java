package example.notification.dao;

import example.notification.dto.Relation;

/**
 * Class RelationDaoImpl
 * 
 * @author AlokPandey
 */
public class RelationDaoImpl extends AbstractDao implements RelationDao {

	@Override
	public Relation getRelationById(long id) {
		return (Relation) selectOne("getRelationById", id);
	}

}
