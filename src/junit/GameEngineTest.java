/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import org.junit.Test;
import checkers.GameEngine;

// TODO: Auto-generated Javadoc
/**
 * Unit Test #18 in Software Test Plan
 * Checks to make sure boards are copied correctly.
 * @author Cristi DeLeo
 * @version 1.0
 * @since 27 April 2017
 */
public class GameEngineTest 
{
  
  /** The Junit tester. */
  checkers.JunitTester JunitTester = new checkers.JunitTester();
  
	/**
	 * Test copy board.
	 */
	@Test
	public void testCopyBoard()
	{
		// Generic in-game board to be copied
		int[][] testBoard1 = {
				{0,	0, 2, 0, 2, 0, 2, 0},
				{0, 2, 0, 0, 0, 3, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 0, 0, 0, 2, 0, 2},
				{3, 0, 0, 0, 1, 0, 2, 0},
				{0, 0, 0, 0, 0, 3, 0, 3},
				{1, 0, 0, 0, 2, 0, 4, 0},
				{0, 2, 0, 0, 0, 0, 0, 1}};
		
		// Expected result
		int[][] expectedBoard1 = {
				{0,	0, 2, 0, 2, 0, 2, 0},
				{0, 2, 0, 0, 0, 3, 0, 0},
				{1, 0, 0, 0, 0, 0, 0, 0},
				{0, 2, 0, 0, 0, 2, 0, 2},
				{3, 0, 0, 0, 1, 0, 2, 0},
				{0, 0, 0, 0, 0, 3, 0, 3},
				{1, 0, 0, 0, 2, 0, 4, 0},
				{0, 2, 0, 0, 0, 0, 0, 1}};
		
		// Actual result
		int[][] actualBoard1 = JunitTester.copyBoard(testBoard1);
		
		assertArrayEquals(expectedBoard1, actualBoard1);
	}

  //Merge Conflict 
  /**
   * Gets the opponent test 1.
   *
   * @return the opponent test 1
   */
  //Steven Bennett-Test Cases
  @Test
  public void getOpponentTest1() {
    assertTrue(JunitTester.getOpponentTest(1) == 2);
  }
  
  /**
   * Gets the opponent test 2.
   *
   * @return the opponent test 2
   */
  @Test
  public void getOpponentTest2() {
    assertTrue(JunitTester.getOpponentTest(2) == 1);
}

}
