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

	private String notes;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts, String notes) {
		super(inputId, date, contacts);
		this.notes = notes;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.PastMeeting#getNotes()
	 */
	@Override
	public String getNotes() {
		// TODO Auto-generated method stub
		return notes;
	}

}
