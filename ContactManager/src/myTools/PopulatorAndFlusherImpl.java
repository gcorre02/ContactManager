/**
 * 
 */
package myTools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.ContactImpl;
import contactmgmt.FutureMeeting;
import contactmgmt.Meeting;
import contactmgmt.MeetingImpl;
import contactmgmt.PastMeeting;
import contactmgmt.PastMeetingImpl;

/**
 * @author Guilherme
 *
 */
public class PopulatorAndFlusherImpl implements PopulatorAndFlusher {
	// TODO try to make this a generic populator, where constructor inputs the type, to be done when everything is coded//
	private List<Integer> meetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> pastMeetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> futureMeetingsIdIndex= new ArrayList<Integer>();
	private List<Integer> contactsIdIndex= new ArrayList<Integer>();
	private List<String> contactsNameIndex= new ArrayList<String>();
	private Set<Contact> allContacts = new HashSet<Contact>();
	private Set<Meeting> allMeetings = new HashSet<Meeting>();
	private Set<PastMeeting> allPastMeetings = new HashSet<PastMeeting>();
	private Set<FutureMeeting> allFutureMeetings = new HashSet<FutureMeeting>();
	private List<String> csvRows;
	private List<Integer> pastMeetingsWithNotesIndex = new ArrayList<Integer>();
	
	//TODO write constructor that calls all the populators

	/* (non-Javadoc)
	 * @see myTools.PopulatorAndFlusher#WriteToFile(java.util.Set, java.util.Set, java.lang.String)
	 */
	@Override
	public void WriteToFile(Set<Meeting> allMeetings, Set<Contact> allContacts,
			String pathToFile) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the contactsIdIndex
	 */
	public List<Integer> getContactsIdIndex() {
		return contactsIdIndex;
	}

	/**
	 * @param contactsIdIndex the contactsIdIndex to set
	 */
	public void setContactsIdIndex(List<String> csvRows) {
		List<Integer> contactsIdIndex = new ArrayList<Integer>(); 
		for(String str : csvRows){
			String rowSplit[] = str.split(",");
			if(rowSplit[1].equals("C")){
				contactsIdIndex.add(Integer.parseInt(rowSplit[0]));
			}
		}
		//populate index
		this.contactsIdIndex = contactsIdIndex;
	}

	/**
	 * @return the meetingsIdIndex
	 */
	public List<Integer> getMeetingsIdIndex() {
		return meetingsIdIndex;
	}

	/**
	 * @param meetingsIdIndex the meetingsIdIndex to set
	 */
	@Override
	public void setMeetingsIdIndex(List<String> csvRows) {
		List<Integer> meetingsIdIndex = new ArrayList<Integer>(); 
		for(String str : csvRows){
			String rowSplit[] = str.split(",");
			if(rowSplit[1].equals("M")){
				meetingsIdIndex.add(Integer.parseInt(rowSplit[0]));
				if(rowSplit.length == 5){
					pastMeetingsWithNotesIndex.add(Integer.parseInt(rowSplit[0]));
				}
			}
		}
		//populate index
		this.meetingsIdIndex = meetingsIdIndex;
	}

	/**
	 * @return the pastMeetingsIdIndex
	 */
	public List<Integer> getPastMeetingsIdIndex() {
		return pastMeetingsIdIndex;
	}

	/**
	 * @param pastMeetingsIdIndex the pastMeetingsIdIndex to set
	 */
	public void setPastMeetingsIdIndex(List<Integer> pastMeetingsIdIndex) {
		//TODO >needs to figure out if the meeting is in the past, easier if the objects are already created. so it just .getsId() !!
		this.pastMeetingsIdIndex = pastMeetingsIdIndex;
	}

	/**
	 * @return the futureMeetingsIdIndex
	 */
	public List<Integer> getFutureMeetingsIdIndex() {
		return futureMeetingsIdIndex;
	}

	/**
	 * @param futureMeetingsIdIndex the futureMeetingsIdIndex to set
	 */
	public void setFutureMeetingsIdIndex(List<Integer> futureMeetingsIdIndex) {
		this.futureMeetingsIdIndex = futureMeetingsIdIndex;
	}

	/**
	 * @return the contactsNameIndex
	 */
	public List<String> getContactsNameIndex() {
		return contactsNameIndex;
	}

	/**
	 * @param contactsNameIndex the contactsNameIndex to set
	 */
	public void setContactsNameIndex(List<String> contactsNameIndex) {
		this.contactsNameIndex = contactsNameIndex;
	}

	/**
	 * @return the allContacts
	 */
	public Set<Contact> getAllContacts() {
		//TODO start here tomorrow
		return allContacts;
	}

	/**
	 * @param allContacts the allContacts to set
	 */
	public void setAllContacts(List<String> csvRows) {
		//TODO need to allow for notes for contacts, index 3 ? of the row ?
		Set<Contact> allContacts = new HashSet<Contact>();
		for(String str : csvRows){
			String rowSplit[] = str.split(",");
			if(rowSplit[1].equals("C")){
				allContacts.add(new ContactImpl((Integer.parseInt(rowSplit[0])),rowSplit[2]));
			}
		}
		//populate set
		this.allContacts = allContacts;
	}

	/**
	 * @return the allMeetings
	 */
	public Set<Meeting> getAllMeetings() {
		return allMeetings;
	}

	
	

	/**
	 * @return the allPastMeetings
	 */
	public Set<PastMeeting> getAllPastMeetings() {
		return allPastMeetings;
	}

	/**
	 * @param allPastMeetings the allPastMeetings to set
	 */
	public void setAllPastMeetings(Set<Meeting> allMeetings) {
		DatesManager dm = new DatesManagerImpl();
		Set<PastMeeting> allPastMeetings = new HashSet<PastMeeting>();
		Iterator<Meeting> iter = allMeetings.iterator();
		while(iter.hasNext()){
			Meeting current = iter.next();
			if(dm.checkDateIsInThePast(current.getDate())){
				if (pastMeetingsWithNotesIndex.contains(current.getId())){  
					
					String theNotes = getNotes(current.getId());
					allPastMeetings.add(new PastMeetingImpl(current.getId(), current.getDate(), current.getContacts(), theNotes));
				}else{
					allPastMeetings.add(new PastMeetingImpl(current.getId(), current.getDate(), current.getContacts()));
				}
			}
		}
		this.allPastMeetings = allPastMeetings;
	}

	private String getNotes(int id) {
		String notes = "";
		Iterator<String> iter = csvRows.iterator();
		while(iter.hasNext()){
			String current = iter.next();
			String[] rows = current.split(",");
			if(Integer.parseInt(rows[0])==id
					&& rows[1].equals("M")){
				notes = rows[4];
			}
		}
	
		return notes;
	}

	/**
	 * @return the allFutureMeetings
	 */
	public Set<FutureMeeting> getAllFutureMeetings() {
		return allFutureMeetings;
	}

	/**
	 * @param allFutureMeetings the allFutureMeetings to set
	 */
	public void setAllFutureMeetings(Set<FutureMeeting> allFutureMeetings) {
		this.allFutureMeetings = allFutureMeetings;
	}

	@Override
	public List<String> readFromFile(String pathToFile) {
		List<String> rows = new ArrayList<String>();
		
	
		File inputFile = new File(pathToFile);
		if(inputFile.isFile()){
			try{
				rows = Files.readAllLines(inputFile.toPath(), Charset.defaultCharset());
			} catch (IOException e){
				System.out.println("file doesn't read right");
				rows.add("");
			}
		} else {
			rows.add("");
		}
		setCsvRows(rows);
		return rows;
	}

	@Override
	public void PopulateSetsAndIndexes(String[] csvRows) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<String> getCsvRows() {
		return csvRows;
	}

	private void setCsvRows(List<String> csvRows) {
		this.csvRows = csvRows;
	}
	
	@Override
	public void setAllMeetings(List<String> csvRows) {
		//note : all contact names in the meeting rows are concatenated without spaces and spaces are used to separate each contact
		Set<Meeting> allMeetings = new HashSet<Meeting>();
		for(String str : csvRows){
			String rowSplit[] = str.split(",");
			if(rowSplit[1].equals("M")){
				
				DatesManager dm = new DatesManagerImpl();
				Calendar date;
				int year = Integer.parseInt(rowSplit[3].substring(0,4));
				int month = Integer.parseInt(rowSplit[3].substring(4,6));
				int day = Integer.parseInt(rowSplit[3].substring(6,8));
				date = dm.generateCalendarItem(year, month, day);

				//TODO>need to make this pass the test:
				
				String[] contactNames = rowSplit[2].split(" ");
				Set<Contact> contactSet = new HashSet<Contact>();
				for(String name : contactNames){
					Contact newContact = getContact(name);
					contactSet.add(newContact);
				}
				allMeetings.add(new MeetingImpl((Integer.parseInt(rowSplit[0])),date, contactSet));
			}
		}
		//populate set
		this.allMeetings = allMeetings;
		
	}

	private Contact getContact(String name) {
		char[] nameArray = name.toCharArray();
		String finalName= "";
		for(int i = 0; i < nameArray.length; i++){
			if( Character.isUpperCase(nameArray[i])){
				finalName = finalName + nameArray[i];
				do{
					finalName = finalName + nameArray[i+1];
					i++;
				}while((i+1)<nameArray.length && Character.isLowerCase(nameArray[i+1]));
				if((i+1)<nameArray.length){
					finalName = finalName+ " ";
				}
			}
		}

		Iterator<Contact> iter = allContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			
			if (current.getName().equals(finalName)){
				
				return current;
			}
		}
		return null;
	}

}
