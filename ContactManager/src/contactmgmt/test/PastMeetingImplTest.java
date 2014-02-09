/**
 * 
 */
package contactmgmt.test;

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
import contactmgmt.Meeting;
import contactmgmt.PastMeeting;
import contactmgmt.PastMeetingImpl;


/**
 * @author Guilherme
 *
 */
public class PastMeetingImplTest {

	
	private PastMeeting pm ;
	private int inputId = 1;
	private Set<Contact> inputContacts;
	private Calendar inputDate;
	private String inputNotes;
	int expectedId = inputId;
	private String expectedNotes;
	private Set<Contact> expectedContacts;
	private Calendar expectedDate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		inputContacts = new HashSet<Contact>();
		inputDate = new GregorianCalendar(2014,02,15);
		inputNotes = new String("talked about how to tackle nakatomi plaza");
		Contact bruce = new ContactImpl(1, "Bruce Willis");
		inputContacts.add(bruce);
		expectedNotes = inputNotes;
		expectedContacts = inputContacts;
		expectedDate = inputDate;
		pm = new PastMeetingImpl(inputId, inputDate, inputContacts, inputNotes);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		pm = null;
	}


	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#PastMeetingImpl(int,java.util.Calendar,java.util.Set,java.lang.String)}.
	 */
	@Test
	public final void testPastMeetingImpl() {
		assertTrue( pm instanceof PastMeetingImpl);
	}
	
	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#PastMeetingImpl(int,java.util.Calendar,java.util.Set,java.lang.String)}.
	 */
	@Test
	public final void testPastMeetingImplWoutNotes() {
		pm= null;
		pm = new PastMeetingImpl(inputId, inputDate, inputContacts);
		assertTrue( pm instanceof PastMeetingImpl);
		assertEquals("PastMeetingImpl Constructor not not passing notes as empty string", pm.getNotes(), "");
	}
	
	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getId()}.
	 */
	@Test
	public final void testGetId() {
		assertTrue("Id is not getting returned",expectedId == pm.getId());
	}

	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		assertEquals("FutureMeeting not returning date set-up",expectedDate, pm.getDate());
	}

	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getContacts()}.
	 */
	@Test
	public final void testGetContacts() {
		assertEquals("future meetings is not returning contacts propperly", expectedContacts, pm.getContacts());
	}


	/**
	 * Test method for {@link contactmgmt.PastMeetingImpl#getNotes()}.
	 */
	@Test
	public final void testGetNotes() {
		assertEquals("PastMeeting not returning notes", expectedNotes, pm.getNotes()); 
	}
	
	/**
	 * Tests whether a method with return type Meeting returns PastMeeting.
	 * (tests the implementation and extension are working as expected)
	 */
	@Test
	public final void testMeetingReturnsPastMeeting(){
		assertTrue( returnPastMeeting() instanceof PastMeetingImpl);
		PastMeetingImpl meetingUnderTest = (PastMeetingImpl) returnPastMeeting();
		assertEquals("PastMeetingImpl Constructor not passing notes as empty string", meetingUnderTest.getNotes(), inputNotes);
	}
	
	private Meeting returnPastMeeting(){
		return pm;
	}
}

