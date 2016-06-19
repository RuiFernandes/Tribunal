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
import tribunal.entities.Livro;
import tribunal.entities.Processo;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model for type Livro.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public class LivroDAO {
	
	public final static String FIELD__ID = getField(Livro.class, "id");
	public final static String FIELD__NOME = getField(Livro.class, "nome");
	public final static String FIELD__PROCESSO = getField(Livro.class, "processo");
	
	/**
	 * Creates a Livro using all read-only and all non-null properties.
	 */
	public Livro create(EntityManager em, String nome, Processo processo) {
		return create(em, nome, processo, null);
	}
	
	/**
	 * Creates a Livro using all read-only and all non-null properties. The
	 * per-persist action is executed before the entity is persisted and allows to set
	 * properties which are not read-only or nullable.
	 */
	public Livro create(EntityManager em, String nome, Processo processo, IAction<Livro> prePersistAction) {
		@java.lang.SuppressWarnings("deprecation")
		Livro newEntity = new Livro(nome, processo);
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		em.persist(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	public Livro get(EntityManager em, int id) {
		Livro entity = (Livro) em.find(Livro.class, id);
		return entity;
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getByNome(EntityManager _em, String nome) {
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Livro> _query = _builder.createQuery(Livro.class);
		Root<Livro> _root = _query.from(Livro.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (nome == null) {
			_expression1 = _builder.isNull(_root.get(LivroDAO.FIELD__NOME));
		} else {
			_expression1 = _builder.equal(_root.get(LivroDAO.FIELD__NOME), nome);
		}
		_query.where(_expression1);
		List<Livro> _entities = _em.createQuery(_query).getResultList();
		if (_entities != null && !_entities.isEmpty()) {
			return _entities.get(0);
		}
		return null;
	}
	
	/**
	 * Returns the Livros with the given processo.
	 */
	public List<Livro> getByProcesso(EntityManager em, Processo processo) {
		CriteriaBuilder _builder = em.getCriteriaBuilder();
		CriteriaQuery<Livro> _query = _builder.createQuery(Livro.class);
		Root<Livro> _root = _query.from(Livro.class);
		_query.select(_root);
		Expression<Boolean> _expression1;
		if (processo == null) {
			_expression1 = _builder.isNull(_root.get(LivroDAO.FIELD__PROCESSO));
		} else {
			_expression1 = _builder.equal(_root.get(LivroDAO.FIELD__PROCESSO), processo);
		}
		_query.where(_expression1);
		List<Livro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAll(EntityManager em) {
		CriteriaQuery<Livro> _query = buildGetAllQuery(em);
		List<Livro> entities = em.createQuery(_query).getResultList();
		return entities;
	}
	
	/**
	 * Builds a query that fetches all entities of type Livro.
	 */
	public CriteriaQuery<Livro> buildGetAllQuery(EntityManager em) {
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Livro> _query = builder.createQuery(Livro.class);
		Root<Livro> root = _query.from(Livro.class);
		_query.select(root);
		return _query;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> search(EntityManager _em, String _searchString, int _maxResults) {
		if (_searchString == null) {
			throw new IllegalArgumentException("_searchString must not be null.");
		}
		
		CriteriaBuilder _builder = _em.getCriteriaBuilder();
		CriteriaQuery<Livro> _query = _builder.createQuery(Livro.class);
		
		// Create disjunction of all string properties.
		java.lang.String _trimmedSearchString = "%" + _searchString.trim() + "%";
		Root<Livro> _root = _query.from(Livro.class);
		Predicate[] _predicates = new Predicate[1];
		_predicates[0] = _builder.like(_root.<java.lang.String>get(LivroDAO.FIELD__NOME), _builder.literal(_trimmedSearchString));
		_query.where(_builder.or(_predicates));
		
		List<Livro> entities = _em.createQuery(_query).setMaxResults(_maxResults).getResultList();
		return entities;
	}
	
	/**
	 * Deletes a Livro.
	 */
	public void delete(EntityManager em, Livro entity) {
		em.remove(entity);
	}
	
	/**
	 * Deletes all given entities.
	 */
	public void delete(EntityManager em, List<Livro> entities) {
		if (entities == null || entities.isEmpty()) {
			// Nothing to do.
			return;
		}
		
		final String ID_LIST = "ids";
		Set<Integer> ids = new LinkedHashSet<Integer>(entities.size());
		for (Livro entity : entities) {
			ids.add(entity.getId());
		}
		String queryString = "DELETE FROM " + Livro.class.getName() + " WHERE " + LivroDAO.FIELD__ID + " IN (:" + ID_LIST + ")";
		Query _query = em.createQuery(queryString);
		_query.setParameter(ID_LIST, ids);
		_query.executeUpdate();
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int count(EntityManager em) {
		String query = "select count(l) from Livro as l";
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

