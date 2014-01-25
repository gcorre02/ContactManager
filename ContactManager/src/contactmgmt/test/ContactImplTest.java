/**
 * 
 */
package contactmgmt.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	private String inputNotes = expectedNotes ;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ci = new ContactImpl(inputId,inputName);
		ci.addNotes(inputNotes );
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		ci = null;
	}
	//TODO <Important> need to test contacts with notes, haven't done that yet
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
		assertEquals("ContactImpl not returning notes", expectedNotes , ci.getNotes());
	}
	/**
	 *  Test method for {@link contactmgmt.ContactImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEquals() {
		ContactImpl inputContact = new ContactImpl(1, "Jeremy Storm Baker");
		ContactImpl expectedContact = new ContactImpl(1, "Jeremy Storm Baker");
		assertEquals(inputContact, expectedContact);
	}
	/**
	 *  Test method for {@link contactmgmt.ContactImpl#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEqualsSet() {
		//set1
		Set<ContactImpl> contactImplSet1 = new HashSet<ContactImpl>();
		contactImplSet1.add(new ContactImpl(1, "Jeremy Storm Baker"));
		contactImplSet1.add(new ContactImpl(2, "Sara Emil"));
		contactImplSet1.add(new ContactImpl(3, "Johnny Cash"));
		List<ContactImpl> comparableList1 = new ArrayList<ContactImpl>(contactImplSet1);
		//set1
		Set<ContactImpl> contactImplSet2 = new HashSet<ContactImpl>();
		contactImplSet2.add(new ContactImpl(1, "Jeremy Storm Baker"));
		contactImplSet2.add(new ContactImpl(2, "Sara Emil"));
		contactImplSet2.add(new ContactImpl(3, "Johnny Cash"));
		List<ContactImpl> comparableList2 = new ArrayList<ContactImpl>(contactImplSet2);
		//test
		assertTrue(comparableList1.containsAll(comparableList2));
	}

}
