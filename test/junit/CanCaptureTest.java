package junit;


import org.junit.Test;
import checkers.JunitTester;
import static org.junit.Assert.*;

public class CanCaptureTest {
		
	JunitTester JunitTester =  new JunitTester();
	
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
		assertFalse(JunitTester.canCaptureTest(capBoardRed, 1, 6));
	}
	
	//normal red  op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest2() {
		assertFalse(JunitTester.canCaptureTest(capBoardRed, 6, 6));
	}
	
	//normal red  op1 = capture normal blocked (up move)  op2 = capture normal yellow (down move)	
	@Test
	public void capTest3() {
		
		assertTrue(JunitTester.canCaptureTest(capBoardRed, 2, 0));
	}
	
	//normal red  op1 = cap yellow normal(up move)  op2 = capture normal blocked (down move)
	@Test
	public void capTest4() {
		assertTrue(JunitTester.canCaptureTest(capBoardRed, 5, 0));
	}
	
	//normal red  op1 = cap yellow king(up move)  op2 = none
	@Test
	public void capTest5() {
		assertTrue(JunitTester.canCaptureTest(capBoardRed, 4, 3));
	}
	
	//normal red  op1 = cap yellow king(down move)  op2 = capture king blocked (up move)
	@Test
	public void capTest6() {
		assertTrue(JunitTester.canCaptureTest(capBoardRed, 2, 3));
	}
	
	//normal red  op1 = capture out of bounds (king)  op2 = none
	@Test
	public void capTest7() {
		assertFalse(JunitTester.canCaptureTest(capBoardRed, 6, 4));
	}
	
	//normal red  op1 = capture king blocked (down move)  op2 = none
	@Test
	public void capTest8() {
		assertFalse(JunitTester.canCaptureTest(capBoardRed, 5, 2));
	}
	
	// normal yellow op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest9() {
		assertFalse(JunitTester.canCaptureTest(capBoardYellow, 1, 1));
	}
	
	// normal yellow op1 = capture out of bounds(y)  op2 = capture out of bounds(x & y)
	@Test
	public void capTest10() {
		assertFalse(JunitTester.canCaptureTest(capBoardYellow, 6, 1));
	}
	
	//normal yellow op1 = capture normal blocked (up move)  op2 = capture normal red (down move)
	@Test
	public void capTest11() {
		assertTrue(JunitTester.canCaptureTest(capBoardYellow, 2, 7));
	}
	
	//normal yellow  op1 = cap red normal(up move)  op2 = capture normal blocked (down move)
	@Test
	public void capTest12() {
		assertTrue(JunitTester.canCaptureTest(capBoardYellow, 5, 7));
	}
	
	//normal yello1  op1 = cap red king(up move)  op2 = none
	@Test
	public void capTest13() {
		assertTrue(JunitTester.canCaptureTest(capBoardYellow, 2, 4));
	}
	
	//normal red  op1 = cap yellow king(down move)  op2 = capture king blocked (up move)
	@Test
	public void capTest14() {
		assertTrue(JunitTester.canCaptureTest(capBoardYellow, 4, 4));
	}
	
	//normal red  op1 = capture out of bounds (king)  op2 = none
	@Test
	public void capTest15() {
		assertFalse(JunitTester.canCaptureTest(capBoardYellow, 5, 5));
	}
	
	//normal red  op1 = capture king blocked (down move)  op2 = none
	@Test
	public void capTest16() {
		assertFalse(JunitTester.canCaptureTest(capBoardYellow, 5, 2));
	}
	
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest17() {
		assertFalse(JunitTester.canCaptureTest(redKingBoard, 6, 1));
	}
		
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest18() {
		assertFalse(JunitTester.canCaptureTest(redKingBoard, 1, 6));
	}
		
	//king red  cap up right
	@Test
	public void capTest19() {
		assertTrue(JunitTester.canCaptureTest(redKingBoard, 4, 0));
	}
	
	//king red  cap down right
	@Test
	public void capTest20() {
		assertTrue(JunitTester.canCaptureTest(redKingBoard, 2, 0));
	}
	
	//king red  cap up left
	@Test
	public void capTest21() {
		assertTrue(JunitTester.canCaptureTest(redKingBoard, 5, 7));
	}
	
	//king red  cap down left
	@Test
	public void capTest22() {
		assertTrue(JunitTester.canCaptureTest(redKingBoard, 3, 7));
	}
	
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest23() {
		assertFalse(JunitTester.canCaptureTest(redKingvsKingBoard, 6, 1));
	}
		
	//king red  cap out of bounds in 3 directions
	@Test
	public void capTest24() {
		assertFalse(JunitTester.canCaptureTest(redKingvsKingBoard, 1, 6));
	}
		
	//king red  cap up right
	@Test
	public void capTest25() {
		assertTrue(JunitTester.canCaptureTest(redKingvsKingBoard, 4, 0));
	}
	
	//king red  cap down right
	@Test
	public void capTest26() {
		assertTrue(JunitTester.canCaptureTest(redKingvsKingBoard, 2, 0));
	}
	
	//king red  cap up left
	@Test
	public void capTest27() {
		assertTrue(JunitTester.canCaptureTest(redKingvsKingBoard, 5, 7));
	}
	
	//king red  cap down left
	@Test
	public void capTest28() {
		assertTrue(JunitTester.canCaptureTest(redKingvsKingBoard, 3, 7));
	}
	
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest29() {
		assertFalse(JunitTester.canCaptureTest(yellowKingBoard, 6, 1));
	}
			
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest30() {
		assertFalse(JunitTester.canCaptureTest(yellowKingBoard, 1, 6));
	}
			
	//king yellow  cap up right
	@Test
	public void capTest31() {
		assertTrue(JunitTester.canCaptureTest(yellowKingBoard, 4, 0));
	}
		
	//king yellow  cap down right
	@Test
	public void capTest32() {
		assertTrue(JunitTester.canCaptureTest(yellowKingBoard, 2, 0));
	}
		
	//king yellow  cap up left
	@Test
	public void capTest33() {
		assertTrue(JunitTester.canCaptureTest(yellowKingBoard, 5, 7));
	}
		
	//king yellow  cap down left
	@Test
	public void capTest34() {
		assertTrue(JunitTester.canCaptureTest(yellowKingBoard, 3, 7));
	}
		
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest35() {
		assertFalse(JunitTester.canCaptureTest(yellowKingvsKingBoard, 6, 1));
	}
			
	//king yellow  cap out of bounds in 3 directions
	@Test
	public void capTest36() {
		assertFalse(JunitTester.canCaptureTest(yellowKingvsKingBoard, 1, 6));
	}
			
	//king yellow  cap up right
	@Test
	public void capTest37() {
		assertTrue(JunitTester.canCaptureTest(yellowKingvsKingBoard, 4, 0));
	}
		
	//king yellow  cap down right
	@Test
	public void capTest38() {
		assertTrue(JunitTester.canCaptureTest(yellowKingvsKingBoard, 2, 0));
	}
		
	//king yellow  cap up left
	@Test
	public void capTest39() {
		assertTrue(JunitTester.canCaptureTest(yellowKingvsKingBoard, 5, 7));
	}
		
	//king yellow  cap down left
	@Test
	public void capTest40() {
		assertTrue(JunitTester.canCaptureTest(yellowKingvsKingBoard, 3, 7));
	}
}
