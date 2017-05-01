package junit;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import checkers.GameWin;
import checkers.JunitTester;

//Run constructor of GameWin class. 
public class UnitTest4 {
	Point p1 = new Point(25,25);
	GameWin gameWin;
	JunitTester test = new JunitTester();
	
	@Test
	public void test1GameWinContructor() {
		System.out.println("Test1 GameWin");
		gameWin =  test.getGamewin();
		assertTrue("New Game Win", !gameWin.equals(null));
		
		System.out.println("Test2 GameWin");
		gameWin = test.newGameWin("Test 2");
		assertTrue("New Game Win", !gameWin.equals(null));
		
	}
	
}
