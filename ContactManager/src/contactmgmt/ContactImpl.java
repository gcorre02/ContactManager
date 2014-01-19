/**
 * 
 */
package contactmgmt;

/**
 * @author Guilherme
 *
 */
public class ContactImpl implements Contact {

	private int id;
	private String name;
	private String notes;
	
	//TODO Override toString() 
	
	/**
	 * @param name name of the contact <<< not unique
	 * @param id id of the object
	 * construts the object ContactImpl
	 */
	public ContactImpl(int id, String name) {
		this.id = id;
		this.name = name;
		this.notes = "";
		// TODO Auto-generated constructor stub <<<< need to accept aliases!!
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
	
	@Override
	public String toString(){
		String notes="";
		if(getNotes().length()>0){
			notes=","+getNotes();
		}
		return getId()+",C,"+ getName()+notes;
	}


}
