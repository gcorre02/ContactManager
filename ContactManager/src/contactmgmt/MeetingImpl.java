/**
 * 
 */
package contactmgmt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author Guilherme
 *
 */
public class MeetingImpl implements Meeting {

	private int id;
	private Calendar date;
	private Set<Contact> contacts;
	protected String notes;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public MeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		this.id = inputId;
		this.date = date;
		this.contacts = contacts;
		this.notes = "";
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getDate()
	 */
	@Override
	public Calendar getDate() {
		return this.date;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Meeting#getContacts()
	 */
	@Override
	public Set<Contact> getContacts() {
		return this.contacts;
	}

	@Override
	public String toString(){
		Calendar meetingDate = this.getDate();
		String month = ((Integer)meetingDate.get(Calendar.MONTH)).toString();
		String day = ((Integer)meetingDate.get(Calendar.DAY_OF_MONTH)).toString();
		if(month.length()==1){
			month = "0"+month;
		}
		if(day.length()==1){
			day = "0"+day;
		}
		String date = ((Integer)meetingDate.get(Calendar.YEAR)).toString()+ month+ day;

		String contacts ="";// need to remove white spaces!
		//concatenate contact names
		Set<Contact> meetingContacts = this.getContacts();
		Iterator<Contact> iter = meetingContacts.iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			String[] fullName = current.getName().split(" ");
			for(String str : fullName){
				contacts = contacts + str;
			}
			contacts = contacts + " ";
		}
		String notes="";
		if(this.notes.length()>0){
			notes=","+this.notes;
		}

		//return
		return this.getId()+ ",M," + contacts.substring(0,contacts.length()-1) +","+date+notes;

	}
	@Override
	public boolean equals(Object inputMeeting){
		
		//input meeting contacts set
		Set<ContactImpl> overridenContacts = new HashSet<ContactImpl>();
		Iterator<Contact> iter = ((MeetingImpl)inputMeeting).getContacts().iterator();
		while(iter.hasNext()){
			Contact current = iter.next();
			overridenContacts.add((ContactImpl)current);
		}
		
		//this meeting contacts set
		Set<ContactImpl> thisContacts = new HashSet<ContactImpl>();
		Iterator<Contact> thisIter = this.contacts.iterator();
		while(thisIter.hasNext()){
			Contact current = thisIter.next();
			thisContacts.add((ContactImpl)current);
		}
		//convert to list so they can be compared
		List<ContactImpl> thisContactsList = new ArrayList<ContactImpl>(thisContacts);
		List<ContactImpl> overridenContactsList = new ArrayList<ContactImpl>(overridenContacts);
		//main
		if(thisContactsList.containsAll(overridenContactsList)){ 
			if(this.date.equals(((MeetingImpl) inputMeeting).getDate())){
				if(this.id==((MeetingImpl) inputMeeting).getId()){
					return true;
				}
			}
		}
		return false;

	}
}
