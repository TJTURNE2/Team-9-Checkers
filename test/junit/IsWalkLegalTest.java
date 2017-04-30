package junit;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.JUnitTester;

public class IsWalkLegalTest {
		
		int[][] capBoardRed = {
				   {0, 1, 0, 3, 0, 1, 0, 0}, 
				   {2, 0, 0, 0, 0, 0, 2, 0}, 
				   {0, 0, 0, 0, 0, 0, 0, 2}, 
				   {0, 0, 0, 0, 4, 0, 2, 0}, 
				   {0, 2, 0, 1, 0, 0, 0, 2}, 
				   {0, 0, 3, 0, 2, 0, 3, 0}, 
				   {0, 4, 0, 2, 0, 0, 0, 2}, 
				   {1, 0, 3, 0, 2, 0, 0, 0}};

		
	//OUt of bounds walk	
	@Test
	public void walkTest1() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 0, -1, -1, 0), 2);
	}

	//occupied square
	@Test
	public void walkTest2() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 4, 7, 3, 6), 2);
	}
	
	//red normal walk
	@Test
	public void walkTest3() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 0, 1, 1, 2), 1);
	}
	
	//yellow normal walk
	@Test
	public void walkTest4() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 3, 6, 2, 5), 1);
	}
	
	//Red king forward walk test
	@Test
	public void walkTest5() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 0, 3, 1, 4), 1);
	}
	
	//Red king back walk test
	@Test
	public void walkTest6() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 0, 3, 1, 2), 1);
	}
	
	//Yellow king forward walk test
	@Test
	public void walkTest7() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 3, 4, 2, 3), 1);
	}
	
	//Yellow king backward walk test
	@Test
	public void walkTest8() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 3, 4, 4, 5), 1);
	}
	
	//invalid number of rows
	@Test
	public void walkTest9() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 1, 4, 2, 1), 2);
	}
	
	//invalid number of columns
	@Test
	public void walkTest10() {
		assertEquals(JUnitTester.isWalkLegalTest(capBoardRed, 1, 0, 1, 1), 2);
	}
}
