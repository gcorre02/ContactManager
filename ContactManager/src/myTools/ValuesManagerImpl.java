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
		
		/**
		 * expects the last digit of the list to be the highest one, 
		 * iterates through the list to be sure using checkIdExistsInList() 
		 * using an increment of one from that value
		 * returns that unique value
		 * 
		 * @param anyIntegerList 
		 * @return goes through the list and returns outstanding ids
		 */
		
		// TODO Auto-generated method stub
		return 0;
	}

}
