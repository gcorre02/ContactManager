/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import myTools.ValuesManager;
import myTools.ValuesManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme
 *
 */
public class ValuesManagerImplTest {
	
	private ValuesManager vm;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		vm = new ValuesManagerImpl();
		
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		vm = null;
	}

	/**
	 * Test method for {@link myTools.ValuesManagerImpl#checkIdExistsInList(int, java.util.List)}.
	 */
	@Test
	public final void testCheckIdExistsInList() {
		int inputId = 10;
		List<Integer> inputIntegerList = new ArrayList<Integer>();
		for(int t = 5; t<20; t++){
			inputIntegerList.add(t);
		}
		assertTrue("list checker is not working",vm.checkIdExistsInList(inputId, inputIntegerList));
	}

	/**
	 * Test method for {@link myTools.ValuesManagerImpl#checkContactNameIsUnique(java.util.Set, java.lang.String)}.
	 */
	@Test
	public final void testCheckContactNameIsUnique() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.ValuesManagerImpl#newIdGenerator(java.util.List)}.
	 */
	@Test
	public final void testNewIdGenerator() {
		fail("Not yet implemented"); // TODO
	}

}
