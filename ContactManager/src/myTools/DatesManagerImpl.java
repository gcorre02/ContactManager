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
	public Calendar generateCalendarItem(int year, int month, int day, int hour,int minute) {
		Calendar date = new GregorianCalendar(year,month,day, hour, minute); 
		return date;
	}

	@Override
	public boolean compareTwoDates(Calendar date1, Calendar date2) {
		
		return date1.before(date2);
	}

}
