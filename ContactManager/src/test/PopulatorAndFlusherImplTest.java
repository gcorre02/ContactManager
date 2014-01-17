/**
 * 
 */
package test;

import static org.junit.Assert.*;
import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme
 *
 */
public class PopulatorAndFlusherImplTest {
	PopulatorAndFlusher paf;
	String pathToFile;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		pathToFile = "."+ File.separator +"contactsTest.txt";
		paf = new PopulatorAndFlusherImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		paf = null;
	}



	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#readFromFile(java.lang.String)}.
	 */
	@Test
	public final void testReadFromFileReturnsAllRowsToCsvRows(){
		String[] expectedCsvRows = new String[10];
		expectedCsvRows[0]= "Nakatomi Plaza at 9pm";
		expectedCsvRows[1]= "Hans Gruber";
		expectedCsvRows[2]= "John McClane";
		expectedCsvRows[3]= "Tony";
		expectedCsvRows[4]= "Fritz";
		expectedCsvRows[5]= "Harry Ellis";
		expectedCsvRows[6]= "Theo theDriver";
		expectedCsvRows[7]= "Holly Genero";
		expectedCsvRows[8]= "Karl";
		expectedCsvRows[9]= "Klaus";
		String[] returnedCsvRows = paf.readFromFile(pathToFile);
		assertEquals("read from file not populating csvRows propperly", expectedCsvRows[4], returnedCsvRows[4]);
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#PopulateSetsAndIndexes(java.lang.String[])}.
	 */
	@Test
	public final void testPopulateSetsAndIndexes() {
		fail("Not yet implemented"); // TODO
	}
	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#WriteToFile(java.util.Set, java.util.Set, java.lang.String)}.
	 */
	@Test
	public final void testWriteToFile() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getContactsIdIndex()}.
	 */
	@Test
	public final void testGetContactsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setContactsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetContactsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getMeetingsIdIndex()}.
	 */
	@Test
	public final void testGetMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getPastMeetingsIdIndex()}.
	 */
	@Test
	public final void testGetPastMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setPastMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetPastMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getFutureMeetingsIdIndex()}.
	 */
	@Test
	public final void testGetFutureMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setFutureMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetFutureMeetingsIdIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getContactsNameIndex()}.
	 */
	@Test
	public final void testGetContactsNameIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setContactsNameIndex(java.util.List)}.
	 */
	@Test
	public final void testSetContactsNameIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getAllContacts()}.
	 */
	@Test
	public final void testGetAllContacts() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllContacts(java.util.Set)}.
	 */
	@Test
	public final void testSetAllContacts() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getAllMeetings()}.
	 */
	@Test
	public final void testGetAllMeetings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllMeetings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getAllPastMeetings()}.
	 */
	@Test
	public final void testGetAllPastMeetings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllPastMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllPastMeetings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#getAllFutureMeetings()}.
	 */
	@Test
	public final void testGetAllFutureMeetings() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllFutureMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllFutureMeetings() {
		fail("Not yet implemented"); // TODO
	}

}
