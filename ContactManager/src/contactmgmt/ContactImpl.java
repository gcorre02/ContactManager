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

	/**
	 * @param name name of the contact <<< not unique
	 * @param id id of the object
	 * construts the object ContactImpl
	 */
	public ContactImpl(int id, String name) {
		this.id = id;
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getId()
	 */
	@Override
	public int getId() {
		return this.id;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getName()
	 */
	@Override
	public String getName() {
		return this.name;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#getNotes()
	 */
	@Override
	public String getNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see contactmgmt.Contact#addNotes(java.lang.String)
	 */
	@Override
	public void addNotes(String note) {
		// TODO Auto-generated method stub

	}

}
