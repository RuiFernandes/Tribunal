package tribunal.dao;

import java.util.Date;
import java.util.List;
import tribunal.entities.InqueritoSocial;
import tribunal.entities.Livro;
import tribunal.entities.Log;
import tribunal.entities.Pagina;
import tribunal.entities.Processo;
import tribunal.entities.Requerente;
import tribunal.entities.Requerido;
import tribunal.entities.Usuario;

// This class is generated. Any change will be overridden.
public interface IDBOperationsBase {
	
	public void flush();
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(String nome, Date dataDeNascimento, String username, String password, String categoria);
	
	/**
	 * Creates a new Usuario using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Usuario createUsuario(String nome, Date dataDeNascimento, String username, String password, String categoria, IAction<Usuario> prePersistAction);
	
	/**
	 * Returns the Usuario with the given id.
	 */
	// This method is deprecated because the entity Usuario has uniqueness
	// constraints. This indicates that there are properties that represent domain
	// keys, which should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Usuario getUsuario(final int id);
	
	/**
	 * Returns the Usuario with the given username.
	 */
	public Usuario getUsuarioByUsername(final String username);
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoBefore(final Date _maxDate);
	
	/**
	 * Returns all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public List<Usuario> getUsuariosWithDataDeNascimentoAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Usuario.
	 */
	public List<Usuario> getAllUsuarios();
	
	/**
	 * Searches for entities of type Usuario.
	 */
	public List<Usuario> searchUsuarios(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Usuario.
	 */
	public void delete(final Usuario entity);
	
	/**
	 * Deletes all given Usuarios.
	 */
	public void deleteUsuarios(final List<Usuario> entities);
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value before '_maxDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoBefore(final Date _maxDate);
	
	/**
	 * Deletes all Usuarios where dataDeNascimento is set to a value after '_minDate'.
	 */
	public void deleteUsuariosWithDataDeNascimentoAfter(final Date _minDate);
	
	/**
	 * Counts the number of Usuario entities.
	 */
	public int countUsuarios();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Usuario merge(Usuario entity);
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(String nome, Processo processo);
	
	/**
	 * Creates a new Livro using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Livro createLivro(String nome, Processo processo, IAction<Livro> prePersistAction);
	
	/**
	 * Returns the Livro with the given id.
	 */
	// This method is deprecated because the entity Livro has uniqueness constraints.
	// This indicates that there are properties that represent domain keys, which
	// should be used to retrieve entities instead of the raw database IDs.
	@java.lang.Deprecated
	public Livro getLivro(final int id);
	
	/**
	 * Returns the Livro with the given nome.
	 */
	public Livro getLivroByNome(final String nome);
	
	/**
	 * Returns the Livros with the given processo.
	 */
	public List<Livro> getLivrosByProcesso(final Processo processo);
	
	/**
	 * Returns all entities of type Livro.
	 */
	public List<Livro> getAllLivros();
	
	/**
	 * Searches for entities of type Livro.
	 */
	public List<Livro> searchLivros(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Livro.
	 */
	public void delete(final Livro entity);
	
	/**
	 * Deletes all given Livros.
	 */
	public void deleteLivros(final List<Livro> entities);
	
	/**
	 * Counts the number of Livro entities.
	 */
	public int countLivros();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Livro merge(Livro entity);
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(String pag);
	
	/**
	 * Creates a new Pagina using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Pagina createPagina(String pag, IAction<Pagina> prePersistAction);
	
	/**
	 * Returns the Pagina with the given id.
	 */
	public Pagina getPagina(final int id);
	
	/**
	 * Returns all entities of type Pagina.
	 */
	public List<Pagina> getAllPaginas();
	
	/**
	 * Searches for entities of type Pagina.
	 */
	public List<Pagina> searchPaginas(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Pagina.
	 */
	public void delete(final Pagina entity);
	
	/**
	 * Deletes all given Paginas.
	 */
	public void deletePaginas(final List<Pagina> entities);
	
	/**
	 * Counts the number of Pagina entities.
	 */
	public int countPaginas();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Pagina merge(Pagina entity);
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(String numero, Date data, Requerente requerente, Requerido requerido, String auto);
	
	/**
	 * Creates a new Processo using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Processo createProcesso(String numero, Date data, Requerente requerente, Requerido requerido, String auto, IAction<Processo> prePersistAction);
	
	/**
	 * Returns the Processo with the given id.
	 */
	public Processo getProcesso(final int id);
	
	/**
	 * Returns the Processos with the given requerente.
	 */
	public List<Processo> getProcessosByRequerente(final Requerente requerente);
	
	/**
	 * Returns the Processos with the given requerido.
	 */
	public List<Processo> getProcessosByRequerido(final Requerido requerido);
	
	/**
	 * Returns all Processos where data is set to a value before '_maxDate'.
	 */
	public List<Processo> getProcessosWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all Processos where data is set to a value after '_minDate'.
	 */
	public List<Processo> getProcessosWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Processo.
	 */
	public List<Processo> getAllProcessos();
	
	/**
	 * Searches for entities of type Processo.
	 */
	public List<Processo> searchProcessos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Processo.
	 */
	public void delete(final Processo entity);
	
	/**
	 * Deletes all given Processos.
	 */
	public void deleteProcessos(final List<Processo> entities);
	
	/**
	 * Deletes all Processos where data is set to a value before '_maxDate'.
	 */
	public void deleteProcessosWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all Processos where data is set to a value after '_minDate'.
	 */
	public void deleteProcessosWithDataAfter(final Date _minDate);
	
	/**
	 * Counts the number of Processo entities.
	 */
	public int countProcessos();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Processo merge(Processo entity);
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(String nome);
	
	/**
	 * Creates a new Requerente using all read-only and all non-null properties. If
	 * the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerente createRequerente(String nome, IAction<Requerente> prePersistAction);
	
	/**
	 * Returns the Requerente with the given id.
	 */
	public Requerente getRequerente(final int id);
	
	/**
	 * Returns all entities of type Requerente.
	 */
	public List<Requerente> getAllRequerentes();
	
	/**
	 * Searches for entities of type Requerente.
	 */
	public List<Requerente> searchRequerentes(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Requerente.
	 */
	public void delete(final Requerente entity);
	
	/**
	 * Deletes all given Requerentes.
	 */
	public void deleteRequerentes(final List<Requerente> entities);
	
	/**
	 * Counts the number of Requerente entities.
	 */
	public int countRequerentes();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Requerente merge(Requerente entity);
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(String nome);
	
	/**
	 * Creates a new Requerido using all read-only and all non-null properties. If the
	 * new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Requerido createRequerido(String nome, IAction<Requerido> prePersistAction);
	
	/**
	 * Returns the Requerido with the given id.
	 */
	public Requerido getRequerido(final int id);
	
	/**
	 * Returns all entities of type Requerido.
	 */
	public List<Requerido> getAllRequeridos();
	
	/**
	 * Searches for entities of type Requerido.
	 */
	public List<Requerido> searchRequeridos(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Requerido.
	 */
	public void delete(final Requerido entity);
	
	/**
	 * Deletes all given Requeridos.
	 */
	public void deleteRequeridos(final List<Requerido> entities);
	
	/**
	 * Counts the number of Requerido entities.
	 */
	public int countRequeridos();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Requerido merge(Requerido entity);
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(Processo processo, String assistenteSocial);
	
	/**
	 * Creates a new InqueritoSocial using all read-only and all non-null properties.
	 * If the new entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public InqueritoSocial createInqueritoSocial(Processo processo, String assistenteSocial, IAction<InqueritoSocial> prePersistAction);
	
	/**
	 * Returns the InqueritoSocial with the given id.
	 */
	public InqueritoSocial getInqueritoSocial(final int id);
	
	/**
	 * Returns the InqueritoSocials with the given processo.
	 */
	public List<InqueritoSocial> getInqueritoSocialsByProcesso(final Processo processo);
	
	/**
	 * Returns all entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> getAllInqueritoSocials();
	
	/**
	 * Searches for entities of type InqueritoSocial.
	 */
	public List<InqueritoSocial> searchInqueritoSocials(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given InqueritoSocial.
	 */
	public void delete(final InqueritoSocial entity);
	
	/**
	 * Deletes all given InqueritoSocials.
	 */
	public void deleteInqueritoSocials(final List<InqueritoSocial> entities);
	
	/**
	 * Counts the number of InqueritoSocial entities.
	 */
	public int countInqueritoSocials();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public InqueritoSocial merge(InqueritoSocial entity);
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(Date data, String log);
	
	/**
	 * Creates a new Log using all read-only and all non-null properties. If the new
	 * entity violates uniqueness constraints and a Cache is used, an
	 * java.lang.IllegalArgumentException is thrown.
	 */
	public Log createLog(Date data, String log, IAction<Log> prePersistAction);
	
	/**
	 * Returns the Log with the given id.
	 */
	public Log getLog(final int id);
	
	/**
	 * Returns all Logs where data is set to a value before '_maxDate'.
	 */
	public List<Log> getLogsWithDataBefore(final Date _maxDate);
	
	/**
	 * Returns all Logs where data is set to a value after '_minDate'.
	 */
	public List<Log> getLogsWithDataAfter(final Date _minDate);
	
	/**
	 * Returns all entities of type Log.
	 */
	public List<Log> getAllLogs();
	
	/**
	 * Searches for entities of type Log.
	 */
	public List<Log> searchLogs(final java.lang.String _searchString, final int _maxResults);
	
	/**
	 * Deletes the given Log.
	 */
	public void delete(final Log entity);
	
	/**
	 * Deletes all given Logs.
	 */
	public void deleteLogs(final List<Log> entities);
	
	/**
	 * Deletes all Logs where data is set to a value before '_maxDate'.
	 */
	public void deleteLogsWithDataBefore(final Date _maxDate);
	
	/**
	 * Deletes all Logs where data is set to a value after '_minDate'.
	 */
	public void deleteLogsWithDataAfter(final Date _minDate);
	
	/**
	 * Counts the number of Log entities.
	 */
	public int countLogs();
	
	/**
	 * Merges the given entity with the current transaction context and returns an
	 * attached version of the entity.
	 */
	public Log merge(Log entity);
	
}
