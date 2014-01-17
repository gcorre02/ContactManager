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
public class DatesManagerImpl implements DatesManager {

	/* (non-Javadoc)
	 * @see myTools.DatesManager#checkDateIsInThePast(java.util.Calendar)
	 */
	@Override
	public boolean checkDateIsInThePast(Calendar date) {
		Calendar present = Calendar.getInstance();
		if(present.compareTo(date)>=0){
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see myTools.DatesManager#generateCalendarItem(int, int, int)
	 */
	@Override
	public Calendar generateCalendarItem(int year, int month, int day) {
		Calendar date = new GregorianCalendar(year,month,day);
		return date;
	}

}
