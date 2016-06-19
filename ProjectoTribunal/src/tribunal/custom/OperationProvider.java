package tribunal.custom;

import javax.persistence.EntityManager;
import tribunal.custom.IDBOperations;
import tribunal.dao.OperationProviderBase;

// This class is only generated once. It can be customized and all changes will be
// preserved.
public class OperationProvider extends OperationProviderBase implements IDBOperations {
	
	public OperationProvider(EntityManager em) {
		super(em);
	}
	
}
