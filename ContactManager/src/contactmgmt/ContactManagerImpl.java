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

import myTools.DatesManager;
import myTools.DatesManagerImpl;
import myTools.PopulatorAndFlusher;
import myTools.PopulatorAndFlusherImpl;
import myTools.ValuesManager;
import myTools.ValuesManagerImpl;

/**
 * @author Guilherme
 *
 */
public class ContactManagerImpl implements ContactManager {

	
	//declare inner variables:
	private PopulatorAndFlusher paf;
	private ValuesManager vm;
	private DatesManager dm;
	private String pathToFile = "."+ File.separator +"contactsTest.csv";

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
	public int addFutureMeeting(Set<Contact> contacts, Calendar date) throws IllegalArgumentException {
		ValuesManager vm = new ValuesManagerImpl();
		//exceptions
		dm = new DatesManagerImpl();
		if(dm.checkDateIsInThePast(date)){
			System.out.println("date is in the past  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " date is in the past :  " + date.toString()); 
			throw new IllegalArgumentException();
		}
		List<ContactImpl> comparableContacts = new ArrayList<ContactImpl>();
		for(Contact current : contacts){
			comparableContacts.add((ContactImpl)current);
		}
		List<ContactImpl> allContacts = new ArrayList<ContactImpl>();
		for(Contact current : getPaf().getAllContacts()){
			allContacts.add((ContactImpl)current);
		}
		if(!allContacts.containsAll(comparableContacts)){
			System.out.println("at least one of the contacts is unknown  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " contacts inputed : " + contacts.toString()); 
			throw new IllegalArgumentException();
		}

		//generate unique id :

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
		//Exception
		if(paf.getFutureMeetingsIdIndex().contains(id)){
			System.out.println("id requested belongs to a future Meeting  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " id provided : "  +id); 
			throw new IllegalArgumentException();
		}
		//Main
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
	public FutureMeeting getFutureMeeting(int id) throws IllegalArgumentException {
		//exceptions
		if(paf.getPastMeetingsIdIndex().contains(id)){
			System.out.println("id requested belongs to a past Meeting  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " id provided :"  +id); 
			throw new IllegalArgumentException();
		}
		//main
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
		//TODO <After Deliverable Is Ready> override equals under contact and meeting for easier comparison!
		//exception
		vm = new ValuesManagerImpl();
		if(vm.checkContactNameIsUnique(paf.getContactsNameIndex(), contact.getName())){
			System.out.println("contact requested does not exist  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " contact requested "  +contact.getName()); 
			throw new IllegalArgumentException();
		}
		//main
		Set<Meeting> outputList = new HashSet<Meeting>();
		Set<FutureMeeting> inputSet = paf.getAllFutureMeetings();
		Iterator<FutureMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			FutureMeeting current = iter.next();

			Iterator<Contact> cIter= current.getContacts().iterator();
			while(cIter.hasNext()){
				Contact currentContact = cIter.next();
				if(currentContact.toString().equals(contact.toString())){
					outputList.add(current);
				}
			}
		}
		List<Meeting> returnableOutputList = vm.sortMeetingsByDate(outputList);
		return returnableOutputList ;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getFutureMeetingList(java.util.Calendar)
	 */
	@SuppressWarnings("static-access")
	@Override
	public List<Meeting> getFutureMeetingList(Calendar date) {
		//input values
		vm = new ValuesManagerImpl();
		Set<Meeting> outputList = new HashSet<Meeting>();
		Set<FutureMeeting> inputSet= paf.getAllFutureMeetings();

		//select meetings with the date on the same day as input date
		Iterator<FutureMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			Meeting current = iter.next();
			Calendar currentDate = current.getDate();
			if(currentDate.YEAR==date.YEAR
					&& currentDate.DAY_OF_MONTH == date.DAY_OF_MONTH
					&& currentDate.MONTH==date.MONTH){
				outputList.add(current);
			}
		}

		//sort values
		List<Meeting> returnableOutputList = vm.sortMeetingsByDate(outputList);

		return returnableOutputList;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#getPastMeetingList(contactmgmt.Contact)
	 */
	@Override
	public List<PastMeeting> getPastMeetingList(Contact contact) {
		//Exception
		vm = new ValuesManagerImpl();
		if(vm.checkContactNameIsUnique(paf.getContactsNameIndex(), contact.getName())){
			System.out.println("contact requested does not exist  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " contact requested "  +contact.getName()); 
			throw new IllegalArgumentException();
		}
		
		//main
		Set<Meeting> outputList = new HashSet<Meeting>();
		Set<PastMeeting> inputSet = paf.getAllPastMeetings();
		Iterator<PastMeeting> iter = inputSet.iterator();
		while(iter.hasNext()){
			PastMeeting current = iter.next();
			Iterator<Contact> cIter= current.getContacts().iterator();
			while(cIter.hasNext()){
				Contact currentContact = cIter.next();
				if(currentContact.toString().equals(contact.toString())){
					outputList.add(current);
				}
			}
		}
		
		//reorganizes outputList
		List<Meeting> outputListToParse = vm.sortMeetingsByDate(outputList);
		List<PastMeeting>outputListReorganized = new ArrayList<PastMeeting>();
		for(Meeting current : outputListToParse){
			outputListReorganized.add((PastMeeting)current);
		}
		
		//return
		return outputListReorganized;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#addNewPastMeeting(java.util.Set, java.util.Calendar, java.lang.String)
	 */
	@Override
	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) throws IllegalArgumentException{
		//Exceptions
		if(contacts==null || date == null || text == null){
			System.out.println("one of the params evaluates to null  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " Contacts: "+contacts+" date: "+date+" text: "+text); 
			throw new NullPointerException();
		}
		if(contacts.isEmpty()){
			System.out.println("list of contacts is empty :  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()); 
			throw new IllegalArgumentException();
		}
		dm = new DatesManagerImpl();
		if(!dm.checkDateIsInThePast(date)){
			System.out.println("date is in the future :  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()+" date is in the future : "+ date.toString()); 
			throw new IllegalArgumentException();
		}
		vm = new ValuesManagerImpl();
		List<Contact> comparableInputContacts = new ArrayList<Contact>(contacts);
		List<ContactImpl> comparableAllContacts = new ArrayList<ContactImpl>();
		for(Contact current : getPaf().getAllContacts()){
			comparableAllContacts.add(new ContactImpl(current.getId(), current.getName()));
		}
		if(!comparableAllContacts.containsAll(comparableInputContacts)){ 
			System.out.println("at least one of the contacts isn't in the list :  " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()+" thrown on contact : "+comparableAllContacts.toString() + " <Doesn't match> "+ comparableInputContacts.toString()); 
			throw new IllegalArgumentException();
		}
		//main
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
	public void addMeetingNotes(int id, String text) throws NullPointerException, IllegalArgumentException{
		//Exceptions
		if(text == null){
			System.out.println("Argument inputed evaluates to null: " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " w/ param: String note"); //<getMethodName() researched online. need to check if getClass() doesn't bring the performance down massively
			throw new NullPointerException();
		}
		if(!paf.getMeetingsIdIndex().contains(id)){
			System.out.println("Meeting requested is not a meeting at all : " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " w/ param: int id"); 
			throw new IllegalArgumentException();
		}
		dm = new DatesManagerImpl();
		Meeting newMeetingToCheckDate = getMeeting(id);
		if(!dm.checkDateIsInThePast(newMeetingToCheckDate.getDate())){
			System.out.println("date of meeting requested to add notes is in the future : " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()); 
			throw new IllegalStateException();
		}

		//main
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
	public void addNewContact(String name, String notes) throws NullPointerException{
		//Exceptions
		if(name == null|| notes == null){
			System.out.println("either contact name or notes are null > " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()); 
			throw new NullPointerException();
		}
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
	public Set<Contact> getContacts(int... ids) throws IllegalArgumentException{
		//exceptions
		vm = new ValuesManagerImpl();
		for(int i : ids){
			if(!vm.checkIdExistsInList(i, paf.getContactsIdIndex())){
				System.out.println("Contact requested is not in the list : " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName()); 
				throw new IllegalArgumentException();
			}
		}

		//main
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
	public Set<Contact> getContacts(String name) throws NullPointerException, IllegalArgumentException{
		//Exceptions
		if(name == null){
			System.out.println("Argument inputed evaluates to null: " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " w/ param: String Name"); //<getMethodName() researched online. need to check if getClass() doesn't bring the performance down massively
			throw new NullPointerException();
		}
		vm = new ValuesManagerImpl();
		
		//need to check substring name against all contacts with the possible substring as part of it
		boolean checkNameString = false;
		for(String current : paf.getContactsNameIndex()){
			if(current.contains(name)){
				checkNameString = true;
			}
		}
		if(!checkNameString){
			System.out.println("Argument inputed is not part of ContactsIndex: " + this.getClass().getName()+"."+ Thread.currentThread().getStackTrace()[1].getMethodName() + " w/ param: String Name"); 
			throw new IllegalArgumentException();
		}
		
		//main code
		Set<Contact> returnContacts = new HashSet<Contact>();
		Set<Contact> inputContacts = paf.getAllContacts();
		Iterator<Contact> iter = inputContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			if(current.getName().contains(name)){
				returnContacts.add(current);
			}
		}

		return returnContacts;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.ContactManager#flush()
	 */
	@Override
	public void flush() {
		getPaf().writeToFile(pathToFile);
	}

	//Debug Method
	public PopulatorAndFlusher getPaf(){
		return this.paf;
	}
}
