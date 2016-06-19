package tribunal.dao;


// This class is generated. Any change will be overridden.
/**
 * IActions serve as callbacks for different methods provided by the DAO package.
 * The type parameter T is then bound to some entity type.
 */
public interface IAction<T> {
	
	public void execute(T argument);
	
}
