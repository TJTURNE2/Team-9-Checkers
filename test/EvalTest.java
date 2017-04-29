package test;

import org.junit.Test;
import checkers.JUnitTester;
import static org.junit.Assert.*;

public class EvalTest {

	int[][] capBoardRed = {
			   {0, 0, 0, 0, 0, 0, 0, 4}, 
			   {1, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 2}, 
			   {3, 0, 0, 0, 0, 0, 0, 0}};

	@Test
	public void evalTest() {
		boolean eval = false;
		for(int i = 0; i < 1000; i++) {
			if (JUnitTester.evalTest(capBoardRed) >= 0 && JUnitTester.evalTest(capBoardRed) <= 10) {
				eval = true;
			}
			assertTrue(eval);
			eval = false;
		}	
	}
}
