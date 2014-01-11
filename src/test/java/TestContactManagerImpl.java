package contactmgmt;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.*;

import java.io.*;
import java.net.*;
import java.util.*;


//5. commit : doing research into mockito so i can test and program the whole ContactManagerImpl class without having to program the implementations of other classes first
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

	@Test
	public void testAddFutureMeeting(){
		//fail("Test Not Written yet");
		assertEquals(1,1);
	}


}