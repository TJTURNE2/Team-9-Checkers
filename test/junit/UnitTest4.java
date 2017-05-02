/*
 * 
 */
package junit;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import checkers.GameWin;
import checkers.JunitTester;

// TODO: Auto-generated Javadoc
/**
 * The Class UnitTest4.
 */
//Run constructor of GameWin class. 
public class UnitTest4 {
	
	/** The p 1. */
	Point p1 = new Point(25,25);
	
	/** The game win. */
	GameWin gameWin;
	
	/** The test. */
	JunitTester test = new JunitTester();
	
	/**
	 * Test 1 game win contructor.
	 */
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
