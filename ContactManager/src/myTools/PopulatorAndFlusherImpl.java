/**
 * 
 */
package myTools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.Meeting;

/**
 * @author Guilherme
 *
 */
public class PopulatorAndFlusherImpl implements PopulatorAndFlusher {
	
	private List<Integer> meetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> pastMeetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> futureMeetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> contactsIdIndex= new ArrayList<Integer>();
	private List<String> contactsNameIndex= new ArrayList<String>();
	private Set<Contact> allContacts = new HashSet<Contact>();
	private Set<Meeting> allMeetings = new HashSet<Meeting>();
	private Set<Meeting> allPastMeetings = new HashSet<Meeting>();
	private Set<Meeting> allFutureMeetings = new HashSet<Meeting>();
	
	/* (non-Javadoc)
	 * @see myTools.PopulatorAndFlusher#PopulateSetsAndIndexes(java.lang.String)
	 */
	@Override
	public void PopulateSetsAndIndexes(String pathToFile) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see myTools.PopulatorAndFlusher#WriteToFile(java.util.Set, java.util.Set, java.lang.String)
	 */
	@Override
	public void WriteToFile(Set<Meeting> allMeetings, Set<Contact> allContacts,
			String pathToFile) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the contactsIdIndex
	 */
	public List<Integer> getContactsIdIndex() {
		return contactsIdIndex;
	}

	/**
	 * @param contactsIdIndex the contactsIdIndex to set
	 */
	public void setContactsIdIndex(List<Integer> contactsIdIndex) {
		this.contactsIdIndex = contactsIdIndex;
	}

	/**
	 * @return the meetingsIdIndex
	 */
	public List<Integer> getMeetingsIdIndex() {
		return meetingsIdIndex;
	}

	/**
	 * @param meetingsIdIndex the meetingsIdIndex to set
	 */
	public void setMeetingsIdIndex(List<Integer> meetingsIdIndex) {
		this.meetingsIdIndex = meetingsIdIndex;
	}

	/**
	 * @return the pastMeetingsIdIndex
	 */
	public List<Integer> getPastMeetingsIdIndex() {
		return pastMeetingsIdIndex;
	}

	/**
	 * @param pastMeetingsIdIndex the pastMeetingsIdIndex to set
	 */
	public void setPastMeetingsIdIndex(List<Integer> pastMeetingsIdIndex) {
		this.pastMeetingsIdIndex = pastMeetingsIdIndex;
	}

	/**
	 * @return the futureMeetingsIdIndex
	 */
	public List<Integer> getFutureMeetingsIdIndex() {
		return futureMeetingsIdIndex;
	}

	/**
	 * @param futureMeetingsIdIndex the futureMeetingsIdIndex to set
	 */
	public void setFutureMeetingsIdIndex(List<Integer> futureMeetingsIdIndex) {
		this.futureMeetingsIdIndex = futureMeetingsIdIndex;
	}

	/**
	 * @return the contactsNameIndex
	 */
	public List<String> getContactsNameIndex() {
		return contactsNameIndex;
	}

	/**
	 * @param contactsNameIndex the contactsNameIndex to set
	 */
	public void setContactsNameIndex(List<String> contactsNameIndex) {
		this.contactsNameIndex = contactsNameIndex;
	}

	/**
	 * @return the allContacts
	 */
	public Set<Contact> getAllContacts() {
		return allContacts;
	}

	/**
	 * @param allContacts the allContacts to set
	 */
	public void setAllContacts(Set<Contact> allContacts) {
		this.allContacts = allContacts;
	}

	/**
	 * @return the allMeetings
	 */
	public Set<Meeting> getAllMeetings() {
		return allMeetings;
	}

	/**
	 * @param allMeetings the allMeetings to set
	 */
	public void setAllMeetings(Set<Meeting> allMeetings) {
		this.allMeetings = allMeetings;
	}

	/**
	 * @return the allPastMeetings
	 */
	public Set<Meeting> getAllPastMeetings() {
		return allPastMeetings;
	}

	/**
	 * @param allPastMeetings the allPastMeetings to set
	 */
	public void setAllPastMeetings(Set<Meeting> allPastMeetings) {
		this.allPastMeetings = allPastMeetings;
	}

	/**
	 * @return the allFutureMeetings
	 */
	public Set<Meeting> getAllFutureMeetings() {
		return allFutureMeetings;
	}

	/**
	 * @param allFutureMeetings the allFutureMeetings to set
	 */
	public void setAllFutureMeetings(Set<Meeting> allFutureMeetings) {
		this.allFutureMeetings = allFutureMeetings;
	}

}
