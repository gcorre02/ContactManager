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
	 * Normal constructor for a future meeting from scratch.
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public FutureMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		super(inputId, date, contacts);
	}
	/**
	 * Constructor that takes a meeting and converts it to a future meeting(doesn't take notes with it because future meetings aren't supposed to have notes.
	 * @param current
	 */
	public FutureMeetingImpl(Meeting current) {
		super(current.getId(), current.getDate(), current.getContacts());
	}

}
