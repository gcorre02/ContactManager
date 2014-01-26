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
	//TODO <JavaDocs> review javaDocs for every method, test and impl.
	/* 
	 * will need all getters and setters for the private fields at impl 
	 * 
	 * PopulateSetsAndIndexes(String pathToFile), for each list/set = PopulateSetsandIndexes.gettersAndSetters()
	 * 
	 * WriteToFile(Meetings and COntacts sets overriden, pathToFile) *2
	 */
	
	/**
	 * 
	 * @param pathToFile
	 * @return all lines from file in an array
	 */
	List<String> readFromFile(String pathToFile);
	

	/**
	 * 
	 * @param allMeetings set of all meetings to be written to the file
	 * @param allContacts set of all contacts to be written to the file
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
	 * @return
	 */
	List<Integer> getContactsIdIndex();
	/**
	 * 
	 * @param csvRows
	 */
	void setContactsIdIndex(List<String> csvRows);
	/**
	 * 
	 * @param csvRows
	 */
	void setMeetingsIdIndex(List<String> csvRows);
	
	/**
	 * 
	 * @return
	 */
	List<Integer> getMeetingsIdIndex();
	/**
	 * 
	 * @param csvRows
	 */
	void setAllContacts(List<String> csvRows);
	/**
	 * 
	 * @return
	 */
	Set<Contact> getAllContacts();
	/**
	 * 
	 * @param csvRows
	 * @return
	 */
	List<MeetingImpl> setAllMeetings(List<String> csvRows);
	/**
	 * 
	 * @return
	 */
	Set<Meeting> getAllMeetings();
	/**
	 * 
	 * @param allMeetings
	 */
	void setAllPastMeetings(Set<Meeting> allMeetings);
	/**
	 * 
	 * @return
	 */
	Set<PastMeeting> getAllPastMeetings();
	/**
	 * 
	 * @param allPastMeetings
	 */
	void setPastMeetingsIdIndex(Set<PastMeeting> allPastMeetings);
	/**
	 * 
	 * @return
	 */
	List<Integer> getPastMeetingsIdIndex();
	/**
	 * 	
	 * @param allMeetings
	 */
	void setAllFutureMeetings(Set<Meeting> allMeetings);
	/**
	 * 
	 * @return
	 */
	Set<FutureMeeting> getAllFutureMeetings();
	/**
	 * 
	 * @param allFutureMeetings
	 */
	void setFutureMeetingsIdIndex(Set<FutureMeeting> allFutureMeetings);
	/**
	 * 
	 * @return
	 */
	List<Integer> getFutureMeetingsIdIndex();
	/**
	 * 
	 * @param allContacts
	 */
	void setContactsNameIndex(Set<Contact> allContacts);
	/**
	 * 
	 * @return
	 */
	List<String> getContactsNameIndex();
	/**
	 * 
	 * @param inputId
	 * @param contactsIdIndex
	 * @return
	 */
	<T> boolean updateIndex(T inputId, List<T> contactsIdIndex);
	/**
	 * 
	 * @param element
	 * @param elementCollection
	 * @return
	 */
	<T> boolean updateSet(T element, Set<T> elementCollection);
	/**
	 * 
	 * @param setToPrint
	 */
	<T> void printSet(Set<T> setToPrint);
	/**
	 * 
	 * @param listToPrint
	 */
	<T> void printlist(List<T> listToPrint);
}
