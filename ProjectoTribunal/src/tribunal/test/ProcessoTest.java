package tribunal.test;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import tribunal.custom.IDBOperations;
import tribunal.custom.TribunalDAO;
import tribunal.dao.ICommand;
import tribunal.entities.Processo;

/**
 * <p>
 * This test is generated for the entity 'Processo' defined in the HEDL model.
 * </p>
 * 
 * <p>
 * Note: Any change made to this class will be overridden.
 * </p>
 */
public class ProcessoTest {
	
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
		Processo newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
	}
	
	@Test
	public void testCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countProcessos());
	}
	
	@Test
	public void testCreateAndCount() {
		assertEquals("Empty database must contain no entities.", 0, dao.countProcessos());
		Processo newEntity = createInstance(dao);
		assertNotNull("Newly created entity must not be null.", newEntity);
		assertEquals("Database must contain 1 entity after creating one.", 1, dao.countProcessos());
	}
	
	@Test
	public void testStringPropertyNumero() {
		final Processo[] entities = new Processo[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[0].setNumero("a");
				entities[1] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[1].setNumero("ab");
				entities[2] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[2].setNumero("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<Processo> result = dao.searchProcessos("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchProcessos("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchProcessos("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchProcessos("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchProcessos("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testStringPropertyAuto() {
		final Processo[] entities = new Processo[3];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				entities[0] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[0].setAuto("a");
				entities[1] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[1].setAuto("ab");
				entities[2] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
				entities[2].setAuto("abc");
			}
		});
		assertNotNull("Entity must be created.", entities[0]);
		assertNotNull("Entity must be created.", entities[1]);
		assertNotNull("Entity must be created.", entities[2]);
		
		List<Processo> result = dao.searchProcessos("a", Integer.MAX_VALUE);
		assertEquals("Expected three found entities.", 3, result.size());
		result = dao.searchProcessos("ab", Integer.MAX_VALUE);
		assertEquals("Expected two found entities.", 2, result.size());
		result = dao.searchProcessos("abc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchProcessos("bc", Integer.MAX_VALUE);
		assertEquals("Expected one found entity.", 1, result.size());
		result = dao.searchProcessos("ac", Integer.MAX_VALUE);
		assertEquals("Expected no found entities.", 0, result.size());
	}
	
	@Test
	public void testDatePropertyData() {
		// create test object
		assertEquals(0, dao.countProcessos());
		Processo newEntity = createInstance(dao);
		assertNotNull(newEntity);
		assertEquals(1, dao.countProcessos());
		
		final int id = newEntity.getId();
		long oneHour = 60 * 1000;
		final Date newDate = new Date(oneHour);
		
		// change date property
		setData(dao, id, newDate);
		
		// fetch again from database
		newEntity = dao.getProcesso(id);
		assertEquals(newDate, newEntity.getData());
		
		List<Processo> before = dao.getProcessosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		List<Processo> after = dao.getProcessosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
		
		// change date property again (add one hour)
		setData(dao, id, new Date(2 * oneHour));
		
		before = dao.getProcessosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(0, before.size());
		
		after = dao.getProcessosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(1, after.size());
		
		// change date property again (subtract one hour)
		setData(dao, id, new java.util.Date(0 * oneHour));
		
		before = dao.getProcessosWithDataBefore(newDate);
		assertNotNull(before);
		assertEquals(1, before.size());
		
		after = dao.getProcessosWithDataAfter(newDate);
		assertNotNull(after);
		assertEquals(0, after.size());
	}
	
	private void setData(TribunalDAO dao, final int id, final Date newValue) {
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				
				Processo entity = operations.getProcesso(id);
				assertNotNull(entity);
				entity.setData(newValue);
			}
		});
	}
	
	private Processo createInstance(TribunalDAO dao) {
		final Processo[] result = new Processo[1];
		dao.executeInTransaction(new ICommand() {
			public void execute(IDBOperations operations) {
				result[0] = operations.createProcesso("stringValue" + (dummyValueCounter++), new Date(), operations.createRequerente("stringValue" + (dummyValueCounter++)), operations.createRequerido("stringValue" + (dummyValueCounter++)), "stringValue" + (dummyValueCounter++));
			}
		});
		return result[0];
	}
}
