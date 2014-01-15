/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contactmgmt.Contact;
import contactmgmt.ContactImpl;

/**
 * @author Guilherme
 *
 */
public class ContactImplTest {
	Contact ci;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ci = new ContactImpl(1,"John McClane");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ci = null;
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#ContactImpl()}.
	 */
	@Test
	public final void testConstructor() {
		assertTrue(ci instanceof ContactImpl);	
	}
	

	/**
	 * Test method for {@link contactmgmt.ContactImpl#getId()}.
	 */
	@Test
	public final void testGetId() {
		// also tests if values have been passed to the object through constructor
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#getName()}.
	 */
	@Test
	public final void testGetName() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#getNotes()}.
	 */
	@Test
	public final void testGetNotes() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#addNotes(java.lang.String)}.
	 */
	@Test
	public final void testAddNotes() {
		fail("Not yet implemented"); // TODO
	}

}
