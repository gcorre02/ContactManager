/**
 * 
 */
package myTools;


import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.FutureMeeting;
import contactmgmt.Meeting;
import contactmgmt.MeetingImpl;
import contactmgmt.PastMeeting;

/**
 * @author Guilherme
 *
 */
public interface PopulatorAndFlusher {
	
	/**
	 * Collects all lines in the file into one list sorted by the order of read lines.
	 * @param pathToFile path of where the contacts.csv file is //TODO <Important> review csv file compatibility, check every reference to path reads .csv not .txt
	 * @return all lines from file in an array
	 */
	List<String> readFromFile(String pathToFile);
	

	/**
	 * 
	 *	Writes to the file defined all Meetings and contacts.
	 *
	 * @param pathToFile location of the file
	 */
	void  writeToFile(String pathToFile);
	
	/**
	 * 
	 * @return csvRows list of rows in the textFile
	 */
	List<String> getCsvRows();
	
	/**
	 * 
	 * @return All the ids of contacts.
	 */
	List<Integer> getContactsIdIndex();
	/**
	 * populates the Index of ids as a list of integers.
	 * 
	 * @param csvRows
	 */
	void setContactsIdIndex(List<String> csvRows);
	/**
	 * populates an index of meetings as a list.
	 * 
	 * @param csvRows 
	 */
	void setMeetingsIdIndex(List<String> csvRows);
	
	/**
	 * 
	 * @return a list of ids that represents each meeting in the set for all meetings.
	 */
	List<Integer> getMeetingsIdIndex();
	
	/**
	 * populates the contacts set.
	 * @param csvRows
	 */
	void setAllContacts(List<String> csvRows);
	/**
	 * 
	 * @return the set of all contacts.
	 */
	Set<Contact> getAllContacts();
	/**
	 * populates all meetings into an index
	 * @param csvRows
	 * @return The list of all meetings 
	 */
	List<MeetingImpl> setAllMeetings(List<String> csvRows);
	/**
	 * 
	 * @return returns all meetings
	 */
	Set<Meeting> getAllMeetings();
	/**
	 * populates all past meetings set from the set of all meetings.
	 * @param allMeetings
	 */
	void setAllPastMeetings(Set<Meeting> allMeetings);
	/**
	 * 
	 * @return all past meetings as a set
	 */
	Set<PastMeeting> getAllPastMeetings();
	/**
	 * populates the index for past meetings
	 * @param allPastMeetings
	 */
	void setPastMeetingsIdIndex(Set<PastMeeting> allPastMeetings);
	/**
	 * 
	 * @return index of ids for all past meetings
	 */
	List<Integer> getPastMeetingsIdIndex();
	/**
	 * 	populates the set of all future meetings from all meetings set
	 * @param allMeetings
	 */
	void setAllFutureMeetings(Set<Meeting> allMeetings);
	/**
	 * 
	 * @return all future meetings as a set
	 */
	Set<FutureMeeting> getAllFutureMeetings();
	/**
	 * populates the index of future meetings
	 * @param allFutureMeetings
	 */
	void setFutureMeetingsIdIndex(Set<FutureMeeting> allFutureMeetings);
	/**
	 * 
	 * @return the index of future meetings
	 */
	List<Integer> getFutureMeetingsIdIndex();
	/**
	 * populate the index of names for contacts 
	 * @param allContacts
	 */
	void setContactsNameIndex(Set<Contact> allContacts);
	/**
	 * 
	 * @return the names based index for all contacts
	 */
	List<String> getContactsNameIndex();
	/**
	 * 
	 * @param inputId the id to add to the index
	 * @param contactsIdIndex any list to add the inputId to.
	 * @return true if the id didn't exist there before, false if it did, and it is removed.
	 */
	<T> boolean updateIndex(T inputId, List<T> contactsIdIndex);
	/**
	 * 
	 * @param element object to be added to the collection
	 * @param elementCollection the collection to add the element to
	 * @return true if object wasnt part of the collection, false if it did. it is then removed.
	 */
	<T> boolean updateSet(T element, Set<T> elementCollection);
	/**
	 * prints the inputted set
	 * @param setToPrint
	 */
	<T> void printSet(Set<T> setToPrint);
	/**
	 * prints the inputed list
	 * @param listToPrint
	 */
	<T> void printlist(List<T> listToPrint);
}
