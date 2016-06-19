package tribunal.dao;


// This class is generated. Any change will be overridden.
public class TribunalListenerRegistry {
	
	private static IUniquenessListener uniquenessListener;
	
	public static void setUniquenessListener(IUniquenessListener listener) {
		uniquenessListener = listener;
	}
	
	public static IUniquenessListener getUniquenessListener() {
		return uniquenessListener;
	}
	
	public static void notifyUniquenessAccess(Object entity) {
		IUniquenessListener _uniquenessListener = getUniquenessListener();
		if (_uniquenessListener != null) {
			_uniquenessListener.notifyUniquenessAccess(entity);
		}
	}
}
