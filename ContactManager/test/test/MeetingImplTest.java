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
import contactmgmt.Meeting;
import contactmgmt.MeetingImpl;

/**
 * @author Guilherme
 *
 */
public class MeetingImplTest {
	
	private Meeting m;
	private int inputId = 1;
	private Set<Contact> inputContacts = new HashSet<Contact>();
	private Calendar inputDate = new GregorianCalendar(2014,02,15);
	Contact bruce = new ContactImpl(1, "Bruce Willis");
	inputContacts.add(bruce);
	/*
	private int expectedId = inputId;
	private Set<Contact> expectedContacts = inputContacts;
	private Calendar expectedDate = inputDate;
	*/
	
	
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new MeetingImpl(inputId, inputDate, inputContacts);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#MeetingImpl()}.
	 */
	@Test
	public void testMeetingImpl() {
		assertTrue( m instanceof MeetingImpl);
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getId()}.
	 */
	@Test
	public void testGetId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getDate()}.
	 */
	@Test
	public void testGetDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getContacts()}.
	 */
	@Test
	public void testGetContacts() {
		fail("Not yet implemented"); // TODO
	}

}
