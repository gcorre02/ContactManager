/**
 * 
 */
package myTools;

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
	 * called at set-up by ContactManager
	 * populates all Sets and Indexes
	 * @param pathToFile
	 * 
	 */
	void PopulateSetsAndIndexes(String pathToFile);

	/**
	 * 
	 * @param allMeetings set of all meetings to be written to the file
	 * @param allContacts set of all contacts to be written to the file
	 * @param pathToFile location of the file
	 */
	void  WriteToFile(Set<Meeting> allMeetings, Set<Contact> allContacts, String pathToFile);

}
