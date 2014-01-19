/**
 * 
 */
package contactmgmt;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;

/**
 * @author Guilherme
 *
 */
public class ContactManagerImpl implements ContactManager {
	
	/*
	 * variables that might need declaring
	private List<Integer> pastMeetingsIdIndex;
	private List<Integer> futureMeetingsIdIndex;
	private List<Integer> contactsIdIndex;
	private List<String> contactsNameIndex;
	private Set<Contact> allContacts;
	private Set<Meeting> allMeetings;
	private Set<PastMeeting> allPastMeetings;
	private Set<FutureMeeting> allFutureMeetings;
	private List<String> csvRows;
	private List<Integer> pastMeetingsWithNotesIndex;
	
	 */
	
	//declare inner variables:
	@SuppressWarnings("unused")
	private PopulatorAndFlusher paf;
	private String pathToFile = "."+ File.separator +"contactsTest.txt";
	
	/**
	 * 
	 */
	public ContactManagerImpl() {
		paf = new PopulatorAndFlusherImpl(pathToFile);
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addFutureMeeting(java.util.Set, java.util.Calendar)
	 */
	@Override
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getPastMeeting(int)
	 */
	@Override
	public PastMeeting getPastMeeting(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeeting(int)
	 */
	@Override
	public FutureMeeting getFutureMeeting(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getMeeting(int)
	 */
	@Override
	public Meeting getMeeting(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeetingList(contactmgmt.Contact)
	 */
	@Override
	public List<Meeting> getFutureMeetingList(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeetingList(java.util.Calendar)
	 */
	@Override
	public List<Meeting> getFutureMeetingList(Calendar date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getPastMeetingList(contactmgmt.Contact)
	 */
	@Override
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)
	 */
	@Override
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date,
			String text) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addMeetingNotes(int, java.lang.String)
	 */
	@Override
	public void addMeetingNotes(int id, String text) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addNewContact(java.lang.String, java.lang.String)
	 */
	@Override
	public void addNewContact(String name, String notes) {
		// TODO need to check if name is unique at this level

	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getContacts(int[])
	 */
	@Override
	public Set<Contact> getContacts(int... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getContacts(java.lang.String)
	 */
	@Override
	public Set<Contact> getContacts(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#flush()
	 */
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

}
