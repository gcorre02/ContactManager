package contactmgmt;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;

public class TestContactManagerImpl{
	
	ContactManager cm;

	@Before
	public void beforeMethodTest(){
		cm = new ContactManagerImpl();
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
		assertEquals(cm.getCsvRows()[0],"0,C,Sherlock BadBury, 079555768");
	}

	/**
	* need to mock : @param contacts a list of contacts that will participate in the meeting
	* need to mock : @param date the date on which the meeting will take place
	* need to mock : meetings(field)
	* need to test : @return the ID for the meeting
	* need to test : @throws IllegalArgumentException if the meeting is set for a time in the past,
	* of if any contact is unknown / non-existent
	* need to test : check meeting has been added to the (schedule) meetings(field)
	**/
	@Test
	public void testAddFutureMeeting(){
		fail("Test Not Written yet");
		//write mock for args input
		//write test
	}
}