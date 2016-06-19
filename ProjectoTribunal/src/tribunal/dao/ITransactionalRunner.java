package tribunal.dao;

import tribunal.dao.ICommand;
import tribunal.dao.IFunction;

/**
 * <p>
 * This class can be used to decouple clients of the persistence layer from the
 * actual implementation of this layer. This allows, for example, to switch
 * between a Cache and a real database without making changes to such clients.
 * </p>
 * <p>
 * Code that requires access to persistent data should generally use this
 * interface instead of accessing the generated DAO or Cache directly.
 * </p>
 */
// This class is generated. Any change will be overridden.
public interface ITransactionalRunner {
	
	/**
	 * Executes the given function within a single database transaction.
	 */
	public <T> T executeInTransaction(IFunction<T> function);
	
	
	/**
	 * Executes the given command within a single database transaction.
	 */
	public void executeInTransaction(ICommand command);
	
}
