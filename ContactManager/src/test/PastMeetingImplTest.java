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
import contactmgmt.PastMeeting;
import contactmgmt.PastMeetingImpl;


/**
 * @author Guilherme
 *
 */
public class PastMeetingImplTest {

	
	private PastMeeting pm;
	private int inputId = 1;
	private Set<Contact> inputContacts = new HashSet<Contact>();
	private Calendar inputDate = new GregorianCalendar(2014,02,15);
	private String inputNotes = new String("talked about how to tackle nakatomi plaza");
	//inputContacts.add(bruce);
	
	private int expectedId = inputId;
	private String expectedNotes = inputNotes;
	private Set<Contact> expectedContacts = inputContacts;
	private Calendar expectedDate = inputDate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
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
	 * Test method for {@link contactmgmt.PastMeetingImpl#PastMeetingImpl()}.
	 */
	@Test
	public final void testFutureMeetingImpl() {
		assertTrue( pm instanceof PastMeetingImpl);
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
	
}

