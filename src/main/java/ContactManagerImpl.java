package contactmgmt;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import java.io.*;

/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {
	
	private Set<Contact> contacts;
	private Set<Meeting> meetings;
	private int[] contactIDs;
	private int[] meetingIDs;
	private String[] contactNames;
	private String[] csvRows;  //for the test accessability
	private String csvPath = "."+ File.pathSeparator +"contacts.txt";
	
	public ContactManagerImpl(){
		readCSV(csvPath);
	}

	/**
	*	private method that is called once everytime program is run
	*	populates all Contacts and Meetings sets and associated indexes. 
	*	is called by constructor method
	*	written as a separate method for potential future use if needed for update / testing;
	*	@param csvPath the path to the csv source file, each row within the file is set up in the format "Line, type((C)ontact or (M)eeting), DATA(comma separated)"
	*/

	public String[] getCsvRows(){
		return csvRows;
	} 

	private void readCSV(String csvPath){
		//needs to check file exists and handle it (by creating a new file);
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