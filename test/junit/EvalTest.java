package junit;

import org.junit.Test;
import checkers.JunitTester;
import static org.junit.Assert.*;

public class EvalTest {

	JunitTester test = new JunitTester();
	
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
		assertEquals(test.evalTest(capBoardRed), 112);
		assertEquals(test.evalTest(capBoardRed), 113);
		assertEquals(test.evalTest(capBoardRed), 114);
		assertEquals(JUnitTester.evalTest(capBoardRed), 115);
		assertEquals(JUnitTester.evalTest(capBoardRed), 116);
		assertEquals(JUnitTester.evalTest(capBoardRed), 117);
		assertEquals(JUnitTester.evalTest(capBoardRed), 118);
		assertEquals(JUnitTester.evalTest(capBoardRed), 119);
		assertEquals(JUnitTester.evalTest(capBoardRed), 120);
		assertEquals(JUnitTester.evalTest(capBoardRed), 121);
		assertEquals(JUnitTester.evalTest(capBoardRed), 122);
	}

}
