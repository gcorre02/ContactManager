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
public class FutureMeetingImpl extends MeetingImpl implements FutureMeeting{

	/**
	 * @param contacts 
	 * @param date 
	 * @param inputId 
	 * 
	 */
	public FutureMeetingImpl(int inputId, Calendar date, Set<Contact> contacts) {
		super(inputId, date, contacts);
	}

	public FutureMeetingImpl(Meeting current) {
		super(current.getId(), current.getDate(), current.getContacts());
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
		
		//return
		return this.getId()+ ",M," + contacts.substring(0,contacts.length()-1) +","+date;
		
	}

}
