package contactmgmt;

import java.util.Calendar;
import java.util.List;
import java.util.Set;

import java.io.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {
	
	private Set<Contact> contacts;
	private Set<Meeting> meetings;
	private int[] contactIDs;
	private int[] meetingIDs;
	private String[] contactNames;
	private List<String> csvRows;  //for the test accessability
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
		return csvRows.toArray(new String[csvRows.size()]);
	} 

	private void readCSV(String csvPath){
		//needs to check file exists and handle it (by creating a new file);
		
		String fileDir = "."+ File.separator +"contacts.txt";
		File csv = new File(fileDir);
		
		if(!csv.isFile()){
			try{
				csv.createNewFile();
			} catch(IOException e){
				System.out.println("File already exists");
			}
		}
		
		//populate csvRows
		try{
			csvRows = Files.readAllLines(csv.toPath(), StandardCharsets.US_ASCII);
			if(csvRows.isEmpty()){
				System.out.println("read all lines is returning empty");
			}
		} catch(IOException e){
			System.out.println("file not found error!!");
		}
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