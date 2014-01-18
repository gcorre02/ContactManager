/**
 * 
 */
package test;

import static org.junit.Assert.*;
import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;
import contactmgmt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
		pathToFile = "."+ File.separator +"contactsTest.txt";
		PrintWriter writer;
		try {
			writer = new PrintWriter(pathToFile, Charset.defaultCharset().toString());
			//TODO write it all in the right format:
			writer.println("0,M,HansGruber,Nakatomi Plaza at 9pm");
			writer.println("0,C,Hans Gruber");
			writer.println("1,C,John McClane");
			writer.println("2,C,Tony");
			writer.println("3,C,Fritz");
			writer.println("4,C,Harry Ellis");
			writer.println("5,C,Theo theDriver");
			writer.println("6,C,Holly Genero");
			writer.println("7,C,Karl");
			writer.println("8,C,Klaus");
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		paf.readFromFile(pathToFile);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		paf = null;
		File file = new File(pathToFile);
		file.delete();
		
	}


//done tests
	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#readFromFile(java.lang.String)}.
	 */
	@Test
	public final void testReadFromFileReturnsAllRowsToCsvRows(){
		//TODO pass this to before() and change to the right format
		
		List<String> expectedCsvRows = new ArrayList<String>();
		expectedCsvRows.add("0, M, HansGruber, Nakatomi Plaza at 9pm");
		expectedCsvRows.add("0,C,Hans Gruber");
		expectedCsvRows.add("1,C,John McClane");
		expectedCsvRows.add("2,C,Tony");
		expectedCsvRows.add("3,C,Fritz");
		expectedCsvRows.add("4,C,Harry Ellis");
		expectedCsvRows.add("5,C,Theo theDriver");
		expectedCsvRows.add("6,C,Holly Genero");
		expectedCsvRows.add("7,C,Karl");
		expectedCsvRows.add("8,C,Klaus");
		List<String> returnedCsvRows = paf.readFromFile(pathToFile);
		
		assertEquals("read from file not populating csvRows propperly", expectedCsvRows, returnedCsvRows);
		assertEquals("csvRows is not being populated or getter is not working", expectedCsvRows, paf.getCsvRows());
	}

//TODO last tests
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

//TODO current tests
	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setContactsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetContactsIdIndex() {
		
		List<Integer> expectedIdIndex = new ArrayList<Integer>();
		for(int i = 0; i < 9; i++){
			expectedIdIndex.add(i);
		}
		paf.setContactsIdIndex(paf.getCsvRows());
		assertEquals("", expectedIdIndex , paf.getContactsIdIndex());
	}
	//TODO once everything has been written, try making the id the ref to the actual object so it can be called directly!!!
	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetMeetingsIdIndex() {
		List<Integer> expectedIdIndex = new ArrayList<Integer>();
		expectedIdIndex.add(0);
		paf.setMeetingsIdIndex(paf.getCsvRows());
		assertEquals("Meeting IDs not being populated", expectedIdIndex , paf.getMeetingsIdIndex());
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setPastMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetPastMeetingsIdIndex() {
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
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setContactsNameIndex(java.util.List)}.
	 */
	@Test
	public final void testSetContactsNameIndex() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllContacts(java.util.Set)}.
	 */
	@Test
	public final void testSetAllContacts() {
		Set<Contact> inputContacts = paf.getAllContacts();
		String[] expectedContacts = new String[9];
		expectedContacts[0]="Hans Gruber";
		expectedContacts[0]="John McClane";
		expectedContacts[0]="Tony";
		expectedContacts[0]="Fritz";
		expectedContacts[0]="Harry Ellis";
		expectedContacts[0]="Theo theDriver";
		expectedContacts[0]="Holly Genero";
		expectedContacts[0]="Karl";
		expectedContacts[0]="Klaus";
		paf.setAllContacts(paf.getCsvRows());
		
		Iterator<Contact> iter = inputContacts.iterator();
		int i = 0;
		while(iter.hasNext()){
			assertEquals("Set contacts is not importing them propperly", expectedContacts[i],iter.next().getName());
			i++;
		}
		
		
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllMeetings() {
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
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllFutureMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllFutureMeetings() {
		fail("Not yet implemented"); // TODO
	}

}
