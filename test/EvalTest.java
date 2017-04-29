package test;

import org.junit.Test;
import checkers.JUnitTester;
import static org.junit.Assert.*;

public class EvalTest {

	int[][] capBoardRed = {
			   {0, 1, 0, 3, 0, 1, 0, 0}, 
			   {2, 0, 0, 0, 2, 0, 2, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 2}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 2, 0, 1, 0, 0, 0, 2}, 
			   {0, 0, 3, 0, 2, 0, 3, 0}, 
			   {0, 4, 0, 2, 0, 0, 0, 2}, 
			   {1, 0, 3, 0, 2, 0, 0, 0}};

	@Test
	public void evalTest() {
		boolean eval = false;
		if (JUnitTester.evalTest(capBoardRed) >= 112 && JUnitTester.evalTest(capBoardRed) <= 122) {
			eval = true;
		}
		assertTrue(eval);
	}

}
