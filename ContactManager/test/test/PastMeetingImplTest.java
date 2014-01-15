/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contactmgmt.Contact;
import contactmgmt.ContactImpl;
import contactmgmt.PastMeetingImpl;
import contactmgmt.Meeting;

/**
 * @author Guilherme
 *
 */
public class PastMeetingImplTest {

	
	private Meeting fm;
	private int inputId = 1;
	private Set<Contact> inputContacts = new HashSet<Contact>();
	private Calendar inputDate = new GregorianCalendar(2014,02,15);
	Contact bruce = new ContactImpl(1, "Bruce Willis");
	//inputContacts.add(bruce);
	
	private int expectedId = inputId;
	private Set<Contact> expectedContacts = inputContacts;
	private Calendar expectedDate = inputDate;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fm = new PastMeetingImpl(inputId, inputDate, inputContacts);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fm = null;
	}


	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#PastMeetingImpl()}.
	 */
	@Test
	public final void testFutureMeetingImpl() {
		assertTrue( fm instanceof PastMeetingImpl);
	}

	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getId()}.
	 */
	@Test
	public final void testGetId() {
		assertTrue("Id is not getting returned",expectedId == fm.getId());
	}

	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		assertEquals("FutureMeeting not returning date set-up",expectedDate, fm.getDate());
	}

	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getContacts()}.
	 */
	@Test
	public final void testGetContacts() {
		assertEquals("future meetings is not returning contacts propperly", expectedContacts, fm.getContacts());
	}


	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getNotes()}.
	 */
	@Test
	public final void testGetNotes() {
		fail("Not yet implemented"); // TODO
	}
	
}

