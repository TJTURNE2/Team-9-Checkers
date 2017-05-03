/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;
import org.junit.Test;
import checkers.CheckerFrame;
import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckerFrameTest.
 */
public class CheckerFrameTest {
	
	/** The Junit tester. */
	JunitTester JunitTester = new JunitTester();
	
	/**
	 * C frame test.
	 */
	@Test
	public void CFrameTest() {
		assertNotNull(JunitTester.getCheckerFrame());
		//JunitTester.CFrameTest();
	}

}
