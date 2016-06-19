package tribunal.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import tribunal.custom.IDBOperations;
import tribunal.custom.OperationProvider;
import tribunal.dao.IDBOperationsBase;
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
public abstract class TribunalDAOBase implements IDBOperationsBase, ITransactionalRunner {
	
	public final static List<java.lang.Class<?>> ENTITY_CLASSES = Collections.unmodifiableList(Arrays.<java.lang.Class<?>>asList(new java.lang.Class<?>[] {
		Usuario.class,
		Livro.class,
		Pagina.class,
		Processo.class,
		Requerente.class,
		Requerido.class,
		InqueritoSocial.class,
		Log.class,
	}));
	
	private static EntityManagerFactory entityManagerFactory;
	
	private Class<?> contextClass;
	
	public TribunalDAOBase() {
		this(null);
	}
	
	/**
	 * Creates a new DAO that uses the given context class to load the JPA
	 * configuration file 'persistence.properties' using {@link
	 * Class#getResourceAsStream(String)}.
	 */
	public TribunalDAOBase(Class<?> contextClass) {
		this.contextClass = contextClass;
	}
	
	/**
	 * Returns the context class that was used to load the JPA configuration file.
	 */
	public Class<?> getContextClass() {
		return contextClass;
	}
	
	/**
	 * Returns the name of the service provider that is defined in the persistence.xml
	 * file.
	 */
	public String getServiceName() {
		return "Service";
	}
	
	/**
	 * Retrieves the persistence properties from a file called
	 * 'persistence.properties' which must be found next to the context class in the
	 * class path. Override {@link #getResourcePropertiesInputStream()} to customize
	 * the retrieval of the persistence properties.
	 */
	protected Map<Object, Object> getPersistenceProperties() {
		Map<Object, Object> properties = new LinkedHashMap<Object, Object>();
		if (contextClass != null) {
			InputStream stream = getResourcePropertiesInputStream();
			if (stream != null) {
				try {
					Properties loadedProperties = new Properties();
					loadedProperties.load(stream);
					properties.putAll(loadedProperties);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}
	
	/**
	 * Returns an input stream from which the persistence properties are read. The
	 * default implementation reads the persistence properties from a file called
	 * 'persistence.properties' which must be found next to the context class in the
	 * class path.Sub classes may override this method to obtain the persistence
	 * properties from another location (e.g., from memory).
	 */
	protected InputStream getResourcePropertiesInputStream() {
		return contextClass.getResourceAsStream("persistence.properties");
	}
	
	/**
	 * Creates a new EntityManagerFactory based on the persistence properties that are
	 * returned by {@link #getPersistenceProperties()} and the service name returned
	 * by {@link #getServiceName()}. This method is required in unmanaged environments
	 * only and automatically called by {@link #getEntityManagerFactory()}.
	 */
	protected void configure() {
		Map<Object, Object> properties = getPersistenceProperties();
		configure(properties);
	}
	
	protected void configure(Map<Object, Object> properties) {
		performCustomSchemaUpdates(properties);
		entityManagerFactory = Persistence.createEntityManagerFactory(getServiceName(), properties);
	}
	
	protected void performCustomSchemaUpdates(Map<Object, Object> properties) {
		// Schema versioning is disabled.
	}
	
	/**
	 * Returns the existing EntityManagerFactory or creates one if required. This
	 * method is used in unmanaged environments only.
	 */
	protected EntityManagerFactory getEntityManagerFactory() {
		synchronized (TribunalDAOBase.class) {
			if (entityManagerFactory == null) {
				configure();
			}
			return entityManagerFactory;
		}
	}
	
	/**
	 * This method can be overridden if the DAO is used in a managed environment. In
	 * this case the injected EntityManager can be returned. By default this method
	 * returns <code>null</code>.
	 */
	protected EntityManager getEntityManager() {
		return null;
	}
	
	/**
	 * This method is only used if the DAO is used in an unmanaged environment. In
	 * this case the a new EntityManager is created using the EntityManagerFactory.
	 */
	protected EntityManager createEntityManager() {
		return getEntityManagerFactory().createEntityManager();
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#flush()} instead.
	 * </p>
	 */
	@Deprecated
	public void flush() {
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Usuario)} instead.
	 * </p>
	 */
	@Deprecated
	public Usuario merge(Usuario entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Livro)} instead.
	 * </p>
	 */
	@Deprecated
	public Livro merge(Livro entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Pagina)} instead.
	 * </p>
	 */
	@Deprecated
	public Pagina merge(Pagina entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Processo)} instead.
	 * </p>
	 */
	@Deprecated
	public Processo merge(Processo entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Requerente)} instead.
	 * </p>
	 */
	@Deprecated
	public Requerente merge(Requerente entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Requerido)} instead.
	 * </p>
	 */
	@Deprecated
	public Requerido merge(Requerido entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(InqueritoSocial)} instead.
	 * </p>
	 */
	@Deprecated
	public InqueritoSocial merge(InqueritoSocial entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * <p>
	 * This method is deprecated. It is not meant to be used on the DAO directly.
	 * </p>
	 * 
	 * <p>
	 * Use {@link OperationProvider#merge(Log)} instead.
	 * </p>
	 */
	@Deprecated
	public Log merge(Log entity) {
		throw new UnsupportedOperationException("merge() must not be called outside of transactions.");
	}
	
	/**
	 * Executes the given command within a transaction. If the transaction fails, no
	 * retry is performed.
	 */
	public void executeInTransaction(ICommand command) {
		boolean retry = false;
		executeInTransaction(command, retry);
	}
	
	/**
	 * Executes the given command within a transaction. If retry is <code>true</code>,
	 * a retry is performed if the transaction fails.
	 */
	protected void executeInTransaction(ICommand command, boolean retry) {
		executeInTransaction(Collections.singleton(command));
	}
	
	/**
	 * Executes all commands within one transaction. If the transaction fails, no
	 * retry is performed.
	 */
	public void executeInTransaction(Collection<ICommand> commands) {
		boolean retry = false;
		executeInTransaction(commands, retry);
	}
	
	/**
	 * Executes all commands within one transaction. If retry is <code>true</code>, a
	 * retry is performed if the transaction fails.
	 */
	protected void executeInTransaction(Collection<ICommand> commands, boolean retry) {
		boolean successful = false;
		
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			doExecute(commands, entityManager);
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				doExecute(commands, entityManager);
				tx.commit();
				successful = true;
			} catch (java.lang.Exception e) {
				try {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
				} catch (java.lang.Exception e2) {
					handleException(e2, retry);
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				executeInTransaction(commands, false);
			}
		}
	}
	
	/**
	 * Executes all commands. This method assumes that a transaction has been
	 * previously obtained from the given EntityManager.
	 */
	protected void doExecute(Collection<ICommand> commands, EntityManager entityManager) {
		OperationProvider operationProvider = new OperationProvider(entityManager);
		for (ICommand command : commands) {
			command.execute(operationProvider);
		}
	}
	
	/**
	 * Executes the given function within a transaction and return the result. If the
	 * transaction fails, no retry is performed.
	 */
	public <ResultType> ResultType executeInTransaction(IFunction<ResultType> function) {
		boolean retry = false;
		return executeInTransaction(function, retry);
	}
	
	/**
	 * Executes the given function within a transaction and return the result. If
	 * retry is <code>true</code>, a retry is performed if the transaction fails.
	 */
	protected <ResultType> ResultType executeInTransaction(IFunction<ResultType> function, boolean retry) {
		boolean successful = false;
		ResultType result = null;
		EntityManager entityManager = getEntityManager();
		if (entityManager != null) {
			result = function.execute(new OperationProvider(entityManager));
		} else {
			entityManager = createEntityManager();
			EntityTransaction tx = entityManager.getTransaction();
			try {
				tx.begin();
				result = function.execute(new OperationProvider(entityManager));
				tx.commit();
				successful = true;
			} catch (Throwable e) {
				try {
					if (tx != null && tx.isActive()) {
						tx.rollback();
					}
				} catch (java.lang.Exception e2) {
					handleException(e2, retry);
				}
				handleException(e, retry);
			} finally {
				entityManager.close();
			}
			
			if (!successful && retry) {
				// retry once
				return executeInTransaction(function, false);
			}
		}
		return result;
	}
	
	/**
	 * This method is called if an exception is thrown within a transaction or while
	 * rolling back a transaction. If retry is <code>true</code>, the transaction will
	 * be executed again. Implement this method to realize custom exception handling
	 * (e.g., logging).
	 */
	public abstract void handleException(Throwable e, boolean retry);
	
	/**
	 * Tears down this DAO by closing the EntityManagerFactory. Calling this method is
	 * required in unmanaged environments only.
	 */
	public void tearDown() {
		synchronized (TribunalDAOBase.class) {
			if (entityManagerFactory != null) {
				entityManagerFactory.close();
				entityManagerFactory = null;
			}
		}
	}
	
	/**
	 * Returns all entities that are stored in the database. Note that this method
	 * loads all entities into memory.
	 */
	public List<java.lang.Object> getAll() {
		final List<java.lang.Object> entities = new ArrayList<java.lang.Object>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllUsuarios());
				entities.addAll(operations.getAllLivros());
				entities.addAll(operations.getAllPaginas());
				entities.addAll(operations.getAllProcessos());
				entities.addAll(operations.getAllRequerentes());
				entities.addAll(operations.getAllRequeridos());
				entities.addAll(operations.getAllInqueritoSocials());
				entities.addAll(operations.getAllLogs());
			}
		});
		return entities;
	}
	
	/**
	 * Loads all entities that are stored in the database using one transaction per
	 * entity. This method is useful to check whether the database schema matches the
	 * expectation of the JPA provider. Note that this method loads all entities of
	 * one type (and their eager references) into memory.
	 */
	public void loadAll() {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllUsuarios();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllLivros();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllPaginas();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllProcessos();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllRequerentes();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllRequeridos();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllInqueritoSocials();
			}
		});
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.getAllLogs();
			}
		});
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createUsuario(nome, dataDeNascimento, username, password, categoria);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria, final IAction<Usuario> prePersistAction) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createUsuario(nome, dataDeNascimento, username, password, categoria, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getUsuario(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username) {
		final Usuario[] entity = new Usuario[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getUsuarioByUsername(username);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosWithDataDeNascimentoBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getUsuariosWithDataDeNascimentoAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios() {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllUsuarios());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		final List<Usuario> entities = new ArrayList<Usuario>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchUsuarios(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuarios(entities);
			}
		});
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuariosWithDataDeNascimentoBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteUsuariosWithDataDeNascimentoAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countUsuarios();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLivro(nome, processo);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo, final IAction<Livro> prePersistAction) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLivro(nome, processo, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLivro(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		final Livro[] entity = new Livro[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLivroByNome(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Livros with the given processo.
	 */
	public List<Livro> getLivrosByProcesso(final Processo processo) {
		final List<Livro> entities = new ArrayList<Livro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLivrosByProcesso(processo));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		final List<Livro> entities = new ArrayList<Livro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllLivros());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		final List<Livro> entities = new ArrayList<Livro>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchLivros(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLivros(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countLivros();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPagina(pag);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag, final IAction<Pagina> prePersistAction) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createPagina(pag, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		final Pagina[] entity = new Pagina[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getPagina(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		final List<Pagina> entities = new ArrayList<Pagina>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllPaginas());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		final List<Pagina> entities = new ArrayList<Pagina>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchPaginas(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deletePaginas(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countPaginas();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcesso(numero, data, requerente, requerido, auto);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto, final IAction<Processo> prePersistAction) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createProcesso(numero, data, requerente, requerido, auto, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	public Processo getProcesso(final int id) {
		final Processo[] entity = new Processo[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getProcesso(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Processos with the given requerente.
	 */
	public List<Processo> getProcessosByRequerente(final Requerente requerente) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosByRequerente(requerente));
			}
		});
		return entities;
	}
	
	/**
	 * Returns the Processos with the given requerido.
	 */
	public List<Processo> getProcessosByRequerido(final Requerido requerido) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosByRequerido(requerido));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getProcessosWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos() {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllProcessos());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		final List<Processo> entities = new ArrayList<Processo>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchProcessos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Processo.
	 */
	public void delete(final Processo entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Processos.
	 */
	public void deleteProcessos(final List<Processo> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessos(entities);
			}
		});
	}
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessosWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteProcessosWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countProcessos();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome) {
		final Requerente[] entity = new Requerente[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRequerente(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome, final IAction<Requerente> prePersistAction) {
		final Requerente[] entity = new Requerente[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRequerente(nome, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Requerente with the given id.
	 */
	public Requerente getRequerente(final int id) {
		final Requerente[] entity = new Requerente[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getRequerente(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Requerente.
	 */
	public List<Requerente> getAllRequerentes() {
		final List<Requerente> entities = new ArrayList<Requerente>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllRequerentes());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Requerente.
	 */
	public List<Requerente> searchRequerentes(final java.lang.String _searchString, final int _maxResults) {
		final List<Requerente> entities = new ArrayList<Requerente>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRequerentes(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Requerente.
	 */
	public void delete(final Requerente entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Requerentes.
	 */
	public void deleteRequerentes(final List<Requerente> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteRequerentes(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Requerente entities.
	 */
	public int countRequerentes() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countRequerentes();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome) {
		final Requerido[] entity = new Requerido[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRequerido(nome);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome, final IAction<Requerido> prePersistAction) {
		final Requerido[] entity = new Requerido[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createRequerido(nome, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Requerido with the given id.
	 */
	public Requerido getRequerido(final int id) {
		final Requerido[] entity = new Requerido[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getRequerido(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all entities of type Requerido.
	 */
	public List<Requerido> getAllRequeridos() {
		final List<Requerido> entities = new ArrayList<Requerido>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllRequeridos());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Requerido.
	 */
	public List<Requerido> searchRequeridos(final java.lang.String _searchString, final int _maxResults) {
		final List<Requerido> entities = new ArrayList<Requerido>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchRequeridos(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Requerido.
	 */
	public void delete(final Requerido entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Requeridos.
	 */
	public void deleteRequeridos(final List<Requerido> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteRequeridos(entities);
			}
		});
	}
	
	/**
	 * Counts the number of Requerido entities.
	 */
	public int countRequeridos() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countRequeridos();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createInqueritoSocial(processo, assistenteSocial);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createInqueritoSocial(processo, assistenteSocial, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		final InqueritoSocial[] entity = new InqueritoSocial[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getInqueritoSocial(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getInqueritoSocialsByProcesso(processo));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllInqueritoSocials());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		final List<InqueritoSocial> entities = new ArrayList<InqueritoSocial>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchInqueritoSocials(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteInqueritoSocials(entities);
			}
		});
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countInqueritoSocials();
			}
		});
		return count[0];
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLog(data, log);
			}
		});
		return entity[0];
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final IAction<Log> prePersistAction) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.createLog(data, log, prePersistAction);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		final Log[] entity = new Log[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entity[0] = operations.getLog(id);
			}
		});
		return entity[0];
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLogsWithDataBefore(_maxDate));
			}
		});
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getLogsWithDataAfter(_minDate));
			}
		});
		return entities;
	}
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.getAllLogs());
			}
		});
		return entities;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		final List<Log> entities = new ArrayList<Log>();
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				entities.addAll(operations.searchLogs(_searchString, _maxResults));
			}
		});
		return entities;
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.delete(entity);
			}
		});
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogs(entities);
			}
		});
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogsWithDataBefore(_maxDate);
			}
		});
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				operations.deleteLogsWithDataAfter(_minDate);
			}
		});
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		final int[] count = new int[1];
		executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				count[0] = operations.countLogs();
			}
		});
		return count[0];
	}
	
}

