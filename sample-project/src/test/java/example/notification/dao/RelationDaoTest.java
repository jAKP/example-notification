package example.notification.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import example.notification.dao.RelationDaoImpl;
import example.notification.dto.Relation;
import junit.framework.TestCase;

public class RelationDaoTest extends TestCase {

	@Autowired
	private RelationDaoImpl relationDao;

	@Test
	public void testGetRelation() {
		Relation relation = relationDao.getRelationById(1);
		assertEquals(relation.getRelationId(), 1);
		assertEquals(relation.getCity(), "test_city");
		assertEquals(relation.getCountry(), "test_country");
		assertEquals(relation.getFirstName(), "test_first_name");
		assertEquals(relation.getLastName(), "test_last_name");
		assertEquals(relation.getPoBox(), "test_pobox");
		assertEquals(relation.getStreet(), "test_street");
		assertEquals(relation.getZipCode(), "test_zip_code");
	}

}