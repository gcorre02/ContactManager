/**
 * 
 */
package myTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Guilherme
 *
 */
public class ValuesManagerImpl implements ValuesManager {

	/* (non-Javadoc)
	 * @see myTools.ValuesManager#checkIdExistsInList(int, java.util.List)
	 */
	@Override
	public boolean checkIdExistsInList(int id, List<Integer> anyIntegerList) {
		for(int t : anyIntegerList){
			if(t == id){
				return true;
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see myTools.ValuesManager#checkContactNameIsUnique(java.util.Set, java.lang.String)
	 */
	@Override
	public boolean checkContactNameIsUnique(Set<String> names, String candidateName) {
		for(String str : names){
			if(str.equals(candidateName)){
				return false;
			}
		}
		return true;
	}

	/* (non-Javadoc)
	 * @see myTools.ValuesManager#newIdGenerator(java.util.List)
	 */
	@Override
	public int newIdGenerator(List<Integer> anyIntegerList) {
		anyIntegerList = reorganiseList(anyIntegerList);
		int i = 0; //< find the minimum, 0 might not be it, but 0 is where it should start <fine>
		do{
			i++;
		}while(anyIntegerList.contains(i));
		return i;
	}
	
	/* (non-Javadoc)
	 * @see myTools.ValuesManager#reorganiseList(java.util.List)
	 */
	@Override
	public List<Integer> reorganiseList(List<Integer> anyIntegerList) {
		//need to instanciate a new list that is a copy of anyIntegerList to iterate through, otherwise anyIntegerList gets erased
		List<Integer> stubList = new ArrayList<Integer>();
		for(int i : anyIntegerList){
			stubList.add(i);
		}
		
		List<Integer> newList = new ArrayList<Integer>();
		int minimum = 0;
		for (int i : stubList){
			if(i> minimum){
				minimum = i;
			}
		}
		stubList.remove(stubList.indexOf(minimum));
		if(stubList.size()>0){
			newList.addAll(reorganiseList(stubList));
		}
		newList.add(minimum);
		return newList;
	}
	
	/* (non-Javadoc)
	 * @see myTools.ValuesManager#printList(java.util.List, java.lang.String)
	 */
	@Override
	public void printList(List<Integer> inputIntegerList, String listName) {
		System.out.println("Begginning printing of list: " + listName);
		for(int i : inputIntegerList){
			System.out.println(i);
		}
		System.out.println("Ending printing of this list" + listName);

	}
	

}
