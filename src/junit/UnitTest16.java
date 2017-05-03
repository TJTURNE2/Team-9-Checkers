/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTest16.
 */
public class UnitTest16 {

		/** The test. */
		JunitTester test = new JunitTester();
		
		/**
		 * Test get turn.
		 */
		@Test
		public void testGetTurn() {	
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(1));
			assertEquals("Whos Turn", -test.getInf(),test.getGetTurn(2)); 
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(3));
			assertEquals("Whos Turn", -test.getInf(),test.getGetTurn(4));
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(0));
		}
}
