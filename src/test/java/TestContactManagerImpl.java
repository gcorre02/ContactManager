<<<<<<<<<<<<<<<<<<<TESTING INTERRUPTED >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

import contactmgmt.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.HashSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

import java.io.*;

public class TestContactManagerImpl{
	
	ContactManager cm;

	@Before
	public void beforeMethodTest(){
		try{
			String fileDir = "."+ File.separator +"contacts.txt";
			File csv = new File(fileDir);
			FileWriter fw = new FileWriter(csv.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("0,M, Merlock Shant, 023555123");
			bw.newLine();
			bw.write("2457,C, Sherlock Shant, 079555768");
			bw.newLine();
			bw.write("2,M, Merlock BadBury, 023555123");
			bw.newLine();
			bw.write("3,C, Sherlock BadBury, 079555768");
			bw.close();
		} catch(IOException e){
			fail("file doesnt exist");
		}
		cm = spy(new ContactManagerImpl());
	}

	@After
	public void afterMethodTest(){
		cm = null;
	}

	@AfterClass
	public static void afterTestIsRun(){
		String fileDir = "."+ File.separator +"contacts.txt";
		File csv = new File(fileDir);
		csv.delete();
	}

	@Test
	public void testCsvTXTisCreated(){
		String fileDir = "."+ File.separator +"contacts.txt";
		File csv = new File(fileDir);
		assertTrue(csv.isFile());
	}

	@Test
	public void testCSVIndexisLoaded(){		
		//need to check if csvRows is populated;
		assertEquals(cm.getCsvRows()[3],"3,C, Sherlock BadBury, 079555768");
	}

	
	@Test
	public void testAddFutureMeeting(){
		int contactID = 3;
		Calendar userInputDate = new GregorianCalendar(2014, 10, 21); //using this class because the implementation is much easier
		//mocking section
		Contact mockContact = mock(Contact.class);
        when(mockContact.getId()).thenReturn(contactID);
    	Set<Contact> inputContactList = new HashSet<Contact>();
		inputContactList.add(mockContact);

		//test section >> testing whether id is being returned and if it is being added to the csvRows variable
		int meetingID = cm.addFutureMeeting(inputContactList, userInputDate);
		int newMeetingIndex = Integer.parseInt(cm.getCsvRows()[cm.getCsvRows().length-1].substring(0,cm.getCsvRows()[cm.getCsvRows().length-1].indexOf(',')));
		assertEquals(newMeetingIndex, meetingID);		
	}
	
	//tests whether the right exception is thrown and if it is handled propperly, one for date in the past and one for invalid contact
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgEfromDate(){
		
		int contactID2 = 3;
		Calendar userInputDate = new GregorianCalendar(2013, 10, 21); //using this class because the implementation is much easier
		//mocking section
		Contact mockContact2 = mock(Contact.class);
        when(mockContact2.getId()).thenReturn(contactID2);
    	Set<Contact> inputContactList2 = new HashSet<Contact>();
		inputContactList2.add(mockContact2);

		//test section >> testing whether id is being returned and if it is being added to the csvRows variable
		int meetingID = cm.addFutureMeeting(inputContactList2, userInputDate);

	}
	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgEfromContact(){

		///// biggest problem is make sure any aleatory number does the right thing
		
		
		int contactID1 = 5;
		Calendar userInputDate = new GregorianCalendar(2014, 10, 21); //using this class because the implementation is much easier
		//mocking section
		Contact mockContact1 = mock(Contact.class);
        when(mockContact1.getId()).thenReturn(contactID1);
    	Set<Contact> inputContactList1 = new HashSet<Contact>();
		inputContactList1.add(mockContact1);

		//test section >> testing whether id is being returned and if it is being added to the csvRows variable
		int meetingID = cm.addFutureMeeting(inputContactList1, userInputDate);	
	}

	/**
	* Returns the PAST meeting with the requested ID, or null if it there is none.
	*
	* @param id the ID for the meeting
	* @return the meeting with the requested ID, or null if it there is none.
	* @throws IllegalArgumentException if there is a meeting with that ID happening in the future
	*/
	@Test
	public void testReturnsPastMeetingCorrectly(){
		//mocking section
		PastMeetingImpl pastMeetingMock = mock(PastMeetingImpl.class);
		when(pastMeetingMock.getId()).thenReturn(0);
		//cm must have a method that converts the Strings in csvRows into meeting objects >> private Meeting convertToMeeting(int id), should be private
		//.convertToMeeting() is a method that can be called inside the populate index arrays method, should be PRIVATE!! - Use PowerMock to do it >> later//
		when(cm.convertToPastMeeting(0)).thenReturn(pastMeetingMock);
		//this test makes sure that the pastMeeting in the meetings set<Meetings> that corresponds to the int id is being retrieved//  
		assertEquals(0, cm.getPastMeeting(0).getId());
	}
	@Test(expected = IllegalArgumentException.class)
	public void testGetPastMeetingIdInFuture(){
		//fail("test not written yet");
		PastMeeting futureMeeting = cm.getPastMeeting(2);

	}
	@Test
	public void testGetPastMeetingNull(){
		//null return tested here too
		//fail("test not written yet");
		assertEquals(null, cm.getPastMeeting(1));
	}
}