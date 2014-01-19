package myTools.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DatesManagerImplTest.class, PopulatorAndFlusherImplTest.class,
		ValuesManagerImplTest.class })
public class AllTests {

}
