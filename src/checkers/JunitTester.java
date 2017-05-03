package checkers;

import java.awt.Point;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

// TODO: Auto-generated Javadoc
/**
 * The Class JunitTester.
 */
// class that Exposes Variables and methods for testing
public class JunitTester {

  /** The p 1. */
  Point p1 = new Point(25, 25);

  /** The start test. */
  public StartPanel startTest;

  /** The i checkers. */
  public IntelliChecker iCheckers;

  /** The c frame. */
  public CheckerFrame cFrame;

  /** The checkers. */
  public Checkers checkers;

  /** The game win. */
  public GameWin gameWin;

  /** The can walk. */
  public boolean canWalk;

  /** The no moves. */
  public boolean noMoves;

  /** The get turn. */
  public int getTurn;

  /** The help. */
  public Help help;

  /** The test C frame. */
  CheckerFrame testCFrame;

  /**
   * Instantiates a new junit tester.
   */
  public JunitTester() {
    // p1 = new Point(25, 25);
    // gameWin = new GameWin("Test GameWin", p1);
    // iCheckers = new IntelliChecker();
    // checkers = new Checkers();
  }

  /**
   * New game win.
   *
   * @param str
   *          the str
   * @return the game win
   */
  public GameWin newGameWin(String str) {
    return gameWin = new GameWin(str, p1);
  }

  /**
   * Gets the gamewin.
   *
   * @return the gamewin
   */
  public GameWin getGamewin() {
    gameWin = new GameWin("Test GameWin", p1);
    return gameWin;
  }

  /**
   * Gets the checker frame.
   *
   * @return the checker frame
   */
  public CheckerFrame getCheckerFrame() {
      return cFrame = new CheckerFrame();
  }

  /**
   * Play checker frame.
   */
  public CheckerFrame playCheckerFrame() {
    return cFrame;
  }

  /**
   * Checks if is move legal.
   *
   * @param board
   *          the board
   * @param srtI
   *          the srt I
   * @param srtJ
   *          the srt J
   * @param endI
   *          the end I
   * @param endJ
   *          the end J
   * @param turn
   *          the turn
   * @return the int
   */
  public int isMoveLegal(int[][] board, int srtI, int srtJ, int endI, int endJ, int turn) {
    return CheckerMove.isMoveLegal(board, srtI, srtJ, endI, endJ, turn);
  }

  /**
   * Checks if is can walk.
   *
   * @param board
   *          the board
   * @param i
   *          the i
   * @param j
   *          the j
   * @return true, if is can walk
   */
  public boolean isCanWalk(int[][] board, int i, int j) {
    return CheckerMove.canWalk(board, i, j);
  }

  /**
   * Checks for no moves.
   *
   * @param board
   *          the board
   * @param i
   *          the i
   * @return true, if successful
   */
  public boolean hasNoMoves(int[][] board, int i) {
    return CheckerMove.noMovesLeft(board, i);
  }

  /**
   * Gets the gets the turn.
   *
   * @param turn
   *          the turn
   * @return the gets the turn
   */
  public int getGetTurn(int turn) {
    return GameEngine.getTurn(turn);
  }

  /**
   * Gets the inf.
   *
   * @return the inf
   */
  public int getInf() {
    return GameEngine.inf;
  }

  /**
   * Gets the i checkers.
   *
   * @return the i checkers
   */
  public IntelliChecker getiCheckers() {
    return iCheckers = new IntelliChecker();
  }

  /**
   * Gets the checkers.
   *
   * @return the checkers
   */
  public Checkers getCheckers() {
    checkers = new Checkers();
    checkers.toMove = checkers.redNormal;
    return checkers;
  }

  /**
   * Gets the redking.
   *
   * @return the redking
   */
  public int getRedking() {
    return Checkers.redKing;
  }

  /**
   * Gets the yellowking.
   *
   * @return the yellowking
   */
  public int getYellowking() {
    return Checkers.yellowKing;
  }

  /**
   * Gets the red normal.
   *
   * @return the red normal
   */
  public int getRedNormal() {
    return Checkers.redNormal;
  }

  /**
   * Gets the yellow normal.
   *
   * @return the yellow normal
   */
  public int getYellowNormal() {
    return Checkers.yellowNormal;
  }

  /**
   * Gets the empty.
   *
   * @return the empty
   */
  public int getEmpty() {
    return Checkers.empty;
  }

  /**
   * Gets the start test.
   *
   * @return the start test
   */
  public StartPanel getStartTest() {
    return startTest = new StartPanel();
  }

  /**
   * Run checkers.
   */
  public void runCheckers() {
    CFrameTest();
  }

  /**
   * C frame test.
   */
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

  /**
   * Apply move.
   *
   * @param capBoardRed1
   *          the cap board red 1
   * @param startX1
   *          the start X 1
   * @param startY1
   *          the start Y 1
   * @param endX1
   *          the end X 1
   * @param endY1
   *          the end Y 1
   * @return the int
   */
  public int ApplyMove(int[][] capBoardRed1, int startX1, int startY1, int endX1, int endY1) {
    return CheckerMove.ApplyMove(capBoardRed1, startX1, startY1, endX1, endY1);
  }

  /**
   * Checks if is move legal test.
   *
   * @param board
   *          the board
   * @param i
   *          the i
   * @param j
   *          the j
   * @param k
   *          the k
   * @param l
   *          the l
   * @param turn
   *          the turn
   * @return the int
   */
  public int isMoveLegalTest(int[][] board, int i, int j, int k, int l, int turn) {
    return CheckerMove.isMoveLegal(board, i, j, k, l, turn);
  }

  /**
   * Checks if is possible square test.
   *
   * @param i
   *          the i
   * @param j
   *          the j
   * @return true, if is possible square test
   */
  public static boolean isPossibleSquareTest(int i, int j) {
    Checkers testCheckers = new Checkers();
    boolean value = testCheckers.getIsPossibleSquare(i, j);
    testCheckers = null;
    return value;
  }

  /**
   * Gets the opponent test.
   *
   * @param turn
   *          the turn
   * @return the opponent test
   */
  public int getOpponentTest(int turn) {
    return GameEngine.getOpponent(turn);
  }

  /**
   * Checks if is empty test.
   *
   * @param capBoardRedFlip
   *          the cap board red flip
   * @param i
   *          the i
   * @param j
   *          the j
   * @return true, if is empty test
   */
  public boolean isEmptyTest(int[][] capBoardRedFlip, int i, int j) {
    return CheckerMove.getIsEmpty(capBoardRedFlip, i, j);
  }

  /**
   * Can capture test.
   *
   * @param capBoardRed
   *          the cap board red
   * @param i
   *          the i
   * @param j
   *          the j
   * @return true, if successful
   */
  public boolean canCaptureTest(int[][] capBoardRed, int i, int j) {
    return CheckerMove.canCapture(capBoardRed, i, j);
  }

  /**
   * Eval test.
   *
   * @param capBoardRed
   *          the cap board red
   * @return the int
   */
  public int evalTest(int[][] capBoardRed) {
    return GameEngine.eval(capBoardRed);
  }

  /**
   * Checks if is walk legal test.
   *
   * @param capBoardRed
   *          the cap board red
   * @param i
   *          the i
   * @param j
   *          the j
   * @param k
   *          the k
   * @param l
   *          the l
   * @return the int
   */
  public int isWalkLegalTest(int[][] capBoardRed, int i, int j, int k, int l) {
    return CheckerMove.isWalkLegal(capBoardRed, i, j, k, l);
  }

  /**
   * In range test.
   *
   * @param i
   *          the i
   * @param j
   *          the j
   * @return true, if successful
   */
  public boolean inRangeTest(int i, int j) {
    return CheckerMove.getInRange(i, j);
  }

  /**
   * Colour.
   *
   * @param piece
   *          the piece
   * @return the int
   */
  public int colour(int piece) {
    return CheckerMove.colour(piece);
  }

  /**
   * Gets the index.
   *
   * @param actualX1
   *          the actual X 1
   * @param actualY1
   *          the actual Y 1
   * @return the index
   */
  public int[] getIndex(int actualX1, int actualY1) {
    return CheckerMove.getIndex(actualX1, actualY1);
  }

  /**
   * Copy board.
   *
   * @param testBoard1
   *          the test board 1
   * @return the int[][]
   */
  public int[][] copyBoard(int[][] testBoard1) {
    return GameEngine.copyBoard(testBoard1);
  }

  /**
   * New help.
   *
   * @return the help
   */
  public Help newHelp() {
    return help = new Help();
  }

  /**
   * Move computer.
   *
   * @param capBoardRed
   *          the cap board red
   * @param com
   *          the com
   */
  public void moveComputer(int[][] capBoardRed, int[] com) {
    CheckerMove.moveComputer(capBoardRed, com);
  }

  /**
   * Generate moves.
   *
   * @param board
   *          the board
   * @param turn
   *          the turn
   * @return the vector
   */
  public Vector generateMoves(int[][] board, int turn) {
    return CheckerMove.generateMoves(board, turn);
  }

  // public void forceCaptures(int[][] capBoardRed, int[] com) {
  // CheckerMove.forceCapture();
  // }
}
