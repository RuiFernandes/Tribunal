package tribunal.test;

import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Livro;

/**
 * <p>
 * This test is generated for the entity 'Livro' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class LivroTest {
	
	protected int dummyValueCounter;
	protected Throwable lastException;
	
	private TribunalDAO dao;
	
	@Before
	public void setUp() {
		dao = new TribunalDAO(this.getClass()) {
			
			@Override
			public void handleException(Throwable e, boolean retry) {
				super.handleException(e, retry);
				lastException = e;
			}
		};
		dummyValueCounter = 0;
	}
	
	@After
	public void tearDown() {
		dao.tearDown();
		dao = null;
		lastException = null;
	}
	
	@Test
	public void testCreate() {
		Livro newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countLivros());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countLivros());
		Livro newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countLivros());
	}
	
	@Test
	public void testUniquePropertyNome() {
		final Livro[] entities = new Livro[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createLivro("stringValue" + (dummyValueCounter++), operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++)));
			}
		});
		final Livro entity = entities[0];
		assertNotNull("Entity must be created.", entity);
		
		assertNull("There must not be exceptions up to this point.", lastException);
		// test creation of a second object having the same (unique) value
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				Livro secondEntity = operations.createLivro("stringValue" + (dummyValueCounter++), operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++)));
				secondEntity.setNome(entities[0].getNome());
			}
		});
		assertNotNull("Must not be able to create second object with same value for unique property.", lastException);
		lastException = null;
		
		// Use final arrays to store result of execute()
		final String[] nome1 = new String[1];
		final String[] nome2 = new String[1];
		
		// Create two new values for unique property
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				nome1[0] = "stringValue" + (dummyValueCounter++);
				nome2[0] = "stringValue" + (dummyValueCounter++);
			}
		});
		
		// Check that objects were actually created
		assertNull(lastException);
		assertNotNull(nome1[0]);
		assertNotNull(nome2[0]);
		
		// Change value of unique property and test retrieval
		setNome(entity.getId(), nome2[0]);
		
		assertNull("Entity must not exist.", dao.getLivroByNome(nome1[0]));
		assertNotNull("Entity must exist.", dao.getLivroByNome(nome2[0]));
	}
	
	private void setNome(final int id, final String newValue) {
		dao.executeInTransaction(new ICommand() {
			
			@java.lang.SuppressWarnings("deprecation")
			public void execute(IDBOperations operations) {
				
				Livro entity = operations.getLivro(id);
				assertNotNull(entity);
				entity.setNome(newValue);
				
			}
		});
	}
	
	private Livro createInstance(TribunalDAO dao) {
		final Livro[] result = new Livro[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createLivro("stringValue" + (dummyValueCounter++), operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++)));
			}
		});
		return result[0];
	}
}
