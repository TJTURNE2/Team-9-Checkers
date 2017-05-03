/*
 * 
 */
package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class CheckersTest.
 */
public class CheckersTest {

	/**
	 * Checks if is possible square test 1.
	 */
	@Test
	public void isPossibleSquareTest1() {
		// test 1: even + even
		assert(JunitTester.isPossibleSquareTest(2, 2) == false);
	}
	
	/**
	 * Checks if is possible square test 2.
	 */
	@Test
	public void isPossibleSquareTest2() {
		// test 2: even + odd
		assert(JunitTester.isPossibleSquareTest(2, 3) == true);
	}
	
	/**
	 * Checks if is possible square test 3.
	 */
	@Test
	public void isPossibleSquareTest3() {
		// test 3: odd + odd
		assert(JunitTester.isPossibleSquareTest(3, 3) == false);
	}
}
