package checkers;
import java.awt.Point;
import checkers.GameWin;
//class that Exposes Variables and methods for testing
public class JunitTester {
	
	Point p1;
	public GameWin gameWin;
	public boolean canWalk;
	public boolean noMoves;
	public int getTurn;
	
	public JunitTester(){
		p1 = new Point(25, 25);
		gameWin = new GameWin("Test GameWin", p1);
	}
	
	public GameWin newGameWin(String str){
		return new GameWin(str, p1);
	}
	
	public GameWin getGamewin() {
		return gameWin;
	}
	
//	public void setGamewin(String str, Point pt) {
//		this.gameWin.p = pt;
//		this.gameWin.masseage.setText(str);
//	}
	public boolean isCanWalk(int[][]board, int i ,int j) {
		return CheckerMove.canWalk(board, i, j);
	}
	
	public boolean hasNoMoves(int[][] board, int i) {
		return CheckerMove.noMovesLeft(board, i);
	}

	public int getGetTurn(int turn) {
		return GameEngine.getTurn(turn);
	}
	public int getInf(){
		return GameEngine.inf;
	}


	
}
