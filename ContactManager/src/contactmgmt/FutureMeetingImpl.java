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
public class FutureMeetingImpl implements Meeting{

	private int id;
	private Calendar date;
	private Set<Contact> contacts;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public FutureMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		this.id = inputId;
		this.date = date;
		this.contacts = contacts;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getId()
	 */
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getDate()
	 */
	@Override
	public Calendar getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getContacts()
	 */
	@Override
	public Set<Contact> getContacts() {
		// TODO Auto-generated method stub
		return null;
	}

}
