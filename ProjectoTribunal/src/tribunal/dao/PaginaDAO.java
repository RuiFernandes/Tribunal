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
import tribunal.entities.Pagina;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Pagina.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class PaginaDAO {
	
	public final static String FIELD__ID = getField(Pagina.class, "id");
	public final static String FIELD__PAG = getField(Pagina.class, "pag");
	
	/**
	 * Creates a Pagina using all read-only and all non-null properties.
	 */
	public Pagina create(EntityManager em, String pag) {
		return create(em, pag, null);
	}
	
	/**
	 * Creates a Pagina using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Pagina create(EntityManager em, String pag, IAction<Pagina> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Pagina newEntity = new Pagina(pag);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina get(EntityManager em, int id) {
		Pagina entity = (Pagina) em.find(Pagina.class, id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAll(EntityManager em) {
		CriteriaQuery<Pagina> _query = buildGetAllQuery(em);
		List<Pagina> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Pagina.
	 */
	public CriteriaQuery<Pagina> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Pagina> _query = builder.createQuery(Pagina.class);
		Root<Pagina> root = _query.from(Pagina.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Pagina> _query = _builder.createQuery(Pagina.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Pagina> _root = _query.from(Pagina.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(PaginaDAO.FIELD__PAG), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Pagina> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Pagina.
	 */
	public void delete(EntityManager em, Pagina entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Pagina> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Pagina entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Pagina.class.getName() + " WHERE " + PaginaDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(p) from Pagina as p";
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

