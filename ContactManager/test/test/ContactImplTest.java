/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contactmgmt.Contact;
import contactmgmt.ContactImpl;

/**
 * @author Guilherme
 *
 */
public class ContactImplTest {
	private Contact ci;
	private int inputId = 1;
	private	int expectedId = 1;
	private String inputName = "John McClane";
	private String expectedName = inputName;
	private String expectedNotes = "YepeeKyay MF";

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ci = new ContactImpl(inputId,inputName);
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
		assertTrue("ContactImpl not returning ID",ci.getId() == expectedId);
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#getName()}.
	 */
	@Test
	public final void testGetName() {
		assertEquals("ContactImpl not returning name", expectedName, ci.getName());
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#getNotes()}.
	 */
	@Test
	public final void testGetNotes() {
		assertEquals("ContactImpl not returning notes", expectedNotes , ci.getNotes());
	}

	/**
	 * Test method for {@link contactmgmt.ContactImpl#addNotes(java.lang.String)}.
	 */
	@Test
	public final void testAddNotes() {
		fail("Not yet implemented"); // TODO
	}

}
