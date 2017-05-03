/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

/**
 * The Class InRangeTest.
 */
public class InRangeTest {
	
	/** The Junit tester. */
	JunitTester JunitTester =  new JunitTester();
	
	/**
	 * Instantiates a new in range test.
	 */
	public InRangeTest() {
	}

	/**
	 * In range test 1.
	 * values both in range
	 */

	@Test
	public void inRangeTest1() {
		assertTrue(JunitTester.inRangeTest(0, 7));
	}
	
	/**
	 * In range test 2.
	 * first value below range
	 */

	@Test
	public void inRangeTest2() {
		assertFalse(JunitTester.inRangeTest(-1, 7));
	}
	
	/**
	 * In range test 3.
	 * first value above range
	 */

	@Test
	public void inRangeTest3() {
		assertFalse(JunitTester.inRangeTest(8, 7));
	}
	
	/**
	 * In range test 4.
	 * second value below range
	 */

	@Test
	public void inRangeTest4() {
		assertFalse(JunitTester.inRangeTest(0, -1));
	}

	/**
	 * In range test 5.
	 * //second value above range
	 * 
	 */

	@Test
	public void inRangeTest5() {
		assertFalse(JunitTester.inRangeTest(0, 8));
	}
}
