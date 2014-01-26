/**
 * 
 */
package myTools.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import myTools.DatesManager;
import myTools.DatesManagerImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Guilherme
 *
 */
public class DatesManagerImplTest {
	DatesManager dm;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		dm = new DatesManagerImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		dm = null;
	}

	/**
	 * Test method for {@link myTools.DatesManagerImpl#checkDateIsInThePast(java.util.Calendar)}.
	 */
	@Test
	public final void testCheckDateIsInThePast() {
		Calendar date = new GregorianCalendar(2001,12,27);
		assertTrue("Date is not being recognized as being in the past", dm.checkDateIsInThePast(date));
	}

	/**
	 * Test method for {@link myTools.DatesManagerImpl#checkDateIsInThePast(java.util.Calendar)}.
	 */
	@Test
	public final void testCheckDateIsInTheFuture() {
		Calendar date = new GregorianCalendar(2014,12,27);
		assertFalse("Date is not being recognized as being in the future", dm.checkDateIsInThePast(date));
	}

	/**
	 * Test method for {@link myTools.DatesManagerImpl#generateCalendarItem(int, int, int)}.
	 */
	@Test
	public final void testGenerateCalendarItem() {
		Calendar expectedDate = new GregorianCalendar(2014,12,27,5,45);
		assertEquals("Method is not returning a new calendar",expectedDate, dm.generateCalendarItem(2014, 12, 27,5,45));
	}
	@Test
	public final void testCompareDatesReturnsTrueIfFirstDateComesBeforeSecondDate(){
		Calendar date1 = new GregorianCalendar(2015,9,5,9,35);
		Calendar date2 = new GregorianCalendar(2015,9,5,10,45);
		assertTrue(dm.compareTwoDates(date1, date2));
	}

}
