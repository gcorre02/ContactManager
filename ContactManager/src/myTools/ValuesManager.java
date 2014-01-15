/**
 * 
 */
package myTools;

import java.util.List;
import java.util.Set;

/**
 * @author Guilherme
 *
 */
public interface ValuesManager {

	/*List of methods needed :
	 * 
	 * checkIdExistsInList(int id, List<Integer> anyIntegerList) > mock interface for the test	ContactManagerImplTest.java	
	 *
	 * checkContactNameIsUnique(Set<String> names, String candidateName)	
	 *
	 *
	 * int newIdGenerator (List<Integer> typeOfId )
	 *
	 */

	/**
	 * 
	 * @param id the integer the list is being checked against
	 * @param anyIntegerList any list one might want to check ids against
	 * @return true if id exists in list
	 */
	boolean checkIdExistsInList(int id, List<Integer> anyIntegerList);

	/**
	 * checks if candidateName is not in the set
	 * @param names the set of names to check candidateName against
	 * @param candidateName a potential unique name
	 * @return true if candidate name is in fact unique
	 */
	boolean checkContactNameIsUnique(Set<String> names, String candidateName);
	
	/**
	 * expects the last digit of the list to be the highest one, 
	 * iterates through the list to be sure using checkIdExistsInList() 
	 * using an increment of one from that value
	 * returns that unique value
	 * 
	 * @param anyIntegerList 
	 * @return goes through the list and returns outstanding ids
	 */
	int newIdGenerator (List<Integer> anyIntegerList );


}
