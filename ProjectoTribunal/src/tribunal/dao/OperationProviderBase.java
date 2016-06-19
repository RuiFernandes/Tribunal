package tribunal.dao;

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Livro;
import tribunal.entities.Log;
import tribunal.entities.Pagina;
import tribunal.entities.Processo;
import tribunal.entities.Requerente;
import tribunal.entities.Requerido;
import tribunal.entities.Usuario;

/**
 * <p>
 * This class provides all default operations that are derived from the HEDL
 * entity model.
 * </p>
 * 
 * <p>
 * Note: This class is generated. Any change will be overridden.
 * </p>
 */
public abstract class OperationProviderBase implements IDBOperationsBase {
	
	protected UsuarioDAO usuarioDAO = new UsuarioDAO();
	protected LivroDAO livroDAO = new LivroDAO();
	protected PaginaDAO paginaDAO = new PaginaDAO();
	protected ProcessoDAO processoDAO = new ProcessoDAO();
	protected RequerenteDAO requerenteDAO = new RequerenteDAO();
	protected RequeridoDAO requeridoDAO = new RequeridoDAO();
	protected InqueritoSocialDAO inqueritoSocialDAO = new InqueritoSocialDAO();
	protected LogDAO logDAO = new LogDAO();
	
	private EntityManager entityManager;
	
	public OperationProviderBase(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
	
	public void flush() {
		getEntityManager().flush();
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria) {
		return usuarioDAO.create(getEntityManager(), nome, dataDeNascimento, username, password, categoria);
	}
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(final String nome, final Date dataDeNascimento, final String username, final String password, final String categoria, final IAction<Usuario> prePersistAction) {
		return usuarioDAO.create(getEntityManager(), nome, dataDeNascimento, username, password, categoria, prePersistAction);
	}
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id) {
		Usuario entity = usuarioDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username) {
		Usuario entity = usuarioDAO.getByUsername(getEntityManager(), username);
		return entity;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		final List<Usuario> entities = usuarioDAO.getDataDeNascimentoBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		final List<Usuario> entities = usuarioDAO.getDataDeNascimentoAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios() {
		final List<Usuario> entities = usuarioDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults) {
		return usuarioDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity) {
		usuarioDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities) {
		usuarioDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Usuario.class.getName() + " " + "WHERE " + UsuarioDAO.FIELD__DATADENASCIMENTO + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Usuario.class.getName() + " " + "WHERE " + UsuarioDAO.FIELD__DATADENASCIMENTO + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios() {
		return usuarioDAO.count(getEntityManager());
	}
	
	public Usuario merge(Usuario entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo) {
		return livroDAO.create(getEntityManager(), nome, processo);
	}
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(final String nome, final Processo processo, final IAction<Livro> prePersistAction) {
		return livroDAO.create(getEntityManager(), nome, processo, prePersistAction);
	}
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id) {
		Livro entity = livroDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome) {
		Livro entity = livroDAO.getByNome(getEntityManager(), nome);
		return entity;
	}
	
	/**
	 * Returns the Livros with the given processo.
	 */
	public List<Livro> getLivrosByProcesso(final Processo processo) {
		List<Livro> entities = livroDAO.getByProcesso(getEntityManager(), processo);
		return entities;
	}
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros() {
		final List<Livro> entities = livroDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults) {
		return livroDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity) {
		livroDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities) {
		livroDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros() {
		return livroDAO.count(getEntityManager());
	}
	
	public Livro merge(Livro entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag) {
		return paginaDAO.create(getEntityManager(), pag);
	}
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(final String pag, final IAction<Pagina> prePersistAction) {
		return paginaDAO.create(getEntityManager(), pag, prePersistAction);
	}
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id) {
		Pagina entity = paginaDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas() {
		final List<Pagina> entities = paginaDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults) {
		return paginaDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity) {
		paginaDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities) {
		paginaDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas() {
		return paginaDAO.count(getEntityManager());
	}
	
	public Pagina merge(Pagina entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto) {
		return processoDAO.create(getEntityManager(), numero, data, requerente, requerido, auto);
	}
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(final String numero, final Date data, final Requerente requerente, final Requerido requerido, final String auto, final IAction<Processo> prePersistAction) {
		return processoDAO.create(getEntityManager(), numero, data, requerente, requerido, auto, prePersistAction);
	}
	
	/**
	 * Returns the Processo with the given id.
	 */
	public Processo getProcesso(final int id) {
		Processo entity = processoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the Processos with the given requerente.
	 */
	public List<Processo> getProcessosByRequerente(final Requerente requerente) {
		List<Processo> entities = processoDAO.getByRequerente(getEntityManager(), requerente);
		return entities;
	}
	
	/**
	 * Returns the Processos with the given requerido.
	 */
	public List<Processo> getProcessosByRequerido(final Requerido requerido) {
		List<Processo> entities = processoDAO.getByRequerido(getEntityManager(), requerido);
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate) {
		final List<Processo> entities = processoDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate) {
		final List<Processo> entities = processoDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos() {
		final List<Processo> entities = processoDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults) {
		return processoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Processo.
	 */
	public void delete(final Processo entity) {
		processoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Processos.
	 */
	public void deleteProcessos(final List<Processo> entities) {
		processoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Processo.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Processo.class.getName() + " " + "WHERE " + ProcessoDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos() {
		return processoDAO.count(getEntityManager());
	}
	
	public Processo merge(Processo entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome) {
		return requerenteDAO.create(getEntityManager(), nome);
	}
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(final String nome, final IAction<Requerente> prePersistAction) {
		return requerenteDAO.create(getEntityManager(), nome, prePersistAction);
	}
	
	/**
	 * Returns the Requerente with the given id.
	 */
	public Requerente getRequerente(final int id) {
		Requerente entity = requerenteDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Requerente.
	 */
	public List<Requerente> getAllRequerentes() {
		final List<Requerente> entities = requerenteDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Requerente.
	 */
	public List<Requerente> searchRequerentes(final java.lang.String _searchString, final int _maxResults) {
		return requerenteDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Requerente.
	 */
	public void delete(final Requerente entity) {
		requerenteDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Requerentes.
	 */
	public void deleteRequerentes(final List<Requerente> entities) {
		requerenteDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Requerente entities.
	 */
	public int countRequerentes() {
		return requerenteDAO.count(getEntityManager());
	}
	
	public Requerente merge(Requerente entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome) {
		return requeridoDAO.create(getEntityManager(), nome);
	}
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(final String nome, final IAction<Requerido> prePersistAction) {
		return requeridoDAO.create(getEntityManager(), nome, prePersistAction);
	}
	
	/**
	 * Returns the Requerido with the given id.
	 */
	public Requerido getRequerido(final int id) {
		Requerido entity = requeridoDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all entities of type Requerido.
	 */
	public List<Requerido> getAllRequeridos() {
		final List<Requerido> entities = requeridoDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Requerido.
	 */
	public List<Requerido> searchRequeridos(final java.lang.String _searchString, final int _maxResults) {
		return requeridoDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Requerido.
	 */
	public void delete(final Requerido entity) {
		requeridoDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Requeridos.
	 */
	public void deleteRequeridos(final List<Requerido> entities) {
		requeridoDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of Requerido entities.
	 */
	public int countRequeridos() {
		return requeridoDAO.count(getEntityManager());
	}
	
	public Requerido merge(Requerido entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial) {
		return inqueritoSocialDAO.create(getEntityManager(), processo, assistenteSocial);
	}
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(final Processo processo, final String assistenteSocial, final IAction<InqueritoSocial> prePersistAction) {
		return inqueritoSocialDAO.create(getEntityManager(), processo, assistenteSocial, prePersistAction);
	}
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id) {
		InqueritoSocial entity = inqueritoSocialDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo) {
		List<InqueritoSocial> entities = inqueritoSocialDAO.getByProcesso(getEntityManager(), processo);
		return entities;
	}
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials() {
		final List<InqueritoSocial> entities = inqueritoSocialDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults) {
		return inqueritoSocialDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity) {
		inqueritoSocialDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities) {
		inqueritoSocialDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials() {
		return inqueritoSocialDAO.count(getEntityManager());
	}
	
	public InqueritoSocial merge(InqueritoSocial entity) {
		return getEntityManager().merge(entity);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log) {
		return logDAO.create(getEntityManager(), data, log);
	}
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(final Date data, final String log, final IAction<Log> prePersistAction) {
		return logDAO.create(getEntityManager(), data, log, prePersistAction);
	}
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id) {
		Log entity = logDAO.get(getEntityManager(), id);
		return entity;
	}
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate) {
		final List<Log> entities = logDAO.getDataBefore(getEntityManager(), _maxDate);
		return entities;
	}
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate) {
		final List<Log> entities = logDAO.getDataAfter(getEntityManager(), _minDate);
		return entities;
	}
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs() {
		final List<Log> entities = logDAO.getAll(getEntityManager());
		return entities;
	}
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults) {
		return logDAO.search(getEntityManager(), _searchString, _maxResults);
	}
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity) {
		logDAO.delete(getEntityManager(), entity);
	}
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities) {
		logDAO.delete(getEntityManager(), entities);
	}
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Log.class.getName() + " " + "WHERE " + LogDAO.FIELD__DATA + " < ?1");
		query.setParameter(1, _maxDate);
		query.executeUpdate();
	}
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate) {
		Query query = getEntityManager().createQuery("DELETE FROM " + Log.class.getName() + " " + "WHERE " + LogDAO.FIELD__DATA + " > ?1");
		query.setParameter(1, _minDate);
		query.executeUpdate();
	}
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs() {
		return logDAO.count(getEntityManager());
	}
	
	public Log merge(Log entity) {
		return getEntityManager().merge(entity);
	}
	
}
