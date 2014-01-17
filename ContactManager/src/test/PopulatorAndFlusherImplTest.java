/**
 * 
 */
package test;

import static org.junit.Assert.*;
import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

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
		pathToFile = "."+ File.separator +"contactsTest.txt";
		PrintWriter writer;
		try {
			writer = new PrintWriter(pathToFile, Charset.defaultCharset().toString());//"UTF-8"); //
			writer.println("Nakatomi Plaza at 9pm");
			writer.println("Hans Gruber");
			writer.println("John McClane");
			writer.println("Tony");
			writer.println("Fritz");
			writer.println("Harry Ellis");
			writer.println("Theo theDriver");
			writer.println("Holly Genero");
			writer.println("Karl");
			writer.println("Klaus");
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<String> expectedCsvRows = new ArrayList<String>();
		expectedCsvRows.add("Nakatomi Plaza at 9pm");
		expectedCsvRows.add("Hans Gruber");
		expectedCsvRows.add("John McClane");
		expectedCsvRows.add("Tony");
		expectedCsvRows.add("Fritz");
		expectedCsvRows.add("Harry Ellis");
		expectedCsvRows.add("Theo theDriver");
		expectedCsvRows.add("Holly Genero");
		expectedCsvRows.add("Karl");
		expectedCsvRows.add("Klaus");
		List<String> returnedCsvRows = paf.readFromFile(pathToFile);
		File file = new File(pathToFile);
		file.delete();
		assertEquals("read from file not populating csvRows propperly", expectedCsvRows, returnedCsvRows);
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
