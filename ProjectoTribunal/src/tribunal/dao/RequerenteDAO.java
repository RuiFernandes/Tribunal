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
import tribunal.entities.Requerente;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Requerente.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class RequerenteDAO {
	
	public final static String FIELD__ID = getField(Requerente.class, "id");
	public final static String FIELD__NOME = getField(Requerente.class, "nome");
	
	/**
	 * Creates a Requerente using all read-only and all non-null properties.
	 */
	public Requerente create(EntityManager em, String nome) {
		return create(em, nome, null);
	}
	
	/**
	 * Creates a Requerente using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Requerente create(EntityManager em, String nome, IAction<Requerente> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Requerente newEntity = new Requerente(nome);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Requerente with the given id.
	 */
	public Requerente get(EntityManager em, int id) {
		Requerente entity = (Requerente) em.find(Requerente.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Requerente.
	 */
	public List<Requerente> getAll(EntityManager em) {
		CriteriaQuery<Requerente> _query = buildGetAllQuery(em);
		List<Requerente> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Requerente.
	 */
	public CriteriaQuery<Requerente> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Requerente> _query = builder.createQuery(Requerente.class);
		Root<Requerente> root = _query.from(Requerente.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Requerente.
	 */
	public List<Requerente> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Requerente> _query = _builder.createQuery(Requerente.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Requerente> _root = _query.from(Requerente.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(RequerenteDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Requerente> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Requerente.
	 */
	public void delete(EntityManager em, Requerente entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Requerente> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Requerente entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Requerente.class.getName() + " WHERE " + RequerenteDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Requerente entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(r) from Requerente as r";
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

