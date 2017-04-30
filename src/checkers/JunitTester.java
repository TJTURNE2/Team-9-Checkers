package checkers;

import java.awt.Point;
import checkers.GameWin;

//class that Exposes Variables and methods for testing
public class JunitTester {

	Point p1;
	public StartPanel startTest;
	public IntelliChecker iCheckers;
	public Checkers checkers;
	public GameWin gameWin;
	public boolean canWalk;
	public boolean noMoves;
	public int getTurn;

	public JunitTester() {
		p1 = new Point(25, 25);
		gameWin = new GameWin("Test GameWin", p1);
		iCheckers = new IntelliChecker();
		checkers = new Checkers();
		startTest = new StartPanel();
	}

	public GameWin newGameWin(String str) {
		return new GameWin(str, p1);
	}

	public GameWin getGamewin() {
		return gameWin;
	}

	public int isMoveLegal(int[][] board,int srtI,int srtJ,int endI,int endJ,int turn) {
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
		return startTest;
	}

	public void runCheckers() {
		checkers.newGame();
		checkers.drawCheckers();
		checkers.undo();
		checkers.play();
	}

	public static void CFrameTest() {
		// TODO Auto-generated method stub
		
	}

	public static int isMoveLegalTest(int[][] capBoardRedFlip, int i, int j, int k, int l, int m) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean isPossibleSquareTest(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	public static int getOpponentTest(int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean isEmptyTest(int[][] capBoardRedFlip, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean canCaptureTest(int[][] capBoardRed, int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}

	public int evalTest(int[][] capBoardRed) {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object isWalkLegalTest(int[][] capBoardRed, int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean inRangeTest(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}


}
