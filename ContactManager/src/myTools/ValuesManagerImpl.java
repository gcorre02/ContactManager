/**
 * 
 */
package myTools;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import contactmgmt.Meeting;


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
	 * @see myTools.ValuesManager#checkContactNameIsUnique(java.util.List, java.lang.String)
	 */
	@Override
	public boolean checkContactNameIsUnique(List<String> names, String candidateName) {
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
	/* (non-Javadoc)
	 * @see myTools.ValuesManager#sortContactsByDate(java.util.Set)
	 */
	@Override
	public List<Meeting> sortMeetingsByDate(Set<Meeting> meetings) {
		Set<Meeting> inputMeetings = new HashSet<Meeting>();
		
		//Maintain the integrity of the meetings set.
		for(Meeting inputMeeting : meetings){
			inputMeetings.add(inputMeeting);
		}
		
		//select and organize the meetings by date
		List<Meeting> outputMeetings;
		if(meetings.size()>1){
			outputMeetings = new ArrayList<Meeting>();
			outputMeetings = recursiveMeetingDateSort(inputMeetings, outputMeetings);
		} else{
			outputMeetings = new ArrayList<Meeting>(inputMeetings);
		}
		//correct recursion error TODO<important> not a solution!
//		outputMeetings.remove(outputMeetings.get(outputMeetings.size()-1));
		//return
		return outputMeetings;
	}
	/*
	 * Recursive method that helps reorganise a set by date.
	 * 
	 */
	private List<Meeting> recursiveMeetingDateSort(Set<Meeting> inputMeetings, List<Meeting> outputMeetings){
		//TODO method repeating the last one! recurring!!
		if(inputMeetings.isEmpty()){
			return outputMeetings;
		}
		Calendar currentDate = new GregorianCalendar();
		for(Meeting current : inputMeetings){
			currentDate = current.getDate();
			for(Meeting anotherMeeting : inputMeetings){
				if(currentDate.after(anotherMeeting.getDate())){
					currentDate = anotherMeeting.getDate();
				}
			}
		}
		for(Meeting m : inputMeetings){
			if(m.getDate().equals(currentDate)){
				outputMeetings.add(m);
				Set<Meeting> nextInputMeetings = new HashSet<Meeting>();
				for(Meeting f : inputMeetings){
					if(!f.equals(m)){
						nextInputMeetings.add(f);
					}
				}
//				nextInputMeetings.remove(m);
				recursiveMeetingDateSort(nextInputMeetings, outputMeetings);
			}
		}
		return outputMeetings;
	}
	
}
