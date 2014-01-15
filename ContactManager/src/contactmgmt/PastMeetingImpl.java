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
public class PastMeetingImpl implements PastMeeting{

	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	private String notes;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts, String notes) {
		this.id = inputId;
		this.date = date;
		this.contacts = contacts;
		this.notes = notes;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getDate()
	 */
	@Override
	public Calendar getDate() {
		return date;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getContacts()
	 */
	@Override
	public Set<Contact> getContacts() {
		// TODO Auto-generated method stub
		return contacts;
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
