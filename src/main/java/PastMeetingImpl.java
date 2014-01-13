package contactmgmt;

/**
* A meeting that was held in the past.
*
* It includes your notes about what happened and what was agreed.
*/
import java.util.HashSet;
import java.util.Calendar;
import java.util.Set;

public class PastMeetingImpl implements PastMeeting {

/**
* Returns the id of the meeting.
*
* @return the id of the meeting.
*/
	public int getId(){
		return 0;
	}

/**
* Return the date of the meeting.
*
* @return the date of the meeting.
*/
	public Calendar getDate(){
		return Calendar.getInstance();
	}

/**
* Return the details of people that attended the meeting.
*
* The list contains a minimum of one contact (if there were
* just two people: the user and the contact) and may contain an
* arbitraty number of them.
*
* @return the details of people that attended the meeting.
*/
	public Set<Contact> getContacts(){
		return new HashSet<Contact>();
	}
/**
* Returns the notes from the meeting.
*
* If there are no notes, the empty string is returned.
*
* @return the notes from the meeting.
*/
	public String getNotes(){
		return "";
	}
}