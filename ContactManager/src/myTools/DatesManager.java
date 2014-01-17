/**
 * 
 */
package myTools;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Guilherme
 *
 */
public interface DatesManager {

	/*
	 * checkDateIsInThePast(Calendar date)	
	 *
	 * generateCalendarItem() < TODO consider adding a range in time, not just a date// later
	 * 
	 */
	
	/**
	 * checks date is in the past
	 * @param date the date being checked
	 * @return true if date is in the past
	 */
	boolean checkDateIsInThePast(Calendar date);
	
	/**
	 * transforms the int inputs into a calendar object of type GregorianCalendar. TODO review this method to return an actual interval in time, not a static one
	 * @param year the year to add to the Calendar object
	 * @param month the month to add to the Calendar object
	 * @param day the day to add to the Calendar object
	 * @return a date(GregorianCalendar) object
	 */
	GregorianCalendar generateCalendarItem(int year, int month, int day);

}
