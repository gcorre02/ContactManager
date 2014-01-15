/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contactmgmt.ContactManager;
import contactmgmt.ContactManagerImpl;

/**
 * @author Guilherme
 *
 */
public class ContactManagerImplTest {
	ContactManager cm;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		cm = new ContactManagerImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		cm = null;
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
		fail("Not yet implemented"); // TODO
		
		/*
		 * TODO implement myTools.checkIdExistsInList(int id, List<Integer> anyIntegerList) > mock interface for the test
		 */
	}


	/**
	 * Test method for {@link contactmgmt.ContactManagerImpl#getPastMeeting(int)}.
	 */
	@Test
	public final void testGetPastMeeting() {
		fail("Not yet implemented"); // TODO
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
