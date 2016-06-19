package tribunal.custom;

import tribunal.dao.TribunalDAOBase;

// This class is only generated once. It can be customized and all changes will be
// preserved.
public class TribunalDAO extends TribunalDAOBase {
	
	public TribunalDAO(java.lang.Class<?> contextClass) {
		super(contextClass);
	}
	
	public void handleException(java.lang.Throwable e, boolean retry) {
		e.printStackTrace();
	}
}
