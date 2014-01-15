package contactmgmt;

import java.util.Iterator;
import java.util.HashSet;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Calendar;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;

import java.lang.IllegalArgumentException;

import java.io.*;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;

/**
* A class to manage your contacts and meetings.
*/
public class ContactManagerImpl implements ContactManager {

	private boolean setsAreEmpty;
	private Set<Contact> allContacts;
	private Set<Meeting> allMeetings;
	private List<Integer> contactIndex;
	private List<Integer> meetingIndex;
	private List<String> csvRows;

	
	/***************************************************************************
	* <<<<<<<<<<< LIST OF PRIVATE METHODS I AM GOING TO NEED  >>>>>>>>>>>
	*
	*	//populates csvRows and updates setsAreEmpty && calls the populating()s;
	*	private void readFile(){}
	*
	*	private void populateIndexes(){}
	*	private void populateMeetings(){}
	*	private void populateContacts(){}
	*	private Contact getContactFromSet(int Id){}
	*	private Meeting getMeetingFromSet(int Id){}
	*	private boolean meetingIsInThePast(Meeting candidateMeeting){}
	*	private boolean meetingIsInThePast(Calendar date){}
	*	private boolean meetingIsInTheFuture(Meeting candidateMeeting){}
	*//////////////////////////////////////////////////////////////////////////
	

	//populates csvRows and updates setsAreEmpty && calls the populating()s;
	private void readFile(){
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
			csvRows = Files.readAllLines(csv.toPath(), StandardCharsets.US_ASCII); //look into encoding of this file at fulsh to match <<<///
			if(csvRows.isEmpty()){
				System.out.println("File is empty");
				setsAreEmpty = true;
			} else {
				populateIndexes();
			}
			
		} catch(IOException e){
			System.out.println("file not found error!!");
			setsAreEmpty = true;
		}
	}

	private void populateIndexes(){
		if(setsAreEmpty){
			return;
		}
		for(String row : csvRows){
			String[] elementsOfRow = row.split(",");    //<<< need to look into how csv differentiates between context comma and strucutre comma
			if(elementsOfRow[1].equals("C")){
				contactIndex.add(Integer.parseInt(elementsOfRow[0]));
				populateContacts(row);
			} else {  //   <<<<<<<<<OPORTUNITY TO INDEX PAST AND FUTURE MEETINGS!  /// Maybe have all of them to be safe////
				meetingIndex.add(Integer.parseInt(elementsOfRow[0]));
				populateMeetings(row);		
			}

		}
	}
	
	//>>>>constructors instantiate fields<<<
	//>>>>write all constructors <<<<<<<<<<<

	private void populateMeetings(String row) throws IllegalArgumentException{
		String[] elementsOfRow = row.split(",");
		//format of Meetings.Row > "ID,M,DATE, CONTACTS[], %notes%:NOTES"  <<< need to look into how csv differentiates between context comma and strucutre comma
		int id = Integer.parseInt(elementsOfRow[0]);
		int year = Integer.parseInt(elementsOfRow[2].substring(0,4)); 
		int month = Integer.parseInt(elementsOfRow[2].substring(4,6));
		int day = Integer.parseInt(elementsOfRow[2].substring(6,8));
		Calendar date = new GregorianCalendar(year,month,day);
		String[] namesInTheMeeting = elementsOfRow[3].split(";");//<<<<assumes contact names are separated by ";";
		List<Contact> meetingContacts = new ArrayList<Contact>();
		for(String str : names){
			meetingContacts.add(getContacts(str));  // problem with this is that allContacts must be populated first<<<<< to do this maybe flush puts all meetings at the end of the file !!! >>>>>
		}
		allMeetings.add(new Meeting(id, date,meetingContacts));
		if(meetingIsInThePast(date)){
			try{
				String notes = elementsOfRow[4]; //needs to find the ref for notes and loop through adding them into the same string
				pastMeetings.add(new PastMeeting(id, date, meetingContacts, notes));
			} catch (NullPointerException e){ ///<<<< Probably ArrayOutOfBounds Exception, not this. need the internet>>>
				System.out.println("no notes found for this meeting");
				pastMeetings.add(new PastMeeting(id, date, meetingContacts));
			}
		} else {
			futureMeetings.add(new FutureMeeting(id, date, meetingContacts));
		}
	
		//contacts ?? <<need to decide how they are read back from the row into the impl of meeting : better to write the constructor now
	}

	private void populateContacts(String row) throws IllegalArgumentException{
		
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
	public int addFutureMeeting(Set<Contact> contacts, Calendar date){
		// don't forget to change setsareempty - wouldnt work anyway because it needs contacts to be verified, so breaks straight away
		int stub= 0;
		return stub;
	}

	/**
	* Returns the PAST meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	*/
	public PastMeeting getPastMeeting(int id){
		PastMeeting stub= null;
		return stub;
	}

	/**
	* Returns the FUTURE meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the PastMeeting
	*/
	public FutureMeeting getFutureMeeting(int id){
		FutureMeeting stub= null;
		return stub;
	}

	/**
	* Returns the meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	*/
	public Meeting getMeeting(int id){
		Meeting stub= null;
		return stub;
	}

	/**
	* Returns the list of future meetings scheduled with this contact.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the user’s contacts
	* @return the list of future meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	*/
	public List<Meeting> getFutureMeetingList(Contact contact){
		List<Meeting> stub= null;
		return stub;
	}

	/**
	* Returns the list of meetings that are scheduled for, or that took
	* place on, the specified date
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param date the date
	* @return the list of meetings
	*/
	public List<Meeting> getFutureMeetingList(Calendar date){
		List<Meeting> stub= null;
		return stub;
	}

	/**
	* Returns the list of past meetings in which this contact has participated.
	*
	* If there are none, the returned list will be empty. Otherwise,
	* the list will be chronologically sorted and will not contain any
	* duplicates.
	*
	* @param contact one of the user’s contacts
	* @return the list of future meeting(s) scheduled with this contact (maybe empty).
	* @throws IllegalArgumentException if the contact does not exist
	*/
	public List<PastMeeting> getPastMeetingList(Contact contact){
		List<PastMeeting> stub= null;
		return stub;
	}

	/**
	* Create a new record for a meeting that took place in the past.
	*
	* @param contacts a list of participants
	* @param date the date on which the meeting took place
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the list of contacts is
	* empty, or any of the contacts does not exist
	* @throws NullPointerException if any of the arguments is null
	*/
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text){	
	// don't forget to change setsareempty 
	}
	
	/**
	* Add notes to a meeting.
	*
	* This method is used when a future meeting takes place, and is
	* then converted to a past meeting (with notes).
	*
	* It can be also used to add notes to a past meeting at a later date.
	*
	* @param id the ID of the meeting
	* @param text messages to be added about the meeting.
	* @throws IllegalArgumentException if the meeting does not exist
	* @throws IllegalStateException if the meeting is set for a date in the future
	* @throws NullPointerException if the notes are null
	*/
	public void addMeetingNotes(int id, String text){

	}

	/**
	* Create a new contact with the specified name and notes.
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @throws NullPointerException if the name or the notes are null
	*/
	public void addNewContact(String name, String notes){
	// don't forget to change setsareempty 
	}

	/**
	* Returns a list containing the contacts that correspond to the IDs.
	*
	* @param ids an arbitrary number of contact IDs
	* @return a list containing the contacts that correspond to the IDs.
	* @throws IllegalArgumentException if any of the IDs does not correspond to a real contact
	*/
	public Set<Contact> getContacts(int... ids){
		Set<Contact> stub = null;
		return stub;
	}

	/**
	* Returns a list with the contacts whose name contains that string.
	*
	* @param name the string to search for
	* @return a list with the contacts whose name contains that string.
	* @throws NullPointerException if the parameter is null
	*/
	public Set<Contact> getContacts(String name){
		Set<Contact> stub = null;
		return stub;
	}

	/**
	* Save all data to disk.
	*
	* This method must be executed when the program is
	* closed and when/if the user requests it.
	*/
	public void flush(){}
	}