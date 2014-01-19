/**
 * 
 */
package contactmgmt.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import myTools.PopulatorAndFlusher;
import myTools.ValuesManager;
import myTools.ValuesManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contactmgmt.*;

/**
 * @author Guilherme
 *
 */
public class ContactManagerImplTest {
	ContactManagerImpl cm;
	String pathToFile = "."+ File.separator +"contactsTest.txt";
	PopulatorAndFlusher paf;
	ValuesManager vm;
	String debugStr ="";
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	
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
		cm = new ContactManagerImpl();
		paf = cm.getPaf();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		//debug
		paf.printSet(paf.getAllFutureMeetings());
		paf.printSet(paf.getAllPastMeetings());
		paf.printSet(paf.getAllContacts());
		System.out.println(debugStr+"\n");
		//tearDown
		cm = null;
		File file = new File(pathToFile);
		file.delete();
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#ContactManagerImpl()}.
	 */
	@Test
	public final void testContactManagerImplIsInstantiatedCorrectly() {
		assertTrue(cm instanceof ContactManagerImpl);
	}
	//TODO need a battery of tests for each process the Constructor implements!!
	
	@Test
	public final void testContactManagerImplPopulatesSetsAndIndexes() {
		fail("not written yet");
		//TODO implement call to myTools.PopulateSetsAndIndexes(String pathToFile), for each list/set = PopulateSetsandIndexes.gettersAndSetters()
		//TODO > mock interface for the test
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addFutureMeeting(java.util.Set, java.util.Calendar)}.
	 */
	@Test
	public final void testVerifyAddFutureMeetingIdIsUnique() {
		fail("Not yet implemented"); // TODO
		
		/*
		 * @return the ID for the meeting
		 * TODO implement myTools.checkIdExistsInList(int id, List<Integer> anyIntegerList)> mock interface for the test
		 */
	}
	
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addFutureMeeting(java.util.Set, java.util.Calendar)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testVerifyAIllegalArgumentIsThrownAddFuture() {
		fail("Not yet implemented"); // TODO
		
		/*
		 * @throws IllegalArgumentException if the meeting is set for a time in the past,
		 * or if any contact is unknown / non-existent
		 * TODO implement myTools.checkDateIsInThePast(Calendar date)> mock interface for the test
		 * TODO implement myTools.checkIdExistsInList(int id, List<Integer> anyIntegerList)> mock interface for the test
		 */
	}
	
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addFutureMeeting(java.util.Set, java.util.Calendar)}.
	 */
	@Test
	public final void testAddFutureMeetingIsAdded() {
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testAddFutureMeetingIsAdded>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//input variables
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(3, "Fritz"));
		inputContacts.add(new ContactImpl(15, "Sterling Archer"));
		inputContacts.add(new ContactImpl(12, "Barefoot Grub Patch"));
		Calendar inputDate = new GregorianCalendar(2014,11,15);
		int futureMeetingId = cm.addFutureMeeting(inputContacts, inputDate);
		//test setUp
		vm = new ValuesManagerImpl();
		boolean assertResult = vm.checkIdExistsInList(futureMeetingId, paf.getFutureMeetingsIdIndex());
		//test
		assertTrue("addFutureMeeting not adding the meeting to the contactManager DB", assertResult);
	}


	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test
	public final void testGetPastMeeting() {
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetPastMeeting>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		Calendar expectedDate = new GregorianCalendar(2013,9,5);
		Calendar secondExpectedDate = new GregorianCalendar(2013,10,5);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		String expectedNotes = "Nakatomi Plaza at 9pm";
		PastMeeting expectedPastMeeting = new PastMeetingImpl(2,expectedDate,expectedContacts);
		PastMeeting expectedPastMeetingWNotes = new PastMeetingImpl(1,secondExpectedDate, expectedContacts, expectedNotes);
		//input
		PastMeeting inputMeeting = cm.getPastMeeting(2);
		PastMeeting secondInputMeeting = cm.getPastMeeting(1);
		//test
		assertEquals("",expectedPastMeeting,inputMeeting);
		assertEquals("",expectedPastMeetingWNotes,secondInputMeeting);
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeeting(int)}.
	 */
	@Test
	public final void testGetFutureMeeting() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getMeeting(int)}.
	 */
	@Test
	public final void testGetMeeting() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetFutureMeetingListContact() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(java.util.Calendar)}.
	 */
	@Test
	public final void testGetFutureMeetingListCalendar() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetPastMeetingList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test
	public final void testAddNewPastMeeting() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test
	public final void testAddMeetingNotes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewContact(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddNewContact() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(int[])}.
	 */
	@Test
	public final void testGetContactsIntArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(java.lang.String)}.
	 */
	@Test
	public final void testGetContactsString() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#flush()}.
	 */
	@Test
	public final void testFlush() {
		fail("Not yet implemented"); // TODO
	}

}
