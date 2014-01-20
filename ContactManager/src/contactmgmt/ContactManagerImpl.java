/**
 * 
 */
package contactmgmt;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;
import myTools.ValuesManager;
import myTools.ValuesManagerImpl;

/**
 * @author Guilherme
 *
 */
public class ContactManagerImpl implements ContactManager {

	/*
	 * variables that might need declaring
	private List<Integer> pastMeetingsIdIndex;
	private List<Integer> futureMeetingsIdIndex;
	private List<Integer> contactsIdIndex;
	private List<String> contactsNameIndex;
	private Set<Contact> allContacts;
	private Set<Meeting> allMeetings;
	private Set<PastMeeting> allPastMeetings;
	private Set<FutureMeeting> allFutureMeetings;
	private List<String> csvRows;
	private List<Integer> pastMeetingsWithNotesIndex;

	 */

	//declare inner variables:
	private PopulatorAndFlusher paf;
	private ValuesManager vm;
	private String pathToFile = "."+ File.separator +"contactsTest.txt";

	/**
	 * 
	 */
	public ContactManagerImpl() {
		paf = new PopulatorAndFlusherImpl(pathToFile);
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addFutureMeeting(java.util.Set, java.util.Calendar)
	 */
	@Override
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {

		//generate unique id :
		ValuesManager vm = new ValuesManagerImpl();
		int returnId = vm.newIdGenerator(paf.getMeetingsIdIndex()); //<need to use the Meetings Index! //< need to update both the Meetings and the futureMeetings index too
		//instantiate new FM
		FutureMeeting newFMeeting = new FutureMeetingImpl(returnId,date,contacts);
		//add the new future meeting to the collection
		paf.updateSet(newFMeeting, paf.getAllFutureMeetings());
		paf.updateSet(newFMeeting, paf.getAllMeetings());
		paf.updateIndex(returnId, paf.getFutureMeetingsIdIndex());
		paf.updateIndex(returnId, paf.getMeetingsIdIndex());
		return returnId;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getPastMeeting(int)
	 */
	@Override
	public PastMeeting getPastMeeting(int id) {
		Set<PastMeeting> pastMeetingCollection = paf.getAllPastMeetings();
		Iterator<PastMeeting> iter = pastMeetingCollection.iterator();
		while(iter.hasNext()){
			PastMeeting current = iter.next();
			if(current.getId() == id){
				return current;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeeting(int)
	 */
	@Override
	public FutureMeeting getFutureMeeting(int id) {
		Set<FutureMeeting> FutureMeetingCollection = paf.getAllFutureMeetings();
		Iterator<FutureMeeting> iter = FutureMeetingCollection.iterator();
		while(iter.hasNext()){
			FutureMeeting current = iter.next();
			if(current.getId() == id){
				return current;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getMeeting(int)
	 */
	@Override
	public Meeting getMeeting(int id) {
		// TODO need to handle how meetings with notes get stored in this set <<new test
		Set<Meeting> MeetingCollection = paf.getAllMeetings();
		Iterator<Meeting> iter = MeetingCollection.iterator();
		while(iter.hasNext()){
			Meeting current = iter.next();
			if(current.getId() == id){
				return current;
			}
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeetingList(contactmgmt.Contact)
	 */
	@Override
	public List<Meeting> getFutureMeetingList(Contact contact) {
		//TODO : override equals under contact and meeting for easier comparison!
		List<Meeting> outputList = new ArrayList<Meeting>();
		Set<FutureMeeting> inputSet = paf.getAllFutureMeetings();
		Iterator<FutureMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			FutureMeeting current = iter.next();
			//debug
			//paf.printSet(current.getContacts());
			//
			Iterator<Contact> cIter= current.getContacts().iterator();
			while(cIter.hasNext()){
				Contact currentContact = cIter.next();
				if(currentContact.toString().equals(contact.toString())){
					outputList.add(current);
				}
			}
		}
		//debug
		/*
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<debug getFutureMeetingList>>>>>>>>>>>>>>>>>>>>>");
		paf.printlist(outputList);
		System.out.println(contact);
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<debug getFutureMeetingList>>>>>>>>>>>>>>>>>>>>>");
		 */
		//return
		return outputList;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeetingList(java.util.Calendar)
	 */
	@Override
	public List<Meeting> getFutureMeetingList(Calendar date) {
		List<Meeting> outputList = new ArrayList<Meeting>();
		Set<FutureMeeting> inputSet = paf.getAllFutureMeetings();
		Iterator<FutureMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			FutureMeeting current = iter.next();
			if(current.getDate().equals(date)){
				outputList.add(current);
			}
		}
		
		return outputList;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getPastMeetingList(contactmgmt.Contact)
	 */
	@Override
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		List<PastMeeting> outputList = new ArrayList<PastMeeting>();
		Set<PastMeeting> inputSet = paf.getAllPastMeetings();
		Iterator<PastMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			PastMeeting current = iter.next();
			//debug
			//paf.printSet(current.getContacts());
			//
			Iterator<Contact> cIter= current.getContacts().iterator();
			while(cIter.hasNext()){
				Contact currentContact = cIter.next();
				if(currentContact.toString().equals(contact.toString())){
					outputList.add(current);
				}
			}
		}
	
		return outputList;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)
	 */
	@Override
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
		// TODO need to handle test for date in the future and unrecognized contacts (throwable)
		vm = new ValuesManagerImpl();
		int newId = vm.newIdGenerator(paf.getMeetingsIdIndex());
		Meeting newMeeting = new PastMeetingImpl(newId, date, contacts, text);
		paf.updateIndex(newId, paf.getMeetingsIdIndex());
		paf.updateIndex(newId, paf.getPastMeetingsIdIndex());
		paf.updateSet(newMeeting, paf.getAllMeetings());
		paf.updateSet((PastMeeting)newMeeting, paf.getAllPastMeetings());
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addMeetingNotes(int, java.lang.String)
	 */
	@Override
	public void addMeetingNotes(int id, String text) {
		PastMeeting meetingToAddNotes = getPastMeeting(id);
		PastMeeting newMeeting = new PastMeetingImpl(meetingToAddNotes.getId(), meetingToAddNotes.getDate(), meetingToAddNotes.getContacts(), text);
		paf.getAllPastMeetings().remove(meetingToAddNotes);
		paf.getAllPastMeetings().add(newMeeting);
		paf.getAllMeetings().remove(meetingToAddNotes);
		paf.getAllMeetings().add(newMeeting);
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addNewContact(java.lang.String, java.lang.String)
	 */
	@Override
	public void addNewContact(String name, String notes) {
		//checks if name is unique
		String inputName;
		if(paf.getContactsNameIndex().contains(name)){
			int diferentiator;
			try{
				diferentiator = Integer.parseInt(name.substring(name.length()-2,name.length()-1)) + 1;
			} catch(NumberFormatException e){
				diferentiator = 1;
			}
			inputName = name+diferentiator;
		} else{
			inputName = name;
		}
		//inputs
		Set<Contact> contacts = paf.getAllContacts();
		vm = new ValuesManagerImpl();
		List<Integer> contactsId = paf.getContactsIdIndex();
		int newId = vm.newIdGenerator(contactsId);
		Contact newContact = new ContactImpl(newId, inputName);
		newContact.addNotes(notes);
		//update all sets and indexes;
		paf.updateSet(newContact, contacts);
		paf.updateIndex(newId, contactsId);
		paf.updateIndex(inputName, paf.getContactsNameIndex());
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getContacts(int[])
	 */
	@Override
	public Set<Contact> getContacts(int... ids) {
		// TODO write throws if name isn't part of the index
		Set<Contact> returnContacts = new HashSet<Contact>();
		Set<Contact> inputContacts = paf.getAllContacts();
		List<Integer> idsContactInput = new ArrayList<Integer>();
		for (int i : ids){
			idsContactInput.add(i);
		}
		Iterator<Contact> iter = inputContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			if(idsContactInput.contains(current.getId())){
				returnContacts.add(current);
			}
		}
		return returnContacts;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getContacts(java.lang.String)
	 */
	@Override
	public Set<Contact> getContacts(String name) {
		// TODO write throws if name isn't part of the index
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#flush()
	 */
	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	//Debug Method
	public PopulatorAndFlusher getPaf(){
		return this.paf;
	}
}
