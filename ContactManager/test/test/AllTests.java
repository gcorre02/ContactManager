package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ContactImplTest.class,
		FutureMeetingImplTest.class, MeetingImplTest.class,
		PastMeetingImplTest.class, ContactManagerImplTest.class })
public class AllTests {

}
