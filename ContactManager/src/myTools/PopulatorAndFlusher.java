/**
 * 
 */
package myTools;


import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.FutureMeeting;
import contactmgmt.Meeting;
import contactmgmt.PastMeeting;

/**
 * @author Guilherme
 *
 */
public interface PopulatorAndFlusher {
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
	void setAllContacts(List<String> csvRows);
	Set<Contact> getAllContacts();
	void setAllMeetings(List<String> csvRows);
	Set<Meeting> getAllMeetings();
	void setAllPastMeetings(Set<Meeting> allMeetings);
	Set<PastMeeting> getAllPastMeetings();
	void setPastMeetingsIdIndex(Set<PastMeeting> allPastMeetings);
	List<Integer> getPastMeetingsIdIndex();
	void setAllFutureMeetings(Set<Meeting> allMeetings);
	Set<FutureMeeting> getAllFutureMeetings();
	void setFutureMeetingsIdIndex(Set<FutureMeeting> allFutureMeetings);
	List<Integer> getFutureMeetingsIdIndex();
	void setContactsNameIndex(Set<Contact> allContacts);
	List<String> getContactsNameIndex();
	<T> boolean updateIndex(T inputId, List<T> contactsIdIndex);
	<T> boolean updateSet(T element, Set<T> elementCollection);

}
