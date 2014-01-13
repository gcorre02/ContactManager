package contactmgmt;

import java.util.Calendar;
import java.util.Set;

/**
* A meeting to be held in the future
*/
public class FutureMeetingImpl implements FutureMeeting{

// No methods here, this is just a naming interface
// (i.e. only necessary for type checking and/or downcasting)

/**
* Returns the id of the meeting.
*
* @return the id of the meeting.
*/
public int getId(){

}

/**
* Return the date of the meeting.
*
* @return the date of the meeting.
*/
public Calendar getDate(){}

/**
* Return the details of people that attended the meeting.
*
* The list contains a minimum of one contact (if there were
* just two people: the user and the contact) and may contain an
* arbitraty number of them.
*
* @return the details of people that attended the meeting.
*/
public Set<Contact> getContacts(){}

}