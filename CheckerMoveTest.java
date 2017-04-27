package test;

import static org.junit.Assert.*;

import org.junit.Test;

import checkers.CheckerMove;

public class CheckerMoveTest 
{	
	@Test
	public void testGetIndex() 
	{
		// Test 1: x = -1, y = 50, result = {0, 0}
		int actualX1 = -1;
		int actualY1 = 50;
		int[] expectedIndex1 = {0, 0};
		
		// Test 2: x = 349, y = 225, result = {6, 4}
		int actualX2 = 349;
		int actualY2 = 225;
		int[] expectedIndex2 = {6, 4};
		
		// Test 3: x = 350, y = 401, result = {0, 0}
		int actualX3 = 350;
		int actualY3 = 401;
		int[] expectedIndex3 = {0, 0};
		
		assertArrayEquals("Index value: -1, 50", expectedIndex1, CheckerMove.getIndex(actualX1, actualY1));
		assertArrayEquals("Index value: 349, 225", expectedIndex2, CheckerMove.getIndex(actualX2, actualY2));
		assertArrayEquals("Index value: 350, 401", expectedIndex3, CheckerMove.getIndex(actualX3, actualY3));
	}

}
