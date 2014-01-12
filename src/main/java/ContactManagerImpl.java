package contactmgmt;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import java.lang.IllegalArgumentException;

import java.io.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {
	
	private Set<Contact> storedContacts;
	private Set<Meeting> storedMeetings;
	private List<Integer> contactIDs;
	private List<Integer> meetingIDs;
	private List<String> contactNames;
	private List<String> csvRows;  //for the test accessability
	private String csvPath = "."+ File.pathSeparator +"contacts.txt";
	
	public ContactManagerImpl(){
		readCSV(csvPath);
	}

	public String[] getCsvRows(){
		return csvRows.toArray(new String[csvRows.size()]);
	} 

	/**
	*	private method that is called once everytime program is run
	*	populates all Contacts and Meetings sets and associated indexes. 
	*	is called by constructor method
	*	written as a separate method for potential future use if needed for update / testing;
	*	@param csvPath the path to the csv source file, each row within the file is set up in the format "Line, type((C)ontact or (M)eeting), DATA(comma separated)"
	*/
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
				System.out.println("File is empty");
			} else {
				populateIndexArrays();
			}
			
		} catch(IOException e){
			System.out.println("file not found error!!");
		}
	}

	private void populateIndexArrays(){
		contactIDs = new ArrayList<Integer>();
		meetingIDs = new ArrayList<Integer>();
		contactNames = new ArrayList<String>();
		String[] rows = getCsvRows();
		try{
			for(int i = 0; i<rows.length; i++){		
				for(int t =0; t<rows[i].length(); t++){
					if(rows[i].charAt(t) == ','){
						if(rows[i].charAt(t+1) == 'C'){
							
							contactIDs.add(Integer.parseInt(rows[i].substring(0,t)));
							int n = t+4; //need to find the next comma (change this) -- works though, so it might actually be cleaner
							String name = "";
							
							while(rows[i].charAt(n) != ','){
								name = name + rows[i].charAt(n);
								n++;
							}

							
							contactNames.add(name);
							t = rows[i].length()-1;
						
						} else if(rows[i].charAt(t+1) == 'M'){
							meetingIDs.add(Integer.parseInt(rows[i].substring(0,t)));
							t = rows[i].length()-1;
						}
					}
				}
				//@debug
				printIterThroughIndexes();
			}
		} catch(NullPointerException e){
			System.out.println("nothing in the row");
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
		// iterate through each contact in contacts, return id and verify it against ids in contactIDs
		Iterator<Contact> iter = contacts.iterator();
		Set<Integer> userContactsInputID = new HashSet<Integer>();
		while(iter.hasNext()){
			///not sure it isn't moving the iter forward everytime .next() is called...
			if(contactIDs.contains(iter.next().getId())){
				userContactsInputID.add(iter.next().getId());
			} else {
				throw new IllegalArgumentException();
			}
		}
		// check calendar date against current date (gregorian calendar not included in the interface...)
		Calendar present = Calendar.getInstance();
		if(!date.after(present)){
			throw new IllegalArgumentException();
			System.out.println("Date for the meeting is in the past");
		}
		// return an ID for the future meeting and populate the csvRows array with the details of the meeting (return comes last, but finding the ID comes first)
		
		int stub = 0;
		return stub;
	
	}

	/**
	*
	* private method for debug purposes
	*
	*
	*
	*/
	private void printIterThroughIndexes(){
		System.out.println("<<<<<CONTENTS OF contactIDS >>>>>>>>>> :");
		for( Integer id : contactIDs){
			System.out.println(id);
		}
		System.out.println("<<<<<CONTENTS OF meetingIDs >>>>>>>>>> :");
		for( Integer id : meetingIDs){
			System.out.println(id);
		}
		System.out.println("<<<<<CONTENTS OF contactNames >>>>>>>>>> :");
		for( String str : contactNames){
			System.out.println(str);
		}
		System.out.println("<<<<<CONTENTS OF csvRows >>>>>>>>>> :");
		for( String str : csvRows){
			System.out.println(str);
		}
	}


}