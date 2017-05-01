package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import checkers.JunitTester;

public class CheckerMoveTest {
	
	JunitTester JunitTester = new JunitTester();
	
	int[][] capBoardRed = {{0, 1, 0, 3, 0, 1, 0, 0}, 
						   {2, 0, 0, 0, 2, 0, 2, 0}, 
						   {0, 0, 0, 0, 0, 0, 0, 2}, 
						   {0, 0, 0, 0, 0, 0, 0, 0}, 
						   {0, 2, 0, 1, 0, 0, 0, 2}, 
						   {0, 0, 3, 0, 2, 0, 3, 0}, 
						   {0, 4, 0, 2, 0, 0, 0, 2}, 
						   {1, 0, 3, 0, 2, 0, 0, 0}};
	
	int[][] capBoardYellow = {{0, 0, 0, 0, 0, 0, 0, 2}, 
							  {1, 0, 0, 0, 0, 0, 3, 0}, 
							  {0, 4, 0, 0, 0, 4, 0, 0}, 
							  {1, 0, 0, 0, 1, 0, 2, 0}, 
							  {0, 0, 0, 0, 0, 0, 0, 0}, 
							  {0, 0, 1, 0, 2, 0, 0, 0}, 
							  {0, 0, 0, 2, 0, 1, 0, 1}, 
							  {0, 0, 0, 0, 4, 0, 2, 0}};
	
	int[][] capBoardRedFlip = {{0, 2, 0, 0, 0, 0, 0, 1}, 
							   {1, 0, 0, 0, 2, 0, 4, 0}, 
							   {0, 0, 0, 0, 0, 3, 0, 3}, 
							   {3, 0, 0, 0, 1, 0, 2, 0}, 
							   {0, 2, 0, 0, 0, 2, 0, 2}, 
							   {1, 0, 0, 0, 0, 0, 0, 0}, 
							   {0, 2, 0, 0, 0, 3, 0, 0}, 
							   {0, 0, 2, 0, 2, 0, 2, 0}};
	
	int[][] noCapBoardFlip = {{0, 0, 0, 0, 0, 0, 0, 0}, 
							  {1, 0, 0, 0, 0, 0, 0, 0}, 
							  {0, 0, 0, 0, 0, 0, 0, 0}, 
							  {0, 0, 0, 0, 0, 0, 4, 0},
							  {0, 3, 0, 0, 0, 0, 0, 0},
							  {0, 0, 0, 0, 0, 0, 0, 0}, 
							  {0, 0, 0, 0, 0, 0, 0, 2}, 
							  {0, 0, 0, 0, 0, 0, 0, 0}};
	
	int[][] emptyBoard = {{0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}, 
						  {0, 0, 0, 0, 0, 0, 0, 0}};

	@Test
	public void isEmptyTest1() {
		assertTrue(JunitTester.isEmptyTest(capBoardRedFlip, 1, 2) == true);
	}
	
	@Test
	public void isEmptyTest2() {
		assert(JunitTester.isEmptyTest(capBoardRedFlip, 1, 0) == false);
	}
	
	@Test
	public void isEmptyTest3() {
		assert(JunitTester.isEmptyTest(capBoardRedFlip, -1, 0) == false);
	}
	
	@Test
	public void isMoveLegalTest1() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 0, 1, -1, 0, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest2() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 7, 3, 6, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest3() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 3, 0, 2, 1, 1) == 2);
	}
	
	@Test
	public void isMoveLegalTest4() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 5, 5, 4, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest5() {
		assert(JunitTester.isMoveLegalTest(noCapBoardFlip, 1, 0, 2, 1, 1) == 1);
	}
	
	@Test
	public void isMoveLegalTest6() {
		assert(JunitTester.isMoveLegalTest(noCapBoardFlip, 6, 7, 5, 6, 2) == 1);
	}
	
	@Test
	public void isMoveLegalTest7() {
		assert(JunitTester.isMoveLegalTest(noCapBoardFlip, 4, 1, 3, 0, 1) == 1);
	}
	
	@Test
	public void isMoveLegalTest8() {
		assert(JunitTester.isMoveLegalTest(noCapBoardFlip, 1, 0, 2, 2, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest9() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 4, 3, 1) == 2);
	}
	
	@Test
	public void isMoveLegalTest10() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 3, 6, 5, 4, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest11() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 5, 0, 3, 3, 1) == 2);
	}
	
	@Test
	public void isMoveLegalTest12() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 5, 2, 4, 2) == 2);
	}
	
	@Test
	public void isMoveLegalTest13() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 0, 4, 1) == 2);
	}
	
	@Test
	public void isMoveLegalTest14() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 0, 3, 1) == 3);
	}
	
	@Test
	public void isMoveLegalTest15() {
		assert(JunitTester.isMoveLegalTest(capBoardRedFlip, 1, 0, 1, 1, 1) == 2);
	}
}
