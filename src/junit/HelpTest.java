/*
 * 
 */
package junit;

import org.junit.Test;
import checkers.Help;
import checkers.JunitTester;
// TODO: Auto-generated Javadoc
/**
 * Unit Test #2 in Software Test Plan
 * Checks to make sure "Help" menu is constructed.
 * @author Cristi DeLeo
 * @version 1.0
 * @since 27 April 2017
 */
public class HelpTest 
{
  
  /** The Junit tester. */
  JunitTester JunitTester = new checkers.JunitTester();
  
	/** The tester. */
	Help tester;
	
	/**
	 * Test help.
	 */
	@Test
	public void testHelp() 
	{
		tester = JunitTester.newHelp();
	}
}
