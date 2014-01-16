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
		
		int previous = -1;
		for(int i : anyIntegerList){
			if(i != previous+1){
				if(!checkIdExistsInList(previous+1, anyIntegerList)){
					return previous+1;
				}
					return newIdGenerator(reorganiseList(anyIntegerList));
			}
			previous ++;
		}
		if(!checkIdExistsInList(previous+1, anyIntegerList)){
			return previous+1;
		}
		return newIdGenerator(reorganiseList(anyIntegerList));
	}
	
	/* (non-Javadoc)
	 * @see myTools.ValuesManager#reorganiseList(java.util.List)
	 */
	@Override
	public List<Integer> reorganiseList(List<Integer> anyIntegerList) {
		List<Integer> newList = new ArrayList<Integer>();
		int minimum = 0;
		for (int i : anyIntegerList){
			if(i> minimum){
				minimum = i;
			}
		}
		anyIntegerList.remove(anyIntegerList.indexOf(minimum));
		if(anyIntegerList.size()>0){
			newList.addAll(reorganiseList(anyIntegerList));
		}
		newList.add(minimum);
		return newList;
	}

}
