package example.test.dao;

import example.test.dto.Relation;

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
