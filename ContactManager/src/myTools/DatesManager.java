/**
 * 
 */
package myTools;

import java.util.Calendar;

/**
 * @author Guilherme
 *
 */
public interface DatesManager {
	/*
	 *
	 * generateCalendarItem() TODO <After Deliverable Is Ready> consider adding a range in time, not just a date// later
	 * 
	 */
	
	/**
	 * checks date is in the past
	 * @param date the date being checked
	 * @return true if date is in the past
	 */
	boolean checkDateIsInThePast(Calendar date);
	
	/**
	 * TODO <Important> make this method use hours and minutes as well, and then update every date creator that isn't a test (only when meetings in the same date are organized should the be necessary - at the test level )
	 * 
	 * transforms the int inputs into a calendar object of type GregorianCalendar. TODO <After Deliverable Is Ready>  review this method to return an actual interval in time, not a static one
	 * @param year the year to add to the Calendar object
	 * @param month the month to add to the Calendar object
	 * @param day the day to add to the Calendar object
	 * @return a date(GregorianCalendar) object
	 */
	Calendar generateCalendarItem(int year, int month, int day);
	
	/**
	 * note: Calendar.before() already does this.
	 * @param date1 first date to compare
	 * @param date2 second date to compare
	 * @return returns true if date1 comes before date2
	 */
	boolean compareTwoDates(Calendar date1, Calendar date2);

}
