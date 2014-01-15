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
import contactmgmt.FutureMeetingImpl;
import contactmgmt.Meeting;
import contactmgmt.MeetingImpl;

/**
 * @author Guilherme
 *
 */
public class FutureMeetingImplTest {

	
	private Meeting fm;
	private int inputId = 1;
	private Set<Contact> inputContacts = new HashSet<Contact>();
	private Calendar inputDate = new GregorianCalendar(2014,02,15);
	Contact bruce = new ContactImpl(1, "Bruce Willis");

	
	private int expectedId = inputId;
	private Set<Contact> expectedContacts = inputContacts;
	private Calendar expectedDate = inputDate;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		fm = new FutureMeetingImpl(inputId, inputDate, inputContacts);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		fm = null;
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
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.FutureMeetingImpl#getContacts()}.
	 */
	@Test
	public final void testGetContacts() {
		fail("Not yet implemented"); // TODO
	}

}
