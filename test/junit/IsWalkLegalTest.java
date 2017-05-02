/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class IsWalkLegalTest.
 */
public class IsWalkLegalTest {
	
	/** The Junit tester. */
	JunitTester JunitTester =  new JunitTester();
		
		/** The cap board red. */
		int[][] capBoardRed = {
				   {0, 1, 0, 3, 0, 1, 0, 0}, 
				   {2, 0, 0, 0, 0, 0, 2, 0}, 
				   {0, 0, 0, 0, 0, 0, 0, 2}, 
				   {0, 0, 0, 0, 4, 0, 2, 0}, 
				   {0, 2, 0, 1, 0, 0, 0, 2}, 
				   {0, 0, 3, 0, 2, 0, 3, 0}, 
				   {0, 4, 0, 2, 0, 0, 0, 2}, 
				   {1, 0, 3, 0, 2, 0, 0, 0}};

		
	/**
	 * Walk test 1.
	 */
	//OUt of bounds walk	
	@Test
	public void walkTest1() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 0, -1, -1, 0), 2);
	}

	/**
	 * Walk test 2.
	 */
	//occupied square
	@Test
	public void walkTest2() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 4, 7, 3, 6), 2);
	}
	
	/**
	 * Walk test 3.
	 */
	//red normal walk
	@Test
	public void walkTest3() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 0, 1, 1, 2), 1);
	}
	
	/**
	 * Walk test 4.
	 */
	//yellow normal walk
	@Test
	public void walkTest4() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 3, 6, 2, 5), 1);
	}
	
	/**
	 * Walk test 5.
	 */
	//Red king forward walk test
	@Test
	public void walkTest5() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 0, 3, 1, 4), 1);
	}
	
	/**
	 * Walk test 6.
	 */
	//Red king back walk test
	@Test
	public void walkTest6() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 0, 3, 1, 2), 1);
	}
	
	/**
	 * Walk test 7.
	 */
	//Yellow king forward walk test
	@Test
	public void walkTest7() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 3, 4, 2, 3), 1);
	}
	
	/**
	 * Walk test 8.
	 */
	//Yellow king backward walk test
	@Test
	public void walkTest8() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 3, 4, 4, 5), 1);
	}
	
	/**
	 * Walk test 9.
	 */
	//invalid number of rows
	@Test
	public void walkTest9() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 1, 4, 2, 1), 2);
	}
	
	/**
	 * Walk test 10.
	 */
	//invalid number of columns
	@Test
	public void walkTest10() {
		assertEquals(JunitTester.isWalkLegalTest(capBoardRed, 1, 0, 1, 1), 2);
	}
}
