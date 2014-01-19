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
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
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
		paf = null;
		vm=null;
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
	public final void needToWriteTestsForAllExceptionHandlersIndependently(){
		fail("needToWriteTestsForAllExceptionHandlersIndependently");
	}

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
		assertEquals("",expectedPastMeeting.toString(),inputMeeting.toString());
		assertEquals("",expectedPastMeetingWNotes.toString(),secondInputMeeting.toString());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeeting(int)}.
	 */
	@Test
	public final void testGetFutureMeeting() {
		//TODO > what happens if an index for a past meeting is requested? initially null is fine, but later it could check if the index is part of meetings and not futureMeeting << write new test for exception handling
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetFutureMeeting>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		Calendar expectedDate = new GregorianCalendar(2014,5,13);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		FutureMeeting expectedFutureMeeting = new FutureMeetingImpl(0,expectedDate,expectedContacts);
		//input
		FutureMeeting inputMeeting = cm.getFutureMeeting(0);
		//test
		assertEquals("",expectedFutureMeeting.toString(),inputMeeting.toString());

	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getMeeting(int)}.
	 */
	@Test
	public final void testGetMeeting() {
		//TODO need to overwrite a toString() under MeetingImpl() / < maybe just move the futureMeeting toString() to it. << make sure it handles notes accordingly (field exists, but only printed if populated)
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetMeeting>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		Calendar expectedDate = new GregorianCalendar(2013,9,5);
		Calendar secondExpectedDate = new GregorianCalendar(2013,10,5);
		Calendar thirdExpectedDate = new GregorianCalendar(2014,5,13);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		Meeting expectedMeeting = new MeetingImpl(2,expectedDate,expectedContacts);
		Meeting expectedMeetingWNotes = new MeetingImpl(1,secondExpectedDate, expectedContacts);
		Meeting thirdExpectedMeeting = new MeetingImpl(0,thirdExpectedDate,expectedContacts);

		//input
		Meeting inputMeeting = cm.getMeeting(2);
		Meeting secondInputMeeting = cm.getMeeting(1);
		Meeting thirdInputMeeting = cm.getMeeting(0);
		//test
		assertEquals("",expectedMeeting.toString(),inputMeeting.toString());
		assertEquals("",expectedMeetingWNotes.toString(),secondInputMeeting.toString());
		assertEquals("",thirdExpectedMeeting.toString(),thirdInputMeeting.toString());


	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getMeeting(int)}.
	 */
	@Test
	public final void testGetMeetingWNotes() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetFutureMeetingListContact() {
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetFutureMeetingListContact>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		List<FutureMeeting> expectedList = new ArrayList<FutureMeeting>();
		Calendar expectedDate = new GregorianCalendar(2014,5,13);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		Contact inputContact = new ContactImpl(0,"Hans Gruber");
		expectedContacts.add(inputContact);
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		FutureMeeting expectedFutureMeeting = new FutureMeetingImpl(0,expectedDate,expectedContacts);
		expectedList.add(expectedFutureMeeting);
		//input
		List<Meeting> inputList = cm.getFutureMeetingList(inputContact);
		//test
		assertEquals("",expectedList.get(0).getId(), inputList.get(0).getId());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(java.util.Calendar)}.
	 */
	@Test
	public final void testGetFutureMeetingListCalendar() {
		//test stub :
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetFutureMeetingCalendar>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		List<FutureMeeting> expectedList = new ArrayList<FutureMeeting>();
		Calendar expectedDate = new GregorianCalendar(2014,5,13);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		Calendar inputDate = expectedDate;
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		FutureMeeting expectedFutureMeeting = new FutureMeetingImpl(0,expectedDate,expectedContacts);
		expectedList.add(expectedFutureMeeting);
		//input
		List<Meeting> inputList = cm.getFutureMeetingList(inputDate);
		//test
		assertEquals("",expectedList.get(0).getId(), inputList.get(0).getId());	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetPastMeetingList() {
		//test stub :
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<testGetPastMeetingList>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		List<PastMeeting> expectedList = new ArrayList<PastMeeting>();
		Calendar expectedDate = new GregorianCalendar(2013,9,05);
		Calendar secondExpectedDate = new GregorianCalendar(2013,10,05);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		Contact inputContact = new ContactImpl(0,"Hans Gruber");
		expectedContacts.add(inputContact);
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		String expectedNotes = "Nakatomi Plaza at 9pm";
		PastMeeting secondExpectedPastMeeting = new PastMeetingImpl(1,secondExpectedDate, expectedContacts,expectedNotes);
		PastMeeting expectedPastMeeting = new PastMeetingImpl(2,expectedDate,expectedContacts);
		expectedList.add(expectedPastMeeting);
		expectedList.add(secondExpectedPastMeeting);
		//input
		List<PastMeeting> inputList = cm.getPastMeetingList(inputContact);
		//test
		assertEquals("",expectedList.get(1).getId(), inputList.get(1).getId());

	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test
	public final void testAddNewPastMeeting() {
		//test stub :
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<addNewPastMeeting>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		vm = new ValuesManagerImpl();
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(3, "Fritz"));
		expectedContacts.add(new ContactImpl(15, "Sterling Archer"));
		expectedContacts.add(new ContactImpl(12, "Barefoot Grub Patch"));
		Calendar expectedDate = new GregorianCalendar(2014,11,15);
		int expectedPastMeetingId = vm.newIdGenerator(paf.getMeetingsIdIndex());
		String expectedNotes = "";
		PastMeeting expectedPastMeeting = new PastMeetingImpl(expectedPastMeetingId, expectedDate, expectedContacts);
		//input
		cm.addNewPastMeeting(expectedContacts, expectedDate, expectedNotes);
		PastMeeting inputMeeting = (PastMeeting)cm.getMeeting(expectedPastMeetingId);
		//test
		assertEquals("add new past meeting is not adding the meeting as supposed",expectedPastMeeting.toString(), inputMeeting.toString());

	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test
	public final void testAddMeetingNotes() {
		//test stub :
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<addMeetingNotes>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		String expectedMeetingString = "2,M,JohnMcClane HansGruber,20130905,top of Nakatomi Building";
		//input
		String inputNotes = "top of Nakatomi Building";
		cm.addMeetingNotes(2, inputNotes);
		//test
		assertEquals("",expectedMeetingString.toString(), cm.getPastMeeting(2).toString());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewContact(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddNewContact() {
		fail("Not yet implemented"); // TODO
		//test stub :
		//debug
		debugStr = "<<<<<<<<<<<<<<<<<<<<addNewContact>>>>>>>>>>>>>>>";
		System.out.println(debugStr);
		//expected
		//input
		//test
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
