package example.test.dao;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DataAccessException;

/**
 * The Class AbstractDao.
 * 
 * @author AlokPandey
 * 
 */
@SuppressWarnings({ "rawtypes" })
public abstract class AbstractDao extends SqlSessionDaoSupport {

	/**
	 * Query for list.
	 * 
	 * @param statement
	 *            the statement
	 * @return the list
	 * @throws Exception
	 */
	protected List selectList(final String statement) throws Exception {
		return getSqlSession().selectList(statement);
	}

	/**
	 * Query for list.
	 * 
	 * @param statement
	 *            the statement
	 * @param param
	 *            the param
	 * @return the list
	 * @throws Exception
	 */
	protected List selectList(final String statement, final Object param) throws Exception {
		return getSqlSession().selectList(statement, param);
	}


	/**
	 * Query for object.
	 * 
	 * @param statement
	 *            the statement
	 * @param param
	 *            the paramABC
	 * @return the object
	 */
	protected Object selectOne(final String statement, final Object param) throws DataAccessException {
		return getSqlSession().selectOne(statement, param);
	}

	/**
	 * Query for object.
	 * 
	 * @param statement
	 *            the statement
	 * @param param
	 *            the param
	 * @return the object
	 */
	protected Object selectOne(final String statement) throws DataAccessException {
		return getSqlSession().selectOne(statement, "dummy");
	}

	/**
	 * Call an insert sql statement
	 * 
	 * @param statementName
	 *            the statement name
	 * @param parameterObject
	 *            the parameter object
	 * @return int
	 * @throws DataAccessException
	 *             the data access exception
	 */
	protected int insert(final String statementName, final Object parameterObject) throws DataAccessException {
		return getSqlSession().insert(statementName, parameterObject);
	}

	/**
	 * Call an update sql statement and log the number of updated rows.
	 * 
	 * @param statementName
	 *            the statement name
	 * @return int
	 * @throws DataAccessException
	 *             the data access exception
	 */
	protected int update(String statementName) throws DataAccessException {
		return update(statementName, null);
	}

	/**
	 * Call an update sql statement and log the number of updated rows.
	 * 
	 * @param statementName
	 *            the statement name
	 * @param parameterObject
	 *            the parameter object
	 * @return int
	 * @throws DataAccessException
	 *             the data access exception
	 */
	protected int update(final String statementName, final Object parameterObject) throws DataAccessException {
		int count = getSqlSession().update(statementName, parameterObject);
		logger.debug("Number of updated records is " + count);
		return count;
	}

	/**
	 * Call a delete sql statement and log the number of deleted rows.
	 * 
	 * @param statementName
	 *            the statement name
	 * @return int
	 * @throws DataAccessException
	 *             the data access exception
	 */
	protected int delete(String statementName) throws DataAccessException {
		return delete(statementName, null);
	}

	/**
	 * Call a delete sql statement and log the number of deleted rows.
	 * 
	 * @param statementName
	 *            the statement name
	 * @param parameterObject
	 *            the parameter object
	 * @return int
	 * @throws DataAccessException
	 *             the data access exception
	 */
	protected int delete(final String statementName, final Object parameterObject) throws DataAccessException {
		int count = getSqlSession().delete(statementName, parameterObject);
		logger.debug("Number of deleted records is " + count);
		return count;
	}

}
