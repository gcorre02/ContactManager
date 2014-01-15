/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contactmgmt.Meeting;
import contactmgmt.MeetingImpl;

/**
 * @author Guilherme
 *
 */
public class MeetingImplTest {
	Meeting m;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		m = new MeetingImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#MeetingImpl()}.
	 */
	@Test
	public final void testMeetingImpl() {
		assertTrue( m instanceof MeetingImpl);
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getId()}.
	 */
	@Test
	public final void testGetId() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getDate()}.
	 */
	@Test
	public final void testGetDate() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.MeetingImpl#getContacts()}.
	 */
	@Test
	public final void testGetContacts() {
		fail("Not yet implemented"); // TODO
	}

}
