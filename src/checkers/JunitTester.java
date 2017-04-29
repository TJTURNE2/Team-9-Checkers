package checkers;

import java.util.concurrent.TimeUnit;

public class JunitTester {
	public static void CFrameTest() {
		CheckerFrame testCFrame = new CheckerFrame();
    	while(testCFrame.isVisible()) {
    		try {
    			TimeUnit.SECONDS.sleep(60);
    		} catch (InterruptedException e) {
    		}
    	}
    	testCFrame = null;
	}
	
	public static boolean isPossibleSquareTest(int i, int j) {
		Checkers testCheckers = new Checkers();
		boolean value = testCheckers.getIsPossibleSquare(i, j);
		testCheckers = null;
		return value;
	}
	
	public static boolean isEmptyTest(int[][] board, int i, int j) {
		return CheckerMove.getIsEmpty(board, i, j);
	}
	
	public static int isMoveLegalTest(int[][] board, int srtI, int srtJ, int endI, int endJ, int turn) {
		return CheckerMove.isMoveLegal(board, srtI, srtJ, endI, endJ, turn);
	}
	
	public static int ApplyMoveTest(int[][] board,int srtI,int srtJ,int endI,int endJ) {
    	return CheckerMove.ApplyMove(board, srtI, srtJ, endI, endJ);
    }
	
	public static int getOpponentTest(int turn) {
		return GameEngine.getOpponent(turn);
	}
}
