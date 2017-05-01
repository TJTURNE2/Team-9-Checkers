package test;

import org.junit.Test;
import checkers.Help;

/**
 * Unit Test #2 in Software Test Plan
 * Checks to make sure "Help" menu is constructed.
 * @author Cristi DeLeo
 * @version 1.0
 * @since 27 April 2017
 */
public class HelpTest 
{
	Help tester;
	
	@Test
	public void testHelp() 
	{
		tester = new Help();
	}
}
