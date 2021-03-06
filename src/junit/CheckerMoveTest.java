/*
 * 
 */
package junit;

import static org.junit.Assert.*;
import org.junit.Test;
import checkers.CheckerMove;
import checkers.Checkers;

// TODO: Auto-generated Javadoc
/**
 * Unit Tests #6, 10, and 14 in Software Test Plan Checks getIndex, testColour, and ApplyMove
 * methods behave correctly.
 * 
 * @author Cristi DeLeo  
 * @author Steven Bennette
 * @version 3.0
 * @since 25 April 2017
 */
public class CheckerMoveTest {
  
  /** The Junit tester. */
  checkers.JunitTester JunitTester = new checkers.JunitTester();

  /**
   * Test get index.
   */
  @Test
  public void testGetIndex() {
    // Test 1: x = -1, y = 50, result = {0, 0}
    int actualX1 = -1;
    int actualY1 = 50;
    int[] expectedIndex1 = { 0, 0 };

    // Test 2: x = 349, y = 225, result = {6, 4}
    int actualX2 = 349;
    int actualY2 = 225;
    int[] expectedIndex2 = { 6, 4 };

    // Test 3: x = 350, y = 401, result = {0, 0}
    int actualX3 = 350;
    int actualY3 = 401;
    int[] expectedIndex3 = { 0, 0 };

    assertArrayEquals("Index value: -1, 50", expectedIndex1,
        JunitTester.getIndex(actualX1, actualY1));
    assertArrayEquals("Index value: 349, 225", expectedIndex2,
        JunitTester.getIndex(actualX2, actualY2));
    assertArrayEquals("Index value: 350, 401", expectedIndex3,
        JunitTester.getIndex(actualX3, actualY3));
  }

  /**
   * Test colour.
   */
  @Test
  public void testColour() {
    // Test 1 Parameters: Empty square returns 0
    int expected0 = 0;
    int actual0 = JunitTester.colour(JunitTester.getEmpty());

    // Tests 2 & 4 Parameters: Square occupied by a red normal or red king piece
    int expected1 = 1;
    int actual1 = JunitTester.colour(JunitTester.getRedNormal());
    int actual3 = JunitTester.colour(JunitTester.getRedking());

    // Tests 3 & 5 Parameters: Square occupied by a yellow normal or yellow king piece
    int expected2 = 2;
    int actual2 = JunitTester.colour(JunitTester.getYellowNormal());
    int actual4 = JunitTester.colour(JunitTester.getYellowking());

    assertEquals("Case: empty (0), Result: 0", expected0, actual0);
    assertEquals("Case: redNormal (1), Result: 1", expected1, actual1);
    assertEquals("Case: yellowNormal (2), Result: 2", expected2, actual2);
    assertEquals("Case: redKing (3), Result: 1", expected1, actual3);
    assertEquals("Case: yellowKing (4), Result: 2", expected2, actual4);
  }

  /**
   * Test apply move.
   */
  @Test
  public void testApplyMove() {
    int[][] capBoardRed1 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 3, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 3, 0, 0, 0, 1, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 3, 0, 3 }, { 1, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 1 } };

    // Move to an out-of-bounds i value
    int startX1 = 6; // Start row
    int startY1 = 0; // Start column
    int endX1 = 8; // End row
    int endY1 = 2; // End column
    int expected1 = 2; // Illegal move
    int actual1 = JunitTester.ApplyMove(capBoardRed1, startX1, startY1, endX1, endY1);

    int[][] capBoardRed2 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 3, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 3, 0, 0, 0, 1, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 3, 0, 3 }, { 1, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 1 } };

    // Red King captures a normal yellow piece, with one more capture available after
    int startX2 = 4; // Start row
    int startY2 = 0; // Start column
    int endX2 = 2; // End row
    int endY2 = 2; // End column
    int expected2 = 3; // Incomplete move (player can jump one more piece located at 1, 6)
    int actual2 = JunitTester.ApplyMove(capBoardRed2, startX2, startY2, endX2, endY2);

    int[][] capBoardRed3 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 3, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 3, 0, 0, 0, 1, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 3, 0, 3 }, { 1, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 1 } };

    // Normal red piece captures a normal yellow piece without any further captures available
    int startX3 = 4; // Start row
    int startY3 = 4; // Start column
    int endX3 = 2; // End row
    int endY3 = 6; // End column
    int expected3 = 1; // Legal move
    int actual3 = JunitTester.ApplyMove(capBoardRed3, startX3, startY3, endX3, endY3);

    int[][] capBoardRed4 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 3, 0, 0 },
        { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 3, 0, 0, 0, 1, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 3, 0, 3 }, { 1, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 1 } };

    // Normal red piece attempts to move to a legal square, however there are other possible
    // moves that result in a capture, thus the move is deemed illegal
    int startX4 = 6; // Start row
    int startY4 = 0; // Start column
    int endX4 = 5; // End row
    int endY4 = 1; // End column
    int expected4 = 2; // Illegal move
    int actual4 = JunitTester.ApplyMove(capBoardRed4, startX4, startY4, endX4, endY4);

    int[][] capBoardRed5 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 0, 0, 0, 0, 0, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 } };

    // Normal red piece moves one space to a legal square (no available captures for any red piece)
    int startX5 = 6; // Start row
    int startY5 = 0; // Start column
    int endX5 = 5; // End row
    int endY5 = 1; // End column
    int expected5 = 1; // Legal move
    int actual5 = JunitTester.ApplyMove(capBoardRed5, startX5, startY5, endX5, endY5);

    int[][] boardKingRed6 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 1, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 }, { 0, 0, 0, 0, 0, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 } };

    // "King" a normal red piece
    int startX6 = 2; // Start row
    int startY6 = 6; // Start column
    int endX6 = 1; // End row
    int endY6 = 7; // End column
    int expected6 = 1; // Legal move
    int actual6 = JunitTester.ApplyMove(boardKingRed6, startX6, startY6, endX6, endY6);

    int[][] boardKingYellow7 = { { 0, 0, 2, 0, 2, 0, 2, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 1, 0, 2, 0, 2 }, { 0, 0, 0, 0, 0, 0, 2, 0 },
        { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 2, 0, 4, 0 }, { 0, 2, 0, 0, 0, 0, 0, 0 } };

    // "King" a normal yellow piece
    int startX7 = 3; // Start row
    int startY7 = 1; // Start column
    int endX7 = 2; // End row
    int endY7 = 0; // End column
    int expected7 = 1; // Legal move
    int actual7 = JunitTester.ApplyMove(boardKingYellow7, startX7, startY7, endX7, endY7);

    assertEquals(expected1, actual1);
    assertEquals(expected2, actual2);
    assertEquals(expected3, actual3);
    assertEquals(expected4, actual4);
    assertEquals(expected5, actual5);
    assertEquals(expected6, actual6);
    assertEquals(expected7, actual7);
  }

  
  // Merge Conflict Steven Bennette
  // checker Move Test Cases
  //
  //
  //
  //
  //

  /** The cap board red. */
  int[][] capBoardRed = { { 0, 1, 0, 3, 0, 1, 0, 0 }, { 2, 0, 0, 0, 2, 0, 2, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 1, 0, 0, 0, 2 },
      { 0, 0, 3, 0, 2, 0, 3, 0 }, { 0, 4, 0, 2, 0, 0, 0, 2 }, { 1, 0, 3, 0, 2, 0, 0, 0 } };

  /** The cap board yellow. */
  int[][] capBoardYellow = { { 0, 0, 0, 0, 0, 0, 0, 2 }, { 1, 0, 0, 0, 0, 0, 3, 0 },
      { 0, 4, 0, 0, 0, 4, 0, 0 }, { 1, 0, 0, 0, 1, 0, 2, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 1, 0, 2, 0, 0, 0 }, { 0, 0, 0, 2, 0, 1, 0, 1 }, { 0, 0, 0, 0, 4, 0, 2, 0 } };

  /** The cap board red flip. */
  int[][] capBoardRedFlip = { { 0, 2, 0, 0, 0, 0, 0, 1 }, { 1, 0, 0, 0, 2, 0, 4, 0 },
      { 0, 0, 0, 0, 0, 3, 0, 3 }, { 3, 0, 0, 0, 1, 0, 2, 0 }, { 0, 2, 0, 0, 0, 2, 0, 2 },
      { 1, 0, 0, 0, 0, 0, 0, 0 }, { 0, 2, 0, 0, 0, 3, 0, 0 }, { 0, 0, 2, 0, 2, 0, 2, 0 } };

  /** The no cap board flip. */
  int[][] noCapBoardFlip = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 4, 0 }, { 0, 3, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 2 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

  /** The empty board. */
  int[][] emptyBoard = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };

  /**
   * Checks if is empty test 1.
   */
  @Test
  public void isEmptyTest1() {
    assertTrue(JunitTester.isEmptyTest(capBoardRedFlip, 1, 2) == true);
  }

  /**
   * Checks if is empty test 2.
   */
  @Test
  public void isEmptyTest2() {
    assert (JunitTester.isEmptyTest(capBoardRedFlip, 1, 0) == false);
  }

  /**
   * Checks if is empty test 3.
   */
  @Test
  public void isEmptyTest3() {
    assert (JunitTester.isEmptyTest(capBoardRedFlip, -1, 0) == false);
  }

  /**
   * Checks if is move legal test 1.
   */
  @Test
  public void isMoveLegalTest1() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 0, 1, -1, 0, 2) == 2);
  }

  /**
   * Checks if is move legal test 2.
   */
  @Test
  public void isMoveLegalTest2() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 7, 3, 6, 2) == 2);
  }

  /**
   * Checks if is move legal test 3.
   */
  @Test
  public void isMoveLegalTest3() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 3, 0, 2, 1, 1) == 2);
  }

  /**
   * Checks if is move legal test 4.
   */
  @Test
  public void isMoveLegalTest4() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 5, 5, 4, 2) == 2);
  }

  /**
   * Checks if is move legal test 5.
   */
  @Test
  public void isMoveLegalTest5() {
    assert (JunitTester.isMoveLegalTest(noCapBoardFlip, 1, 0, 2, 1, 1) == 1);
  }

  /**
   * Checks if is move legal test 6.
   */
  @Test
  public void isMoveLegalTest6() {
    assert (JunitTester.isMoveLegalTest(noCapBoardFlip, 6, 7, 5, 6, 2) == 1);
  }

  /**
   * Checks if is move legal test 7.
   */
  @Test
  public void isMoveLegalTest7() {
    assert (JunitTester.isMoveLegalTest(noCapBoardFlip, 4, 1, 3, 0, 1) == 1);
  }

  /**
   * Checks if is move legal test 8.
   */
  @Test
  public void isMoveLegalTest8() {
    assert (JunitTester.isMoveLegalTest(noCapBoardFlip, 1, 0, 2, 2, 2) == 2);
  }

  /**
   * Checks if is move legal test 9.
   */
  @Test
  public void isMoveLegalTest9() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 4, 3, 1) == 2);
  }

  /**
   * Checks if is move legal test 10.
   */
  @Test
  public void isMoveLegalTest10() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 3, 6, 5, 4, 2) == 2);
  }

  /**
   * Checks if is move legal test 11.
   */
  @Test
  public void isMoveLegalTest11() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 5, 0, 3, 3, 1) == 2);
  }

  /**
   * Checks if is move legal test 12.
   */
  @Test
  public void isMoveLegalTest12() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 4, 5, 2, 4, 2) == 2);
  }

  /**
   * Checks if is move legal test 13.
   */
  @Test
  public void isMoveLegalTest13() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 0, 4, 1) == 2);
  }

  /**
   * Checks if is move legal test 14.
   */
  @Test
  public void isMoveLegalTest14() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 2, 5, 0, 3, 1) == 3);
  }

  /**
   * Checks if is move legal test 15.
   */
  @Test
  public void isMoveLegalTest15() {
    assert (JunitTester.isMoveLegalTest(capBoardRedFlip, 1, 0, 1, 1, 1) == 2);
  }

}
