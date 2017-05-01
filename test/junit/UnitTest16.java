package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

public class UnitTest16 {

		JunitTester test = new JunitTester();
		
		@Test
		public void testGetTurn() {	
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(1));
			assertEquals("Whos Turn", -test.getInf(),test.getGetTurn(2)); 
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(3));
			assertEquals("Whos Turn", -test.getInf(),test.getGetTurn(4));
			assertEquals("Whos Turn", test.getInf(),test.getGetTurn(0));
		}
}
