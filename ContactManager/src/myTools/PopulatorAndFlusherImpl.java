/**
 * 
 */
package myTools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import contactmgmt.FutureMeetingImpl;
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
	//TODO need to write updaters! but this can be done just by calling the indexing and populating methods from outside the class 
	//TODO write constructor that calls all the populators
	
	public PopulatorAndFlusherImpl(String path){
		csvRows = readFromFile(path);
		populateSetsAndIndexes();
	}
	

	/* (non-Javadoc)
	 * @see myTools.PopulatorAndFlusher#WriteToFile(java.util.Set, java.util.Set, java.lang.String)
	 */
	@Override
	public void writeToFile(String pathToFile) {
		//pass the info to the file using a future, past, contact strucure
		// TODO need to override toString in all the printable methods (dont need to pass Meeting, because all meetings are either future or past.)
		// TODO need to add functionality for adding notes to contacts
		//start the writer
		PrintWriter writer;
		try {
			writer = new PrintWriter(pathToFile, Charset.defaultCharset().toString());
			
			//iterate through each FM and write it in
			Iterator<FutureMeeting> iterFm = allFutureMeetings.iterator();
			while(iterFm.hasNext()){
				FutureMeeting current = iterFm.next();
				writer.println(current.toString());
			}
			//iterate through each PM and write it in
			Iterator<PastMeeting> iterPm = allPastMeetings.iterator();
			while(iterPm.hasNext()){
				PastMeeting current = iterPm.next();
				writer.println(current.toString());
			}
			//iterate through each Contact and write it in
			Iterator<Contact> iterC = allContacts.iterator();
			while(iterC.hasNext()){
				Contact current = iterC.next();
				writer.println(current.toString());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
	public void setPastMeetingsIdIndex(Set<PastMeeting> allPastMeetings) {
		List<Integer> pastMeetingsIdIndex = new ArrayList<Integer>();
		Iterator<PastMeeting> iter = allPastMeetings.iterator();
		while(iter.hasNext()){
			PastMeeting current = iter.next();
			pastMeetingsIdIndex.add(current.getId());
		}		
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
	public void setFutureMeetingsIdIndex(Set<FutureMeeting> allFutureMeetings) {
		List<Integer> futureMeetingsIdIndex = new ArrayList<Integer>();
		Iterator<FutureMeeting> iter = allFutureMeetings.iterator();
		while(iter.hasNext()){
			FutureMeeting current = iter.next();
			futureMeetingsIdIndex.add(current.getId());
		}		
		this.futureMeetingsIdIndex = futureMeetingsIdIndex;
	}

	/**
	 * @return the contactsNameIndex
	 */
	public List<String> getContactsNameIndex() {
		return contactsNameIndex;
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

	
	private void populateSetsAndIndexes() {
		// TODO called with constructor
		
		//calls all the methods charged with populating the fields
		
		setAllContacts(getCsvRows());
		setAllMeetings(getCsvRows());
		setMeetingsIdIndex(getCsvRows());
		setAllPastMeetings(getAllMeetings()); //TODO : investigate why this methid must be called after setMeetings IdIndex(kind of makes sense)
		setAllFutureMeetings(getAllMeetings());
		setPastMeetingsIdIndex(getAllPastMeetings());
		setFutureMeetingsIdIndex(getAllFutureMeetings());
		setContactsIdIndex(getCsvRows());
		setContactsNameIndex(getAllContacts());
		
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

	@Override
	public void setAllFutureMeetings(Set<Meeting> allMeetings) {
		//TODO create a set method that populates all meetings in one go, recognizing if it is in the past or not and returns any meeting
		//Instantiate datesmanager for date comparison
		DatesManager dm = new DatesManagerImpl();
		//
		Set<FutureMeeting> futureMeetings = new HashSet<FutureMeeting>();
		Iterator<Meeting> iter = allMeetings.iterator();
		while(iter.hasNext()){
			Meeting current = iter.next();
			if(!dm.checkDateIsInThePast(current.getDate())){
				futureMeetings.add(new FutureMeetingImpl(current));
			}
		}
		this.allFutureMeetings = futureMeetings;
	}

	
	/**
	 * @param contactsNameIndex the contactsNameIndex to set
	 */
	@Override
	public void setContactsNameIndex(Set<Contact> allContacts) {
		List<String> contactsNameIndex = new ArrayList<String>();
		
		Iterator<Contact> iter = allContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			contactsNameIndex.add(current.getName());
		}
		this.contactsNameIndex = contactsNameIndex;
	}
	/**
	 * 
	 * @param element
	 * @param elementCollection
	 * @param index
	 * @return boolean that indicates whether it's been added or removed
	 */
	public <T> boolean updateSet(T element, Set<T> elementCollection){
		if(elementCollection.contains(element)){
			elementCollection.remove(element);
			return false;
		} else{
			elementCollection.add(element);
			return true;
		}
		
	}
	public <T>boolean updateIndex(T id,List<T> anyList){
		//returns a bool that indicates whether it's been added or removed
		if(anyList.contains(id)){
			anyList.remove((T)id);			
			return false;
		} else {
			anyList.add((T)id);
			return true;
		}
	}
	
}
