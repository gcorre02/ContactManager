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
	 * generateCalendarItem() 
	 * 
	 */
	
	/**
	 * checks date is in the past
	 * @param date the date being checked
	 * @return true if date is in the past
	 */
	boolean checkDateIsInThePast(Calendar date);
	
	/**
	 * 
	 * transforms the int inputs into a calendar object of type GregorianCalendar. 
	 * @param year the year to add to the Calendar object
	 * @param month the month to add to the Calendar object
	 * @param day the day to add to the Calendar object
	 * @return a date(GregorianCalendar) object
	 */
	Calendar generateCalendarItem(int year, int month, int day, int hour, int minute);
	
	/**
	 * note: Calendar.before() already does this.
	 * @param date1 first date to compare
	 * @param date2 second date to compare
	 * @return returns true if date1 comes before date2
	 */
	boolean compareTwoDates(Calendar date1, Calendar date2);

}
