package checkers;

import java.awt.Point;
import java.util.concurrent.TimeUnit;

import checkers.GameWin;

//class that Exposes Variables and methods for testing
public class JunitTester {

  Point p1;
  public StartPanel startTest;
  public IntelliChecker iCheckers;
  public CheckerFrame cFrame;
  public Checkers checkers;
  public GameWin gameWin;
  public boolean canWalk;
  public boolean noMoves;
  public int getTurn;
  CheckerFrame testCFrame = new CheckerFrame();

  public JunitTester() {
    p1 = new Point(25, 25);
    gameWin = new GameWin("Test GameWin", p1);
    iCheckers = new IntelliChecker();
    checkers = new Checkers();
  }

  public GameWin newGameWin(String str) {
    return new GameWin(str, p1);
  }

  public GameWin getGamewin() {
    return gameWin;
  }

  public CheckerFrame getCheckerFrame() {
    return cFrame = new CheckerFrame();
  }
public void playCheckerFrame(){
  checkers.play();
  
}
  public int isMoveLegal(int[][] board, int srtI, int srtJ, int endI, int endJ, int turn) {
    return CheckerMove.isMoveLegal(board, srtI, srtJ, endI, endJ, turn);
  }

  public boolean isCanWalk(int[][] board, int i, int j) {
    return CheckerMove.canWalk(board, i, j);
  }

  public boolean hasNoMoves(int[][] board, int i) {
    return CheckerMove.noMovesLeft(board, i);
  }

  public int getGetTurn(int turn) {
    return GameEngine.getTurn(turn);
  }

  public int getInf() {
    return GameEngine.inf;
  }

  public IntelliChecker getiCheckers() {
    return iCheckers;
  }

  public Checkers getCheckers() {
    return checkers;
  }

  public StartPanel getStartTest() {
    return startTest = new StartPanel();
  }

  public void runCheckers() {
    CFrameTest();
  }

  public static void CFrameTest() {
    CheckerFrame testCFrame = new CheckerFrame();
    while (testCFrame.isVisible()) {
      try {
        TimeUnit.SECONDS.sleep(60);
      } catch (InterruptedException e) {
      }
    }
    testCFrame = null;
  }

  public int isMoveLegalTest(int[][] board, int i, int j, int k, int l, int turn) {
    return CheckerMove.isMoveLegal(board, i, j, k, l, turn);
  }

  public static boolean isPossibleSquareTest(int i, int j) {
    Checkers testCheckers = new Checkers();
    boolean value = testCheckers.getIsPossibleSquare(i, j);
    testCheckers = null;
    return value;
  }

  public static int getOpponentTest(int turn) {
    return GameEngine.getOpponent(turn);
  }

  public boolean isEmptyTest(int[][] capBoardRedFlip, int i, int j) {
    return CheckerMove.getIsEmpty(capBoardRedFlip, i, j);
  }

  public boolean canCaptureTest(int[][] capBoardRed, int i, int j) {
    return CheckerMove.canCapture(capBoardRed, i, j);
  }

  public int evalTest(int[][] capBoardRed) {
    return GameEngine.eval(capBoardRed);
  }

  public int isWalkLegalTest(int[][] capBoardRed, int i, int j, int k, int l) {
    return CheckerMove.isWalkLegal(capBoardRed, i, j, k, l);
  }

  public boolean inRangeTest(int i, int j) {
    return CheckerMove.getInRange(i, j);
  }

}
