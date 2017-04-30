package checkers;


public class JUnitTester {
	
	
	
	public static boolean canCaptureTest(int[][] board, int i, int j) {
		return CheckerMove.canCapture(board, i, j);
	}
	
	public static boolean inRangeTest(int i, int j) {
		return CheckerMove.getInRange(i, j);
	}
	
	public static int isWalkLegalTest(int[][] board,int srtI,int srtJ,int endI,int endJ) {
    	return CheckerMove.isWalkLegal(board, srtI, srtJ, endI, endJ);
    }
	
	public static int evalTest(int [][] board) {
		return GameEngine.eval(board);
	}
}