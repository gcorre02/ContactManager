package contactmgmt;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {
	
	//indexes:
	private int[] contactIDs;
	private int[] contactNames;
	private int[] meetingIDs;

	public ContactManagerImpl(){
		mapCSV();
	}

	/**
	*	private method that is called once everytime program is run
	*	populates all Contacts ID, Name and All Meetings ID indexes so they can be easily accessible on the csv file. 
	*	is called by constructor method
	*	written as a separate method for potential future use if needed for update / testing;
	*/
	private void mapCSV(){

	}

	/**
	* Add a new meeting to be held in the future.
	*
	* @param contacts a list of contacts that will participate in the meeting
	* @param date the date on which the meeting will take place
	* @return the ID for the meeting
	* @throws IllegalArgumentException if the meeting is set for a time in the past,
	* of if any contact is unknown / non-existent
	*/
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws IllegalArgumentException{
		int stub = 0;
		return stub;
	}

}