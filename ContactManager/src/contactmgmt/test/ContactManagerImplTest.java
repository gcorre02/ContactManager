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
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;
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
	String pathToFile = "."+ File.separator +"contactsTest.csv";
	PopulatorAndFlusher paf;
	ValuesManager vm;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {

		PrintWriter writer;
		try {
			writer = new PrintWriter(pathToFile, Charset.defaultCharset().toString());
			//Write stub file
			writer.println("0,M,HansGruber JohnMcClane,201405130530");
			writer.println("1,M,HansGruber JohnMcClane,201310050530,Nakatomi Plaza at 9pm");
			writer.println("2,M,HansGruber JohnMcClane,201309050530");
			writer.println("0,C,Hans Gruber");
			writer.println("1,C,John Mc Clane");
			writer.println("2,C,Tony");
			writer.println("3,C,Fritz");
			writer.println("4,C,Harry Ellis");
			writer.println("5,C,Theo theDriver");
			writer.println("6,C,Holly Genero, the mother");
			writer.println("7,C,Karl");
			writer.println("8,C,Klaus");
			writer.println("12,C,Barefoot Grub Patch");
			writer.println("13,C,Fritz Lang");
			writer.println("14,C,Johnny Fritz ");
			writer.println("15,C,Fritz Hansen");
			writer.println("16,C,Sterling Archer");
			writer.println("31,C,Salamander Lang");
			writer.println("32,C,Johnny Salamander ");
			writer.println("33,C,Salamander Hansen");
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

	@Test
	public final void checkThatCMcanStartUpWithoutAContactsFile(){
		//does what it says on the tin
		//setup
		cm = null;
		File file = new File(pathToFile);
		file.delete();
		//test
		cm = new ContactManagerImpl();	
		assertTrue(cm.getPaf().getAllMeetings().isEmpty());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addFutureMeeting(java.util.Set, java.util.Calendar)}.
	 */
	@Test
	public final void testAddFutureMeetingIsAdded() {
		//input variables
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(3, "Fritz"));
		inputContacts.add(new ContactImpl(16, "Sterling Archer"));
		inputContacts.add(new ContactImpl(12, "Barefoot Grub Patch"));
		Calendar inputDate = new GregorianCalendar(2014,11,15);
		int futureMeetingId = cm.addFutureMeeting(inputContacts, inputDate);
		//test setUp
		vm = new ValuesManagerImpl();
		boolean assertResult = vm.checkIdExistsInList(futureMeetingId, cm.getPaf().getFutureMeetingsIdIndex());
		//test
		assertTrue("addFutureMeeting not adding the meeting to the contactManager DB", assertResult);
	}


	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test
	public final void testGetPastMeeting() {
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
		assertEquals("",expectedPastMeeting.getId(),inputMeeting.getId());
		assertEquals("",expectedPastMeetingWNotes.getId(),secondInputMeeting.getId());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeeting(int)}.
	 */
	@Test
	public final void testGetFutureMeeting() {
		//expected
		Calendar expectedDate = new GregorianCalendar(2014,5,13);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		FutureMeeting expectedFutureMeeting = new FutureMeetingImpl(0,expectedDate,expectedContacts);
		//input
		FutureMeeting inputMeeting = cm.getFutureMeeting(0);
		//test
		assertEquals("",expectedFutureMeeting.getId(),inputMeeting.getId());

	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getMeeting(int)}.
	 */
	@Test
	public final void testGetMeeting() {
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
		assertEquals("",expectedMeeting.getId(),inputMeeting.getId());
		assertEquals("",expectedMeetingWNotes.getId(),secondInputMeeting.getId());
		assertEquals("",thirdExpectedMeeting.getId(),thirdInputMeeting.getId());


	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetFutureMeetingListContact() {
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
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(contactmgmt.Contact)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetFutureMeetingListExceptionContact() {
		//expected
		Contact contactInput = new ContactImpl(79, "Kimosabe");
		//test
		cm.getFutureMeetingList(contactInput);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeetingList(contactmgmt.Contact)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetPastMeetingListExceptionContact() {
		//expected
		Contact contactInput = new ContactImpl(79, "Older Kimosabe");
		//test
		cm.getFutureMeetingList(contactInput);

	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeetingList(java.util.Calendar)}.
	 */
	@Test
	public final void testGetFutureMeetingListCalendar() {
		
		//expected
		List<FutureMeeting> expectedList = new ArrayList<FutureMeeting>();
		Calendar expectedDate = new GregorianCalendar(2014,5,13,05,30);
		Calendar expectedDate1 = new GregorianCalendar(2014,5,13,9,23);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		Calendar inputDate = new GregorianCalendar(2014,5,13);
		expectedContacts.add(new ContactImpl(0,"Hans Gruber"));
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		FutureMeeting expectedFutureMeeting = new FutureMeetingImpl(0,expectedDate,expectedContacts);
		expectedList.add(expectedFutureMeeting);

		//add another future meeting with the same date
		cm.addFutureMeeting(expectedContacts, expectedDate1);
		FutureMeeting expectedFutureMeeting1 = new FutureMeetingImpl(3,expectedDate1,expectedContacts);
		expectedList.add(expectedFutureMeeting1);

		//input
		List<Meeting> inputList = cm.getFutureMeetingList(inputDate);
		
		//test
		assertEquals("",expectedList.get(0).getId(), inputList.get(0).getId());
		assertEquals("",expectedList.get(1).getId(), inputList.get(1).getId());
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeetingList(contactmgmt.Contact)}.
	 */
	@Test
	public final void testGetPastMeetingList() {
		//expected
		List<PastMeetingImpl> expectedList = new ArrayList<PastMeetingImpl>();
		Calendar expectedDate = new GregorianCalendar(2013,9,05,05,30);
		Calendar secondExpectedDate = new GregorianCalendar(2013,10,05,05,30);
		Set<Contact> expectedContacts = new HashSet<Contact>();
		Contact inputContact = new ContactImpl(0,"Hans Gruber");
		expectedContacts.add(inputContact);
		expectedContacts.add(new ContactImpl(1,"John Mc Clane"));
		String expectedNotes = "Nakatomi Plaza at 9pm";
		PastMeetingImpl secondExpectedPastMeeting = new PastMeetingImpl(1,secondExpectedDate, expectedContacts,expectedNotes);
		PastMeetingImpl expectedPastMeeting = new PastMeetingImpl(2,expectedDate,expectedContacts);
		expectedList.add(expectedPastMeeting);
		expectedList.add(secondExpectedPastMeeting);
		//input
		List<PastMeetingImpl> inputList = new ArrayList<PastMeetingImpl>(); 
		for(PastMeeting iter :	cm.getPastMeetingList(inputContact)){
			inputList.add((PastMeetingImpl)iter);
		}
		//test
		assertTrue(expectedList.containsAll(inputList));

	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test
	public final void testAddNewPastMeeting() {
		//expected
		vm = new ValuesManagerImpl();
		Set<Contact> expectedContacts = new HashSet<Contact>();
		expectedContacts.add(new ContactImpl(3, "Fritz"));
		expectedContacts.add(new ContactImpl(16, "Sterling Archer"));
		expectedContacts.add(new ContactImpl(12, "Barefoot Grub Patch"));
		Calendar expectedDate = new GregorianCalendar(2011,11,15);
		int expectedPastMeetingId = vm.newIdGenerator(cm.getPaf().getMeetingsIdIndex());
		String expectedNotes = "watching too much tv";
		PastMeeting expectedPastMeeting = new PastMeetingImpl(expectedPastMeetingId, expectedDate, expectedContacts, expectedNotes);
		//input
		cm.addNewPastMeeting(expectedContacts, expectedDate, expectedNotes);
		PastMeeting inputMeeting = (PastMeeting)cm.getMeeting(expectedPastMeetingId);
		//test
		assertEquals("add new past meeting is not adding the meeting as supposed",expectedPastMeeting.toString(), inputMeeting.toString());

	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testaddNewPastMeetingEmptyContacts() {
		//expected
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		String text = "";
		Calendar date = new GregorianCalendar();
		//test
		cm.addNewPastMeeting(inputContacts, date, text);//empty contacts

	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testaddNewPastMeetingIllegal1oneoftheArgs() {
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(1,"Guybrush Threepwood"));
		inputContacts.add(new ContactImpl(8,"Klaus"));
		inputContacts.add(new ContactImpl(2,"Tony"));

		String text = "";
		Calendar date = new GregorianCalendar(1995,3,12);
		
		//test
		cm.addNewPastMeeting(inputContacts, date, text);//one of the contacts doesn't exist
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test(expected = NullPointerException.class)
	public final void testaddNewPastMeetingNull() {
		//expected
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(1,"Guybrush Threepwood"));
		inputContacts.add(new ContactImpl(8,"Klaus"));
		inputContacts.add(new ContactImpl(2,"Tony"));
		String text = "";
		Calendar date = new GregorianCalendar(1988,11,23);
		//test
		cm.addNewPastMeeting(null, date, text);
		cm.addNewPastMeeting(inputContacts, null, text);
		cm.addNewPastMeeting(inputContacts, date, null);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testaddNewPastMeetingDateException() {
		//expected
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(1,"Guybrush Threepwood"));
		inputContacts.add(new ContactImpl(8,"Klaus"));
		inputContacts.add(new ContactImpl(2,"Tony"));
		String text = "Some monkey island note";
		Calendar date = new GregorianCalendar(2015,10,4);
		//test
		cm.addNewPastMeeting(inputContacts, date, text);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getFutureMeeting(int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetFutureMeetingIdBelongsPastMeeting() {
		//expected

		//input
		int id = 2;

		//test
		cm.getFutureMeeting(id);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetPastMeetingIdBelongsPastMeeting() {
		//expected

		//input
		int id = 0;

		//test
		cm.getPastMeeting(id);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testAddFutureMeetingDateIsInThePast() {
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(3,"Fritz"));
		Calendar inputDate = new GregorianCalendar(2005,4,25);
		//test
		cm.addFutureMeeting(inputContacts, inputDate);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testAddFutureMeetingContactUnknown() {
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		inputContacts.add(new ContactImpl(34,"Jonah"));
		Calendar inputDate = new GregorianCalendar(2015,4,25);
		//test
		cm.addFutureMeeting(inputContacts, inputDate);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testAddFutureMeetingContactsIsEmpty() {
		//input
		Set<Contact> inputContacts = new HashSet<Contact>();
		Calendar inputDate = new GregorianCalendar(2015,4,25);
		//test
		cm.addFutureMeeting(inputContacts, inputDate);
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testaddNewPastMeetingIllegalArgsDateinFuture() {
		//input
		Set<Contact> realInputContacts = new HashSet<Contact>();
		String text = "";
		Calendar dateInTheFuture = new GregorianCalendar();
		//test
		cm.addNewPastMeeting(realInputContacts, dateInTheFuture, text);//date is in the future
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test
	public final void testAddMeetingNotes() {
		//expected
		String expectedMeetingString = "top of Nakatomi Building";
		//input
		String inputNotes = "top of Nakatomi Building";
		cm.addMeetingNotes(2, inputNotes);
		//test
		assertEquals("",expectedMeetingString, cm.getPastMeeting(2).getNotes());
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test(expected = NullPointerException.class)
	public final void testAddMeetingNotesNullExceptionHandler() {
		//test
		String inputNotes = null;
		cm.addMeetingNotes(2, inputNotes);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testAddMeetingNotesIllegealArgsExceptionExceptionHandler() {
		//test
		cm.addMeetingNotes(8, "discussed the blueprints for the nakatomi building construction");
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addMeetingNotes(int, java.lang.String)}.
	 */
	@Test(expected = IllegalStateException.class)
	public final void testAddMeetingNotesIllegealIllegalStateException() {
		//test
		cm.addMeetingNotes(0, "ze germans are coming");
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewContact(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testAddNewContact() {
		//expected
		List<Integer> inputIndex = cm.getPaf().getContactsIdIndex();
		vm = new ValuesManagerImpl();
		//input
		cm.addNewContact("Basil Towers", "Has a fawlty network");
		//test
		assertTrue("Meeting is not being added", vm.checkIdExistsInList(9, inputIndex));
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#addNewContact(java.lang.String, java.lang.String)}.
	 */
	@Test(expected = NullPointerException.class)
	public final void testAddNewContactIllegalStringInput() {
		//test
		cm.addNewContact(null, "just some notes on the design of nakatomi's safe");
		cm.addNewContact("Fritz", null);
	}


	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(int[])}.
	 */
	@Test
	public final void testGetContactsIntArray() {
		//expected
		List<String> expectedContactList = new ArrayList<String>();
		expectedContactList.add("3,C,Fritz");
		expectedContactList.add("5,C,Theo theDriver");
		expectedContactList.add("8,C,Klaus");
		//input
		List<String> inputContactsString = new ArrayList<String>();
		List<Contact> inputContacts = new ArrayList<Contact>(cm.getContacts(3,5,8));
		Iterator<Contact> iter = inputContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			inputContactsString.add(current.toString());
		}
		//test
		for(int i = 0; i < expectedContactList.toArray().length ; i++){
			assertTrue(inputContactsString.containsAll(expectedContactList));
		}
	}

	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(int[])}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetContactsIntArrayArgs() {
		//test
		//one of ids[] not correspond to real contact
		cm.getContacts(99,1,2);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(java.lang.String)}.
	 */
	@Test
	public final void testGetContactsString() {
		//expected
		List<String> expectedContactList = new ArrayList<String>();
		expectedContactList.add("13,C,Fritz Lang");
		expectedContactList.add("14,C,Johnny Fritz ");
		expectedContactList.add("15,C,Fritz Hansen");
		expectedContactList.add("3,C,Fritz");
		//input
		List<String> inputContactsString = new ArrayList<String>();
		List<Contact> inputContacts = new ArrayList<Contact>(cm.getContacts("Fritz"));
		Iterator<Contact> iter = inputContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			inputContactsString.add(current.toString());
		}
		//test

		assertTrue(inputContactsString.containsAll(expectedContactList));

	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(java.lang.String)}.
	 */
	@Test
	public final void testGetContactsShortNameDoesntExist() {
		//expected
		List<String> expectedContactList = new ArrayList<String>();
		expectedContactList.add("31,C,Salamander Lang");
		expectedContactList.add("32,C,Johnny Salamander ");
		expectedContactList.add("33,C,Salamander Hansen");
		
		//input
		List<String> inputContactsString = new ArrayList<String>();
		List<Contact> inputContacts = new ArrayList<Contact>(cm.getContacts("Salamander"));
		Iterator<Contact> iter = inputContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			inputContactsString.add(current.toString());
		}
		//test

		assertTrue(inputContactsString.containsAll(expectedContactList));

	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(java.lang.String)}.
	 */
	@Test(expected = NullPointerException.class)
	public final void testGetContactsStringExceptionHandler() {
		//test
		String name = null;
		cm.getContacts(name);
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getContacts(java.lang.String)}.
	 */
	@Test(expected = IllegalArgumentException.class)
	public final void testGetContactsStringIllegealArgsExceptionExceptionHandler() {
		//test
		cm.getContacts("Jackson Rabbit");
	}
	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#flush()}.
	 */
	@Test
	public final void testFlush() {
		//expected
		//empty the file :
		File file = new File(pathToFile);
		file.delete();

		//create array of expected values
		List<String> expectedCsvRows = new ArrayList<String>();
		expectedCsvRows.add("0,M,HansGruber JohnMcClane,201405130530");
		expectedCsvRows.add("1,M,HansGruber JohnMcClane,201310050530,Nakatomi Plaza at 9pm");
		expectedCsvRows.add("2,M,HansGruber JohnMcClane,201309050530");
		expectedCsvRows.add("0,C,Hans Gruber");
		expectedCsvRows.add("1,C,John Mc Clane");
		expectedCsvRows.add("2,C,Tony");
		expectedCsvRows.add("3,C,Fritz");		
		expectedCsvRows.add("4,C,Harry Ellis");
		expectedCsvRows.add("5,C,Theo theDriver");
		expectedCsvRows.add("6,C,Holly Genero, the mother");
		expectedCsvRows.add("7,C,Karl");
		expectedCsvRows.add("8,C,Klaus");
		expectedCsvRows.add("12,Barefoot Grub Patch");
		expectedCsvRows.add("13,C,Fritz Lang");
		expectedCsvRows.add("14,C,Johnny Fritz ");
		expectedCsvRows.add("15,C,Fritz Hansen");
		expectedCsvRows.add("16,Sterling Archer");



		//dump to file:
		cm.flush();


		//expected
		PopulatorAndFlusher expectedPaf = new PopulatorAndFlusherImpl(pathToFile);
		List<MeetingImpl> expectedMeetings = expectedPaf.setAllMeetings(expectedCsvRows);
		//input
		List<MeetingImpl> inputMeetings = paf.setAllMeetings(cm.getPaf().getCsvRows());

		//Assert write works
		assertTrue("Write operation not working : ", expectedMeetings.containsAll(inputMeetings));
	}
	@Test
	public final void checkContactNotesArePassedToTheObject(){
		Set<Contact> testContact = cm.getContacts(6);
		assertEquals(testContact.toString(), "[6,C,Holly Genero, the mother]");
	}

}
