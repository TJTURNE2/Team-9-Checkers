/*
 * 
 */
package junit;

import static org.junit.Assert.assertNotNull;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import org.junit.Test;

import checkers.CheckerFrame;
import checkers.Checkers;
import checkers.IntelliChecker;
import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTest21.
 */
public class UnitTest21 {

  /** The Junit tester. */
  JunitTester JunitTester;
  
  /** The cframe. */
  CheckerFrame cframe;
  
  /** The checkers. */
  Checkers checkers;
  
  /** The me. */
  MouseEvent me;

  /**
   * Test.
   */
  @Test
  public void test() {
    IntelliChecker Checker = new IntelliChecker();
    JunitTester = new JunitTester();
    try {
      String[] stuff = { "null", "null" };
      Checker.main(stuff);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      // e.printStackTrace();
    }
    checkers = JunitTester.getCheckers();
    checkers.drawCheckers();
    // checkers.();
    cframe = new JunitTester().getCheckerFrame();
    JunitTester.getCheckerFrame().setVisible(true);
    // JunitTester.CFrameTest(); //assertNotNull(this.JunitTester.runCheckers());
  }

  
  /**
   * Mouse test.
   */
  @Test
  public void mouseTest() {
    JunitTester = new JunitTester();
    checkers = JunitTester.getCheckers();
    me = new MouseEvent(checkers, 0, 0, 0, 100, 100, 1, false);
    checkers.mouseDragged(me);
    checkers.mouseClicked(me);
    checkers.mouseEntered(me);
    checkers.mouseMoved(me);
    checkers.mouseReleased(me);
    checkers.mouseExited(me);
  }

  /**
   * Action performed test.
   */
  @Test
  public void actionPerformedTest() {
    JunitTester = new JunitTester();
    checkers = JunitTester.getCheckers();
    me = new MouseEvent(checkers, 0, 0, 0, 100, 100, 1, false);
    checkers.mousePressed(me);
    ActionEvent evt = new ActionEvent(checkers, 1, "1-Player");
    checkers.actionPerformed(evt);
    evt = new ActionEvent(checkers, 1, "2-Player");
    checkers.actionPerformed(evt);
    // evt = new ActionEvent(checkers, 2, "New Game");
    // checkers.actionPerformed(evt);
    evt = new ActionEvent(checkers, 1, "yellow");
    checkers.actionPerformed(evt);
    evt = new ActionEvent(checkers, 1, "undo");
    checkers.actionPerformed(evt);
//    evt = new ActionEvent(checkers, 1, "Forfeit");
//    checkers.actionPerformed(evt);
    evt = new ActionEvent(checkers, 1, "red");
    checkers.actionPerformed(evt);

  }

  /**
   * Move computer test.
   */
  @Test
  public void moveComputerTest() {
    JunitTester = new JunitTester();
    int[] com = { 0, 0, 2, 2 };
    int[][] capBoardRed = {
        {1, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 2, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}};
    JunitTester.moveComputer(capBoardRed, com);
  }
  
  /**
   * Generate moves test.
   */
  @Test
  public void generateMovesTest() {
    JunitTester = new JunitTester();
    int com = 1;
    int[][] board1 = {
        {1, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 2, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 1, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}};
    int[][] board2 = {
        {1, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 1, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 1, 0, 0, 0, 0, 0}, 
        {0, 1, 0, 1, 0, 0, 0, 0}, 
        {1, 0, 1, 0, 1, 0, 0, 0}, 
        {0, 1, 0, 0, 0, 1, 0, 0}, 
        {0, 0, 1, 0, 0, 0, 0, 0}, 
        {0, 2, 0, 0, 0, 0, 0, 0}};
    int[][] board3 = {
        {1, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 2, 0, 2, 0, 0, 0, 0}, 
        {0, 0, 2, 0, 2, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}, 
        {0, 0, 0, 0, 0, 0, 0, 0}};
    assertNotNull(JunitTester.generateMoves(board1, com));
    assertNotNull(JunitTester.generateMoves(board2, com));
    assertNotNull(JunitTester.generateMoves(board3, com));
  }
 
//  @Test
//  public void forceCaptureTest() {
//    JunitTester = new JunitTester();
//    int[] com = { 0, 0, 2, 2 };
//    int[][] capBoardRed = {
//        {1, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 2, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}, 
//        {0, 0, 0, 0, 0, 0, 0, 0}};
//    JunitTester.forceCaptures(capBoardRed, com);
//  }

}
