/**
 * 
 */
package myTools;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import contactmgmt.Contact;
import contactmgmt.ContactImpl;
import contactmgmt.Meeting;

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
	private Set<Meeting> allPastMeetings = new HashSet<Meeting>();
	private Set<Meeting> allFutureMeetings = new HashSet<Meeting>();
	private List<String> csvRows;
	
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
	 * @param allMeetings the allMeetings to set
	 */
	public void setAllMeetings(Set<Meeting> allMeetings) {
		this.allMeetings = allMeetings;
	}

	/**
	 * @return the allPastMeetings
	 */
	public Set<Meeting> getAllPastMeetings() {
		return allPastMeetings;
	}

	/**
	 * @param allPastMeetings the allPastMeetings to set
	 */
	public void setAllPastMeetings(Set<Meeting> allPastMeetings) {
		this.allPastMeetings = allPastMeetings;
	}

	/**
	 * @return the allFutureMeetings
	 */
	public Set<Meeting> getAllFutureMeetings() {
		return allFutureMeetings;
	}

	/**
	 * @param allFutureMeetings the allFutureMeetings to set
	 */
	public void setAllFutureMeetings(Set<Meeting> allFutureMeetings) {
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

}
