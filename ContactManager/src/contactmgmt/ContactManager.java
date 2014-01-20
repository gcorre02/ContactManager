package contactmgmt;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
/**
 * A class to manage your contacts and meetings.
 */
public interface ContactManager {
	//TODO <After Deliverable is Ready> make sure outputCsv file can be read by a csvReader program
	//TODO <After Deliverable is Ready> increase performance by accessing the file and not keeping it in memory all the time (check which version is faster : processing time vs ram weight)
	//TODO <JavaDocs> review javaDocs for every method, test and impl.
	/**
	 * Add a new meeting to be held in the future.
	 *
	 * @param contacts a list of contacts that will participate in the meeting
	 * @param date the date on which the meeting will take place
	 * @return the ID for the meeting
	 * //TODO <Exception Handling> @throws IllegalArgumentException if the meeting is set for a time in the past,
	 * or if any contact is unknown / non-existent
	 */
	int addFutureMeeting(Set<Contact> contacts, Calendar date);
	/**
	 * Returns the PAST meeting with the requested ID, or null if there is none.
	 *
	 * @param id the ID for the meeting
	 * @return the meeting with the requested ID, or null if it there is none.
	 * //TODO <Exception Handling> @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	 */
	PastMeeting getPastMeeting(int id);
	/**
	 * Returns the FUTURE meeting with the requested ID, or null if there is none.
	 *
	 * @param id the ID for the meeting
	 * @return the meeting with the requested ID, or null if it there is none.
	 * //TODO <Exception Handling> @throws IllegalArgumentException if there is a meeting with that ID happening in the past
	 */
	FutureMeeting getFutureMeeting(int id);
	/**
	 * Returns the meeting with the requested ID, or null if it there is none.
	 *
	 * @param id the ID for the meeting
	 * @return the meeting with the requested ID, or null if it there is none.
	 */
	Meeting getMeeting(int id);
	/**
	 * Returns the list of future meetings scheduled with this contact.
	 *
	 * If there are none, the returned list will be empty. Otherwise,
	 * the list will be chronologically sorted and will not contain any
	 * duplicates.
	 *
	 * @param contact one of the user�s contacts
	 * @return the list of future meeting(s) scheduled with this contact (maybe empty).
	 * //TODO <Exception Handling> @throws IllegalArgumentException if the contact does not exist
	 */
	List<Meeting> getFutureMeetingList(Contact contact);
	/**
	 * Returns the list of meetings that are scheduled for, or that took
	 * place on, the specified date
	 *
	 * If there are none, the returned list will be empty. Otherwise,
	 * the list will be chronologically sorted and will not contain any
	 * duplicates.
	 *
	 * @param date the date
	 * @return the list of meetings
	 */
	List<Meeting> getFutureMeetingList(Calendar date);
	/**
	 * Returns the list of past meetings in which this contact has participated.
	 *
	 * If there are none, the returned list will be empty. Otherwise,
	 * the list will be chronologically sorted and will not contain any
	 * duplicates.
	 *
	 * @param contact one of the user�s contacts
	 * @return the list of future meeting(s) scheduled with this contact (maybe empty).
	 * //TODO <Exception Handling> @throws IllegalArgumentException if the contact does not exist
	 */
	List<PastMeeting> getPastMeetingList(Contact contact);
	/**
	 * Create a new record for a meeting that took place in the past.
	 *
	 * @param contacts a list of participants
	 * @param date the date on which the meeting took place
	 * @param text messages to be added about the meeting.
	 * //TODO <Exception Handling> @throws IllegalArgumentException if the list of contacts is
	 * empty, or any of the contacts does not exist
	 * //TODO <Exception Handling> @throws IllegalArgumentException if date inputed is in the future
	 * //TODO <Exception Handling> @throws NullPointerException if any of the arguments is null
	 */
	void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text);
	/**
	 * Add notes to a meeting.
	 *
	 * TODO <Important> implement this :This method is used when a future meeting takes place, and is
	 * then converted to a past meeting (with notes).
	 * TODO <Important> how else does the Conversion to PastMeeting can work ?
	 * It can be also used to add notes to a past meeting at a later date.
	 *
	 * TODO <Current>
	 *
	 * @param id the ID of the meeting
	 * @param text messages to be added about the meeting.
	 * //TODO <Exception Handling> @throws IllegalArgumentException if the meeting does not exist
	 * //TODO <Exception Handling> @throws IllegalStateException if the meeting is set for a date in the future
	 * //TODO <Exception Handling> @throws NullPointerException if the notes are null
	 */
	void addMeetingNotes(int id, String text);
	/**
	 * Create a new contact with the specified name and notes.
	 *
	 * @param name the name of the contact.
	 * @param notes notes to be added about the contact.
	 * //TODO <Exception Handling> @throws NullPointerException if the name or the notes are null
	 */
	void addNewContact(String name, String notes);
	/**
	 * Returns a list containing the contacts that correspond to the IDs.
	 *
	 * @param ids an arbitrary number of contact IDs
	 * @return a list containing the contacts that correspond to the IDs.
	 * //TODO <Exception Handling> @throws IllegalArgumentException if any of the IDs does not correspond to a real contact
	 */
	Set<Contact> getContacts(int... ids);
	/**
	 * Returns a list with the contacts whose name contains that string.
	 *
	 * @param name the string to search for
	 * @return a list with the contacts whose name contains that string.
	 * @throws NullPointerException if the parameter is null
	 * @throws IllegalArgumentException if name isn't part of the index
	 */
	Set<Contact> getContacts(String name);
	/**
	 * Save all data to disk.
	 *
	 * This method must be executed when the program is
	 * closed and when/if the user requests it.
	 */
	void flush();
}