/**
 * 
 */
package contactmgmt;

import java.util.Calendar;
import java.util.Set;

/**
 * @author Guilherme
 *
 */
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting{

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public FutureMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		super(inputId, date, contacts);
	}

}
