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
	private List<Integer> contactIndexes;
	private List<Integer> meetingIndexes;
	private List<String> csvRows;

	
	/***************************************************************************
	* <<<<<<<<<<< LIST OF PRIVATE METHODS I AM GOING TO NEED  >>>>>>>>>>>
	*
	*	//populates csvRows and updates setsAreEmpty && calls the populating()s;
	*	private void readFile(){}
	*
	*	private void populateIndexes(){}
	*	private void populateSets(){}
	*	private Contact getContactFromSet(int Id){}
	*	private Meeting getMeetingFromSet(int Id){}
	*	private boolean meetingIsInThePast(Meeting candidateMeeting){}
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
			csvRows = Files.readAllLines(csv.toPath(), StandardCharsets.US_ASCII);
			if(csvRows.isEmpty()){
				System.out.println("File is empty");
			} else {
				populateIndexes();
				populateSets();
			}
			
		} catch(IOException e){
			System.out.println("file not found error!!");
		}
	}

	private void populateIndexes(){

	}

	private void populateSets(){
	//constructors instantiate fields<<<
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
	public int addFutureMeeting(Set<Contact> contacts, Calendar date){}

	/**
	* Returns the PAST meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	*/
	public PastMeeting getPastMeeting(int id){}

	/**
	* Returns the FUTURE meeting with the requested ID, or null if there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the PastMeeting
	*/
	public FutureMeeting getFutureMeeting(int id){}

	/**
	* Returns the meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	*/
	public Meeting getMeeting(int id){}

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
	public List<Meeting> getFutureMeetingList(Contact contact){}

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
	public List<Meeting> getFutureMeetingList(Calendar date){}

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
	public List<PastMeeting> getPastMeetingList(Contact contact){}

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
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text){}

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
	public void addMeetingNotes(int id, String text){}

	/**
	* Create a new contact with the specified name and notes.
	*
	* @param name the name of the contact.
	* @param notes notes to be added about the contact.
	* @throws NullPointerException if the name or the notes are null
	*/
	public void addNewContact(String name, String notes){}

	/**
	* Returns a list containing the contacts that correspond to the IDs.
	*
	* @param ids an arbitrary number of contact IDs
	* @return a list containing the contacts that correspond to the IDs.
	* @throws IllegalArgumentException if any of the IDs does not correspond to a real contact
	*/
	public Set<Contact> getContacts(int... ids){}

	/**
	* Returns a list with the contacts whose name contains that string.
	*
	* @param name the string to search for
	* @return a list with the contacts whose name contains that string.
	* @throws NullPointerException if the parameter is null
	*/
	public Set<Contact> getContacts(String name){}

	/**
	* Save all data to disk.
	*
	* This method must be executed when the program is
	* closed and when/if the user requests it.
	*/
	public void flush(){}
	}