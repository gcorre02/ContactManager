/**
 * 
 */
package myTools.test;

import static org.junit.Assert.*;
import myTools.DatesManager;
import myTools.DatesManagerImpl;
import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;
import contactmgmt.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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

		pathToFile = "."+ File.separator +"contactsTest.txt";
		PrintWriter writer;
		try {
			writer = new PrintWriter(pathToFile, Charset.defaultCharset().toString());
			//TODO write it all in the right format:
			writer.println("0,M,HansGruber JohnMcClane,20140513");
			writer.println("1,M,HansGruber JohnMcClane,20131005,Nakatomi Plaza at 9pm");
			writer.println("2,M,HansGruber JohnMcClane,20130905");
			writer.println("0,C,Hans Gruber");
			writer.println("1,C,John Mc Clane");
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
		paf = new PopulatorAndFlusherImpl(pathToFile);

		/*		not having to write these methods at setup is the test for the constructor's behaviour
		 * 	
		 *		paf.setAllContacts(paf.getCsvRows());
		 *		paf.setAllMeetings(paf.getCsvRows());
		 *
		 *		paf.setMeetingsIdIndex(paf.getCsvRows());
		 *		paf.setAllPastMeetings(paf.getAllMeetings()); 
		 *		paf.setAllFutureMeetings(paf.getAllMeetings());
		 *		paf.setPastMeetingsIdIndex(paf.getAllPastMeetings());
		 *		paf.setFutureMeetingsIdIndex(paf.getAllFutureMeetings());
		 *		paf.setContactsIdIndex(paf.getCsvRows());
		 *
		 */
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
		expectedCsvRows.add("0,M,HansGruber JohnMcClane,20140513");
		expectedCsvRows.add("1,M,HansGruber JohnMcClane,20131005,Nakatomi Plaza at 9pm");
		expectedCsvRows.add("2,M,HansGruber JohnMcClane,20130905");
		expectedCsvRows.add("0,C,Hans Gruber");
		expectedCsvRows.add("1,C,John Mc Clane");
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
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#WriteToFile(java.util.Set, java.util.Set, java.lang.String)}.
	 */
	@Test
	public final void testWriteToFile() {
		
		//empty the file :
		File file = new File(pathToFile);
		file.delete();
		
		//create array of expected values
		List<String> expectedCsvRows = new ArrayList<String>();
		expectedCsvRows.add("0,M,JohnMcClane HansGruber,20140513");
		expectedCsvRows.add("1,M,JohnMcClane HansGruber,20131005,Nakatomi Plaza at 9pm");
		expectedCsvRows.add("2,M,JohnMcClane HansGruber,20130905");
		expectedCsvRows.add("4,C,Harry Ellis");
		expectedCsvRows.add("8,C,Klaus");
		expectedCsvRows.add("7,C,Karl");
		expectedCsvRows.add("6,C,Holly Genero");
		expectedCsvRows.add("1,C,John Mc Clane");
		expectedCsvRows.add("3,C,Fritz");
		expectedCsvRows.add("0,C,Hans Gruber");
		expectedCsvRows.add("5,C,Theo theDriver");
		expectedCsvRows.add("2,C,Tony");
		
		
		//dump to file:
		paf.writeToFile(pathToFile);
		
		//populate array with file elements
		paf.readFromFile(pathToFile);
		List<String> inputRows = paf.getCsvRows();
		
		//Assert write works
		assertTrue("Write operation not working : ", expectedCsvRows.containsAll(inputRows));
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
		expectedIdIndex.add(1);
		expectedIdIndex.add(2);
		paf.setMeetingsIdIndex(paf.getCsvRows());
		assertEquals("Meeting IDs not being populated", expectedIdIndex , paf.getMeetingsIdIndex());
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setPastMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetPastMeetingsIdIndex() {
		List<Integer> expectedIdIndex = new ArrayList<Integer>();
		expectedIdIndex.add(1);
		expectedIdIndex.add(2);
		assertTrue("Meeting IDs not being populated", expectedIdIndex.containsAll(paf.getPastMeetingsIdIndex()));
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setFutureMeetingsIdIndex(java.util.List)}.
	 */
	@Test
	public final void testSetFutureMeetingsIdIndex() {
		List<Integer> expectedIdIndex = new ArrayList<Integer>();
		expectedIdIndex.add(0);
		assertEquals("Meeting IDs not being populated", expectedIdIndex , paf.getFutureMeetingsIdIndex());
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setContactsNameIndex(java.util.List)}.
	 */
	@Test
	public final void testSetContactsNameIndex() {
		paf.setContactsNameIndex(paf.getAllContacts());
		String[] expectedContacts = new String[9];
		expectedContacts[0]="Hans Gruber";
		expectedContacts[1]="John Mc Clane";
		expectedContacts[2]="Tony";
		expectedContacts[3]="Fritz";
		expectedContacts[4]="Harry Ellis";
		expectedContacts[5]="Theo theDriver";
		expectedContacts[6]="Holly Genero";
		expectedContacts[7]="Karl";
		expectedContacts[8]="Klaus";
		paf.setContactsNameIndex(paf.getAllContacts());
		List<String> inputContacts = paf.getContactsNameIndex();
		assertTrue("Setcontacts name index not passing the names into index", inputContacts.contains(expectedContacts[5]));

	}

	/**1
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllContacts(java.util.Set)}.
	 */
	@Test
	public final void testSetAllContacts() {

		String[] expectedContacts = new String[9];
		expectedContacts[0]="Hans Gruber";
		expectedContacts[1]="John Mc Clane";
		expectedContacts[2]="Tony";
		expectedContacts[3]="Fritz";
		expectedContacts[4]="Harry Ellis";
		expectedContacts[5]="Theo theDriver";
		expectedContacts[6]="Holly Genero";
		expectedContacts[7]="Karl";
		expectedContacts[8]="Klaus";

		paf.setAllContacts(paf.getCsvRows());
		Set<Contact> inputContacts = paf.getAllContacts();

		Iterator<Contact> iter = inputContacts.iterator();

		while(iter.hasNext()){
			Contact current = iter.next();
			assertEquals("Set contacts is not importing them propperly", expectedContacts[current.getId()],current.getName());
		}




	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllMeetings() {
		String[] expectedMeetings = new String[2];
		expectedMeetings[0]="Hans Gruber";
		expectedMeetings[1]="John Mc Clane";

		Set<Meeting> inputMeetings = paf.getAllMeetings();

		Iterator<Meeting> iter = inputMeetings.iterator();
		String contactName = "";

		while(iter.hasNext()){
			Meeting current = iter.next();
			Iterator<Contact> contactIter = current.getContacts().iterator();
			while(contactIter.hasNext()){
				Contact currentContact = contactIter.next();
				contactName = currentContact.getName();

				assertEquals("Set Meetings is not importing them propperly", expectedMeetings[currentContact.getId()], contactName);

			}

		} 


	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllPastMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllPastMeetings() {


		Set<PastMeeting> inputMeetings = paf.getAllPastMeetings();

		Iterator<PastMeeting> iter = inputMeetings.iterator();
		Calendar inputDate;
		DatesManager dm = new DatesManagerImpl();

		while(iter.hasNext()){
			Meeting current = iter.next();
			inputDate = current.getDate();
			assertTrue("Set pastMeetings is not importing them propperly", dm.checkDateIsInThePast(inputDate));
		} 
	}

	/**
	 * Test method for {@link myTools.PopulatorAndFlusherImpl#setAllFutureMeetings(java.util.Set)}.
	 */
	@Test
	public final void testSetAllFutureMeetings() {

		Set<FutureMeeting> inputMeetings = paf.getAllFutureMeetings();

		Iterator<FutureMeeting> iter = inputMeetings.iterator();

		Calendar date = new GregorianCalendar(2014,05,13);
		if(iter.hasNext()){
			while(iter.hasNext()){
				FutureMeeting current = iter.next();
				if(current.getId()== 0){
					assertEquals("Set FutureMeeting is not importing them propperly", date,current.getDate());
				} else {
					fail("future meeting array not populated with index 0");
				}
			} 
		}  else {
			fail("future meeting array not populated");
		}

	}

	@Test 
	public final void checkThatNotesHaveBeenAddedToThePastMeeting(){


		String expectedNotes = "Nakatomi Plaza at 9pm";
		Set<PastMeeting> inputMeetings = paf.getAllPastMeetings();
		String inputNotes="";
		Iterator<PastMeeting> iter = inputMeetings.iterator();
		while(iter.hasNext()){
			PastMeeting current = iter.next();
			if(current.getId()==1){
				inputNotes = current.getNotes();
			}
		}

		assertEquals("getNtes() is not returning the notes from the assigned id meeting", expectedNotes, inputNotes);
	}

	@Test 
	public final void testUpdateIndex(){
		int inputId = 13;
		paf.updateIndex(inputId,paf.getContactsIdIndex());
		assertTrue("index updater not working", paf.getContactsIdIndex().contains(inputId));
		paf.updateIndex(inputId,paf.getContactsIdIndex());
		assertTrue("index updater removal not working", !paf.getContactsIdIndex().contains(inputId));
	}
	@Test
	public final void testUpdateSet(){
		Contact inputContact = new ContactImpl(23,"John McClane");
		paf.updateSet(inputContact, paf.getAllContacts());

	}
}
