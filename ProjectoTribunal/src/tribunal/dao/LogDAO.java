package tribunal.dao;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tribunal.entities.Log;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Log.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class LogDAO {
	
	public final static String FIELD__ID = getField(Log.class, "id");
	public final static String FIELD__DATA = getField(Log.class, "data");
	public final static String FIELD__LOG = getField(Log.class, "log");
	
	/**
	 * Creates a Log using all read-only and all non-null properties.
	 */
	public Log create(EntityManager em, Date data, String log) {
		return create(em, data, log, null);
	}
	
	/**
	 * Creates a Log using all read-only and all non-null properties. The per-persist
	 * action is executed before the entity is persisted and allows to set properties
	 * which are not read-only or nullable.
	 */
	public Log create(EntityManager em, Date data, String log, IAction<Log> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Log newEntity = new Log(data, log);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log get(EntityManager em, int id) {
		Log entity = (Log) em.find(Log.class, id);
		return entity;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getDataBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Log> _query = _builder.createQuery(Log.class);
		Root<Log> _root = _query.from(Log.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(LogDAO.FIELD__DATA), _maxDate);
		_query.where(expression);
		List<Log> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getDataAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Log> _query = _builder.createQuery(Log.class);
		Root<Log> _root = _query.from(Log.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(LogDAO.FIELD__DATA), _minDate);
		_query.where(expression);
		List<Log> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAll(EntityManager em) {
		CriteriaQuery<Log> _query = buildGetAllQuery(em);
		List<Log> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Log.
	 */
	public CriteriaQuery<Log> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Log> _query = builder.createQuery(Log.class);
		Root<Log> root = _query.from(Log.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Log> _query = _builder.createQuery(Log.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Log> _root = _query.from(Log.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(LogDAO.FIELD__LOG), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Log> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Log.
	 */
	public void delete(EntityManager em, Log entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Log> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Log entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Log.class.getName() + " WHERE " + LogDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(l) from Log as l";
		Object first = em.createQuery(query).getResultList().get(0);
		if (first instanceof Long) {
			return ((Long) first).intValue();
		}
		throw new RuntimeException("Unexpected result for count query: " + first);
	}
	
	protected static String getField(Class<?> clazz, String fieldName) {
		try {
			return clazz.getDeclaredField(fieldName).getName();
		} catch (SecurityException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		} catch (NoSuchFieldException e) {
			throw new RuntimeException(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
	}
}

