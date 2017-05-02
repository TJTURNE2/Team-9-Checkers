package junit;

import org.junit.Test;
import checkers.JunitTester;

import static org.junit.Assert.*;

public class EvalTest {
	JunitTester JunitTester =  new JunitTester();
	
	int[][] capBoardRed = {
			   {3, 0, 0, 0, 0, 0, 0, 4}, 
			   {1, 3, 0, 0, 0, 0, 4, 2}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {0, 0, 0, 0, 0, 0, 0, 0}, 
			   {2, 4, 0, 0, 0, 0, 3, 1}, 
			   {4, 0, 0, 0, 0, 0, 0, 3}};

	//running eval test 1k times to ensure the random value (1-10) never brings the expected value outside the range
	@Test
	public void evalTest() {
		boolean eval = false;
		for(int i = 0; i < 1000; i++) {
			if (JunitTester.evalTest(capBoardRed) >= 0 && JunitTester.evalTest(capBoardRed) <= 10) {
				eval = true;
			}
			assertTrue(eval);
			eval = false;
		}	
	}
}
