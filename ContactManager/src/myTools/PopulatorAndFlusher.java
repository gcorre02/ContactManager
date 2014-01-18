/**
 * 
 */
package myTools;


import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.Meeting;

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
	 * called at set-up by ContactManager
	 * populates all Sets and Indexes
	 * @param pathToFile
	 * 
	 */
	void PopulateSetsAndIndexes(String[] csvRows);

	/**
	 * 
	 * @param allMeetings set of all meetings to be written to the file
	 * @param allContacts set of all contacts to be written to the file
	 * @param pathToFile location of the file
	 */
	void  WriteToFile(Set<Meeting> allMeetings, Set<Contact> allContacts, String pathToFile);
	
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

}
