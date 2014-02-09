/**
 * 
 */
package contactmgmt;

/**
 * @author Guilherme
 *
 */
public class ContactImpl implements Contact {
	private static int hashcode;
	private int individualHashCode;
	private int id;
	private String name;
	private String notes;
	
	
	/**
	 * constructor for the object ContactImpl
	 * @param name of the contact
	 * @param id of the object
	 */
	public ContactImpl(int id, String name) {
		hashcode++;
		individualHashCode = hashcode;
		this.id = id;
		this.name = name;
		this.notes = "";
	}
	/**
	 * constructor for the object ContactImpl
	 * @param name of the contact
	 * @param id of the object
	 * @param notes the notes associated with the contact
	 */
	public ContactImpl(int id, String name,String notes) {
		this.id = id;
		this.name = name;
		this.notes = notes;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getId()
	 */
	@Override
	public int getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getNotes()
	 */
	@Override
	public String getNotes() {
		return notes;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#addNotes(java.lang.String)
	 */
	@Override
	public void addNotes(String note) {
		this.notes = note;
	}
	

	/**
	 * Overrides Object.toString() in order to return a string that matches what will be printed onto the csv file
	 * @return a string in the format id,C,Name,Notes (if there are any)
	 */
	@Override
	public String toString(){
		//this boolean checks whether the notes field is populated, and if so, adds a comma.
		String notes="";
		if(getNotes().length()>0){
			notes=","+getNotes();
		}
		return getId()+",C,"+ getName()+notes;
	}
	/**
	 * Overrides Object.equals() in order to allow for easy comparison of objects with similar data. also works with sets.
	 * @param inputContact the object of type ContactImpl being compared to.
	 */
	@Override
	public boolean equals(Object inputContact) throws IllegalArgumentException{
		if(inputContact == null){
			throw new IllegalArgumentException("Object being compared is null");
		}
		//every inputContact field needs casting because the overriden .equals only takes object, note: was having trouble trying to just overload it.
		if(this.id == ((ContactImpl) inputContact).getId()){
			if(this.name.equals(((ContactImpl) inputContact).getName())){
				if(this.notes.equals(((ContactImpl) inputContact).getNotes())){
					return true;
				}
			}
		}
		return false;
	}
	
	@Override
	public int hashCode(){
		return this.individualHashCode;
		
	}
	

}
