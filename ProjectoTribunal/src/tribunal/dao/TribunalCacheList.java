package tribunal.dao;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

/**
 * A list which delegates all of its method calls to the list given in the
 * constructor. Instances of this class are returned from all getters of generated
 * entities that return lists, when the cache is used. All methods of this class
 * that are used for adding elements to the list, throw an
 * IllegalArgumentException if the element(s) being added is not persisted.
 */
public class TribunalCacheList<E> implements List<E> {
	
	private final List<E> delegate;
	private final Set<? super E> persistedElements;
	
	public TribunalCacheList(List<E> delegate, Set<? super E> persistedElements) {
		this.delegate = delegate;
		this.persistedElements = persistedElements;
	}
	
	@java.lang.Override
	public int size() {
		return delegate.size();
	}
	
	@java.lang.Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}
	
	@java.lang.Override
	public boolean contains(java.lang.Object o) {
		return delegate.contains(o);
	}
	
	@java.lang.Override
	public Iterator<E> iterator() {
		return delegate.iterator();
	}
	
	@java.lang.Override
	public java.lang.Object[] toArray() {
		return delegate.toArray();
	}
	
	@java.lang.Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}
	
	@java.lang.Override
	public boolean add(E e) {
		checkPersisted(e);
		return delegate.add(e);
	}
	
	@java.lang.Override
	public boolean remove(java.lang.Object o) {
		return delegate.remove(o);
	}
	
	@java.lang.Override
	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}
	
	@java.lang.Override
	public boolean addAll(Collection<? extends E> c) {
		checkPersisted(c);
		return delegate.addAll(c);
	}
	
	@java.lang.Override
	public boolean addAll(int index, Collection<? extends E> c) {
		checkPersisted(c);
		return delegate.addAll(index, c);
	}
	
	@java.lang.Override
	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}
	
	@java.lang.Override
	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}
	
	@java.lang.Override
	public void clear() {
		delegate.clear();
	}
	
	@java.lang.Override
	public E get(int index) {
		return delegate.get(index);
	}
	
	@java.lang.Override
	public E set(int index, E element) {
		return delegate.set(index, element);
	}
	
	@java.lang.Override
	public void add(int index, E element) {
		checkPersisted(element);
		delegate.add(index, element);
	}
	
	@java.lang.Override
	public E remove(int index) {
		return delegate.remove(index);
	}
	
	@java.lang.Override
	public int indexOf(java.lang.Object o) {
		return delegate.indexOf(o);
	}
	
	@java.lang.Override
	public int lastIndexOf(java.lang.Object o) {
		return delegate.lastIndexOf(o);
	}
	
	@java.lang.Override
	public ListIterator<E> listIterator() {
		return delegate.listIterator();
	}
	
	@java.lang.Override
	public ListIterator<E> listIterator(int index) {
		return delegate.listIterator(index);
	}
	
	@java.lang.Override
	public List<E> subList(int fromIndex, int toIndex) {
		return delegate.subList(fromIndex, toIndex);
	}
	
	private void checkPersisted(Collection<? extends E> c) {
		for (E e : c) {
			checkPersisted(e);
		}
	}
	
	private void checkPersisted(E e) {
		if (persistedElements.contains(e)) {
			return;
		}
		
		throw new java.lang.IllegalArgumentException("Can't use non-persistent object as argument.");
	}
	
}
