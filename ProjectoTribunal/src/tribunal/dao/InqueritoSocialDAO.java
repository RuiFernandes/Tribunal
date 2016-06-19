package tribunal.dao;

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
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Processo;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type InqueritoSocial.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class InqueritoSocialDAO {
	
	public final static String FIELD__ID = getField(InqueritoSocial.class, "id");
	public final static String FIELD__PROCESSO = getField(InqueritoSocial.class, "processo");
	public final static String FIELD__ASSISTENTESOCIAL = getField(InqueritoSocial.class, "assistenteSocial");
	
	/**
	 * Creates a InqueritoSocial using all read-only and all non-null properties.
	 */
	public InqueritoSocial create(EntityManager em, Processo processo, String assistenteSocial) {
		return create(em, processo, assistenteSocial, null);
	}
	
	/**
	 * Creates a InqueritoSocial using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public InqueritoSocial create(EntityManager em, Processo processo, String assistenteSocial, IAction<InqueritoSocial> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		InqueritoSocial newEntity = new InqueritoSocial(processo, assistenteSocial);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial get(EntityManager em, int id) {
		InqueritoSocial entity = (InqueritoSocial) em.find(InqueritoSocial.class, id);
		return entity;
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getByProcesso(EntityManager em, Processo processo) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<InqueritoSocial> _query = _builder.createQuery(InqueritoSocial.class);
		Root<InqueritoSocial> _root = _query.from(InqueritoSocial.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (processo == null) {
			_expression1 = _builder.isNull(_root.get(InqueritoSocialDAO.FIELD__PROCESSO));
		} else {
			_expression1 = _builder.equal(_root.get(InqueritoSocialDAO.FIELD__PROCESSO), processo);
		}
		_query.where(_expression1);
		List<InqueritoSocial> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAll(EntityManager em) {
		CriteriaQuery<InqueritoSocial> _query = buildGetAllQuery(em);
		List<InqueritoSocial> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type InqueritoSocial.
	 */
	public CriteriaQuery<InqueritoSocial> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<InqueritoSocial> _query = builder.createQuery(InqueritoSocial.class);
		Root<InqueritoSocial> root = _query.from(InqueritoSocial.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<InqueritoSocial> _query = _builder.createQuery(InqueritoSocial.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<InqueritoSocial> _root = _query.from(InqueritoSocial.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(InqueritoSocialDAO.FIELD__ASSISTENTESOCIAL), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<InqueritoSocial> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a InqueritoSocial.
	 */
	public void delete(EntityManager em, InqueritoSocial entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<InqueritoSocial> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (InqueritoSocial entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + InqueritoSocial.class.getName() + " WHERE " + InqueritoSocialDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(i) from InqueritoSocial as i";
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

