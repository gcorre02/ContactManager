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
public class PastMeetingImpl extends MeetingImpl implements PastMeeting{


	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * @param notes
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts, String notes) {
		super(inputId, date, contacts);
		this.notes = notes;
	}
	
	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		super(inputId, date, contacts);
		this.notes = "";
	}

	/* (non-Javadoc)
	 * @see contactmgmt.PastMeeting#getNotes()
	 */
	@Override
	public String getNotes() {
		return notes;
	}
	
}
