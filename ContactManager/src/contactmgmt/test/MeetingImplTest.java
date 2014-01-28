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
import contactmgmt.MeetingImpl;

/**
 * @author Guilherme
 *
 */
public class MeetingImplTest {

	private Meeting m;
	private int inputId = 1;
	private Set<Contact> inputContacts;
	private Calendar inputDate;
	private int expectedId;
	private Set<Contact> expectedContacts;
	private Calendar expectedDate;





	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		inputContacts = new HashSet<Contact>();
		Contact bruce = new ContactImpl(1, "Bruce Willis");
		inputContacts.add(bruce);
		inputDate = new GregorianCalendar(2014,02,15);
		expectedId = inputId;
		expectedContacts = inputContacts;
		expectedDate = inputDate;
		m = new MeetingImpl(inputId, inputDate, inputContacts);

	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		m = null;
		inputContacts = null;
		inputDate = null;
		expectedContacts = null;
		expectedDate = null;
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
		assertEquals("Meeting not returning ID", expectedId, m.getId());
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getDate()}.
	 */
	@Test
	public void testGetDate() {
		assertEquals("Meeting not returning date/ or constructor not setting up date",expectedDate, m.getDate());
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getContacts()}.
	 */
	@Test
	public void testGetContacts() {
		assertEquals("Meeting not returning contacts or Contructor not instantiating them", expectedContacts, m.getContacts());
	}
	/**
	 * Test method for {@link contactmgmt.MeetingImpl#equals()}.
	 */
	@Test
	public void testEquals() {
		//input1
		Calendar date1 = new GregorianCalendar(2013,11,25);
		Set<Contact> contacts1 = new HashSet<Contact>();
		contacts1.add(new ContactImpl(1,"Lord Byron"));
		contacts1.add(new ContactImpl(2,"Lord Bacon"));
		contacts1.add(new ContactImpl(3,"Lord Buster"));
		Meeting m1 = new MeetingImpl(1,date1,contacts1);
		//input2
		Calendar date2 = new GregorianCalendar(2013,11,25);
		Set<Contact> contacts2 = new HashSet<Contact>();
		contacts2.add(new ContactImpl(1,"Lord Byron"));
		contacts2.add(new ContactImpl(2,"Lord Bacon"));
		contacts2.add(new ContactImpl(3,"Lord Buster"));
		Meeting m2 = new MeetingImpl(1,date2,contacts2);
		//test
		assertEquals(m1,m2);
	}

}
