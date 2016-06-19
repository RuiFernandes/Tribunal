package tribunal.test;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Usuario;

/**
 * <p>
 * This test is generated for the entity 'Usuario' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class UsuarioTest {
	
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
		Usuario newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countUsuarios());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countUsuarios());
		Usuario newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countUsuarios());
	}
	
	@Test
	public void testUniquePropertyUsername() {
		final Usuario[] entities = new Usuario[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
			}
		});
		final Usuario entity = entities[0];
		assertNotNull("Entity must be created.", entity);
		
		assertNull("There must not be exceptions up to this point.", lastException);
		// test creation of a second object having the same (unique) value
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				Usuario secondEntity = operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
				secondEntity.setUsername(entities[0].getUsername());
			}
		});
		assertNotNull("Must not be able to create second object with same value for unique property.", lastException);
		lastException = null;
		
		// Use final arrays to store result of execute()
		final String[] username1 = new String[1];
		final String[] username2 = new String[1];
		
		// Create two new values for unique property
		dao.executeInTransaction(new ICommand() {
			
			public void execute(IDBOperations operations) {
				username1[0] = "stringValue" + (dummyValueCounter++);
				username2[0] = "stringValue" + (dummyValueCounter++);
			}
		});
		
		// Check that objects were actually created
		assertNull(lastException);
		assertNotNull(username1[0]);
		assertNotNull(username2[0]);
		
		// Change value of unique property and test retrieval
		setUsername(entity.getId(), username2[0]);
		
		assertNull("Entity must not exist.", dao.getUsuarioByUsername(username1[0]));
		assertNotNull("Entity must exist.", dao.getUsuarioByUsername(username2[0]));
	}
	
	private void setUsername(final int id, final String newValue) {
		dao.executeInTransaction(new ICommand() {
			
			@java.lang.SuppressWarnings("deprecation")
			public void execute(IDBOperations operations) {
				
				Usuario entity = operations.getUsuario(id);
				assertNotNull(entity);
				entity.setUsername(newValue);
				
			}
		});
	}
	
	@Test
	@java.lang.SuppressWarnings("deprecation")
	public void testDatePropertyDataDeNascimento() {
		// create test object
		assertEquals(0, dao.countUsuarios());
		Usuario newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countUsuarios());
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final Date newDate = new Date(oneHour);
		
		// change date property
		setDataDeNascimento(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getUsuario(id);
		assertEquals(newDate, newEntity.getDataDeNascimento());
		
		List<Usuario> before = dao.getUsuariosWithDataDeNascimentoBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<Usuario> after = dao.getUsuariosWithDataDeNascimentoAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
		
		// change date property again (add one hour)
		setDataDeNascimento(dao, id, new Date(2 * oneHour));
		
		before = dao.getUsuariosWithDataDeNascimentoBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getUsuariosWithDataDeNascimentoAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());
		
		// change date property again (subtract one hour)
		setDataDeNascimento(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getUsuariosWithDataDeNascimentoBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getUsuariosWithDataDeNascimentoAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}
	
	private void setDataDeNascimento(TribunalDAO dao, final int id, final Date newValue) {
		dao.executeInTransaction(new ICommand() {
			@java.lang.SuppressWarnings("deprecation")
			public void execute(IDBOperations operations) {
				
				Usuario entity = operations.getUsuario(id);
				assertNotNull(entity);
				entity.setDataDeNascimento(newValue);
			}
		});
	}
	
	private Usuario createInstance(TribunalDAO dao) {
		final Usuario[] result = new Usuario[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createUsuario("stringValue" + (dummyValueCounter++), new Date(), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++), "stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
