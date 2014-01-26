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
	//TODO <JavaDocs> review javaDocs for every method, test and impl.
	

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
	 * returns -1 if the id generated is not unique; <<<< Should just get the highest value an increment
	 * 
	 * @param anyIntegerList 
	 * @return goes through the list and returns outstanding ids
	 */
	int newIdGenerator (List<Integer> anyIntegerList );
	
	/**
	 * 
	 * @param anyIntegerList input array to reorganise 
	 * @return this list reorganized
	 * 
	 */
	List<Integer> reorganiseList(List<Integer> inputIntegerList);

	/**
	 * debugging method, prints contents of the list
	 * @param inputIntegerList list to be printed
	 * @param listName list identifier for debug
	 */
	void printList(List<Integer> inputIntegerList, String listName);
	
	/**
	 * 
	 * @param names list to check a single name against
	 * @param candidateName name to be checked for uniqueness
	 * @return true if candidateName isn't in the list
	 */
	boolean checkContactNameIsUnique(List<String> names, String candidateName);



}
