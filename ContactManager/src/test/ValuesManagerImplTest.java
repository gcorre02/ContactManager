/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
		int secondInput = 1;
		List<Integer> inputIntegerList = new ArrayList<Integer>();
		for(int t = 5; t<20; t++){
			inputIntegerList.add(t);
		}
		assertTrue("list checker is not working",vm.checkIdExistsInList(inputId, inputIntegerList));
		assertTrue("list checker is not working",!vm.checkIdExistsInList(secondInput, inputIntegerList));
	}

	/**
	 * Test method for {@link myTools.ValuesManagerImpl#checkContactNameIsUnique(java.util.Set, java.lang.String)}.
	 */
	@Test
	public final void testCheckContactNameIsUnique() {
		
		String inputCandidateName = "Hans Gruber";
		Set<String> inputCandidateSet= new HashSet<String>();
		inputCandidateSet.add(inputCandidateName);
		inputCandidateSet.add("John McClane");
		inputCandidateSet.add("Simon Gruber");
		inputCandidateSet.add("Marylin Genero");
		inputCandidateSet.add("Casper Vanderbilt");
		inputCandidateSet.add("Lars Mikkelsen");
		inputCandidateSet.add("Gunther ShaterHeanne");
		
		assertTrue("Checkcontactnameisunique() is checking the set string", !vm.checkContactNameIsUnique(inputCandidateSet, inputCandidateName));
		
		inputCandidateSet.remove(inputCandidateName);
		assertTrue("Checkcontactnameisunique() is checking the set string", vm.checkContactNameIsUnique(inputCandidateSet, inputCandidateName));
	}

	/**
	 * Test method for {@link myTools.ValuesManagerImpl#newIdGenerator(java.util.List)}.
	 */
	@Test
	public final void testNewIdGenerator() {
		//TODO if there is time should separate the tests.
		List<Integer> inputIntegerList = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++){
			inputIntegerList.add(i);
		}
		
		int expectedInt = 100;
		int secondExpectedInt = 35;
		
		assertEquals("newIdGenerator() not returning a number 1", expectedInt, vm.newIdGenerator(inputIntegerList));
		
		inputIntegerList.remove(secondExpectedInt);
		assertEquals("newIdGenerator() not returning a number 1", secondExpectedInt, vm.newIdGenerator(inputIntegerList));
		
		assertTrue("make sure it is unique", !vm.checkIdExistsInList(vm.newIdGenerator(inputIntegerList), inputIntegerList) );
		inputIntegerList.add(vm.newIdGenerator(inputIntegerList));
		
		secondExpectedInt = 45; 
		inputIntegerList.remove(secondExpectedInt);
		assertEquals("doesn't work if it is not organized, need to solve this problem : reorganise list and try again", secondExpectedInt, vm.newIdGenerator(inputIntegerList));
		
	}
	
	/**
	 * Test method for {@link myTools.ValuesManagerImpl#reorganiseList(java.util.List)}.
	 */
	@Test
	public final void checkListIsReorganised(){
		List<Integer> inputIntegerList = new ArrayList<Integer>();
		inputIntegerList.add(0);
		inputIntegerList.add(8);
		inputIntegerList.add(6);
		inputIntegerList.add(4);
		inputIntegerList.add(2);
		inputIntegerList.add(9);
		inputIntegerList.add(3);
		inputIntegerList.add(7);
		inputIntegerList.add(5);
		inputIntegerList.add(1);
		List<Integer> expectedIntegerList = new ArrayList<Integer>();
		expectedIntegerList.add(0);
		expectedIntegerList.add(1);
		expectedIntegerList.add(2);
		expectedIntegerList.add(3);
		expectedIntegerList.add(4);
		expectedIntegerList.add(5);
		expectedIntegerList.add(6);
		expectedIntegerList.add(7);
		expectedIntegerList.add(8);
		expectedIntegerList.add(9);
		assertEquals("", vm.reorganiseList(inputIntegerList), expectedIntegerList );
	}

}
