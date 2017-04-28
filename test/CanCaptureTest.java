package test;

import org.junit.Test;
import checkers.JUnitTester;
import static org.junit.Assert.*;

public class CanCaptureTest {
		
		int[][] capBoardRed = {
				   {0, 0, 2, 0, 0, 4, 0, 2}, 
				   {0, 2, 0, 0, 4, 0, 1, 0}, 
				   {1, 0, 0, 1, 0, 0, 0, 2}, 
				   {0, 2, 0, 0, 4, 0, 0, 0}, 
				   {0, 2, 0, 1, 0, 0, 0, 0}, 
				   {1, 0, 1, 0, 0, 0, 0, 2}, 
				   {0, 2, 0, 4, 1, 0, 1, 0}, 
				   {0, 0, 2, 0, 2, 4, 0, 2}};
		
		int[][] capBoardYellow = {
				   {1, 0, 3, 0, 0, 1, 0, 0}, 
				   {0, 2, 0, 3, 0, 0, 1, 0}, 
				   {1, 0, 0, 0, 2, 0, 0, 2}, 
				   {0, 0, 0, 3, 0, 0, 1, 0}, 
				   {0, 0, 0, 0, 2, 0, 1, 0}, 
				   {1, 0, 0, 0, 0, 2, 0, 2}, 
				   {0, 2, 0, 2, 3, 0, 1, 0}, 
				   {1, 0, 3, 1, 0, 1, 0, 0}};
		
		int[][] redKingBoard = {
				   {0, 0, 2, 0, 0, 2, 0, 2}, 
				   {0, 2, 0, 0, 0, 2, 3, 0}, 
				   {3, 0, 0, 0, 0, 0, 2, 2}, 
				   {0, 2, 0, 0, 0, 0, 0, 3}, 
				   {3, 0, 0, 0, 0, 0, 2, 0}, 
				   {2, 2, 0, 0, 0, 0, 0, 3}, 
				   {0, 3, 2, 0, 0, 0, 2, 0}, 
				   {2, 0, 2, 0, 0, 2, 0, 0}};
		
		int[][] redKingvsKingBoard = {
				   {0, 0, 4, 0, 0, 4, 0, 4}, 
				   {0, 4, 0, 0, 0, 4, 3, 0}, 
				   {3, 0, 0, 0, 0, 0, 4, 4}, 
				   {0, 4, 0, 0, 0, 0, 0, 3}, 
				   {3, 0, 0, 0, 0, 0, 4, 0}, 
				   {4, 4, 0, 0, 0, 0, 0, 3}, 
				   {0, 3, 4, 0, 0, 0, 4, 0}, 
				   {4, 0, 4, 0, 0, 4, 0, 0}};
		
		int[][] yellowKingBoard = {
				   {0, 0, 1, 0, 0, 1, 0, 1}, 
				   {0, 1, 0, 0, 0, 1, 4, 0}, 
				   {4, 0, 0, 0, 0, 0, 1, 1}, 
				   {0, 1, 0, 0, 0, 0, 0, 4}, 
				   {4, 0, 0, 0, 0, 0, 1, 0}, 
				   {1, 1, 0, 0, 0, 0, 0, 4}, 
				   {0, 4, 1, 0, 0, 0, 1, 0}, 
				   {1, 0, 1, 0, 0, 1, 0, 0}};
		
		int[][] yellowKingvsKingBoard = {
				   {0, 0, 3, 0, 0, 3, 0, 3}, 
				   {0, 3, 0, 0, 0, 3, 4, 0}, 
				   {4, 0, 0, 0, 0, 0, 3, 3}, 
				   {0, 3, 0, 0, 0, 0, 0, 4}, 
				   {4, 0, 0, 0, 0, 0, 3, 0}, 
				   {3, 3, 0, 0, 0, 0, 0, 4}, 
				   {0, 4, 3, 0, 0, 0, 3, 0}, 
				   {3, 0, 3, 0, 0, 3, 0, 0}};

	//normal red  op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest1() {
		assertFalse(JUnitTester.canCaptureTest(capBoardRed, 1, 6));
	}
	
	//normal red  op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest2() {
		assertFalse(JUnitTester.canCaptureTest(capBoardRed, 6, 6));
	}
	
	//normal red  op1 = capture normal blocked (up move)  op2 = capture normal yellow (down move)	
	@Test
	public void capTest3() {
		assertTrue(JUnitTester.canCaptureTest(capBoardRed, 2, 0));
	}
	
	//normal red  op1 = cap yellow normal(up move)  op2 = capture normal blocked (down move)
	@Test
	public void capTest4() {
		assertTrue(JUnitTester.canCaptureTest(capBoardRed, 5, 0));
	}
	
	//normal red  op1 = cap yellow king(up move)  op2 = none
	@Test
	public void capTest5() {
		assertTrue(JUnitTester.canCaptureTest(capBoardRed, 4, 3));
	}
	
	//normal red  op1 = cap yellow king(down move)  op2 = capture king blocked (up move)
	@Test
	public void capTest6() {
		assertTrue(JUnitTester.canCaptureTest(capBoardRed, 2, 3));
	}
	
	//normal red  op1 = capture out of bounds (king)  op2 = none
	@Test
	public void capTest7() {
		assertFalse(JUnitTester.canCaptureTest(capBoardRed, 6, 4));
	}
	
	//normal red  op1 = capture king blocked (down move)  op2 = none
	@Test
	public void capTest8() {
		assertFalse(JUnitTester.canCaptureTest(capBoardRed, 5, 2));
	}
	
	// normal yellow op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest9() {
		assertFalse(JUnitTester.canCaptureTest(capBoardYellow, 1, 1));
	}
	
	// normal yellow op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest10() {
		assertFalse(JUnitTester.canCaptureTest(capBoardYellow, 6, 1));
	}
	
	//normal yellow op1 = capture normal blocked (up move)  op2 = capture normal red (down move)
	@Test
	public void capTest11() {
		assertTrue(JUnitTester.canCaptureTest(capBoardYellow, 2, 7));
	}
	
	//normal yellow  op1 = cap red normal(up move)  op2 = capture normal blocked (down move)
	@Test
	public void capTest12() {
		assertTrue(JUnitTester.canCaptureTest(capBoardYellow, 5, 7));
	}
	
	//normal yello1  op1 = cap red king(up move)  op2 = none
	@Test
	public void capTest13() {
		assertTrue(JUnitTester.canCaptureTest(capBoardYellow, 2, 4));
	}
	
	//normal red  op1 = cap yellow king(down move)  op2 = capture king blocked (up move)
	@Test
	public void capTest14() {
		assertTrue(JUnitTester.canCaptureTest(capBoardYellow, 4, 4));
	}
	
	//normal red  op1 = capture out of bounds (king)  op2 = none
	@Test
	public void capTest15() {
		assertFalse(JUnitTester.canCaptureTest(capBoardYellow, 5, 5));
	}
	
	//normal red  op1 = capture king blocked (down move)  op2 = none
	@Test
	public void capTest16() {
		assertFalse(JUnitTester.canCaptureTest(capBoardYellow, 5, 2));
	}
	
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest17() {
		assertFalse(JUnitTester.canCaptureTest(redKingBoard, 6, 1));
	}
		
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest18() {
		assertFalse(JUnitTester.canCaptureTest(redKingBoard, 1, 6));
	}
		
	//king red  cap up right
	@Test
	public void capTest19() {
		assertTrue(JUnitTester.canCaptureTest(redKingBoard, 4, 0));
	}
	
	//king red  cap down right
	@Test
	public void capTest20() {
		assertTrue(JUnitTester.canCaptureTest(redKingBoard, 2, 0));
	}
	
	//king red  cap up left
	@Test
	public void capTest21() {
		assertTrue(JUnitTester.canCaptureTest(redKingBoard, 5, 7));
	}
	
	//king red  cap down left
	@Test
	public void capTest22() {
		assertTrue(JUnitTester.canCaptureTest(redKingBoard, 3, 7));
	}
	
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest23() {
		assertFalse(JUnitTester.canCaptureTest(redKingvsKingBoard, 6, 1));
	}
		
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest24() {
		assertFalse(JUnitTester.canCaptureTest(redKingvsKingBoard, 1, 6));
	}
		
	//king red  cap up right
	@Test
	public void capTest25() {
		assertTrue(JUnitTester.canCaptureTest(redKingvsKingBoard, 4, 0));
	}
	
	//king red  cap down right
	@Test
	public void capTest26() {
		assertTrue(JUnitTester.canCaptureTest(redKingvsKingBoard, 2, 0));
	}
	
	//king red  cap up left
	@Test
	public void capTest27() {
		assertTrue(JUnitTester.canCaptureTest(redKingvsKingBoard, 5, 7));
	}
	
	//king red  cap down left
	@Test
	public void capTest28() {
		assertTrue(JUnitTester.canCaptureTest(redKingvsKingBoard, 3, 7));
	}
	
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest29() {
		assertFalse(JUnitTester.canCaptureTest(yellowKingBoard, 6, 1));
	}
			
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest30() {
		assertFalse(JUnitTester.canCaptureTest(yellowKingBoard, 1, 6));
	}
			
	//king yellow  cap up right
	@Test
	public void capTest31() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingBoard, 4, 0));
	}
		
	//king yellow  cap down right
	@Test
	public void capTest32() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingBoard, 2, 0));
	}
		
	//king yellow  cap up left
	@Test
	public void capTest33() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingBoard, 5, 7));
	}
		
	//king yellow  cap down left
	@Test
	public void capTest34() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingBoard, 3, 7));
	}
		
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest35() {
		assertFalse(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 6, 1));
	}
			
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest36() {
		assertFalse(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 1, 6));
	}
			
	//king yellow  cap up right
	@Test
	public void capTest37() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 4, 0));
	}
		
	//king yellow  cap down right
	@Test
	public void capTest38() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 2, 0));
	}
		
	//king yellow  cap up left
	@Test
	public void capTest39() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 5, 7));
	}
		
	//king yellow  cap down left
	@Test
	public void capTest40() {
		assertTrue(JUnitTester.canCaptureTest(yellowKingvsKingBoard, 3, 7));
	}
}
