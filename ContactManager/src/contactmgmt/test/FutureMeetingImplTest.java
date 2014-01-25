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
import contactmgmt.FutureMeetingImpl;
import contactmgmt.Meeting;

/**
 * @author Guilherme
 *
 */
public class FutureMeetingImplTest {


	private Meeting fm;
	int inputId = 1;
	int expectedId = inputId;
	Calendar inputDate = new GregorianCalendar(2014,02,15);
	Set<Contact> inputContacts;
	Set<Contact> expectedContacts;
	Calendar expectedDate;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		inputContacts = new HashSet<Contact>();
		Contact bruce = new ContactImpl(1, "Bruce Willis");	
		inputContacts.add(bruce);
		expectedContacts = inputContacts;
		expectedDate= inputDate;
		fm = new FutureMeetingImpl(inputId, inputDate, inputContacts);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fm = null;
		inputContacts = null;
		expectedContacts = null;
		expectedDate = null;
	}


	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#FutureMeetingImpl()}.
	 */
	@Test
	public final void testFutureMeetingImpl() {
		assertTrue( fm instanceof FutureMeetingImpl);
	}

	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#getId()}.
	 */
	@Test
	public final void testGetId() {
		assertTrue("Id is not getting returned",expectedId == fm.getId());
	}

	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		assertEquals("FutureMeeting not returning date set-up",expectedDate, fm.getDate());
	}

	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#getContacts()}.
	 */
	@Test
	public final void testGetContacts() {
		assertEquals("future meetings is not returning contacts propperly", expectedContacts, fm.getContacts());
	}

}
