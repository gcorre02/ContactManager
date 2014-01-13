package contactmgmt;
/**
* A contact is a person we are making business with or may do in the future.
*
* Contacts have an ID (unique), a name (probably unique, but maybe
* not), and notes that the user may want to save about them.
*/
public class ContactImpl implements Contact {
	String notes;
	String name;
	int id;

/**
* Returns the ID of the contact.
*
* @return the ID of the contact.
*/
public int getId(){
	int stub = id;
	return stub;
}

/**
* Returns the name of the contact.
*
* @return the name of the contact.
*/
public String getName(){
	String stub = name;
	return name;
}

/**
* Returns our notes about the contact, if any.
*
* If we have not written anything about the contact, the empty
* string is returned.
*
* @return a string with notes about the contact, maybe empty.
*/
public String getNotes(){
	String stub = notes;
	return stub;
}

/**
* Add notes about the contact.
*
* @param note the notes to be added
*/
public void addNotes(String note){}
}