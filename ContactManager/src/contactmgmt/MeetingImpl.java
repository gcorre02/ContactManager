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
public class MeetingImpl implements Meeting {

	private int id;
	private Calendar date;
	private Set<Contact> contacts;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public MeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		this.id = inputId;
		this.date = date;
		this.contacts = contacts;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getDate()
	 */
	@Override
	public Calendar getDate() {
		return this.date;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getContacts()
	 */
	@Override
	public Set<Contact> getContacts() {
		return this.contacts;
	}
		
}
