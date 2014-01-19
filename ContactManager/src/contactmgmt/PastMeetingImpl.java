/**
 * 
 */
package contactmgmt;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Guilherme
 *
 */
public class PastMeetingImpl extends MeetingImpl implements PastMeeting{

	private String notes;

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * @param notes
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts, String notes) {
		super(inputId, date, contacts);
		this.notes = notes;
	}
	
	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 */
	public PastMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		super(inputId, date, contacts);
		this.notes = "";
	}

	/* (non-Javadoc)
	 * @see contactmgmt.PastMeeting#getNotes()
	 */
	@Override
	public String getNotes() {
		return notes;
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
		if(getNotes().length()>0){
			notes=","+getNotes();
		}
		
		//return
		return this.getId()+ ",M," + contacts.substring(0,contacts.length()-1) +","+date+notes;
		
	}
}
