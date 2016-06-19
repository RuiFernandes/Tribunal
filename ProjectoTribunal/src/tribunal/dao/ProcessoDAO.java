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
import tribunal.entities.Processo;
import tribunal.entities.Requerente;
import tribunal.entities.Requerido;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Processo.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class ProcessoDAO {
	
	public final static String FIELD__ID = getField(Processo.class, "id");
	public final static String FIELD__NUMERO = getField(Processo.class, "numero");
	public final static String FIELD__DATA = getField(Processo.class, "data");
	public final static String FIELD__REQUERENTE = getField(Processo.class, "requerente");
	public final static String FIELD__REQUERIDO = getField(Processo.class, "requerido");
	public final static String FIELD__AUTO = getField(Processo.class, "auto");
	
	/**
	 * Creates a Processo using all read-only and all non-null properties.
	 */
	public Processo create(EntityManager em, String numero, Date data, Requerente requerente, Requerido requerido, String auto) {
		return create(em, numero, data, requerente, requerido, auto, null);
	}
	
	/**
	 * Creates a Processo using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Processo create(EntityManager em, String numero, Date data, Requerente requerente, Requerido requerido, String auto, IAction<Processo> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Processo newEntity = new Processo(numero, data, requerente, requerido, auto);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	public Processo get(EntityManager em, int id) {
		Processo entity = (Processo) em.find(Processo.class, id);
		return entity;
	}
	
	/**
	 * Returns the Processos with the given requerente.
	 */
	public List<Processo> getByRequerente(EntityManager em, Requerente requerente) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (requerente == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__REQUERENTE));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__REQUERENTE), requerente);
		}
		_query.where(_expression1);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns the Processos with the given requerido.
	 */
	public List<Processo> getByRequerido(EntityManager em, Requerido requerido) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (requerido == null) {
			_expression1 = _builder.isNull(_root.get(ProcessoDAO.FIELD__REQUERIDO));
		} else {
			_expression1 = _builder.equal(_root.get(ProcessoDAO.FIELD__REQUERIDO), requerido);
		}
		_query.where(_expression1);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getDataBefore(EntityManager em, Date _maxDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.lessThan(_root.<Date>get(ProcessoDAO.FIELD__DATA), _maxDate);
		_query.where(expression);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getDataAfter(EntityManager em, Date _minDate) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		Root<Processo> _root = _query.from(Processo.class);
		_query.select(_root);
		Expression<Boolean> expression = _builder.greaterThan(_root.<Date>get(ProcessoDAO.FIELD__DATA), _minDate);
		_query.where(expression);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAll(EntityManager em) {
		CriteriaQuery<Processo> _query = buildGetAllQuery(em);
		List<Processo> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Processo.
	 */
	public CriteriaQuery<Processo> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = builder.createQuery(Processo.class);
		Root<Processo> root = _query.from(Processo.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Processo> _query = _builder.createQuery(Processo.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Processo> _root = _query.from(Processo.class);
		Predicate[] _predicates = new Predicate[2];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(ProcessoDAO.FIELD__NUMERO), _builder.literal(_trimmedSearchString));
		_predicates[1] = _builder.like(_root.<java.lang.String>get(ProcessoDAO.FIELD__AUTO), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Processo> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Processo.
	 */
	public void delete(EntityManager em, Processo entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Processo> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Processo entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Processo.class.getName() + " WHERE " + ProcessoDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(p) from Processo as p";
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

