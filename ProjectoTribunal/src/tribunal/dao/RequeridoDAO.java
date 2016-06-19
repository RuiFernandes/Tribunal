package tribunal.dao;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import tribunal.entities.Requerido;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Requerido.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class RequeridoDAO {
	
	public final static String FIELD__ID = getField(Requerido.class, "id");
	public final static String FIELD__NOME = getField(Requerido.class, "nome");
	
	/**
	 * Creates a Requerido using all read-only and all non-null properties.
	 */
	public Requerido create(EntityManager em, String nome) {
		return create(em, nome, null);
	}
	
	/**
	 * Creates a Requerido using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Requerido create(EntityManager em, String nome, IAction<Requerido> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Requerido newEntity = new Requerido(nome);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Requerido with the given id.
	 */
	public Requerido get(EntityManager em, int id) {
		Requerido entity = (Requerido) em.find(Requerido.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Requerido.
	 */
	public List<Requerido> getAll(EntityManager em) {
		CriteriaQuery<Requerido> _query = buildGetAllQuery(em);
		List<Requerido> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Requerido.
	 */
	public CriteriaQuery<Requerido> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Requerido> _query = builder.createQuery(Requerido.class);
		Root<Requerido> root = _query.from(Requerido.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Requerido.
	 */
	public List<Requerido> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Requerido> _query = _builder.createQuery(Requerido.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Requerido> _root = _query.from(Requerido.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(RequeridoDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Requerido> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Requerido.
	 */
	public void delete(EntityManager em, Requerido entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Requerido> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Requerido entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Requerido.class.getName() + " WHERE " + RequeridoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Requerido entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(r) from Requerido as r";
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

