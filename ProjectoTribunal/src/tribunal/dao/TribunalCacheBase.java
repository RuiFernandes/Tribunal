package tribunal.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import tribunal.custom.IDBOperations;
import tribunal.dao.ICommand;
import tribunal.dao.IDBOperationsBase;
import tribunal.dao.IFunction;
import tribunal.dao.ITransactionalRunner;
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Livro;
import tribunal.entities.Log;
import tribunal.entities.Pagina;
import tribunal.entities.Processo;
import tribunal.entities.Requerente;
import tribunal.entities.Requerido;
import tribunal.entities.Usuario;

// This class is generated. Any change will be overridden.
public abstract class TribunalCacheBase implements IDBOperationsBase, ITransactionalRunner {
	
	protected IDBOperations delegate;
	
	private int nextUsuarioID = 1;
	private int nextLivroID = 1;
	private int nextPaginaID = 1;
	private int nextProcessoID = 1;
	private int nextRequerenteID = 1;
	private int nextRequeridoID = 1;
	private int nextInqueritoSocialID = 1;
	private int nextLogID = 1;
	
	private Set<Usuario> cachedUsuario = null;
	
	private Set<Livro> cachedLivro = null;
	
	private Set<Pagina> cachedPagina = null;
	
	private Set<Processo> cachedProcesso = null;
	
	private Set<Requerente> cachedRequerente = null;
	
	private Set<Requerido> cachedRequerido = null;
	
	private Set<InqueritoSocial> cachedInqueritoSocial = null;
	
	private Set<Log> cachedLog = null;
	
	/**
	 * <p>
	 * Creates a new TribunalCacheBase.
	 * </p>
	 * 
	 * <p>
	 * If the delegate is not null, it is used to obtain entities by means of the
	 * getAll() methods. Once the objects are obtained, they are stored in memory and
	 * returned directly upon future calls.
	 * </p>
	 * 
	 * <p>
	 * The delegate can also be null. In this case, the cache can serve as in-memory
	 * replacement for the database, which is quite useful to write fast test cases.
	 * </p>
	 */
	public TribunalCacheBase(IDBOperations delegate) {
		super();
		this.delegate = delegate;
	}
	
	public void flush() {
		if (delegate == null) {
			return;
		}
		delegate.flush();
	}
	
	/**
	 * Returns all entities that are stored in the cache.
	 */
	public List<java.lang.Object> getAll() {
		final List<java.lang.Object> entities = new ArrayList<java.lang.Object>();
		entities.addAll(getAllUsuarios());
		entities.addAll(getAllLivros());
		entities.addAll(getAllPaginas());
		entities.addAll(getAllProcessos());
		entities.addAll(getAllRequerentes());
		entities.addAll(getAllRequeridos());
		entities.addAll(getAllInqueritoSocials());
		entities.addAll(getAllLogs());
		return entities;
	}
	
	/**
	 * Removes all entities that are stored from the cache.
	 */
	public void removeAll() {
		if (cachedUsuario != null) {
			cachedUsuario.clear();
		}
		if (cachedLivro != null) {
			cachedLivro.clear();
		}
		if (cachedPagina != null) {
			cachedPagina.clear();
		}
		if (cachedProcesso != null) {
			cachedProcesso.clear();
		}
		if (cachedRequerente != null) {
			cachedRequerente.clear();
		}
		if (cachedRequerido != null) {
			cachedRequerido.clear();
		}
		if (cachedInqueritoSocial != null) {
			cachedInqueritoSocial.clear();
		}
		if (cachedLog != null) {
			cachedLog.clear();
		}
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria) {
		return createUsuario(nome, dataDeNascimento, username, password, categoria, null);
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria, final IAction<Usuario> prePersistAction) {
		
		Usuario newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextUsuarioID;
			nextUsuarioID++;
			@java.lang.SuppressWarnings("deprecation")
			Usuario newUsuario = new Usuario(nome, dataDeNascimento, username, password, categoria) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setUsername(String newValue) {
					checkUniqueUsuarioUsername(this, newValue);
					super.setUsername(newValue);
				}
				
			};
			newEntity = newUsuario;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueUsuario(newEntity);
		} else {
			newEntity = delegate.createUsuario(nome, dataDeNascimento, username, password, categoria);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getUsuarioCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username) {
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			Object usernameValue = concreteNext.getUsername();
			if (isSameValue(username, usernameValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (!(next instanceof Usuario)) {
				continue;
			}
			Usuario concreteNext = (Usuario) next;
			Date value = concreteNext.getDataDeNascimento();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario next : cache) {
			if (!(next instanceof Usuario)) {
				continue;
			}
			Usuario concreteNext = (Usuario) next;
			Date value = concreteNext.getDataDeNascimento();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios() {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		List<Usuario> result = new ArrayList<Usuario>();
		Set<Usuario> cache = _getUsuarioCache();
		for (Usuario concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String username = concreteNext.getUsername();
				if (username != null && username.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String password = concreteNext.getPassword();
				if (password != null && password.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String categoria = concreteNext.getCategoria();
				if (categoria != null && categoria.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity) {
		// Check whether entity is contained in cache
		if (!_getUsuarioCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getUsuarioCache().remove(entity);
	}
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities) {
		for (Usuario entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		_getUsuarioCache().removeAll(getUsuariosWithDataDeNascimentoBefore(_maxDate));
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		_getUsuarioCache().removeAll(getUsuariosWithDataDeNascimentoAfter(_minDate));
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios() {
		return _getUsuarioCache().size();
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo) {
		return createLivro(nome, processo, null);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo, final IAction<Livro> prePersistAction) {
		
		Livro newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(processo, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextLivroID;
			nextLivroID++;
			@java.lang.SuppressWarnings("deprecation")
			Livro newLivro = new Livro(nome, processo) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setNome(String newValue) {
					checkUniqueLivroNome(this, newValue);
					super.setNome(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setProcesso(Processo newValue) {
					checkPersisted(newValue, false);
					super.setProcesso(newValue);
				}
				
			};
			newEntity = newLivro;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueLivro(newEntity);
		} else {
			newEntity = delegate.createLivro(nome, processo);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getLivroCache().add(newEntity);
		
		// Notify uniqueness listener
		TribunalListenerRegistry.notifyUniquenessAccess(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		Set<Livro> cache = _getLivroCache();
		for (Livro next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		Set<Livro> cache = _getLivroCache();
		for (Livro concreteNext : cache) {
			Object nomeValue = concreteNext.getNome();
			if (isSameValue(nome, nomeValue)) {
				return concreteNext;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Livros with the given processo.
	 */
	public List<Livro> getLivrosByProcesso(final Processo processo) {
		List<Livro> result = new ArrayList<Livro>();
		Set<Livro> cache = _getLivroCache();
		for (Livro concreteNext : cache) {
			if (processo != null && processo.equals(concreteNext.getProcesso())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		List<Livro> result = new ArrayList<Livro>();
		Set<Livro> cache = _getLivroCache();
		for (Livro castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		List<Livro> result = new ArrayList<Livro>();
		Set<Livro> cache = _getLivroCache();
		for (Livro concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		// Check whether entity is contained in cache
		if (!_getLivroCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getLivroCache().remove(entity);
		// Remove entities referenced by outgoing reference
		Processo processo = entity.getProcesso();
		delete(processo);
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		for (Livro entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		return _getLivroCache().size();
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag) {
		return createPagina(pag, null);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag, final IAction<Pagina> prePersistAction) {
		
		Pagina newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextPaginaID;
			nextPaginaID++;
			@java.lang.SuppressWarnings("deprecation")
			Pagina newPagina = new Pagina(pag) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newPagina;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniquePagina(newEntity);
		} else {
			newEntity = delegate.createPagina(pag);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getPaginaCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		List<Pagina> result = new ArrayList<Pagina>();
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		List<Pagina> result = new ArrayList<Pagina>();
		Set<Pagina> cache = _getPaginaCache();
		for (Pagina concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String pag = concreteNext.getPag();
				if (pag != null && pag.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		// Check whether entity is contained in cache
		if (!_getPaginaCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getPaginaCache().remove(entity);
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		for (Pagina entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		return _getPaginaCache().size();
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto) {
		return createProcesso(numero, data, requerente, requerido, auto, null);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto, final IAction<Processo> prePersistAction) {
		
		Processo newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(requerente, true);
			checkPersisted(requerido, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextProcessoID;
			nextProcessoID++;
			@java.lang.SuppressWarnings("deprecation")
			Processo newProcesso = new Processo(numero, data, requerente, requerido, auto) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setRequerente(Requerente newValue) {
					checkPersisted(newValue, false);
					super.setRequerente(newValue);
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setRequerido(Requerido newValue) {
					checkPersisted(newValue, false);
					super.setRequerido(newValue);
				}
				
			};
			newEntity = newProcesso;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueProcesso(newEntity);
		} else {
			newEntity = delegate.createProcesso(numero, data, requerente, requerido, auto);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getProcessoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	public Processo getProcesso(final int id) {
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the Processos with the given requerente.
	 */
	public List<Processo> getProcessosByRequerente(final Requerente requerente) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (requerente != null && requerente.equals(concreteNext.getRequerente())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns the Processos with the given requerido.
	 */
	public List<Processo> getProcessosByRequerido(final Requerido requerido) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			if (requerido != null && requerido.equals(concreteNext.getRequerido())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof Processo)) {
				continue;
			}
			Processo concreteNext = (Processo) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo next : cache) {
			if (!(next instanceof Processo)) {
				continue;
			}
			Processo concreteNext = (Processo) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos() {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		List<Processo> result = new ArrayList<Processo>();
		Set<Processo> cache = _getProcessoCache();
		for (Processo concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String numero = concreteNext.getNumero();
				if (numero != null && numero.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (!matches) {
				java.lang.String auto = concreteNext.getAuto();
				if (auto != null && auto.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Processo.
	 */
	public void delete(final Processo entity) {
		// Check whether entity is contained in cache
		if (!_getProcessoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getProcessoCache().remove(entity);
		// Remove entities referenced by outgoing reference
		Requerente requerente = entity.getRequerente();
		delete(requerente);
		// Remove entities referenced by outgoing reference
		Requerido requerido = entity.getRequerido();
		delete(requerido);
	}
	
	/**
	 * Deletes all given Processos.
	 */
	public void deleteProcessos(final List<Processo> entities) {
		for (Processo entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate) {
		_getProcessoCache().removeAll(getProcessosWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate) {
		_getProcessoCache().removeAll(getProcessosWithDataAfter(_minDate));
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos() {
		return _getProcessoCache().size();
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome) {
		return createRequerente(nome, null);
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome, final IAction<Requerente> prePersistAction) {
		
		Requerente newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextRequerenteID;
			nextRequerenteID++;
			@java.lang.SuppressWarnings("deprecation")
			Requerente newRequerente = new Requerente(nome) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newRequerente;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueRequerente(newEntity);
		} else {
			newEntity = delegate.createRequerente(nome);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getRequerenteCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Requerente with the given id.
	 */
	public Requerente getRequerente(final int id) {
		Set<Requerente> cache = _getRequerenteCache();
		for (Requerente next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Requerente.
	 */
	public List<Requerente> getAllRequerentes() {
		List<Requerente> result = new ArrayList<Requerente>();
		Set<Requerente> cache = _getRequerenteCache();
		for (Requerente castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Requerente.
	 */
	public List<Requerente> searchRequerentes(final java.lang.String _searchString, final int _maxResults) {
		List<Requerente> result = new ArrayList<Requerente>();
		Set<Requerente> cache = _getRequerenteCache();
		for (Requerente concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Requerente.
	 */
	public void delete(final Requerente entity) {
		// Check whether entity is contained in cache
		if (!_getRequerenteCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getRequerenteCache().remove(entity);
	}
	
	/**
	 * Deletes all given Requerentes.
	 */
	public void deleteRequerentes(final List<Requerente> entities) {
		for (Requerente entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Requerente entities.
	 */
	public int countRequerentes() {
		return _getRequerenteCache().size();
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome) {
		return createRequerido(nome, null);
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome, final IAction<Requerido> prePersistAction) {
		
		Requerido newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextRequeridoID;
			nextRequeridoID++;
			@java.lang.SuppressWarnings("deprecation")
			Requerido newRequerido = new Requerido(nome) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newRequerido;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueRequerido(newEntity);
		} else {
			newEntity = delegate.createRequerido(nome);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getRequeridoCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Requerido with the given id.
	 */
	public Requerido getRequerido(final int id) {
		Set<Requerido> cache = _getRequeridoCache();
		for (Requerido next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all entities of type Requerido.
	 */
	public List<Requerido> getAllRequeridos() {
		List<Requerido> result = new ArrayList<Requerido>();
		Set<Requerido> cache = _getRequeridoCache();
		for (Requerido castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Requerido.
	 */
	public List<Requerido> searchRequeridos(final java.lang.String _searchString, final int _maxResults) {
		List<Requerido> result = new ArrayList<Requerido>();
		Set<Requerido> cache = _getRequeridoCache();
		for (Requerido concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String nome = concreteNext.getNome();
				if (nome != null && nome.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Requerido.
	 */
	public void delete(final Requerido entity) {
		// Check whether entity is contained in cache
		if (!_getRequeridoCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getRequeridoCache().remove(entity);
	}
	
	/**
	 * Deletes all given Requeridos.
	 */
	public void deleteRequeridos(final List<Requerido> entities) {
		for (Requerido entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of Requerido entities.
	 */
	public int countRequeridos() {
		return _getRequeridoCache().size();
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		return createInqueritoSocial(processo, assistenteSocial, null);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		
		InqueritoSocial newEntity;
		if (delegate == null) {
			// Check whether all entities passed to the constructor are persisted
			checkPersisted(processo, true);
			
			// Call entity constructor to create non-persistent object
			final int objectID = nextInqueritoSocialID;
			nextInqueritoSocialID++;
			@java.lang.SuppressWarnings("deprecation")
			InqueritoSocial newInqueritoSocial = new InqueritoSocial(processo, assistenteSocial) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
				@java.lang.Override
				@java.lang.Deprecated
				public void setProcesso(Processo newValue) {
					checkPersisted(newValue, false);
					super.setProcesso(newValue);
				}
				
			};
			newEntity = newInqueritoSocial;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueInqueritoSocial(newEntity);
		} else {
			newEntity = delegate.createInqueritoSocial(processo, assistenteSocial);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getInqueritoSocialCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial concreteNext : cache) {
			if (processo != null && processo.equals(concreteNext.getProcesso())) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		List<InqueritoSocial> result = new ArrayList<InqueritoSocial>();
		Set<InqueritoSocial> cache = _getInqueritoSocialCache();
		for (InqueritoSocial concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String assistenteSocial = concreteNext.getAssistenteSocial();
				if (assistenteSocial != null && assistenteSocial.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		// Check whether entity is contained in cache
		if (!_getInqueritoSocialCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getInqueritoSocialCache().remove(entity);
		// Remove entities referenced by outgoing reference
		Processo processo = entity.getProcesso();
		delete(processo);
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		for (InqueritoSocial entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		return _getInqueritoSocialCache().size();
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log) {
		return createLog(data, log, null);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final IAction<Log> prePersistAction) {
		
		Log newEntity;
		if (delegate == null) {
			// Call entity constructor to create non-persistent object
			final int objectID = nextLogID;
			nextLogID++;
			@java.lang.SuppressWarnings("deprecation")
			Log newLog = new Log(data, log) {
				
				@java.lang.Override
				public int getId() {
					return objectID;
				}
				
			};
			newEntity = newLog;
			// Check constraints to make sure that no entity which violates constraints is
			// created.
			checkUniqueLog(newEntity);
		} else {
			newEntity = delegate.createLog(data, log);
		}
		
		// Call prePersistAction
		if (prePersistAction != null) {
			prePersistAction.execute(newEntity);
		}
		
		// Add new entity to cache
		_getLogCache().add(newEntity);
		return newEntity;
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (next.getId() == id) {
				return next;
			}
		}
		return null;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (!(next instanceof Log)) {
				continue;
			}
			Log concreteNext = (Log) next;
			Date value = concreteNext.getData();
			if (value == null || value.getTime() < _maxDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log next : cache) {
			if (!(next instanceof Log)) {
				continue;
			}
			Log concreteNext = (Log) next;
			Date value = concreteNext.getData();
			if (value != null && value.getTime() > _minDate.getTime()) {
				result.add(concreteNext);
			}
		}
		return result;
	}
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log castedNext : cache) {
			result.add(castedNext);
		}
		return result;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		List<Log> result = new ArrayList<Log>();
		Set<Log> cache = _getLogCache();
		for (Log concreteNext : cache) {
			boolean matches = false;
			
			if (!matches) {
				java.lang.String log = concreteNext.getLog();
				if (log != null && log.contains(_searchString)) {
					matches = true;
				}
			}
			
			if (matches) {
				result.add(concreteNext);
				if (result.size() >= _maxResults) {
					break;
				}
			}
		}
		return result;
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		// Check whether entity is contained in cache
		if (!_getLogCache().contains(entity)) {
			return;
		}
		// Delete entity itself
		_getLogCache().remove(entity);
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		for (Log entity : entities ) {
			delete(entity);
		}
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		_getLogCache().removeAll(getLogsWithDataBefore(_maxDate));
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		_getLogCache().removeAll(getLogsWithDataAfter(_minDate));
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		return _getLogCache().size();
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Processo processo, boolean includeEntityNameInExceptionMessage) {
		if (processo != null && !_getProcessoCache().contains(processo)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'processo'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Requerente requerente, boolean includeEntityNameInExceptionMessage) {
		if (requerente != null && !_getRequerenteCache().contains(requerente)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'requerente'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Checks if the given entity is persisted and throws an
	 * java.lang.IllegalArgumentException if it is not.
	 */
	private void checkPersisted(Requerido requerido, boolean includeEntityNameInExceptionMessage) {
		if (requerido != null && !_getRequeridoCache().contains(requerido)) {
			if (includeEntityNameInExceptionMessage) {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument for parameter 'requerido'.");
			} else {
				throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
			}
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Usuario merge(Usuario entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Usuario> _getUsuarioCache() {
		if (cachedUsuario == null) {
			cachedUsuario = new LinkedHashSet<Usuario>();
			if (delegate != null) {
				cachedUsuario.addAll(delegate.getAllUsuarios());
			}
		}
		return cachedUsuario;
	}
	
	protected void checkUniqueUsuario(Usuario entity) {
		checkUniqueUsuarioUsername(entity);
	}
	
	protected void checkUniqueUsuarioUsername(Usuario entity) {
		Object username = entity.getUsername();
		checkUniqueUsuarioUsername(entity, username);
	}
	
	protected void checkUniqueUsuarioUsername(Usuario entity, Object username) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getUsuarioCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof Usuario)) {
				continue;
			}
			Usuario existingEntity = (Usuario) existingObject;
			if (username == null) {
				continue;
			}
			Object existingUsername = existingEntity.getUsername();
			if (!username.equals(existingUsername)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'username'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Livro merge(Livro entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Livro> _getLivroCache() {
		if (cachedLivro == null) {
			cachedLivro = new LinkedHashSet<Livro>();
			if (delegate != null) {
				cachedLivro.addAll(delegate.getAllLivros());
			}
		}
		return cachedLivro;
	}
	
	protected void checkUniqueLivro(Livro entity) {
		checkUniqueLivroNome(entity);
	}
	
	protected void checkUniqueLivroNome(Livro entity) {
		Object nome = entity.getNome();
		checkUniqueLivroNome(entity, nome);
	}
	
	protected void checkUniqueLivroNome(Livro entity, Object nome) {
		// Check whether there is already an entity with the same value.
		for (Object existingObject : _getLivroCache()) {
			if (existingObject == entity) {
				continue;
			}
			if (!(existingObject instanceof Livro)) {
				continue;
			}
			Livro existingEntity = (Livro) existingObject;
			if (nome == null) {
				continue;
			}
			Object existingNome = existingEntity.getNome();
			if (!nome.equals(existingNome)) {
				continue;
			}
			throw new java.lang.IllegalArgumentException("Constraint violated for unique property 'nome'.");
		}
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Pagina merge(Pagina entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Pagina> _getPaginaCache() {
		if (cachedPagina == null) {
			cachedPagina = new LinkedHashSet<Pagina>();
			if (delegate != null) {
				cachedPagina.addAll(delegate.getAllPaginas());
			}
		}
		return cachedPagina;
	}
	
	protected void checkUniquePagina(Pagina entity) {
		// The entity Pagina does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Processo merge(Processo entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Processo> _getProcessoCache() {
		if (cachedProcesso == null) {
			cachedProcesso = new LinkedHashSet<Processo>();
			if (delegate != null) {
				cachedProcesso.addAll(delegate.getAllProcessos());
			}
		}
		return cachedProcesso;
	}
	
	protected void checkUniqueProcesso(Processo entity) {
		// The entity Processo does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Requerente merge(Requerente entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Requerente> _getRequerenteCache() {
		if (cachedRequerente == null) {
			cachedRequerente = new LinkedHashSet<Requerente>();
			if (delegate != null) {
				cachedRequerente.addAll(delegate.getAllRequerentes());
			}
		}
		return cachedRequerente;
	}
	
	protected void checkUniqueRequerente(Requerente entity) {
		// The entity Requerente does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Requerido merge(Requerido entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Requerido> _getRequeridoCache() {
		if (cachedRequerido == null) {
			cachedRequerido = new LinkedHashSet<Requerido>();
			if (delegate != null) {
				cachedRequerido.addAll(delegate.getAllRequeridos());
			}
		}
		return cachedRequerido;
	}
	
	protected void checkUniqueRequerido(Requerido entity) {
		// The entity Requerido does not have any uniqueness constraints. Therefore, this
		// method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public InqueritoSocial merge(InqueritoSocial entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<InqueritoSocial> _getInqueritoSocialCache() {
		if (cachedInqueritoSocial == null) {
			cachedInqueritoSocial = new LinkedHashSet<InqueritoSocial>();
			if (delegate != null) {
				cachedInqueritoSocial.addAll(delegate.getAllInqueritoSocials());
			}
		}
		return cachedInqueritoSocial;
	}
	
	protected void checkUniqueInqueritoSocial(InqueritoSocial entity) {
		// The entity InqueritoSocial does not have any uniqueness constraints. Therefore,
		// this method remains empty.
	}
	
	/**
	 * Merge the properties of the given entity with the current  transaction context.
	 */
	public Log merge(Log entity) {
		if (delegate == null) {
			return entity;
		}
		return delegate.merge(entity);
	}
	
	protected Set<Log> _getLogCache() {
		if (cachedLog == null) {
			cachedLog = new LinkedHashSet<Log>();
			if (delegate != null) {
				cachedLog.addAll(delegate.getAllLogs());
			}
		}
		return cachedLog;
	}
	
	protected void checkUniqueLog(Log entity) {
		// The entity Log does not have any uniqueness constraints. Therefore, this method
		// remains empty.
	}
	
	/**
	 * Executes the given function. Currently, the generated cache basically executes
	 * the function without any transaction behavior.
	 */
	public <T> T executeInTransaction(IFunction<T> function) {
		if (this instanceof tribunal.custom.IDBOperations) {
			return function.execute((tribunal.custom.IDBOperations) this);
		} else {
			throw new java.lang.RuntimeException("All sub classes of TribunalCacheBase must implement tribunal.custom.IDBOperations");
		}
	}
	
	/**
	 * Executes the given command. Currently, the generated cache basically executes
	 * the function without any transaction behavior.
	 */
	public void executeInTransaction(ICommand command) {
		if (this instanceof tribunal.custom.IDBOperations) {
			command.execute((tribunal.custom.IDBOperations) this);
		} else {
			throw new java.lang.RuntimeException("All sub classes of TribunalCacheBase must implement tribunal.custom.IDBOperations");
		}
	}
	
	protected boolean isSameValue(Object value1, Object value2) {
		if (value1 == null) {
			if (value2 != null) {
				return false;
			}
		} else {
			if (value1.equals(value2)) {
				return true;
			}
		}
		return false;
	}
	
}
